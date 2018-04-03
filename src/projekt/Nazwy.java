/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Krzysiu
 */
public class Nazwy {

    private static List<String> imiona = new ArrayList<>();
    private static List<String> nazwiska = new ArrayList<>();
    private static List<String> ulice = new ArrayList<>();
    private static List<String> pesel = new ArrayList<>();
    private static List<String> regon = new ArrayList<>();
    private static List<String> konta = new ArrayList<>();
    private static List<String> telefony = new ArrayList<>();
    private static List<String> maile = new ArrayList<>();
    private static List<String> posilki = new ArrayList<>();
    private static Random rd = new Random();

    /**
     *
     * @throws FileNotFoundException
     */
    public Nazwy() throws FileNotFoundException {
        File file = new File("pliki\\imiona.txt");
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            imiona.add(in.nextLine());
        }
        in.close();

        file = new File("pliki\\nazwiska.txt");
        in = new Scanner(file);
        while (in.hasNextLine()) {
            nazwiska.add(in.nextLine());
        }
        in.close();

        file = new File("pliki\\pesel.txt");
        in = new Scanner(file);
        while (in.hasNextLine()) {
            pesel.add(in.nextLine());
        }
        in.close();

        file = new File("pliki\\ulice.txt");
        in = new Scanner(file);
        while (in.hasNextLine()) {
            ulice.add(in.nextLine());
        }
        in.close();

        file = new File("pliki\\regon.txt");
        in = new Scanner(file);
        while (in.hasNextLine()) {
            regon.add(in.nextLine());
        }
        in.close();

        file = new File("pliki\\konta.txt");
        in = new Scanner(file);
        while (in.hasNextLine()) {
            konta.add(in.nextLine());
        }
        in.close();

        file = new File("pliki\\telefony.txt");
        in = new Scanner(file);
        while (in.hasNextLine()) {
            telefony.add(in.nextLine());
        }
        in.close();

        file = new File("pliki\\maile.txt");
        in = new Scanner(file);
        while (in.hasNextLine()) {
            maile.add(in.nextLine());
        }
        in.close();

        file = new File("pliki\\posilki.txt");
        in = new Scanner(file);
        while (in.hasNextLine()) {
            posilki.add(in.nextLine() + "\n" + in.nextLine() + "\n" + in.nextLine());
        }
        in.close();

    }

    /**
     *
     * @return losowe imie
     */
    public static String losujImie() {
        return getImiona().get(getRd().nextInt(getImiona().size()));
    }

    /**
     *
     * @return losowe nazwisko
     */
    public static String losujNazwisko() {
        return getNazwiska().get(getRd().nextInt(getNazwiska().size()));
    }

    /**
     *
     * @return losowy pesel
     */
    public static String losujPesel() {
        return getPesel().get(getRd().nextInt(getPesel().size()));
    }

    /**
     *
     * @return losowy adres
     */
    public static String losujAdres() {
        return getUlice().get(getRd().nextInt(getUlice().size())) + " " + getRd().nextInt(100);
    }

    /**
     *
     * @return losowy nrkonta
     */
    public static String losujNrKonta() {
        return getKonta().get(getRd().nextInt(getKonta().size()));
    }

    /**
     *
     * @return losowy regon
     */
    public static String losujRegon() {
        return getRegon().get(getRd().nextInt(getRegon().size()));
    }

    /**
     *
     * @return losowy nrtelefonu
     */
    public static String losujNrTelefonu() {
        return getTelefony().get(getRd().nextInt(getTelefony().size()));
    }

    /**
     *
     * @return losowy email
     */
    public static String losujEmail() {
        return getMaile().get(getRd().nextInt(getMaile().size()));
    }

    /**
     *
     * @return losowy posilek
     */
    public static String losujPosilek() {
        return getPosilki().get(getRd().nextInt(getPosilki().size()));
    }

    /**
     * @return the imiona
     */
    public static List<String> getImiona() {
        return imiona;
    }

    /**
     * @return the konta
     */
    public static List<String> getKonta() {
        return konta;
    }

    /**
     * @return the maile
     */
    public static List<String> getMaile() {
        return maile;
    }

    /**
     * @return the nazwiska
     */
    public static List<String> getNazwiska() {
        return nazwiska;
    }

    /**
     * @return the pesel
     */
    public static List<String> getPesel() {
        return pesel;
    }

    /**
     * @return the posilki
     */
    public static List<String> getPosilki() {
        return posilki;
    }

    /**
     * @return the rd
     */
    public static Random getRd() {
        return rd;
    }

    /**
     * @return the regon
     */
    public static List<String> getRegon() {
        return regon;
    }

    /**
     * @return the telefony
     */
    public static List<String> getTelefony() {
        return telefony;
    }

    /**
     * @return the ulice
     */
    public static List<String> getUlice() {
        return ulice;
    }

    /**
     * @param aImiona the imiona to set
     */
    public static void setImiona(List<String> aImiona) {
        imiona = aImiona;
    }

    /**
     * @param aKonta the konta to set
     */
    public static void setKonta(List<String> aKonta) {
        konta = aKonta;
    }

    /**
     * @param aMaile the maile to set
     */
    public static void setMaile(List<String> aMaile) {
        maile = aMaile;
    }

    /**
     * @param aNazwiska the nazwiska to set
     */
    public static void setNazwiska(List<String> aNazwiska) {
        nazwiska = aNazwiska;
    }

    /**
     * @param aPesel the pesel to set
     */
    public static void setPesel(List<String> aPesel) {
        pesel = aPesel;
    }

    /**
     * @param aPosilki the posilki to set
     */
    public static void setPosilki(List<String> aPosilki) {
        posilki = aPosilki;
    }

    /**
     * @param aRd the rd to set
     */
    public static void setRd(Random aRd) {
        rd = aRd;
    }

    /**
     * @param aRegon the regon to set
     */
    public static void setRegon(List<String> aRegon) {
        regon = aRegon;
    }

    /**
     * @param aTelefony the telefony to set
     */
    public static void setTelefony(List<String> aTelefony) {
        telefony = aTelefony;
    }

    /**
     * @param aUlice the ulice to set
     */
    public static void setUlice(List<String> aUlice) {
        ulice = aUlice;
    }

}
