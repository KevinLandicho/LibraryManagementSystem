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

public class manageArticle extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPublisher;
	private JTextField txtLanguage;
	private JTextField txtYear;
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
					addArticle frame = new addArticle();
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
	public manageArticle() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Article");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 144, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(72, 79, 115, 25);
		contentPane.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String Id = txtID.getText();
					
					pst =con.prepareStatement("select aID,aTitle,aAuthor,aPublisher,aLanguage,aYear,aPrice from tbl_article Where aID = ?");
					pst.setString(1, Id);
					ResultSet rs = pst.executeQuery();
					
				if (rs.next()==true)
				{
					
					String Title = rs.getString(2);
					String Author = rs.getString(3);
					String Publisher = rs.getString(4);
					String Language = rs.getString(5);
					String Year = rs.getString(6);
					String Price = rs.getString(7);
										
					
					txtTitle.setText(Title);
					txtAuthor.setText(Author);
					txtPublisher.setText(Publisher);
					txtLanguage.setText(Language);
					txtYear.setText(Year);
					txtPrice.setText(Price);
					
				}
				else {
					
					txtTitle.setText("");
					txtAuthor.setText("");
					txtPublisher.setText("");
					txtLanguage.setText("");
					txtYear.setText("");
					txtPrice.setText("");
					
				}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		txtID.setBounds(72, 103, 158, 34);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Title:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(301, 79, 115, 25);
		contentPane.add(lblNewLabel_1_1);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(301, 103, 158, 34);
		contentPane.add(txtTitle);
		
		JLabel lblNewLabel_1_2 = new JLabel("Author:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(72, 157, 115, 25);
		contentPane.add(lblNewLabel_1_2);
		
		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(72, 181, 158, 34);
		contentPane.add(txtAuthor);
		
		JLabel lblNewLabel_1_3 = new JLabel("Publisher:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(301, 157, 115, 25);
		contentPane.add(lblNewLabel_1_3);
		
		txtPublisher = new JTextField();
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(301, 181, 158, 34);
		contentPane.add(txtPublisher);
		
		JLabel lblNewLabel_1_4 = new JLabel("Language:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(72, 241, 115, 25);
		contentPane.add(lblNewLabel_1_4);
		
		txtLanguage = new JTextField();
		txtLanguage.setColumns(10);
		txtLanguage.setBounds(72, 265, 158, 34);
		contentPane.add(txtLanguage);
		
		JLabel lblNewLabel_1_5 = new JLabel("Published Year:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(301, 241, 115, 25);
		contentPane.add(lblNewLabel_1_5);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(301, 265, 158, 34);
		contentPane.add(txtYear);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(301, 327, 115, 25);
		contentPane.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setText("0");
		txtPrice.setColumns(10);
		txtPrice.setBounds(301, 351, 158, 34);
		contentPane.add(txtPrice);
		
		JLabel lblNewLabel_1_7 = new JLabel("Acquisition Type:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_7.setBounds(72, 327, 115, 25);
		contentPane.add(lblNewLabel_1_7);
		
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


		txtType.setBounds(72, 351, 158, 34);
		contentPane.add(txtType);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID,Title,Author,Publisher,Language,Year,Acquire,Price,Type;
				ID =txtID.getText();
				Title = txtTitle.getText();
				Author = txtAuthor.getText();
				Publisher = txtPublisher.getText();
				Language = txtLanguage.getText();
				Year = txtYear.getText();
				Acquire = (String) txtType.getSelectedItem();
				Price = txtPrice.getText();
				
				
				try {
					pst = con.prepareStatement("updare tbl_article set aTitle=?,aAuthor=?,aPublisher=?,aLanguage=?,aYear=?,aAcquire=?,aPrice=? where aID=?");
					
					pst.setString(1,Title);
					pst.setString(2,Author);
					pst.setString(3,Publisher);
					pst.setString(4,Language);
					pst.setString(5,Year);
					pst.setString(6,Acquire);
					pst.setString(7,Price);
					pst.setString(8,ID);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Article Updated!");
					article.table_load();
					manageArticle.this.dispose();
					}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				
			}
		});
		panel.setBackground(new Color(0,200,119));
		panel.setBounds(375, 418, 84, 25);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Update");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 84, 23);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageArticle.this.dispose();
			}
		});
		panel_1.setBackground(new Color(100,100,100));
		panel_1.setLayout(null);
		panel_1.setBounds(70, 418, 84, 25);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cancel");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(0, 0, 84, 23);
		panel_1.add(lblNewLabel_2_1);
		
		JPanel btnDelete = new JPanel();
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Id;
				
				Id = txtID.getText();
				
				
				try {
					pst = con.prepareStatement("Delete from tbl_article where aID=?");
					pst.setString(1,Id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Deleted!");
					manageArticle.this.dispose();
					article.table_load();
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setLayout(null);
		btnDelete.setBackground(new Color(0, 200, 119));
		btnDelete.setBounds(255, 418, 88, 25);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_4_1 = new JLabel("Delete");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(0, 0, 88, 25);
		btnDelete.add(lblNewLabel_4_1);
	}

}