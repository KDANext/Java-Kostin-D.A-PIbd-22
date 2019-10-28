import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JButton;
import Transport.FuelTruck;
import myEnum.Direction;
//
public class main {
	private JFrame frame;
	private My_JPanel panel;
	JButton btnUp;
	JButton btnDown;
	JButton btnLeft;
	JButton btnRight;
	JButton btnCreateFuelTruck;
	FuelTruck fuelTruck ;
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
				fuelTruck = new FuelTruck();
				Random random = new Random();
				fuelTruck.setPosition(
						random.nextInt(100), 
						random.nextInt(100),
						panel.getWidth(), 
						panel.getHeight()
						);
				panel.setFuelTruck(fuelTruck);
				panel.repaint();   
			}
		});
		btnCreateFuelTruck.setBounds(10, 11, 135, 23);
		frame.getContentPane().add(btnCreateFuelTruck);
		//
		btnLeft = new JButton("");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuelTruck.moveTruck(Direction.Left);
				panel.setFuelTruck(fuelTruck);
				panel.repaint();
			}
		});
		btnLeft.setBounds(764, 420, 30, 30);
		frame.getContentPane().add(btnLeft);
		//
		btnDown = new JButton("");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuelTruck.moveTruck(Direction.Down);
				panel.setFuelTruck(fuelTruck);
				panel.repaint();
			}
		});
		btnDown.setBounds(804, 420, 30, 30);
		frame.getContentPane().add(btnDown);
		//
		btnRight = new JButton("");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuelTruck.moveTruck(Direction.Right);
				panel.setFuelTruck(fuelTruck);
				panel.repaint();
			}
		});
		btnRight.setBounds(844, 420, 30, 30);
		frame.getContentPane().add(btnRight);
		//
		btnUp = new JButton("");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuelTruck.moveTruck(Direction.Up);
				panel.setFuelTruck(fuelTruck);
				panel.repaint();
			}
		});
		btnUp.setBounds(804, 379, 30, 30);
		frame.getContentPane().add(btnUp);
	}
}
