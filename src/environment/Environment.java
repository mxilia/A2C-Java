package environment;

import main.KeyRegister;

import java.awt.*;
import java.awt.image.BufferedImage;

import static util.Function.loadImg;

public class Environment {
    KeyRegister kr;
    BufferedImage bg;
    Car plr;

    public Environment(KeyRegister kr) {
        this.kr = kr;
        this.plr = new Car(kr);
        this.bg = loadImg("res/race.png");
    }

    public void update() {
        plr.update();
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bg, 0, 0, bg.getWidth(), bg.getHeight(), null);
        plr.draw(g2);
    }
}
