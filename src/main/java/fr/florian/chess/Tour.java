package fr.florian.chess;

public class Tour extends Piece {

    public Tour(Couleur couleur, Case casePiece, Plateau plateau, Joueur joueur) {
        super(couleur, casePiece, plateau, joueur);
    }

    public String getNom() {
        return "Tour";
    }

    public boolean deplacementValide(int x, int y) {

        // Si la case est vide
        if (plateau.getCase(x, y).getPiece() == null) {
            // Si le déplacement est en ligne droite
            if (x == this.getCase().getX() || y == this.getCase().getY()) {
                // Si le déplacement est vers le haut
                if (x - this.getCase().getX() > 0) {
                    for (int i = 1; i < Math.abs(x - this.getCase().getX()); i++) {
                        if (plateau.getCase(x - i, y).getPiece() != null) {
                            return false;
                        }
                    }
                }
                // Si le déplacement est vers le bas
                else {
                    for (int i = 1; i < Math.abs(x - this.getCase().getX()); i++) {
                        if (plateau.getCase(x + i, y).getPiece() != null) {
                            return false;
                        }
                    }
                }
                // Si le déplacement est vers la droite
                if (y - this.getCase().getY() > 0) {
                    for (int i = 1; i < Math.abs(y - this.getCase().getY()); i++) {
                        if (plateau.getCase(x, y - i).getPiece() != null) {
                            return false;
                        }
                    }
                }
                // Si le déplacement est vers la gauche
                else {
                    for (int i = 1; i < Math.abs(y - this.getCase().getY()); i++) {
                        if (plateau.getCase(x, y + i).getPiece() != null) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        // Si la case n'est pas vide
        else {
            // Si la case n'est pas de la même couleur
            if (!plateau.getCase(x, y).getPiece().getCouleur().equals(this.getCouleur())) {
                // Si le déplacement est en ligne droite
                if (x == this.getCase().getX() || y == this.getCase().getY()) {
                    // Si le déplacement est vers le haut
                    if (x - this.getCase().getX() > 0) {
                        for (int i = 1; i < Math.abs(x - this.getCase().getX()); i++) {
                            if (plateau.getCase(x - i, y).getPiece() != null) {
                                return false;
                            }
                        }
                    }
                    // Si le déplacement est vers le bas
                    else {
                        for (int i = 1; i < Math.abs(x - this.getCase().getX()); i++) {
                            if (plateau.getCase(x + i, y).getPiece() != null) {
                                return false;
                            }
                        }
                    }
                    // Si le déplacement est vers la droite
                    if (y - this.getCase().getY() > 0) {
                        for (int i = 1; i < Math.abs(y - this.getCase().getY()); i++) {
                            if (plateau.getCase(x, y - i).getPiece() != null) {
                                return false;
                            }
                        }
                    }
                    // Si le déplacement est vers la gauche
                    else {
                        for (int i = 1; i < Math.abs(y - this.getCase().getY()); i++) {
                            if (plateau.getCase(x, y + i).getPiece() != null) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
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
        return "R";
    }
}