import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class registerStudent extends JFrame {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPanel contentPane;
	private JTextField txtLRN;
	private JTextField txtLname;
	private JTextField txtFname;
	private JTextField txtMname;
	private JTextField txtSection;
	private static JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerStudent window = new registerStudent();
					window.frame.setVisible(true);
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
	public registerStudent() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 738);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244,239,239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Student");
		lblNewLabel.setForeground(new Color(100,100,100));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 10, 317, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblLrn = new JLabel("LRN:");
		lblLrn.setForeground(SystemColor.windowBorder);
		lblLrn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLrn.setBounds(303, 101, 167, 50);
		contentPane.add(lblLrn);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setForeground(SystemColor.windowBorder);
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastname.setBounds(303, 194, 167, 50);
		contentPane.add(lblLastname);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(SystemColor.windowBorder);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstName.setBounds(303, 302, 167, 50);
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleInitial = new JLabel("Middle Name:");
		lblMiddleInitial.setForeground(SystemColor.windowBorder);
		lblMiddleInitial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMiddleInitial.setBounds(303, 406, 167, 50);
		contentPane.add(lblMiddleInitial);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setForeground(SystemColor.windowBorder);
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSection.setBounds(303, 510, 167, 50);
		contentPane.add(lblSection);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					registerStudent.this.dispose();
					
				}
			}
		});
		lblBack.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBack.setForeground(SystemColor.windowBorder);
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBack.setBounds(810, 678, 146, 50);
		contentPane.add(lblBack);
		
		txtLRN = new JTextField();
		txtLRN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLRN.setBackground(new Color(217,217,217));
		txtLRN.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtLRN.setBounds(303, 140, 396, 51);
		contentPane.add(txtLRN);
		txtLRN.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLname.setColumns(10);
		txtLname.setBackground(new Color(217, 217, 217));
		txtLname.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtLname.setBounds(303, 241, 396, 51);
		contentPane.add(txtLname);
		
		txtFname = new JTextField();
		txtFname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFname.setColumns(10);
		txtFname.setBackground(new Color(217, 217, 217));
		txtFname.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtFname.setBounds(303, 343, 396, 51);
		contentPane.add(txtFname);
		
		txtMname = new JTextField();
		txtMname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMname.setColumns(10);
		txtMname.setBackground(new Color(217, 217, 217));
		txtMname.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtMname.setBounds(303, 452, 396, 51);
		contentPane.add(txtMname);
		
		txtSection = new JTextField();
		txtSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSection.setColumns(10);
		txtSection.setBackground(new Color(217, 217, 217));
		txtSection.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtSection.setBounds(303, 555, 396, 51);
		contentPane.add(txtSection);
		
		JPanel btnGenerate = new JPanel();
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String lrn,lname,fname,mname,section;
				
				lrn=txtLRN.getText();
				lname=txtLname.getText();
				fname=txtFname.getText();
				mname=txtMname.getText();
				section=txtSection.getText();
				
				try {
					pst = con.prepareStatement("INSERT INTO tbl_student(LRN,student_fname,student_mname,student_lname,section) VALUES (?,?,?,?,?)");
					pst.setString(1,lrn);
					pst.setString(2,fname);
					pst.setString(3,mname);
					pst.setString(4,lname);
					pst.setString(5,section);
					

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Student Registered!");
				
					txtLRN.setText("");
					txtLname.setText("");
					txtFname.setText("");
					txtMname.setText("");
					txtSection.setText("");
					txtLRN.requestFocus();

					panelData.table_load();
				
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				
				//QR code generator
				try {
		            String qrCodeData = lrn;
		            //directory path of qr code
		            String filePath = ("D:\\QRCODE\\" +lname+(",")+fname+(",")+mname+".png" );
		            
		            String charset = "UTF-8"; // or "ISO-8859-1"
		            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
		            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		            BitMatrix matrix = new MultiFormatWriter().encode(
		                new String(qrCodeData.getBytes(charset), charset),
		                BarcodeFormat.QR_CODE, 200, 200, hintMap);
		            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
		                .lastIndexOf('.') + 1), new File(filePath));
		            
		            
		           
		        } catch (Exception ex) {
		            System.err.println(ex);
		        }
			}
		});
		btnGenerate.setBackground(new Color(0, 200, 119));
		btnGenerate.setBounds(424, 626, 154, 44);
		contentPane.add(btnGenerate);
		btnGenerate.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Generate QR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 10, 134, 24);
		btnGenerate.add(lblNewLabel_1);
	}
}
