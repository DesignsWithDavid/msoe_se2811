package gonzalez_salzwedelda;

/**
 * Course: SE2811
 * Winter 2019-2020
 * Lab 1 - Winter Necessities
 * Description: This class represents a generic truck with a plow and any name,
 * number of wheels, weight, and load capacity
 *
 * @author David Gonzalez-Salzwedel
 * @version 1.0
 * @created 12/9/2019
 */
public abstract class Truck extends Vehicle {

	private Plow plow;
	private double loadCapacity;

	public Truck(String name, int numWheels, double weight, double loadCapacity, double plowWidth){
		super(name, numWheels, weight);
		System.out.println("Creating a Truck");
		this.plow = new Plow(plowWidth);
		this.loadCapacity = loadCapacity;
	}

	public void setLoadCapacity(double loadCapacity){
		System.out.println("Setting Load Capacity");
		this.loadCapacity = loadCapacity;
	}

	public double getLoadCapacity(){
		System.out.println("Getting Load Capacity");
		return loadCapacity;
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