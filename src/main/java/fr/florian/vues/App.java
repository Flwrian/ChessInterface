package fr.florian.vues;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        VueMain vueMain = new VueMain();

        scene = new Scene(vueMain);
        stage.setScene(scene);
        stage.getIcons().add(new Image("icon.png"));
        stage.setTitle("SolveIt");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}