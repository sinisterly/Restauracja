/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projekt.Dostawca;
import projekt.Klient;
import projekt.Obiekt;

/**
 *
 * @author Krzysiu
 */
public class MapaController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private void panelKontrolny(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("PanelKontrolny.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     *
     * @param obiekt dodanie obiektu do mapy na pozycji (x,y)
     * @param x
     * @param y
     */
    public void dodajObiekt(Obiekt obiekt, int x, int y) {
        obiekt.inicjalizuj();
        ImageView image = obiekt.getImage();
        image.setX(x);
        image.setY(y);
        getAnchorPane().getChildren().add(image);
        image.setOnMouseClicked((MouseEvent me) -> {
            try {
                FXMLLoader loader = new FXMLLoader(GUIFXMain.class.getResource("OknoInformacyjne.fxml"));
                Parent root2 = (Parent) loader.load();
                OknoInformacyjneController controller = (OknoInformacyjneController) loader.getController();
                Stage stage2 = new Stage();
                controller.init(obiekt);
                stage2.setScene(new Scene(root2));
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * usunicie obrazka z mapy
     *
     * @param image obrazek obiektu, ktory ma byc usuniety
     */
    public void usun(ImageView image) {
        getAnchorPane().getChildren().remove(image);
    }

    /**
     * wyczyszczenie mapy potrzebne do wczytania zapisanej wersji
     */
    public void usun() {
        for (Dostawca d : GUIFXMain.getRestauracja().getDostawcy()) {
            getAnchorPane().getChildren().remove(d.getImage());
        }
        for (Klient k : GUIFXMain.getRestauracja().getKlienci()) {
            getAnchorPane().getChildren().remove(k.getImage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * @return the anchorPane
     */
    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    /**
     * @param anchorPane the anchorPane to set
     */
    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

}
