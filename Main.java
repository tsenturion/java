class Person {
    String name; // Поле для хранения имени

    // Метод для вывода информации
    void displayInfo() {
        System.out.println("Имя: " + name); // Вывод имени на экран
    }
}

public class Main {
    // Точка входа для проверки
    public static void main(String[] args) {
        Person p1 = new Person(); // Создаем объект класса Person
        p1.name = "Иван";         // Присваиваем значение полю name
        p1.displayInfo();         // Вызываем метод для вывода информации
    }
}