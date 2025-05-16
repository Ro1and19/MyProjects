package org.example;

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
    public ResponseEntity<?> returnIMAGE(@RequestParam int size, @RequestParam String type) {
        Map<String, String> response = new HashMap<>();

        if (size > 500 || size < 100) {
            response.put("error", "Image size must be between 100 and 500 pixels");
            return ResponseEntity.badRequest().body(response);
        }

        if (!type.matches("(png|jpeg|gif)")) {
            response.put("error", "Only png, jpeg and gif image types are supported");
            return ResponseEntity.badRequest().body(response);
        }

        BufferedImage image = createImage(size);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/"+type)).body(image);
    }

    private static BufferedImage createImage(int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, size, size);

        return image;
    }
}
