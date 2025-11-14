import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Анна", "Иван", "Мария", "Пётр", "Яна");
        
        System.out.println("Исходный список имен: " + names);
        
        // Сортировка по длине имени (от короткого к длинному)
        List<String> sortedNames = names.stream()
            .sorted((name1, name2) -> name1.length() - name2.length()) // Сортируем по длине имени
            .collect(Collectors.toList());
        
        System.out.println("Сортировка по длине (короткие -> длинные): " + sortedNames);
        
        // Дополнительные примеры с sorted():
        
        System.out.println("\n=== Сортировка по длине (длинные -> короткие) ===");
        List<String> sortedDescByLength = names.stream()
            .sorted((name1, name2) -> name2.length() - name1.length()) // Обратный порядок
            .collect(Collectors.toList());
        System.out.println("Сортировка по длине (длинные -> короткие): " + sortedDescByLength);
        
        System.out.println("\n=== Естественная сортировка (алфавитная) ===");
        List<String> alphabeticallySorted = names.stream()
            .sorted() // Естественный порядок для строк - алфавитный
            .collect(Collectors.toList());
        System.out.println("Алфавитная сортировка: " + alphabeticallySorted);
        
        System.out.println("\n=== Обратная алфавитная сортировка ===");
        List<String> reverseAlphabetical = names.stream()
            .sorted((a, b) -> b.compareTo(a)) // Обратный алфавитный порядок
            .collect(Collectors.toList());
        System.out.println("Обратная алфавитная сортировка: " + reverseAlphabetical);
        
        System.out.println("\n=== Комплексная сортировка (сначала по длине, затем по алфавиту) ===");
        List<String> complexSorted = names.stream()
            .sorted((name1, name2) -> {
                // Сначала сравниваем по длине
                int lengthCompare = name1.length() - name2.length();
                // Если длины равны, сравниваем по алфавиту
                return lengthCompare != 0 ? lengthCompare : name1.compareTo(name2);
            })
            .collect(Collectors.toList());
        System.out.println("Сначала по длине, затем по алфавиту: " + complexSorted);
        
        System.out.println("\n=== Сортировка с использованием Comparator.comparing ===");
        List<String> sortedWithComparator = names.stream()
            .sorted(java.util.Comparator.comparing(String::length)) // Более читаемый способ
            .collect(Collectors.toList());
        System.out.println("Сортировка через Comparator.comparing: " + sortedWithComparator);
    }
}