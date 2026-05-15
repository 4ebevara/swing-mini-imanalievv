package guess;

import javax.swing.*;
import java.awt.*;

public class GuessNumberGame extends JFrame {

    private JLabel titleLabel;
    private JLabel hintLabel;
    private JLabel attemptsLabel;
    private JTextField inputField;
    private JButton guessButton;
    private JButton resetButton;

    public GuessNumberGame() {
        setTitle("Угадай число");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        titleLabel = new JLabel("Я загадал число от 1 до 100. Попробуй угадать!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        hintLabel = new JLabel("Введите число и нажмите \"Угадать\"", SwingConstants.CENTER);
        hintLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        attemptsLabel = new JLabel("Попыток: 0", SwingConstants.CENTER);
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(inputField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        guessButton = new JButton("Угадать");
        resetButton = new JButton("Новая игра");

        guessButton.setFont(new Font("Arial", Font.BOLD, 13));
        resetButton.setFont(new Font("Arial", Font.PLAIN, 13));

        buttonPanel.add(guessButton);
        buttonPanel.add(resetButton);

        mainPanel.add(titleLabel);
        mainPanel.add(hintLabel);
        mainPanel.add(inputPanel);
        mainPanel.add(attemptsLabel);
        mainPanel.add(buttonPanel);

        add(mainPanel);
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
