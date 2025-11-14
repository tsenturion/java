import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double averageGrade;
    
    // Конструктор
    public Student(String name, int age, double averageGrade) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }
    
    // Геттеры
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getAverageGrade() {
        return averageGrade;
    }
    
    // Для красивого вывода
    @Override
    public String toString() {
        return name + " (возраст: " + age + ", средний балл: " + averageGrade + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание списка студентов
        List<Student> students = Arrays.asList(
            new Student("Анна", 20, 4.8),
            new Student("Иван", 22, 3.9),  // Не подходит по среднему баллу
            new Student("Мария", 19, 4.5), // Не подходит по возрасту
            new Student("Пётр", 21, 4.2),
            new Student("Ольга", 20, 4.9)
        );
        
        System.out.println("Все студенты:");
        students.forEach(System.out::println);
        
        // Обработка потока студентов
        List<String> resultNames = students.stream()
            .filter(student -> student.getAge() >= 20)           // Шаг 1: Фильтрация по возрасту
            .filter(student -> student.getAverageGrade() > 4.0)  // Шаг 2: Фильтрация по среднему баллу
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName())) // Шаг 3: Сортировка по имени
            .map(Student::getName)                               // Шаг 4: Преобразование в имена
            .collect(Collectors.toList());                       // Шаг 5: Сбор результатов
        
        System.out.println("\n=== Результат обработки ===");
        System.out.println("Имена студентов (возраст ≥ 20, средний балл > 4.0, отсортированы по алфавиту):");
        System.out.println(resultNames);
        
        // Детальный разбор процесса
        System.out.println("\n=== Детальный разбор процесса ===");
        
        System.out.println("1. Исходный список: 5 студентов");
        
        System.out.println("2. После filter(age >= 20):");
        students.stream()
            .filter(student -> student.getAge() >= 20)
            .forEach(s -> System.out.println("   - " + s.getName() + " (возраст: " + s.getAge() + ")"));
        
        System.out.println("3. После filter(grade > 4.0):");
        students.stream()
            .filter(student -> student.getAge() >= 20)
            .filter(student -> student.getAverageGrade() > 4.0)
            .forEach(s -> System.out.println("   - " + s.getName() + " (балл: " + s.getAverageGrade() + ")"));
        
        System.out.println("4. После sorted(по имени) и map(в имена):");
        System.out.println("   - Отсортированные имена: " + resultNames);
        
        // Альтернативный вариант с одним фильтром
        System.out.println("\n=== Альтернативный вариант (один фильтр) ===");
        List<String> alternativeResult = students.stream()
            .filter(student -> student.getAge() >= 20 && student.getAverageGrade() > 4.0)
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
            .map(Student::getName)
            .collect(Collectors.toList());
        
        System.out.println("Результат (один фильтр): " + alternativeResult);
        
        // Сравнение двух подходов
        System.out.println("\n=== Сравнение подходов ===");
        System.out.println("Два фильтра: " + resultNames);
        System.out.println("Один фильтр: " + alternativeResult);
        System.out.println("Результаты идентичны: " + resultNames.equals(alternativeResult));
    }
}