class Person {
    String name; // поле для имени
    int age;     // поле для возраста

    // Конструктор класса Person
    public Person(String name, int age) {
        this.name = name; // инициализация поля name
        this.age = age;   // инициализация поля age
    }

    public void introduce() {
        System.out.println("Привет, меня зовут " + name + ", мне " + age + " лет."); // вывод приветствия
    }
}

class Student extends Person {
    String studentId; // поле для номера студенческого билета

    // Конструктор Student берет на себя ответственность за все поля
    public Student(String name, int age, String studentId) {
        super(name, age); // вызов конструктора родительского класса
        this.studentId = studentId; // инициализация собственного поля
    }

    public void study() {
        System.out.println(name + " усердно учится."); // использование унаследованного поля
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание объекта Student с передачей параметров в конструктор
        Student student = new Student("Иван", 20, "ST12345");
        
        student.introduce(); // вызов унаследованного метода
        student.study();     // вызов собственного метода
        
        // Вывод номера студенческого билета
        System.out.println("Номер студенческого: " + student.studentId);
    }
}