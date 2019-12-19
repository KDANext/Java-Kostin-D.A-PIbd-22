package Transport;
//	
import java.awt.Color;
import java.awt.Graphics;
import myEnum.*;
import wheel.IWheel;
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
    protected IWheel typeWheel;
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
	public abstract boolean equals(Object transport);
	public abstract boolean notEquals(Object transport);
	public int getStartX() {
		return startX;
	}
	protected void setStartX(int startX) {
		this.startX = startX;
	}
	public int getStartY() {
		return startY;
	}
	protected void setStartY(int startY) {
		this.startY = startY;
	}
	public IWheel getTypeWheel() {
		return typeWheel;
	}
	public void setTypeWheel(IWheel typeWheel) {
		this.typeWheel = typeWheel;
	}
	public void SetMainColor(Color color){
        bodyColor = color;
    }
}
