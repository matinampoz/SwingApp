package gr.aueb.elearn;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
    private JTextField display;
    private StringBuilder currentInput;
    private double lastValue;
    private char lastOperator;

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        currentInput = new StringBuilder();
        lastValue = 0;
        lastOperator = ' ';

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new CalculatorButtonListener());
            buttonPanel.add(button);
        }

        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private class CalculatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".indexOf(command) >= 0) {
                currentInput.append(command);
                display.setText(currentInput.toString());
            } else if ("/+-*".indexOf(command) >= 0) {
                performOperation();
                lastOperator = command.charAt(0);
            } else if ("=".equals(command)) {
                performOperation();
                lastOperator = ' ';
            }
        }

        private void performOperation() {
            double currentValue = currentInput.length() > 0 ? Double.parseDouble(currentInput.toString()) : 0;
            switch (lastOperator) {
                case '+': lastValue += currentValue; break;
                case '-': lastValue -= currentValue; break;
                case '*': lastValue *= currentValue; break;
                case '/': lastValue /= currentValue; break;
                default: lastValue = currentValue; break;
            }
            display.setText(String.valueOf(lastValue));
            currentInput.setLength(0);
        }
    }
}

