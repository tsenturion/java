package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Демонстрационный класс для показа полного жизненного цикла тестов JUnit
 */
public class LifecycleDemoTest {

    private Calculator calculator;
    private static int testCounter = 0;

    // @BeforeAll - выполняется один раз перед всеми тестами (должен быть static)
    @BeforeAll
    public static void setUpClass() {
        System.out.println("🎯 @BeforeAll: Начинаем тестовый прогон");
        System.out.println("========================================");
    }

    // @AfterAll - выполняется один раз после всех тестов (должен быть static)
    @AfterAll
    public static void tearDownClass() {
        System.out.println("========================================");
        System.out.println("🎯 @AfterAll: Тестовый прогон завершен");
        System.out.println("Всего выполнено тестов: " + testCounter);
    }

    @BeforeEach
    public void setUp() {
        testCounter++;
        System.out.println("\n🔧 @BeforeEach: Подготовка теста #" + testCounter);
        calculator = new Calculator();
        System.out.println("   Создан новый объект Calculator");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("🧹 @AfterEach: Очистка после теста #" + testCounter);
        calculator = null;
        System.out.println("   Объект Calculator очищен");
    }

    @Test
    public void firstTest() {
        System.out.println("   ▶️ Выполняется firstTest");
        assertEquals(4, calculator.add(2, 2));
        System.out.println("   ✅ firstTest завершен");
    }

    @Test
    public void secondTest() {
        System.out.println("   ▶️ Выполняется secondTest");
        assertEquals(0, calculator.subtract(5, 5));
        System.out.println("   ✅ secondTest завершен");
    }

    @Test
    public void thirdTest() {
        System.out.println("   ▶️ Выполняется thirdTest");
        assertEquals(25, calculator.multiply(5, 5));
        System.out.println("   ✅ thirdTest завершен");
    }
}