package com.example.calculator;

/**
 * Класс Calculator предоставляет базовые арифметические операции.
 * Включает сложение, вычитание, умножение и деление целых чисел.
 */
public class Calculator {
    
    /**
     * Сложение двух целых чисел
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма a и b
     */
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
}
