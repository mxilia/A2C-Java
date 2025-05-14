package environment;

import java.awt.*;

public class Line {
    public Point start, end;
    public double slope, constant;

    public Line(int x1, int y1, int x2, int y2) {
        update(x1, y1, x2, y2);
    }

    public void update(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        setEquation();
    }

    private void setEquation() {
        double deltaX = this.end.x-this.start.x;
        double deltaY = this.end.y-this.start.y;
        this.slope = deltaY/deltaX;
        this.constant = this.end.y-this.slope*this.end.x;
    }

    boolean checkBound(Point a) {
        double mn = Math.min(start.x, end.x), mx = Math.max(start.x, end.x);
        return mn <= a.x && a.x <= mx;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine((int)start.x, (int)start.y, (int)end.x, (int)end.y);
    }
}
