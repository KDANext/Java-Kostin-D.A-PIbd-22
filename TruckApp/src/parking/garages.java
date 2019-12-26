package parking;

import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Transport.*;
import exception.GaragesNotFoundException;
import exception.GaragesOccupiedPlaceException;
import exception.GaragesOverflowException;
import wheel.*;

public class garages<T extends Object&ITransport,W extends Object&IWheel >  {
	Map<Integer, T> _places;
	Map<Integer, W> _wheels;
	private int _maxCount;
	private int PictureWidth;
	private int PictureHeight;
	private final int _placeSizeWidth = 210;
	private final int _placeSizeHeight = 80;

	public garages(int sizes, int pictureWidth, int pictureHeight) {
		_maxCount = sizes;
		_places = new HashMap<Integer, T>();
		_wheels = new HashMap<Integer, W>();
		PictureWidth=pictureWidth;
		PictureHeight=pictureHeight;
	}			
	public int addTransport(T car,W wheel) throws GaragesOverflowException {
		if(_places.size()==_maxCount) {
			throw new GaragesOverflowException();
		}
		for (int i = 0; i < _maxCount; i++) {
			if(checkFreePlace(i)) {
				_places.put(i,car);
				_places.get(i).SetPosition(5+i/5* _placeSizeWidth+5, i%5*_placeSizeHeight+15, PictureWidth, PictureHeight);
				_wheels.put(i,wheel);
				return i;
			}
		}
		return -1;
	}
	public ITransport takeTransport(int index) throws GaragesNotFoundException {
		if(!checkFreePlace(index)) {
			T car = _places.get(index);
			_places.remove(index);
			_wheels.remove(index);
			return car;
		}
		throw new GaragesNotFoundException(index);
	}
	public boolean checkFreePlace(int index) {
		return !_places.containsKey(index);
	}
	public void Draw(Graphics g) {
		drawMarking(g);
		for (int i = 0; i < _maxCount; i++) {
			if(_places.get(i)!=null) {
				_places.get(i).setTypeWheel(_wheels.get(i));
				_places.get(i).DrawTransport(g);
			}
		}

	}
	private void drawMarking(Graphics g) {
		g.drawRect(0, 0, (_maxCount/5)*_placeSizeWidth,480);
		for (int i = 0; i < _maxCount/5; i++) {
			for (int j = 0; j < 6; j++) {
				g.drawLine(i*_placeSizeWidth, j*_placeSizeHeight, i*_placeSizeWidth+110, j*_placeSizeHeight);
			}
			g.drawLine(i*_placeSizeWidth, 0, i*_placeSizeWidth, 400);
		}		
	}
	public T getTransportAtIndex(int index) {
		if (_places.containsKey(index)) {
			return _places.get(index);
		}
		return null;
	}
	public int getSize() {
		return _places.size();
	}
	public void setTransport(int index, T transport) throws GaragesOccupiedPlaceException {
		if(checkFreePlace(index)) {
			_places.put(index, transport);
			_wheels.put(index, (W) transport.getTypeWheel());
			_places.get(index).SetPosition(5 + index / 5 * _placeSizeWidth + 5, index % 5 * _placeSizeHeight + 15, PictureWidth, PictureHeight);
			return;
		}
		else
        {
			throw new GaragesOccupiedPlaceException(index);
        }

	}
}
