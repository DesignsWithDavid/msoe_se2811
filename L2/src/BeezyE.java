/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

import javafx.scene.image.ImageView;

/**
 * This Bee implements the Euclidean distance method for move.
 * It targets a flower and moves to that flower it has targeted.
 */
public class BeezyE extends Bee {

    public BeezyE(String name, Position position, Flower targetFlower, ImageView image){
        super(name, position, targetFlower, image);
    }

    @Override
    public boolean move() {
        setEnergyLevel(getEnergyLevel()-ENERGY_LOSS);
        if (isAlive()){
            Position flowerPosition = getTargetFlower().getPosition();
            Position beePosition = getPosition();
            int stepIncrement = getStepIncrement();

            double currentX = beePosition.getCurrentX();
            double currentY = beePosition.getCurrentY();
            double desiredX = flowerPosition.getCurrentX() - currentX;
            double desiredY = flowerPosition.getCurrentY() - currentY;

            double max = Math.max(Math.abs(desiredX), Math.abs(desiredY));
            desiredX = (desiredX/max)*stepIncrement + currentX;
            desiredY = (desiredY/max)*stepIncrement + currentY;

            //ensure the number value always exists
            desiredX = (Double.isNaN(desiredX))?currentX:desiredX;
            desiredY = (Double.isNaN(desiredY))?currentY:desiredY;
            return beePosition.setCurrentX(desiredX) & beePosition.setCurrentY(desiredY);
        }
        return false;

    }
}
