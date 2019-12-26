package exception;

public class GaragesOverflowException extends IndexOutOfBoundsException {
	public GaragesOverflowException() {
		super("No parking spaces available!");
	}
}
