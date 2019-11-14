package parking;

import java.awt.Graphics;
import Transport.*;
import wheel.*;

public class garages<T extends Object&ITransport,W extends Object&IWheel >  {
	private T[] _places;
	private W[] _wheels;
	private int PictureWidth;
	private int PictureHeight;
	private final int _placeSizeWidth = 210;
	private final int _placeSizeHeight = 80;

	@SuppressWarnings("unchecked")
	public garages(int sizes, int pictureWidth, int pictureHeight) {
		_places= (T[]) new Object[sizes];
		_wheels= (W[]) new Object[sizes];		
		for (int i = 0; i < _places.length; i++)
		{
			_places[i] = null;
			_wheels[i] = null;
		}
	}			
	public int addTransport(T car,W wheel) {
		for (int i = 0; i < _places.length; i++) {
			if(checkFreePlace(i)) {
				_places[i]=car;
				_places[i].SetPosition(5+i/5* _placeSizeWidth+5, i%5*_placeSizeHeight+15, PictureWidth, PictureHeight);
				_wheels[i]=wheel;
				return i;
			}
		}
		return -1;
	}
	public ITransport takeTransport(int index) {
		if(index < 0 || index > _places.length) {
			return null;
		}
		if(!checkFreePlace(index)) {
			T car = _places[index];
			_places[index]=null;
			_wheels[index]=null;
			return car;
		}
		return null;
	}
	public boolean checkFreePlace(int index) {
		return _places[index]==null;
	}
	public void Draw(Graphics g) {
		drawMarking(g);
		for (int i = 0; i < _places.length; i++) {
			if(!checkFreePlace(i)) {
				_places[i].setTypeWheel(_wheels[i]);
				_places[i].DrawTransport(g);
			}
		}
	}
	private void drawMarking(Graphics g) {
		g.drawRect(0, 0, (_places.length/5)*_placeSizeWidth,480);
		for (int i = 0; i < _places.length/5; i++) {
			for (int j = 0; j < 6; j++) {
				g.drawLine(i*_placeSizeWidth, j*_placeSizeHeight, i*_placeSizeWidth+110, j*_placeSizeHeight);
			}
			g.drawLine(i*_placeSizeWidth, 0, i*_placeSizeWidth, 400);
		}
	}
	public T checkTransportAtIndex(int index) {
		return _places[index];	
	}
	public int getSize() {
		return _places.length;
	}
}
