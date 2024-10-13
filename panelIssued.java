import javax.swing.JPanel;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class panelIssued extends JPanel {
	private static JTable table;
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;
	 private static Timer timer;
	

	public static void Connect() {
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
					+ "  tbl_issued.transaction_id,\r\n"
					+ "  tbl_issued.book_id,\r\n"
					+ "  tbl_catalog.title,\r\n"
					+ "  tbl_student.LRN,\r\n"
					+ "  tbl_student.student_lname,\r\n"
					+ "  tbl_student.student_fname,\r\n"
					+ "  tbl_student.section,\r\n"
					+ "  tbl_issued.time_issued,\r\n"
					+ "  tbl_issued.date_issued,\r\n"
					+ "  tbl_issued.Status\r\n"
					+ "FROM tbl_issued\r\n"
					+ "INNER JOIN tbl_catalog\r\n"
					+ "ON tbl_issued.book_id = tbl_catalog.book_id\r\n"
					+ "INNER JOIN tbl_student\r\n"
					+ "ON tbl_issued.LRN = tbl_student.LRN where status='Active' OR status='overdue';";
			pst =con.prepareStatement(query);
			rs = pst.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
	        rs.close();
		}
		catch (Exception e)
		{
			 System.out.println("pop Lost connection to the database. Trying to reconnect...");
	         Connect();
		}
	}
	
	public static void updateOverdue() {
	    try {
	        String query = "UPDATE tbl_issued SET Status = 'overdue' WHERE date_issued <= NOW() - INTERVAL 1 DAY;";
	        pst = con.prepareStatement(query);
	        pst.executeUpdate(); // Execute the PreparedStatement

	        // Close database resources
	        pst.close();
	        rs.close();
	        //con.close(); // Close the connection
	    } catch (SQLException e) {
	        System.out.println("1Lost connection to the database. Trying to reconnect...");
	        Connect();
	    }
	}
	
	

	public static void updateFines() {
	    try {
	        String query = "SELECT transaction_id, date_issued FROM tbl_issued WHERE status='overdue'";
	        pst = con.prepareStatement(query);
	        rs = pst.executeQuery(query);

	        while (rs.next()) {
	            int transactionId = rs.getInt("transaction_id");
	            Date dateIssued = rs.getDate("date_issued");

	            // Calculate the number of days overdue
	            long daysOverdue = (System.currentTimeMillis() - dateIssued.getTime()) / (1000 * 60 * 60 * 24);

	            // Calculate the fine amount
	            int fineAmount = (int) (5 * daysOverdue);

	            // Prepare the update statement
	            String updateQuery = "UPDATE tbl_issued SET fines = ? WHERE transaction_id = ?";
	            PreparedStatement updateStatement = con.prepareStatement(updateQuery);

	            // Set the update parameters
	            updateStatement.setInt(1, fineAmount);
	            updateStatement.setInt(2, transactionId);

	            // Execute the update statement to modify the `fines` column
	            updateStatement.executeUpdate();
	        }

	        // Close database resources after the loop
	        rs.close();
	        pst.close();
	        //con.close();
	    } catch (SQLException e) {
	        System.out.println("Lost connection to the database. Trying to reconnect...");
	        Connect();
	    }
	}

		
			
			public static void stopTimer() {
			    timer.stop();
			 
			}
			
			public static void startTimer() {
				timer.start();
			
				
			}

	
	/**
	 * Create the panel.
	 */
	public panelIssued() {
		Connect();
		setBounds(0, 0, 1308, 863);
		setLayout(null);
		
		 timer = new Timer(1000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	updateOverdue();
	            	updateFines();
	            	panelOverdue.table_load();	
	            	table_load();
	            }
	        });
	        timer.start();


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 65, 1227, 717);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 1227, 717);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100,100,100));
		panel_1.setBounds(36, 32, 1227, 35);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transaction ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 0, 112, 35);
		panel_1.add(lblNewLabel);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setForeground(Color.WHITE);
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookId.setBounds(132, 0, 58, 35);
		panel_1.add(lblBookId);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitle.setBounds(254, 0, 38, 35);
		panel_1.add(lblTitle);
		
		JLabel lblLrn = new JLabel("LRN");
		lblLrn.setForeground(Color.WHITE);
		lblLrn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLrn.setBounds(366, 0, 38, 35);
		panel_1.add(lblLrn);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setForeground(Color.WHITE);
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastname.setBounds(503, 0, 70, 35);
		panel_1.add(lblLastname);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(612, 0, 112, 35);
		panel_1.add(lblFirstName);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setForeground(Color.WHITE);
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSection.setBounds(741, 0, 112, 35);
		panel_1.add(lblSection);
		
		JLabel lblDateAndTime = new JLabel("Date");
		lblDateAndTime.setForeground(Color.WHITE);
		lblDateAndTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateAndTime.setBounds(983, 0, 31, 35);
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
		lblTime.setBounds(872, 0, 38, 35);
		panel_1.add(lblTime);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(1105, 0, 51, 35);
		panel_1.add(lblStatus);
		
		JPanel btnScan = new JPanel();
		btnScan.setBackground(new Color(100,100,100));
		btnScan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Lend.main(null);
			}
		});
		btnScan.setBounds(1132, 792, 133, 35);
		add(btnScan);
		btnScan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Issue Book");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(35, 0, 90, 35);
		btnScan.add(lblNewLabel_1);
		
		JLabel iconCam = new JLabel("");
		iconCam.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgCam = new ImageIcon(this.getClass().getResource("/imgqr.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconCam.setIcon(new ImageIcon(imgCam));
		iconCam.setBounds(0, 0, 45, 35);
		btnScan.add(iconCam);
		
		JPanel btnPrint = new JPanel();
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library", "root","");
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Admin\\eclipse-workspace\\LibraryManagementSystem\\src\\issued.jrxml");
					String query = "SELECT   tbl_issued.transaction_id,tbl_issued.book_id,tbl_catalog.title,tbl_student.LRN,tbl_student.student_lname,tbl_student.student_fname,tbl_student.section,tbl_issued.time_issued,tbl_issued.date_issued,tbl_issued.Status\r\n"
							+ "FROM tbl_issued\r\n"
							+ "INNER JOIN tbl_catalog\r\n"
							+ "ON tbl_issued.book_id = tbl_catalog.book_id\r\n"
							+ "INNER JOIN tbl_student\r\n"
							+ "ON tbl_issued.LRN = tbl_student.LRN where status='Active' OR status='overdue'";
					
					JRDesignQuery updateQuery = new JRDesignQuery();
					updateQuery.setText(query);
					
					jdesign.setQuery(updateQuery);
					
					JasperReport jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint jprint = JasperFillManager.fillReport(jreport, null,con);
					
					JasperViewer.viewReport(jprint);
					
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setLayout(null);
		btnPrint.setBackground(SystemColor.windowBorder);
		btnPrint.setBounds(36, 792, 110, 35);
		add(btnPrint);
		
		JLabel lblNewLabel_2 = new JLabel("Print");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(40, 0, 70, 35);
		btnPrint.add(lblNewLabel_2);
		
		JLabel iconPrint = new JLabel("");
		iconPrint.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgPrint = new ImageIcon(this.getClass().getResource("/imgarchived.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		iconPrint.setIcon(new ImageIcon(imgPrint));
		iconPrint.setBounds(0, 0, 45, 35);
		btnPrint.add(iconPrint);
		
		table_load();
	}
}
