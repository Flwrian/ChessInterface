package fr.florian;

import javafx.scene.paint.Color;

public class Pion extends Piece{
    
    public Pion(Color couleur) {
        super(couleur);
    }
    
    @Override
    public String toString() {
        return "Pion";
    }
}
