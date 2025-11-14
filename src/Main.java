import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Создание потока напрямую из значений
        Stream<String> streamOfValues = Stream.of("a", "b", "c"); // Поток создан из значений!
        
        System.out.println("Элементы потока из значений:");
        // Вывод элементов потока
        streamOfValues.forEach(element -> System.out.println(element));
        
        // Дополнительные примеры создания потоков из значений:
        
        System.out.println("\n=== Поток чисел ===");
        // Создание потока чисел
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);
        numberStream.filter(n -> n > 2)
                   .forEach(n -> System.out.println("Число > 2: " + n));
        
        System.out.println("\n=== Поток разных типов ===");
        // Stream.of() может принимать разные типы, но должен быть однородным
        Stream<String> mixedStream = Stream.of("Java", "Stream", "API", "Example");
        mixedStream.map(String::length)
                  .forEach(len -> System.out.println("Длина слова: " + len));
        
        System.out.println("\n=== Пустой поток ===");
        // Создание пустого потока
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Количество элементов в пустом потоке: " + emptyStream.count());
        
        System.out.println("\n=== Поток из одного элемента ===");
        // Поток с одним элементом
        Stream<String> singleElementStream = Stream.of("Один элемент");
        singleElementStream.forEach(System.out::println);
        
        System.out.println("\n=== Конкатенация потоков ===");
        // Объединение нескольких потоков
        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("X", "Y", "Z");
        Stream<String> concatenated = Stream.concat(stream1, stream2);
        concatenated.forEach(System.out::println);
    }
}