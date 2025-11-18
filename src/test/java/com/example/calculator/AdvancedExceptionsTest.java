package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Продвинутый тестовый класс для тестирования исключений
 */
public class AdvancedExceptionsTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testMultipleExceptionTypes() {
        System.out.println(">>> Тестируем различные типы исключений");
        
        assertAll("Разные типы исключений",
            // ArithmeticException
            () -> assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0)),
            
            // IllegalArgumentException
            () -> assertThrows(IllegalArgumentException.class, () -> calculator.power(2, -1)),
            () -> assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1)),
            () -> assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-1)),
            () -> assertThrows(IllegalArgumentException.class, () -> calculator.logarithm(-1)),
            
            // RuntimeExceptions (родительские классы)
            () -> assertThrows(RuntimeException.class, () -> calculator.divide(1, 0)),
            () -> assertThrows(RuntimeException.class, () -> calculator.power(2, -1))
        );
    }

    @Test
    void testExceptionMessageContent() {
        System.out.println(">>> Тестируем содержание сообщений об ошибках");
        
        assertAll("Содержание сообщений",
            () -> {
                ArithmeticException e = assertThrows(ArithmeticException.class,
                    () -> calculator.divide(10, 0));
                assertTrue(e.getMessage().contains("ноль"));
            },
            () -> {
                IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                    () -> calculator.power(2, -1));
                assertTrue(e.getMessage().contains("отрицательным"));
            },
            () -> {
                IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                    () -> calculator.factorial(-5));
                assertTrue(e.getMessage().contains("неотрицательных"));
            }
        );
    }

    @Test
    void testNoExceptionOnValidInput() {
        System.out.println(">>> Тестируем отсутствие исключений на валидных данных");
        
        assertAll("Валидные операции без исключений",
            () -> assertDoesNotThrow(() -> calculator.sqrt(4)),
            () -> assertDoesNotThrow(() -> calculator.sqrt(0)),
            () -> assertDoesNotThrow(() -> calculator.logarithm(1)),
            () -> assertDoesNotThrow(() -> calculator.logarithm(100)),
            () -> assertDoesNotThrow(() -> calculator.safeDivide(10, 2)),
            () -> assertDoesNotThrow(() -> calculator.safeDivide(0, 5))
        );
    }
}