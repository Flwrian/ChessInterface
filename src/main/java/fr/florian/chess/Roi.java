package fr.florian.chess;

import javafx.scene.paint.Color;

public class Roi extends Piece{
    
    public Roi(Color couleur) {
        super(couleur);
    }
    
    @Override
    public String toString() {
        return "Roi";
    }
}
