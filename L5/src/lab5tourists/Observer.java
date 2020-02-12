package lab5tourists;

import lab5tourists.mobileEntities.MobileEntity;

/**
 * An interface to follow the Observer pattern
 */
public interface Observer {
    /**
     * Receives an update from the subjects it is observing
     * @param mobileEntities - the entity that triggered the update
     */
    public void update(MobileEntity[] mobileEntities);
}
