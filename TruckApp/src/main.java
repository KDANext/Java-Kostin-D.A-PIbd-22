import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JButton;
import Transport.*;
import myEnum.*;
import wheel.basicTruckWheel;
import wheel.goodTruckWheel;
import wheel.superTruckWheel;
//
public class main {
	private JFrame frame;
	private My_JPanel panel;
	JButton btnUp;
	JButton btnDown;
	JButton btnLeft;
	JButton btnRight;
	JButton btnCreateFuelTruck;
	JButton btnCreateTruck;
	ITransport transport;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//
	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}
	//
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//
		panel = new My_JPanel();
		panel.setBounds(10, 45, 784, 364);
		frame.getContentPane().add(panel);
		//
		btnCreateFuelTruck = new JButton("Create fuel truck");
		btnCreateFuelTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFuelTruck();
				panel.setTransport(transport);
				panel.repaint();   
			}
		});
		btnCreateFuelTruck.setBounds(10, 11, 135, 23);
		frame.getContentPane().add(btnCreateFuelTruck);
		//
		btnLeft = new JButton("");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport.MoveTransport(Direction.Left);
				panel.setTransport(transport);
				panel.repaint();
			}
		});
		btnLeft.setBounds(764, 420, 30, 30);
		frame.getContentPane().add(btnLeft);
		//
		btnDown = new JButton("");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport.MoveTransport(Direction.Down);
				panel.setTransport(transport);
				panel.repaint();
			}
		});
		btnDown.setBounds(804, 420, 30, 30);
		frame.getContentPane().add(btnDown);
		//
		btnRight = new JButton("");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport.MoveTransport(Direction.Right);
				panel.setTransport(transport);
				panel.repaint();
			}
		});
		btnRight.setBounds(844, 420, 30, 30);
		frame.getContentPane().add(btnRight);
		//
		btnUp = new JButton("");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport.MoveTransport(Direction.Up);
				panel.setTransport(transport);
				panel.repaint();
			}
		});
		btnUp.setBounds(804, 379, 30, 30);
		frame.getContentPane().add(btnUp);
		//
		btnCreateTruck = new JButton("Create truck");
		btnCreateTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTruck();			
				panel.setTransport(transport);
				panel.repaint();
			}
		});
		btnCreateTruck.setBounds(147, 11, 135, 23);
		frame.getContentPane().add(btnCreateTruck);
	}
	//
	protected void newFuelTruck() {
		Random rnd = new Random();
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
        transport = new FuelTruck(100, countWheels, 1000,"FUEL",10, false, Color.orange, Color.gray, Color.black, Color.red);
        transport.SetPosition(rnd.nextInt(90)+10, rnd.nextInt(90)+10, panel.getWidth(), panel.getHeight());	
	}
	//
	protected void newTruck() {
		Random rnd = new Random();
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
        transport = new Truck(100,countWheels,1000,true,Color.white,Color.white,Color.black);
        transport.SetPosition(rnd.nextInt(90)+10, rnd.nextInt(90)+10, panel.getWidth(), panel.getHeight());	
	}
}
