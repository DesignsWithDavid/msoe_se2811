/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

import javafx.scene.image.ImageView;

/**
 * This abstract class represents a flower.
 * The only abstract method in this class is its transfer energy method,
 * which changes based on the type of flower. Coca gives energy and
 * Poppy steals energy. The boolean hasNectar keeps track of whether
 * the flower has any nectar after a bee has contacted it.
 */
public abstract class Flower {
    public static final int MAX_ENERGY_TRANSFER = 50;

    private String name;
    private ImageView image;
    private Position position;
    private boolean hasNectar;


    public Flower(String name, ImageView image, Position position) {
        this.name = name;
        this.image = image;
        this.position = position;
        this.hasNectar = true;
    }

    public boolean getNectar(){
        return hasNectar;
    }

    public String getName() {
        return name;
    }

    public ImageView getImage() {
        return image;
    }

    public Position getPosition() {
        return position;
    }

    public boolean consumeNectar(){
        if (hasNectar){
            hasNectar = false;
            return true;
        }
        return false;
    }

    public abstract void transferEnergy(Bee bee);
}
