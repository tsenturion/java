/**
 * Класс с преднамеренными ошибками для обучения отладке
 */
public class DebugWithErrors {
    public static void main(String[] args) {
        System.out.println("🐛 Демонстрация отладки с ошибками");
        
        // Пример 1: Ошибка в цикле
        loopErrorExample();
        
        // Пример 2: Ошибка с null
        nullPointerExample();
        
        // Пример 3: Ошибка деления на ноль
        divisionErrorExample();
        
        // Пример 4: Бесконечный цикл
        // infiniteLoopExample(); // Раскомментируйте для демонстрации
    }
    
    /**
     * Пример ошибки в цикле - выход за границы массива
     */
    public static void loopErrorExample() {
        System.out.println("\n1. Ошибка в цикле:");
        int[] numbers = {1, 2, 3, 4, 5};
        
        // ОШИБКА: i <= numbers.length вместо i < numbers.length
        for (int i = 0; i <= numbers.length; i++) {
            try {
                System.out.println("numbers[" + i + "] = " + numbers[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("❌ Ошибка: выход за границы массива при i = " + i);
                break;
            }
        }
    }
    
    /**
     * Пример NullPointerException
     */
    public static void nullPointerExample() {
        System.out.println("\n2. NullPointerException:");
        
        String text = null;
        
        try {
            // ОШИБКА: вызов метода у null ссылки
            int length = text.length();
            System.out.println("Длина текста: " + length);
        } catch (NullPointerException e) {
            System.out.println("❌ Ошибка: NullPointerException - попытка вызвать метод у null");
        }
    }
    
    /**
     * Пример деления на ноль
     */
    public static void divisionErrorExample() {
        System.out.println("\n3. Деление на ноль:");
        
        int a = 10;
        int b = 0;
        
        try {
            // ОШИБКА: деление на ноль
            int result = a / b;
            System.out.println("Результат деления: " + result);
        } catch (ArithmeticException e) {
            System.out.println("❌ Ошибка: ArithmeticException - деление на ноль");
        }
    }
    
    /**
     * Пример бесконечного цикла (закомментирован для безопасности)
     */
    public static void infiniteLoopExample() {
        System.out.println("\n4. Бесконечный цикл:");
        System.out.println("⚠️  Этот метод содержит бесконечный цикл!");
        
        int count = 0;
        while (true) { // БЕСКОНЕЧНЫЙ ЦИКЛ
            count++;
            System.out.println("Итерация: " + count);
            
            // Условие выхода никогда не выполнится из-за ошибки
            if (count > 1000) { // Должно быть count > 10, но специально ошиблись
                break;
            }
            
            // Для безопасности добавим принудительный выход
            if (count > 20) {
                System.out.println("🛑 Принудительный выход из бесконечного цикла");
                break;
            }
        }
    }
    
    /**
     * Пример логической ошибки (код работает, но результат неверный)
     */
    public static void logicalErrorExample() {
        System.out.println("\n5. Логическая ошибка:");
        
        // Задача: посчитать сумму четных чисел от 1 до 10
        int sum = 0;
        
        // ОШИБКА: условие i <= 10 вместо i < 10
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.println("Добавлено четное число: " + i);
            }
        }
        
        // Правильный результат должен быть 2+4+6+8+10 = 30
        // Но из-за ошибки мы получим 2+4+6+8 = 20
        System.out.println("Результат: " + sum + " (ожидалось: 30)");
    }
}