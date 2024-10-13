import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.Timer;

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

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class panelInventory extends JPanel {
	private static JTable table;
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;
	private JLabel lblbID;
	private JLabel lbl;
	
	
	
	

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
			String query= "select * from tbl_books";
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
	/**
	 * Create the panel.
	 */
	public panelInventory() {
		Connect();
		setBounds(0, 0, 1308, 863);
		setLayout(null);
		setVisible (true);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 96, 1227, 717);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 1227, 717);
		panel.add(table);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.windowBorder);
		panel_1.setBounds(36, 66, 1227, 35);
		add(panel_1);
		
		JLabel lblNewLabel_1;
		lblbID = new JLabel("Book ID");
		lblbID.setForeground(new Color(255, 255, 255));
		lblbID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblbID.setBounds(10, 0, 80, 35);
		panel_1.add(lblbID);
		
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
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1042, 10, 154, 28);
		add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Book", "Article", "Magazine", "Newspaper", "Furniture"}));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1206, 10, 56, 28);
		add(panel_2);
		panel_2.setBackground(new Color(100, 100, 100));
		
		JLabel lblNewLabel_1_4_7_1 = new JLabel("Filter");
		lblNewLabel_1_4_7_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1_4_7_1);
		
		JLabel lbl;
		lbl = new JLabel("Books");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl.setBounds(35, 18, 107, 20);
		add(lbl);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboBox.getSelectedIndex()==0) {
					MainFrame Main = (MainFrame)
							SwingUtilities.getWindowAncestor(panelInventory.this);
							Main.menuClicked(Main.PanelInventory);
				}else if (comboBox.getSelectedIndex()==1) {
							MainFrame Main = (MainFrame)
							SwingUtilities.getWindowAncestor(panelInventory.this);
							Main.menuClicked(Main.Article);
				}else if (comboBox.getSelectedIndex()==2) {
					MainFrame Main = (MainFrame)
							SwingUtilities.getWindowAncestor(panelInventory.this);
							Main.menuClicked(Main.Magazine);
				}else if (comboBox.getSelectedIndex()==3) {
					MainFrame Main = (MainFrame)
							SwingUtilities.getWindowAncestor(panelInventory.this);
							Main.menuClicked(Main.Newspaper);
				}else if (comboBox.getSelectedIndex()==4) {
					MainFrame Main = (MainFrame)
							SwingUtilities.getWindowAncestor(panelInventory.this);
							Main.menuClicked(Main.furniture);
				}
						
				
			}
		});
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
		btnPrint.setBounds(35, 821, 110, 35);
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
		
		JPanel btnManage = new JPanel();
		btnManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageItems manage = new manageItems();
				manage.show();
			}
		});
		btnManage.setLayout(null);
		btnManage.setBackground(SystemColor.windowBorder);
		btnManage.setBounds(1152, 821, 110, 35);
		add(btnManage);
		
		JLabel lblNewLabel_2_1 = new JLabel("Manage");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(40, 0, 70, 35);
		btnManage.add(lblNewLabel_2_1);
		
		JLabel iconPrint_1 = new JLabel("");
		iconPrint_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgmanage = new ImageIcon(this.getClass().getResource("/imgManage.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		iconPrint_1.setIcon(new ImageIcon(imgmanage));
		iconPrint_1.setBounds(0, 0, 45, 35);
		btnManage.add(iconPrint_1);
		
	table_load();
		
	}
}
