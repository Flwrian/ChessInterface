package fr.florian.chess;

import java.util.Scanner;

public class Pion extends Piece{

    public Pion(Couleur couleur, Case casePiece, Plateau plateau, Joueur joueur) {
        super(couleur, casePiece, plateau, joueur);
    }

    public String getNom() {
        return "Pion";
    }

    public boolean deplacementValide(int x, int y) {
        // Ceci est le déplacement d'un pion aux échecs
        // Il ne peut se déplacer que d'une case en avant
        // Il peut se déplacer de deux cases en avant si il n'a pas encore bougé
        // Il peut manger une pièce adverse en diagonale
        // Il peut se transformer en une autre pièce si il atteint la dernière ligne

        // Si le pion n'a pas bougé
        if (this.casePiece.getX() == 1 || this.casePiece.getX() == 6) {
            // Si le pion se déplace de deux cases en avant
            if (this.casePiece.getX() == 1 && x == 3 && y == this.casePiece.getY() && this.couleur.equals(Couleur.NOIR)) {
                // Vérifier qu'il ne traverse pas de pièce sur son chemin
                if (plateau.getCase(2, y).getPiece() == null && plateau.getCase(3, y).getPiece() == null) {
                    return true;
                }
            }
            // Si le pion se déplace de deux cases en avant
            if (this.casePiece.getX() == 6 && x == 4 && y == this.casePiece.getY() && this.couleur.equals(Couleur.BLANC)) {
                // Vérifier qu'il ne traverse pas de pièce sur son chemin
                if (plateau.getCase(5, y).getPiece() == null && plateau.getCase(4, y).getPiece() == null) {
                    return true;
                }
            }
        }

        // Si le pion se déplace d'une case en avant
        if (x == this.casePiece.getX() + 1 && y == this.casePiece.getY() && this.couleur.equals(Couleur.NOIR)) {
            // Vérifier qu'il ne traverse pas de pièce sur son chemin
            if (plateau.getCase(x, y).getPiece() == null) {
                return true;
            }
        }

        // Si le pion se déplace d'une case en avant
        if (x == this.casePiece.getX() - 1 && y == this.casePiece.getY() && this.couleur.equals(Couleur.BLANC)) {
            // Vérifier qu'il ne traverse pas de pièce sur son chemin
            if (plateau.getCase(x, y).getPiece() == null) {
                return true;
            }
        }

        // Si le pion se déplace en diagonale d'une case en avant que s'il y a une pièce adverse.
        if (x == this.casePiece.getX() + 1 && (y == this.casePiece.getY() + 1 || y == this.casePiece.getY() - 1) && this.couleur.equals(Couleur.NOIR)) {
            if(plateau.getCase(x, y).getPiece() != null && plateau.getCase(x, y).getPiece().getCouleur().equals(Couleur.BLANC)) {
                return true;
            }
        }

        // Si le pion se déplace en diagonale d'une case en avant que s'il y a une pièce adverse.
        if (x == this.casePiece.getX() - 1 && (y == this.casePiece.getY() + 1 || y == this.casePiece.getY() - 1) && this.couleur.equals(Couleur.BLANC)) {
            if(plateau.getCase(x, y).getPiece() != null && plateau.getCase(x, y).getPiece().getCouleur().equals(Couleur.NOIR)) {
                return true;
            }
        }

        return false;
    }

    public void deplacer(int x, int y) {
        if(!deplacementValide(x, y)) {
            return;
        }

        // Si il y a une pièce sur la case de destination
        if (plateau.getCase(x, y).getPiece() != null) {
            plateau.getCase(x, y).getPiece().setCase(null);
            // On retire la piece de la liste des pieces du joueur
            plateau.getCase(x, y).getPiece().getJoueur().getPieces().remove(plateau.getCase(x, y).getPiece());
        }

        this.getCase().setPiece(null);
        plateau.getCase(x, y).setPiece(this);
        this.setCase(plateau.getCase(x, y));
        
        // Si le pion atteint la dernière ligne, il se transforme en une autre pièce
        if (x == 0 || x == 7) {
            // On demande à l'utilisateur quelle pièce il veut transformer le pion
            System.out.println("Quelle pièce voulez-vous transformer le pion?");
            System.out.println("1. Tour");
            System.out.println("2. Cavalier");
            System.out.println("3. Fou");
            System.out.println("4. Reine");
            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    // On supprime le pion de la liste des pièces du joueur
                    this.casePiece.setPiece(null);
                    joueur.getPieces().remove(this);
                    plateau.getCase(x, y).setPiece(new Tour(this.couleur, plateau.getCase(x, y), plateau, joueur));
                    break;
                case 2:
                    // On supprime le pion de la liste des pièces du joueur
                    this.casePiece.setPiece(null);
                    joueur.getPieces().remove(this);
                    plateau.getCase(x, y).setPiece(new Cavalier(this.couleur, plateau.getCase(x, y), plateau, joueur));
                    break;
                case 3:
                    // On supprime le pion de la liste des pièces du joueur
                    this.casePiece.setPiece(null);
                    joueur.getPieces().remove(this);
                    plateau.getCase(x, y).setPiece(new Fou(this.couleur, plateau.getCase(x, y), plateau, joueur));
                    break;
                case 4:
                    // On supprime le pion de la liste des pièces du joueur
                    this.casePiece.setPiece(null);
                    joueur.getPieces().remove(this);
                    plateau.getCase(x, y).setPiece(new Dame(this.couleur, plateau.getCase(x, y), plateau, joueur));
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }
    
    @Override
    public String toString() {
        return "P";
    }
}
