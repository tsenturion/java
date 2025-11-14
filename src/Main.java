import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Анна", "Иван", "Мария");
        
        System.out.println("Исходный список имен: " + names);
        
        // Преобразование каждого имени в его длину
        List<Integer> nameLengths = names.stream()
            .map(String::length) // Преобразуем каждое имя в его длину (String -> Integer)
            .collect(Collectors.toList());
        
        System.out.println("Длины имен: " + nameLengths);
        
        // Дополнительные примеры с map():
        
        System.out.println("\n=== Имена в верхнем регистре ===");
        List<String> upperCaseNames = names.stream()
            .map(String::toUpperCase) // Преобразуем в верхний регистр
            .collect(Collectors.toList());
        System.out.println("Имена в верхнем регистре: " + upperCaseNames);
        
        System.out.println("\n=== Первые буквы имен ===");
        List<Character> firstLetters = names.stream()
            .map(name -> name.charAt(0)) // Берем первую букву каждого имени
            .collect(Collectors.toList());
        System.out.println("Первые буквы: " + firstLetters);
        
        System.out.println("\n=== Имена с указанием длины ===");
        List<String> namesWithLength = names.stream()
            .map(name -> name + " (" + name.length() + " букв)") // Добавляем информацию о длине
            .collect(Collectors.toList());
        System.out.println("Имена с длиной: " + namesWithLength);
        
        System.out.println("\n=== Числовые преобразования ===");
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> integers = numbers.stream()
            .map(Integer::parseInt) // Преобразуем строки в числа
            .collect(Collectors.toList());
        System.out.println("Строки: " + numbers);
        System.out.println("Числа: " + integers);
        
        System.out.println("\n=== Комбинация map и filter ===");
        List<String> longNames = names.stream()
            .map(String::toUpperCase)        // Сначала преобразуем
            .filter(name -> name.length() > 4) // Затем фильтруем
            .collect(Collectors.toList());
        System.out.println("Длинные имена в верхнем регистре: " + longNames);
    }
}