package fr.florian.chess;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    
    private ArrayList<Piece> pieces;
    private Couleur couleur;
    private ArrayList<Coup> coupsPossibles;
    private Plateau plateau;

    public Joueur(Couleur couleur, Plateau plateau) {
        this.couleur = couleur;
        pieces = new ArrayList<Piece>();
        coupsPossibles = new ArrayList<Coup>();
        this.plateau = plateau;

        if(couleur.equals(Couleur.BLANC)){
            this.pieces.add(new Tour(Couleur.BLANC, plateau.getCase(7, 7), plateau, this));
            this.pieces.add(new Cavalier(Couleur.BLANC, plateau.getCase(7, 6), plateau, this));
            this.pieces.add(new Fou(Couleur.BLANC, plateau.getCase(7, 5), plateau, this));
            this.pieces.add(new Dame(Couleur.BLANC, plateau.getCase(7, 4), plateau, this));
            this.pieces.add(new Roi(Couleur.BLANC, plateau.getCase(7, 3), plateau, this));
            this.pieces.add(new Fou(Couleur.BLANC, plateau.getCase(7, 2), plateau, this));
            this.pieces.add(new Cavalier(Couleur.BLANC, plateau.getCase(7, 1), plateau, this));
            this.pieces.add(new Tour(Couleur.BLANC, plateau.getCase(7, 0), plateau, this));
            for(int i = 0; i < 8; i++){
                this.pieces.add(new Pion(Couleur.BLANC, plateau.getCase(6, i), plateau, this));
            }
        }

        if(couleur.equals(Couleur.NOIR)){
            this.pieces.add(new Tour(Couleur.NOIR, plateau.getCase(0, 7), plateau, this));
            this.pieces.add(new Cavalier(Couleur.NOIR, plateau.getCase(0, 6), plateau, this));
            this.pieces.add(new Fou(Couleur.NOIR, plateau.getCase(0, 5), plateau, this));
            this.pieces.add(new Dame(Couleur.NOIR, plateau.getCase(0, 4), plateau, this));
            this.pieces.add(new Roi(Couleur.NOIR, plateau.getCase(0, 3), plateau, this));
            this.pieces.add(new Fou(Couleur.NOIR, plateau.getCase(0, 2), plateau, this));
            this.pieces.add(new Cavalier(Couleur.NOIR, plateau.getCase(0, 1), plateau, this));
            this.pieces.add(new Tour(Couleur.NOIR, plateau.getCase(0, 0), plateau, this));
            for(int i = 0; i < 8; i++){
                this.pieces.add(new Pion(Couleur.NOIR, plateau.getCase(1, i), plateau, this));
            }
        }


    }
    
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public boolean isCheckMate() {
        return getRoi() == null;
    }
    
    public Roi getRoi() {
        for (Piece piece : pieces) {
            if (piece instanceof Roi) {
                return (Roi) piece;
            }
        }
        return null;
    }

    public void jouerCoupAleatoire() {
        coupsPossibles.clear();
        for (Piece piece : pieces) {
            for (Coup coup : piece.getCoupsPossibles()) {
                coupsPossibles.add(coup);
            }
        }
        // Jouer un coup aléatoire
        int indexCoup = (int) (Math.random() * coupsPossibles.size());
        Coup coup = coupsPossibles.get(indexCoup);
        coup.getPiece().deplacer(coup.getCaseFin().getX(), coup.getCaseFin().getY());
    }
    
    public void jouerCoup(){
        coupsPossibles.clear();
        System.out.println(pieces);
        // On récupère les coups possibles
        for (Piece piece : pieces) {
            for (Coup coup : piece.getCoupsPossibles()) {
                coupsPossibles.add(coup);
            }
        }
        System.out.println("Trait aux " + couleur.toString());
        Scanner sc = new Scanner(System.in);

        // Le joueur choisit un coup. Example: NC6 (N pour le cavalier, C6 pour la case), est l'équivalent de 0 1 2 5. Par exemple la case A1 est 0 0 0 0
        System.out.println("Choisissez un coup:");
        String coup = sc.nextLine();

        coup = coup.toUpperCase();

        int x =coup.charAt(2) - '1';
        int y =coup.charAt(1) - 'A';

        if(coup.length() == 3){

            // On doit identifier la pièce et la case de destination
            // On récupère les pièces possibles et on regarde celle qui permet le coup
            int nbPieces = 0;
            for (Piece piece : pieces) {
                if(piece.toString().charAt(0) == coup.charAt(0)){
                    // Calculer combien de pièces peuvent aller sur la case.
                    if(piece.deplacementValide(x, y)){
                        nbPieces++;
                    }
                }
            }
            if(nbPieces < 2){
                // On joue le coup car il n'y a qu'une pièce qui peut aller sur la case
                for (Piece piece : pieces) {
                    if(piece.toString().charAt(0) == coup.charAt(0)){
                        piece.deplacer(x, y);
                    }
                }
            }else{
                System.out.println("Il y a plusieurs pièces qui peuvent aller sur cette case. Veuillez préciser la pièce. Example: Rac6");
            }

        }

        if(coup.length() == 4){
            System.out.println(coup.charAt(3) - '1');
            System.out.println(coup.charAt(2) - 'A');
            for (Piece piece : pieces) {

                // Example: Thh6
                if(Character.isLetter(coup.charAt(1))){
                    if(piece.toString().charAt(0) == coup.charAt(0) && piece.getCase().getY() == y){
                        if(piece.deplacementValide(coup.charAt(3) - '1', coup.charAt(2) - 'A')){
                            piece.deplacer(coup.charAt(3) - '1', coup.charAt(2) - 'A');
                        }
                        else{
                            System.out.println("Le déplacement n'est pas valide");
                        }
                    }
                }
                // Example: T6h6
                else{
                    if(piece.toString().charAt(0) == coup.charAt(0) && piece.getCase().getX() == x){
                        if(piece.deplacementValide(coup.charAt(3) - '1', coup.charAt(2) - 'A')){
                            piece.deplacer(coup.charAt(3) - '1', coup.charAt(2) - 'A');
                        }
                        else{
                            System.out.println("Le déplacement n'est pas valide");
                        }
                    }
                }

            }
        }

        if(coup.length() == 2){
            for (Piece piece : pieces) {
                if(piece instanceof Pion){
                    if(piece.toString().charAt(0) == coup.charAt(0)){
                        if(piece.deplacementValide(coup.charAt(0) - 'A', coup.charAt(1) - '1')){
                            piece.deplacer(x, y);
                        }
                        else{
                            System.out.println("Le déplacement n'est pas valide");
                        }
                    }
                }
            }
        }
    }

    public void afficherCoupsPossibles() {
        for (Piece piece : pieces) {
            piece.afficherDeplacementValide();
        }
    }

}
