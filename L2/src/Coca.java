/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

import javafx.scene.image.ImageView;

/**
 * This flower transfers energy to the Bee in a positive manner.
 * It adds energy to the Bee.
 */
public class Coca extends Flower {

    public Coca(String name, ImageView image, Position position) {
        super(name, image, position);
    }

    @Override
    public void transferEnergy(Bee bee) {
        if (consumeNectar()){
            bee.setEnergyLevel(bee.getEnergyLevel() + (int) (Math.random() * MAX_ENERGY_TRANSFER));
        }
    }
}
