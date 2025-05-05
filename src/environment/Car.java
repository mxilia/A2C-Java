package environment;

import main.KeyRegister;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import static util.Function.loadImg;

public class Car {
    double x = 90, y = 180;
    double width = 20, height = 35;
    double acceleration = 0.7, friction = 0.1, omega = 4;
    double maxSpeed = 14, speed = 0, angle = 0;

    BufferedImage img;
    KeyRegister kr;

    public Car(KeyRegister kr) {
        this.kr = kr;
        this.img = loadImg("res/car.png");
    }

    public void update() {
        if(kr.keyDown['W']) speed-=acceleration;
        if(kr.keyDown['A'] && speed!=0) angle=((angle-omega)%360+360)%360;
        if(kr.keyDown['S']) speed+=acceleration;
        if(kr.keyDown['D'] && speed!=0) angle=((angle+omega)%360+360)%360;
        if(speed>0){
            speed-=friction;
            speed = Math.min(speed, maxSpeed);
        }
        else if(speed<0){
            speed+=friction;
            speed = Math.max(speed, -maxSpeed);
        }
        speed = Math.round(speed*10)/10.0;
        double radians = Math.toRadians(angle);
        x-=speed*Math.sin(radians);
        y+=speed*Math.cos(radians);
    }

    public void draw(Graphics2D g2) {
        double centerX = x+width/2.0, centerY = y+height/2.0;
        double radians = Math.toRadians(angle);
        AffineTransform rotateTransform = AffineTransform.getRotateInstance(radians, centerX, centerY);
        rotateTransform.translate(x, y);
        g2.drawImage(img, rotateTransform, null);
    }
}
