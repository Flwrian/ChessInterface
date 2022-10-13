package fr.florian.vues;

import javafx.scene.layout.StackPane;

public class VueMain extends StackPane {
    
    private VuePlateau vuePlateau;

    public VueMain() {
        String base_position = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        vuePlateau = new VuePlateau("r1bqkb1r/ppp2Npp/2n5/3np3/2B5/8/PPPP1PPP/RNBQK2R b KQkq");
        getChildren().add(vuePlateau);

        setPrefSize(800, 800);
    }
}
