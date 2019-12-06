package parking;

import java.awt.Graphics;
import java.util.Stack;

import Transport.ITransport;

public class historyTransport {
	Stack<ITransport> transports;
	public historyTransport() {
		transports = new Stack<ITransport>();
	}
	
	public void addHistory(ITransport transport) {
		transports.add(transport);
	}
	
	public void draw(Graphics g,int StartX,int StartY) {
		int i=0;
		for (ITransport transport : transports) {
			transport.SetPosition(StartX+i*0, StartY+i*60, 500, 500);
			transport.DrawTransport(g);
			i++;
		}
	}
}
