package carFactory;

public class Honda implements ICar{

	@Override
	public void viewCar() {
		System.out.println("View Honda car");
	}

	@Override
	public void driveCar() {
		System.out.println("Drive Honda car");
	}
	
}
