import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register {

	Connection conn=null;
	//ResultSet rs=null;
	PreparedStatement pst=null;
	
	private JFrame frame;
	private JTextField txt_fname;
	private JTextField txt_lname;
	private JTextField txt_email;
	@SuppressWarnings("rawtypes")
	private JComboBox cbgender;
	private JTextField txt_phone;

	/**
	 * Launch the application.
	 */
	public void RegistrationScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
		conn=javaconnect.ConnecrDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(75, 68, 82, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(75, 105, 82, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(75, 186, 82, 14);
		frame.getContentPane().add(lblEmail);
		
		txt_fname = new JTextField();
		txt_fname.setBounds(167, 65, 186, 20);
		frame.getContentPane().add(txt_fname);
		txt_fname.setColumns(10);
		
		txt_lname = new JTextField();
		txt_lname.setColumns(10);
		txt_lname.setBounds(167, 102, 186, 20);
		frame.getContentPane().add(txt_lname);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(167, 183, 186, 20);
		frame.getContentPane().add(txt_email);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql = "Insert into Registration (FirstName, LastName, Phone, Email) values (?,?,?,?)";
					//JOptionPane.showMessageDialog(null,sql);
					//pst=conn.prepareStatement(sql);
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString (1,txt_fname.getText());
					pst.setString (2,txt_lname.getText());
					pst.setString (3,txt_phone.getText());
					pst.setString (4,txt_email.getText());
					pst.execute();
					
					txt_fname.setText(null);
					txt_lname.setText(null);
					txt_phone.setText(null);
					txt_email.setText(null);
					
					//JOptionPane.showMessageDialog(null,"Saved"");
					JOptionPane.showMessageDialog
					(null, "Thank you for registering with Leeds Coffee Kiosk!","My Message", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog (null, "Registration failed!","My Message", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnRegister.setBounds(264, 224, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblRegistration = new JLabel("REGISTRATION");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistration.setBounds(110, 11, 205, 25);
		frame.getContentPane().add(lblRegistration);
		
		JButton btnNewButton = new JButton("Continue to order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cs = new Customer();
				cs.CustomerScreen();
			}
		});
		btnNewButton.setBounds(167, 258, 186, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(75, 146, 82, 14);
		frame.getContentPane().add(lblPhone);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(167, 143, 186, 20);
		frame.getContentPane().add(txt_phone);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbgender() {
		return cbgender;
	}

	@SuppressWarnings("rawtypes")
	public void setCbgender(JComboBox cbgender) {
		this.cbgender = cbgender;
	}
}
