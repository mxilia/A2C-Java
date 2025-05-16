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
        double newX,newY;
        if(a.infSlope){
            newX = a.end.x;
            newY = b.slope*a.end.x+b.constant;
        }
        else if(b.infSlope){
            newX = b.end.x;
            newY = a.slope*b.end.x+a.constant;
        }
        else {
            newX = (b.constant-a.constant)/(a.slope-b.slope);
            newY = a.slope*newX+a.constant;
        }
        return new Point(newX, newY);
    }
}
