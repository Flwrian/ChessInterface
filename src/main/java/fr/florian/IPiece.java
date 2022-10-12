package fr.florian;

import fr.florian.chess.Case;
import fr.florian.chess.Piece;

/**
 * IPiece
 */
public interface IPiece {
    
    Piece getPiece();

    void setPiece(Piece piece);

    Case getCase();

    void setCase(Case c);

    String getNom();

    void setNom(String nom);
}