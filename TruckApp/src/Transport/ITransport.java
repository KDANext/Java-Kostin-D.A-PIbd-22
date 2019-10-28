package Transport;

import java.awt.Graphics;
import myEnum.*;

public interface ITransport {
	public void SetPosition(int x, int y, int width, int height);
   	public void MoveTransport(Direction direction);
   	public void DrawTransport(Graphics g);
}
