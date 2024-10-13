import javax.print.DocFlavor.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.awt.SystemColor;

public class panelAcquisition extends JPanel {

	/**
	 * Create the panel.
	 */
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
	
	public static void table_books()
	{
		try {
			String query= "select * from tbl_books";
			pst =con.prepareStatement(query);
			rs = pst.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void table_furniture()
	{
		try {
			String query= "select * from tbl_furniture";
			pst =con.prepareStatement(query);
			rs = pst.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void table_article()
	{
		try {
			String query= "select * from tbl_article";
			pst =con.prepareStatement(query);
			rs = pst.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void table_newspaper()
	{
		try {
			String query= "select * from tbl_newspaper";
			pst =con.prepareStatement(query);
			rs = pst.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void table_magazine()
	{
		try {
			String query= "select * from tbl_magazine";
			pst =con.prepareStatement(query);
			rs = pst.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	

	public static void bookList() {
		
	}
	
	
		
	
	public panelAcquisition() {
		Connect();
		setBounds(0, 0, 1308, 863);
		setLayout(null);
		setVisible (true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 65, 1227, 717);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 1227, 717);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100,100,100));
		panel_1.setBounds(35, 32, 1227, 35);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 0, 80, 35);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Title");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(93, 0, 33, 35);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ISBN");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(188, 0, 45, 35);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Author");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(286, 0, 45, 35);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Version");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(383, 0, 61, 35);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Publisher");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(470, 0, 61, 35);
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Place");
		lblNewLabel_1_4_2.setForeground(Color.WHITE);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_2.setBounds(565, 0, 51, 35);
		panel_1.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Year");
		lblNewLabel_1_4_3.setForeground(Color.WHITE);
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_3.setBounds(663, 0, 45, 35);
		panel_1.add(lblNewLabel_1_4_3);
		
		JLabel lblNewLabel_1_4_4 = new JLabel("Pages");
		lblNewLabel_1_4_4.setForeground(Color.WHITE);
		lblNewLabel_1_4_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_4.setBounds(756, 0, 51, 35);
		panel_1.add(lblNewLabel_1_4_4);
		
		JLabel lblNewLabel_1_4_5 = new JLabel("Categories");
		lblNewLabel_1_4_5.setForeground(Color.WHITE);
		lblNewLabel_1_4_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_5.setBounds(849, 0, 80, 35);
		panel_1.add(lblNewLabel_1_4_5);
		
		JLabel lblNewLabel_1_4_6 = new JLabel("Type");
		lblNewLabel_1_4_6.setForeground(Color.WHITE);
		lblNewLabel_1_4_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_6.setBounds(1036, 0, 72, 35);
		panel_1.add(lblNewLabel_1_4_6);
		
		JLabel lblNewLabel_1_4_7 = new JLabel("Price");
		lblNewLabel_1_4_7.setForeground(Color.WHITE);
		lblNewLabel_1_4_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_7.setBounds(1139, 0, 80, 35);
		panel_1.add(lblNewLabel_1_4_7);
		
		JLabel iconRefresh = new JLabel("");
		iconRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_books();
			}
		});
		iconRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgRefresh = new ImageIcon(this.getClass().getResource("/iconRefresh.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconRefresh.setIcon(new ImageIcon(imgRefresh));
		panel_1.add(iconRefresh);
		iconRefresh.setBounds(1184, 0, 45, 35);
		
		
		JPanel btnRegister = new JPanel();
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				items item = new items();
				item.show();
			}
		});
		btnRegister.setBackground(new Color(100,100,100));
		btnRegister.setBounds(1154, 800, 110, 35);
		add(btnRegister);
		btnRegister.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(40, 0, 70, 35);
		btnRegister.add(lblNewLabel);
		
		JLabel iconAdd = new JLabel("");
		iconAdd.setBounds(0, 0, 45, 35);
		btnRegister.add(iconAdd);
		iconAdd.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgAdd = new ImageIcon(this.getClass().getResource("/imgadd.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		iconAdd.setIcon(new ImageIcon(imgAdd));
		
		JPanel btnPrint = new JPanel();
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library", "root","");
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Admin\\eclipse-workspace\\LibraryManagementSystem\\src\\Acquisition.jrxml");
					String query = "select * from tbl_acquisition";
					
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
		btnPrint.setBounds(35, 800, 110, 35);
		add(btnPrint);
		
		JLabel lblNewLabel_2 = new JLabel("Print");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(40, 0, 70, 35);
		btnPrint.add(lblNewLabel_2);
		
		JLabel iconPrint = new JLabel("");
		iconPrint.setHorizontalAlignment(SwingConstants.CENTER);
		iconPrint.setBounds(0, 0, 45, 35);
		Image imgPrint = new ImageIcon(this.getClass().getResource("/imgarchived.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		iconPrint.setIcon(new ImageIcon(imgPrint));
		btnPrint.add(iconPrint);
		
		
		table_books();
	}
}
