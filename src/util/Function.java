package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Function {

    public static BufferedImage loadImg(String str) {
        File imgFile = new File(str);
        BufferedImage img;
        try {
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
}
