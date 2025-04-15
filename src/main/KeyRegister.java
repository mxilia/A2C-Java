package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyRegister implements KeyListener {
    public boolean[] keyDown = new boolean[256];

    @Override
    public void keyTyped(KeyEvent event){
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyDown[keyCode] = true;
    }

    @Override
    public void keyReleased(KeyEvent event){
        int keyCode = event.getKeyCode();
        keyDown[keyCode] = false;
    }
}