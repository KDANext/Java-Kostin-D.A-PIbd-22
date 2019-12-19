package Transport;

import java.awt.Color;
import java.awt.Graphics;
import myEnum.*;
import wheel.IWheel;

public interface ITransport {
	public void SetPosition(int x, int y, int width, int height);
   	public void MoveTransport(Direction direction);
   	public void DrawTransport(Graphics g);
   	public void setTypeWheel(IWheel typeWheel);
   	public IWheel getTypeWheel();
   	public void SetMainColor(Color color);
   	public boolean equals(Object transport);
   	public boolean notEquals(Object transport);
	public String ToString();
}
