package com.example.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class FirstWindowApp extends Application {
    private static final int BOARD_SIZE = 3;
    private Button[][] buttons = new Button[BOARD_SIZE][BOARD_SIZE];

    @Override
    public void start(Stage stage) {
        GridPane grid = createButtonGrid();
        Scene scene = new Scene(grid, 400, 400);
        stage.setTitle("Игровое поле 3×3");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
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
        button.setOnAction(event -> handleButtonClick(r, c, button));

        return button;
    }

    private void handleButtonClick(int row, int col, Button button) {
        // Временная логика: просто показываем координаты
        System.out.println("Нажата кнопка в позиции: [" + row + ", " + col + "]");

        // Если кнопка пустая, ставим X (для теста)
        if (button.getText().isEmpty()) {
            button.setText("X");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
