import operations.AddOperation;
import operations.DivideOperation;
import operations.MultiplyOperation;
import operations.SubtractOperation;

import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {

    private final Calculator calculator = new Calculator();
    private JTextField display;

    public CalculatorUI() {
        setTitle("OOP Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initUI();
        setVisible(true);
    }

    private void initUI() {
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        addButton(panel, "7");
        addButton(panel, "8");
        addButton(panel, "9");
        addOperationButton(panel, "+");

        addButton(panel, "4");
        addButton(panel, "5");
        addButton(panel, "6");
        addOperationButton(panel, "-");

        addButton(panel, "1");
        addButton(panel, "2");
        addButton(panel, "3");
        addOperationButton(panel, "*");

        addButton(panel, "0");
        addButton(panel, ".");
        addEqualButton(panel);
        addOperationButton(panel, "/");

        addClearButton(panel);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(JPanel panel, String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.addActionListener(e -> display.setText(display.getText() + text));
        panel.add(button);
    }

    private void addOperationButton(JPanel panel, String op) {
        JButton button = new JButton(op);
        button.setFont(new Font("Arial", Font.BOLD, 20));

        button.addActionListener(e -> {
            try {
                double value = Double.parseDouble(display.getText());
                calculator.setFirstNumber(value);

                switch (op) {
                    case "+" -> calculator.setOperation(new AddOperation());
                    case "-" -> calculator.setOperation(new SubtractOperation());
                    case "*" -> calculator.setOperation(new MultiplyOperation());
                    case "/" -> calculator.setOperation(new DivideOperation());
                }

                display.setText("");

            } catch (Exception ex) {
                display.setText("Error");
            }
        });

        panel.add(button);
    }

    private void addEqualButton(JPanel panel) {
        JButton button = new JButton("=");
        button.setFont(new Font("Arial", Font.BOLD, 20));

        button.addActionListener(e -> {
            try {
                double value = Double.parseDouble(display.getText());
                double result = calculator.calculate(value);
                display.setText(String.valueOf(result));
            } catch (Exception ex) {
                display.setText("Error");
            }
        });

        panel.add(button);
    }

    private void addClearButton(JPanel panel) {
        JButton button = new JButton("C");
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.addActionListener(e -> {
            calculator.clear();
            display.setText("");
        });
        panel.add(button);
    }
}
