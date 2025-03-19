package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    
    public GameWindow() {
        // Configurações básicas da janela do jogo
        setTitle("Meu Jogo 2D");
        setSize(800, 600); // Largura x Altura
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Centraliza a janela na tela        
        add(new GamePanel()); //Adiciona painel do jogo
        setVisible(true);

    }
}
