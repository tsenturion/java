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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FirstWindowApp extends Application {

    private static final int BOARD_SIZE = 3;
    private static final String MAIN_LAYOUT_STYLE = "-fx-background-color: #f5f5f5;";
    private static final String BOTTOM_PANEL_STYLE =
            "-fx-background-color: white;" +
            "-fx-background-radius: 10;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0);";
    private static final String STATUS_DEFAULT_STYLE = "-fx-text-fill: #333333;";
    private static final String STATUS_HOVER_STYLE = "-fx-text-fill: #2196F3;";
    private static final String STATUS_NEXT_TURN_STYLE = "-fx-text-fill: #F44336; -fx-font-weight: bold;";
    private static final String BUTTON_DEFAULT_STYLE =
            "-fx-font-size: 24px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: white;" +
            "-fx-background-radius: 8;" +
            "-fx-border-color: #cccccc;" +
            "-fx-border-radius: 8;" +
            "-fx-border-width: 2;" +
            "-fx-cursor: hand;";
    private static final String BUTTON_HOVER_STYLE =
            "-fx-font-size: 24px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: #e3f2fd;" +
            "-fx-background-radius: 8;" +
            "-fx-border-color: #2196F3;" +
            "-fx-border-radius: 8;" +
            "-fx-border-width: 2;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(33,150,243,0.3), 10, 0, 0, 0);";
    private static final String BUTTON_X_STYLE =
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #2196F3;" +
            "-fx-background-color: #e3f2fd;" +
            "-fx-background-radius: 8;" +
            "-fx-border-color: #2196F3;" +
            "-fx-border-radius: 8;" +
            "-fx-border-width: 2;" +
            "-fx-cursor: hand;";

    private Button[][] buttons = new Button[BOARD_SIZE][BOARD_SIZE];
    private Label statusLabel;

    @Override
    public void start(Stage stage) {
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));
        mainLayout.setStyle(MAIN_LAYOUT_STYLE);

        GridPane grid = createButtonGrid();
        mainLayout.setCenter(grid);

        VBox bottomPanel = new VBox();
        bottomPanel.setPadding(new Insets(10));
        bottomPanel.setSpacing(10);
        bottomPanel.setStyle(BOTTOM_PANEL_STYLE);

        statusLabel = new Label("Status: waiting for move");
        statusLabel.setFont(Font.font("System", FontWeight.BOLD, 16));
        statusLabel.setStyle(STATUS_DEFAULT_STYLE);
        statusLabel.setOnMouseEntered(e -> statusLabel.setStyle(STATUS_HOVER_STYLE));
        statusLabel.setOnMouseExited(e -> statusLabel.setStyle(STATUS_DEFAULT_STYLE));
        bottomPanel.getChildren().add(statusLabel);

        mainLayout.setBottom(bottomPanel);

        Scene scene = new Scene(mainLayout, 400, 450);
        scene.setUserAgentStylesheet(null);
        stage.setTitle("Game board 3x3");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setStyle("-fx-background-color: transparent;");

        for (int i = 0; i < BOARD_SIZE; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / BOARD_SIZE);
            grid.getColumnConstraints().add(col);
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / BOARD_SIZE);
            grid.getRowConstraints().add(row);
        }

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
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setText("");
        button.setStyle(BUTTON_DEFAULT_STYLE);

        final int r = row;
        final int c = col;

        button.setOnAction(event -> {
            handleButtonClick(r, c, button);
        });
        button.setOnMouseEntered(e -> {
            if (button.getText().isEmpty()) {
                button.setStyle(BUTTON_HOVER_STYLE);
            }
        });
        button.setOnMouseExited(e -> {
            if (button.getText().isEmpty()) {
                button.setStyle(BUTTON_DEFAULT_STYLE);
            }
        });

        return button;
    }

    private void handleButtonClick(int row, int col, Button button) {
        System.out.println("Button clicked at: [" + row + ", " + col + "]");

        if (button.getText().isEmpty()) {
            button.setText("X");
            button.setStyle(BUTTON_X_STYLE);
            statusLabel.setText("Status: O turn");
            statusLabel.setStyle(STATUS_NEXT_TURN_STYLE);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
