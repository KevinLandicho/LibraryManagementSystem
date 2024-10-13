import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class panelReturned extends JPanel {

	private static JTable tableReturn;
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;
	

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library", "root","");
			
			
		}
		catch(ClassNotFoundException ex){ 
			System.out.println(ex);
		}
		catch(SQLException ex){
			System.out.println(ex);
		}
	}
	
	public static void table_load()
	{
		try {
			String query= "SELECT\r\n"
					+ "  tbl_return.transaction_id,\r\n"
					+ "  tbl_return.book_id,\r\n"
					+ "  tbl_catalog.title,\r\n"
					+ "  tbl_student.LRN,\r\n"
					+ "  tbl_student.student_lname,\r\n"
					+ "  tbl_student.student_fname,\r\n"
					+ "  tbl_student.section,\r\n"
					+ "  tbl_return.time_return,\r\n"
					+ "  tbl_return.date_return\r\n"
					+ "FROM tbl_return\r\n"
					+ "INNER JOIN tbl_catalog\r\n"
					+ "ON tbl_return.book_id = tbl_catalog.book_id\r\n"
					+ "INNER JOIN tbl_student\r\n"
					+ "ON tbl_return.LRN = tbl_student.LRN;";
			pst =con.prepareStatement(query);
			rs = pst.executeQuery(query);
			tableReturn.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	/**
	 * Create the panel.
	 */
	public panelReturned() {
		Connect();
		setBounds(0, 0, 1308, 863);
		setLayout(null);
		setVisible (true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 67, 1227, 717);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		tableReturn = new JTable();
		tableReturn.setBounds(0, 0, 1227, 717);
		panel.add(tableReturn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100,100,100));
		panel_1.setBounds(36, 33, 1227, 35);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transaction ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 0, 112, 35);
		panel_1.add(lblNewLabel);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setForeground(Color.WHITE);
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookId.setBounds(148, 0, 58, 35);
		panel_1.add(lblBookId);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitle.setBounds(279, 0, 38, 35);
		panel_1.add(lblTitle);
		
		JLabel lblLrn = new JLabel("LRN");
		lblLrn.setForeground(Color.WHITE);
		lblLrn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLrn.setBounds(412, 0, 38, 35);
		panel_1.add(lblLrn);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setForeground(Color.WHITE);
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastname.setBounds(552, 0, 70, 35);
		panel_1.add(lblLastname);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(687, 0, 112, 35);
		panel_1.add(lblFirstName);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setForeground(Color.WHITE);
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSection.setBounds(825, 0, 112, 35);
		panel_1.add(lblSection);
		
		JLabel lblDateAndTime = new JLabel("Date");
		lblDateAndTime.setForeground(Color.WHITE);
		lblDateAndTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateAndTime.setBounds(1090, 0, 79, 35);
		panel_1.add(lblDateAndTime);
		
		JLabel iconRefresh = new JLabel("");
		iconRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_load();
			}
		});
		iconRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgRefresh = new ImageIcon(this.getClass().getResource("/iconRefresh.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconRefresh.setIcon(new ImageIcon(imgRefresh));
		iconRefresh.setBounds(1184, 0, 45, 35);
		panel_1.add(iconRefresh);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(957, 0, 112, 35);
		panel_1.add(lblTime);
		
		JPanel btnScan = new JPanel();
		btnScan.setBackground(new Color(100,100,100));
		btnScan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Return.main(null);
			}
		});
		btnScan.setBounds(1133, 793, 131, 35);
		add(btnScan);
		btnScan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Return Book");
		lblNewLabel_1.setBounds(39, 0, 82, 35);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnScan.add(lblNewLabel_1);
		
		JLabel iconCam = new JLabel("");
		Image imgCam = new ImageIcon(this.getClass().getResource("/imgqr.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconCam.setIcon(new ImageIcon(imgCam));
		iconCam.setHorizontalAlignment(SwingConstants.CENTER);
		iconCam.setBounds(0, 0, 45, 35);
		btnScan.add(iconCam);
		
		table_load();
	}
}
