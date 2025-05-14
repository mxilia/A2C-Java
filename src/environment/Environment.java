package environment;

import main.KeyRegister;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static util.Function.findIntersect;
import static util.Function.loadImg;

public class Environment {
    KeyRegister kr;
    BufferedImage bg;

    Car plr;
    public ArrayList<Line> lineBorder = new ArrayList<>();

    public Environment(KeyRegister kr) {
        this.kr = kr;
        this.plr = new Car(kr);
        this.bg = loadImg("res/race.png");
        setBorder();
    }

    private void setBorder() {
        lineBorder.add(new Line(55, 106, 52, 248));
    }

    private boolean collideBorder() {
        // Fix intersect function
        for(Line line:lineBorder){
            Point intersectLeft = findIntersect(line, plr.leftLine);
            Point intersectRight = findIntersect(line, plr.rightLine);
            Point intersectTop = findIntersect(line, plr.topLine);
            Point intersectBottom = findIntersect(line, plr.bottomLine);
            if(intersectLeft!=null) System.out.println(intersectLeft.x + " "  + intersectLeft.y);
            else System.out.println("null");
            if(intersectLeft!=null && line.checkBound(intersectLeft) && plr.leftLine.checkBound(intersectLeft)) return true;
            if(intersectRight!=null && line.checkBound(intersectRight) && plr.rightLine.checkBound(intersectRight)) return true;
            if(intersectTop!=null && line.checkBound(intersectTop) && plr.topLine.checkBound(intersectTop)) return true;
            if(intersectBottom!=null && line.checkBound(intersectBottom) && plr.bottomLine.checkBound(intersectBottom)) return true;
        }
        return false;
    }

    public void update() {
        plr.update();
        if(collideBorder()) {
            plr.reset();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bg, 0, 0, bg.getWidth(), bg.getHeight(), null);
        for(Line line:lineBorder) line.draw(g2);
        plr.draw(g2);
    }
}
