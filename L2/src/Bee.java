/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

import javafx.scene.image.ImageView;

/**
 * This abstract class represents a Bee, meant to be extended as each bee has a different
 * movement style. All other methods remain standard throughout Bee types.
 */
public abstract class Bee {
    public static final int MAX_ENERGY_LEVEL = 250;
    public static final int MIN_ENERGY_LEVEL = 0;
    public static final int ENERGY_LOSS = 1;
    public static final int STEP_INCREMENT = 25;

    private int energyLevel = MAX_ENERGY_LEVEL;
    private boolean isAlive = true;

    private String name;
    private Position position;
    private Flower targetFlower;
    private ImageView image;


    public Bee(String name, Position position, Flower targetFlower, ImageView image){
        this.name = name;
        this.position = position;
        this.targetFlower = targetFlower;
        this.image = image;
    }

    public abstract boolean move();

    public int getEnergyLevel(){
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel){
        if (energyLevel > MAX_ENERGY_LEVEL) {
            this.energyLevel = MAX_ENERGY_LEVEL;
        } else if (energyLevel < MIN_ENERGY_LEVEL){
            this.energyLevel = MIN_ENERGY_LEVEL;
        } else {
            this.energyLevel = energyLevel;
        }

    }

    public boolean isAlive(){
        if (energyLevel <= 0){
            isAlive = false;
        }
        return isAlive;
    }

    public String getName(){
        return name;
    }

    public Position getPosition(){
        return position;
    }

    public Flower getTargetFlower(){
        return targetFlower;
    }

    public void setTargetFlower(Flower targetFlower){
        this.targetFlower = targetFlower;
    }

    public ImageView getImage(){
        return image;
    }

    public int getStepIncrement(){
        return STEP_INCREMENT;
    }
}
