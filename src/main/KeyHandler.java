package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean leftPressed, rightPressed, spacePressed; // Variáveis para armazenar os comandos

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode(); // obtem o código da tecla pressionada
        if (KeyCode == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (KeyCode == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (KeyCode == KeyEvent.VK_SPACE) {
            spacePressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int KeyCode = e.getKeyCode();
    
        if (KeyCode == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (KeyCode == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (KeyCode == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }
    }
}
