package com.example.swingcalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
    private static final String ERROR_TEXT = "Ошибка";

    Calculator parent;
    char selectedAction = ' ';
    double currentResult = 0;
    double memory = 0;

    public CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String dispFieldText = parent.displayField.getText();
        Object src = e.getSource();
        double displayValue = parseDisplayValue(dispFieldText);

        if (src == parent.buttonClear) {
            resetCalculator();
        } else if (src == parent.buttonBack) {
            handleBackspace(dispFieldText);
        } else if (src == parent.buttonPlus) {
            selectedAction = '+';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMinus) {
            selectedAction = '-';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonDivide) {
            selectedAction = '/';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMultiply) {
            selectedAction = '*';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonEqual) {
            calculateResult(displayValue);
        } else if (src == parent.buttonMC) {
            memory = 0;
        } else if (src == parent.buttonMR) {
            parent.displayField.setText("" + memory);
        } else if (src == parent.buttonMS) {
            memory = displayValue;
        } else if (src == parent.buttonMPlus) {
            memory += displayValue;
        } else if (src == parent.buttonSquare) {
            if (isInvalidForUnaryOperation(dispFieldText)) {
                return;
            }
            double result = displayValue * displayValue;
            currentResult = result;
            parent.displayField.setText("" + result);
        } else if (src == parent.buttonSqrt) {
            if (isInvalidForUnaryOperation(dispFieldText)) {
                return;
            }
            if (displayValue < 0) {
                showError();
                return;
            }
            double result = Math.sqrt(displayValue);
            currentResult = result;
            parent.displayField.setText("" + result);
        } else {
            appendToDisplay(clickedButton.getText(), dispFieldText);
        }
    }

    private void calculateResult(double displayValue) {
        if (selectedAction == '+') {
            currentResult += displayValue;
            parent.displayField.setText("" + currentResult);
        } else if (selectedAction == '-') {
            currentResult -= displayValue;
            parent.displayField.setText("" + currentResult);
        } else if (selectedAction == '/') {
            if (displayValue == 0) {
                showError();
                return;
            }
            currentResult /= displayValue;
            parent.displayField.setText("" + currentResult);
        } else if (selectedAction == '*') {
            currentResult *= displayValue;
            parent.displayField.setText("" + currentResult);
        }
    }

    private void appendToDisplay(String clickedButtonLabel, String dispFieldText) {
        if (".".equals(clickedButtonLabel) && dispFieldText.contains(".")) {
            return;
        }

        if (ERROR_TEXT.equals(dispFieldText)) {
            if (".".equals(clickedButtonLabel)) {
                parent.displayField.setText("0.");
            } else {
                parent.displayField.setText(clickedButtonLabel);
            }
            return;
        }

        if (dispFieldText.isEmpty()) {
            if (".".equals(clickedButtonLabel)) {
                parent.displayField.setText("0.");
            } else {
                parent.displayField.setText(clickedButtonLabel);
            }
            return;
        }

        if ("0".equals(dispFieldText) && !".".equals(clickedButtonLabel)) {
            parent.displayField.setText(clickedButtonLabel);
        } else {
            parent.displayField.setText(dispFieldText + clickedButtonLabel);
        }
    }

    private void handleBackspace(String dispFieldText) {
        if (ERROR_TEXT.equals(dispFieldText) || dispFieldText.length() <= 1) {
            parent.displayField.setText("0");
            return;
        }

        parent.displayField.setText(dispFieldText.substring(0, dispFieldText.length() - 1));
    }

    private boolean isInvalidForUnaryOperation(String dispFieldText) {
        return dispFieldText.isEmpty() || ERROR_TEXT.equals(dispFieldText);
    }

    private double parseDisplayValue(String dispFieldText) {
        if (dispFieldText.isEmpty() || ERROR_TEXT.equals(dispFieldText)) {
            return 0;
        }

        try {
            return Double.parseDouble(dispFieldText);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private void resetCalculator() {
        parent.displayField.setText("0");
        currentResult = 0;
        selectedAction = ' ';
    }

    private void showError() {
        parent.displayField.setText(ERROR_TEXT);
        currentResult = 0;
        selectedAction = ' ';
    }
}
