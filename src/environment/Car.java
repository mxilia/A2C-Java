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
    Line leftHitLine, rightHitLine, topHitLine, bottomHitLine;
    Line forwardLine, forwardRightLine, rightLine, backRightLine, backLine, backLeftLine, leftLine, forwardLeftLine;
    double verticalLength = 100.0+height/2.0, horizontalLength = 100.0+width/2.0;

    int[] quadrant = {90, 180, 270, 360};
    double quarterRad = Math.PI/4, rightRad = Math.PI/2;

    BufferedImage img;
    KeyRegister kr;

    public Car(KeyRegister kr) {
        this.kr = kr;
        this.img = loadImg("res/car.png");
        createLine();
        updateLine();
    }

    private void createLine() {
        leftHitLine = new Line(x, y, x, y+height);
        rightHitLine = new Line(x+width, y, x+width, y+height);
        topHitLine = new Line(x, y, x+width, y);
        bottomHitLine = new Line(x, y+height, x+width, y+height);
        double centerX = x+width/2.0, centerY = y+height/2.0;
        forwardLine = new Line(centerX, centerY, centerX, centerY-verticalLength);
        forwardRightLine = new Line(centerX, centerY, centerX+verticalLength*Math.sin(quarterRad), centerY-verticalLength*Math.cos(quarterRad));
        rightLine = new Line(centerX, centerY, centerX+horizontalLength, centerY);
        backRightLine = new Line(centerX, centerY, centerX+verticalLength*Math.sin(rightRad+quarterRad), centerY-verticalLength*Math.cos(rightRad+quarterRad));
        backLine = new Line(centerX, centerY, centerX, centerY+verticalLength);
        backLeftLine = new Line(centerX, centerY, centerX+verticalLength*Math.sin(2*rightRad+quarterRad), centerY-verticalLength*Math.cos(2*rightRad+quarterRad));
        leftLine = new Line(centerX, centerY, centerX-horizontalLength, centerY);
        forwardLeftLine = new Line(centerX, centerY, centerX+verticalLength*Math.sin(3*rightRad+quarterRad), centerY-verticalLength*Math.cos(3*rightRad+quarterRad));
    }

    private void updateLine() {
        int currentQuadrant=0;
        for(int i=0;i<4;i++) if(angle<=quadrant[i]) currentQuadrant=i;
        double centerX = x+width/2.0, centerY = y+height/2.0;
        double radians = Math.toRadians(angle);
        double theta = Math.atan(width/height);
        double alpha = radians-theta;
        double beta = Math.toRadians(quadrant[currentQuadrant])-(Math.toRadians(quadrant[currentQuadrant])-radians-theta);
        double hypotenuse = Math.hypot(width/2, height/2);
        double leftTopX = centerX+hypotenuse*Math.sin(alpha), leftTopY = centerY-hypotenuse*Math.cos(alpha);
        double rightTopX = centerX+hypotenuse*Math.sin(beta), rightTopY = centerY-hypotenuse*Math.cos(beta);
        double leftBottomX = centerX+hypotenuse*Math.sin(beta+2*rightRad), leftBottomY = centerY-hypotenuse*Math.cos(beta+2*rightRad);
        double rightBottomX = centerX+hypotenuse*Math.sin(alpha+2*rightRad), rightBottomY = centerY-hypotenuse*Math.cos(alpha+2*rightRad);
        leftHitLine.update(leftTopX, leftTopY, leftBottomX, leftBottomY);
        rightHitLine.update(rightTopX, rightTopY, rightBottomX, rightBottomY);
        topHitLine.update(leftTopX, leftTopY, rightTopX, rightTopY);
        bottomHitLine.update(leftBottomX, leftBottomY, rightBottomX, rightBottomY);
        double forwardX = centerX+verticalLength*Math.sin(radians), forwardY = centerY-verticalLength*Math.cos(radians);
        double forwardRightX = centerX+verticalLength*Math.sin(quarterRad+radians), forwardRightY = centerY-verticalLength*Math.cos(quarterRad+radians);
        double rightX = centerX+horizontalLength*Math.sin(radians+rightRad), rightY = centerY-horizontalLength*Math.cos(radians+rightRad);
        double backRightX = centerX+verticalLength*Math.sin(rightRad+quarterRad+radians), backRightY = centerY-verticalLength*Math.cos(rightRad+quarterRad+radians);
        double backX = centerX+verticalLength*Math.sin(radians+2*rightRad), backY = centerY-verticalLength*Math.cos(radians+2*rightRad);
        double backLeftX = centerX+verticalLength*Math.sin(2*rightRad+quarterRad+radians), backLeftY = centerY-verticalLength*Math.cos(2*rightRad+quarterRad+radians);
        double leftX = centerX+horizontalLength*Math.sin(radians+3*rightRad), leftY = centerY-horizontalLength*Math.cos(radians+3*rightRad);
        double forwardLeftX = centerX+verticalLength*Math.sin(3*rightRad+quarterRad+radians), forwardLeftY = centerY-verticalLength*Math.cos(3*rightRad+quarterRad+radians);
        forwardLine.update(centerX, centerY, forwardX, forwardY);
        forwardRightLine.update(centerX, centerY, forwardRightX, forwardRightY);
        rightLine.update(centerX, centerY, rightX, rightY);
        backRightLine.update(centerX, centerY, backRightX, backRightY);
        backLine.update(centerX, centerY, backX, backY);
        backLeftLine.update(centerX, centerY, backLeftX, backLeftY);
        leftLine.update(centerX, centerY, leftX, leftY);
        forwardLeftLine.update(centerX, centerY, forwardLeftX, forwardLeftY);
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
        updateLine();
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
        forwardLine.draw(g2); rightLine.draw(g2); backLine.draw(g2); leftLine.draw(g2); forwardLeftLine.draw(g2); forwardRightLine.draw(g2); backLeftLine.draw(g2); backRightLine.draw(g2);
    }
}
