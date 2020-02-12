package lab5tourists;

import lab5tourists.mobileEntities.MobileEntity;

/**
 * An interface to follow the Observer pattern
 */
public interface Subject {
    /**
     * Add an observer to the subject
     * @param o - the observer to be added
     */
    public void attach(Observer o);

    /**
     * Remove an observer from the subject
     * @param o - the observer to remove
     */
    public void detach(Observer o);

    /**
     * Notify all of the observers that are beings observed
     * @param entity - the entity that is causing the update
     */
    public void notifyObservers(MobileEntity entity);

}
