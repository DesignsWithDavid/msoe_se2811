package gonzalez_salzwedelda;

/**
 * Course: SE2811
 * Winter 2019-2020
 * Lab 1 - Winter Necessities
 * Description: This class represents a specific type of truck (a dump truck) with a plow and any name,
 * number of wheels, weight, and load capacity
 *
 * @author David Gonzalez-Salzwedel
 * @version 1.0
 * @created 12/9/2019
 */
public class DumpTruck extends Truck {

	public DumpTruck(String name, int numWheels, double weight, double loadCapacity, double plowWidth){
		super(name, numWheels, weight, loadCapacity, plowWidth);
		System.out.println("Creating a Dump Truck");
	}


	public void lowerLoad(){
		System.out.println("Lowering Load");
	}

	public void raiseLoad(){
		System.out.println("Raising Load");
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