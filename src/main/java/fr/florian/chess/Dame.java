package fr.florian.chess;

public class Dame extends Piece {

    public Dame(Couleur couleur, Case casePiece, Plateau plateau, Joueur joueur) {
        super(couleur, casePiece, plateau, joueur);
    }

    public String getNom() {
        return "Dame";
    }

    public boolean deplacementValide(int x, int y) {
        // Le déplacement est valide si le déplacement est en ligne droite ou en diagonale, cela revient à vérifier si le déplacement est valide pour un fou ou pour une tour
        return (new Fou(this.getCouleur(), this.getCase(), this.getPlateau(), this.getJoueur()).deplacementValide(x, y) || new Tour(this.getCouleur(), this.getCase(), this.getPlateau(), this.getJoueur()).deplacementValide(x, y));
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
        return "Q";
    }
}