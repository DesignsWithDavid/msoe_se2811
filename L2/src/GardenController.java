/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class controls the Garden. It displays the bees, flowers,
 * and updates each of their attributes on key pressed.
 */
public class GardenController {
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;

    // images to draw on the panel
    private ArrayList<ImageView> images = new ArrayList<>();
    private Garden garden;
    private ArrayList<Label> beeLabels = new ArrayList<>();
    //private ArrayList<Label> flowerLabels = new ArrayList<>();

    @FXML
    public ImageView cardiBee = new ImageView(new Image("file:bee-2.jpg"));
    @FXML
    public ImageView beezyE = new ImageView(new Image("file:bee-1.jpg"));
    @FXML
    public ImageView cocaView = new ImageView(new Image("file:coca flower.png"));
    @FXML
    public ImageView poppyView = new ImageView(new Image("file:poppy flower.png"));

    @FXML
    private Pane theGarden;                 // capture the pane we are drawing on from JavaFX

    @FXML
    public void initialize() {              // executed after scene is loaded but before any methods
        // note the label has a Z index of 2 so it is drawn above the panel, otherwise it may be displayed "under" the panel and not be visible
        theGarden.setStyle("-fx-background-color: forestgreen;");
        theGarden.setPrefWidth(WINDOW_WIDTH + 150);
        theGarden.setPrefHeight(WINDOW_HEIGHT + 150);

        // create a garden
        //garden = new Garden(1, 1, 1, 1);
        garden = new Garden(10, 5, 1, 1);

        // load images from a file; the file needs to be in the top folder of the project
        for (Bee bee : garden.getBees()) {
            ImageView newImage = bee.getImage();
            newImage.setPreserveRatio(true);
            newImage.setFitWidth(50.0);
            images.add(newImage);
        }
        updateHealth();
        for (Flower flower : garden.getFlowers()) {
            //Label health = new Label("Full");
            //health.setLayoutX(flower.getPosition().getCurrentX());
            //health.setLayoutY(flower.getPosition().getCurrentY() + 10);
            //flowerLabels.add(health);
            ImageView newImage = flower.getImage();
            newImage.setPreserveRatio(true);
            newImage.setFitWidth(50.0);
            images.add(newImage);
        }
        theGarden.getChildren().addAll(images);
        theGarden.getChildren().addAll(beeLabels);
        //theGarden.getChildren().addAll(flowerLabels);
        displayFlowers();
        displayBees();
        theGarden.setFocusTraversable(true); // ensure garden pane will receive keypresses

        createLegend();
    }

    // display the bee at the (beeXLocation, beeYLocation), ensuring the bee does not leave the garden
    private void displayBees() {
        for (Bee bee : garden.getBees()) {
            double beeXLocation = bee.getPosition().getCurrentX();
            double beeYLocation = bee.getPosition().getCurrentY();

            if (beeXLocation < 0)
                beeXLocation = 0;
            else if (theGarden.getWidth() > 0 && beeXLocation > theGarden.getWidth() - 10)
                // note: getWidth() is 0 when first load the scene, so don't relocate the bee in that case
                beeXLocation = theGarden.getWidth() - 10;
            if (beeYLocation < 0)
                beeYLocation = 0;
            else if (theGarden.getHeight() > 0 && beeYLocation > theGarden.getHeight() - 10)
                beeYLocation = theGarden.getHeight() - 10;
            bee.getImage().setLayoutX(beeXLocation);
            bee.getImage().setLayoutY(beeYLocation);
        }

    }

    // display the flower at the (beeXLocation, beeYLocation), ensuring the bee does not leave the garden
    private void displayFlowers() {
        for (Flower flower : garden.getFlowers()) {
            double beeXLocation = flower.getPosition().getCurrentX();
            double beeYLocation = flower.getPosition().getCurrentY();

            if (beeXLocation < 0)
                beeXLocation = 0;
            else if (theGarden.getWidth() > 0 && beeXLocation > theGarden.getWidth() - 10)
                // note: getWidth() is 0 when first load the scene, so don't relocate the bee in that case
                beeXLocation = theGarden.getWidth() - 10;
            if (beeYLocation < 0)
                beeYLocation = 0;
            else if (theGarden.getHeight() > 0 && beeYLocation > theGarden.getHeight() - 10)
                beeYLocation = theGarden.getHeight() - 10;
            flower.getImage().setLayoutX(beeXLocation);
            flower.getImage().setLayoutY(beeYLocation);
        }

    }

    public void updateHealth() {
        for (int i = 0; i < garden.getBees().size(); i++) {
            Label health = new Label(Bee.MAX_ENERGY_LEVEL + "/" + Bee.MAX_ENERGY_LEVEL);
            health.setLayoutX(garden.getBees().get(i).getPosition().getCurrentX());
            health.setLayoutY(garden.getBees().get(i).getPosition().getCurrentY() + 10);
            beeLabels.add(health);
        }
    }

