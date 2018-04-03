/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import GUI.GUIFXMain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;

/**
 *
 * @author Krzysiu
 */
public class Dostawca extends Obiekt implements Serializable {

    private String imie;
    private String nazwisko;
    private String pesel;
    private Pojazd pojazd = new Pojazd();
    private Polozenie polozenie;
    private List<Zamowienie> zamowienia = new ArrayList<>();
    private transient ImageView image = new ImageView("file:pliki\\kwadrat.png");
    private Boolean powrot = false;
    private double paliwo;
    private transient StringProperty value = new SimpleStringProperty("0");

    /**
     * Inicjalizacja atrybutow klasy
     */
    public Dostawca() {
        Random rd = new Random();
        imie = Nazwy.losujImie();
        nazwisko = Nazwy.losujNazwisko();
        pesel = Nazwy.losujPesel();
        polozenie = new Polozenie();;
        image.setX(polozenie.getX());
        image.setY(polozenie.getY());
        paliwo = pojazd.getPojemnoscBaku();
    }

    @Override
    public void run() {

        while (!this.isInterrupted()) {
            try {
                if (getPolozenie().getX() == GUIFXMain.getRestauracja().getPolozenie().getX() && getPolozenie().getY() == GUIFXMain.getRestauracja().getPolozenie().getY()) {
                    while (getZamowienia().isEmpty()) {
                        GUIFXMain.getRestauracja().odbierzZamowienie(getZamowienia(), getPojazd().getLadownosc());
                    }
                }
                rozwiez();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     *
     * @throws InterruptedException
     */
    public void rozwiez() throws InterruptedException {
        while (!zamowienia.isEmpty() && getPowrot() == false) {
            Polozenie p2 = getZamowienia().get(0).getWlasciciel().getPolozenie();
            jedz(p2);
            if (getPolozenie().getX() == p2.getX() && getPolozenie().getY() == p2.getY()) {
                getZamowienia().remove(0);
                sleep(1000);
            }
        }
        powrot();

    }

    /**
     *
     * @param p2 polozenie do ktorego jedzie dostawca
     * @throws InterruptedException
     */
    public void jedz(Polozenie p2) throws InterruptedException {
        int x2 = p2.getX();
        int y2 = p2.getY();

        while (getPolozenie().getX() != x2 && getPowrot() == false) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    getImage().setRotate(0);
                    setPaliwo(getPaliwo() - 1);
                    getValue().setValue(String.valueOf("paliwo: " + Math.floor((getPaliwo() / getPojazd().getPojemnoscBaku()) * 1000) / 10) + "%");
                    if (getPolozenie().getX() < x2) {
                        getImage().setScaleX(1);
                        getPolozenie().setX(getPolozenie().getX() + 1);
                    } else {
                        getImage().setScaleX(-1);
                        getPolozenie().setX(getPolozenie().getX() - 1);
                    }
                    while (!GUIFXMain.czyWolne(image)) {

                        getPolozenie().setY(getPolozenie().getY() + 1);
                        getImage().setY(getPolozenie().getY());
                    }
                    getImage().setX(getPolozenie().getX());
                }
            });
            sleep(30);
        }
        while (getPolozenie().getY() != y2 && getPowrot() == false) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    getImage().setScaleX(1);
                    getImage().setRotate(90);
                    setPaliwo(getPaliwo() - 1);
                    getValue().setValue(String.valueOf("paliwo: " + Math.floor((getPaliwo() / getPojazd().getPojemnoscBaku()) * 1000) / 10) + "%");
                    if (getPolozenie().getY() < y2) {
                        getImage().setScaleX(1);
                        getPolozenie().setY(getPolozenie().getY() + 1);
                    } else {
                        getImage().setScaleX(-1);
                        getPolozenie().setY(getPolozenie().getY() - 1);
                    }
                    while (!GUIFXMain.czyWolne(image)) {
                        getPolozenie().setX(getPolozenie().getX() + 1);
                        getImage().setX(getPolozenie().getX());
                    }
                    getImage().setY(getPolozenie().getY());
                }
            });
            sleep(30);
        }
        sleep(50);
    }

    /**
     * dostawca wraca do restauracji
     *
     * @throws InterruptedException
     */
    public void powrot() throws InterruptedException {
        setPowrot((Boolean) false);
        jedz(GUIFXMain.getRestauracja().getPolozenie());
        setPaliwo(getPojazd().getPojemnoscBaku());
    }

    @Override
    public String toString() {
        return "imie: " + getImie() + "\n"
                + "nazwisko: " + getNazwisko() + "\n"
                + "pesel: " + getPesel() + "\n"
                + "ladownosc: " + getPojazd().getLadownosc() + "\n";
    }

    /**
     *
     * @return zmieniajaca sie w oknie informacyjnym ilosc paliwa
     */
    public StringProperty aktualizujPaliwo() {
        return getValue();
    }

    @Override
    public void inicjalizuj() {
        setImage(getPojazd().getNazwa().equals("samochod") ? new ImageView("file:pliki\\samochod.png") : new ImageView("file:pliki\\skuter.png"));
        setValue(new SimpleStringProperty("paliwo: 0"));
        getValue().setValue(String.valueOf(getPaliwo()));
    }

    @Override
    public void usun() {
        GUIFXMain.getRestauracja().getDostawcy().remove(this);
    }

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
     * @return the paliwo
     */
    public double getPaliwo() {
        return paliwo;
    }

    /**
     * @return the pesel
     */
    public String getPesel() {
        return pesel;
    }

    /**
     * @return the pojazd
     */
    public Pojazd getPojazd() {
        return pojazd;
    }

    /**
     * @return the polozenie
     */
    public Polozenie getPolozenie() {
        return polozenie;
    }

    /**
     * @return the powrot
     */
    public Boolean getPowrot() {
        return powrot;
    }

    /**
     * @return the value
     */
    public StringProperty getValue() {
        return value;
    }

    /**
     * @return the zamowienia
     */
    public List<Zamowienie> getZamowienia() {
        return zamowienia;
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
     * @param paliwo the paliwo to set
     */
    public void setPaliwo(double paliwo) {
        this.paliwo = paliwo;
    }

    /**
     * @param pesel the pesel to set
     */
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    /**
     * @param pojazd the pojazd to set
     */
    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }

    /**
     * @param polozenie the polozenie to set
     */
    public void setPolozenie(Polozenie polozenie) {
        this.polozenie = polozenie;
    }

    /**
     * @param powrot the powrot to set
     */
    public void setPowrot(Boolean powrot) {
        this.powrot = powrot;
    }

    /**
     * @param value the value to set
     */
    public void setValue(StringProperty value) {
        this.value = value;
    }

    /**
     * @param zamowienia the zamowienia to set
     */
    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

}
