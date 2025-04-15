package environment;

import main.KeyRegister;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Car {
    double x = 0, y = 0;
    double width = 20, height = 35;
    double speed = 0, angle = 0;
    double acceleration = 0.31, friction = 0.05, omega = 4;
    KeyRegister kr;

    public Car(KeyRegister kr) {
        this.kr = kr;
    }

    public void update() {
        if(kr.keyDown['W']) speed-=acceleration;
        if(kr.keyDown['A']) angle=((angle-omega)%360+360)%360;
        if(kr.keyDown['S']) speed+=acceleration;
        if(kr.keyDown['D']) angle=((angle+omega)%360+360)%360;
        if(speed>0) speed-=friction;
        else if(speed<0) speed+=friction;
        double radians = Math.toRadians(angle);
        x-=speed*Math.sin(radians);
        y+=speed*Math.cos(radians);
    }

    public void draw(Graphics2D g2) {
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
        double centerX = x+width/2.0, centerY = y+height/2.0;
        double radians = Math.toRadians(angle);
        AffineTransform rotateTransform = AffineTransform.getRotateInstance(radians, centerX, centerY);
        Shape rotatedRect = rotateTransform.createTransformedShape(rect);
        g2.setColor(Color.RED);
        g2.fill(rotatedRect);
    }
}
