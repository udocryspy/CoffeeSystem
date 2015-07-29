import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


public class Customer {
	
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	private JFrame frame;
	private JTextField amtArabica;
	private JTextField amtRobusta;
	private JTextField amtTotal;
	private JTextField qtyA;
	private JTextField qtyR;
	@SuppressWarnings("unused")
	private JLabel label;
	@SuppressWarnings("unused")
	private JTextField textField;
	@SuppressWarnings("unused")
	private JTextField textField_1;
	@SuppressWarnings("unused")
	private static int TotQty = 0;
	int qA,qR,Arabica,Robusta,Total, custno;
	private JTextField txt_customer;
	private JTextField txt_searchphone;
	
	/*{
	    int custno = Customer.getVariable();  // Accessing in Customer class
	}*/

	/**
	 * Launch the application.
	 */
	public void CustomerScreen() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
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
	public Customer() {
		initialize();
		conn=javaconnect.ConnecrDB();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 772, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//conn=javaconnect.ConnecrDB();
		
		JButton btnCheckout = new JButton("CHECKOUT & PRINT RECEIPT");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user=txt_customer.getText();
				if (user.isEmpty()){
					JOptionPane.showMessageDialog (null, "Please enter your name!","My Message", JOptionPane.WARNING_MESSAGE);
				}
				
				else{
				
				try {				
					String sql = "Insert into Customer (CustomerName, QtyArabica, QtyRobusta, AmtTotal) values (?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString (1,txt_customer.getText());
					pst.setString (2,qtyA.getText());
					pst.setString (3,qtyR.getText());
					pst.setString (4,amtTotal.getText());
					//JOptionPane.showMessageDialog(null,"getText captured");
					pst.execute();
					
					qtyA.setText(null);
					qtyR.setText(null);
					amtArabica.setText(null);
					amtRobusta.setText(null);
					amtTotal.setText(null);
					txt_customer.setText(null);
					
					
					
					JOptionPane.showMessageDialog
					(null, "Thank you for the payment!"+"\nPlease collect your Espresso at the Bar counter."
						,"My Message", JOptionPane.INFORMATION_MESSAGE);
					
				
					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog (null, "Something is wrong!","My Message", JOptionPane.WARNING_MESSAGE);
				}
				}
			}
		});
		btnCheckout.setBounds(471, 353, 227, 30);
		frame.getContentPane().add(btnCheckout);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qtyA.setText(null);
				qtyR.setText(null);
				amtArabica.setText(null);
				amtRobusta.setText(null);
				amtTotal.setText(null);
				txt_customer.setText(null);
			}
		});
		btnClear.setBounds(283, 353, 116, 30);
		frame.getContentPane().add(btnClear);
		
		/*textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(555, 173, 131, 33);
		frame.getContentPane().add(textField);*/
		
		JLabel lblTotalrm = new JLabel("TOTAL (RM):");
		lblTotalrm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalrm.setBounds(410, 293, 86, 33);
		frame.getContentPane().add(lblTotalrm);
		
		JPanel panelRobusta = new JPanel();
		panelRobusta.setLayout(null);
		panelRobusta.setBorder(new TitledBorder(null, "Espresso Robusta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRobusta.setBounds(368, 156, 378, 55);
		frame.getContentPane().add(panelRobusta);
		
		JLabel label_1 = new JLabel("Amount (RM):");
		label_1.setBounds(202, 16, 82, 22);
		panelRobusta.add(label_1);
		
		amtRobusta = new JTextField();
		amtRobusta.setBackground(Color.LIGHT_GRAY);
		amtRobusta.setEditable(false);
		amtRobusta.setBounds(279, 17, 62, 20);
		panelRobusta.add(amtRobusta);
		amtRobusta.setColumns(10);
		
		JLabel lblRobustarm = new JLabel("Robusta@RM5");
		lblRobustarm.setBounds(10, 19, 91, 19);
		panelRobusta.add(lblRobustarm);
		
		JLabel lblQty_1 = new JLabel("Qty:");
		lblQty_1.setBounds(111, 18, 29, 18);
		panelRobusta.add(lblQty_1);
		
		qtyR = new JTextField();
		qtyR.setBounds(139, 17, 23, 20);
		panelRobusta.add(qtyR);
		qtyR.setColumns(10);
		
		final Button btnYes = new Button("Yes!");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    JOptionPane.showMessageDialog(null, "Our sandwiches are really good!");
					Snacks sc= new Snacks();
					//s.setVisible(true);
					sc.SnackScreen();
			}
		});
		btnYes.setBounds(425, 229, 55, 22);
		frame.getContentPane().add(btnYes);
		
		/*final JToggleButton tglbtnYes = new JToggleButton("Yes");
		tglbtnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		tglbtnYes.setBounds(349, 262, 62, 23);
		frame.getContentPane().add(tglbtnYes);*/
		
		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int qA,qR,Arabica,Robusta,Total,TotQty;
				

					String user=txt_customer.getText();
					if (user.isEmpty()){
						JOptionPane.showMessageDialog (null, "Please enter your name!","My Message", JOptionPane.WARNING_MESSAGE);
					}
					
					else{	
				
				
				try {
					qA=Integer.parseInt((String) qtyA.getText());
					qR=Integer.parseInt((String) qtyR.getText());
					Arabica=qA*5;
					Robusta=qR*5;
					
					//if (tglbtnYes.isSelected()) {
					//if (btnYes.getModel().isPressed()) {
					if (btnYes.isEnabled()) {
			            System.out.println("Yes Button is pressed");
			            //Total = 500;
			            Total=Snacks.TotalSnacks + Arabica + Robusta;
			            System.out.println(Total);
			        }
					else {
			            //System.out.println("Add Button is not pressed");
						Total=Arabica + Robusta;
						System.out.println(Total);
			        }
					
					//Total=Arabica + Robusta;
								
					/*if (qtyA == null){
							Total=Robusta;
							JOptionPane.showMessageDialog(null,"OK1");}
					if (qtyR== null){
							Total=Arabica;
							JOptionPane.showMessageDialog(null,"OK2");}
					else {
						Total=Arabica + Robusta;
						}*/
					
			
					
					amtArabica.setText(Integer.toString(Arabica));
					amtRobusta.setText(Integer.toString(Robusta));
					amtTotal.setText(Integer.toString(Total));

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number!","My Message", JOptionPane.WARNING_MESSAGE);
					
				}
						}
				
			}
		});
		btnCalculate.setBounds(147, 293, 227, 39);
		frame.getContentPane().add(btnCalculate);
		
		JPanel panelArabica = new JPanel();
		panelArabica.setLayout(null);
		panelArabica.setBorder(new TitledBorder(null, "Espresso Arabica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelArabica.setBounds(368, 90, 378, 55);
		frame.getContentPane().add(panelArabica);
		
		JLabel label;
		label = new JLabel("Amount (RM):");
		label.setBounds(200, 16, 84, 20);
		panelArabica.add(label);
		
		amtArabica = new JTextField();
		amtArabica.setBackground(Color.LIGHT_GRAY);
		amtArabica.setEditable(false);
		amtArabica.setBounds(277, 16, 64, 20);
		panelArabica.add(amtArabica);
		amtArabica.setColumns(10);
		
		JLabel lblQty = new JLabel("Qty:");
		lblQty.setBounds(112, 16, 30, 20);
		panelArabica.add(lblQty);
		
		qtyA = new JTextField();
		qtyA.setBounds(138, 16, 24, 20);
		panelArabica.add(qtyA);
		qtyA.setColumns(10);
		
		JLabel label_6 = new JLabel("Arabica@RM5");
		label_6.setBounds(10, 19, 92, 17);
		panelArabica.add(label_6);
		
		JLabel lblCustomerOrder = new JLabel("CUSTOMER ORDER");
		lblCustomerOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerOrder.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerOrder.setBounds(253, 11, 227, 25);
		frame.getContentPane().add(lblCustomerOrder);
		
		amtTotal = new JTextField();
		amtTotal.setEditable(false);
		amtTotal.setColumns(10);
		amtTotal.setBackground(Color.LIGHT_GRAY);
		amtTotal.setBounds(506, 293, 131, 33);
		frame.getContentPane().add(amtTotal);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using Leeds Coffee Kiosk");
				System.exit(0);
			}
		});
		btnExit.setBounds(96, 353, 116, 30);
		frame.getContentPane().add(btnExit);
		
		JLabel lblCustomer = new JLabel("Customer Name");
		lblCustomer.setBounds(418, 62, 96, 14);
		frame.getContentPane().add(lblCustomer);
		
		txt_customer = new JTextField();
		txt_customer.setBounds(524, 59, 131, 20);
		frame.getContentPane().add(txt_customer);
		txt_customer.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Membership", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(45, 62, 295, 149);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(163, 65, 90, 23);
		panel.add(btnSearch);
		
		txt_searchphone = new JTextField();
		txt_searchphone.setBounds(22, 65, 131, 22);
		panel.add(txt_searchphone);
		txt_searchphone.setToolTipText("Enter your phone number to search");
		txt_searchphone.setColumns(10);
		
		Label label_2 = new Label("Registered member? Enter phone number to search.");
		label_2.setBounds(10, 27, 251, 22);
		panel.add(label_2);
		
		JButton btnGetMembership = new JButton("Get Membership!");
		btnGetMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Membership registration");
				Register rg = new Register();
				rg.RegistrationScreen();
			}
		});
		btnGetMembership.setBounds(60, 99, 147, 23);
		panel.add(btnGetMembership);
		
		Label label_3 = new Label("Want some snacks to go with?");
		label_3.setAlignment(Label.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(194, 229, 219, 22);
		frame.getContentPane().add(label_3);
		
		/*JToggleButton tglbtnYes = new JToggleButton("Yes");
		tglbtnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		tglbtnYes.setBounds(349, 262, 62, 23);
		frame.getContentPane().add(tglbtnYes);*/
		
		/*Button btnYes = new Button("Yes!");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnYes.setBounds(307, 263, 36, 22);
		frame.getContentPane().add(btnYes);*/
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mobile;
				try {
					//String sql1="select Phone from Registration where Phone=?";
					String sql1="select * from Registration where Phone=?";
					pst=conn.prepareStatement(sql1);
					pst.setString (1,txt_searchphone.getText());
					//JOptionPane.showMessageDialog(null, "get txt_searchphone");
					mobile=Integer.parseInt((String) txt_searchphone.getText());
					//JOptionPane.showMessageDialog(null, mobile);
										
					ResultSet rs=pst.executeQuery();			
					rs=pst.executeQuery();
					if (rs.next()) {
						//JOptionPane.showMessageDialog(null, "Welcome member");
						//String sqlcustName = ("SELECT FirstName FROM Registration");
						String sqlcustName = ("SELECT FirstName FROM Registration where Phone = " + mobile);
						//JOptionPane.showMessageDialog(null, mobile);
						
						pst=conn.prepareStatement(sqlcustName);
						//JOptionPane.showMessageDialog(null, sqlcustName);
						
						rs=pst.executeQuery();
						if(rs.next()){
	                        String FName = rs.getString("FirstName");
	                        txt_customer.setText(FName);
	                        //JOptionPane.showMessageDialog(null, FName);
	                        JOptionPane.showMessageDialog(null, "Hi " +FName+ ", Good Day to you!");
						}
						
					}
					
					else {
						//JOptionPane.showMessageDialog(null, "Username and Password is not correct");
						JOptionPane.showMessageDialog(null, "You are not a registered member. Please Get Membership to enjoy our special discounts!","My Message", JOptionPane.INFORMATION_MESSAGE);
						txt_searchphone.setText(null);
						
					}
					
					txt_searchphone.setText(null);
					
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAdmin = new JMenuItem("Admin");
		mntmAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Log In to Admin Screen");
				Login ls = new Login();
				ls.LoginScreen();
			}
		});
		mnFile.add(mntmAdmin);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Thank you for using Leeds Coffee Kiosk");
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		/*amtTotal = new JTextField();
		amtTotal.setBackground(Color.LIGHT_GRAY);
		amtTotal.setEditable(false);
		amtTotal.setBounds(528, 184, 131, 33);
		//panelCustomer.add(amtTotal);
		amtTotal.setColumns(10);*/
		
	}

	protected JFrame Snacks() {
		// TODO Auto-generated method stub
		return null;
	}
}
