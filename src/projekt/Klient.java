/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import GUI.GUIFXMain;
import java.io.Serializable;
import java.util.Random;
import javafx.scene.image.ImageView;

/**
 *
 * @author Krzysiu
 */
public abstract class Klient extends Obiekt implements Serializable {

    private String imie;
    private String nazwisko;
    private String nrtel;
    private Polozenie polozenie = new Polozenie();
    private String adresDostawy;
    private String email;
    private transient ImageView image = new ImageView("file:pliki\\trojkat.png");

    /**
     * Inicjalizacja atrybutow klasy
     */
    public Klient() {
        Random rd = new Random();
        imie = Nazwy.losujImie();
        nazwisko = Nazwy.losujNazwisko();
        adresDostawy = Nazwy.losujAdres();
        nrtel = Nazwy.losujNrTelefonu();
        email = Nazwy.losujEmail();
        int x = rd.nextInt(750);
        int y = rd.nextInt(500) + 50;
        polozenie.setX(x);
        polozenie.setY(y);
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                zamow();
                sleep(30000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public String toString() {
        return "imie: " + getImie() + "\n"
                + "nazwisko: " + getNazwisko() + "\n"
                + "Numer telefonu: " + getNrtel() + "\n"
                + "Email: " + getEmail() + "\n" + "Adres Dostawy: " + getAdresDostawy() + "\n";
    }

    /**
     * metoda ustawiajaca obrazek klienta
     */
    @Override
    public void inicjalizuj() {
    }

    /**
     * usuwa klienta
     */
    @Override
    public void usun() {
        GUIFXMain.getRestauracja().getKlienci().remove(this);
    }

    /**
     * 
     */
    public void zamow() {
        Zamowienie z = new Zamowienie();
        z.setWlasciciel(this);
        GUIFXMain.getRestauracja().dodajZamowienie(z);
    }

    /**
     * @return the adresDostawy
     */
    public String getAdresDostawy() {
        return adresDostawy;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the image
     */
    @Override
    public ImageView getImage() {
        return image;
    }

    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * @return the nrtel
     */
    public String getNrtel() {
        return nrtel;
    }

    /**
     * @return the polozenie
     */
    public Polozenie getPolozenie() {
        return polozenie;
    }

    /**
     * @param adresDostawy the adresDostawy to set
     */
    public void setAdresDostawy(String adresDostawy) {
        this.adresDostawy = adresDostawy;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param image the image to set
     */
    public void setImage(ImageView image) {
        this.image = image;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * @param nazwisko the nazwisko to set
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * @param nrtel the nrtel to set
     */
    public void setNrtel(String nrtel) {
        this.nrtel = nrtel;
    }

    /**
     * @param polozenie the polozenie to set
     */
    public void setPolozenie(Polozenie polozenie) {
        this.polozenie = polozenie;
    }

}
