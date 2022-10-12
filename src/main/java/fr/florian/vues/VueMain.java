package fr.florian.vues;

import javafx.scene.layout.StackPane;

public class VueMain extends StackPane {
    
    private VuePlateau vuePlateau;

    public VueMain() {
        vuePlateau = new VuePlateau();
        getChildren().add(vuePlateau);

        setPrefSize(800, 800);
    }
}
