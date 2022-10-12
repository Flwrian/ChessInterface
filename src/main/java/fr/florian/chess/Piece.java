package fr.florian.chess;

import java.util.ArrayList;

public abstract class Piece {
    
    protected Couleur couleur;
    protected Case casePiece;
    protected Plateau plateau;
    protected Joueur joueur;

    public Piece(Couleur couleur, Case casePiece, Plateau plateau, Joueur joueur) {
        this.couleur = couleur;
        this.casePiece = casePiece;
        this.plateau = plateau;
        this.joueur = joueur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Case getCase() {
        return casePiece;
    }

    public void setCase(Case casePiece) {
        this.casePiece = casePiece;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Coup[] getCoupsPossibles() {
        ArrayList<Coup> coupsPossibles = new ArrayList<Coup>();
        for (int i = 0; i < plateau.getTaille(); i++) {
            for (int j = 0; j < plateau.getTaille(); j++) {
                if (deplacementValide(plateau.getCase(i, j).getX(), plateau.getCase(i, j).getY())) {
                    coupsPossibles.add(new Coup(this, plateau.getCase(i, j)));
                }
            }
        }
        return coupsPossibles.toArray(new Coup[coupsPossibles.size()]);
    }

    /**
     * Vérifie si le déplacement est valide
     * @param x
     * @param y
     * @return true si le déplacement est valide, false sinon
     */
    public abstract boolean deplacementValide(int x, int y);

    public abstract void deplacer(int x, int y);

    public abstract String getNom();

    public abstract String toString();

    public void afficherDeplacementValide(){
        // Copie du Plateau
        Plateau plateauCopie = new Plateau(8);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plateauCopie.setCase(i, j, new Case(i, j, plateau.getCase(i, j).getPiece()));
            }
        }
        System.out.println("Deplacements possibles de la piece " + this.getNom() + " en " + this.getCase().getX() + " " + this.getCase().getY());
        // Pour chaque déplacement possible de la pièce, afficher un x sur le plateauCopie
        for (Coup coup : getCoupsPossibles()) {
            plateauCopie.getCase(coup.getCaseFin().getX(), coup.getCaseFin().getY()).setChar('x');
        }

        // Affichage du plateauCopie
        System.out.println(plateauCopie);
    }

    public void afficherInfos() {
        System.out.println("Piece : " + this.getNom());
        System.out.println("Couleur : " + couleur);
        System.out.println("Position : " + casePiece.getX() + ", " + casePiece.getY());
        System.out.println("+-------------------+");
    }


}