    private void displayBeeHealth() {
        int x = 0;
        for (Label label : beeLabels) {
            double currentX = garden.getBees().get(x).getPosition().getCurrentX();
            double currentY = garden.getBees().get(x).getPosition().getCurrentY();
            label.setText(garden.getBees().get(x).getEnergyLevel() + "/" + Bee.MAX_ENERGY_LEVEL);

            if (currentX < 0)
                currentX = 0;
            else if (theGarden.getWidth() > 0 && currentX > theGarden.getWidth() - 10)
                // note: getWidth() is 0 when first load the scene, so don't relocate the bee in that case
                currentX = theGarden.getWidth() - 10;
            if (currentY < 0)
                currentY = 0;
            else if (theGarden.getHeight() > 0 && currentY > theGarden.getHeight() - 10)
                currentY = theGarden.getHeight() - 10;
            label.setLayoutX(currentX);
            label.setLayoutY(currentY);
            x++;
            if (x == 2) {
                x = 0;
            }
        }

    }

//    public void displayFlowerHealth() {
//        int x = 0;
//        for (Label label : flowerLabels) {
//            double currentX = garden.getFlowers().get(x).getPosition().getCurrentX();
//            double currentY = garden.getFlowers().get(x).getPosition().getCurrentY();
//            if (garden.getFlowers().get(x).getNectar()){
//                label.setText("Full");
//            } else {
//                label.setText("Empty");
//                //garden.getFlowers().get(x).getImage().setBlendMode(BlendMode.DARKEN);
//            }
//
//            if (currentX < 0)
//                currentX = 0;
//            else if (theGarden.getWidth() > 0 && currentX > theGarden.getWidth() - 10)
//                // note: getWidth() is 0 when first load the scene, so don't relocate the bee in that case
//                currentX = theGarden.getWidth() - 10;
//            if (currentY < 0)
//                currentY = 0;
//            else if (theGarden.getHeight() > 0 && currentY > theGarden.getHeight() - 10)
//                currentY = theGarden.getHeight() - 10;
//            label.setLayoutX(currentX);
//            label.setLayoutY(currentY);
//            x++;
//            if (x == garden.getFlowers().size() - 1) {
//                x = 0;
//            }
//        }
//
//    }

    public void displayFlowerHealth(){
        for (Flower flower:garden.getFlowers()){
            if (!flower.getNectar()){
                flower.getImage().setBlendMode(BlendMode.DARKEN);
            }
        }
    }


    @FXML
    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            garden.move();
        }
        displayBees();
        displayBeeHealth();
        displayFlowerHealth();
    }

    private void createLegend(){
        int width = 20;

        Pane legend = new Pane();
        Random random = new Random();
        legend.setStyle("-fx-background-color: white;");
        legend.setPrefSize(200,100);

        ImageView beezyEView = new ImageView(new Image("file:bee-1.jpg"));
        beezyEView.setPreserveRatio(true);
        beezyEView.setFitWidth(width);
        beezyEView.setX(0);
        beezyEView.setY(0);
        Label beezyELabel = new Label("Flies from Flower to Flower");
        beezyELabel.setLayoutX(30);
        beezyELabel.setLayoutY(0);

        ImageView cardiBeeView = new ImageView(new Image("file:bee-2.jpg"));
        cardiBeeView.setPreserveRatio(true);
        cardiBeeView.setFitWidth(width);
        cardiBeeView.setX(0);
        cardiBeeView.setY(25);
        Label cardiBeeLabel = new Label("Flies in Line Pattern");
        cardiBeeLabel.setLayoutX(30);
        cardiBeeLabel.setLayoutY(25);

        ImageView poppyView = new ImageView(new Image("file:poppy flower.png"));
        poppyView.setPreserveRatio(true);
        poppyView.setFitWidth(width);
        poppyView.setX(0);
        poppyView.setY(50);
        Label poppyLabel = new Label("Gives Energy");
        poppyLabel.setLayoutX(30);
        poppyLabel.setLayoutY(50);

        ImageView cocaView = new ImageView(new Image("file:coca flower.png"));
        cocaView.setPreserveRatio(true);
        cocaView.setFitWidth(width);
        cocaView.setX(0);
        cocaView.setY(75);
        Label cocaLabel = new Label("Consumes Energy");
        cocaLabel.setLayoutX(30);
        cocaLabel.setLayoutY(75);

        legend.getChildren().addAll(beezyEView, beezyELabel,
                cardiBeeView, cardiBeeLabel,
                cocaView, cocaLabel,
                poppyView, poppyLabel);
        theGarden.getChildren().add(legend);
    }
}
