package fr.florian.chess;

public class Plateau {

    private Case[][] cases;
    private int taille;

    public Plateau(int taille) {
        this.taille = taille;
        cases = new Case[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                cases[i][j] = new Case(i, j);
            }
        }
    }

    public Case[][] getCases() {
        return cases;
    }

    public int getTaille() {
        return taille;
    }

    public Case getCase(int x, int y) {
        return cases[x][y];
    }

    public void setCase(int x, int y, Case c) {
        cases[x][y] = c;
    }

    public String toString() {
        String s = "  +---+---+---+---+---+---+---+---+\n";
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if(j == 0) {
                    s += i+1 + " ";
                }
                s += "| " + cases[i][j] + " ";
            }
            s += "|\n  +---+---+---+---+---+---+---+---+\n";
        }
        s+= "    A   B   C   D   E   F   G   H";
        return s;
    }

    

}