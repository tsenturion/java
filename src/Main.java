import java.util.Arrays;
import java.util.List;

class Person {
    private String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void introduce() {
        System.out.println("Привет, меня зовут " + name + ", мне " + age + " лет.");
    }
}

class Student extends Person {
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public void introduce() {
        System.out.println("Я студент " + getName() + ", мой номер студенческого: " + studentId + ".");
    }
}

class Teacher extends Person {
    private String department;

    public Teacher(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void introduce() {
        System.out.println("Я преподаватель " + getName() + ", кафедра " + department + ".");
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем полиморфный список людей университета
        List<Person> people = Arrays.asList(
            new Student("Анна", 20, "A123"),
            new Teacher("Игорь Петрович", 55, "Математика"),
            new Student("Максим", 21, "B456")
        );

        System.out.println("=== Полиморфизм в действии ===");
        // Проходим по всем людям в списке
        for (Person person : people) {
            person.introduce(); // Вызываем метод introduce() для каждого объекта
        }

        // Демонстрация полиморфизма с отдельными переменными
        System.out.println("\n=== Отдельные полиморфные переменные ===");
        Person person1 = new Student("Елена", 19, "C789");
        Person person2 = new Teacher("Сергей Владимирович", 42, "Физика");
        
        person1.introduce(); // Будет вызван метод из класса Student
        person2.introduce(); // Будет вызван метод из класса Teacher
    }
}