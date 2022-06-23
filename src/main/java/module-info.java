module game.chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.chess to javafx.fxml;
    exports game.chess;
}