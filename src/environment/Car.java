package environment;

import main.KeyRegister;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import static util.Function.loadImg;

public class Car {
    double ox = 90, oy = 180;
    double x = ox, y = oy;
    double width = 20, height = 35;
    double acceleration = 0.5, friction = 0.1, omega = 6;
    double maxSpeed = 14, speed = 0, angle = 0;
    Line leftLine, rightLine, topLine, bottomLine;

    BufferedImage img;
    KeyRegister kr;

    public Car(KeyRegister kr) {
        this.kr = kr;
        this.img = loadImg("res/car.png");
        createLine();
    }

    private void createLine() {
        leftLine = new Line((int)x, (int)y, (int)x, (int)(y+height));
        rightLine = new Line((int)(x+width), (int)y, (int)(x+width), (int)(y+height));
        topLine = new Line((int)x, (int)y, (int)(x+width), (int)y);
        bottomLine = new Line((int)x, (int)(y+height), (int)(x+width), (int)(y+height));
    }

    private void updateLine() {
        double centerX = x+width/2.0, centerY = y+height/2.0;
        double radians = Math.toRadians(angle), rightRad = Math.PI/2;

        leftLine.update((int)x, (int)y, (int)x, (int)(y+height));
        rightLine.update((int)(x+width), (int)y, (int)(x+width), (int)(y+height));
        topLine.update((int)x, (int)y, (int)(x+width), (int)y);
        bottomLine.update((int)x, (int)(y+height), (int)(x+width), (int)(y+height));
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

    public void reset() {
        x = ox;
        y = oy;
        angle = 0;
        speed = 0;
    }

    public void draw(Graphics2D g2) {
        double centerX = x+width/2.0, centerY = y+height/2.0;
        double radians = Math.toRadians(angle);
        AffineTransform rotateTransform = AffineTransform.getRotateInstance(radians, centerX, centerY);
        rotateTransform.translate(x, y);
        g2.drawImage(img, rotateTransform, null);
        updateLine();
        leftLine.draw(g2);
        rightLine.draw(g2);
        topLine.draw(g2);
        bottomLine.draw(g2);
    }
}
