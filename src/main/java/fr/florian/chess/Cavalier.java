package fr.florian.chess;

public class Cavalier extends Piece {
    
    public Cavalier(Couleur couleur, Case casePiece, Plateau plateau, Joueur joueur) {
        super(couleur, casePiece, plateau, joueur);
    }

    public String getNom() {
        return "Cavalier";
    }

    public boolean deplacementValide(int x, int y) {
        
        // Si la case de destination possède une pièce de la même couleur que la pièce courante alors le déplacement n'est pas valide
        if(plateau.getCase(x, y).getPiece() != null) {
            if(plateau.getCase(x, y).getPiece().getCouleur().equals(this.couleur)) {
                return false;
            }
        }

        // Si la case de destination est la même que la case courante alors le déplacement n'est pas valide
        if (x == this.casePiece.getX() && y == this.casePiece.getY()) {
            return false;
        }

        // Si la case de destination est à une distance de 2 cases en x et 1 case en y ou à une distance de 1 case en x et 2 cases en y alors le déplacement est valide
        if (x == this.casePiece.getX() + 1 || x == this.casePiece.getX() - 1) {
            if (y == this.casePiece.getY() + 2 || y == this.casePiece.getY() - 2) {
                return true;
            }
        }

        // Si la case de destination est à une distance de 2 cases en y et 1 case en x ou à une distance de 1 case en y et 2 cases en x alors le déplacement est valide
        if (x == this.casePiece.getX() + 2 || x == this.casePiece.getX() - 2) {
            if (y == this.casePiece.getY() + 1 || y == this.casePiece.getY() - 1) {
                return true;
            }
        }

        // Sinon le déplacement n'est pas valide
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

    @Override
    public String toString() {
        return "N";
    }
}
