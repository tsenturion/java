package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности калькулятора.
 * Использует JUnit 5 для модульного тестирования.
 */
class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3), "2 + 3 должно быть 5");
        assertEquals(0, calculator.add(0, 0), "0 + 0 должно быть 0");
        assertEquals(-1, calculator.add(2, -3), "2 + (-3) должно быть -1");
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 должно быть 1");
        assertEquals(-1, calculator.subtract(2, 3), "2 - 3 должно быть -1");
        assertEquals(0, calculator.subtract(5, 5), "5 - 5 должно быть 0");
    }

    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 должно быть 6");
        assertEquals(0, calculator.multiply(5, 0), "5 * 0 должно быть 0");
        assertEquals(-6, calculator.multiply(2, -3), "2 * (-3) должно быть -6");
    }

    @Test
    void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3), "6 / 3 должно быть 2");
        assertEquals(0, calculator.divide(0, 5), "0 / 5 должно быть 0");
        assertEquals(-2, calculator.divide(6, -3), "6 / (-3) должно быть -2");
    }

    @Test
    void testDivideByZero() {
        Calculator calculator = new Calculator();
        ArithmeticException exception = assertThrows(ArithmeticException.class, 
            () -> calculator.divide(5, 0), "Деление на ноль должно вызывать исключение");
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }

    @Test
    void testPower() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.power(2, 3), "2^3 должно быть 8");
        assertEquals(1, calculator.power(5, 0), "5^0 должно быть 1");
        assertEquals(1, calculator.power(1, 100), "1^100 должно быть 1");
    }

    @Test
    void testPowerWithNegativeExponent() {
        Calculator calculator = new Calculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.power(2, -1), "Отрицательная степень должна вызывать исключение");
        assertEquals("Показатель степени не может быть отрицательным", exception.getMessage());
    }

    @Test
    void testFactorial() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.factorial(0), "0! должно быть 1");
        assertEquals(1, calculator.factorial(1), "1! должно быть 1");
        assertEquals(120, calculator.factorial(5), "5! должно быть 120");
        assertEquals(3628800, calculator.factorial(10), "10! должно быть 3628800");
    }

    @Test
    void testFactorialWithNegativeNumber() {
        Calculator calculator = new Calculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.factorial(-1), "Факториал отрицательного числа должен вызывать исключение");
        assertEquals("Факториал определен только для неотрицательных чисел", exception.getMessage());
    }
}