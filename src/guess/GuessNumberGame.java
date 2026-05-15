package guess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessNumberGame extends JFrame {

    private int secretNumber;
    private int attempts;

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
        resetGame();

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

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }

    private void checkGuess() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) {
            hintLabel.setText("Введите число!");
            return;
        }

        int guess;
        try {
            guess = Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            hintLabel.setText("Введите корректное число!");
            inputField.setText("");
            return;
        }

        if (guess < 1 || guess > 100) {
            hintLabel.setText("Число должно быть от 1 до 100!");
            inputField.setText("");
            return;
        }

        attempts++;
        attemptsLabel.setText("Попыток: " + attempts);

        if (guess < secretNumber) {
            hintLabel.setText("Моё число БОЛЬШЕ! Попробуй ещё.");
            hintLabel.setForeground(new Color(0, 100, 200));
        } else if (guess > secretNumber) {
            hintLabel.setText("Моё число МЕНЬШЕ! Попробуй ещё.");
            hintLabel.setForeground(new Color(200, 100, 0));
        } else {
            hintLabel.setText("Поздравляю! Ты угадал число " + secretNumber + "!");
            hintLabel.setForeground(new Color(0, 150, 0));
            guessButton.setEnabled(false);
            inputField.setEnabled(false);
        }

        inputField.setText("");
        inputField.requestFocus();
    }

    private void resetGame() {
        secretNumber = new Random().nextInt(100) + 1;
        attempts = 0;
        hintLabel.setText("Введите число и нажмите \"Угадать\"");
        hintLabel.setForeground(Color.BLACK);
        attemptsLabel.setText("Попыток: 0");
        inputField.setText("");
        inputField.setEnabled(true);
        guessButton.setEnabled(true);
        inputField.requestFocus();
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
