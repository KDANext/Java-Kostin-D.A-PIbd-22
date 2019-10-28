package Transport;
//	
import java.awt.Color;
import java.awt.Graphics;
import myEnum.*;
//	
public abstract class Vehicle implements ITransport {
	//	
	protected int startX;
    protected int startY;
    protected int sizeX;
    protected int sizeY;
    protected countWheels countWheels;
    public int maxSpeed;
    public float weight;
    public Color bodyColor;
    public Color drivesColor;
    public Color frameColor;
	//	
	@Override
	public void SetPosition(int x, int y, int width, int height) {
		startX = x;
        startY = y;
        this.sizeX = width;
        this.sizeY = height;
	}
	//	
	public abstract void MoveTransport(Direction direction);
	public abstract void DrawTransport(Graphics g);
}
