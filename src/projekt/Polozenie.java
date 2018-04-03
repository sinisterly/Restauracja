/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.io.Serializable;

/**
 *
 * @author Krzysiu
 */
public class Polozenie implements Serializable {

    private int x;
    private int y;

    /**
     * Inicjalizacja atrybutow klasy
     */
    public Polozenie() {
        x = 0;
        y = 50;
    }

    @Override
    public String toString() {
        return getX() + " " + getY();
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

}
