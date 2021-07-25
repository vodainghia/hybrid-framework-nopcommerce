package carWithoutFactory;

public class Person {

	public static void main(String[] args) {
		// morning
		Honda honda = new Honda();
		honda.viewCar();
		honda.driveCar();
		
		// afternoon
		Toyota toyota = new Toyota();
		toyota.viewCar();
		toyota.driveCar();
		
		//evening
		Kia kia = new Kia();
		kia.viewCar();
		kia.driveCar();

	}

}
