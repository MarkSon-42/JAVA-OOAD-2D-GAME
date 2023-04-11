package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16 * 16 tile
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48 * 48 tile
    final int maxScreenCol = 16; // horizontal
    final int maxScreenRow = 12; // vertical .... ratio 4 : 3
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }
    @Override
    public void run() {
        while(gameThread != null) {


//            System.out.println("The game loop is running");

            // 1. UPDATE : update ..info such as character positions
            update();
            // 2. DRAW : draw the screen update information
            repaint();
        }
    }
    public void update() {

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();
    }

}
