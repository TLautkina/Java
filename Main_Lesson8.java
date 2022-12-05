package ru.geekbrains.courses.java.LautkinaT.Lesson8;
/*
Дописать калькулятор так, чтобы можно было вычислять примеры.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main_Lesson8 extends JFrame implements ActionListener {


    private JButton[] NumberBtn;
    private JButton[] functionBtn;
    private JTextField inputField;


    private double number;
    private double result = 0;
    private double temp = 0;
    private char operator = ' ';
    private int x = 0;

    public Main_Lesson8() {
        initialize();
    }

    public static void main(String[] args) {
        new Main_Lesson8();
    }

    private void initialize() {
        this.setTitle("Calculator v.1.0");
        this.setSize(new Dimension(300, 420));
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        inputField = new JTextField();
        inputField.setSize(new Dimension(250, 40));
        inputField.setLocation(new Point(20, 20));
        inputField.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        inputField.setEditable(false);
        inputField.setBackground(new Color(170, 215, 167));
        inputField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.setSize(new Dimension(250, 250));
        panel.setBackground(Color.darkGray);
        panel.setLocation(new Point(20, 70));

        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("x");
        JButton divide = new JButton("/");
        JButton equal = new JButton("=");
        JButton decimal = new JButton(".");

        JButton clear = new JButton("CE");
        clear.setLocation(new Point(20, 330));

        JButton delete = new JButton("CLR");
        delete.setLocation(new Point(170, 330));

        functionBtn = new JButton[8];

        functionBtn[0] = plus;
        functionBtn[1] = minus;
        functionBtn[2] = multiply;
        functionBtn[3] = divide;
        functionBtn[4] = equal;
        functionBtn[5] = delete;
        functionBtn[6] = clear;
        functionBtn[7] = decimal;

        for (int i = 0; i < 8; i++) {
            functionBtn[i].setFocusable(false);
            functionBtn[i].setVerticalTextPosition(JButton.CENTER);
            functionBtn[i].setHorizontalTextPosition(JButton.CENTER);
            functionBtn[i].setFont(new Font("TimesRoman", Font.PLAIN, 20));
            functionBtn[i].setBackground(new Color(148, 208, 204));
            functionBtn[i].setSize(new Dimension(100, 30));
            functionBtn[i].addActionListener(this);
            functionBtn[i].setForeground(Color.black);
        }

        NumberBtn = new JButton[10];

        for (int i = 0; i < 10; i++) {
            NumberBtn[i] = new JButton(String.valueOf(i));
            NumberBtn[i].setFocusable(false);
            NumberBtn[i].setFont(new Font("TimesRoman", Font.PLAIN, 20));
            NumberBtn[i].setSize(new Dimension(10, 10));
            NumberBtn[i].setBackground(new Color(236, 204, 204));
            NumberBtn[i].setVerticalTextPosition(JButton.CENTER);
            NumberBtn[i].setHorizontalTextPosition(JButton.CENTER);
            NumberBtn[i].addActionListener(this);
            NumberBtn[i].setForeground(Color.black);
        }

        panel.add(NumberBtn[7]);
        panel.add(NumberBtn[8]);
        panel.add(NumberBtn[9]);

        panel.add(functionBtn[0]);

        panel.add(NumberBtn[4]);
        panel.add(NumberBtn[5]);
        panel.add(NumberBtn[6]);
        panel.add(functionBtn[1]);

        panel.add(NumberBtn[1]);
        panel.add(NumberBtn[2]);
        panel.add(NumberBtn[3]);

        panel.add(functionBtn[2]);

        panel.add(functionBtn[7]);
        panel.add(NumberBtn[0]);
        panel.add(functionBtn[4]);
        panel.add(functionBtn[3]);

        this.add(functionBtn[6]);
        this.add(functionBtn[5]);
        this.add(inputField);
        this.add(panel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void operation(double curr) {
        switch (operator) {
            case '+':
                result = number + curr;
                break;

            case '-':
                result = number - curr;
                break;

            case '*':
                result = number * curr;
                break;

            case '/':
                result = number / curr;
                break;
        }

        inputField.setText(String.valueOf(result));
        temp = result;
        x = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double current;
        if (e.getSource() == functionBtn[0]) {
            //сложение
            if (!inputField.getText().isEmpty()) {
                current = Double.parseDouble(inputField.getText());
                if (operator != ' ' && operator != '+') {
                    operation(current);
                    operator = ' ';
                }

                current = Double.parseDouble(inputField.getText());

                if (x == 0) {
                    temp = current;
                    number = temp;
                    operator = '+';
                } else {
                    number = temp;
                    result = number + current;
                    inputField.setText(String.valueOf(result));
                    temp = result;
                }
                x = 1;
            }
        }

        if (e.getSource() == functionBtn[1]) {
            //вычитание
            if (!inputField.getText().isEmpty()) {
                current = Double.parseDouble(inputField.getText());
                if (operator != ' ' && operator != '-') {
                    operation(current);
                    operator = ' ';
                }

                current = Double.parseDouble(inputField.getText());

                if (x == 0) {
                    temp = current;
                    number = temp;
                    operator = '-';

                } else {
                    number = temp;
                    result = number - current;
                    inputField.setText(String.valueOf(result));
                    temp = result;
                }
                x = 1;
            }
        }


        if (e.getSource() == functionBtn[2]) {
            //умножение
            if (!inputField.getText().isEmpty()) {
                current = Double.parseDouble(inputField.getText());
                if (operator != ' ' && operator != '*') {
                    operation(current);
                    operator = ' ';
                }

                current = Double.parseDouble(inputField.getText());

                if (x == 0) {
                    temp = current;
                    number = temp;
                    operator = '*';
                } else {
                    number = temp;
                    result = number * current;
                    inputField.setText(String.valueOf(result));
                    temp = result;
                }
                x = 1;
            }
        }


        if (e.getSource() == functionBtn[3]) {
            //деление
            if (!inputField.getText().isEmpty()) {
                current = Double.parseDouble(inputField.getText());
                if (operator != ' ' && operator != '/') {
                    operation(current);
                    operator = ' ';
                }

                current = Double.parseDouble(inputField.getText());

                if (x == 0) {
                    temp = current;
                    number = temp;
                    operator = '/';
                } else {
                    number = temp;
                    result = number / current;
                    inputField.setText(String.valueOf(result));
                    temp = result;
                }
                x = 1;
            }
        }


        if (e.getSource() == functionBtn[4]) {
            // равно
            if (!inputField.getText().isEmpty()) {
                current = Double.parseDouble(inputField.getText());
                operation(current);
                operator = ' ';
            }
        }


        if (e.getSource() == functionBtn[5]) {
            // удалить
            inputField.setText("");
        }


        if (e.getSource() == functionBtn[6]) {
            // очистить
            result = 0;
            x = 0;
            temp = 0;
            number = 0;
            operator = ' ';
            inputField.setText("");
        }


        if (e.getSource() == functionBtn[7]) {
            // дробное значение

            if (x == 1) {
                inputField.setText("");


                if (!inputField.getText().contains(".")) {
                    inputField.setText(inputField.getText().concat("."));
                }

                x = 0;
            } else {
                if (!inputField.getText().contains(".")) {
                    inputField.setText(inputField.getText().concat("."));
                }
            }

        }


        for (int i = 0; i < 10; i++) {
            // числовые кнопки
            if (e.getSource() == NumberBtn[i]) {
                if (x == 1) {
                    inputField.setText("");
                    inputField.setText(inputField.getText().concat(String.valueOf(i)));
                    x = 2;
                } else {
                    inputField.setText(inputField.getText().concat(String.valueOf(i)));
                }
            }
        }
    }

}

