package fr.florian;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public abstract class Piece {
    
    private Color couleur;
    private ImageView image;

    public Piece(Color couleur) {
        this.couleur = couleur;
        this.image = new ImageView(new Image("file:src/main/resources/images/" + this.toString() + "_100px.png"));
    }

    public Color getCouleur() {
        return couleur;
    }

    public ImageView getImage() {
        return image;
    }

    public abstract String toString();
}
