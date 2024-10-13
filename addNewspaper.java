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

public class addNewspaper extends JFrame {

	private JPanel contentPane;
	private JTextField txtHead;
	private JTextField txtID;
	private JTextField txtDate;
	private JLabel lblNewLabel_2;
	private JTextField txtPublisher;
	private JLabel lblNewLabel_3;
	private JTextField txtLanguage;
	private JLabel lblNewLabel_1_3;
	private JComboBox txtFrequency;
	private JLabel lblType;
	private JComboBox txtType;
	private JTextField txtPrice;
	private JLabel lblPrice;
	private JPanel btnRegister;
	private JLabel lblNewLabel_4;
	private JPanel btnCancel;
	private JLabel lblCancel;


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
					addNewspaper frame = new addNewspaper();
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
	public addNewspaper() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Newspaper");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 192, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Headline:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(284, 69, 232, 30);
		contentPane.add(lblNewLabel_1);
		
		txtHead = new JTextField();
		txtHead.setBounds(284, 98, 232, 30);
		contentPane.add(txtHead);
		txtHead.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(32, 69, 117, 30);
		contentPane.add(lblNewLabel_1_1);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(32, 98, 219, 30);
		contentPane.add(txtID);
		
		JLabel lblNewLabel_1_2 = new JLabel("Publication Date: (yyyy-mm-dd)");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(32, 150, 219, 30);
		contentPane.add(lblNewLabel_1_2);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(32, 179, 219, 30);
		contentPane.add(txtDate);
		
		lblNewLabel_2 = new JLabel("Publisher:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(284, 150, 232, 30);
		contentPane.add(lblNewLabel_2);
		
		txtPublisher = new JTextField();
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(284, 179, 232, 30);
		contentPane.add(txtPublisher);
		
		lblNewLabel_3 = new JLabel("Frequency:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(284, 230, 232, 30);
		contentPane.add(lblNewLabel_3);
		
		txtLanguage = new JTextField();
		txtLanguage.setColumns(10);
		txtLanguage.setBounds(32, 259, 219, 30);
		contentPane.add(txtLanguage);
		
		lblNewLabel_1_3 = new JLabel("Language:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(32, 230, 117, 30);
		contentPane.add(lblNewLabel_1_3);
		
		txtFrequency = new JComboBox();
		txtFrequency.setModel(new DefaultComboBoxModel(new String[] {"Monthly", "Weekly", "Daily"}));
		txtFrequency.setBounds(284, 259, 232, 32);
		contentPane.add(txtFrequency);
		
		lblType = new JLabel("Acquisition Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblType.setBounds(32, 313, 219, 30);
		contentPane.add(lblType);
		

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setText("0");
		txtPrice.setBounds(284, 344, 232, 30);
		contentPane.add(txtPrice);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(284, 315, 232, 30);
		contentPane.add(lblPrice);
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
		

		txtType.setBounds(32, 342, 219, 32);
		contentPane.add(txtType);
		
		
		btnRegister = new JPanel();
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID,Headline,Date,Publisher,Language,Frequency,Acquire,Price,Type;
				ID =txtID.getText();
				Headline = txtHead.getText();
				Date = txtDate.getText();
				Publisher = txtPublisher.getText();
				Language = txtLanguage.getText();
				Frequency = (String) txtFrequency.getSelectedItem();
				Acquire = (String) txtType.getSelectedItem();
				Price = txtPrice.getText();
				Type = "Newspaper";
				
				try {
					pst = con.prepareStatement("INSERT INTO tbl_newspaper(nID,nHeadline,nDate,nPublisher,nLanguage,nFrequency,nAcquire,nPrice,nType) VALUES (?,?,?,?,?,?,?,?,?)");
					pst.setString(1,ID);
					pst.setString(2,Headline);
					pst.setString(3,Date);
					pst.setString(4,Publisher);
					pst.setString(5,Language);
					pst.setString(6,Frequency);
					pst.setString(7,Acquire);
					pst.setString(8,Price);
					pst.setString(9,Type);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Newspaper Added!");
					newspaper.table_load();
					addNewspaper.this.dispose();
					}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBackground(new Color(0, 200, 119));
		btnRegister.setBounds(428, 409, 88, 32);
		contentPane.add(btnRegister);
		btnRegister.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Register");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 88, 32);
		btnRegister.add(lblNewLabel_4);
		
		btnCancel = new JPanel();
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addNewspaper.this.dispose();
			}
		});
		btnCancel.setLayout(null);
		btnCancel.setBackground(new Color(100, 100, 100));
		btnCancel.setBounds(32, 409, 88, 32);
		contentPane.add(btnCancel);
		
		lblCancel = new JLabel("Cancel");
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCancel.setBounds(0, 0, 88, 32);
		btnCancel.add(lblCancel);
		
		
	}

}
