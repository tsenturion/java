import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Анна", "Иван", "Мария", "Пётр", "Яна");
        
        System.out.println("Исходный список имен: " + names);
        
        // Фильтрация имен длиннее 4 символов и сбор в новый список
        List<String> longNames = names.stream()
            .filter(name -> name.length() > 4) // Оставляем имена длиннее 4 символов
            .collect(Collectors.toList());     // Собираем результат в новый List
        
        System.out.println("Имена длиннее 4 символов: " + longNames);
        
        // Дополнительные примеры с collect():
        
        System.out.println("\n=== Имена, начинающиеся на 'А' ===");
        List<String> namesStartingWithA = names.stream()
            .filter(name -> name.startsWith("А"))
            .collect(Collectors.toList());
        System.out.println("Имена на 'А': " + namesStartingWithA);
        
        System.out.println("\n=== Имена в верхнем регистре ===");
        List<String> upperCaseNames = names.stream()
            .map(String::toUpperCase)  // Преобразуем в верхний регистр
            .collect(Collectors.toList());
        System.out.println("Имена в верхнем регистре: " + upperCaseNames);
        
        System.out.println("\n=== Длины имен ===");
        List<Integer> nameLengths = names.stream()
            .map(String::length)      // Преобразуем в длины строк
            .collect(Collectors.toList());
        System.out.println("Длины имен: " + nameLengths);
        
        System.out.println("\n=== Уникальные длины имен ===");
        List<Integer> uniqueLengths = names.stream()
            .map(String::length)
            .distinct()               // Убираем дубликаты
            .collect(Collectors.toList());
        System.out.println("Уникальные длины: " + uniqueLengths);
        
        System.out.println("\n=== Сортировка имен ===");
        List<String> sortedNames = names.stream()
            .sorted()                 // Сортировка по умолчанию (алфавитная)
            .collect(Collectors.toList());
        System.out.println("Отсортированные имена: " + sortedNames);
    }
}