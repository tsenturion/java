import java.util.ArrayList;

/**
 * Класс Library представляет библиотеку, которая хранит книги.
 * 
 * Ключевые концепции:
 * - Работа с коллекциями (ArrayList)
 * - Управление объектами Book
 * - Реализация бизнес-логики библиотеки
 */
public class Library {
    // Используем ArrayList для хранения книг
    // ArrayList - это динамический массив, который может расти
    private ArrayList<Book> books;
    
    /**
     * Конструктор библиотеки
     */
    public Library() {
        // Инициализируем список книг
        books = new ArrayList<>();
        System.out.println("Библиотека создана!");
    }
    
    /**
     * Добавляет книгу в библиотеку
     * @param book книга для добавления
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Добавлена книга: " + book.getTitle());
    }
    
    /**
     * Добавляет книгу с параметрами (удобный метод)
     * @param title название
     * @param author автор
     * @param year год издания
     */
    public void addBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.add(book);
        System.out.println("Добавлена книга: \"" + title + "\"");
    }
    
    /**
     * Взять книгу из библиотеки
     * @param title название книги
     * @return true если книга была успешно выдана
     */
    public boolean borrowBook(String title) {
        // Ищем книгу по названию
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                // Если нашли книгу, пытаемся её выдать
                return book.borrow();
            }
        }
        // Если книга не найдена
        System.out.println("Книга \"" + title + "\" не найдена в библиотеке");
        return false;
    }
    
    /**
     * Вернуть книгу в библиотеку
     * @param title название книги
     * @return true если книга была успешно возвращена
     */
    public boolean returnBook(String title) {
        // Ищем книгу по названию
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                // Если нашли книгу, возвращаем её
                book.returnBook();
                return true;
            }
        }
        // Если книга не найдена
        System.out.println("Книга \"" + title + "\" не найдена в библиотеке");
        return false;
    }
    
    /**
     * Выводит список всех доступных книг
     */
    public void listAvailableBooks() {
        System.out.println("\n📚 ДОСТУПНЫЕ КНИГИ:");
        
        boolean hasAvailableBooks = false;
        
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("• " + book);
                hasAvailableBooks = true;
            }
        }
        
        if (!hasAvailableBooks) {
            System.out.println("Нет доступных книг. Все книги выданы.");
        }
    }
    
    /**
     * Выводит список всех книг (включая выданные)
     */
    public void listAllBooks() {
        System.out.println("\n📚 ВСЕ КНИГИ В БИБЛИОТЕКЕ (" + books.size() + " шт.):");
        
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
            return;
        }
        
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            String status = book.isAvailable() ? "✅" : "❌";
            System.out.println((i + 1) + ". " + status + " " + book.getTitle() + 
                             " (" + book.getAuthor() + ", " + book.getYear() + ")");
        }
    }
    
    /**
     * Поиск книги по автору
     * @param author автор для поиска
     */
    public void findBooksByAuthor(String author) {
        System.out.println("\n🔍 Поиск книг автора: " + author);
        
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("• " + book);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Книги автора \"" + author + "\" не найдены.");
        }
    }
    
    /**
     * Получить количество книг в библиотеке
     * @return общее количество книг
     */
    public int getTotalBooks() {
        return books.size();
    }
    
    /**
     * Получить количество доступных книг
     * @return количество доступных книг
     */
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Получить книгу по индексу (для тестирования)
     * @param index индекс книги
     * @return книга или null если индекс неверный
     */
    public Book getBook(int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        return null;
    }
}