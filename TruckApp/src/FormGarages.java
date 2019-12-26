import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Transport.FuelTruck;
import Transport.ITransport;
import Transport.Truck;
import Transport.Vehicle;
import delegate.TransportDelegate;
import exception.GaragesNotFoundException;
import exception.GaragesOccupiedPlaceException;
import exception.GaragesOverflowException;
import exception.formatErrorLog;
import myEnum.countWheels;
import parking.*;
import wheel.IWheel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FormGarages {
	private JFrame frame;
	private JTextField tbTruckNumber;
	private JList listLevels;
	private panelGaraging pbGarages;
	private multiLevelGarages garages;	
	private final int countLevel = 5;
	private int selectLevel = 0;
	historyTransport historyTransport = new historyTransport();
	static Logger loggerInfo;
	static Logger loggerError;
	class _delegate extends TransportDelegate {
		@Override
		public void invoke(ITransport transport) {
			try {
				int place = garages.getGaragesStages(selectLevel).addTransport(transport,((Vehicle)transport).getTypeWheel());
				loggerInfo.info("Added car " + transport.ToString() + " in place " + place);
			} catch (GaragesOverflowException e) {
				loggerError.warning("Garages overflow");
				JOptionPane.showMessageDialog(null, "Garages overflow","Exception", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				loggerError.warning("Unknown error");
				JOptionPane.showMessageDialog(null, "Unknown error","Exception", JOptionPane.ERROR_MESSAGE);
			}
			pbGarages.repaint();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormGarages window = new FormGarages();
					window.frame.setVisible(true);
				} catch (Exception e) {
					loggerError.warning("Unknown error");
					JOptionPane.showMessageDialog(null, "Unknown error","Exception", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public FormGarages() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		loggerInfo = Logger.getLogger(FormGarages.class.getName() + "1");
		loggerError = Logger.getLogger(FormGarages.class.getName() + "2");
		try {
			FileHandler fhInfo = null;
			FileHandler fhError = null;
			fhInfo = new FileHandler("log\\infoLog.txt");
			fhError = new FileHandler("log\\errorLog.txt");
			loggerInfo.addHandler(fhInfo);
			loggerError.addHandler(fhError);
			loggerInfo.setUseParentHandlers(false);
			loggerError.setUseParentHandlers(false);
			SimpleFormatter formatter = new SimpleFormatter();
			fhInfo.setFormatter(formatter);
			fhError.setFormatter(new formatErrorLog());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		pbGarages = new panelGaraging();
		pbGarages.setBounds(0, 1, 762, 460);
		frame.getContentPane().add(pbGarages);

		JPanel groupBox = new JPanel();
		groupBox.setBounds(768, 299, 110, 162);
		frame.getContentPane().add(groupBox);
		groupBox.setLayout(null);
		groupBox.setBorder(BorderFactory.createTitledBorder("Pick up truck"));

		JLabel lblNewLabel = new JLabel("A place:");
		lblNewLabel.setBounds(4, 19, 46, 13);
		groupBox.add(lblNewLabel);

		tbTruckNumber = new JTextField();
		tbTruckNumber.setBounds(62, 16, 42, 20);
		groupBox.add(tbTruckNumber);
		tbTruckNumber.setColumns(10);

		My_JPanel pbPickUpTruck = new My_JPanel();
		pbPickUpTruck.setBounds(4, 64, 100, 60);
		groupBox.add(pbPickUpTruck);

		JButton btnTakeTransport = new JButton("Take");
		btnTakeTransport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectLevel>-1)
					if(tbTruckNumber.getText() !="") {
						try {
							ITransport transport = garages.getGaragesStages(selectLevel).takeTransport(Integer.parseInt(tbTruckNumber.getText()));
							if(transport!=null) {
								transport.SetPosition(5, 5, pbPickUpTruck.getWidth(), pbPickUpTruck.getHeight());
								pbPickUpTruck.setTransport(transport);
								historyTransport.addHistory(transport);
								pbGarages.setHistoryTransport(historyTransport);
								loggerInfo.info("Vehicle seized " + transport.ToString() + " from place " + tbTruckNumber.getText());
								Draw();
							}
						} catch (GaragesNotFoundException ex) {
							loggerError.warning("Not fount transport");
							JOptionPane.showMessageDialog(frame, "Not fount transport","Exception", JOptionPane.ERROR_MESSAGE);
						} catch (Exception ex) {
							loggerError.warning("Unknown error");
							JOptionPane.showMessageDialog(frame, "Unknown error","Exception", JOptionPane.ERROR_MESSAGE);
						}
					}
			}
		});
		btnTakeTransport.setBounds(14, 41, 89, 23);
		groupBox.add(btnTakeTransport);

		JButton btnAddTruck = new JButton("Truck in garage");
		btnAddTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Random rnd=new Random();
					countWheels countWheels = null;
					switch(rnd.nextInt(4)) {
					case 3:
						countWheels=countWheels.superIncreasedCarryngCapacity;
						break;
					case 2:
						countWheels=countWheels.increasedCarryngCapacity;
						break;
					case 1:
						countWheels=countWheels.basic;
						break;
					default:
						countWheels=countWheels.basic;
						break;
					}
					Color mainColor = JColorChooser.showDialog(pbGarages, "chose", Color.BLACK);
					ITransport transport = new Truck(100,countWheels,100,rnd.nextBoolean(),mainColor,Color.white,Color.BLACK);						
					IWheel wheel= new wheel.basicTruckWheel(countWheels, Color.white);
					int place = garages.getGaragesStages(selectLevel).addTransport(transport, wheel);
					loggerInfo.info("Added car " + transport.ToString() + " in place " + place);
					Draw();
				} catch (GaragesOverflowException ex) {
					loggerError.warning("Garages overflow!!!!");
					JOptionPane.showMessageDialog(frame, "Garages overflow!!!!","Exception", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddTruck.setBounds(768, 136, 110, 36);
		frame.getContentPane().add(btnAddTruck);

		JButton btnAddFuelTruck = new JButton("Fuel truck in garages");
		btnAddFuelTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Random rnd=new Random();
					countWheels countWheels = null;
					switch(rnd.nextInt(4)) {
					case 3:
						countWheels=countWheels.superIncreasedCarryngCapacity;
						break;
					case 2:
						countWheels=countWheels.increasedCarryngCapacity;
						break;
					case 1:
						countWheels=countWheels.basic;
						break;
					default:
						countWheels=countWheels.basic;
						break;
					}
					Color mainColor = JColorChooser.showDialog(pbGarages, "chose", Color.BLACK);
					Color drivesColor = JColorChooser.showDialog(pbGarages, "chose", Color.BLACK);
					ITransport transport = new FuelTruck(100,countWheels,100,"FUEL",10,rnd.nextBoolean(),mainColor,drivesColor,Color.BLACK,Color.red);						
					IWheel wheel= new wheel.basicTruckWheel(countWheels, drivesColor);
					int place = garages.getGaragesStages(selectLevel).addTransport(transport, wheel);
					loggerInfo.info("Added car " + transport.ToString() + " in place " + place);
				} catch (GaragesOverflowException ex) {
					loggerError.warning("Garages overflow!!!!");
					JOptionPane.showMessageDialog(frame, "Garages overflow!!!!","Exception", JOptionPane.ERROR_MESSAGE);
				}
				Draw();
			}
		});
		btnAddFuelTruck.setBounds(768, 178, 110, 40);
		frame.getContentPane().add(btnAddFuelTruck);

		DefaultListModel listLevelModel = new DefaultListModel();
		for (int i = 0; i < countLevel; i++) {
			listLevelModel.addElement("Уровень "+(i+1));
		}
		JList listLevels = new JList(listLevelModel);
		listLevels.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectLevel=listLevels.getSelectedIndex();
				Draw();
			}
		});
		listLevels.setBounds(768, 1, 110, 121);
		frame.getContentPane().add(listLevels);

		JButton btnAddTransport = new JButton("Add transport");
		btnAddTransport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormConfigTruck conf = new FormConfigTruck(new _delegate());
				conf.frame.setVisible(true);
				Draw();	
			}
		});
		btnAddTransport.setBounds(768, 229, 110, 40);
		frame.getContentPane().add(btnAddTransport);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnAll = new JMenu("All");
		menuBar.add(mnAll);

		JMenuItem mntmSaveAll = new JMenuItem("Save");
		mntmSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Save");                
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						garages.SaveData(file.getAbsolutePath());
						loggerInfo.info("Saving was successful");
						JOptionPane.showMessageDialog(frame, "Saving was successful","Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch (Exception ex) {
					loggerError.warning("Unknown error while saving");
					JOptionPane.showMessageDialog(frame, "Unknown error while saving","Exception", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnAll.add(mntmSaveAll);

		JMenuItem mntmLoadAll = new JMenuItem("Load");
		mntmLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Load");                
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						garages.LoadData(file.getAbsolutePath());
						loggerInfo.info("Load file!");
					} 
				} catch (GaragesOccupiedPlaceException ex) {
					loggerError.warning("Garages occupied place");
					JOptionPane.showMessageDialog(frame, "\"Garages occupied place","Exception", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					loggerError.warning("Unknown error while load");
					JOptionPane.showMessageDialog(frame, "Unknown error while load","Exception", JOptionPane.ERROR_MESSAGE);
				}
				Draw();
			}
		});
		mnAll.add(mntmLoadAll);

		JMenu mnLevel = new JMenu("Level");
		menuBar.add(mnLevel);

		JMenuItem mntmSaveLevel = new JMenuItem("Save");
		mntmSaveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("lvl", "lvl");
				filechooser.setFileFilter(filter);
				int ret = filechooser.showDialog(null, "Save");                
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = filechooser.getSelectedFile();
					try {
						garages.SaveLevel(file.getAbsolutePath(), selectLevel);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Draw();
				}
			}
		});
		mnLevel.add(mntmSaveLevel);

		JMenuItem mntmLoadLevel = new JMenuItem("Load");
		mntmLoadLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("lvl", "lvl");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Load");                
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						garages.LoadLevel(file.getAbsolutePath());

						Draw();
					}				
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		mnLevel.add(mntmLoadLevel);
		garages = new multiLevelGarages(countLevel, pbGarages.getWidth(), pbGarages.getHeight());
		Draw();		
	}

	private void Draw() {
		pbGarages.setGarages(garages.getGaragesStages(selectLevel));
		pbGarages.repaint();	
	}
}
