package environment;

import main.KeyRegister;

import java.awt.*;

public class Environment {
    KeyRegister kr;
    Car plr;

    public Environment(KeyRegister kr) {
        this.kr = kr;
        this.plr = new Car(kr);
    }

    public void update() {
        plr.update();
    }

    public void draw(Graphics2D g2) {
        plr.draw(g2);
    }
}
