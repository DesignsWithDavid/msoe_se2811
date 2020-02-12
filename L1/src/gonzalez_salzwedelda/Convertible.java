package gonzalez_salzwedelda;

/**
 * Course: SE2811
 * Winter 2019-2020
 * Lab 1 - Winter Necessities
 * Description: This class represents a specific type of car (a convertible) with any name,
 * number of wheels, and weight
 *
 * @author David Gonzalez-Salzwedel
 * @version 1.0
 * @created 12/9/2019
 */
public class Convertible extends Car {

	public Convertible(String name, int numWheels, double weight) {
		super(name, numWheels, weight);
		System.out.println("Creating a Convertible");
	}

	public boolean lowerRoof(){
		System.out.println("Lowering Roof");
		return true;
	}

	public boolean raiseRoof(){
		System.out.println("Raising Roof");
		return true;
	}

}