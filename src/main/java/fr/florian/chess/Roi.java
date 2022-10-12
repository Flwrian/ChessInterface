package fr.florian.chess;

public class Roi extends Piece{

    public Roi(Couleur couleur, Case casePiece, Plateau plateau, Joueur joueur) {
        super(couleur, casePiece, plateau, joueur);
    }

    public String getNom() {
        return "Roi";
    }

    public boolean deplacementValide(int x, int y) {
        // Le roi peut se déplacer d'une case dans n'importe quelle direction (haut, bas, gauche, droite, diagonale). Il ne peut pas se déplacer sur une case occupée par une pièce de la même couleur.
        if (plateau.getCase(x, y).getPiece() == null || !plateau.getCase(x, y).getPiece().getCouleur().equals(this.getCouleur())) {
            if (Math.abs(x - this.getCase().getX()) <= 1 && Math.abs(y - this.getCase().getY()) <= 1) {
                return true;
            }
        }
        return false;
    }

    public void deplacer(int x, int y) {
        if (deplacementValide(x, y)) {
            // Si il y a une pièce sur la case de destination
            if (plateau.getCase(x, y).getPiece() != null) {
                plateau.getCase(x, y).getPiece().setCase(null);
                // On retire la piece de la liste des pieces du joueur
                plateau.getCase(x, y).getPiece().getJoueur().getPieces().remove(plateau.getCase(x, y).getPiece());
            }
            this.getCase().setPiece(null);
            plateau.getCase(x, y).setPiece(this);
            this.setCase(plateau.getCase(x, y));
        }
    }
    
    public String toString() {
        return "K";
    }
}
