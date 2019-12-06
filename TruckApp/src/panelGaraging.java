import java.awt.Graphics;
import javax.swing.JPanel;
import Transport.ITransport;
import parking.garages;
import parking.historyTransport;
import wheel.IWheel;

public class panelGaraging extends JPanel {
	garages<ITransport, IWheel> garages;
	historyTransport historyTransport;

	public garages<ITransport, IWheel> getGarages() {
		return garages;
	}

	public void setGarages(garages<ITransport, IWheel> garages) {
		this.garages = garages;
	}

	public void paint(Graphics g) {
		super.paint(g);
		garages.Draw(g);
	}

	public historyTransport getHistoryTransport() {
		return historyTransport;
	}

	public void setHistoryTransport(historyTransport historyTransport) {
		this.historyTransport = historyTransport;
	}
}
