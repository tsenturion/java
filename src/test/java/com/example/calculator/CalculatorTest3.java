package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для демонстрации различных методов Assertions
 * Показывает использование assertEquals, assertTrue, assertFalse и других
 */
public class CalculatorTest3 {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("🔄 Подготовлен новый Calculator для теста");
    }

    @Test
    void testBasicOperationsWithAssertEquals() {
        System.out.println(">>> Тестируем базовые операции с assertEquals");
        
        // assertEquals для точных проверок целых чисел
        assertEquals(15, calculator.add(10, 5), "10 + 5 должно быть 15");
        assertEquals(5, calculator.subtract(10, 5), "10 - 5 должно быть 5");
        assertEquals(50, calculator.multiply(10, 5), "10 * 5 должно быть 50");
        assertEquals(2, calculator.divide(10, 5), "10 / 5 должно быть 2");
        
        System.out.println("✅ Все базовые операции работают корректно");
    }

    @Test
    void testFloatingPointOperationsWithDelta() {
        System.out.println(">>> Тестируем операции с плавающей точкой и delta");
        
        // Для демонстрации создадим метод в Calculator для деления double
        // Временно используем целочисленное деление, но покажем концепцию delta
        
        // Пример с delta для чисел с плавающей точкой
        double expected = 3.333;
        double actual = 10.0 / 3.0; // 3.333333...
        double delta = 0.001; // Допустимая погрешность
        
        assertEquals(expected, actual, delta, 
            "10.0 / 3.0 должно быть приблизительно 3.333 с погрешностью 0.001");
        
        System.out.println("✅ Операции с плавающей точкой проверены с delta");
    }

    @Test
    void testBooleanConditionsWithAssertTrueFalse() {
        System.out.println(">>> Тестируем булевы условия с assertTrue/assertFalse");
        
        // assertTrue для положительных проверок
        assertTrue(calculator.isPositive(10), "10 должно быть положительным");
        assertTrue(calculator.isEven(4), "4 должно быть четным");
        assertTrue(calculator.isPrime(7), "7 должно быть простым числом");
        
        // assertFalse для отрицательных проверок  
        assertFalse(calculator.isPositive(-5), "-5 не должно быть положительным");
        assertFalse(calculator.isEven(3), "3 не должно быть четным");
        assertFalse(calculator.isPrime(4), "4 не должно быть простым числом");
        
        System.out.println("✅ Все булевы условия проверены");
    }

    @Test
    void testEdgeCasesWithDescriptiveMessages() {
        System.out.println(">>> Тестируем граничные случаи с описательными сообщениями");
        
        // Добавляем понятные сообщения об ошибках
        int result = calculator.add(2, 3);
        assertEquals(5, result, "2 + 3 должно быть 5");
        
        // Граничные случаи
        assertEquals(0, calculator.add(0, 0), "0 + 0 должно быть 0");
        assertEquals(-5, calculator.add(-2, -3), "-2 + (-3) должно быть -5");
        assertEquals(0, calculator.add(5, -5), "5 + (-5) должно быть 0");
        
        System.out.println("✅ Граничные случаи обработаны корректно");
    }

    @Test
    void testComplexBooleanExpressions() {
        System.out.println(">>> Тестируем сложные булевы выражения");
        
        // Комбинированные проверки
        int number = 15;
        
        // Проверяем несколько условий
        assertTrue(calculator.isPositive(number) && !calculator.isPrime(number), 
            "15 должно быть положительным и не простым");
        
        assertTrue(calculator.isOdd(number) && calculator.isDivisibleBy(number, 5), 
            "15 должно быть нечетным и делиться на 5");
        
        System.out.println("✅ Сложные булевы выражения проверены");
    }

    @Test
    void testWithAssertAll() {
        System.out.println(">>> Тестируем с assertAll - группировка проверок");
        
        // assertAll позволяет выполнить все проверки, даже если некоторые падают
        assertAll("Группа проверок сложения",
            () -> assertEquals(5, calculator.add(2, 3), "2 + 3"),
            () -> assertEquals(0, calculator.add(0, 0), "0 + 0"),
            () -> assertEquals(-1, calculator.add(2, -3), "2 + (-3)"),
            () -> assertEquals(100, calculator.add(50, 50), "50 + 50")
        );
        
        System.out.println("✅ Все проверки в группе выполнены");
    }

    @Test
    void testNullAndNotNull() {
        System.out.println(">>> Тестируем проверки на null");
        
        String result = calculator.processNumber(10);
        
        // assertNotNull проверяет, что объект не null
        assertNotNull(result, "Результат не должен быть null");
        
        // assertNull проверяет, что объект null
        String nullResult = calculator.processNumber(-1);
        assertNull(nullResult, "Для отрицательных чисел должен возвращаться null");
        
        System.out.println("✅ Проверки на null работают корректно");
    }

    @Test
    void testArrayEquality() {
        System.out.println(">>> Тестируем сравнение массивов");
        
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = calculator.generateSequence(5);
        
        // assertArrayEquals сравнивает массивы
        assertArrayEquals(expected, actual, "Массивы должны быть одинаковыми");
        
        System.out.println("✅ Сравнение массивов работает корректно");
    }
}