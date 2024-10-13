import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

public class panelOverdue extends JPanel {
	private static JTable table;
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
			String query= "SELECT tbl_issued.transaction_id, tbl_issued.book_id, tbl_catalog.title, tbl_issued.LRN, tbl_student.student_lname, tbl_student.student_fname, tbl_student.section, tbl_issued.date_issued, tbl_issued.fines FROM tbl_issued INNER JOIN tbl_catalog ON tbl_issued.book_id = tbl_catalog.book_id INNER JOIN tbl_student ON tbl_issued.LRN = tbl_student.LRN where status='overdue';";
			pst =con.prepareStatement(query);
			rs = pst.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	/**
	 * Create the panel.
	 */
	public panelOverdue() {
		Connect();
		setBounds(0, 0, 1308, 863);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 67, 1227, 717);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBounds(0, 0, 1227, 717);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 1227, 717);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.windowBorder);
		panel_1.setBounds(35, 32, 1229, 35);
		add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Transaction ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 10, 98, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(696, 10, 80, 15);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Lastname");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(555, 10, 80, 15);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Section");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(820, 10, 80, 15);
		panel_1.add(lblNewLabel_1_4);
		
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
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Fines");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(1094, 10, 80, 15);
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Book ID");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(141, 10, 80, 15);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Title");
		lblNewLabel_1_5_1.setForeground(Color.WHITE);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5_1.setBounds(279, 10, 28, 15);
		panel_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("LRN");
		lblNewLabel_1_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5_1_1.setBounds(403, 10, 28, 15);
		panel_1.add(lblNewLabel_1_5_1_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Date Issued");
		lblNewLabel_1_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1.setBounds(956, 13, 80, 15);
		panel_1.add(lblNewLabel_1_4_1_1);
		setVisible (true);
		table_load();
	}
}
