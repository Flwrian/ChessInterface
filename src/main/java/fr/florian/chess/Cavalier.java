package fr.florian;

import javafx.scene.paint.Color;

public class Cavalier extends Piece{
    
    public Cavalier(Color couleur) {
        super(couleur);
    }
    
    @Override
    public String toString() {
        return "Cavalier";
    }
}
