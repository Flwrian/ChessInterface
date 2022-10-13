package fr.florian.vues;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class VueCase extends Button {

    private int x;
    private int y;
    private Color couleur;
    private VuePiece vuePiece;

    public VueCase(int x, int y, Color couleur, VuePiece vuePiece) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
        this.vuePiece = vuePiece;

        // Parse the color so it can be used in CSS
        String color = String.format("#%02X%02X%02X",
                (int) (couleur.getRed() * 255),
                (int) (couleur.getGreen() * 255),
                (int) (couleur.getBlue() * 255));

        // Set the style of the button
        setStyle("-fx-background-color: " + color + "; -fx-border-color: black; -fx-border-width: 1px;");

        if (vuePiece != null){
            setGraphic(vuePiece);
        }

        setMaxHeight(50);
        setMaxWidth(50);

        setOnMouseClicked(event -> 
            System.out.println("Pièce cliquée: {\n   Type: " + ((VueCase) event.getSource()).getVuePiece().getPiece().toString() + "\n   Couleur: " + ((VueCase) event.getSource()).getVuePiece().getPiece().getCouleurString() + "\n   Position: " + (char) (x + 97) + "" + (y + 1)+"\n}"));

        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getCoords() {
        return new int[]{x, y};
    }

    public Color getCouleur() {
        return couleur;
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    /**
     * Set the vuePiece on the Case
     * @param vuePiece
     */
    public void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
        if (vuePiece != null){
            setGraphic(vuePiece);
        } else {
            setGraphic(new ImageView(new Image("EMPTY_SQUARE.png")));
        }
    }

    /**
     * Set the vuePiece and set the maximum size of the image
     * @param vuePiece
     * @param x
     * @param y
     */
    public void setVuePiece(VuePiece vuePiece, double x, double y) {
        this.vuePiece = vuePiece;
        if (vuePiece != null){
            setGraphic(vuePiece);
            vuePiece.setFitHeight(x);
            vuePiece.setFitWidth(y);
            getVuePiece().setFitHeight(x);
            getVuePiece().setFitWidth(y);
        } else {
            ImageView img = new ImageView(new Image("EMPTY_SQUARE.png"));
            img.setFitHeight(x);
            img.setFitWidth(y);
            setGraphic(img);
        }
    }

}
