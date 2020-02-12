package lab5tourists;

import javafx.scene.control.Label;
import lab5tourists.mobileEntities.Bus;
import lab5tourists.mobileEntities.Car;
import lab5tourists.mobileEntities.MobileEntity;
import lab5tourists.mobileEntities.Person;

public class BusChallengeObserver implements Observer {
    private Label label;
    private String challenge = "***";
    private boolean busFound = false;
    private boolean challengeComplete = false;

    public BusChallengeObserver(Label label){
        this.label = label;
    }

    /**
     * Receives an update from the subjects it is observing
     * @param mobileEntities - the entity that triggered the update
     */
    public void update(MobileEntity[] mobileEntities){
        if (!busFound) {
            if ((mobileEntities[0] instanceof Person && mobileEntities[1] instanceof Bus) || (mobileEntities[1] instanceof Person && mobileEntities[0] instanceof Bus)) {
                busFound = true;
                label.setVisible(true);
            }
        } else if (!challengeComplete && mobileEntities[0] instanceof Person && mobileEntities[1] instanceof Car){
            String name = ((Car)mobileEntities[1]).getPlate();
            if (name.contains("B")){
                challenge = "B" + challenge.substring(1);
            }
            if (name.contains("U")){
                challenge = challenge.charAt(0) + "U" + challenge.substring(2);
            }
            if (name.contains("S")){
                challenge = challenge.substring(0, 2) + "S" + challenge.substring(3);
            }

            label.setText(label.getText().substring(0, label.getText().length()-3) + challenge);

            if (challenge.contentEquals("BUS")){
                challengeComplete = true;
                label.setText(label.getText().substring(0, label.getText().length()-10) + "CHALLENGE COMPLETE");
            }

        }
    }
}
