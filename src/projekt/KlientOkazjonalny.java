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
public class KlientOkazjonalny extends Klient {

    private transient ImageView image;

    @Override
    public void inicjalizuj() {
        setImage(new ImageView("file:pliki\\dom1.png"));
    }

    /**
     * @return the image
     */
    @Override
    public ImageView getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    @Override
    public void setImage(ImageView image) {
        this.image = image;
    }

}
