package gonzalez_salzwedelda;

/**
 * Course: SE2811
 * Winter 2019-2020
 * Lab 1 - Winter Necessities
 * Description: This class represents a plow which is an attachment that a vehicle can have
 *
 * @author David Gonzalez-Salzwedel
 * @version 1.0
 * @created 12/9/2019
 */
public class Plow {

	public double plowWidth;

	public Plow(double plowWidth){
		System.out.println("Creating Plow");
		this.plowWidth = plowWidth;
	}

	public boolean lowerPlow(){
		System.out.println("Lowering Plow");
		return true;
	}

	public boolean raisePlow(){
		System.out.println("Raising Plow");
		return true;
	}

	public void setPlowWidth(double plowWidth){
		System.out.println("Setting Plow Width");
		this.plowWidth = plowWidth;
	}

	public double getPlowWidth(){
		System.out.println("Getting Plow Width");
		return plowWidth;
	}
}