package guess;

import javax.swing.*;
import java.awt.*;

public class GuessNumberGame extends JFrame {

    public GuessNumberGame() {
        setTitle("Угадай число");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessNumberGame();
            }
        });
    }
}
