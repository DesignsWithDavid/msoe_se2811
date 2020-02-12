/*
 * Course: SE2811
 * Winter 2019-2020
 * Lab 1 - Winter Necessities
 * Name: Josiah Yoder
 *       David Gonzalez-Salzwedel
 * Created: 12/7/2019
 */
package gonzalez_salzwedelda;

/**
 * This tester application calls each method and confirms getters return
 * the correct values.
 *
 * It also includes lines which should NOT compile
 * for each type of object. Uncomment these lines
 * to confirm they do not compile.
 */
public class VehicleApp {
    public static void main(String[] args) {
        testCar();
        testConvertible();
        testConvertibleWithPlow();
        testPickup();
        testDumpTruck();
    }

    private static void testCar() {
        Car car = new Car("LoveBug", 5, 3000);
        assertFact(car.getName().equals("LoveBug"),"Car does not have the correct name.");
        assertFact(car.getNumWheels() == 5,"Car lacks spare (or has extra).");
        assertFact(car.getWeight() == 3000, "Car not at correct weight");
        car.start();
        car.stop();

        // Should cause compile error
//        car.raiseLoad();
//        car.lowerLoad();
//        car.getLoadCapacity();
//        car.raiseRoof();
//        car.lowerRoof();
//        car.raisePlow();
//        car.lowerPlow();
//        car.getPlowWidth();
    }

    private static void testConvertible() {
        Convertible convertible = new Convertible("Chitty Chitty Bang Bang", 5, 3500);
        assertFact(convertible.getName().equals("Chitty Chitty Bang Bang"),"Convertible does not " +
                "have the correct name.");
        assertFact(convertible.getNumWheels() == 5,"Convertible lacks spare (or has extra).");
        assertFact(convertible.getWeight() == 3500, "Convertible not at correct weight");
        convertible.start();
        convertible.stop();
        convertible.raiseRoof();
        convertible.lowerRoof();

        // Should cause compile error
//        convertible.raiseLoad();
//        convertible.lowerLoad();
//        convertible.getLoadCapacity();
//        convertible.raisePlow();
//        convertible.lowerPlow();
//        convertible.getPlowWidth();
    }

    private static void testConvertibleWithPlow() {
        ConvertibleWithPlow convertible = new ConvertibleWithPlow("Snowy Snowy Bang Bang", 5,
                3600, 80);
        assertFact(convertible.getName().equals("Snowy Snowy Bang Bang"),"Convertible does not " +
                "have the correct name.");
        assertFact(convertible.getNumWheels() == 5,"Convertible lacks spare (or has extra).");
        assertFact(convertible.getWeight() == 3600, "Convertible not at correct weight");
        convertible.start();
        convertible.stop();
        convertible.raiseRoof();
        convertible.lowerRoof();
        convertible.raisePlow();
        convertible.lowerPlow();
        assertFact(convertible.getPlowWidth()==80,"Convertible's plow width is incorrect");

        // Should cause compile error
//        convertible.raiseLoad();
//        convertible.lowerLoad();
//        convertible.getLoadCapacity();
    }

    private static void testPickup() {
        Pickup pickup = new Pickup("Mater", 4, 5000, 3000, 96);
        assertFact(pickup.getName().equals("Mater"),"Pickup does not have the correct name.");
        assertFact(pickup.getNumWheels() == 4,"Pickup lacks spare (or has extra).");
        assertFact(pickup.getWeight() == 5000, "Pickup is not at correct weight.");
        pickup.start();
        pickup.stop();
        assertFact(pickup.getLoadCapacity()==3000,"Pickup's capacity is incorrect.");
        pickup.raisePlow();
        pickup.lowerPlow();
        assertFact(pickup.getPlowWidth()==96,"Pickup's plow width is incorrect.");

        // Should cause compile error
//        pickup.raiseLoad();
//        pickup.lowerLoad();
//        pickup.raiseRoof();
//        pickup.lowerRoof();
    }

    private static void testDumpTruck() {
        DumpTruck truck = new DumpTruck("Dump", 10, 7000, 8000, 100);
        assertFact(truck.getName().equals("Dump"),"DumpTruck does not have the correct name.");
        assertFact(truck.getNumWheels() == 10,"DumpTruck lacks spare (or has extra).");
        assertFact(truck.getWeight() == 7000, "DumpTruck is not at correct weight.");
        truck.start();
        truck.stop();
        truck.raiseLoad();
        truck.lowerLoad();
        assertFact(truck.getLoadCapacity()==8000,"DumpTruck's capacity is incorrect.");
        truck.raisePlow();
        truck.lowerPlow();
        assertFact(truck.getPlowWidth()==100,"DumpTruck's plow width is incorrect.");

        // Should cause compile error
//        truck.raiseRoof();
//        truck.lowerRoof();

        // This is a bit hacky, but it allows us to achieve 100% code coverage
        for(int i = 0; i < 2; i++) {
            try {
                assertFact(i == 0, "Confirm assertion test works.");
            } catch (AssertionError error) {
                System.out.println("Assertion test still works.  (To get 100% code coverage)");
            }
        }
    }

    private static void assertFact(boolean fact, String message){
        if(!fact) {
            throw new AssertionError(message);
        }
    }
}
