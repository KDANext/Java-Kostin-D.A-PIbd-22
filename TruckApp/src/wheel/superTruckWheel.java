package wheel;

import java.awt.Color;
import java.awt.Graphics;
import myEnum.*;
//	
public class superTruckWheel implements IWheel {
	//	
	countWheels countWheels;
	Color colorWheel;
	//	
	public superTruckWheel(countWheels countWheel,Color colorWheel) {
		this.countWheels=countWheel;
		this.colorWheel=colorWheel;
	}
	//	
	@Override
	public void draw(Graphics g, int startX, int startY) {
		drawWheel(g, startX + 60, startY + 30);
		drawWheel(g, startX + 0, startY + 30);
		g.setColor(Color.black);
		switch (countWheels)
		{
		case superIncreasedCarryngCapacity:
			g.setColor(Color.black);
			//g.fillRect(startX + 58, startY + 8, 6, 16);
			drawWheel(g, startX + 40, startY + 30);
		case increasedCarryngCapacity:
			drawWheel(g, startX + 20, startY + 30);
			break;
		}
	}
	//	
	private void drawWheel(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		g.setColor(Color.GRAY);
		g.fillRect(x , y , 19, 12);
		g.setColor(Color.black);
		g.drawRect( x, y, 19, 12);
		g.setColor(Color.black);
		g.fillOval( x + 1, y + 1, 16, 20);
		g.setColor(colorWheel);
		g.fillOval( x + 4, y + 4, 10, 14);
	}
}
