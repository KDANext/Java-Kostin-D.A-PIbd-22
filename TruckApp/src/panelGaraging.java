import java.awt.Graphics;
import javax.swing.JPanel;
import Transport.ITransport;
import parking.garages;
import wheel.IWheel;

public class panelGaraging extends JPanel {
	garages<ITransport, IWheel> garages;
	public garages<ITransport, IWheel> getGarages() {
		return garages;
	}
	public void setGarages(garages<ITransport, IWheel> garages) {
		this.garages = garages;
	}	
	public void paint(Graphics g) {
		super.paint(g);
		garages.Draw(g);
		repaint();	
	}	
}
