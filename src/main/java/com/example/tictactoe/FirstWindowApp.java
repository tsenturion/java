package com.example.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstWindowApp extends Application {
    private static final int BOARD_SIZE = 3;
    private Button[][] buttons = new Button[BOARD_SIZE][BOARD_SIZE];
    // Добавляем поле для метки статуса, чтобы к ней можно было обращаться из разных методов
    private Label statusLabel;

    @Override
    public void start(Stage stage) {
        // Используем BorderPane для более гибкого размещения элементов
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));

        // Создаем игровое поле и помещаем его в центр
        GridPane grid = createButtonGrid();
        mainLayout.setCenter(grid);

        // Создаем нижнюю панель для размещения статуса
        VBox bottomPanel = new VBox();
        bottomPanel.setPadding(new Insets(10));
        bottomPanel.setSpacing(10);

        // Создаем Label для отображения статуса игры
        // Пока что он просто показывает текст, но в будущем будет отображать:
        // - чей сейчас ход (X или O)
        // - кто победил
        // - ничья
        statusLabel = new Label("Статус игры");
        statusLabel.setFont(new Font(16)); // Увеличиваем размер шрифта
        bottomPanel.getChildren().add(statusLabel);

        // Размещаем панель со статусом в нижней части главного макета
        mainLayout.setBottom(bottomPanel);

        // Создаем сцену с немного увеличенной высотой, чтобы вместить статус
        Scene scene = new Scene(mainLayout, 400, 450);
        stage.setTitle("Игровое поле 3×3");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5); // Отступы между кнопками
        grid.setVgap(5);

        // Настройка равных столбцов
        for (int i = 0; i < BOARD_SIZE; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / BOARD_SIZE);
            grid.getColumnConstraints().add(col);
        }

        // Настройка равных строк
        for (int i = 0; i < BOARD_SIZE; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / BOARD_SIZE);
            grid.getRowConstraints().add(row);
        }

        // Создание и размещение кнопок
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Button button = createGameButton(row, col);
                buttons[row][col] = button;
                grid.add(button, col, row);
            }
        }

        return grid;
    }

    private Button createGameButton(int row, int col) {
        Button button = new Button();

        // Настройка размеров - кнопка растягивается на всю ячейку
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Установка начального текста (пусто)
        button.setText("");

        // Сохраняем координаты для обработчика
        final int r = row;
        final int c = col;

        // Обработчик нажатия
        button.setOnAction(event -> {
            handleButtonClick(r, c, button);
        });

        return button;
    }

    private void handleButtonClick(int row, int col, Button button) {
        // Временная логика: просто показываем координаты
        System.out.println("Нажата кнопка в позиции: [" + row + ", " + col + "]");

        // Если кнопка пустая, ставим X (для теста)
        if (button.getText().isEmpty()) {
            button.setText("X");
            // Здесь позже будет логика обновления statusLabel
            // Например: statusLabel.setText("Ход игрока O");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
