package parking;

import java.util.ArrayList;
import java.util.List;

import Transport.ITransport;
import wheel.IWheel;

public class multiLevelGarages {
	ArrayList<garages<ITransport,IWheel>> garagesStages ;
	private int countPlaces = 20;
	
	public multiLevelGarages(int countStages, int pictureWidth, int pictureHeight) {
		garagesStages = new ArrayList<garages<ITransport,IWheel>>();
		for (int i = 0; i < countStages; i++) {
			garagesStages.add(new garages<ITransport, IWheel>(countPlaces, pictureWidth, pictureHeight));
		}
	}
	public garages<ITransport,IWheel> getGaragesStages(int index){	
		if(index>-1 && index < garagesStages.size()) {
			return garagesStages.get(index);
		}
		return null;
	}
	public ITransport getTruck(int level,int index) {
		if(level<0 || level>=garagesStages.size()) return null;
		if(index<0 || index>countPlaces) return null;
		return getGaragesStages(level).getTransportAtIndex(index);
	}
}
