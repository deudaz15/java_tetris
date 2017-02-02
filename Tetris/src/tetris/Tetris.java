package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageProducer;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tetris implements KeyListener {

    private Canvas can;
    private Inventory inv;
    private Random randi = new Random();

    private int theta = 0;
    private int counter = 0;
    private int freePlace, filledPlace;

    private void go() {
        JFrame frame = new JFrame();
        frame.setTitle("Tetris");
        frame.setSize(600, 600);
        frame.addKeyListener(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inv = new Inventory();
        /*int c [] = {10, 10, 50, 50};
        inv.add(new Rect(c, Color.green));*/
        can = new Canvas();
        frame.getContentPane().add(can);
        freePlace = frame.getWidth()*frame.getHeight();
        //can.setSize(frame.getSize());
        can.setBackground(Color.black);
        
        
        
        frame.repaint();
can.repaint();
createRect(frame);
        
        
    }

    private void createRect(JFrame frame) {
        int w = frame.getWidth();
        int h = frame.getHeight();
        System.out.println("Height: " + h + " ; Width: " + w + "\n");
        
        int x = randi.nextInt() % w + w / 100 *2, y = h / 100;
        int zw = randi.nextInt() % freePlace + w / 100 * 2, zh = randi.nextInt() % h + h / 100 * 2;
        int coords[] = {x, y, zw, zh};
        filledPlace += zw * zh;
        Color c = Color.black;
        switch ((randi.nextInt() +1) % 4) { 
            case 0: c = Color.red;
                break;
            case 1: c = Color.blue;
                break;
            case 2: c = Color.white;
                break;
            case 3: c = Color.green;
                break;
            case 4: c = Color.yellow;
                break;
            default: JOptionPane.showMessageDialog(can, "Error", "Switching error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        Rect rect = new Rect(coords, c, counter);
        inv.add(rect);
        can.repaint();
        frame.repaint();
        counter++;
    }

    
    public static void main(String[] args) {
        Tetris game = new Tetris();
        game.go();
    }

    public class Canvas extends JPanel {

        private int h, w;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            h = getHeight() / 100; // jeweils 1% der Länge/Breite
            w = getWidth() / 100;
            freePlace = getHeight() * getWidth();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white); // Border-Color
            g2d.drawRect(w, h, getWidth() - 2 * w, getHeight() - 2 * h); // Border
            // g2d.setColor(Color.red);
            for (Rect rc : inv.getRects()) {
                g2d.setColor(rc.getClr());
                g2d.fillRect(rc.getRectCoords()[0],
                        rc.getRectCoords()[1],
                        rc.getRectCoords()[2],
                        rc.getRectCoords()[3]);
            }
            g2d.rotate(theta);// try - doesn't work

        }

    }

    @Override
    public void keyTyped(KeyEvent e) { // KeyCode immer 0 !!
        
    }

    @Override
    public void keyPressed(KeyEvent e) { // KeyCode entspricht dem jeweiligen Buchstaben als Kleinbuchstaben
        //System.out.println(e.getKeyCode());
if (e.getKeyCode() == 37) { // <-
            theta += 90;
            System.out.println("Theta: " + theta);
        }

        if (e.getKeyCode() == 39) { // ->
            theta -= 90;
            System.out.println("Theta: " + theta);
        }
        if (e.getKeyCode() == 40) { // speed downwards
            System.out.println(can.getHeight());
            //increase y-Coord with 10% of frame-height ; -1 because counter++ after every Rect
                inv.getRects().get(counter-1).getRectCoords()[1] += can.getHeight()/10; // works
            System.out.println("Y: " + inv.getRects().get(counter-1).getRectCoords()[1]);
        }
        this.can.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
