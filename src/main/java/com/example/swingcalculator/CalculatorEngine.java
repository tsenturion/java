package com.example.swingcalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {

    // Урок 11. Задание 2. Создать в CalculatorEngine ссылку на класс Calculator. Внесенный код, часть 1, начало
    Calculator parent; // ссылка на Calculator

    // Конструктор сохраняет ссылку на окно калькулятора
    // в переменной класса parent
    public CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }
    // Урок 11. Задание 2. Создать в CalculatorEngine ссылку на класс Calculator. Внесенный код, часть 1, конец

    // Урок 11. Задание 3. Реализовать алгоритм работы калькулятора. Внесенный код, часть 1, начало
    char selectedAction = ' '; // +, -, /, или *
    double currentResult = 0;
    // Урок 11. Задание 3. Реализовать алгоритм работы калькулятора. Внесенный код, часть 1, конец
    // Урок 11. Задание 5. Добавить обработку кнопок памяти и точки. Внесенный код, часть 1
    double memory = 0; // Для памяти

    @Override
    public void actionPerformed(ActionEvent e) {
        // Получаем источник события
        JButton clickedButton = (JButton) e.getSource();
        // Получаем надпись на кнопке
        // String clickedButtonLabel = clickedButton.getText();

        // Урок 11. Задание 2. Создать в CalculatorEngine ссылку на класс Calculator. Внесенный код, часть 2, начало
        // Получить текущий текст из поля вывода («дисплея») калькулятора
        String dispFieldText = parent.displayField.getText();
        // parent.displayField.setText(dispFieldText + clickedButtonLabel);
        // Урок 11. Задание 2. Создать в CalculatorEngine ссылку на класс Calculator. Внесенный код, часть 2, конец

        // Урок 11. Задание 3. Реализовать алгоритм работы калькулятора. Внесенный код, часть 2, начало
        double displayValue = 0;

        // Получить число из дисплея калькулятора,
        // если он не пустой.
        // Восклицательный знак – это оператор отрицания

//        if (!"".equals(dispFieldText)) {
//            displayValue = Double.parseDouble(dispFieldText);
//        }
        Object src = e.getSource();

        // Урок 11. Задание 6. Расширить функциональность калькулятора. Внесенный код, часть 1, начало
        // Блок безопасного парсинга числа
        try {
            if (!"".equals(dispFieldText)) {
                displayValue = Double.parseDouble(dispFieldText);
            }
        } catch (NumberFormatException ex) {
            // если дисплей содержит скобки или что-то нечисловое
            // просто оставляем displayValue = 0, не падаем
        }
        // Кнопка C
        if (src == parent.buttonClear) {
            parent.displayField.setText("");
            currentResult = 0;
            selectedAction = ' ';
        }
        // Кнопка ←
        else if (src == parent.buttonBack) {

            if (dispFieldText.length() > 0) {
                parent.displayField.setText(
                        dispFieldText.substring(0, dispFieldText.length() - 1)
                );
            }

        }
        // Урок 11. Задание 6. Расширить функциональность калькулятора. Внесенный код, часть 1, конец

        // Для каждой кнопки арифметического действия
        // запомнить его: +, -, /, или *, сохранить текущее число
        // в переменной currentResult, и очистить дисплей
        // для ввода нового числа

        // Арифметика
        else if (src == parent.buttonPlus) {
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
            // Совершить арифметическое действие, в зависимости
            // от selectedAction, обновить переменную currentResult
            // и показать результат на дисплее
            if (selectedAction == '+') {
                currentResult += displayValue;
                // Сконвертировать результат в строку, добавляя его
                // к пустой строке и показать его
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '-') {
                currentResult -= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '/') {
                currentResult /= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '*') {
                currentResult *= displayValue;
                parent.displayField.setText("" + currentResult);
            }

        }
        // Урок 11. Задание 5. Добавить обработку кнопок памяти и точки. Внесенный код, часть 2, начало
        // Память
        else if (src == parent.buttonMC) {
            memory = 0;
        } else if (src == parent.buttonMR) {
            parent.displayField.setText("" + memory);
        } else if (src == parent.buttonMS) {
            memory = displayValue;
        } else if (src == parent.buttonMPlus) {
            memory += displayValue;
        }
        // Урок 11. Задание 5. Добавить обработку кнопок памяти и точки. Внесенный код, часть 2, конец

        // Урок 11. Задание 6. Расширить функциональность калькулятора. Внесенный код, часть 2, начало
        // Скобки
        else if (src == parent.buttonOpen || src == parent.buttonClose) {
            String clickedButtonLabel = clickedButton.getText();
            parent.displayField.setText(dispFieldText + clickedButtonLabel);
        }
        // Урок 11. Задание 6. Расширить функциональность калькулятора. Внесенный код, часть 2, конец

        else {
            // Для всех цифровых кнопок присоединить надпись на кнопке к надписи в дисплее
            String clickedButtonLabel = clickedButton.getText();
            // Урок 11. Задание 5. Добавить обработку кнопок памяти и точки. Внесенный код, часть 3
            if (clickedButtonLabel.equals(".") && dispFieldText.contains(".")) {
                return;
            }
            parent.displayField.setText(dispFieldText + clickedButtonLabel);
        }
        // Урок 11. Задание 3. Реализовать алгоритм работы калькулятора. Внесенный код, часть 2, конец
    }
}
