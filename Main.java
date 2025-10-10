class CatPublic {
    String name;   // Имя кошки
    int age;       // Возраст
}

public class Main {
    public static void main(String[] args) {
        CatPublic cat = new CatPublic(); // Создание объекта класса CatPublic
        cat.name = "Мурзик";             // Установка имени кошки
        cat.age = -5; // Ошибка! Отрицательный возраст (логическая ошибка)
        System.out.println(cat.name + " " + cat.age); // Вывод имени и возраста
    }
}