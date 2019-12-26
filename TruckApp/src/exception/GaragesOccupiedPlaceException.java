package exception;

public class GaragesOccupiedPlaceException extends Exception {
	public GaragesOccupiedPlaceException(int i) {
		super("On the spot " + i + " car is already standing");
	}
}
