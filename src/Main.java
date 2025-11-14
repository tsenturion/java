import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        System.out.println("Исходный список: " + numbers);
        
        // Пошаговая обработка потока
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 1) // 1) Оставляем нечетные числа: 1, 3, 5
                .map(n -> n * 10)        // 2) Умножаем на 10: 10, 30, 50
                .collect(Collectors.toList()); // Собираем в список
        
        System.out.println("Результат: " + result);
        
        // Детальное объяснение каждого шага:
        System.out.println("\n=== Детальный разбор ===");
        
        System.out.println("1. Исходный список: " + numbers);
        
        System.out.println("2. После filter(n -> n % 2 == 1):");
        System.out.println("   - Остаются нечетные числа: 1, 3, 5");
        System.out.println("   - Четные числа (2, 4) отфильтровываются");
        
        System.out.println("3. После map(n -> n * 10):");
        System.out.println("   - 1 → 1 * 10 = 10");
        System.out.println("   - 3 → 3 * 10 = 30");
        System.out.println("   - 5 → 5 * 10 = 50");
        
        System.out.println("4. После collect(Collectors.toList()):");
        System.out.println("   - Собираем в новый список: [10, 30, 50]");
        
        // Визуализация потока данных
        System.out.println("\n=== Визуализация потока ===");
        System.out.println("Исходный:  [1,    2,    3,    4,    5]");
        System.out.println("Filter:    [1,    -,    3,    -,    5]  (n % 2 == 1)");
        System.out.println("Map:       [10,   -,    30,   -,    50] (n * 10)");
        System.out.println("Результат: [10, 30, 50]");
        
        // Дополнительная проверка
        System.out.println("\n=== Проверка результата ===");
        System.out.println("Количество элементов в результате: " + result.size());
        System.out.println("Первый элемент: " + result.get(0));
        System.out.println("Последний элемент: " + result.get(result.size() - 1));
    }
}