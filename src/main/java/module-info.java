module fr.florian {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens fr.florian.vues to javafx.fxml;
    exports fr.florian.vues;
    exports fr.florian.chess;
}
