class Person {
    private String name;   // private - закрыто для всех, кроме самого класса Person
    protected int age;     // protected - доступно внутри пакета и для всех наследников
    public String hobby;   // public - доступно отовсюду

    // Конструктор класса Person
    public Person(String name, int age) {
        this.name = name;   // доступ к private полю изнутри класса
        this.age = age;     // доступ к protected полю изнутри класса
    }

    // Конструктор с hobby
    public Person(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    // Геттер для private поля name
    public String getName() {
        return name; // доступ к private полю изнутри класса
    }

    public void introduce() {
        System.out.println("Привет, меня зовут " + name + ", мне " + age + " лет.");
    }
}

class Teacher extends Person {
    private String department; // приватное поле department для преподавателя

    public Teacher(String name, int age, String department) {
        super(name, age); // вызов конструктора родительского класса Person
        this.department = department; // инициализация собственного поля department
    }

    // Переопределение метода introduce() из родительского класса
    @Override
    public void introduce() {
        System.out.println("Здравствуйте, меня зовут " + getName() + ", я преподаватель кафедры " + department + ".");
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание объекта Teacher
        Teacher teacher = new Teacher("Анна Сергеевна", 35, "Математика");
        
        // Вызов переопределенного метода introduce()
        teacher.introduce(); // будет вызвана версия метода из класса Teacher
        
        // Создание объекта Person для сравнения
        Person person = new Person("Иван", 25);
        person.introduce(); // будет вызвана версия метода из класса Person
    }
}