/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import projekt.Dostawca;
import projekt.Nazwy;
import projekt.Restauracja;

/**
 *
 * @author Krzysiu
 */
public class GUIFXMain extends Application {

    private static MapaController mapaController = new MapaController();
    private static Restauracja restauracja = new Restauracja();

    @Override
    public void start(Stage stage) throws IOException {
        Nazwy n = new Nazwy();
        getRestauracja().dodajPosilek();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Mapa.fxml"));
        Parent root = loader.load();
        setMapaController((MapaController) loader.getController());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param image obrazek dostawcy
     * @return true jesli obrazek dostawcy nie koliduje z zadnym innym dostawca,
     * w przeciwnym wypadku false
     */
    public static boolean czyWolne(ImageView image) {
        int x = (int) image.getX();
        int y = (int) image.getY();
        for (Dostawca d : getRestauracja().getDostawcy()) {
            if (image != d.getImage() && image.getBoundsInParent().intersects(d.getImage().getBoundsInParent())) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return the mapaController
     */
    public static MapaController getMapaController() {
        return mapaController;
    }

    /**
     * @return the restauracja
     */
    public static Restauracja getRestauracja() {
        return restauracja;
    }

    /**
     * @param aMapaController the mapaController to set
     */
    public static void setMapaController(MapaController aMapaController) {
        mapaController = aMapaController;
    }

    /**
     * @param aRestauracja the restauracja to set
     */
    public static void setRestauracja(Restauracja aRestauracja) {
        restauracja = aRestauracja;
    }

}
