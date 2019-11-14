import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Transport.FuelTruck;
import Transport.ITransport;
import Transport.Truck;
import myEnum.countWheels;
import parking.*;
import wheel.IWheel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class FormGarages {

	private JFrame frame;
	private JTextField tbTruckNumber;
	garages<ITransport, IWheel> garaging;
	panelGaraging pbGarages;
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
					e.printStackTrace();
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
				if(tbTruckNumber.getText() !="") {
					ITransport transport = garaging.takeTransport(Integer.parseInt(tbTruckNumber.getText()));
					if(transport!=null) {
						transport.SetPosition(5, 5, pbPickUpTruck.getWidth(), pbPickUpTruck.getHeight());
						pbPickUpTruck.setTransport(transport);
						pbPickUpTruck.repaint();
					}
					for (int i = 0; i < garaging.getSize(); i++) {
						if(transport.equals(garaging.checkTransportAtIndex(i)))
						System.out.println(i);
					}
					System.out.println();
				}
			}
		});
		btnTakeTransport.setBounds(14, 41, 89, 23);
		groupBox.add(btnTakeTransport);

		JButton btnAddTruck = new JButton("Truck in garage");
		btnAddTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				garaging.addTransport(transport, wheel);
			}
		});
		btnAddTruck.setBounds(768, 136, 110, 36);
		frame.getContentPane().add(btnAddTruck);

		JButton btnAddFuelTruck = new JButton("Fuel truck in garages");
		btnAddFuelTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				garaging.addTransport(transport, wheel);
			}
		});
		btnAddFuelTruck.setBounds(768, 178, 110, 40);
		frame.getContentPane().add(btnAddFuelTruck);

		garaging = new garages<ITransport, IWheel>(20, pbGarages.getWidth(), pbGarages.getHeight());
		Draw();

	}

	private void Draw() {
		pbGarages.setGarages(garaging);
		pbGarages.repaint();	
	}
}
