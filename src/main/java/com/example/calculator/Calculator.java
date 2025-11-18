package com.example.calculator;

/**
 * Класс Calculator предоставляет базовые арифметические операции
 * и дополнительные методы для тестирования различных assertions
 */
public class Calculator {
    
    // Существующие методы...
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Вычитание двух целых чисел
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return разность a и b
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Умножение двух целых чисел
     * @param a первый множитель
     * @param b второй множитель
     * @return произведение a и b
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Деление двух целых чисел
     * @param a делимое
     * @param b делитель
     * @return частное a и b
     * @throws ArithmeticException если делитель равен нулю
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return a / b;
    }
    
    /**
     * Возведение числа в степень (только для неотрицательных степеней)
     * @param a основание
     * @param b показатель степени (неотрицательный)
     * @return a в степени b
     * @throws IllegalArgumentException если показатель степени отрицательный
     */
    public int power(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Показатель степени не может быть отрицательным");
        }
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
    
    /**
     * Вычисление факториала числа
     * @param n число для вычисления факториала (неотрицательное)
     * @return факториал числа n
     * @throws IllegalArgumentException если число отрицательное
     */
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // НОВЫЕ МЕТОДЫ ДЛЯ ТЕСТИРОВАНИЯ ASSERTIONS
    
    /**
     * Проверяет, является ли число положительным
     */
    public boolean isPositive(int number) {
        return number > 0;
    }
    
    /**
     * Проверяет, является ли число четным
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    /**
     * Проверяет, является ли число нечетным
     */
    public boolean isOdd(int number) {
        return number % 2 != 0;
    }
    
    /**
     * Проверяет, является ли число простым
     */
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    /**
     * Проверяет, делится ли число на divisor
     */
    public boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
    
    /**
     * Обрабатывает число и возвращает строку или null
     */
    public String processNumber(int number) {
        if (number >= 0) {
            return "Обработано: " + number;
        }
        return null;
    }
    
    /**
     * Генерирует последовательность чисел
     */
    public int[] generateSequence(int length) {
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = i + 1;
        }
        return sequence;
    }
    
    /**
     * Возвращает число как double для тестирования delta
     */
    public double getDoubleValue(int number) {
        return (double) number;
    }

    // НОВЫЕ МЕТОДЫ ДЛЯ ТЕСТИРОВАНИЯ ИСКЛЮЧЕНИЙ
    
    /**
     * Вычисляет квадратный корень (только для неотрицательных чисел)
     */
    public double sqrt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Квадратный корень определен только для неотрицательных чисел");
        }
        return Math.sqrt(number);
    }
    
    /**
     * Делит числа с проверкой на переполнение
     */
    public int safeDivide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("Переполнение при делении");
        }
        return a / b;
    }
    
    /**
     * Вычисляет логарифм (только для положительных чисел)
     */
    public double logarithm(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Логарифм определен только для положительных чисел");
        }
        return Math.log(number);
    }
}