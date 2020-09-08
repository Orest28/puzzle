package com.devcom.puzzle.services.imp;


import com.devcom.puzzle.exceptions.exceptions.StorageException;
import com.devcom.puzzle.services.PuzzleService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class PuzzleServiceImpl implements PuzzleService {

    public void uploadAndBreakImage(MultipartFile file) {
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());

            image = resize(image, 500, 500);

            Path pathToBrokenImages = Paths.get("uploads/" + Objects.requireNonNull(file.getOriginalFilename()).substring(0,file.getOriginalFilename().length() - 4) + "Parts");

            Files.createDirectory(pathToBrokenImages);

            for(int x = 0, index = 0; x <= image.getWidth() - 100; x += 100) {
                for(int y = 0; y <= image.getHeight() - 100; y += 100) {
                    ImageIO.write(image.getSubimage(x,y,100, 100), "png", new File(pathToBrokenImages + "/brokenImage" + index++ + ".png"));
                }
            }
//ImageIO.write(image.getSubimage(0, y, 50,50), "png", new File(pathToBrokenImages + "/brokenImage" + index + ".png"));

        } catch (IOException ex) {
            throw new StorageException(ex.getMessage());
        }
    }

    public static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}

