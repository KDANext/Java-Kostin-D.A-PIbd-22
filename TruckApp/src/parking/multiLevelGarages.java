package parking;

import java.awt.Color;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Transport.FuelTruck;
import Transport.ITransport;
import Transport.Truck;
import exception.GaragesNotFoundException;
import myEnum.countWheels;
import wheel.IWheel;
import wheel.basicTruckWheel;

public class multiLevelGarages {
	ArrayList<garages<ITransport, IWheel>> garagesStages;
	private int countPlaces = 20;
	int pictureWidth;
	int pictureHeight;

	public multiLevelGarages(int countStages, int pictureWidth, int pictureHeight) {
		this.pictureHeight = pictureHeight;
		this.pictureWidth = pictureWidth;
		garagesStages = new ArrayList<garages<ITransport, IWheel>>();
		for (int i = 0; i < countStages; i++) {
			garagesStages.add(new garages<ITransport, IWheel>(countPlaces, pictureWidth, pictureHeight));
		}
	}

	public garages<ITransport, IWheel> getGaragesStages(int index) {
		if (index > -1 && index < garagesStages.size()) {
			return garagesStages.get(index);
		}
		return null;
	}

	public ITransport getTruck(int level, int index) throws GaragesNotFoundException {
		if (level < 0 || level >= garagesStages.size())
			return null;
		if (index < 0 || index > countPlaces)
			return null;
		return getGaragesStages(level).getTransportAtIndex(index);
	}

	private void WriteToFile(String text, FileWriter fw) {
		try {
			fw.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean SaveData(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		WriteToFile("CountLeveles:" + garagesStages.size() + "\n", fw);
		for (garages<ITransport, IWheel> level : garagesStages) {
			WriteToFile("Level" + "\n", fw);
			for (int i = 0; i < countPlaces; i++) {
				ITransport transport = null;
				transport = level.getTransportAtIndex(i);
				if (transport != null) {
						if (transport.getClass().getName() == "Transport.Truck") {
							WriteToFile(i + ":Truck:", fw);
						}
						if (transport.getClass().getName() == "Transport.FuelTruck") {
							WriteToFile(i + ":FuelTruck:", fw);
						}
						WriteToFile(transport.ToString() + "\n", fw);
					}
			}
		}
		fw.close();
		return true;
	}

	public boolean SaveLevel(String filename, int lvl) throws IOException {
		try {
			if (lvl < garagesStages.size() && lvl > 0) {
				return false;
			}
			FileWriter fw = new FileWriter(filename);
			WriteToFile("Level:" + lvl + "\n", fw);
			garages<ITransport, IWheel> level = garagesStages.get(lvl);
			for (int i = 0; i < countPlaces; i++) {
				ITransport transport = level.getTransportAtIndex(i);
				if (transport != null) {
					if (transport.getClass().getName() == "Transport.Truck") {
						WriteToFile(i + ":Truck:", fw);
					}
					if (transport.getClass().getName() == "Transport.FuelTruck") {
						WriteToFile(i + ":FuelTruck:", fw);
					}
					WriteToFile(transport.ToString() + "\n", fw);
				}
			}
			fw.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean LoadData(String filename) throws Exception {
		FileReader fr = new FileReader(filename);
		String bufferTextFromFile = "";
		int counter = -1;

		int c;
		while ((char) (c = fr.read()) != '\n') {
			bufferTextFromFile += (char) c;
		}

		if (bufferTextFromFile.contains("CountLeveles")) {
			int count = Integer.parseInt(bufferTextFromFile.split(":")[1]);
			if (garagesStages != null) {
				garagesStages.clear();
			}
			garagesStages = new ArrayList<garages<ITransport, IWheel>>(count);
			bufferTextFromFile = "";
		} else {
			throw new Exception("Invalid file format");
		}

		while ((c = fr.read()) != -1) {
			if ((char) c == '\n') {
				ITransport transport = null;

				if (bufferTextFromFile.equals("Level")) {
					counter++;
					garagesStages.add(new garages<ITransport, IWheel>(countPlaces, pictureWidth, pictureHeight));
					bufferTextFromFile = "";
					continue;
				}

				if (bufferTextFromFile.split(":").length > 1) {
					if (bufferTextFromFile.split(":")[1].equals("Truck")) {
						transport = new Truck(bufferTextFromFile.split(":")[2]);
					} else if (bufferTextFromFile.split(":")[1].equals("FuelTruck")) {
						transport = new FuelTruck(bufferTextFromFile.split(":")[2]);
					}
					transport.setTypeWheel(new basicTruckWheel(countWheels.basic, Color.white));
					garagesStages.get(counter).setTransport(Integer.parseInt(bufferTextFromFile.split(":")[0]),transport);
				}

				bufferTextFromFile = "";
			} else {
				bufferTextFromFile += (char) c;
			}
		}
		return true;
	}

	public boolean LoadLevel(String filename) throws IOException {
		try {
			FileReader fr = new FileReader(filename);
			String bufferTextFromFile = "";
			int lvl = 0;

			int c;
			while ((char) (c = fr.read()) != '\n') {
				bufferTextFromFile += (char) c;
			}

			if (bufferTextFromFile.contains("Level")) {
				lvl = Integer.parseInt(bufferTextFromFile.split(":")[1]);
				bufferTextFromFile = "";
			} else {
				return false;
			}

			if (garagesStages.size() < lvl) {
				return false;
			}

			garagesStages.set(lvl, new garages<ITransport, IWheel>(countPlaces, pictureWidth, pictureHeight));

			while ((c = fr.read()) != -1) {
				if ((char) c == '\n') {
					ITransport transport = null;

					if (bufferTextFromFile == null) {
						continue;
					}

					if (bufferTextFromFile.split(":").length > 2) {
						if (bufferTextFromFile.split(":")[1].equals("Truck")) {
							transport = new Truck(bufferTextFromFile.split(":")[2]);
						} else if (bufferTextFromFile.split(":")[1].equals("FuelTruck")) {
							transport = new FuelTruck(bufferTextFromFile.split(":")[2]);
						}
						transport.setTypeWheel(new basicTruckWheel(countWheels.basic, Color.white));
						garagesStages.get(lvl).setTransport(Integer.parseInt(bufferTextFromFile.split(":")[0]),
								transport);
					}

					bufferTextFromFile = "";
				} else {
					bufferTextFromFile += (char) c;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true; 
	}

}
