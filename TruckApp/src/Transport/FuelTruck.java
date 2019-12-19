package Transport;
//	
import java.awt.*;
import myEnum.*;
import wheel.IWheel;
import wheel.superTruckWheel;
//	
public class FuelTruck extends Truck
{
	public String typeLiquid;
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
		this.typeLiquid = typeLiquid;
		this.countLiquid = countLiquid;
	}
	public FuelTruck(String info)
    {
    	super(info);

    	String[] strs = info.split(";");
        if (strs.length == 9)
        {
            maxSpeed = Integer.parseInt(strs[0]);
            weight = Float.parseFloat(strs[1]);
            bodyColor = new Color(Integer.parseInt(strs[2]));
            drivesColor = new Color(Integer.parseInt(strs[3]));
            flasher = Boolean.getBoolean(strs[4]);
            frameColor = new Color(Integer.parseInt(strs[5]));
            typeLiquid = strs[6];
            countLiquid = Float.parseFloat(strs[7]);
            tankColor = new Color(Integer.parseInt(strs[8]));
        }
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
	@Override
	public boolean equals(Object transport) {
		FuelTruck fuelTruck = (FuelTruck) transport;
		if(typeLiquid!=fuelTruck.typeLiquid) return false;
		if(tankColor!=fuelTruck.tankColor) return false;
		if(super.notEquals(fuelTruck)) return false;
		return true;
	}
	@Override
	public boolean notEquals(Object transport) {
		return !equals(transport);
	}
	public boolean notEquals(Truck truck) {
		if (!equals(truck)) {
			return true;
		} else {
			return false;
		}
	}
	public void setTankColor(Color tankColor) {
		this.tankColor = tankColor;
	}
	@Override
    public String ToString()
    {
        return super.ToString() + ";"
                + typeLiquid + ";"
                + countLiquid + ";"
                + tankColor.getRGB();
    }
}
