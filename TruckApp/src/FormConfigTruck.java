import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Transport.FuelTruck;
import Transport.ITransport;
import Transport.Truck;
import delegate.TransportDelegate;
import myEnum.countWheels;
import wheel.IWheel;
import wheel.basicTruckWheel;
import wheel.goodTruckWheel;
import wheel.superTruckWheel;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormConfigTruck {

	public JFrame frame;
	private ITransport tempTransport;
	private IWheel tempWheel;
	private Color tempColor;
	private My_JPanel pbTransport;
	TransportDelegate add;
	FormConfigTruck window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FormConfigTruck window = new FormConfigTruck(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	public FormConfigTruck(TransportDelegate delegate) {
		add = delegate;
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 412, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 120, 140);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type truck:");
		lblNewLabel.setBounds(10, 11, 100, 17);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTruck = new JLabel("Truck");
		lblTruck.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				tempTransport = new Truck(100,countWheels.basic,100,true,Color.white,Color.white,Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempTransport = null;
			}
		});
		lblTruck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTruck.setBounds(10, 39, 100, 40);
		panel_1.add(lblTruck);
		
		JLabel lblFuelTruck = new JLabel("Fuel truck");
		lblFuelTruck.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				tempTransport = new FuelTruck(100,countWheels.basic,100,"FUEL",10,true,Color.white,Color.white,Color.BLACK,Color.white);	
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempTransport = null;
			}
		});
		lblFuelTruck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFuelTruck.setBounds(10, 90, 100, 40);
		panel_1.add(lblFuelTruck);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(270, 11, 116, 209);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel labelColor = new JLabel("Color:");
		labelColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelColor.setBounds(10, 11, 100, 17);
		panel_2.add(labelColor);
		
		JLabel lcWhite = new JLabel("");
		lcWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempColor=Color.white;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				tempColor=null;
			}
		});
		JLabel lcBlack = new JLabel("");
		lcBlack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempColor=Color.black;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempColor=null;
			}
		});
		JLabel lcGreen = new JLabel("");
		lcGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempColor=Color.green;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempColor=null;
			}
		});
		JLabel lcYellow = new JLabel("");
		lcYellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempColor=Color.yellow;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempColor=null;
			}
		});
		JLabel lcOrange = new JLabel("");
		lcOrange.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempColor=Color.orange;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempColor=null;
			}
		});
		JLabel lcBlue = new JLabel("");
		lcBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempColor=Color.blue;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempColor=null;
			}
		});
		JLabel lcRed = new JLabel("");
		lcRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempColor=Color.red;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempColor=null;
			}
		});
		JLabel lcCyan = new JLabel("");
		lcCyan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempColor=Color.cyan;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempColor=null;
			}
		});
		
		lcWhite.setBounds(6, 39, 49, 20);
		lcBlack.setBounds(55, 40, 49, 20);
		lcGreen.setBounds(55, 71, 49, 20);
		lcYellow.setBounds(6, 70, 49, 20);;
		lcOrange.setBounds(55, 103, 49, 20);
		lcBlue.setBounds(6, 102, 49, 20);
		lcRed.setBounds(55, 135, 49, 20);
		lcCyan.setBounds(6, 134, 49, 20);
		
		lcWhite.setBackground(Color.WHITE);
		lcBlack.setBackground(Color.BLACK);
		lcGreen.setBackground(Color.GREEN);
		lcYellow.setBackground(Color.YELLOW);
		lcOrange.setBackground(Color.ORANGE);
		lcBlue.setBackground(Color.BLUE);
		lcRed.setBackground(Color.RED);
		lcCyan.setBackground(Color.CYAN);
		
		lcWhite.setOpaque(true);
		lcBlack.setOpaque(true);
		lcGreen.setOpaque(true);
		lcYellow.setOpaque(true);
		lcOrange.setOpaque(true);
		lcBlue.setOpaque(true);
		lcRed.setOpaque(true);
		lcCyan.setOpaque(true);
		
		panel_2.add(lcWhite);
		panel_2.add(lcBlack);
		panel_2.add(lcGreen);
		panel_2.add(lcYellow);
		panel_2.add(lcOrange);
		panel_2.add(lcBlue);
		panel_2.add(lcRed);
		panel_2.add(lcCyan);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (tempTransport != null) {
					tempTransport.setTypeWheel(new basicTruckWheel(countWheels.basic, Color.white));
					pbTransport.setTransport(tempTransport);
					pbTransport.repaint();
				}
				if (tempWheel != null) {
					if (pbTransport.getTransport() != null) {
						pbTransport.getTransport().setTypeWheel(tempWheel);
						pbTransport.repaint();
					}
				}
			}
		});
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBounds(140, 11, 120, 260);
		panel_3.setTransferHandler(new TransferHandler("type_transport"));
		frame.getContentPane().add(panel_3);
		
		pbTransport = new My_JPanel();
		pbTransport.setBorder(new LineBorder(new Color(0, 0, 0)));
		pbTransport.setBounds(10, 11, 100, 60);
		panel_3.add(pbTransport);
		
		JLabel mainColor = new JLabel("Main color");
		mainColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(tempColor!=null) {
					pbTransport.getTransport().SetMainColor(tempColor);
				}
			}
		});
		mainColor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainColor.setBounds(10, 82, 100, 50);
		panel_3.add(mainColor);
		mainColor.setTransferHandler(new TransferHandler("123"));
		mainColor.setDropTarget(null);
		
		JLabel secondColor = new JLabel("Second color");
		secondColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(pbTransport.getTransport()!=null && pbTransport.getTransport() instanceof FuelTruck) {
					if( tempColor != null) {
						FuelTruck temp = (FuelTruck) pbTransport.getTransport();
						temp.setTankColor(tempColor);
						pbTransport.setTransport(temp);
					}
				}
			}
		});
		secondColor.setForeground(Color.BLACK);
		secondColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		secondColor.setBounds(10, 143, 100, 50);
		panel_3.add(secondColor);
		
		JLabel typeWheel = new JLabel("Type wheel");
		typeWheel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(pbTransport.getTransport()!=null) {
					if(tempWheel!=null) {
						pbTransport.getTransport().setTypeWheel(tempWheel);
					}
				}
			}
		});
		typeWheel.setForeground(Color.BLACK);
		typeWheel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		typeWheel.setBounds(10, 204, 100, 50);
		panel_3.add(typeWheel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(10, 197, 120, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnOk = new JButton("Add transport");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pbTransport.getTransport()!=null) {
					add.invoke(pbTransport.getTransport());
					frame.dispose();
				}
			}
		});
		btnOk.setBounds(10, 163, 120, 23);
		frame.getContentPane().add(btnOk);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 231, 98, 95);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Type wheel:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 120, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblBasicWheel = new JLabel("");
		lblBasicWheel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempWheel = new basicTruckWheel(countWheels.basic,Color.white);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempWheel = null;
			}
		});
		lblBasicWheel.setIcon(new ImageIcon("res\\basicWheel.png"));
		lblBasicWheel.setBounds(10, 40, 27, 44);
		panel.add(lblBasicWheel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempWheel = new goodTruckWheel(countWheels.basic,Color.white);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempWheel = null;
			}
		});
		label.setIcon(new ImageIcon("res\\goodWheel.png"));
		label.setBounds(37, 40, 27, 44);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tempWheel = new superTruckWheel(countWheels.basic,Color.white);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tempWheel = null;
			}
		});
		label_1.setIcon(new ImageIcon("res\\superWheel.png"));
		label_1.setBounds(64, 40, 27, 44);
		panel.add(label_1);
	}
}
