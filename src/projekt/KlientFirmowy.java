/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import javafx.scene.image.ImageView;

/**
 *
 * @author Krzysiu
 */
public class KlientFirmowy extends Klient {

    private String adresKorespondencyjny;
    private String numerKontaBankowego;
    private String regon;
    private transient ImageView image;

    @Override
    public void inicjalizuj() {
        setImage(new ImageView("file:pliki\\dom2.png"));
    }

    /**
     * Inicjalizacja atrybutow klasy
     */
    public KlientFirmowy() {
        adresKorespondencyjny = Nazwy.losujAdres();
        numerKontaBankowego = Nazwy.losujNrKonta();
        regon = Nazwy.losujRegon();
    }

    @Override
    public String toString() {
        return super.toString()
                + "Adres Korespondencyjny: " + getAdresKorespondencyjny() + "\n"
                + "Numer Konta: " + getNumerKontaBankowego() + "\n"
                + "Regon: " + getRegon() + "\n";
    }

    /**
     * @return the adresKorespondencyjny
     */
    public String getAdresKorespondencyjny() {
        return adresKorespondencyjny;
    }

    /**
     * @return the image
     */
    @Override
    public ImageView getImage() {
        return image;
    }

    /**
     * @return the numerKontaBankowego
     */
    public String getNumerKontaBankowego() {
        return numerKontaBankowego;
    }

    /**
     * @return the regon
     */
    public String getRegon() {
        return regon;
    }

    /**
     * @param adresKorespondencyjny the adresKorespondencyjny to set
     */
    public void setAdresKorespondencyjny(String adresKorespondencyjny) {
        this.adresKorespondencyjny = adresKorespondencyjny;
    }

    /**
     * @param image the image to set
     */
    @Override
    public void setImage(ImageView image) {
        this.image = image;
    }

    /**
     * @param numerKontaBankowego the numerKontaBankowego to set
     */
    public void setNumerKontaBankowego(String numerKontaBankowego) {
        this.numerKontaBankowego = numerKontaBankowego;
    }

    /**
     * @param regon the regon to set
     */
    public void setRegon(String regon) {
        this.regon = regon;
    }

}
