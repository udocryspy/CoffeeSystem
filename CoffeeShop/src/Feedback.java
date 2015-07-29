import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Feedback {
	
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	private JFrame frame;
	private JTextField txt_name_fback;
	private JTextField txt_email_fback;

	/**
	 * Launch the application.
	 */
	public void FeedbackScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback window = new Feedback();
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
	public Feedback() {
		initialize();
		conn=javaconnect.ConnecrDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFeedback = new JLabel("FEEDBACK");
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFeedback.setBounds(107, 11, 205, 25);
		frame.getContentPane().add(lblFeedback);
		
		JLabel lblPleaseTakeA = new JLabel("Please take a minute to assess our service.");
		lblPleaseTakeA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseTakeA.setBounds(66, 47, 303, 14);
		frame.getContentPane().add(lblPleaseTakeA);
		
		JLabel lblYourFeedbackIs = new JLabel("Your feedback is most valuable to to us!");
		lblYourFeedbackIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourFeedbackIs.setBounds(66, 62, 303, 14);
		frame.getContentPane().add(lblYourFeedbackIs);
		
		JLabel lblNameFback = new JLabel("Name:");
		lblNameFback.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameFback.setBounds(51, 90, 82, 14);
		frame.getContentPane().add(lblNameFback);
		
		txt_name_fback = new JTextField();
		txt_name_fback.setColumns(10);
		txt_name_fback.setBounds(160, 87, 186, 20);
		frame.getContentPane().add(txt_name_fback);
		
		JLabel lblEmailFback = new JLabel("Email:");
		lblEmailFback.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailFback.setBounds(51, 121, 82, 14);
		frame.getContentPane().add(lblEmailFback);
		
		txt_email_fback = new JTextField();
		txt_email_fback.setColumns(10);
		txt_email_fback.setBounds(160, 118, 186, 20);
		frame.getContentPane().add(txt_email_fback);
		
		JLabel lblCommentFback = new JLabel("Comment:");
		lblCommentFback.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommentFback.setBounds(51, 147, 82, 14);
		frame.getContentPane().add(lblCommentFback);
		
		final JTextArea textArea_fback = new JTextArea();
		textArea_fback.setBounds(160, 152, 186, 79);
		frame.getContentPane().add(textArea_fback);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_name_fback.setText(null);
				txt_email_fback.setText(null);
				textArea_fback.setText(null);
			}
		});
		btnReset.setBounds(170, 250, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnSendFeedback = new JButton("Send");
		btnSendFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user=txt_name_fback.getText();
				if (user.isEmpty()){
					JOptionPane.showMessageDialog (null, "Please enter your name!","My Message", JOptionPane.WARNING_MESSAGE);
				}
				
				else{
					
					try {
						
						String sql = "Insert into Feedback (Name, Email, Comment) values (?,?,?)";
						PreparedStatement pst=conn.prepareStatement(sql);
						pst.setString (1,txt_name_fback.getText());
						pst.setString (2,txt_email_fback.getText());
						pst.setString (3,textArea_fback.getText());
						//JOptionPane.showMessageDialog(null,"getText captured");
						pst.execute();
						
						txt_name_fback.setText(null);
						txt_email_fback.setText(null);
						textArea_fback.setText(null);
								
						JOptionPane.showMessageDialog (null, "Thank you for your feedback!","My Message", JOptionPane.INFORMATION_MESSAGE);
						
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog (null, "Something is wrong!","My Message", JOptionPane.WARNING_MESSAGE);
						
					}
					
				}
			}
		});
		btnSendFeedback.setBounds(280, 250, 89, 23);
		frame.getContentPane().add(btnSendFeedback);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(59, 250, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
