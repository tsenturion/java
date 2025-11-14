import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание списка чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Исходный список чисел: " + numbers);
        System.out.println("\nЧетные числа из списка:");
        
        // Фильтрация четных чисел и вывод
        numbers.stream()
               .filter(n -> n % 2 == 0)          // промежуточная операция - фильтрация
               .forEach(System.out::println);     // терминальная операция - вывод
        
        // Дополнительные примеры с filter():
        
        System.out.println("\n=== Числа больше 5 ===");
        numbers.stream()
               .filter(n -> n > 5)
               .forEach(n -> System.out.println("Число > 5: " + n));
        
        System.out.println("\n=== Нечетные числа ===");
        numbers.stream()
               .filter(n -> n % 2 != 0)
               .forEach(System.out::println);
        
        System.out.println("\n=== Числа от 3 до 8 ===");
        numbers.stream()
               .filter(n -> n >= 3 && n <= 8)
               .forEach(n -> System.out.println("Число в диапазоне: " + n));
        
        System.out.println("\n=== Комбинированные операции ===");
        // Фильтрация + преобразование
        numbers.stream()
               .filter(n -> n % 2 == 0)          // только четные
               .map(n -> n * n)                  // возведение в квадрат
               .forEach(n -> System.out.println("Квадрат четного числа: " + n));
        
        System.out.println("\n=== Подсчет отфильтрованных элементов ===");
        long evenCount = numbers.stream()
                               .filter(n -> n % 2 == 0)
                               .count();
        System.out.println("Количество четных чисел: " + evenCount);
    }
}