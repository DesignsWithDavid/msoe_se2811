/*
 * Course:     SE 2811
 * Term:       Winter 2018-19
 * Assignment: Lab 5: Tourists
 * Author:     Dr. Yoder and YOUR NAME HERE
 * Date:       13 Jan 2019
 */
package lab5tourists;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lab5tourists.mobileEntities.MobileEntity;

import java.util.ArrayList;

/**
 * A rectangular area representing an art museum.
 *
 * The Museum is similar to a MobileEntity, except that it does not move
 * and it has a rectangular rather than circular tag area.
 */
public class Museum implements Taggable, Subject {
    public static final int MUSEUM_WIDTH = 40;
    public static final int MUSEUM_HEIGHT = 50;
    public static final int MUSEUM_LEFT_CORNER = 500-64;
    public static final int MUSEUM_TOP_CORNER = 250+3;
    private final Rectangle area;

    private ArrayList<Observer> observers = new ArrayList<>();

    public Museum(CityMap cityMap) {
        area = new Rectangle(MUSEUM_WIDTH, MUSEUM_HEIGHT);
        area.setStroke(Color.RED);
        area.setFill(Color.RED.deriveColor(1, 1, 1, 0.2));
        area.relocate(MUSEUM_LEFT_CORNER, MUSEUM_TOP_CORNER);

        cityMap.addNodeToMap(area);
        cityMap.addTaggableToMap(this);
    }

    /**
     * Determines if point falls within the rectangular region shown on the map
     * @param location The location to check
     * @return true of within region
     */
    @Override
    public boolean isTagged(Point2D location) {
        return location.getX() > MUSEUM_LEFT_CORNER
            && location.getY() > MUSEUM_TOP_CORNER
            && location.getX() < MUSEUM_LEFT_CORNER + MUSEUM_WIDTH
            && location.getY() < MUSEUM_TOP_CORNER + MUSEUM_HEIGHT;
    }

    /**
     * Respond to being tagged by another entity.
     * @param entity The entity performing the tagging.
     */
    @Override
    public void taggedBy(MobileEntity entity) {
        notifyObservers(entity);
    }

    /**
     * @return a unique description of this Museum, including a hashcode
     */
    @Override
    public String toString() {
        return "Museum "+Integer.toHexString(super.hashCode());
    }

    public void attach(Observer o){
        observers.add(o);
    }

    public void detach(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(MobileEntity entity){
        MobileEntity[] mobileEntities = new MobileEntity[1];
        mobileEntities[0] = entity;
        for (Observer observer:observers) {
            observer.update(mobileEntities);
        }
    }
}
