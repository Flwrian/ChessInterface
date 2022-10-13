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
        // Fill the grid with the pieces from the FEN. Example: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR.

        // Split the FEN into 8 rows
        String[] rows = fen.split("/");

        // For each row
        for (int i = 0; i < rows.length; i++) {
            // Split the row into 8 squares
            String[] squares = rows[i].split("");

            // For each square
            for (int j = 0; j < squares.length; j++) {
                // If the square is not empty
                if (!squares[j].equals("")) {
                    // Get the piece
                    Piece piece = Piece.getPieceFromChar(squares[j].charAt(0));

                    // If the piece is not null
                    if (piece != null) {
                        // Add the piece to the grid
                        getVueCase(j, i).setVuePiece(new VuePiece(piece));
                    }

                    // If the square is empty
                    else {
                        // Get the number of empty squares
                        int nbEmptySquares = Integer.parseInt(squares[j]);

                        // Add the empty squares to the grid
                        for (int k = 0; k < nbEmptySquares; k++) {
                            getVueCase(j + k, i).setVuePiece(null);
                        }

                        // Skip the empty squares
                        j += nbEmptySquares - 1;
                    }
                }
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
                    fen += "1";
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