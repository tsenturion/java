class Person {
    String name; // поле для имени
    int age;     // поле для возраста

    public void introduce() {
        System.out.println("Привет, меня зовут " + name + ", мне " + age + " лет."); // вывод приветствия
    }
}

// Класс-наследник Student
class Student extends Person {
    String studentId; // собственное свойство студента - номер студенческого билета

    public void study() {
        System.out.println(name + " усердно учится."); // использование унаследованного поля name
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student(); // создание объекта Student
        student.name = "Анна";           // установка унаследованного поля name
        student.age = 20;                // установка унаследованного поля age
        student.studentId = "ST12345";   // установка собственного поля studentId
        
        student.introduce(); // вызов унаследованного метода
        student.study();     // вызов собственного метода
    }
}