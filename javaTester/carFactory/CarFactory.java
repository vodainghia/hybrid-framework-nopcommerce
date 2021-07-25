package carFactory;

public class CarFactory {
	public void viewCarByType(String carTypeName) {
		if (carTypeName.equalsIgnoreCase("honda")) {
			Honda honda = new Honda();
			honda.viewCar();
		} else if (carTypeName.equalsIgnoreCase("toyota")) {
			Toyota toyota = new Toyota();
			toyota.viewCar();
		} else if (carTypeName.equalsIgnoreCase("kia")) {
			Kia kia = new Kia();
			kia.viewCar();
		}
	}
}
