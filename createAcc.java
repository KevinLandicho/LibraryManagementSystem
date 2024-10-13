import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class createAcc extends JFrame {

	private JPanel contentPane;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtNumber;
	private JTextField txtUser;
	private JTextField txtPass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAcc frame = new createAcc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
	 * Create the frame.
	 */
	public createAcc() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 500);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(new Color(100,100,100));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 10, 317, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblLrn = new JLabel("Employee ID:");
		lblLrn.setForeground(SystemColor.windowBorder);
		lblLrn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLrn.setBounds(65, 84, 167, 50);
		contentPane.add(lblLrn);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					createAcc.this.dispose();
					
				}
			}
		});
		lblBack.setForeground(SystemColor.windowBorder);
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBack.setBounds(65, 412, 146, 50);
		contentPane.add(lblBack);
		
		
		JPanel btnGenerate = new JPanel();
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID,name,email,number,username,password;
				
				ID=txtID.getText();
				name=txtName.getText();
				email=txtEmail.getText();
				number=txtNumber.getText();
				username=txtUser.getText();
				password=txtPass.getText();
				
				try {
					pst = con.prepareStatement("INSERT INTO tbl_librarianinfo(employee_id,employee_name,employee_email,employee_contact	) VALUES (?,?,?,?)");
					pst.setString(1,ID);
					pst.setString(2,name);
					pst.setString(3,email);
					pst.setString(4,number);
					pst.executeUpdate();
					
				
					
					
				
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				
				try {
					pst = con.prepareStatement("INSERT INTO tbl_librarianaccount(username,password,employee_id) VALUES (?,?,?)");
					pst.setString(1,username);
					pst.setString(2,password);
					pst.setString(3,ID);
					

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Account Created!");
					
					txtID.setText("");
					txtName.setText("");
					txtEmail.setText("");
					txtNumber.setText("");
					txtUser.setText("");
					txtPass.setText("");
					txtID.requestFocus();
					
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		btnGenerate.setBackground(new Color(0, 200, 119));
		btnGenerate.setBounds(750, 418, 154, 44);
		contentPane.add(btnGenerate);
		btnGenerate.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Create Account");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 10, 134, 24);
		btnGenerate.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtID.setBackground(new Color(217,217,217));
		txtID.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtID.setBounds(65, 123, 396, 51);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel("Name:");
		lblEmployeeName.setForeground(SystemColor.windowBorder);
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmployeeName.setBounds(65, 184, 167, 50);
		contentPane.add(lblEmployeeName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtName.setBackground(new Color(217, 217, 217));
		txtName.setBounds(65, 223, 396, 51);
		contentPane.add(txtName);
		
		JLabel lblEmployeeEmail = new JLabel("Email Address:");
		lblEmployeeEmail.setForeground(SystemColor.windowBorder);
		lblEmployeeEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmployeeEmail.setBounds(65, 284, 167, 50);
		contentPane.add(lblEmployeeEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtEmail.setBackground(new Color(217, 217, 217));
		txtEmail.setBounds(65, 323, 396, 51);
		contentPane.add(txtEmail);
		
		JLabel lblContactNumber = new JLabel("Contact Number:");
		lblContactNumber.setForeground(SystemColor.windowBorder);
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContactNumber.setBounds(508, 84, 167, 50);
		contentPane.add(lblContactNumber);
		
		txtNumber = new JTextField();
		txtNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNumber.setColumns(10);
		txtNumber.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtNumber.setBackground(new Color(217, 217, 217));
		txtNumber.setBounds(508, 123, 396, 51);
		contentPane.add(txtNumber);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(SystemColor.windowBorder);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(508, 184, 167, 50);
		contentPane.add(lblUsername);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setColumns(10);
		txtUser.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtUser.setBackground(new Color(217, 217, 217));
		txtUser.setBounds(508, 223, 396, 51);
		contentPane.add(txtUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(SystemColor.windowBorder);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(508, 284, 167, 50);
		contentPane.add(lblPassword);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setColumns(10);
		txtPass.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtPass.setBackground(new Color(217, 217, 217));
		txtPass.setBounds(508, 323, 396, 51);
		contentPane.add(txtPass);
	}
}
