package main;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;
    private KeyHandler keyHandler;

    private int playerX = 100, playerY = 300; // Posição inicial do quadrado
    private int velocityY = 0; // Velocidade vertical do jogador
    private final int gravity = 1; // Gravidade que puxa o jogador para baixo
    private final int jumpStrength = -15; // Força do pulo (negativo porque sobe)
    private final int groundY = 500; // Posição do chão (altura máxima que o jogador pode ficar)
    private final int playerSize = 50;
    private int speed = 5;

    
    public GamePanel() {
        keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true); // Permite que o painel receba entrada do teclado
        setBackground(Color.BLACK);

        startGame();
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (true) {
            update();
            repaint();

            try {
                Thread.sleep(16); // Controla a taxa de atualização (~60 FPS)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (keyHandler.leftPressed) {
            playerX -= speed;
        }
        if (keyHandler.rightPressed) {
            playerX += speed;
        }
        //PULO
        if(keyHandler.spacePressed && playerY == groundY){
            velocityY = jumpStrength;
        }
        //Aplicar gravidade 
        playerY += velocityY;
        velocityY += gravity;

        if (playerY >   groundY) {
        playerY = groundY;
        velocityY = 0;

        }
    
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(playerX, playerY, playerSize, playerSize);
    }
}
