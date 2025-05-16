package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;


@RestController
public class Controller {
    @GetMapping("/api/health")
    public String returnOK() {
        return "200 OK";
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<?> returnIMAGE(@RequestParam int size,
                                         @RequestParam String type,
                                         @RequestParam String contents) {
        Map<String, String> response = new HashMap<>();

        if (contents == null || contents.isEmpty()) {
            response.put("error", "Contents cannot be null or blank");
            return ResponseEntity.badRequest().body(response);
        }

        if (size > 500 || size < 100) {
            response.put("error", "Image size must be between 100 and 500 pixels");
            return ResponseEntity.badRequest().body(response);
        }

        if (!type.matches("(png|jpeg|gif)")) {
            response.put("error", "Only png, jpeg and gif image types are supported");
            return ResponseEntity.badRequest().body(response);
        }

        BufferedImage image = createImage(size, contents);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/"+type)).body(image);
    }

    private static BufferedImage createImage(int size, String contents) {

        BufferedImage image = null;
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, size, size);
            image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return image;
    }
}
