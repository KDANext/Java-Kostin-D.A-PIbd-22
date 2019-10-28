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
    private int typeWheel;
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
        Random rnd =new Random();
        typeWheel=rnd.nextInt()%3;
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
		switch (typeWheel) {
		case 1:
			new superTruckWheel(countWheels, drivesColor).draw(g, startX, startY);
			break;
		case 2:
			new goodTruckWheel(countWheels, drivesColor).draw(g, startX, startY);
			break;
		default:
			new basicTruckWheel(countWheels, drivesColor).draw(g, startX, startY);
			break;
		}
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
}
