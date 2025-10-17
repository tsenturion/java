//создать класс Teacher, наследующий от Person, с полем department и правильным конструктором
class Person {
    private String name;
    protected int age;
    public String hobby;

    public Person(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void introduce() {
        System.out.println("My name is " + name + ". I am " + age + " years old. My hobby is " + hobby);
    }
}

class Student extends Person {
    String studentId;
    public Student(String name, int age, String hobby, String studentId) {
        super(name, age, hobby);
        this.studentId = studentId;
    }

    public void study() {
        System.out.println(getName() + " is studying." + " Student ID: " + studentId + ".");
    }
}

class Teacher extends Person {
    String department;

    public Teacher(String name, int age, String hobby, String department) {
        super(name, age, hobby);
        this.department = department;
    }

    public void teach() {
        System.out.println(getName() + " is teaching." + " Department: " + department + ".");
    }
}