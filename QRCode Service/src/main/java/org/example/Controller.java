package org.example;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;


@RestController
public class Controller {

    @GetMapping("/api/health")
    public String returnOK() {
        return "200 OK";
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<BufferedImage> returnIMAGE() {
        BufferedImage image = createImage(Color.BLUE);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
    }

    private static BufferedImage createImage(Color color) {
        BufferedImage image = new BufferedImage(750, 750, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.fillRect(250, 250, 250, 250);

        return image;
    }
}
