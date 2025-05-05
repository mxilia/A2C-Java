package main;

import environment.Environment;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public final int width = 1000;
    public final int height = 750;
    public final int FPS = 60;

    Thread gameThread;
    KeyRegister kr = new KeyRegister();
    Environment env = new Environment(kr);

    public GamePanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(kr);
        this.setFocusable(true);
    }

    public void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/(double)FPS;
        double startTime = System.nanoTime();
        double previousTime, currentTime;
        previousTime = startTime;
        while(gameThread != null){
            currentTime = System.nanoTime();
            if(currentTime-previousTime>=drawInterval){
                update();
                repaint();
                previousTime = currentTime;
            }
        }
    }

    public void update() {
        env.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        env.draw(g2);
        g2.dispose();
    }

}
