package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickRegister implements MouseListener {
    GamePanel gp;
    int clickX, clickY;

    public MouseClickRegister(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + "  " + e.getY());
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