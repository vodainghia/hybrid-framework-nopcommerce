package carFactory;

public class Kia implements ICar{

	@Override
	public void viewCar() {
		System.out.println("View Kia car");
	}

	@Override
	public void driveCar() {
		System.out.println("Drive Kia car");
	}
	
}
