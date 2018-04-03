/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import projekt.Dostawca;
import projekt.Klient;
import projekt.Posilek;
import projekt.Restauracja;
import projekt.Zamowienie;

public class PanelKontrolnyController implements Initializable {

    @FXML
    private void dodajPosilek(ActionEvent event) {
        Posilek p = GUIFXMain.getRestauracja().dodajPosilek();
        dodanoNowyObiekt(p);
    }

    @FXML
    private void wyswietlPosilki(ActionEvent event) {
        wyswietlInformacje(GUIFXMain.getRestauracja().wyswietlPosilki(), "Menu");
    }

    @FXML
    private void dodajZamowienie(ActionEvent event) {
        if (GUIFXMain.getRestauracja().brakKlientow()) {
            blad("Dodaj najpierw klienta do systemu");
        } else {
            Zamowienie z = new Zamowienie();
            z.setWlasciciel(GUIFXMain.getRestauracja().losujKlienta());
            GUIFXMain.getRestauracja().dodajZamowienie(z);
            dodanoNowyObiekt(z);
        }
    }

    @FXML
    private synchronized void wyswietlZamowienia(ActionEvent event) {
        wyswietlInformacje(GUIFXMain.getRestauracja().wyswietlZamowienia(), "Zamowienia");
    }

    public void blad(String info) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(null);
        alert.setHeaderText("Blad!");
        alert.setContentText(info);

        alert.showAndWait();
    }

    public void dodanoNowyObiekt(Object o) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText("Dodano " + o.getClass().getSimpleName());
        alert.setContentText(o.toString());

        alert.showAndWait();
    }

    public void wyswietlInformacje(String dane, String tytul) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(tytul);
        alert.setContentText("");
        TextArea textArea = new TextArea(dane);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        alert.getDialogPane().setContent(textArea);

        alert.showAndWait();
    }

    @FXML
    private void dodajKlientaOkazjonalnego(ActionEvent event) {
        Klient k = GUIFXMain.getRestauracja().dodajKlientaOkazjonalnego();
        dodanoNowyObiekt(k);
        GUIFXMain.getMapaController().dodajObiekt(k, k.getPolozenie().getX(), k.getPolozenie().getY());
    }

    @FXML
    private void dodajKlientaFirmowego(ActionEvent event) {
        Klient k = GUIFXMain.getRestauracja().dodajKlientaFirmowego();
        dodanoNowyObiekt(k);
        GUIFXMain.getMapaController().dodajObiekt(k, k.getPolozenie().getX(), k.getPolozenie().getY());
    }

    @FXML
    private void dodajKlientaStalego(ActionEvent event) {
        Klient k = GUIFXMain.getRestauracja().dodajKlientaStalego();
        dodanoNowyObiekt(k);
        GUIFXMain.getMapaController().dodajObiekt(k, k.getPolozenie().getX(), k.getPolozenie().getY());
    }

    @FXML
    private void wyswietlKlientow(ActionEvent event) {
        GUIFXMain.getRestauracja().wyswietlKlientow();
        wyswietlInformacje(GUIFXMain.getRestauracja().wyswietlKlientow(), "Klienci");
    }

    @FXML
    private void dodajDostawce(ActionEvent event) throws IOException {

        Dostawca d = GUIFXMain.getRestauracja().dodajDostawce();
        GUIFXMain.getMapaController().dodajObiekt(d, d.getPolozenie().getX(), d.getPolozenie().getY());

        dodanoNowyObiekt(d);
    }

    @FXML
    private void wyswietlDostawcow(ActionEvent event) {
        wyswietlInformacje(GUIFXMain.getRestauracja().wyswietlDostawcow(), "Dostawcy");
    }

    @FXML
    private void zapisz(ActionEvent event) throws IOException {
        String nazwaPliku = "pliki\\lista.ser";
        ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(nazwaPliku)));
        out.writeObject(GUIFXMain.getRestauracja());
        out.close();
    }

    @FXML
    private void wczytaj(ActionEvent event) throws IOException, ClassNotFoundException {
        String nazwaPliku = "pliki\\lista.ser";
        ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(nazwaPliku)));
        GUIFXMain.getMapaController().usun();
        GUIFXMain.setRestauracja((Restauracja) in.readObject());
        in.close();
        GUIFXMain.getRestauracja().startuj();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
