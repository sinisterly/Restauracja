/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import GUI.GUIFXMain;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Krzysiu
 */
public class Restauracja implements Serializable {

    private List<Posilek> menu = new ArrayList<>();
    private List<Zamowienie> zamowienia = new ArrayList<>();
    private Set<Klient> klienci = new HashSet<>();
    private Set<Dostawca> dostawcy = new HashSet<>();
    private Polozenie polozenie = new Polozenie();

    /**
     *
     * @return true jesli nie ma klientow w restauracji, false w przeciwnym wypadku
     */
    public boolean brakKlientow() {
        return getKlienci().isEmpty();
    }

    /**
     *
     * @return dodanu posilek
     */
    public Posilek dodajPosilek() {
        Posilek p = new Posilek();
        getMenu().add(p);
        return p;
    }

    /**
     *
     * @return wylosowany posilek
     */
    public Posilek losujPosilek() {
        Random rd = new Random();
        Posilek p = getMenu().get(rd.nextInt(getMenu().size()));
        return p;
    }

    /**
     *
     * @return wylosowany klient
     */
    public Klient losujKlienta() {
        Random rd = new Random();
        Klient k = getKlienci().iterator().next();
        return k;
    }

    /**
     *
     * @return string zawierajacy opis posilkow
     */
    public String wyswietlPosilki() {
        String s = "";
        for (Posilek p : getMenu()) {
            s += p;
            s += '\n';
        }
        return s;
    }

    /**
     *
     * @param z zamowienie
     */
    public synchronized void dodajZamowienie(Zamowienie z) {
        getZamowienia().add(z);
    }

    /**
     *
     * @return true jesli nie ma zamowien w restauracji, false w przeciwnym wypadku
     */
    public synchronized boolean brakZamowien() {
        return getZamowienia().isEmpty();
    }

    /**
     *
     * @param zamowieniaDostawcy lista zamowien dosyawcy
     * @param ile ladownosc pojazdu dostawcy
     */
    public synchronized void odbierzZamowienie(List<Zamowienie> zamowieniaDostawcy, int ile) {
        for (int i = 0; i < ile && !zamowienia.isEmpty(); i++) {
            Zamowienie z = getZamowienia().get(0);
            getZamowienia().remove(0);
            zamowieniaDostawcy.add(z);
        }
    }

    /**
     *
     * @return string zawierajacy liste zamowien
     */
    public String wyswietlZamowienia() {
        String s = "";
        for (Zamowienie z : getZamowienia()) {
            s += z;
            s += '\n';
        }
        return s;
    }

    /**
     *
     * @return dodany klient okazjonalny
     */
    public Klient dodajKlientaOkazjonalnego() {
        Klient k = new KlientOkazjonalny();
        getKlienci().add(k);
        k.setDaemon(true);
        k.start();
        return k;
    }

    /**
     *
     * @return dodany klient firmowy
     */
    public Klient dodajKlientaFirmowego() {
        Klient k = new KlientFirmowy();
        getKlienci().add(k);
        k.setDaemon(true);
        k.start();
        return k;
    }

    /**
     *
     * @return dodany klient staly
     */
    public Klient dodajKlientaStalego() {
        Klient k = new KlientStaly();
        getKlienci().add(k);
        k.setDaemon(true);
        k.start();
        return k;
    }

    /**
     *
     * @return string zawierajacy liste klientow
     */
    public String wyswietlKlientow() {
        String s = "";
        for (Klient k : getKlienci()) {
            s += k;
            s += '\n';
        }
        return s;
    }

    /**
     *
     * @return dodany dostawca
     */
    public Dostawca dodajDostawce() {
        Dostawca d = new Dostawca();
        getDostawcy().add(d);
        d.setDaemon(true);
        d.start();
        return d;
    }

    /**
     *
     * @return string zawierajacy liste dostawcow
     */
    public String wyswietlDostawcow() {
        String s = "";
        for (Dostawca d : getDostawcy()) {
            s += d;
            s += '\n';
        }
        return s;
    }

    /**
     * metoda uruchamiajaca watki po deserializacji
     */
    public void startuj() {
        for (Klient k : getKlienci()) {
            GUIFXMain.getMapaController().dodajObiekt(k, k.getPolozenie().getX(), k.getPolozenie().getY());
            k.setDaemon(true);
            k.start();
        }
        for (Dostawca d : getDostawcy()) {
            GUIFXMain.getMapaController().dodajObiekt(d, d.getPolozenie().getX(), d.getPolozenie().getY());
            d.setDaemon(true);
            d.start();
        }
    }

    /**
     * @return the dostawcy
     */
    public Set<Dostawca> getDostawcy() {
        return dostawcy;
    }

    /**
     * @return the klienci
     */
    public Set<Klient> getKlienci() {
        return klienci;
    }

    /**
     * @return the menu
     */
    public List<Posilek> getMenu() {
        return menu;
    }

    /**
     * @return the polozenie
     */
    public Polozenie getPolozenie() {
        return polozenie;
    }

    /**
     * @return the zamowienia
     */
    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    /**
     * @param dostawcy the dostawcy to set
     */
    public void setDostawcy(Set<Dostawca> dostawcy) {
        this.dostawcy = dostawcy;
    }

    /**
     * @param klienci the klienci to set
     */
    public void setKlienci(Set<Klient> klienci) {
        this.klienci = klienci;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(List<Posilek> menu) {
        this.menu = menu;
    }

    /**
     * @param polozenie the polozenie to set
     */
    public void setPolozenie(Polozenie polozenie) {
        this.polozenie = polozenie;
    }

    /**
     * @param zamowienia the zamowienia to set
     */
    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

}
