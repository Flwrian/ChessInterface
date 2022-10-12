module fr.florian {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.florian.vues to javafx.fxml;
    exports fr.florian.vues;
    exports fr.florian.chess;
}
