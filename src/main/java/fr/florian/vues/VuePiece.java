package fr.florian.vues;

import fr.florian.IPiece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VuePiece extends ImageView {

    public VuePiece(IPiece piece) {
        super(new Image("file:src/main/resources/images/" + piece.getNom() + "_100px.png"));
    }
}
