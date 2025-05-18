package main;

import environment.Line;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickRegister implements MouseListener {
    GamePanel gp;
    int cnt=0,x,y;

    public MouseClickRegister(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cnt++;
        cnt%=2;
        if(cnt==0) System.out.println("rewardLine.add(new Line("+x+", "+y+", "+e.getX()+", "+e.getY()+"));");
        else {
            x=e.getX();
            y=e.getY();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}