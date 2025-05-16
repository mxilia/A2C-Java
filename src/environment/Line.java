package environment;

import java.awt.*;

public class Line {
    public Point start, end;
    public double slope, constant;
    public boolean infSlope = false;

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
        if(deltaX == 0){
            this.slope = 0;
            this.infSlope = true;
        }
        else {
            this.slope = deltaY/deltaX;
            this.infSlope = false;
        }
        this.constant = this.end.y-this.slope*this.end.x;
    }

    boolean checkBound(Point a) {
        double mnX = Math.min(start.x, end.x), mxX = Math.max(start.x, end.x);
        double mnY = Math.min(start.y, end.y), mxY = Math.max(start.y, end.y);
        return mnX <= a.x && a.x <= mxX && mnY <= a.y && a.y <= mxY;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine((int)start.x, (int)start.y, (int)end.x, (int)end.y);
    }
}
