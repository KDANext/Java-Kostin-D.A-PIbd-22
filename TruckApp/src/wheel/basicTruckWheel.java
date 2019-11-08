package wheel;
//	
import java.awt.Color;
import java.awt.Graphics;
import myEnum.*;
//	
public class basicTruckWheel implements IWheel {
	//	
	countWheels countWheels;
	Color colorWheel;
	//	
	public basicTruckWheel(countWheels countWheel,Color colorWheel) {
		this.countWheels=countWheel;
		this.colorWheel=colorWheel;
	}
	//	
	public void draw(Graphics g,int startX,int startY) {
		drawWheel(g, startX + 60, startY + 30);
		drawWheel(g, startX + 0, startY + 30);
		g.setColor(Color.black);
		switch (countWheels)
		{
		case superIncreasedCarryngCapacity:
			g.setColor(Color.black);
			drawWheel(g, startX + 40, startY + 30);
		case increasedCarryngCapacity:
			drawWheel(g, startX + 20, startY + 30);
			break;
		}
	}
	//	
	private void drawWheel(Graphics g, int x, int y)
	{
		g.setColor(Color.GRAY);
		g.fillRect(x , y , 19, 12);
		g.setColor(Color.black);
		g.drawRect( x, y, 19, 12);
		g.setColor(Color.black);
		g.fillOval( x + 1, y + 1, 16, 16);
		g.setColor(colorWheel);
		g.fillOval( x + 4, y + 4, 10, 10);
		g.setColor(Color.red);
	}	
}
