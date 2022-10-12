package fr.florian.chess;

import javafx.scene.paint.Color;

public abstract class Piece {
    
    private Color couleur;

    public Piece(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public abstract String toString();
}
