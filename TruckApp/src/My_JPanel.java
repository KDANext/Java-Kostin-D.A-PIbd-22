import java.awt.Graphics;
import javax.swing.JPanel;
import Transport.*;
//
public class My_JPanel extends JPanel {
	FuelTruck fuelTruck;
	//
	public void setFuelTruck(FuelTruck fuelTruck) {
		this.fuelTruck=fuelTruck;
	}
	//
	public void paint(Graphics g) {
		super.paint(g);
		if (fuelTruck!=null) {
			fuelTruck.drawTruck(g);
		}
		repaint();	
	}
}
