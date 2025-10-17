class Message {
    // Приватное поле text - защищено от прямого доступа извне
    private String text;

    // Геттер для получения значения text (чтение)
    public String getText() {
        return text; // возвращает значение поля text
    }

    // Сеттер для установки значения text (запись)
    public void setText(String newText) {
        this.text = newText; // устанавливает новое значение для поля text
    }
}

// Класс для демонстрации работы
public class Main {
    public static void main(String[] args) {
        Message message = new Message(); // создание объекта Message
        
        message.setText("Hello, World!"); // установка текста через сеттер
        String text = message.getText(); // получение текста через геттер
        
        System.out.println("Текст сообщения: " + text); // вывод текста
    }
}