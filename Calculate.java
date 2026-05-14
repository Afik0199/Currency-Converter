package converterrapp;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculate extends JFrame {

    private ImageIcon icon;
    private JLabel userLabel1, userLabel2;
    private Container c;                          //variable banaitesi jate shb jaygay use kora jay
    private JTextField tf1, tf2;
    private JButton convertButton, exitButton;
    private JComboBox<String> fromBox, toBox;

    Calculate() {               //constructor banaisi bhitore method call disi
        Components();
    }

    public void Components() {      //method

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);       //Text color change

        //First input
        userLabel1 = new JLabel("Enter Amount: ");
        userLabel1.setBounds(50, 25, 150, 50);
        userLabel1.setForeground(Color.WHITE);
        c.add(userLabel1);
        userLabel1.setHorizontalAlignment(JTextField.CENTER);  //Middle theke entry nitesi

        //Second input
        userLabel2 = new JLabel("Converted Amount: ");
        userLabel2.setBounds(50, 73, 150, 50);
        userLabel2.setForeground(Color.WHITE);
        c.add(userLabel2);
        userLabel2.setHorizontalAlignment(JTextField.CENTER);  //Middle theke entry nitesi

        // First input field
        tf1 = new JTextField();
        tf1.setBounds(200, 32, 200, 40);
        tf1.setBackground(Color.WHITE);
        tf1.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf1);

        // Second input field (Result)
        tf2 = new JTextField();
        tf2.setBounds(200, 80, 200, 40);
        tf2.setBackground(Color.WHITE);
        tf2.setEditable(false);
        tf2.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf2);

        // Currency Selection ComboBox
        fromBox = new JComboBox<>(new String[]{"USD", "BDT", "EUR"});
        fromBox.setBounds(420, 32, 80, 40);
        fromBox.setBackground(Color.CYAN);
        c.add(fromBox);

        toBox = new JComboBox<>(new String[]{"USD", "BDT", "EUR"});
        toBox.setBounds(420, 80, 80, 40);
        toBox.setBackground(Color.PINK);
        c.add(toBox);

        // Convert Button
        convertButton = new JButton("Convert");             //button add korsi
        convertButton.setBounds(117, 150, 150, 40);
        convertButton.setBackground(Color.WHITE);            //button er background color change
        convertButton.setForeground(Color.BLACK);            //button er foreground mainly text tuku color change
        c.add(convertButton);

        // ==== Thread ====
        convertButton.addActionListener((ActionEvent e) -> {
            new Thread(() -> {   // background thread
                try {
                    String amountText = tf1.getText().trim();
                    double amount = Double.parseDouble(amountText);

                    String from = fromBox.getSelectedItem().toString();
                    String to = toBox.getSelectedItem().toString();

                    double result = convertCurrency(amount, from, to);

                    // update GUI safely
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        tf2.setText(String.format("%.2f", result));
                    });

                } catch (NumberFormatException ex) {
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(this,
                                "Please enter a valid number.",
                                "Input Error",
                                JOptionPane.ERROR_MESSAGE);
                        tf1.setText(""); // clear input
                        tf2.setText(""); // clear output
                    });
                }
            }).start();
        });

        // Exit Button
        exitButton = new JButton("Exit");           //button add korsi
        exitButton.setBounds(278, 150, 150, 40);
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.BLACK);
        c.add(exitButton);

        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        icon = new ImageIcon(getClass().getResource("Converter.png"));
        this.setIconImage(icon.getImage());

    }

    // Currency Conversion Logic
    private double convertCurrency(double amount, String from, String to) {
        if (from.equals(to)) {
            return amount; // Same currency
        }
        switch (from) {
            case "USD":
                if (to.equals("BDT")) {
                    return amount * 110;
                }
                if (to.equals("EUR")) {
                    return amount * 0.92;
                }
                break;
            case "BDT":
                if (to.equals("USD")) {
                    return amount / 110;
                }
                if (to.equals("EUR")) {
                    return amount / 120;
                }
                break;
            case "EUR":
                if (to.equals("USD")) {
                    return amount / 0.92;
                }
                if (to.equals("BDT")) {
                    return amount * 120;
                }
                break;
        }
        return 0;
    }

    public static void main(String[] args) {
        Calculate frame = new Calculate();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(710, 415, 555, 250);
        frame.setTitle("Currency Converter");
    }
}
