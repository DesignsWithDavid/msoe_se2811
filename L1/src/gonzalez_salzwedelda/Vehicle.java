package gonzalez_salzwedelda;

/**
 * Course: SE2811
 * Winter 2019-2020
 * Lab 1 - Winter Necessities
 * Description: This class represents a generic vehicle.  It is an abstract class and cannot be instantiated.
 *
 * @author David Gonzalez-Salzwedel
 * @version 1.0
 * @created 12/9/2019
 */
public abstract class Vehicle {

	private String name;
	private int numWheels;
	private double weight;

	public Vehicle(String name, int numWheels, double weight){
		System.out.println("Creating a Vehicle");
		this.name = name;
		this.numWheels = numWheels;
		this.weight = weight;
	}

	public void setNumWheels(int numWheels){
		System.out.println("Setting Num Wheels");
		this.numWheels = numWheels;
	}

	public int getNumWheels(){
		System.out.println("Getting Num Wheels");
		return numWheels;
	}

	public void setName(String name){
		System.out.println("Setting Name");
		this.name = name;
	}

	public String getName(){
		System.out.println("Getting Names");
		return name;
	}

	public void setWeight(double weight){
		System.out.println("Setting Weight");
		this.weight = weight;
	}

	public double getWeight(){
		System.out.println("Getting Weight");
		return weight;
	}

	public abstract void goBackwards();

	public abstract void goForwards();

	public abstract boolean start();

	public abstract boolean stop();

}