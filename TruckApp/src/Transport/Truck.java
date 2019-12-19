package Transport;
//	
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import myEnum.*;
import wheel.*;
//	
public class Truck extends Vehicle {
	protected final int truckWidth = 90;
    protected final int truckHeight = 50;
    public boolean flasher;
	//	
    public Truck(int maxSpeed,
                    countWheels countWheels,
                    float weight,
                    boolean flasher,
                    Color bodyColor,
                    Color drivesColor,
                    Color frameColor)
    {
        this.maxSpeed = maxSpeed;
        this.countWheels = countWheels;
        this.weight = weight;
        this.flasher = flasher;
        this.bodyColor = bodyColor;
        this.drivesColor = drivesColor;
        this.frameColor = frameColor;
    }
	public Truck(String info) {
		String[] strs = info.split(";");
        if (strs.length == 6)
        {
            maxSpeed = Integer.parseInt(strs[0]);
            weight = Float.parseFloat(strs[1]);
            bodyColor = new Color(Integer.parseInt(strs[2]));
            drivesColor = new Color(Integer.parseInt(strs[3]));
            flasher = Boolean.parseBoolean(strs[4]);
            frameColor = new Color(Integer.parseInt(strs[5]));
        }
	}
	//	
    @Override
    public void DrawTransport(Graphics g)
    {
    	g.setColor(bodyColor);
		g.fillRect(startX+64, startY+4, 85-64, 43-4);
		//	
		if (flasher)
        {
            g.setColor(Color.orange);
            g.fillRect( startX + 80, startY, 4, 4);
        }
		//	
		g.setColor(frameColor);
		g.fillRect(startX + 80, startY + 36, 85 - 80, 43-36);
		g.fillRect(startX + 0, startY + 30, 63-0, 43 - 30);
		g.fillRect(startX + 7, startY + 28, 52 - 7, 3);
		//	
		typeWheel.draw(g, startX, startY);		
		//	
		g.setColor(Color.yellow);
		g.fillRect(startX + 83, startY + 33, 85 - 83, 39 - 33);
		//	
		g.setColor(Color.black);
		g.drawRect( startX + 72, startY + 5, 84 - 72, 16 - 5);
		g.drawLine( startX + 84, startY + 5, startX + 87, startY + 8);
		g.fillRect(startX + 87, startY + 8, 88 - 87, 15 - 7);
		g.drawLine( startX + 51, startY + 1, startX + 65, startY + 4);
    }
	//	
    @Override
    public void MoveTransport(Direction direction)
    {
    	float step = maxSpeed * 100 / weight;
		switch (direction)
		{
		case Right:
			if (startX + step < sizeX - truckWidth)
			{
				startX += step;
			}
			break;
		case Left:
			if (startX - step > 0)
			{
				startX -= step;
			}
			break;
		case Up:
			if (startY - step > 0)
			{
				startY -= step;
			}
			break;
		case Down:
			if (startY + step < sizeY - truckHeight)
			{
				startY += step;
			}
			break;
		}
    }
    @Override
    public boolean equals(Object transport) {
    	if(transport==null) return false;
    	Truck truck = (Truck) transport;
    	if(truck.flasher!=flasher) return false;
    	if(truck.countWheels!=countWheels) return false;
    	if(truck.drivesColor!=drivesColor) return false;
    	if(truck.frameColor!=frameColor) return false;
    	if(truck.maxSpeed!=maxSpeed) return false;
    	if(truck.weight!=weight) return false;
    	return true;
    }
    @Override
    public boolean notEquals(Object transport) {
		return !equals(transport);
	}
	public IWheel getTypeWheel() {
		return typeWheel;
	}
	public void setTypeWheel(IWheel typeWheel) {
		this.typeWheel = typeWheel;
	}
	@Override
	public String ToString() {
		return maxSpeed + ";"
                + weight + ";"
                + bodyColor.getRGB() + ";"
                + drivesColor.getRGB() + ";"
                + flasher +";"
                + frameColor.getRGB() ;
	}
}
