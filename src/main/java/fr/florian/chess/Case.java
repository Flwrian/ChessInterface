package fr.florian.chess;

public class Case {
    
    private int x;
    private int y;
    private Piece piece;

    private char c;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    public Case(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setChar(char c) {
        this.c = c;
    }

    public String toString() {
        if(c != 0){
            return "" + c;
        }
        if (piece == null) {
            return " ";
        }

        return piece.toString();
    }
}
