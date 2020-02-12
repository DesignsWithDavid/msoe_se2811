package gonzalez_salzwedelda;

/**
 * Course: SE2811
 * Winter 2019-2020
 * Lab 1 - Winter Necessities
 * Description: This class represents a generic car with any name, number of wheels, and weight
 *
 * @author David Gonzalez-Salzwedel
 * @version 1.0
 * @created 12/9/2019
 */
public class Car extends Vehicle {

	public Car(String name, int numWheels, double weight){
		super(name, numWheels, weight);
		System.out.println("Creating a Car");
	}


	@Override
	public void goBackwards() {
		System.out.println("Going Backwards");
	}

	@Override
	public void goForwards() {
		System.out.println("Going Forwards");
	}

	@Override
	public boolean start() {
		System.out.println("Starting");
		return true;
	}

	@Override
	public boolean stop() {
		System.out.println("Stopping");
		return true;
	}

}