/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import GUI.GUIFXMain;
import static java.lang.Double.max;
import javafx.scene.image.ImageView;

/**
 *
 * @author Krzysiu
 */
public class KlientStaly extends Klient {

    private int punktyLojalnosciowe = 0;
    private int znizka = 5;
    private transient ImageView image;

    @Override
    public void inicjalizuj() {
        setImage(new ImageView("file:pliki\\dom3.png"));
    }

    @Override
    public void zamow() {
        Zamowienie z = new Zamowienie();
        z.setWlasciciel(this);
        z.setCena(z.getCena() - getZnizka());
        if (getPunktyLojalnosciowe() >= 80) {
            setPunktyLojalnosciowe(0);
            z.setCena(max(z.getCena() - 100, 0));
        }
        GUIFXMain.getRestauracja().dodajZamowienie(z);
        setPunktyLojalnosciowe(getPunktyLojalnosciowe() + 10);
    }

    @Override
    public String toString() {
        return super.toString() + "znika: " + getZnizka() + " zl\n" + "Punkty Lojalnosciowe: " + getPunktyLojalnosciowe() + "\n";
    }

    /**
     * @return the image
     */
    @Override
    public ImageView getImage() {
        return image;
    }

    /**
     * @return the punktyLojalnosciowe
     */
    public int getPunktyLojalnosciowe() {
        return punktyLojalnosciowe;
    }

    /**
     * @return the znizka
     */
    public int getZnizka() {
        return znizka;
    }

    /**
     * @param image the image to set
     */
    @Override
    public void setImage(ImageView image) {
        this.image = image;
    }

    /**
     * @param punktyLojalnosciowe the punktyLojalnosciowe to set
     */
    public void setPunktyLojalnosciowe(int punktyLojalnosciowe) {
        this.punktyLojalnosciowe = punktyLojalnosciowe;
    }

    /**
     * @param znizka the znizka to set
     */
    public void setZnizka(int znizka) {
        this.znizka = znizka;
    }

}
