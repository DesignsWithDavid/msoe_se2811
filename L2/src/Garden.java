/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents the Garden that stores all of the Bees and
 * Flowers. It also allows the user to press the arrow key to advance
 * in time through each Bee movement.
 */
public class Garden {
    public static final double ACCURACY = 25;
    private ArrayList<Flower> flowers;
    private ArrayList<Bee> bees;


    public Garden() {
        Random random = new Random();
        flowers = new ArrayList<>();
        flowers.add(new Coca("Coca",
                new ImageView(new Image("file:coca flower.png")),
                new Position(random.nextInt(GardenController.WINDOW_WIDTH),
                        random.nextInt(GardenController.WINDOW_HEIGHT))));
        flowers.add(new Poppy("Poppy",
                new ImageView(new Image("file:poppy flower.png")),
                new Position(random.nextInt(GardenController.WINDOW_WIDTH),
                        random.nextInt(GardenController.WINDOW_HEIGHT))));

        bees = new ArrayList<>();

        bees.add(new BeezyE("Beezy-E",
                new Position(random.nextInt(GardenController.WINDOW_WIDTH),
                        random.nextInt(GardenController.WINDOW_HEIGHT)),
                flowers.get(random.nextInt(flowers.size())),
                new ImageView(new Image("file:bee-1.jpg"))));
        bees.add(new CardiBee("Cardi-Bee",
                new Position(random.nextInt(GardenController.WINDOW_WIDTH),
                        random.nextInt(GardenController.WINDOW_HEIGHT)),
                flowers.get(random.nextInt(flowers.size())),
                new ImageView(new Image("file:bee-2.jpg"))));
    }

    public Garden(int numCocas, int numPoppies, int numBeezyEs, int numCardiBees) {
        Random random = new Random();
        flowers = new ArrayList<>();
        bees = new ArrayList<>();

        for (int i = 0; i < numCocas; i++){
            flowers.add(new Coca("Coca" + i,
                    new ImageView(new Image("file:coca flower.png")),
                    new Position(random.nextInt(GardenController.WINDOW_WIDTH),
                            random.nextInt(GardenController.WINDOW_HEIGHT))));
        }

        for (int i = 0; i < numPoppies; i++){
            flowers.add(new Poppy("Poppy" + i,
                    new ImageView(new Image("file:poppy flower.png")),
                    new Position(random.nextInt(GardenController.WINDOW_WIDTH),
                            random.nextInt(GardenController.WINDOW_HEIGHT))));
        }

        for (int i = 0; i < numBeezyEs; i++){
            bees.add(new BeezyE("Beezy-E" + i,
                    new Position(random.nextInt(GardenController.WINDOW_WIDTH),
                            random.nextInt(GardenController.WINDOW_HEIGHT)),
                    flowers.get(random.nextInt(flowers.size())),
                    new ImageView(new Image("file:bee-1.jpg"))));
        }

        for (int i = 0; i < numCardiBees; i++){
            bees.add(new CardiBee("Cardi-Bee" + i,
                    new Position(random.nextInt(GardenController.WINDOW_WIDTH),
                            random.nextInt(GardenController.WINDOW_HEIGHT)),
                    flowers.get(random.nextInt(flowers.size())),
                    new ImageView(new Image("file:bee-2.jpg"))));
        }

    }

    private boolean areTouching(Position position1, Position position2) {
        double x = (position1.getCurrentX() - position2.getCurrentX());
        double y = (position1.getCurrentY() - position2.getCurrentY());
        double euc_distance = Math.sqrt(x * x + y * y);
        return euc_distance < ACCURACY;
    }


    public void move() {
        for (Bee bee : bees) {
            bee.move();
        }
        checkIfTouching();
    }

    private void checkIfTouching(){
        for (Bee bee: bees){
            for (Flower flower: flowers){
                if(areTouching(bee.getPosition(), flower.getPosition())){
                    flower.transferEnergy(bee);
                    Flower newFlower;
                    Random random = new Random();
                    do {
                        newFlower = flowers.get(random.nextInt(flowers.size()));
                    } while (newFlower == bee.getTargetFlower());
                    bee.setTargetFlower(newFlower);
                }
            }
        }
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public ArrayList<Bee> getBees() {
        return bees;
    }
}
