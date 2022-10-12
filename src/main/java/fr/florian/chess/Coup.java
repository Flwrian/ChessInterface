package fr.florian.chess;

public class Coup {
    
    private Piece piece;
    private Case caseDestination;
    
    public Coup(Piece piece, Case caseCoup) {
        this.piece = piece;
        this.caseDestination = caseCoup;
    }
    
    public Piece getPiece() {
        return piece;
    }
    
    public Case getCaseFin() {
        return caseDestination;
    }

    public Case getCaseDebut() {
        return piece.getCase();
    }
    
    public String toString() {
        return piece.getNom() + " : " + caseDestination;
    }
}
