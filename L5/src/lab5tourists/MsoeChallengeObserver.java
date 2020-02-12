package lab5tourists;

import javafx.scene.control.Label;
import lab5tourists.mobileEntities.Car;
import lab5tourists.mobileEntities.MobileEntity;
import lab5tourists.mobileEntities.Person;

public class MsoeChallengeObserver implements Observer {
    private Label label;
    private String challenge = "****";
    private boolean challengeComplete = false;

    public MsoeChallengeObserver(Label label){
        this.label = label;
    }

    /**
     * Receives an update from the subjects it is observing
     * @param mobileEntities - the entity that triggered the update
     */
    public void update(MobileEntity[] mobileEntities){
        if (!challengeComplete && mobileEntities[0] instanceof Person && mobileEntities[1] instanceof Car){
            String name = ((Car)mobileEntities[1]).getPlate();
            if (name.contains("M")){
                challenge = "M" + challenge.substring(1);
            }
            if (name.contains("S")){
                challenge = challenge.charAt(0) + "S" + challenge.substring(2);
            }
            if (name.contains("O")){
                challenge = challenge.substring(0, 2) + "O" + challenge.substring(3);
            }
            if (name.contains("E")){
                challenge = challenge.substring(0, 3) + "E";
            }

            label.setText(label.getText().substring(0, label.getText().length()-4) + challenge);

            if (challenge.contentEquals("MSOE")){
                challengeComplete = true;
                label.setText(label.getText().substring(0, label.getText().length()-11) + "CHALLENGE COMPLETE");
            }

        }
    }
}
