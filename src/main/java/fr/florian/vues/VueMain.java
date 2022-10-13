package fr.florian.vues;

import javafx.scene.layout.StackPane;

public class VueMain extends StackPane {
    
    private VuePlateau vuePlateau;

    public VueMain() {
        vuePlateau = new VuePlateau("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        getChildren().add(vuePlateau);

        setPrefSize(800, 800);
    }
}
