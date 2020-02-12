package gonzalez_salzwedelda;

/**
 * Course: SE2811
 * Winter 2019-2020
 * Lab 1 - Winter Necessities
 * Description: This class represents a specific type of convertible that has a plow and with any name,
 * number of wheels, and weight
 *
 * @author David Gonzalez-Salzwedel
 * @version 1.0
 * @created 12/9/2019
 */
public class ConvertibleWithPlow extends Convertible {

private Plow plow;

public ConvertibleWithPlow(String name, int numWheels, double weight, double plowWidth){
    super(name, numWheels, weight);
    System.out.println("Creating Convertible");
    plow = new Plow(plowWidth);
}

    public void setPlow(Plow plow){
        System.out.println("Setting Plow");
        this.plow = plow;
    }

    public Plow getPlow(){
        System.out.println("Getting Plow");
        return plow;
    }

    public void setPlowWidth(double plowWidth){
        System.out.println("Setting Plow Width");
        plow.setPlowWidth(plowWidth);
    }

    public double getPlowWidth(){
        System.out.println("Getting Plow Width");
        return plow.getPlowWidth();
    }

    public void lowerPlow(){
        System.out.println("Lowering Plow");
        plow.lowerPlow();
    }

    public void raisePlow(){
        System.out.println("Raising Plow");
        plow.raisePlow();
    }

}