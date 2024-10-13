import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class panelArchive extends JPanel {
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
			String query= "select * from tbl_archived";
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
	public panelArchive() {
		
		Connect();
		
		setBounds(0, 0, 1308, 863);
		setLayout(null);
		setVisible (true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 67,1227, 717);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 1227, 717);
		panel.add(table);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100,100,100));
		panel_1.setBounds(33, 32, 1229, 35);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBookID_1 = new JLabel("Book ID");
		lblBookID_1.setForeground(new Color(255, 255, 255));
		lblBookID_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1.setBounds(10, 10, 70, 22);
		panel_1.add(lblBookID_1);
		
		JLabel lblBookID_1_1 = new JLabel("Title");
		lblBookID_1_1.setForeground(Color.WHITE);
		lblBookID_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_1.setBounds(102, 10, 70, 22);
		panel_1.add(lblBookID_1_1);
		
		JLabel lblBookID_1_2 = new JLabel("ISBN");
		lblBookID_1_2.setForeground(Color.WHITE);
		lblBookID_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_2.setBounds(207, 10, 70, 22);
		panel_1.add(lblBookID_1_2);
		
		JLabel lblBookID_1_3 = new JLabel("Author");
		lblBookID_1_3.setForeground(Color.WHITE);
		lblBookID_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_3.setBounds(314, 10, 70, 22);
		panel_1.add(lblBookID_1_3);
		
		JLabel lblBookID_1_4 = new JLabel("Version");
		lblBookID_1_4.setForeground(Color.WHITE);
		lblBookID_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_4.setBounds(430, 10, 70, 22);
		panel_1.add(lblBookID_1_4);
		
		JLabel lblBookID_1_5 = new JLabel("Publisher");
		lblBookID_1_5.setForeground(Color.WHITE);
		lblBookID_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_5.setBounds(519, 10, 70, 22);
		panel_1.add(lblBookID_1_5);
		
		JLabel lblBookID_1_6 = new JLabel("Place");
		lblBookID_1_6.setForeground(Color.WHITE);
		lblBookID_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6.setBounds(608, 10, 70, 22);
		panel_1.add(lblBookID_1_6);
		
		JLabel lblBookID_1_6_1 = new JLabel("Year");
		lblBookID_1_6_1.setForeground(Color.WHITE);
		lblBookID_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6_1.setBounds(713, 10, 70, 22);
		panel_1.add(lblBookID_1_6_1);
		
		JLabel lblBookID_1_6_1_1 = new JLabel("Pages");
		lblBookID_1_6_1_1.setForeground(Color.WHITE);
		lblBookID_1_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6_1_1.setBounds(813, 10, 48, 22);
		panel_1.add(lblBookID_1_6_1_1);
		
		JLabel lblBookID_1_6_1_2 = new JLabel("Categories");
		lblBookID_1_6_1_2.setForeground(Color.WHITE);
		lblBookID_1_6_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6_1_2.setBounds(929, 10, 114, 22);
		panel_1.add(lblBookID_1_6_1_2);
		
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
		
		JLabel lblBookID_1_6_1_2_1 = new JLabel("Reason");
		lblBookID_1_6_1_2_1.setForeground(Color.WHITE);
		lblBookID_1_6_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6_1_2_1.setBounds(1126, 10, 70, 22);
		panel_1.add(lblBookID_1_6_1_2_1);
		
		JPanel btnPrint = new JPanel();
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library", "root","");
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Admin\\eclipse-workspace\\LibraryManagementSystem\\src\\Archive.jrxml");
					String query = "select * from tbl_archived";
					
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
		btnPrint.setBounds(33, 800, 110, 35);
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
		Image imgSearch = new ImageIcon(this.getClass().getResource("/imgsearch.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		
		table_load();
	}
}
