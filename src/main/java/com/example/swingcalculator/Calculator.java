package com.example.swingcalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculator {
    // Объявление всех компонентов калькулятора.
    JPanel windowContent;
    JTextField displayField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPoint;
    JButton buttonEqual;
    JPanel p1;

    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonMultiply;
    JButton buttonDivide;
    JButton buttonClear;
    JButton buttonBack;
    JButton buttonSqrt;
    JButton buttonSquare;

    // Кнопки для памяти (p2)
    JButton buttonMC;
    JButton buttonMR;
    JButton buttonMS;
    JButton buttonMPlus;

    JPanel p2;

    // В конструкторе создаём все компоненты
    // и добавляем на фрейм с помощью комбинации Borderlayout и Gridlayout
    public Calculator() {
        windowContent = new JPanel();

        // Задаём схему для этой панели
        windowContent.setLayout(new BorderLayout());

        // Создаём и добавляем его в северную область окна
        displayField = new JTextField(30);
        displayField.setText("0");
        displayField.setFont(new Font("Arial", Font.BOLD, 16));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setBackground(new Color(220, 240, 255));
        displayField.setOpaque(true);
        windowContent.add("North", displayField);

        // Создаём кнопки, используя конструктор класса JButton,
        // который принимает текст кнопки в качестве параметра
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");

        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        buttonClear = new JButton("C");
        buttonBack = new JButton("←");
        buttonSqrt = new JButton("√");
        buttonSquare = new JButton("x²");

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        styleButton(button0, buttonFont);
        styleButton(button1, buttonFont);
        styleButton(button2, buttonFont);
        styleButton(button3, buttonFont);
        styleButton(button4, buttonFont);
        styleButton(button5, buttonFont);
        styleButton(button6, buttonFont);
        styleButton(button7, buttonFont);
        styleButton(button8, buttonFont);
        styleButton(button9, buttonFont);
        styleButton(buttonPoint, buttonFont);
        styleButton(buttonEqual, buttonFont);
        styleButton(buttonPlus, buttonFont);
        styleButton(buttonMinus, buttonFont);
        styleButton(buttonMultiply, buttonFont);
        styleButton(buttonDivide, buttonFont);
        styleButton(buttonClear, buttonFont);
        styleButton(buttonBack, buttonFont);
        styleButton(buttonSqrt, buttonFont);
        styleButton(buttonSquare, buttonFont);

        buttonPlus.setBackground(Color.LIGHT_GRAY);
        buttonMinus.setBackground(Color.LIGHT_GRAY);
        buttonMultiply.setBackground(Color.LIGHT_GRAY);
        buttonDivide.setBackground(Color.LIGHT_GRAY);
        buttonEqual.setBackground(Color.ORANGE);
        buttonPlus.setOpaque(true);
        buttonMinus.setOpaque(true);
        buttonMultiply.setOpaque(true);
        buttonDivide.setOpaque(true);
        buttonEqual.setOpaque(true);

        // Создаём кнопки для панели p2
        buttonMC = new JButton("MC");
        buttonMR = new JButton("MR");
        buttonMS = new JButton("MS");
        buttonMPlus = new JButton("M+");
        styleButton(buttonMC, buttonFont);
        styleButton(buttonMR, buttonFont);
        styleButton(buttonMS, buttonFont);
        styleButton(buttonMPlus, buttonFont);

        // Создаём панель с GridLayout, которая содержит кнопки калькулятора
        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 5));

        // Добавляем кнопки на панель p1
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(buttonDivide);
        p1.add(buttonClear);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(buttonMultiply);
        p1.add(buttonBack);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(buttonMinus);
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonEqual);
        p1.add(buttonPlus);
        p1.add(buttonSqrt);
        p1.add(buttonSquare);

        // Помещаем панель p1 в центральную область окна
        windowContent.add("Center", p1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 1));
        p2.add(buttonMC);
        p2.add(buttonMR);
        p2.add(buttonMS);
        p2.add(buttonMPlus);
        windowContent.add("West", p2);

        // Создаём фрейм и задаём его основную панель
        JFrame frame = new JFrame("Мой третий калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(windowContent);
        frame.setLocationRelativeTo(null);

        // Делаем размер окна таким, чтобы вместить все компоненты
        frame.pack();

        // Отображаем окно
        frame.setVisible(true);

        CalculatorEngine calcEngine = new CalculatorEngine(this);

        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);
        buttonPoint.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonDivide.addActionListener(calcEngine);
        buttonMultiply.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);
        buttonClear.addActionListener(calcEngine);
        buttonBack.addActionListener(calcEngine);
        buttonSqrt.addActionListener(calcEngine);
        buttonSquare.addActionListener(calcEngine);
        buttonMC.addActionListener(calcEngine);
        buttonMR.addActionListener(calcEngine);
        buttonMS.addActionListener(calcEngine);
        buttonMPlus.addActionListener(calcEngine);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }

    private void styleButton(JButton button, Font font) {
        button.setFont(font);
    }
}
