package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Специализированный тестовый класс для тестирования исключительных ситуаций
 * Демонстрирует использование assertThrows и проверку исключений
 */
public class CalculatorTest4 {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("🔄 Calculator подготовлен для тестирования исключений");
    }

    @Test
    void testDivisionByZeroThrowsException() {
        System.out.println(">>> Тестируем деление на ноль");
        
        // Act & Assert в одном вызове!
        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            () -> calculator.divide(10, 0),
            "Деление на ноль должно выбрасывать ArithmeticException"
        );
        
        // Дополнительная проверка сообщения об ошибке
        assertEquals("Деление на ноль невозможно", exception.getMessage());
        System.out.println("✅ Деление на ноль корректно выбрасывает ArithmeticException: " + exception.getMessage());
    }

    @Test
    void testNegativePowerThrowsException() {
        System.out.println(">>> Тестируем отрицательную степень");
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.power(2, -1),
            "Отрицательная степень должна выбрасывать IllegalArgumentException"
        );
        
        assertEquals("Показатель степени не может быть отрицательным", exception.getMessage());
        System.out.println("✅ Отрицательная степень корректно выбрасывает IllegalArgumentException: " + exception.getMessage());
    }

    @Test
    void testNegativeFactorialThrowsException() {
        System.out.println(">>> Тестируем факториал отрицательного числа");
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.factorial(-5),
            "Факториал отрицательного числа должен выбрасывать исключение"
        );
        
        assertTrue(exception.getMessage().contains("Факториал определен только"));
        System.out.println("✅ Факториал отрицательного числа корректно выбрасывает исключение: " + exception.getMessage());
    }

    @Test
    void testMultipleDivisionByZeroScenarios() {
        System.out.println(">>> Тестируем различные сценарии деления на ноль");
        
        // Проверяем разные случаи деления на ноль
        assertAll("Группа проверок деления на ноль",
            () -> {
                ArithmeticException exception = assertThrows(ArithmeticException.class,
                    () -> calculator.divide(0, 0));
                assertEquals("Деление на ноль невозможно", exception.getMessage());
            },
            () -> {
                ArithmeticException exception = assertThrows(ArithmeticException.class,
                    () -> calculator.divide(-10, 0));
                assertEquals("Деление на ноль невозможно", exception.getMessage());
            },
            () -> {
                ArithmeticException exception = assertThrows(ArithmeticException.class,
                    () -> calculator.divide(100, 0));
                assertEquals("Деление на ноль невозможно", exception.getMessage());
            }
        );
        
        System.out.println("✅ Все сценарии деления на ноль обработаны корректно");
    }

    @Test
    void testVariousInvalidPowerScenarios() {
        System.out.println(">>> Тестируем различные невалидные сценарии степени");
        
        // Проверяем разные отрицательные степени
        assertAll("Группа проверок отрицательной степени",
            () -> {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> calculator.power(5, -10));
                assertEquals("Показатель степени не может быть отрицательным", exception.getMessage());
            },
            () -> {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> calculator.power(1, -1));
                assertEquals("Показатель степени не может быть отрицательным", exception.getMessage());
            },
            () -> {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> calculator.power(100, -100));
                assertEquals("Показатель степени не может быть отрицательным", exception.getMessage());
            }
        );
        
        System.out.println("✅ Все невалидные сценарии степени обработаны корректно");
    }

    @Test
    void testVariousInvalidFactorialScenarios() {
        System.out.println(">>> Тестируем различные невалидные сценарии факториала");
        
        // Проверяем разные отрицательные числа для факториала
        assertAll("Группа проверок отрицательного факториала",
            () -> {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> calculator.factorial(-1));
                assertTrue(exception.getMessage().contains("Факториал определен только"));
            },
            () -> {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> calculator.factorial(-10));
                assertTrue(exception.getMessage().contains("Факториал определен только"));
            },
            () -> {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> calculator.factorial(Integer.MIN_VALUE));
                assertTrue(exception.getMessage().contains("Факториал определен только"));
            }
        );
        
        System.out.println("✅ Все невалидные сценарии факториала обработаны корректно");
    }

    @Test
    void testValidOperationsDoNotThrowExceptions() {
        System.out.println(">>> Тестируем, что валидные операции не выбрасывают исключения");
        
        // Проверяем, что нормальные операции работают без исключений
        assertAll("Группа проверок валидных операций",
            () -> assertDoesNotThrow(() -> calculator.divide(10, 2)),
            () -> assertDoesNotThrow(() -> calculator.power(2, 5)),
            () -> assertDoesNotThrow(() -> calculator.factorial(5)),
            () -> assertDoesNotThrow(() -> calculator.add(1, 1)),
            () -> assertDoesNotThrow(() -> calculator.multiply(3, 4))
        );
        
        System.out.println("✅ Все валидные операции выполняются без исключений");
    }

    @Test
    void testExceptionHierarchy() {
        System.out.println(">>> Тестируем иерархию исключений");
        
        // Проверяем, что исключения правильного типа
        assertAll("Группа проверок типов исключений",
            () -> {
                Exception exception = assertThrows(Exception.class,
                    () -> calculator.divide(1, 0));
                assertTrue(exception instanceof ArithmeticException);
            },
            () -> {
                Exception exception = assertThrows(Exception.class,
                    () -> calculator.power(1, -1));
                assertTrue(exception instanceof IllegalArgumentException);
            },
            () -> {
                Exception exception = assertThrows(Exception.class,
                    () -> calculator.factorial(-1));
                assertTrue(exception instanceof IllegalArgumentException);
            }
        );
        
        System.out.println("✅ Иерархия исключений корректна");
    }

    @Test
    void testEdgeCaseValidOperations() {
        System.out.println(">>> Тестируем граничные валидные случаи");
        
        // Граничные случаи, которые должны работать
        assertAll("Группа проверок граничных случаев",
            () -> assertEquals(0, calculator.divide(0, 5), "0 / 5 должно быть 0"),
            () -> assertEquals(1, calculator.power(100, 0), "100^0 должно быть 1"),
            () -> assertEquals(1, calculator.power(1, 1000), "1^1000 должно быть 1"),
            () -> assertEquals(1, calculator.factorial(0), "0! должно быть 1"),
            () -> assertEquals(1, calculator.factorial(1), "1! должно быть 1")
        );
        
        System.out.println("✅ Граничные валидные случаи обработаны корректно");
    }
}