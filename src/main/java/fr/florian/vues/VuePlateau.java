package fr.florian.vues;
import fr.florian.chess.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * This class is the graphical interface of the chess game
 * It is a grid of 8x8 squares
 * Each square is a button
 */
public class VuePlateau extends GridPane {

    public VuePlateau() {
        // A grid of 8x8 squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                // We fill the grid with VueCase
                VueCase vueCase = new VueCase(i, j, (i + j) % 2 == 0 ? Color.WHITE : Color.GREY, null);

                // We add the VueCase to the grid
                add(vueCase, i, j);
            }
        }

        // Show the grid
        setGridLinesVisible(true);

        // Set the size of the grid
        setPrefSize(800, 800);
    }

    public VueCase getVueCase(int x, int y) {
        return (VueCase) getChildren().get(x * 8 + y);
    }

    public VuePlateau (String fen){
        this();
        loadFromFen(fen);
        System.out.println(fen);
        System.out.println(getFen());
    }

    public void loadFromFen(String fen) {

        int imageX = (int) getPrefWidth()/9;
        int imageY = (int) getPrefHeight()/9;

        // Fill the grid with the pieces from the FEN. Example: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR.

        int x = 0;
        int y = 0;

        // While there is a character in the FEN, add a vueCase of the corresponding piece
        for (int i = 0; i < fen.length(); i++) {
            char c = fen.charAt(i);

            // If the character is a letter, add a vueCase of the corresponding piece
            if (Character.isLetter(c)) {
                VuePiece vuePiece = new VuePiece(Piece.getPieceFromChar(c));
                VueCase vueCase = new VueCase(x, y, (x + y) % 2 == 0 ? Color.WHITE : Color.GREY, vuePiece);
                vueCase.setVuePiece(vuePiece, imageX, imageY);
                add(vueCase, x, y);
                x++;
            }

            // If the character is a number, add a vueCase of the corresponding number of empty squares
            else if (Character.isDigit(c)) {
                for (int j = 0; j < Character.getNumericValue(c); j++) {
                    VueCase vueCase = new VueCase(x, y, (x + y) % 2 == 0 ? Color.WHITE : Color.GREY, null);
                    vueCase.setVuePiece(null, imageX, imageY);
                    add(vueCase, x, y);
                    x++;
                }
            }

            // If the character is a slash, go to the next line
            else if (c == '/') {
                x = 0;
                y++;
            }

            if(x ==8 && y == 7){
                break;
            }
        }
    }

    public String getFen() {
        // Get the FEN of the grid. Remember that the white pieces are at the bottom of the grid and the black pieces are at the top of the grid.

        // The FEN
        String fen = "";

        // For each row
        for (int i = 0; i < 8; i++) {
            // For each square
            for (int j = 0; j < 8; j++) {
                // Get the piece
                VuePiece vuePiece = getVueCase(j, i).getVuePiece();

                // If the square is empty
                if (vuePiece == null) {
                    // Add an empty square to the FEN
                    // If the previous square was empty, add 1 to the number of empty squares
                    if (fen.length() > 0 && fen.charAt(fen.length() - 1) >= '0' && fen.charAt(fen.length() - 1) <= '9') {
                        fen = fen.substring(0, fen.length() - 1) + (Integer.parseInt(fen.substring(fen.length() - 1)) + 1);
                    }

                    // If the previous square was not empty, add an empty square
                    else {
                        fen += "1";
                    }
                }

                // If the square is not empty
                else {
                    // Add the piece to the FEN
                    fen += vuePiece.getPiece().getChar();
                }
            }

            // If the row is not the last row
            if (i != 7) {
                // Add a slash to the FEN
                fen += "/";
            }
        }

        return fen;
    }
}