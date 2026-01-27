import java.util.Scanner;

/**
 * Программа-конвертер валют: переводит сумму из рублей в доллары
 * по заданному курсу.
 * 
 * Особенности:
 * - Принимает сумму в рублях и курс доллара
 * - Выполняет конвертацию
 * - Выводит результат с двумя знаками после запятой
 */
public class CurrencyConverter {

    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== КОНВЕРТЕР ВАЛЮТ РУБЛИ → ДОЛЛАРЫ ===");
        System.out.println();
        
        // Запрашиваем у пользователя сумму в рублях
        System.out.print("Введите сумму в рублях: ");
        double rubles = scanner.nextDouble();
        
        // Запрашиваем курс доллара (сколько рублей стоит 1 доллар)
        System.out.print("Введите курс доллара (рублей за 1 доллар): ");
        double exchangeRate = scanner.nextDouble();
        
        // Проверяем корректность введенных данных
        if (rubles < 0) {
            System.out.println("Ошибка: сумма не может быть отрицательной!");
            return; // Завершаем программу
        }
        
        if (exchangeRate <= 0) {
            System.out.println("Ошибка: курс должен быть положительным числом!");
            return; // Завершаем программу
        }
        
        // Выполняем конвертацию: делим сумму в рублях на курс
        double dollars = rubles / exchangeRate;
        
        System.out.println();
        System.out.println("=== РЕЗУЛЬТАТ КОНВЕРТАЦИИ ===");
        
        // Выводим результат с двумя знаками после запятой
        // Используем форматирование строк для контроля вывода
        System.out.printf("Сумма в рублях: %.2f руб.\n", rubles);
        System.out.printf("Курс доллара: %.2f руб./$\n", exchangeRate);
        System.out.printf("Сумма в долларах: $%.2f\n", dollars);
        
        // Закрываем Scanner для освобождения ресурсов
        scanner.close();
        
        // Дополнительная информация для пользователя
        System.out.println();
        System.out.println("Для конвертации использована формула:");
        System.out.println("Доллары = Рубли / Курс_доллара");
        System.out.println("Где курс доллара - сколько рублей стоит 1 доллар");
    }
    
    /**
     * Альтернативная версия метода конвертации для повторного использования
     * @param rubles - сумма в рублях
     * @param exchangeRate - курс доллара (рублей за 1 доллар)
     * @return сумма в долларах с округлением до 2 знаков после запятой
     */
    public static double convertRublesToDollars(double rubles, double exchangeRate) {
        if (rubles < 0 || exchangeRate <= 0) {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
        double dollars = rubles / exchangeRate;
        // Округляем до 2 знаков после запятой
        return Math.round(dollars * 100.0) / 100.0;
    }
}