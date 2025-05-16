package environment;

import java.awt.*;

public class Point {
    public double x,y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillOval((int)x, (int)y, 7, 7);
    }
}
