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
public class Posilek implements Serializable {

    private String nazwa;
    private String skladniki;
    private double cena;
    private String kategoria;

    /**
     * Inicjalizacja atrybutow klasy
     */
    public Posilek() {
        Random rd = new Random();
        String s[] = Nazwy.losujPosilek().split("\n");
        kategoria = s[0];
        nazwa = s[1];
        skladniki = s[2];
        cena = rd.nextInt(40) + 10;
    }

    @Override
    public String toString() {
        return "kategoria: " + getKategoria() + "\n" + "nazwa: " + getNazwa() + "\n" + "skladniki: " + getSkladniki() + "\n" + "cena: " + getCena() + " zl" + "\n";
    }

    /**
     * @return the cena
     */
    public double getCena() {
        return cena;
    }

    /**
     * @return the kategoria
     */
    public String getKategoria() {
        return kategoria;
    }

    /**
     * @return the nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * @return the skladniki
     */
    public String getSkladniki() {
        return skladniki;
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(double cena) {
        this.cena = cena;
    }

    /**
     * @param kategoria the kategoria to set
     */
    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    /**
     * @param nazwa the nazwa to set
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * @param skladniki the skladniki to set
     */
    public void setSkladniki(String skladniki) {
        this.skladniki = skladniki;
    }

}
