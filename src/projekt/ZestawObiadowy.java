/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Krzysiu
 */
public class ZestawObiadowy extends Posilek {

    private List<Posilek> zestaw = new ArrayList<>();
    private double cena;

    @Override
    public double getCena() {
        for (Posilek p : getZestaw()) {
            cena += p.getCena();
        }
        cena *= 0.8;
        return cena;
    }

    @Override
    public String getNazwa() {
        String s = "Zestaw: ";
        for (Posilek p : getZestaw()) {
            s += p.getNazwa() + " ";
        }
        return s;
    }

    /**
     * @return the zestaw
     */
    public List<Posilek> getZestaw() {
        return zestaw;
    }

    /**
     * @param zestaw the zestaw to set
     */
    public void setZestaw(List<Posilek> zestaw) {
        this.zestaw = zestaw;
    }

}
