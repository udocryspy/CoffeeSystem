import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Snacks {

	private JFrame frame;
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	private JTextField txt_disp_chick;
	private JTextField txt_chick;
	private JTextField txt_disp_tuna;
	private JTextField txt_tuna;
	
	//public int TotalSnacks;
	int qC,qT,Chicken,Tuna;

	static int TotalSnacks;
	
	public Integer getMyValue() {
	      return TotalSnacks;
	    }

	/**
	 * Launch the application.
	 */
	public  void SnackScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Snacks window = new Snacks();
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
	public Snacks() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSnacks = new JLabel("SNACKS");
		lblSnacks.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnacks.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSnacks.setBounds(109, 11, 205, 25);
		frame.getContentPane().add(lblSnacks);
		
		final JButton btnBack = new JButton("Back to Customer Order");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Back to Customer Order");
				if (btnBack.isEnabled()) {
					JOptionPane.showMessageDialog(null, "Back to Customer Order");
					frame.setState(Frame.ICONIFIED);

				}
				else {
					JOptionPane.showMessageDialog(null, "Close Snacks Screen");
				}
				//Customer cs = new Customer();
				//cs.CustomerScreen();
			}
		});
		btnBack.setBounds(109, 213, 231, 23);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Club Chicken Sandwich", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(33, 47, 363, 55);
		frame.getContentPane().add(panel);
		
		JLabel lbl_amt_chick = new JLabel("Amount (RM):");
		lbl_amt_chick.setBounds(200, 16, 84, 20);
		panel.add(lbl_amt_chick);
		
		txt_disp_chick = new JTextField();
		txt_disp_chick.setEditable(false);
		txt_disp_chick.setColumns(10);
		txt_disp_chick.setBackground(Color.LIGHT_GRAY);
		txt_disp_chick.setBounds(294, 16, 47, 20);
		panel.add(txt_disp_chick);
		
		JLabel label_1 = new JLabel("Qty:");
		label_1.setBounds(104, 16, 30, 20);
		panel.add(label_1);
		
		txt_chick = new JTextField();
		txt_chick.setColumns(10);
		txt_chick.setBounds(130, 16, 24, 20);
		panel.add(txt_chick);
		
		JLabel lblClubChickenrm = new JLabel("Chicken@RM15");
		lblClubChickenrm.setBounds(10, 19, 84, 17);
		panel.add(lblClubChickenrm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Club Tuna Sandwich", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(33, 113, 363, 55);
		frame.getContentPane().add(panel_1);
		
		JLabel lbl_amt_tuna = new JLabel("Amount (RM):");
		lbl_amt_tuna.setBounds(200, 16, 84, 20);
		panel_1.add(lbl_amt_tuna);
		
		txt_disp_tuna = new JTextField();
		txt_disp_tuna.setEditable(false);
		txt_disp_tuna.setColumns(10);
		txt_disp_tuna.setBackground(Color.LIGHT_GRAY);
		txt_disp_tuna.setBounds(294, 16, 47, 20);
		panel_1.add(txt_disp_tuna);
		
		JLabel label_3 = new JLabel("Qty:");
		label_3.setBounds(104, 16, 30, 20);
		panel_1.add(label_3);
		
		txt_tuna = new JTextField();
		txt_tuna.setColumns(10);
		txt_tuna.setBounds(130, 16, 24, 20);
		panel_1.add(txt_tuna);
		
		JLabel lblClubTunarm = new JLabel("Tuna@RM15");
		lblClubTunarm.setBounds(10, 19, 84, 17);
		panel_1.add(lblClubTunarm);
		
		JButton btnConfirm = new JButton("Confirm Snacks");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				qC=Integer.parseInt((String) txt_chick.getText());
				qT=Integer.parseInt((String) txt_tuna.getText());
				Chicken=qC*15;
				Tuna=qT*15;
				TotalSnacks=Chicken+Tuna;
				System.out.println("Total is: RM"+TotalSnacks);
			}
		});
		btnConfirm.setBounds(208, 179, 132, 23);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_chick.setText(null);
				txt_tuna.setText(null);
			}
		});
		btnClear.setBounds(109, 179, 89, 23);
		frame.getContentPane().add(btnClear);
	}

	protected Component getRootPane() {
		// TODO Auto-generated method stub
		return null;
	}
}
