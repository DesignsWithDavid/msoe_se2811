/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

import javafx.scene.image.ImageView;

/**
 * This Bee simply moves back and forth across the garden in a standard pattern
 * until it contacts a flower. Its movement pattern can be described as random.
 */
public class CardiBee extends Bee{
    private boolean up = true;
    private boolean right = true;

    public CardiBee(String name, Position position, Flower targetFlower, ImageView image){
        super(name, position, targetFlower, image);
    }

    @Override
    public boolean move() {
        setEnergyLevel(getEnergyLevel()-ENERGY_LOSS);
        if (isAlive()) {
            Position position = getPosition();
            int stepIncrement = getStepIncrement();

            if (!moveVertical(position, stepIncrement)) {
                moveHorizontal(position, stepIncrement);
            }
            return true;
        }
        return false;
    }

    private boolean moveVertical(Position position, int stepIncrement){
        double currentY = position.getCurrentY();
        double desiredY;

        if (up){
            if (currentY > 0){
                desiredY = currentY - stepIncrement;
            }else{
                up = false;
                return false;
            }
        } else{
            if (currentY < GardenController.WINDOW_HEIGHT){
                desiredY = currentY + stepIncrement;
            } else{
                up = true;
                return false;
            }
        }
        position.setCurrentY(desiredY);
        return true;
    }

    private void moveHorizontal(Position position, int stepIncrement){
        double currentX = position.getCurrentX();
        double desiredX;

        if (right){
            if (currentX < GardenController.WINDOW_WIDTH){
                desiredX = currentX + stepIncrement;
            }else{
                right = false;
                desiredX = currentX - stepIncrement;
            }
        } else{
            if (currentX > 0){
                desiredX = currentX - stepIncrement;
            } else{
                right = true;
                desiredX = currentX + stepIncrement;
            }
        }

        position.setCurrentX(desiredX);
    }

}
