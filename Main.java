class Message {
    private String text; // приватное поле для хранения текста сообщения

    // Сеттер для установки текста сообщения
    public void setText(String newText) {
        text = newText; // установка нового значения текста
    }

    // Геттер для получения текста сообщения
    public String getText() {
        return text; // возврат текущего значения текста
    }
}

public class Main {
    public static void main(String[] args) {
        Message msg = new Message(); // создание объекта Message
        
        msg.setText("Привет, мир!"); // установка текста через сеттер
        String currentText = msg.getText(); // получение текста через геттер
        
        System.out.println("Текст сообщения: " + currentText); // вывод текста
    }
}