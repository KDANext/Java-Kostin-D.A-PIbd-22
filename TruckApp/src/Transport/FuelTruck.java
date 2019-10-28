package Transport;
//	
import java.awt.*;
import myEnum.*;
//	
public class FuelTruck extends Truck
{
	public String typeLiqui;
	public float countLiquid;
	public Color tankColor;
	//	
	public FuelTruck(int maxSpeed,
			countWheels countWheels,
			float weight,
			String typeLiquid,
			float countLiquid,
			boolean flasher,
			Color bodyColor,
			Color drivesColor,
			Color frameColor,
			Color tankColor)
	{
		super(maxSpeed,
				countWheels,
				weight,
				flasher,
				bodyColor,
				drivesColor,
				frameColor);
		this.tankColor = tankColor;
		this.typeLiqui = typeLiquid;
		this.countLiquid = countLiquid;
	}
	//		
	@Override
	public void DrawTransport(Graphics g)
	{
		g.setColor(tankColor);
		g.fillRect(startX + 3, startY + 8, 55 -3, 28 - 8);
		g.fillRect(startX + 16, startY + 3, 28 - 16, 8 - 3);
		g.fillRect(startX + 35, startY + 3, 28 - 16, 8 - 3);
		g.fillRect(startX + 17, startY + 1, 27 - 17, 3 - 1);
		g.fillRect(startX + 36, startY + 1, 27 - 17, 3 - 1);
		super.DrawTransport(g);
	}
}
