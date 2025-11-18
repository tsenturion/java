//Используя Stream API, напишите цепочку операторов, чтобы получить список этих строк, преобразованных к верхнему регистру.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Исходный список имен
        List<String> names = Arrays.asList("анна", "иван", "мария", "пётр", "яна");
        
        System.out.println("Исходный список имен: " + names);
        
        // Преобразование имен в верхний регистр
        List<String> upperCaseNames = names.stream()
                                          .map(String::toUpperCase)
                                          .collect(Collectors.toList());
        
        System.out.println("Имена в верхнем регистре: " + upperCaseNames);
        
        // Дополнительные примеры преобразований:
        
        System.out.println("\n=== Различные преобразования строк ===");
        
        // Добавление приставки к каждому имени
        List<String> namesWithPrefix = names.stream()
                                           .map(name -> "Студент: " + name)
                                           .collect(Collectors.toList());
        System.out.println("Имена с приставкой: " + namesWithPrefix);
        
        // Преобразование в длину строк
        List<Integer> nameLengths = names.stream()
                                        .map(String::length)
                                        .collect(Collectors.toList());
        System.out.println("Длины имен: " + nameLengths);
        
        // Комплексное преобразование - имя + длина
        List<String> namesWithLength = names.stream()
                                           .map(name -> name + " (" + name.length() + " букв)")
                                           .collect(Collectors.toList());
        System.out.println("Имена с указанием длины: " + namesWithLength);
        
        // Цепочка преобразований
        System.out.println("\n=== Цепочка преобразований ===");
        List<String> complexTransform = names.stream()
                                            .map(String::toUpperCase)        // в верхний регистр
                                            .map(name -> name + "!")         // добавляем восклицательный знак
                                            .map(name -> ">> " + name)       // добавляем префикс
                                            .collect(Collectors.toList());
        System.out.println("Цепочка преобразований: " + complexTransform);
        
        // Сравнение исходного и преобразованного списков
        System.out.println("\n=== Сравнение списков ===");
        System.out.println("Исходный список: " + names);
        System.out.println("Преобразованный список: " + upperCaseNames);
        System.out.println("Исходный список не изменился: " + (names != upperCaseNames));
        
        // Работа с пустым списком
        System.out.println("\n=== Работа с пустым списком ===");
        List<String> emptyList = Arrays.asList();
        List<String> emptyResult = emptyList.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());
        System.out.println("Пустой исходный список: " + emptyList);
        System.out.println("Результат для пустого списка: " + emptyResult);
    }
}

