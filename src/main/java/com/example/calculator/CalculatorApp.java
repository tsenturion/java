package com.example.calculator;

import java.util.Scanner;

/**
 * Главный класс приложения калькулятора.
 * Предоставляет консольный интерфейс для взаимодействия с пользователем.
 */
public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Калькулятор ===");
        System.out.println("Доступные операции:");
        System.out.println("1. Сложение (+)");
        System.out.println("2. Вычитание (-)");
        System.out.println("3. Умножение (*)");
        System.out.println("4. Деление (/)");
        System.out.println("5. Возведение в степень (^)");
        System.out.println("6. Факториал (!)");
        System.out.println("0. Выход");
        
        while (true) {
            System.out.print("\nВыберите операцию (0-6): ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                System.out.println("Выход из программы.");
                break;
            }
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Введите первое число: ");
                        int a1 = scanner.nextInt();
                        System.out.print("Введите второе число: ");
                        int b1 = scanner.nextInt();
                        System.out.println("Результат: " + a1 + " + " + b1 + " = " + calculator.add(a1, b1));
                        break;
                        
                    case 2:
                        System.out.print("Введите первое число: ");
                        int a2 = scanner.nextInt();
                        System.out.print("Введите второе число: ");
                        int b2 = scanner.nextInt();
                        System.out.println("Результат: " + a2 + " - " + b2 + " = " + calculator.subtract(a2, b2));
                        break;
                        
                    case 3:
                        System.out.print("Введите первое число: ");
                        int a3 = scanner.nextInt();
                        System.out.print("Введите второе число: ");
                        int b3 = scanner.nextInt();
                        System.out.println("Результат: " + a3 + " * " + b3 + " = " + calculator.multiply(a3, b3));
                        break;
                        
                    case 4:
                        System.out.print("Введите первое число: ");
                        int a4 = scanner.nextInt();
                        System.out.print("Введите второе число: ");
                        int b4 = scanner.nextInt();
                        System.out.println("Результат: " + a4 + " / " + b4 + " = " + calculator.divide(a4, b4));
                        break;
                        
                    case 5:
                        System.out.print("Введите основание: ");
                        int base = scanner.nextInt();
                        System.out.print("Введите показатель степени: ");
                        int exponent = scanner.nextInt();
                        System.out.println("Результат: " + base + " ^ " + exponent + " = " + calculator.power(base, exponent));
                        break;
                        
                    case 6:
                        System.out.print("Введите число для вычисления факториала: ");
                        int num = scanner.nextInt();
                        System.out.println("Результат: " + num + "! = " + calculator.factorial(num));
                        break;
                        
                    default:
                        System.out.println("Неверный выбор операции.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
