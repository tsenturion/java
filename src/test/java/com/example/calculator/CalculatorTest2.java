package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Улучшенный тестовый класс Calculator с использованием @BeforeEach и @AfterEach
 * Демонстрирует жизненный цикл тестов и лучшие практики тестирования
 */
public class CalculatorTest2 {

    // Это наш главный инструмент для тестов
    private Calculator calculator;

    // @BeforeEach - ключевая аннотация!
    // Этот метод выполняется ПЕРЕД КАЖДЫМ тестом
    @BeforeEach
    public void setUp() {
        System.out.println("=== @BeforeEach: Создаем новый Calculator перед тестом ===");
        calculator = new Calculator();
        System.out.println("Объект Calculator создан: " + calculator);
    }

    // @AfterEach - для завершающих действий
    @AfterEach
    public void tearDown() {
        System.out.println("=== @AfterEach: Тест завершен. Готовимся к следующему ===");
        // Здесь можно, например, обнулить ссылку
        calculator = null;
        System.out.println("Объект Calculator очищен");
        System.out.println("----------------------------------------");
    }

    @Test
    public void testAddition() {
        System.out.println(">>> Выполняется testAddition");
        // Arrange (Подготовка)
        int a = 5;
        int b = 3;
        int expectedResult = 8;

        // Act (Действие)
        int actualResult = calculator.add(a, b);

        // Assert (Проверка)
        assertEquals(expectedResult, actualResult, "5 + 3 должно быть 8");
        System.out.println("✓ Сложение выполнено успешно: " + a + " + " + b + " = " + actualResult);
    }

    @Test
    public void testSubtraction() {
        System.out.println(">>> Выполняется testSubtraction");
        // Arrange
        int a = 10;
        int b = 4;
        int expectedResult = 6;

        // Act
        int actualResult = calculator.subtract(a, b);

        // Assert
        assertEquals(expectedResult, actualResult, "10 - 4 должно быть 6");
        System.out.println("✓ Вычитание выполнено успешно: " + a + " - " + b + " = " + actualResult);
    }

    @Test
    public void testAdditionWithNegativeNumbers() {
        System.out.println(">>> Выполняется testAdditionWithNegativeNumbers");
        // Arrange
        int a = -5;
        int b = -3;
        int expectedResult = -8;

        // Act
        int actualResult = calculator.add(a, b);

        // Assert
        assertEquals(expectedResult, actualResult, "-5 + (-3) должно быть -8");
        System.out.println("✓ Сложение отрицательных чисел выполнено: " + a + " + " + b + " = " + actualResult);
    }

    @Test
    public void testMultiplication() {
        System.out.println(">>> Выполняется testMultiplication");
        // Arrange
        int a = 7;
        int b = 6;
        int expectedResult = 42;

        // Act
        int actualResult = calculator.multiply(a, b);

        // Assert
        assertEquals(expectedResult, actualResult, "7 * 6 должно быть 42");
        System.out.println("✓ Умножение выполнено успешно: " + a + " * " + b + " = " + actualResult);
    }

    @Test
    public void testDivision() {
        System.out.println(">>> Выполняется testDivision");
        // Arrange
        int a = 15;
        int b = 3;
        int expectedResult = 5;

        // Act
        int actualResult = calculator.divide(a, b);

        // Assert
        assertEquals(expectedResult, actualResult, "15 / 3 должно быть 5");
        System.out.println("✓ Деление выполнено успешно: " + a + " / " + b + " = " + actualResult);
    }

    @Test
    public void testDivisionByZero() {
        System.out.println(">>> Выполняется testDivisionByZero");
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        ArithmeticException exception = assertThrows(ArithmeticException.class, 
            () -> calculator.divide(a, b), 
            "Деление на ноль должно выбрасывать ArithmeticException");
        
        assertEquals("Деление на ноль невозможно", exception.getMessage());
        System.out.println("✓ Исключение при делении на ноль обработано корректно: " + exception.getMessage());
    }

    @Test
    public void testComplexOperations() {
        System.out.println(">>> Выполняется testComplexOperations");
        // Arrange - несколько операций подряд
        int result1 = calculator.add(10, 5);      // 15
        int result2 = calculator.multiply(result1, 2); // 30
        int result3 = calculator.subtract(result2, 10); // 20
        int finalResult = calculator.divide(result3, 4); // 5

        // Assert
        assertEquals(5, finalResult, "((10 + 5) * 2 - 10) / 4 должно быть 5");
        System.out.println("✓ Комплексная операция выполнена: ((10+5)*2-10)/4 = " + finalResult);
    }
}