import java.awt.Color;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class addBooks extends JFrame {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtISBN;
	private JTextField txtAuthor;
	private JTextField txtVersion;
	private JTextField txtPublisher;
	private JTextField txtYear;
	private JTextField txtPlace;
	private JTextField txtPages;
	private JTextField txtCat1;
	private JTextField txtCat2;
	private JTextField txtPrice;
	private JTextField txtBId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addBooks frame = new addBooks();
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
	public addBooks() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 841);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244,239,239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New Book");
		lblNewLabel.setForeground(new Color(100,100,100));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 10, 317, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblLrn = new JLabel("Book ID");
		lblLrn.setForeground(SystemColor.windowBorder);
		lblLrn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLrn.setBounds(30, 59, 167, 50);
		contentPane.add(lblLrn);
		
		JLabel lblBack = new JLabel("X");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					addBooks.this.dispose();
					
				}
			}
		});
		lblBack.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBack.setForeground(SystemColor.windowBorder);
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBack.setBounds(831, 10, 135, 39);
		contentPane.add(lblBack);
		
		
		
		
		txtBId = new JTextField();
		txtBId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBId.setBackground(new Color(217,217,217));
		txtBId.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtBId.setBounds(30, 108, 396, 51);
		contentPane.add(txtBId);
		txtBId.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setForeground(SystemColor.windowBorder);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(30, 169, 167, 50);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTitle.setColumns(10);
		txtTitle.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtTitle.setBackground(new Color(217, 217, 217));
		txtTitle.setBounds(30, 218, 396, 51);
		contentPane.add(txtTitle);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(SystemColor.windowBorder);
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIsbn.setBounds(30, 279, 167, 50);
		contentPane.add(lblIsbn);
		
		txtISBN = new JTextField();
		txtISBN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtISBN.setColumns(10);
		txtISBN.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtISBN.setBackground(new Color(217, 217, 217));
		txtISBN.setBounds(30, 328, 396, 51);
		contentPane.add(txtISBN);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setForeground(SystemColor.windowBorder);
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAuthor.setBounds(30, 389, 167, 50);
		contentPane.add(lblAuthor);
		
		txtAuthor = new JTextField();
		txtAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAuthor.setColumns(10);
		txtAuthor.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtAuthor.setBackground(new Color(217, 217, 217));
		txtAuthor.setBounds(30, 438, 396, 51);
		contentPane.add(txtAuthor);
		
		JLabel lblPublisher = new JLabel("Version");
		lblPublisher.setForeground(SystemColor.windowBorder);
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPublisher.setBounds(30, 499, 167, 50);
		contentPane.add(lblPublisher);
		
		txtVersion = new JTextField();
		txtVersion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtVersion.setColumns(10);
		txtVersion.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtVersion.setBackground(new Color(217, 217, 217));
		txtVersion.setBounds(30, 548, 396, 51);
		contentPane.add(txtVersion);
		
		JLabel lblPulishedPlace = new JLabel("Publisher");
		lblPulishedPlace.setForeground(SystemColor.windowBorder);
		lblPulishedPlace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPulishedPlace.setBounds(30, 609, 167, 50);
		contentPane.add(lblPulishedPlace);
		
		txtPublisher = new JTextField();
		txtPublisher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPublisher.setColumns(10);
		txtPublisher.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtPublisher.setBackground(new Color(217, 217, 217));
		txtPublisher.setBounds(30, 658, 396, 51);
		contentPane.add(txtPublisher);
		
		JLabel lblPages = new JLabel("Year Published");
		lblPages.setForeground(SystemColor.windowBorder);
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPages.setBounds(537, 59, 167, 50);
		contentPane.add(lblPages);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtYear.setColumns(10);
		txtYear.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtYear.setBackground(new Color(217, 217, 217));
		txtYear.setBounds(537, 108, 396, 51);
		contentPane.add(txtYear);
		
		JLabel lblplace = new JLabel("Published Place");
		lblplace.setForeground(SystemColor.windowBorder);
		lblplace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblplace.setBounds(30, 716, 167, 50);
		contentPane.add(lblplace);
		
		txtPlace = new JTextField();
		txtPlace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPlace.setColumns(10);
		txtPlace.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtPlace.setBackground(new Color(217, 217, 217));
		txtPlace.setBounds(30, 765, 396, 51);
		contentPane.add(txtPlace);
		
		JLabel lblCategory = new JLabel("Pages");
		lblCategory.setForeground(SystemColor.windowBorder);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategory.setBounds(537, 169, 167, 50);
		contentPane.add(lblCategory);
		
		txtPages = new JTextField();
		txtPages.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPages.setColumns(10);
		txtPages.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtPages.setBackground(new Color(217, 217, 217));
		txtPages.setBounds(537, 218, 396, 51);
		contentPane.add(txtPages);
		
		JLabel lblCategory_1 = new JLabel("Category 1");
		lblCategory_1.setForeground(SystemColor.windowBorder);
		lblCategory_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategory_1.setBounds(537, 279, 167, 50);
		contentPane.add(lblCategory_1);
		
		txtCat1 = new JTextField();
		txtCat1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCat1.setColumns(10);
		txtCat1.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtCat1.setBackground(new Color(217, 217, 217));
		txtCat1.setBounds(537, 328, 396, 51);
		contentPane.add(txtCat1);
		
		JLabel lblCategory_2 = new JLabel("Category 2");
		lblCategory_2.setForeground(SystemColor.windowBorder);
		lblCategory_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategory_2.setBounds(537, 389, 167, 50);
		contentPane.add(lblCategory_2);
		
		txtCat2 = new JTextField();
		txtCat2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCat2.setColumns(10);
		txtCat2.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtCat2.setBackground(new Color(217, 217, 217));
		txtCat2.setBounds(537, 438, 396, 51);
		contentPane.add(txtCat2);
		
		JLabel lblAcquisitonType = new JLabel("Acquisiton Type");
		lblAcquisitonType.setForeground(SystemColor.windowBorder);
		lblAcquisitonType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAcquisitonType.setBounds(537, 499, 167, 50);
		contentPane.add(lblAcquisitonType);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(SystemColor.windowBorder);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(537, 609, 167, 50);
		contentPane.add(lblPrice);
		
		
		txtPrice = new JTextField();
		txtPrice.setText("0");
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtPrice.setBackground(new Color(217, 217, 217));
		txtPrice.setBounds(537, 658, 396, 51);
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
		txtType.setBounds(537, 553, 396, 49);
		txtType.setBorder(BorderFactory.createLineBorder(new Color(217,217,217)));
		txtType.setBackground(new Color(217, 217, 217));
		contentPane.add(txtType);
		
		
		JPanel btnRegister = new JPanel();
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Id,Title,ISBN,Author,Version,Publisher,Place,Year,Pages,Cat1,Cat2,selectedType,price;
				
				Id = txtBId.getText();
				Title = txtTitle.getText();
				ISBN = txtISBN.getText();
				Author = txtAuthor.getText();
				Version = txtVersion.getText();
				Publisher = txtPublisher.getText();
				Place = txtPlace.getText();
				Year = txtYear.getText();
				Pages = txtPages.getText();
				Cat1 = txtCat1.getText();
				Cat2 = txtCat2.getText();
				selectedType = (String) txtType.getSelectedItem();
				price = txtPrice.getText();
		
				try {
					pst = con.prepareStatement("INSERT INTO tbl_catalog(book_id,Title,ISBN,author,version,publisher,place_published,year_published,pages,category_1,category_2 ) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1,Id);
					pst.setString(2,Title);
					pst.setString(3,ISBN);
					pst.setString(4,Author);
					pst.setString(5,Version);
					pst.setString(6,Publisher);
					pst.setString(7,Place);
					pst.setString(8,Year);
					pst.setString(9,Pages);
					pst.setString(10,Cat1);
					pst.setString(11,Cat2);
					pst.executeUpdate();
					
					pst = con.prepareStatement("INSERT INTO tbl_books(book_id,Title,ISBN,author,version,publisher,place_published,year_published,pages,category_1,category_2,acquisition_type,price) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1,Id);
					pst.setString(2,Title);
					pst.setString(3,ISBN);
					pst.setString(4,Author);
					pst.setString(5,Version);
					pst.setString(6,Publisher);
					pst.setString(7,Place);
					pst.setString(8,Year);
					pst.setString(9,Pages);
					pst.setString(10,Cat1);
					pst.setString(11,Cat2);
					pst.setString(12,selectedType);
					pst.setString(13,price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Registered!");
				
					txtBId.setText("");
					txtTitle.setText("");
					txtISBN.setText("");
					txtAuthor.setText("");
					txtVersion.setText("");
					txtPublisher.setText("");
					txtPlace.setText("");
					txtYear.setText("");
					txtPages.setText("");
					txtCat1.setText("");
					txtCat2.setText("");
					txtPrice.setText("");
					txtBId.requestFocus();

					panelCatalog.table_load();
					panelAcquisition.table_books();
					panelInventory.table_load();
				
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				try {
		            String qrCodeData = Id;
		            //directory path of qr code
		            String filePath = ("D:\\BookQRCODE\\" +Title+".png" );
		            
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
		btnRegister.setBackground(new Color(0, 200, 119));
		btnRegister.setBounds(638, 772, 154, 44);
		contentPane.add(btnRegister);
		btnRegister.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Register");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 10, 134, 24);
		btnRegister.add(lblNewLabel_1);
			
	}
	private void elseif(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
