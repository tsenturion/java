package com.example.calculator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Демонстрационный класс для показа всех методов Assertions
 */
public class AssertionsDemo {

    public static void main(String[] args) {
        System.out.println("🎯 ДЕМОНСТРАЦИЯ МЕТОДОВ ASSERTIONS\n");
        
        Calculator calculator = new Calculator();
        
        // 1. assertEquals
        System.out.println("1. assertEquals():");
        assertEquals(4, calculator.add(2, 2));
        System.out.println("   ✅ 2 + 2 = 4 - проверка пройдена");
        
        // 2. assertNotEquals
        System.out.println("2. assertNotEquals():");
        assertNotEquals(5, calculator.add(2, 2));
        System.out.println("   ✅ 2 + 2 ≠ 5 - проверка пройдена");
        
        // 3. assertTrue
        System.out.println("3. assertTrue():");
        assertTrue(calculator.isPositive(10));
        System.out.println("   ✅ 10 положительное - проверка пройдена");
        
        // 4. assertFalse
        System.out.println("4. assertFalse():");
        assertFalse(calculator.isPositive(-5));
        System.out.println("   ✅ -5 не положительное - проверка пройдена");
        
        // 5. assertNull
        System.out.println("5. assertNull():");
        assertNull(calculator.processNumber(-1));
        System.out.println("   ✅ processNumber(-1) вернул null - проверка пройдена");
        
        // 6. assertNotNull
        System.out.println("6. assertNotNull():");
        assertNotNull(calculator.processNumber(10));
        System.out.println("   ✅ processNumber(10) не null - проверка пройдена");
        
        // 7. assertArrayEquals
        System.out.println("7. assertArrayEquals():");
        int[] expected = {1, 2, 3};
        int[] actual = calculator.generateSequence(3);
        assertArrayEquals(expected, actual);
        System.out.println("   ✅ Массивы совпадают - проверка пройдена");
        
        // 8. assertThrows
        System.out.println("8. assertThrows():");
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        System.out.println("   ✅ Исключение при делении на ноль - проверка пройдена");
        
        System.out.println("\n🎉 Все методы Assertions продемонстрированы успешно!");
    }
}