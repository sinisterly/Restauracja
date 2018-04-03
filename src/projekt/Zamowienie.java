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

/**
 *
 * @author Krzysiu
 */
public class Zamowienie implements Serializable {

    private List<Posilek> posilki = new ArrayList<>();
    private double cena;
    private Klient wlasciciel;

    /**
     * 
     */
    public Zamowienie() {
        Random rd = new Random();
        int n = rd.nextInt(5) + 1;
        if (n >= 3) {
            ZestawObiadowy z = new ZestawObiadowy();
            for (int i = 0; i < 3; i++) {
                Posilek p = GUIFXMain.getRestauracja().losujPosilek();
                z.getZestaw().add(p);
            }
            posilki.add(z);
            cena += z.getCena();
            n -= 3;
        }
        for (int i = 0; i < n; i++) {
            Posilek p = GUIFXMain.getRestauracja().losujPosilek();
            posilki.add(p);
            cena += p.getCena();
        }

    }

    @Override
    public String toString() {
        String s = "Zamowienie " + getWlasciciel().getImie() + " " + getWlasciciel().getNazwisko() + "\n";

        for (Posilek p : getPosilki()) {
            s += p.getNazwa() + " ";
        }
        s += "\n" + "cena: " + Math.floor(getCena() * 100) / 100 + " zl\n";
        return s;
    }

    /**
     * @return the cena
     */
    public double getCena() {
        return cena;
    }

    /**
     * @return the posilki
     */
    public List<Posilek> getPosilki() {
        return posilki;
    }

    /**
     * @return the wlasciciel
     */
    public Klient getWlasciciel() {
        return wlasciciel;
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(double cena) {
        this.cena = cena;
    }

    /**
     * @param posilki the posilki to set
     */
    public void setPosilki(List<Posilek> posilki) {
        this.posilki = posilki;
    }

    /**
     * @param wlasciciel the wlasciciel to set
     */
    public void setWlasciciel(Klient wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

}
