/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

import javafx.scene.image.ImageView;

/**
 * This class represents the Poppy flower that steals energy from each Bee
 * when the bee contacts it.
 */
public class Poppy extends Flower {

    public Poppy(String name, ImageView image, Position position) {
        super(name, image, position);
    }

    @Override
    public void transferEnergy(Bee bee) {
        if (consumeNectar()){
            bee.setEnergyLevel(bee.getEnergyLevel() - (int) (Math.random() * MAX_ENERGY_TRANSFER));
        }

    }
}
