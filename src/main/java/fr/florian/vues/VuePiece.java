package fr.florian.vues;

import fr.florian.chess.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VuePiece extends ImageView {

    private Piece piece;

    public VuePiece(Piece piece) {
        super(new Image(piece.toString() + "_" + piece.getCouleurString() + ".png"));
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
