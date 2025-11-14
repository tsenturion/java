import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Создание списка имен
        List<String> names = new ArrayList<>();
        names.add("Мария");
        names.add("Анна");
        names.add("Иван");
        names.add("Петр");
        names.add("Ольга");

        System.out.println("Исходный список:");
        System.out.println(names);

        // Сортировка с использованием лямбда-выражения
        names.sort((s1, s2) -> s1.compareTo(s2));

        System.out.println("\nОтсортированный список:");
        System.out.println(names);

        // Альтернативные способы сортировки:
        
        // 1. С использованием ссылки на метод
        System.out.println("\nСортировка через ссылку на метод:");
        List<String> names2 = new ArrayList<>(names);
        names2.sort(String::compareTo);
        System.out.println(names2);

        // 2. С использованием Comparator.naturalOrder()
        System.out.println("\nСортировка через Comparator.naturalOrder():");
        List<String> names3 = new ArrayList<>(names);
        names3.sort(Comparator.naturalOrder());
        System.out.println(names3);

        // 3. Обратная сортировка
        System.out.println("\nОбратная сортировка:");
        List<String> names4 = new ArrayList<>(names);
        names4.sort(Comparator.reverseOrder());
        System.out.println(names4);

        // 4. Сортировка по длине строки
        System.out.println("\nСортировка по длине строки:");
        List<String> names5 = new ArrayList<>(names);
        names5.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(names5);
    }
}