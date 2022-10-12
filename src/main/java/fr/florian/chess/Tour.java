package fr.florian.chess;

import javafx.scene.paint.Color;

public class Tour extends Piece{
    
    public Tour(Color couleur) {
        super(couleur);
    }
    
    @Override
    public String toString() {
        return "Tour";
    }
}
