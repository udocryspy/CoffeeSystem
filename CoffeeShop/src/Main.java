import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;
	public int cust;
	public static int custno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 305);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCustomer = new JButton("Customer Order");
		btnCustomer.setHorizontalAlignment(SwingConstants.LEADING);
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Welcome to Coffee Kiosk ");
				//Coffee1 nw = new Coffee1();
				//nw.NewScreen();
				//cust=cust+1;
				Customer cs = new Customer();
				cs.CustomerScreen();
			}
		});
		btnCustomer.setBounds(36, 86, 163, 103);
		frame.getContentPane().add(btnCustomer);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Welcome Admin ");
				Login ls = new Login();
				ls.LoginScreen();
			}
		});
		
		btnAdmin.setBounds(239, 86, 163, 103);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Thank You for using Leeds Coffee Kiosk");
		          System.exit(0);
			}
			
		});
		btnExit.setBounds(239, 219, 163, 35);
		frame.getContentPane().add(btnExit);
		
		JLabel lblLeedsCoffeeKiosk = new JLabel("LEEDS COFFEE KIOSK");
		lblLeedsCoffeeKiosk.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeedsCoffeeKiosk.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblLeedsCoffeeKiosk.setForeground(new Color(148, 0, 211));
		lblLeedsCoffeeKiosk.setBounds(36, 11, 366, 72);
		frame.getContentPane().add(lblLeedsCoffeeKiosk);
		
		JButton btnNewButton = new JButton("Send Feedback!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Feedback fs= new Feedback();
				fs.FeedbackScreen();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(36, 218, 163, 35);
		frame.getContentPane().add(btnNewButton);
		
		/*JButton btnBeAMember = new JButton("Be a Member!");
		btnBeAMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Membership registration");
				Register rg = new Register();
				rg.RegistrationScreen();
			}
		});
		btnBeAMember.setBounds(141, 191, 147, 23);
		frame.getContentPane().add(btnBeAMember);*/
	} 
	
}
