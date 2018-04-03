/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Krzysiu
 */
public class Pojazd implements Serializable {

    private int ladownosc;
    private int pojemnoscBaku;
    private String nazwa;

    /**
     * Inicjalizacja atrybutow klasy
     */
    public Pojazd() {

        Random rd = new Random();
        ladownosc = rd.nextInt(5) + 1;
        pojemnoscBaku = rd.nextInt(10000) + 10000;
        nazwa = rd.nextInt(2) == 1 ? "samochod" : "skuter";
    }

    /**
     * @return the ladownosc
     */
    public int getLadownosc() {
        return ladownosc;
    }

    /**
     * @return the nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * @return the pojemnoscBaku
     */
    public int getPojemnoscBaku() {
        return pojemnoscBaku;
    }

    /**
     * @param ladownosc the ladownosc to set
     */
    public void setLadownosc(int ladownosc) {
        this.ladownosc = ladownosc;
    }

    /**
     * @param nazwa the nazwa to set
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * @param pojemnoscBaku the pojemnoscBaku to set
     */
    public void setPojemnoscBaku(int pojemnoscBaku) {
        this.pojemnoscBaku = pojemnoscBaku;
    }

}
