import java.awt.Graphics;

import javax.swing.JPanel;

import Transport.ITransport;
//
public class My_JPanel extends JPanel {
	ITransport transport;
	public void setTransport(ITransport transport) {
		this.transport = transport;
	}
	public void paint(Graphics g) {
		super.paint(g);
		if (transport!=null) {
			transport.DrawTransport(g);
		}
		repaint();	
	}
	public ITransport getTransport() {
		return transport;
	}
}
