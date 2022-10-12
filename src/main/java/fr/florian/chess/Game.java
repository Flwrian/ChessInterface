package fr.florian.chess;

import java.util.ArrayList;

public class Game {
    
    public static void main(String[] args) {
        Plateau plateau = new Plateau(8);

        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(new Joueur(Couleur.BLANC, plateau));
        joueurs.add(new Joueur(Couleur.NOIR, plateau));

        // Placement des pièces sur le plateau
        for (Joueur joueur : joueurs) {
            for (Piece piece : joueur.getPieces()) {
                piece.getCase().setPiece(piece);
            }
        }

        // Boucle de jeu
        Joueur joueur1 = joueurs.get(0);
        Joueur joueur2 = joueurs.get(1);
        while (!joueur1.isCheckMate() && !joueur2.isCheckMate()) {
            for (int i = 0; i < joueurs.size(); i++) {
                System.out.println(plateau);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                joueurs.get(i).jouerCoup();
            }
        }
        System.out.println("Fin de la partie");
    }
}
