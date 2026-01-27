import java.util.Scanner;

/**
 * Простой калькулятор с меню для выполнения базовых арифметических операций.
 * Программа демонстрирует:
 * - Использование циклов while/do-while
 * - Работу с меню
 * - Обработку пользовательского ввода
 * - Базовые арифметические операции
 */
public class MenuCalculator {

    public static void main(String[] args) {
        // Создаём Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);
        
        // Переменная для выбора пользователя
        int choice;
        
        System.out.println("=== ПРОСТОЙ КАЛЬКУЛЯТОР ===");
        System.out.println("Добро пожаловать! Выберите операцию:");
        
        // ЦИКЛ - СЕРДЦЕ НАШЕЙ ПРОГРАММЫ
        // Будет работать, пока пользователь не выберет выход (5)
        do {
            // ВЫВОД МЕНЮ - пользователь всегда видит доступные опции
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Сложение (+)");
            System.out.println("2. Вычитание (-)");
            System.out.println("3. Умножение (*)");
            System.out.println("4. Деление (/)");
            System.out.println("5. Выход");
            System.out.println("=============");
            
            System.out.print("Ваш выбор (1-5): ");
            
            // Проверяем, что введено число
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                
                // Если выбран не выход - выполняем операцию
                if (choice != 5) {
                    performOperation(choice, scanner);
                } else {
                    System.out.println("Выход из программы. До свидания!");
                }
            } else {
                // Если введён не номер - сообщаем об ошибке
                System.out.println("Ошибка! Введите число от 1 до 5.");
                scanner.next(); // Очищаем некорректный ввод
                choice = 0; // Устанавливаем неверный выбор для продолжения цикла
            }
            
        } while (choice != 5); // Условие продолжения цикла
        
        // Закрываем Scanner - важно освобождать ресурсы!
        scanner.close();
    }
    
    /**
     * Выполняет выбранную арифметическую операцию
     * @param operation - номер операции (1-4)
     * @param scanner - объект Scanner для чтения ввода
     */
    private static void performOperation(int operation, Scanner scanner) {
        double num1, num2;
        double result = 0;
        
        // Запрашиваем два числа для операции
        System.out.print("Введите первое число: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка! Введите число.");
            scanner.next(); // Очищаем некорректный ввод
            System.out.print("Введите первое число: ");
        }
        num1 = scanner.nextDouble();
        
        System.out.print("Введите второе число: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка! Введите число.");
            scanner.next(); // Очищаем некорректный ввод
            System.out.print("Введите второе число: ");
        }
        num2 = scanner.nextDouble();
        
        // ВЫПОЛНЕНИЕ ОПЕРАЦИИ
        // Используем switch для выбора операции
        switch (operation) {
            case 1: // СЛОЖЕНИЕ
                result = num1 + num2;
                System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, result);
                break;
                
            case 2: // ВЫЧИТАНИЕ
                result = num1 - num2;
                System.out.printf("%.2f - %.2f = %.2f\n", num1, num2, result);
                break;
                
            case 3: // УМНОЖЕНИЕ
                result = num1 * num2;
                System.out.printf("%.2f * %.2f = %.2f\n", num1, num2, result);
                break;
                
            case 4: // ДЕЛЕНИЕ
                // ОСОБЫЙ СЛУЧАЙ: деление на ноль
                if (num2 == 0) {
                    System.out.println("Ошибка! Деление на ноль невозможно.");
                } else {
                    result = num1 / num2;
                    System.out.printf("%.2f / %.2f = %.2f\n", num1, num2, result);
                }
                break;
                
            default:
                System.out.println("Неизвестная операция.");
        }
    }
    
    /**
     * Альтернативная версия с более продвинутой обработкой ошибок
     * @param operation - номер операции
     * @param num1 - первое число
     * @param num2 - второе число
     * @return результат операции или Double.NaN при ошибке
     */
    public static double calculate(int operation, double num1, double num2) {
        switch (operation) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                    return Double.NaN; // Special value: Not a Number
                }
            default:
                System.out.println("Неверная операция!");
                return Double.NaN;
        }
    }
}