import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class manageMagazine extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtTitle;
	private JTextField txtPublisher;
	private JTextField txtLanguage;
	private JTextField txtCategory;
	private JTextField txtPrice;



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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMagazine frame = new addMagazine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public manageMagazine() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Magazine");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 245, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(39, 68, 160, 33);
		contentPane.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String Id = txtID.getText();
					
					pst =con.prepareStatement("select mID,mTitle,mPublisher,mLanguage,mCategory,mPrice from tbl_magazine Where mID = ?");
					pst.setString(1, Id);
					ResultSet rs = pst.executeQuery();
					
				if (rs.next()==true)
				{
					
					String Title = rs.getString(2);
					String Publisher = rs.getString(3);
					String Language = rs.getString(4);
					String Category = rs.getString(5);
					String Price = rs.getString(6);
										
					
					txtTitle.setText(Title);
					txtPublisher.setText(Publisher);
					txtLanguage.setText(Language);
					txtCategory.setText(Category);
					txtPrice.setText(Price);
					
				}
				else {
					
					txtTitle.setText("");
					txtPublisher.setText("");
					txtLanguage.setText("");
					txtCategory.setText("");
					txtPrice.setText("");
					
				}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		txtID.setBounds(39, 100, 182, 33);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(309, 100, 182, 33);
		contentPane.add(txtTitle);
		
		JLabel lblNewLabel_1_1 = new JLabel("Title:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(309, 68, 160, 33);
		contentPane.add(lblNewLabel_1_1);
		
		txtPublisher = new JTextField();
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(39, 176, 182, 33);
		contentPane.add(txtPublisher);
		
		JLabel lblNewLabel_1_2 = new JLabel("Publisher:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(39, 144, 160, 33);
		contentPane.add(lblNewLabel_1_2);
		
		txtLanguage = new JTextField();
		txtLanguage.setColumns(10);
		txtLanguage.setBounds(309, 175, 182, 33);
		contentPane.add(txtLanguage);
		
		JLabel lblNewLabel_1_3 = new JLabel("Language:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(309, 143, 160, 33);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Frequency:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(39, 226, 160, 33);
		contentPane.add(lblNewLabel_1_4);
		
		txtCategory = new JTextField();
		txtCategory.setColumns(10);
		txtCategory.setBounds(309, 258, 182, 33);
		contentPane.add(txtCategory);
		
		JLabel lblNewLabel_1_5 = new JLabel("Category:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(309, 226, 160, 33);
		contentPane.add(lblNewLabel_1_5);
		
		JComboBox txtFrequency = new JComboBox();
		txtFrequency.setModel(new DefaultComboBoxModel(new String[] {"Monthly", "Weekly", "Daily"}));
		txtFrequency.setBounds(39, 258, 182, 33);
		contentPane.add(txtFrequency);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Acquisition type:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(39, 311, 160, 33);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(309, 311, 160, 33);
		contentPane.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setText("0");
		txtPrice.setBounds(309, 343, 182, 33);
		contentPane.add(txtPrice);
		txtPrice.setVisible(false);
		lblPrice.setVisible(false);
		
		JComboBox txtType = new JComboBox(new String[] {"Donation", "Purchased"});	
		txtType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				int type = txtType.getSelectedIndex();
				
				if (type==0) { 
					txtPrice.setText("0");
					txtPrice.setVisible(false);
					lblPrice.setVisible(false);
					
				}else {
					txtPrice.setVisible(true);
					lblPrice.setVisible(true);
				}
			}
		});

		txtType.setBounds(39, 343, 182, 33);
		contentPane.add(txtType);
		
		
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID,Title,Publisher,Language,Frequency,Category,Acquire,Price,Type;
				ID =txtID.getText();
				Title = txtTitle.getText();
				Publisher = txtPublisher.getText();
				Language = txtLanguage.getText();
				Frequency =(String) txtFrequency.getSelectedItem();
				Category = txtCategory.getText();
				Acquire = (String) txtType.getSelectedItem();
				Price = txtPrice.getText();
				
				
				try {
					pst = con.prepareStatement("updare tbl_magazine set mTitle=?,mPublisher=?,mLanguage=?,mFrequency,mCategory,mAcquire=?,mPrice=? where mID=?");
					
					pst.setString(1,Title);
					pst.setString(2,Publisher);
					pst.setString(3,Language);
					pst.setString(4,Frequency);
					pst.setString(5,Category);
					pst.setString(6,Acquire);
					pst.setString(7,Price);
					pst.setString(8,ID);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Magazine Updated!");
					magazine.table_load();
					manageMagazine.this.dispose();
					}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		panel.setBackground(new Color(0,200,119));
		panel.setBounds(394, 407, 97, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Update");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 97, 33);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageMagazine.this.dispose();
			}
		});
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(100,100,100));
		panel_1.setBounds(39, 407, 97, 33);
		contentPane.add(panel_1);
		
		JLabel Cancel = new JLabel("Cancel");
		Cancel.setForeground(new Color(255, 255, 255));
		Cancel.setHorizontalAlignment(SwingConstants.CENTER);
		Cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Cancel.setBounds(0, 0, 97, 33);
		panel_1.add(Cancel);
		JPanel btnDelete = new JPanel();
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
String Id;
				
				Id = txtID.getText();
				
				
				try {
					pst = con.prepareStatement("Delete from tbl_magazine where mID=?");
					pst.setString(1,Id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Magazine Deleted!");
					manageMagazine.this.dispose();
					magazine.table_load();
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setLayout(null);
		btnDelete.setBackground(new Color(0, 200, 119));
		btnDelete.setBounds(284, 409, 88, 32);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_4_1 = new JLabel("Delete");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(0, 0, 88, 32);
		btnDelete.add(lblNewLabel_4_1);
		
	}
}
