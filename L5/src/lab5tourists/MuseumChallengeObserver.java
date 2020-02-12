package lab5tourists;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import lab5tourists.mobileEntities.MobileEntity;
import lab5tourists.mobileEntities.Person;

public class MuseumChallengeObserver implements Observer {
    private Label label;
    private ImageView imageView;

    public MuseumChallengeObserver(Label label, ImageView imageView){
        this.label = label;
        this.imageView = imageView;
    }

    /**
     * Receives an update from the subjects it is observing
     * @param mobileEntities - the entity that triggered the update
     */
    public void update(MobileEntity[] mobileEntities){
        if (mobileEntities[0] instanceof Person){
            imageView.setVisible(true);
        }
    }
}
