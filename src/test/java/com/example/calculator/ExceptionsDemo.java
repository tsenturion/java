package com.example.calculator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Демонстрационный класс для тестирования исключений
 */
public class ExceptionsDemo {

    public static void main(String[] args) {
        System.out.println("🎯 ДЕМОНСТРАЦИЯ ТЕСТИРОВАНИЯ ИСКЛЮЧЕНИЙ\n");
        
        Calculator calculator = new Calculator();
        
        // 1. Тестирование деления на ноль
        System.out.println("1. Тестирование деления на ноль:");
        try {
            calculator.divide(10, 0);
            System.out.println("   ❌ Ожидалось исключение, но его не было!");
        } catch (ArithmeticException e) {
            System.out.println("   ✅ Поймано ожидаемое исключение: " + e.getMessage());
        }
        
        // 2. Тестирование отрицательной степени
        System.out.println("2. Тестирование отрицательной степени:");
        try {
            calculator.power(2, -1);
            System.out.println("   ❌ Ожидалось исключение, но его не было!");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ Поймано ожидаемое исключение: " + e.getMessage());
        }
        
        // 3. Тестирование отрицательного факториала
        System.out.println("3. Тестирование отрицательного факториала:");
        try {
            calculator.factorial(-5);
            System.out.println("   ❌ Ожидалось исключение, но его не было!");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ Поймано ожидаемое исключение: " + e.getMessage());
        }
        
        // 4. Тестирование квадратного корня от отрицательного числа
        System.out.println("4. Тестирование квадратного корня от отрицательного числа:");
        try {
            calculator.sqrt(-4);
            System.out.println("   ❌ Ожидалось исключение, но его не было!");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ Поймано ожидаемое исключение: " + e.getMessage());
        }
        
        // 5. Демонстрация assertThrows
        System.out.println("5. Использование assertThrows:");
        ArithmeticException divisionException = assertThrows(ArithmeticException.class,
            () -> calculator.divide(1, 0));
        System.out.println("   ✅ assertThrows работает: " + divisionException.getMessage());
        
        // 6. Демонстрация assertDoesNotThrow
        System.out.println("6. Использование assertDoesNotThrow:");
        assertDoesNotThrow(() -> calculator.divide(10, 2));
        System.out.println("   ✅ assertDoesNotThrow работает: операция выполнена без исключений");
        
        System.out.println("\n🎉 Все тесты исключений продемонстрированы успешно!");
    }
}