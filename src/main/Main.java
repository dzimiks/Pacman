package main;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import pacman.PacmanGame;
import pacman.view.Display;
import pacman.view.Game;

/**
 * @author dzimiks
 */
public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	
                Game game = new PacmanGame();
                Display view = new Display(game);
                JFrame frame = new JFrame();
            	URL iconURL = getClass().getResource("/res/pacman_0_1.png");
            	ImageIcon icon = new ImageIcon(iconURL);

            	frame.setIconImage(icon.getImage());
                frame.setTitle("Pacman 2018");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(view);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
                view.requestFocus();
                view.start();
            }
        });
	}
}