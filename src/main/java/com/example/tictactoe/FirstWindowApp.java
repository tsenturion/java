package com.example.tictactoe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class FirstWindowApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 1. Установка заголовка окна
        primaryStage.setTitle("Моё первое приложение JavaFX");

        // 2. Установка размеров окна (ширина, высота)
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);

        // Альтернативный способ задания размера:
        // primaryStage.setScene(new Scene(new Group(), 400, 300));

        // 3. Запрет изменения размеров окна (опционально)
        // primaryStage.setResizable(false);

        // 4. Установка действия при закрытии окна
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Окно закрывается...");
            // Здесь можно выполнить сохранение данных, освобождение ресурсов
            Platform.exit(); // Полное завершение приложения
        });

        // 5. Отображение окна (обязательно!)
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
