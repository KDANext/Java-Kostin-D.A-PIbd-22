package Transport;

import java.awt.*;
import java.util.Random;
import myEnum.*;
import wheel.*;

public class FuelTruck
{
	//
	private int startX = 10;
	private int startY = 10;
	private int sizeX = 100;
	private int sizeY = 100;
	private countWheels countWheels;
	private static final int  truckWidth = 90;
	private static final int truckHeight = 50;
	public int maxSpeed = 0;
	public float weight = 0;
	public boolean flasher = false;
	public Color bodyColor = Color.black;
	public Color tankColor = Color.red ;
	public Color drivesColor = Color.white;
	public Color frameColor=Color.white;
	//
	public FuelTruck(int maxSpeed,
			countWheels countWheels,
			float weight,
			boolean flasher,
			Color bodyColor,
			Color tankColor,
			Color drivesColor,
			Color frameColor)
	{
		this.maxSpeed = maxSpeed;
		this.countWheels = countWheels;
		this.weight = weight;
		this.flasher = flasher;
		this.bodyColor = bodyColor;
		this.tankColor = tankColor;
		this.drivesColor = drivesColor;
		this.frameColor = frameColor;
	}
	//
	public FuelTruck() {
			Random rnd = new Random();
			countWheels countWheels = null;
			switch(rnd.nextInt(3)+2) {
			case 4:
				countWheels=countWheels.superIncreasedCarryngCapacity;
				break;
			case 3:
				countWheels=countWheels.increasedCarryngCapacity;
				break;
			case 2:
				countWheels=countWheels.basic;
				break;
			default:
				countWheels=countWheels.basic;
				break;
			}		
		maxSpeed = 100; 
		this.countWheels = countWheels;
		weight = 1000;
		flasher = true;
		bodyColor = Color.white;
		tankColor = Color.cyan;
		drivesColor = Color.white;
		frameColor = Color.black;
	}
	//
	public void setPosition(int x, int y, int sizeX, int sizeY)
	{
		startX = x;
		startY = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	//
	public void moveTruck(Direction direction)
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
	//
	public void drawTruck(Graphics g)
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
		g.setColor(tankColor);
		g.fillRect(startX + 3, startY + 8, 55 -3, 28 - 8);
		g.fillRect(startX + 16, startY + 3, 28 - 16, 8 - 3);
		g.fillRect(startX + 35, startY + 3, 28 - 16, 8 - 3);
		g.fillRect(startX + 17, startY + 1, 27 - 17, 3 - 1);
		g.fillRect(startX + 36, startY + 1, 27 - 17, 3 - 1);
		//
		new wheel(countWheels, drivesColor).draw(g, startX, startY);
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
}
