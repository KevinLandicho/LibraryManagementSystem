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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class manageFurniture extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtItem;
	private JLabel lblAcquisitionType;
	private JComboBox txtType;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JTextField txtDetails;
	private JPanel btnRegister;
	private JLabel lblNewLabel_1;
	private JPanel btnCancel;
	private JLabel lblNewLabel_2;

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
					addFurniture frame = new addFurniture();
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
	public manageFurniture() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Furniture");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 205, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblItemId = new JLabel("Item ID:");
		lblItemId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItemId.setBounds(53, 82, 205, 53);
		contentPane.add(lblItemId);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItem.setBounds(322, 82, 205, 53);
		contentPane.add(lblItem);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String Id = txtID.getText();
					
					pst =con.prepareStatement("select fID,fName,fDetails,fPrice from tbl_furniture where fID=?");
					pst.setString(1, Id);
					ResultSet rs = pst.executeQuery();
					
				if (rs.next()==true)
				{
					
					String name = rs.getString(2);
					String details = rs.getString(3);
					String Price = rs.getString(4);
										
					
					txtItem.setText(name);
					txtDetails.setText(details);
					txtPrice.setText(Price);
					
				}
				else {
					
					txtItem.setText("");
					txtDetails.setText("");
					txtPrice.setText("");
					
				}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		txtID.setBounds(53, 125, 205, 30);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtItem = new JTextField();
		txtItem.setColumns(10);
		txtItem.setBounds(322, 125, 205, 30);
		contentPane.add(txtItem);
		
		JLabel lblColor = new JLabel("Item Details:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColor.setBounds(53, 184, 205, 53);
		contentPane.add(lblColor);
		
		lblAcquisitionType = new JLabel("Acquisition Type:");
		lblAcquisitionType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAcquisitionType.setBounds(53, 282, 205, 53);
		contentPane.add(lblAcquisitionType);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(322, 282, 205, 53);
		contentPane.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setText("0");
		txtPrice.setBounds(322, 325, 205, 30);
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

		txtType.setBounds(53, 324, 205, 30);
		contentPane.add(txtType);
		
		
		
		txtDetails = new JTextField();
		txtDetails.setColumns(10);
		txtDetails.setBounds(53, 226, 474, 30);
		contentPane.add(txtDetails);
		
		btnRegister = new JPanel();
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID,Name,Details,Acquire,Price,Type;
				ID =txtID.getText();
				Name = txtItem.getText();
				Details = txtDetails.getText();
				Acquire = (String) txtType.getSelectedItem();
				Price = txtPrice.getText();
				Type = "Furniture";
				
				try {
					pst = con.prepareStatement("update tbl_furniture set fName,fDetails,fAcquire,fPrice,fType where fID=?");
					pst.setString(1,ID);
					pst.setString(2,Name);
					pst.setString(3,Details);
					pst.setString(4,Acquire);
					pst.setString(5,Price);
					pst.setString(6,Type);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Furniture Updated!");
					Furniture.table_load();
					manageFurniture.this.dispose();
					}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnRegister.setBackground(new Color(0,200,119));
		btnRegister.setBounds(429, 408, 98, 30);
		contentPane.add(btnRegister);
		btnRegister.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Update");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 98, 30);
		btnRegister.add(lblNewLabel_1);
		
		btnCancel = new JPanel();
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageFurniture.this.dispose();
			}
		});
		btnCancel.setLayout(null);
		btnCancel.setBackground(new Color(100,100,100));
		btnCancel.setBounds(53, 408, 98, 30);
		contentPane.add(btnCancel);
		
		lblNewLabel_2 = new JLabel("Cancel");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 0, 98, 30);
		btnCancel.add(lblNewLabel_2);
		
		JPanel btnDelete = new JPanel();
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
String Id;
				
				Id = txtID.getText();
				
				
				try {
					pst = con.prepareStatement("Delete from tbl_furniture where fID=?");
					pst.setString(1,Id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Deleted!");
					manageFurniture.this.dispose();
					Furniture.table_load();
				
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
