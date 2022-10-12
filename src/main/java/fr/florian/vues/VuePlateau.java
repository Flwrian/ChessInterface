package fr.florian.vues;

import fr.florian.IPiece;
import fr.florian.chess.Piece;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * This class is the graphical interface of the chess game
 * It is a grid of 8x8 squares
 * Each square is a button
 */
public class VuePlateau extends GridPane {

    public VuePlateau() {
        // A grid of 8x8 squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                VueCase vueCase = new VueCase(i, j, (i + j) % 2 == 0 ? Color.WHITE : Color.GREY, null);
                add(vueCase, i, j);
            }
        }

        // Show the grid
        setGridLinesVisible(true);

        // Set the size of the grid
        setPrefSize(800, 800);
    }
}
