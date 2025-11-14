import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Создание списка из элементов
        List<String> list = Arrays.asList("a", "b", "c");
        
        // Создание потока из списка
        Stream<String> streamFromList = list.stream(); // Поток создан!
        
        System.out.println("Элементы потока:");
        // Вывод элементов потока с помощью forEach
        streamFromList.forEach(element -> System.out.println(element));
        
        // Дополнительные примеры работы с потоками:
        
        System.out.println("\n=== Фильтрация и преобразование ===");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        // Фильтрация слов длиннее 4 символов и преобразование в верхний регистр
        words.stream()
             .filter(word -> word.length() > 4)        // промежуточная операция - фильтрация
             .map(String::toUpperCase)                 // промежуточная операция - преобразование
             .forEach(System.out::println);            // терминальная операция - вывод
        
        System.out.println("\n=== Подсчет элементов ===");
        long count = words.stream()
                         .filter(word -> word.contains("a")) // слова содержащие 'a'
                         .count();                          // терминальная операция - подсчет
        System.out.println("Слов содержащих 'a': " + count);
        
        System.out.println("\n=== Создание потока из значений ===");
        // Создание потока напрямую из значений
        Stream<String> directStream = Stream.of("x", "y", "z");
        directStream.forEach(System.out::println);
    }
}