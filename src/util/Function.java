package util;

import environment.Line;
import environment.Point;

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

    public static Point findIntersect(Line a, Line b) {
        if(a.slope == b.slope) return null;
        double divisor = -b.slope+a.slope;
        double newX = (-b.constant+a.constant)/divisor;
        double newY = (-a.constant+b.constant)/divisor;
        return new Point(newX, newY);
    }
}
