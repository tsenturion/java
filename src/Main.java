import java.util.Arrays;
import java.util.List;

// Абстрактный базовый класс
abstract class Shape {
    public abstract void draw(); // Абстрактный метод - у фигуры нет реализации по умолчанию
}

// Классы-наследники
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Рисую круг"); // Реализация метода draw для круга
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Рисую квадрат"); // Реализация метода draw для квадрата
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Рисую треугольник"); // Реализация метода draw для треугольника
    }
}

// Главный класс с точкой входа
public class Main {
    public static void main(String[] args) {
        // Создание списка фигур разных типов
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());

        System.out.println("=== Художественная студия ===");
        // Проход по всем фигурам в списке
        for (Shape shape : shapes) {
            shape.draw(); // Динамическое связывание: для каждого объекта вызовется свой draw()
        }

        // Дополнительная демонстрация полиморфизма
        System.out.println("\n=== Отдельные фигуры ===");
        Shape shape1 = new Circle();   // Circle хранится в переменной типа Shape
        Shape shape2 = new Square();   // Square хранится в переменной типа Shape
        Shape shape3 = new Triangle(); // Triangle хранится в переменной типа Shape
        
        shape1.draw(); // Вызовется draw() из Circle
        shape2.draw(); // Вызовется draw() из Square
        shape3.draw(); // Вызовется draw() из Triangle
    }
}