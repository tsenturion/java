class ColliderUtil {
    
    // Публичный метод — виден снаружи
    public boolean checkCollision(int x1, int y1, int x2, int y2) {
        int distance = calculateDistance(x1, y1, x2, y2); // вызов приватного метода
        return distance < 10; // возврат результата проверки столкновения
    }

    // Приватный метод — только для внутреннего использования
    private int calculateDistance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2; // вычисление разности по X
        int dy = y1 - y2; // вычисление разности по Y
        return (int) Math.sqrt(dx * dx + dy * dy); // вычисление и возврат расстояния
    }
}

public class Main {
    public static void main(String[] args) {
        ColliderUtil collider = new ColliderUtil(); // создание объекта ColliderUtil
        
        // Проверка столкновения между двумя точками
        boolean collision1 = collider.checkCollision(0, 0, 5, 5); // точки близко - столкновение
        boolean collision2 = collider.checkCollision(0, 0, 20, 20); // точки далеко - нет столкновения
        
        System.out.println("Столкновение (0,0) и (5,5): " + collision1); // вывод результата
        System.out.println("Столкновение (0,0) и (20,20): " + collision2); // вывод результата
    }
}