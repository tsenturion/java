class CatPrivate {
    private String name;  // Поле скрыто (инкапсуляция)
    private int age;      // Поле скрыто (инкапсуляция)

    // Сеттер для имени
    public void setName(String newName) {
        name = newName; // установка значения имени
    }

    // Сеттер для возраста с проверкой
    public void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge; // установка возраста если значение корректно
        } else {
            System.out.println("Возраст не может быть отрицательным!"); // сообщение об ошибке
        }
    }

    // Геттеры для получения значений
    public String getName() {
        return name; // возврат значения имени
    }

    public int getAge() {
        return age; // возврат значения возраста
    }
}

public class Main {
    public static void main(String[] args) {
        CatPrivate cat = new CatPrivate(); // создание объекта CatPrivate
        cat.setName("Мурка");              // установка имени через сеттер
        cat.setAge(-3); // проверка отработает - возраст не установится
        System.out.println(cat.getName() + " " + cat.getAge()); // вывод данных через геттеры
    }
}