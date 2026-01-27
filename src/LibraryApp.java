import java.util.Scanner;

/**
 * Главное приложение для демонстрации работы библиотеки.
 * 
 * Ключевые концепции:
 * - Создание объектов
 * - Взаимодействие между объектами
 * - Пользовательский интерфейс
 */
public class LibraryApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        // Добавляем несколько книг для примера
        initializeLibrary(library);
        
        System.out.println("\n=== СИСТЕМА УПРАВЛЕНИЯ БИБЛИОТЕКОЙ ===");
        
        int choice;
        do {
            displayMenu();
            System.out.print("Ваш выбор: ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Очищаем буфер
                
                switch (choice) {
                    case 1:
                        addNewBook(scanner, library);
                        break;
                    case 2:
                        borrowBook(scanner, library);
                        break;
                    case 3:
                        returnBook(scanner, library);
                        break;
                    case 4:
                        library.listAvailableBooks();
                        break;
                    case 5:
                        library.listAllBooks();
                        break;
                    case 6:
                        searchByAuthor(scanner, library);
                        break;
                    case 7:
                        showStatistics(library);
                        break;
                    case 0:
                        System.out.println("Выход из программы...");
                        break;
                    default:
                        System.out.println("Неверный выбор!");
                }
            } else {
                System.out.println("Пожалуйста, введите число!");
                scanner.next();
                choice = -1;
            }
            
            System.out.println();
            
        } while (choice != 0);
        
        scanner.close();
    }
    
    /**
     * Инициализация библиотеки начальными книгами
     */
    private static void initializeLibrary(Library library) {
        System.out.println("Инициализация библиотеки...");
        
        library.addBook("Мастер и Маргарита", "Михаил Булгаков", 1966);
        library.addBook("Преступление и наказание", "Фёдор Достоевский", 1866);
        library.addBook("Война и мир", "Лев Толстой", 1869);
        library.addBook("1984", "Джордж Оруэлл", 1949);
        library.addBook("Гарри Поттер и философский камень", "Джоан Роулинг", 1997);
    }
    
    /**
     * Отображение меню
     */
    private static void displayMenu() {
        System.out.println("\n══════════ МЕНЮ ══════════");
        System.out.println("1. 📖 Добавить книгу");
        System.out.println("2. 📚 Взять книгу");
        System.out.println("3. ↩️  Вернуть книгу");
        System.out.println("4. 📋 Список доступных книг");
        System.out.println("5. 📒 Список всех книг");
        System.out.println("6. 🔍 Найти книги по автору");
        System.out.println("7. 📊 Статистика");
        System.out.println("0. 🚪 Выход");
        System.out.println("══════════════════════════");
    }
    
    /**
     * Добавление новой книги
     */
    private static void addNewBook(Scanner scanner, Library library) {
        System.out.println("\n📖 ДОБАВЛЕНИЕ НОВОЙ КНИГИ");
        
        System.out.print("Название: ");
        String title = scanner.nextLine();
        
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        
        System.out.print("Год издания: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер
        
        library.addBook(title, author, year);
    }
    
    /**
     * Взятие книги
     */
    private static void borrowBook(Scanner scanner, Library library) {
        System.out.println("\n📚 ВЗЯТИЕ КНИГИ");
        
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        
        library.borrowBook(title);
    }
    
    /**
     * Возврат книги
     */
    private static void returnBook(Scanner scanner, Library library) {
        System.out.println("\n↩️  ВОЗВРАТ КНИГИ");
        
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        
        library.returnBook(title);
    }
    
    /**
     * Поиск книг по автору
     */
    private static void searchByAuthor(Scanner scanner, Library library) {
        System.out.println("\n🔍 ПОИСК КНИГ ПО АВТОРУ");
        
        System.out.print("Введите имя автора: ");
        String author = scanner.nextLine();
        
        library.findBooksByAuthor(author);
    }
    
    /**
     * Показ статистики
     */
    private static void showStatistics(Library library) {
        System.out.println("\n📊 СТАТИСТИКА БИБЛИОТЕКИ");
        System.out.println("Всего книг: " + library.getTotalBooks());
        System.out.println("Доступно: " + library.getAvailableBooksCount());
        System.out.println("Выдано: " + (library.getTotalBooks() - library.getAvailableBooksCount()));
        
        // Пример работы с конкретной книгой
        Book book = library.getBook(0);
        if (book != null) {
            System.out.println("\nПример книги:");
            book.displayInfo();
        }
    }
}