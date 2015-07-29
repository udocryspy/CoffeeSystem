import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Admin {

	private JFrame frame;
	private JTextField txt_totOrders;
	private JTextField txt_totSales;
	private JTextField txt_totEmp;
	private JTextField txt_mnthPayout;
	int totOrders, totSales, totEmp, salEmp, mnthPayout;
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	/*{
	    int totOrders = Customer.getVariable();  // Accessing in Admin class
	}*/

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void AdminScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		conn=javaconnect.ConnecrDB();
		
		JPanel panelRevenue = new JPanel();
		panelRevenue.setBorder(new TitledBorder(null, "Revenue", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRevenue.setBounds(44, 48, 403, 102);
		frame.getContentPane().add(panelRevenue);
		panelRevenue.setLayout(null);
		
		JLabel lblTotalOrders = new JLabel("Total Orders:");
		lblTotalOrders.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalOrders.setBounds(53, 19, 100, 14);
		panelRevenue.add(lblTotalOrders);
		
		JLabel lblTotalSales = new JLabel("Total Sales (RM):");
		lblTotalSales.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalSales.setBounds(53, 44, 100, 14);
		panelRevenue.add(lblTotalSales);
		
		txt_totOrders = new JTextField();
		txt_totOrders.setBounds(199, 11, 166, 20);
		panelRevenue.add(txt_totOrders);
		txt_totOrders.setBackground(Color.LIGHT_GRAY);
		txt_totOrders.setEditable(false);
		txt_totOrders.setColumns(10);
		
		txt_totSales = new JTextField();
		txt_totSales.setBounds(199, 41, 166, 20);
		panelRevenue.add(txt_totSales);
		txt_totSales.setBackground(new Color(192, 192, 192));
		txt_totSales.setEditable(false);
		txt_totSales.setColumns(10);
		
		JButton btnCalculateSales = new JButton("Calculate Sales");
		btnCalculateSales.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				int sumIntArabica, sumIntRobusta, sumIntAmtTotal,sumA,sumR,sumAT;
				sumA=0;
				sumR=0;
				sumAT=0;
				//String sumArabica, sumRobusta, sumAmtTotal;
				//totSales = totOrders*5;
				
				try {
					String sqlArabica = ("SELECT sum(QtyArabica) FROM Customer");
					//JOptionPane.showMessageDialog(null, sqlArabica);
					
					String sqlRobusta = ("SELECT sum(QtyRobusta) FROM Customer");
					//JOptionPane.showMessageDialog(null, sqlRobusta);
					
					String sqlAmtTotal = ("SELECT sum(AmtTotal) FROM Customer");
					//JOptionPane.showMessageDialog(null, sqlAmtTotal);
					
					pst=conn.prepareStatement(sqlArabica);
					rs=pst.executeQuery();
					if(rs.next()){
                        String sumArabica = rs.getString("sum(QtyArabica)");
                        sumA=Integer.parseInt((String) sumArabica);
                        //JOptionPane.showMessageDialog(null, sumA);
					}
					
					pst=conn.prepareStatement(sqlRobusta);
					rs=pst.executeQuery();
					if(rs.next()){
                        String sumRobusta = rs.getString("sum(QtyRobusta)");
                        sumR=Integer.parseInt((String) sumRobusta);
                        //JOptionPane.showMessageDialog(null, sumR);
					}
					
					pst=conn.prepareStatement(sqlAmtTotal);
					rs=pst.executeQuery();
					if(rs.next()){
                        String sumAmtTotal = rs.getString("sum(AmtTotal)");
                        sumAT=Integer.parseInt((String) sumAmtTotal);
                        //JOptionPane.showMessageDialog(null, sumAT);
					}
					
					pst.execute();
					
					//sumIntArabica=Integer.valueOf(sumArabica);
					//sumIntRobusta=Integer.valueOf(sumRobusta);
					//sumIntAmtTotal=Integer.valueOf(sumAmtTotal);
					
					totOrders=sumA + sumR;
					totSales=sumAT;
					//JOptionPane.showMessageDialog(null, "total sales = " + sumAT);
					
					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Total sales not correct!");
				}
				
				txt_totOrders.setText(Integer.toString(totOrders));
				txt_totSales.setText(Integer.toString(totSales));
				
			}
		});
		btnCalculateSales.setBounds(25, 69, 128, 23);
		panelRevenue.add(btnCalculateSales);
		
		JButton btnPrintSalesReport = new JButton("Print Sales Report");
		btnPrintSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null,totSales);
				JOptionPane.showMessageDialog(null, "Total number of orders: " +totOrders,"My Message", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Total amount of sales: RM" +totSales,"My Message", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnPrintSalesReport.setBounds(199, 69, 166, 23);
		panelRevenue.add(btnPrintSalesReport);
		
		JPanel panelExpense = new JPanel();
		panelExpense.setBorder(new TitledBorder(null, "Expense", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelExpense.setBounds(44, 163, 403, 115);
		frame.getContentPane().add(panelExpense);
		panelExpense.setLayout(null);
		
		JLabel lblTotalEmployee = new JLabel("Total Employee:");
		lblTotalEmployee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEmployee.setBounds(34, 26, 124, 14);
		panelExpense.add(lblTotalEmployee);
		
		txt_totEmp = new JTextField();
		txt_totEmp.setEditable(false);
		txt_totEmp.setBounds(195, 23, 169, 20);
		panelExpense.add(txt_totEmp);
		txt_totEmp.setColumns(10);
		
		JLabel lblTotalMonthlyPayout = new JLabel("Total Monthly Payout (RM):");
		lblTotalMonthlyPayout.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalMonthlyPayout.setBounds(3, 54, 155, 14);
		panelExpense.add(lblTotalMonthlyPayout);
		
		txt_mnthPayout = new JTextField();
		txt_mnthPayout.setBounds(195, 51, 169, 20);
		panelExpense.add(txt_mnthPayout);
		txt_mnthPayout.setBackground(Color.LIGHT_GRAY);
		txt_mnthPayout.setEditable(false);
		txt_mnthPayout.setColumns(10);
		
		JButton btnPrintSalaryStatement = new JButton("Print Salary Statement");
		btnPrintSalaryStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cntEmp, summnthPayout;
				cntEmp=0; 
				summnthPayout=0;
				try {
					//totEmp=Integer.parseInt((String) txt_totEmp.getText());
					//salEmp=500;
					//mnthPayout=totEmp*salEmp;
					
					//txt_salEmp.setText(Integer.toString(salEmp));
					//txt_mnthPayout.setText(Integer.toString(mnthPayout));
					//JOptionPane.showMessageDialog(null,mnthPayout);
					
					String sqlEmp = ("SELECT count(Name) FROM Employee_Info");
					pst=conn.prepareStatement(sqlEmp);
					rs=pst.executeQuery();
					if(rs.next()){
                        String Emp = rs.getString("count(Name)");
                        cntEmp=Integer.parseInt((String) Emp);
					}
										
					String sqlmnthPayout = ("SELECT sum(Salary) FROM Employee_Info");
					pst=conn.prepareStatement(sqlmnthPayout);
					rs=pst.executeQuery();
					if(rs.next()){
                        String Payout = rs.getString("sum(Salary)");
                        summnthPayout=Integer.parseInt((String) Payout);
					}

					pst.execute();
					
					totEmp=cntEmp;
					mnthPayout=summnthPayout;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					//JOptionPane.showMessageDialog(null,"Enter valid number of Employee");
					JOptionPane.showMessageDialog(null, "No employee registered in database!"+"\nPlease hire asap!","My Message", JOptionPane.WARNING_MESSAGE);
				}
				
				txt_totEmp.setText(Integer.toString(totEmp));
				txt_mnthPayout.setText(Integer.toString(mnthPayout));
				JOptionPane.showMessageDialog(null, "Total number of employee: " +cntEmp,"My Message", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Total amount of salary paid: RM" +summnthPayout,"My Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnPrintSalaryStatement.setBounds(68, 81, 224, 23);
		panelExpense.add(btnPrintSalaryStatement);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmin.setBounds(148, 11, 120, 25);
		frame.getContentPane().add(lblAdmin);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank You for using Leeds Coffee Kiosk");
				System.exit(0);
			}
		});
		btnLogout.setBounds(363, 295, 84, 23);
		frame.getContentPane().add(btnLogout);
	}
}
