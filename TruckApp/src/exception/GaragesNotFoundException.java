package exception;

public class GaragesNotFoundException extends NullPointerException {
	public GaragesNotFoundException(int i)
    { 
		super("No truck found by location" + i);
    }
}
