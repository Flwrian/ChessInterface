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

    public String getCouleurString() {
        return couleur == Color.BLACK ? "NOIR" : "BLANC";
    }

    public abstract String toString();

    public static Piece getPieceFromChar(char fenPartSplitPartChar) {
        switch (fenPartSplitPartChar) {
            case 'P':
                return new Pion(Color.WHITE);
            case 'p':
                return new Pion(Color.BLACK);
            case 'R':
                return new Tour(Color.WHITE);
            case 'r':
                return new Tour(Color.BLACK);
            case 'N':
                return new Cavalier(Color.WHITE);
            case 'n':
                return new Cavalier(Color.BLACK);
            case 'B':
                return new Fou(Color.WHITE);
            case 'b':
                return new Fou(Color.BLACK);
            case 'Q':
                return new Reine(Color.WHITE);
            case 'q':
                return new Reine(Color.BLACK);
            case 'K':
                return new Roi(Color.WHITE);
            case 'k':
                return new Roi(Color.BLACK);
            default:
                return null;
        }
    }

    public char getChar(){
        if (this instanceof Pion){
            return couleur == Color.BLACK ? 'p' : 'P';
        } else if (this instanceof Tour){
            return couleur == Color.BLACK ? 'r' : 'R';
        } else if (this instanceof Cavalier){
            return couleur == Color.BLACK ? 'n' : 'N';
        } else if (this instanceof Fou){
            return couleur == Color.BLACK ? 'b' : 'B';
        } else if (this instanceof Reine){
            return couleur == Color.BLACK ? 'q' : 'Q';
        } else if (this instanceof Roi){
            return couleur == Color.BLACK ? 'k' : 'K';
        } else {
            return ' ';
        }
    }
}
