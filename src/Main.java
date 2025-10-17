class Person {
    private String name;   // private - закрыто для всех, кроме самого класса Person
    protected int age;     // protected - доступно внутри пакета и для всех наследников
    public String hobby;   // public - доступно отовсюду

    // Конструктор класса Person
    public Person(String name, int age, String hobby) {
        this.name = name;   // доступ к private полю изнутри класса
        this.age = age;     // доступ к protected полю изнутри класса
        this.hobby = hobby; // доступ к public полю изнутри класса
    }

    // Геттер для private поля name
    public String getName() {
        return name; // доступ к private полю изнутри класса
    }

    public void introduce() {
        System.out.println("Привет, меня зовут " + name + ", мне " + age + " лет. Мое хобби: " + hobby);
    }
}

class Student extends Person {
    String studentId;

    // Конструктор Student
    public Student(String name, int age, String hobby, String studentId) {
        super(name, age, hobby); // вызов конструктора родительского класса
        this.studentId = studentId;
    }

    public void study() {
        // name - недоступно (private в родительском классе)
        // age - доступно (protected в родительском классе)
        // hobby - доступно (public в родительском классе)
        System.out.println(getName() + " усердно учится. Возраст: " + age + ", Хобби: " + hobby);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Мария", 20, "программирование", "ST12345");
        
        student.introduce(); // вызов унаследованного метода
        student.study();     // вызов собственного метода
        
        // Доступ к полям с разными модификаторами доступа:
        // student.name - недоступно (private)
        // student.age - доступно (protected, но только в том же пакете)
        // student.hobby - доступно (public)
        System.out.println("Хобби студента: " + student.hobby);
        System.out.println("Имя студента: " + student.getName()); // через геттер
    }
}