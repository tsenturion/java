import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Создание массива строк
        String[] array = {"a", "b", "c"};
        
        // Создание потока из массива
        Stream<String> streamFromArray = Arrays.stream(array); // Поток создан из массива!
        
        System.out.println("Элементы потока из массива:");
        // Вывод элементов потока
        streamFromArray.forEach(element -> System.out.println(element));
        
        // Дополнительные примеры работы с потоками из массивов:
        
        System.out.println("\n=== Числовой массив ===");
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Создание потока из числового массива
        Arrays.stream(numbers)
              .filter(n -> n % 2 == 0)    // фильтрация четных чисел
              .forEach(n -> System.out.println("Четное число: " + n));
        
        System.out.println("\n=== Работа с частью массива ===");
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        
        // Создание потока из части массива (с 1 по 3 индекс, не включая 4)
        Arrays.stream(words, 1, 4)        // элементы с индексами 1, 2, 3
              .map(String::toUpperCase)   // преобразование в верхний регистр
              .forEach(System.out::println);
        
        System.out.println("\n=== Подсчет и сумма ===");
        double[] doubles = {1.5, 2.7, 3.1, 4.8};
        
        // Работа с числовыми потоками
        long count = Arrays.stream(doubles).count();
        double sum = Arrays.stream(doubles).sum();
        double average = Arrays.stream(doubles).average().orElse(0.0);
        
        System.out.println("Количество элементов: " + count);
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее: " + average);
    }
}