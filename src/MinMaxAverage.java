import java.util.Scanner;

/**
 * Программа для поиска минимального, максимального значения
 * и вычисления среднего арифметического из 10 чисел.
 * 
 * Основные концепции:
 * - Работа с массивами или переменными-аккумуляторами
 * - Использование циклов for для обработки последовательности
 * - Математические операции
 * - Поиск экстремальных значений
 */
public class MinMaxAverage {

    public static void main(String[] args) {
        // Создаём Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);
        
        // КОНСТАНТА - количество чисел для ввода
        // Использование констант делает код понятнее
        final int NUMBER_COUNT = 10;
        
        System.out.println("=== ПОИСК МИНИМУМА, МАКСИМУМА И СРЕДНЕГО ЗНАЧЕНИЯ ===");
        System.out.println("Программа запросит у вас " + NUMBER_COUNT + " чисел.");
        System.out.println("Затем найдёт минимальное, максимальное и среднее значение.");
        System.out.println();
        
        // ИНИЦИАЛИЗАЦИЯ ПЕРЕМЕННЫХ
        // Мы должны где-то хранить промежуточные результаты
        
        // Для минимального значения начинаем с ОЧЕНЬ большого числа
        // Это гарантирует, что первое введённое число станет минимумом
        double min = Double.MAX_VALUE;
        
        // Для максимального значения начинаем с ОЧЕНЬ маленького числа
        // Это гарантирует, что первое введённое число станет максимумом
        double max = Double.MIN_VALUE;
        
        // Переменная для суммы всех чисел
        // Нам нужна сумма, чтобы потом вычислить среднее
        double sum = 0;
        
        // ЦИКЛ ДЛЯ ЧТЕНИЯ 10 ЧИСЕЛ
        // Мы используем for, потому что знаем ТОЧНОЕ количество итераций
        for (int i = 1; i <= NUMBER_COUNT; i++) {
            System.out.print("Введите число #" + i + ": ");
            
            // Проверяем, что введено число
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка! Пожалуйста, введите число.");
                scanner.next(); // Очищаем некорректный ввод
                System.out.print("Введите число #" + i + ": ");
            }
            
            // Читаем число
            double number = scanner.nextDouble();
            
            // ОБНОВЛЯЕМ МИНИМАЛЬНОЕ ЗНАЧЕНИЕ
            // Если текущее число меньше того минимума, что у нас есть,
            // то это число становится новым минимумом
            if (number < min) {
                min = number;
                System.out.println("   🎯 Новый минимум: " + min);
            }
            
            // ОБНОВЛЯЕМ МАКСИМАЛЬНОЕ ЗНАЧЕНИЕ
            // Если текущее число больше того максимума, что у нас есть,
            // то это число становится новым максимумом
            if (number > max) {
                max = number;
                System.out.println("   🚀 Новый максимум: " + max);
            }
            
            // ДОБАВЛЯЕМ ЧИСЛО К СУММЕ
            // Мы накапливаем сумму всех чисел
            sum += number; // То же самое, что sum = sum + number
        }
        
        // ВЫЧИСЛЯЕМ СРЕДНЕЕ АРИФМЕТИЧЕСКОЕ
        // Среднее = сумма всех чисел / количество чисел
        double average = sum / NUMBER_COUNT;
        
        System.out.println();
        System.out.println("══════════════════════════════════════");
        System.out.println("             РЕЗУЛЬТАТЫ              ");
        System.out.println("══════════════════════════════════════");
        
        // ВЫВОДИМ РЕЗУЛЬТАТЫ
        // Используем форматирование для красивого вывода
        System.out.printf("Минимальное значение:  %.2f\n", min);
        System.out.printf("Максимальное значение: %.2f\n", max);
        System.out.printf("Среднее арифметическое: %.2f\n", average);
        System.out.println("══════════════════════════════════════");
        
        // ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ
        System.out.println();
        System.out.println("Дополнительная информация:");
        System.out.println("Сумма всех чисел: " + sum);
        System.out.println("Количество чисел: " + NUMBER_COUNT);
        
        // РАЗНИЦА МЕЖДУ МАКСИМУМОМ И МИНИМУМОМ
        double range = max - min;
        System.out.printf("Размах данных (max - min): %.2f\n", range);
        
        // Закрываем Scanner
        scanner.close();
    }
    
    /**
     * Альтернативная версия с использованием массива
     * Этот метод показывает другой подход к решению задачи
     */
    public static void findMinMaxWithArray() {
        Scanner scanner = new Scanner(System.in);
        final int COUNT = 10;
        double[] numbers = new double[COUNT];
        
        System.out.println("Введите " + COUNT + " чисел:");
        
        // Заполняем массив числами
        for (int i = 0; i < COUNT; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }
        
        // Находим минимум и максимум в массиве
        double min = numbers[0];
        double max = numbers[0];
        double sum = numbers[0];
        
        // Начинаем со второго элемента, так как первый уже учтён
        for (int i = 1; i < COUNT; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            sum += numbers[i];
        }
        
        double average = sum / COUNT;
        
        System.out.println("\nРезультаты (версия с массивом):");
        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
        System.out.println("Среднее: " + average);
        
        scanner.close();
    }
    
    /**
     * Дополнительный метод для демонстрации принципов
     * Находит минимум, максимум и среднее в переданном массиве
     */
    public static void analyzeNumbers(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Массив пуст или не существует!");
            return;
        }
        
        double min = numbers[0];
        double max = numbers[0];
        double sum = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            // Обновляем минимум
            min = Math.min(min, numbers[i]);
            // Обновляем максимум
            max = Math.max(max, numbers[i]);
            // Суммируем
            sum += numbers[i];
        }
        
        double average = sum / numbers.length;
        
        System.out.println("Анализ " + numbers.length + " чисел:");
        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
        System.out.println("Среднее: " + average);
        System.out.println("Сумма: " + sum);
    }
}