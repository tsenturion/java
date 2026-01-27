/**
 * Класс Book представляет книгу в библиотеке.
 * Это наш первый настоящий класс с полями и методами!
 * 
 * Ключевые концепции:
 * - Поля класса (атрибуты объекта)
 * - Конструктор для инициализации объекта
 * - Методы getter/setter для доступа к полям
 * - Инкапсуляция (скрытие деталей реализации)
 */
public class Book {
    // ПОЛЯ КЛАССА - характеристики книги
    // private означает, что доступ к полям возможен только внутри класса
    // Это принцип инкапсуляции - скрытие данных
    private String title;      // Название книги
    private String author;     // Автор
    private int year;          // Год издания
    private boolean isAvailable; // Доступна ли для выдачи
    
    /**
     * КОНСТРУКТОР - специальный метод для создания объектов
     * Вызывается при создании нового объекта через new Book(...)
     * 
     * @param title  название книги
     * @param author автор книги
     * @param year   год издания
     */
    public Book(String title, String author, int year) {
        this.title = title;       // this.title - поле объекта
        this.author = author;     // title - параметр конструктора
        this.year = year;
        this.isAvailable = true;  // Новая книга всегда доступна
    }
    
    // МЕТОДЫ GETTER (получить значение поля)
    // Позволяют безопасно получать значения полей
    
    /**
     * @return название книги
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * @return год издания
     */
    public int getYear() {
        return year;
    }
    
    /**
     * @return доступна ли книга для выдачи
     */
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // МЕТОДЫ SETTER (установить значение поля)
    // Позволяют безопасно изменять значения полей
    
    /**
     * Устанавливает доступность книги
     * @param available true если книга доступна, false если выдана
     */
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    /**
     * Позволяет взять книгу (выдать читателю)
     * @return true если книга была доступна и успешно выдана
     */
    public boolean borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Книга \"" + title + "\" успешно выдана");
            return true;
        } else {
            System.out.println("Книга \"" + title + "\" уже выдана");
            return false;
        }
    }
    
    /**
     * Позволяет вернуть книгу в библиотеку
     */
    public void returnBook() {
        isAvailable = true;
        System.out.println("Книга \"" + title + "\" возвращена");
    }
    
    /**
     * Метод для вывода информации о книге
     * @return строковое представление книги
     */
    @Override
    public String toString() {
        String status = isAvailable ? "Доступна" : "Выдана";
        return "\"" + title + "\", автор: " + author + 
               ", год: " + year + ", статус: " + status;
    }
    
    /**
     * Дополнительный метод для подробной информации
     */
    public void displayInfo() {
        System.out.println("📚 Информация о книге:");
        System.out.println("   Название: " + title);
        System.out.println("   Автор: " + author);
        System.out.println("   Год издания: " + year);
        System.out.println("   Статус: " + (isAvailable ? "✅ Доступна" : "❌ Выдана"));
    }
}