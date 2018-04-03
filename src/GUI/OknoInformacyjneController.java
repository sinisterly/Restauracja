/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import projekt.Dostawca;
import projekt.Obiekt;

/**
 *
 * @author Krzysiu
 */
public class OknoInformacyjneController implements Initializable {

    @FXML
    private Label label1;

    @FXML
    private VBox vBox;

    private Obiekt obiekt;

    /**
     * otwieranie okna informacyjnego po kliknieciu na obiekt
     *
     * @param obiekt obiekt, ktorego dotyczy okno informacyjne
     */
    public void init(Obiekt obiekt) {
        this.setObiekt(obiekt);
        getLabel1().setText(obiekt.toString());
        System.out.println(obiekt.getClass().getSimpleName());
        if (obiekt.getClass().getSimpleName().equals("Dostawca")) {
            Label label2 = new Label();

            label2.textProperty().bind(((Dostawca) obiekt).aktualizujPaliwo());
            Button button = new Button("Powrot awaryjny");
            button.setWrapText(true);
            button.setOnAction((ActionEvent event) -> {
                ((Dostawca) obiekt).setPowrot(true);
            });
            getvBox().getChildren().add(button);
            getvBox().getChildren().add(label2);

        }
    }

    /**
     * usuniecie obiektu(usuniecie obrazka z mapy oraz usuniecie watku)
     *
     * @param event
     */
    public void usun(ActionEvent event) {
        GUIFXMain.getMapaController().usun(getObiekt().getImage());
        getObiekt().usun();
        getObiekt().interrupt();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * @return the label1
     */
    public Label getLabel1() {
        return label1;
    }

    /**
     * @return the obiekt
     */
    public Obiekt getObiekt() {
        return obiekt;
    }

    /**
     * @return the vBox
     */
    public VBox getvBox() {
        return vBox;
    }

    /**
     * @param label1 the label1 to set
     */
    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    /**
     * @param obiekt the obiekt to set
     */
    public void setObiekt(Obiekt obiekt) {
        this.obiekt = obiekt;
    }

    /**
     * @param vBox the vBox to set
     */
    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

}
