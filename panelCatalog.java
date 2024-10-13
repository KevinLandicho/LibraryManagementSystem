import javax.swing.JPanel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class panelCatalog extends JPanel {
	private static JTable table;
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;
	static JTextField txtBookID;
	static JTextField txtISBN;
	static JTextField txtTitle;
	static JTextField txtAuthor;
	static JTextField txtVersion;
	static JTextField txtPublisher;
	static JTextField txtPlace;
	static JTextField txtYear;
	static JTextField txtPages;
	static JTextField txtCat1;
	static JTextField txtCat2;
	static JTextField txtSearch;
	
	
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
			String query= "select * from tbl_catalog";
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
	public panelCatalog() {
		Connect();
		setBounds(0, 0, 1308, 863);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 76, 968, 678);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 968, 678);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100,100,100));
		panel_1.setBounds(295, 41, 968, 713);
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
		lblBookID_1_1.setBounds(94, 10, 70, 22);
		panel_1.add(lblBookID_1_1);
		
		JLabel lblBookID_1_2 = new JLabel("ISBN");
		lblBookID_1_2.setForeground(Color.WHITE);
		lblBookID_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_2.setBounds(185, 10, 70, 22);
		panel_1.add(lblBookID_1_2);
		
		JLabel lblBookID_1_3 = new JLabel("Author");
		lblBookID_1_3.setForeground(Color.WHITE);
		lblBookID_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_3.setBounds(266, 10, 70, 22);
		panel_1.add(lblBookID_1_3);
		
		JLabel lblBookID_1_4 = new JLabel("Version");
		lblBookID_1_4.setForeground(Color.WHITE);
		lblBookID_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_4.setBounds(360, 10, 70, 22);
		panel_1.add(lblBookID_1_4);
		
		JLabel lblBookID_1_5 = new JLabel("Publisher");
		lblBookID_1_5.setForeground(Color.WHITE);
		lblBookID_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_5.setBounds(440, 10, 70, 22);
		panel_1.add(lblBookID_1_5);
		
		JLabel lblBookID_1_6 = new JLabel("Place");
		lblBookID_1_6.setForeground(Color.WHITE);
		lblBookID_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6.setBounds(530, 10, 70, 22);
		panel_1.add(lblBookID_1_6);
		
		JLabel lblBookID_1_6_1 = new JLabel("Year");
		lblBookID_1_6_1.setForeground(Color.WHITE);
		lblBookID_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6_1.setBounds(617, 10, 70, 22);
		panel_1.add(lblBookID_1_6_1);
		
		JLabel lblBookID_1_6_1_1 = new JLabel("Pages");
		lblBookID_1_6_1_1.setForeground(Color.WHITE);
		lblBookID_1_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6_1_1.setBounds(707, 10, 48, 22);
		panel_1.add(lblBookID_1_6_1_1);
		
		JLabel lblBookID_1_6_1_2 = new JLabel("Categories");
		lblBookID_1_6_1_2.setForeground(Color.WHITE);
		lblBookID_1_6_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookID_1_6_1_2.setBounds(797, 10, 114, 22);
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
		iconRefresh.setBounds(921, 0, 45, 32);
		panel_1.add(iconRefresh);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 81, 275, 733);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblBookID = new JLabel("Book ID");
		lblBookID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookID.setBounds(10, 10, 70, 22);
		panel_2.add(lblBookID);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIsbn.setBounds(10, 142, 41, 22);
		panel_2.add(lblIsbn);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(10, 76, 34, 22);
		panel_2.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAuthor.setBounds(10, 207, 60, 22);
		panel_2.add(lblAuthor);
		
		JLabel lblVersion = new JLabel("Version");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVersion.setBounds(10, 271, 60, 22);
		panel_2.add(lblVersion);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPublisher.setBounds(10, 336, 79, 22);
		panel_2.add(lblPublisher);
		
		JLabel lblPlaceOfPublish = new JLabel("Place of Publish");
		lblPlaceOfPublish.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlaceOfPublish.setBounds(10, 401, 126, 22);
		panel_2.add(lblPlaceOfPublish);
		
		JLabel lblYearPublished = new JLabel("Year Published");
		lblYearPublished.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYearPublished.setBounds(10, 466, 126, 22);
		panel_2.add(lblYearPublished);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPages.setBounds(10, 531, 60, 22);
		panel_2.add(lblPages);
		
		JLabel lblCategory1 = new JLabel("Category 1");
		lblCategory1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategory1.setBounds(10, 597, 88, 22);
		panel_2.add(lblCategory1);
		
		JLabel lblCategory2 = new JLabel("Category 2");
		lblCategory2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategory2.setBounds(10, 663, 88, 22);
		panel_2.add(lblCategory2);
		
		txtBookID = new JTextField();
		txtBookID.setBounds(10, 32, 245, 34);
		panel_2.add(txtBookID);
		txtBookID.setColumns(10);
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(10, 163, 245, 34);
		panel_2.add(txtISBN);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(10, 98, 245, 34);
		panel_2.add(txtTitle);
		
		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(10, 227, 245, 34);
		panel_2.add(txtAuthor);
		
		txtVersion = new JTextField();
		txtVersion.setColumns(10);
		txtVersion.setBounds(10, 292, 245, 34);
		panel_2.add(txtVersion);
		
		txtPublisher = new JTextField();
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(10, 357, 245, 34);
		panel_2.add(txtPublisher);
		
		txtPlace = new JTextField();
		txtPlace.setColumns(10);
		txtPlace.setBounds(10, 422, 245, 34);
		panel_2.add(txtPlace);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(10, 487, 245, 34);
		panel_2.add(txtYear);
		
		txtPages = new JTextField();
		txtPages.setColumns(10);
		txtPages.setBounds(10, 553, 245, 34);
		panel_2.add(txtPages);
		
		txtCat1 = new JTextField();
		txtCat1.setColumns(10);
		txtCat1.setBounds(10, 619, 245, 34);
		panel_2.add(txtCat1);
		
		txtCat2 = new JTextField();
		txtCat2.setColumns(10);
		txtCat2.setBounds(10, 686, 245, 34);
		panel_2.add(txtCat2);
		
		JPanel btnAdd = new JPanel();
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Id,Title,ISBN,Author,Version,Publisher,Place,Year,Pages,Cat1,Cat2;
				
				Id = txtBookID.getText();
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
					JOptionPane.showMessageDialog(null,"Book Registered!");
					table_load();
					txtBookID.setText("");
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
					txtBookID.requestFocus();

					
					
				
				
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				
				//QR code generator
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
		btnAdd.setBackground(new Color(100,100,100));
		btnAdd.setBounds(343, 773, 170, 41);
		add(btnAdd);
		btnAdd.setLayout(null);
		
		JLabel lblAdd = new JLabel("Register Book");
		lblAdd.setForeground(new Color(255, 255, 255));
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdd.setBounds(50, 0, 120, 41);
		btnAdd.add(lblAdd);
		
		JLabel iconAdd = new JLabel("");
		iconAdd.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgAdd = new ImageIcon(this.getClass().getResource("/imgadd.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconAdd.setIcon(new ImageIcon(imgAdd));
		iconAdd.setBounds(0, 0, 46, 41);
		btnAdd.add(iconAdd);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(100,100,100));
		panel_4.setBounds(10, 41, 275, 41);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel iconSearch = new JLabel("");
		iconSearch.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgSearch = new ImageIcon(this.getClass().getResource("/imgsearch.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		iconSearch.setIcon(new ImageIcon(imgSearch));
		iconSearch.setBounds(0, 0, 46, 41);
		panel_4.add(iconSearch);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
				String Id = txtSearch.getText();
				
				pst =con.prepareStatement("select book_id,Title,ISBN,author,version,publisher,place_published,year_published,pages,category_1,category_2  from tbl_catalog Where book_id = ?");
				pst.setString(1, Id);
				ResultSet rs = pst.executeQuery();
				
			if (rs.next()==true)
			{
				
				String Title = rs.getString(2);
				String ISBN = rs.getString(3);
				String Author = rs.getString(4);
				String Version = rs.getString(5);
				String Publisher = rs.getString(6);
				String Place = rs.getString(7);
				String Year = rs.getString(8);
				String Pages = rs.getString(9);
				String Cat1 = rs.getString(10);
				String Cat2 = rs.getString(11);
				
				
				txtTitle.setText(Title);
				txtISBN.setText(ISBN);
				txtAuthor.setText(Author);
				txtVersion.setText(Version);
				txtPublisher.setText(Publisher);
				txtPlace.setText(Place);
				txtYear.setText(Year);
				txtPages.setText(Pages);
				txtCat1.setText(Cat1);
				txtCat2.setText(Cat2);
				
			}
			else {
				
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
				
			}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			}
		});
		txtSearch.setBounds(46, 0, 229, 41);
		panel_4.add(txtSearch);
		txtSearch.setColumns(10);
		
		JPanel btnUpdate = new JPanel();
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Title,ISBN,Author,Version,Publisher,Place,Year,Pages,Cat1,Cat2, Id;
				
				
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
				Id = txtSearch.getText();
				
				try {
					pst = con.prepareStatement("UPDATE tbl_catalog set Title=?,ISBN=?,author=?,version=?,publisher=?,place_published=?,year_published=?,pages=?,category_1=?,category_2=? where book_id=? ");
					
					pst.setString(1,Title);
					pst.setString(2,ISBN);
					pst.setString(3, Author);
					pst.setString(4, Version);
					pst.setString(5, Publisher);
					pst.setString(6, Place);
					pst.setString(7, Year);
					pst.setString(8, Pages);
					pst.setString(9, Cat1);
					pst.setString(10, Cat2);
					pst.setString(11, Id);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Updated!");
					table_load();
					
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
					txtBookID.setText("");
					txtSearch.setText("");
					txtBookID.requestFocus();

				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnUpdate.setBackground(SystemColor.windowBorder);
		btnUpdate.setBounds(523, 773, 170, 41);
		add(btnUpdate);
		btnUpdate.setLayout(null);
		
		JLabel lblUpdateBook = new JLabel("Update Book");
		lblUpdateBook.setForeground(Color.WHITE);
		lblUpdateBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUpdateBook.setBounds(56, 0, 109, 41);
		btnUpdate.add(lblUpdateBook);
		
		JLabel iconUpdate = new JLabel("");
		iconUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgUpdate = new ImageIcon(this.getClass().getResource("/imgupdate.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconUpdate.setIcon(new ImageIcon(imgUpdate));
		iconUpdate.setBounds(0, 0, 46, 41);
		btnUpdate.add(iconUpdate);
		
		JPanel btnArchive = new JPanel();
		btnArchive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			archiveDetails details = new archiveDetails();
			details.show();
			}
		});
		btnArchive.setBackground(SystemColor.windowBorder);
		btnArchive.setBounds(703, 773, 170, 41);
		add(btnArchive);
		btnArchive.setLayout(null);
		
		JLabel lblArchiveBook = new JLabel("Archive Book");
		lblArchiveBook.setForeground(Color.WHITE);
		lblArchiveBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArchiveBook.setBounds(56, 0, 104, 41);
		btnArchive.add(lblArchiveBook);
		
		JLabel iconArchive = new JLabel("");
		iconArchive.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgArchive = new ImageIcon(this.getClass().getResource("/imgarchive2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconArchive.setIcon(new ImageIcon(imgArchive));
		iconArchive.setBounds(0, 0, 46, 41);
		btnArchive.add(iconArchive);
		
		JPanel btnDelete = new JPanel();
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Id;
				
				Id = txtSearch.getText();
				
				
				try {
					pst = con.prepareStatement("Delete from tbl_catalog where book_id=?");
					pst.setString(1,Id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Deleted!");
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
					txtBookID.setText("");
					txtSearch.setText("");
					txtBookID.requestFocus();
					table_load();
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBackground(SystemColor.windowBorder);
		btnDelete.setBounds(883, 773, 170, 41);
		add(btnDelete);
		btnDelete.setLayout(null);
		
		JLabel lblDeleteBook = new JLabel("Delete Book");
		lblDeleteBook.setForeground(Color.WHITE);
		lblDeleteBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteBook.setBounds(56, 0, 97, 41);
		btnDelete.add(lblDeleteBook);
		
		JLabel iconDelete = new JLabel("");
		iconDelete.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgDelete = new ImageIcon(this.getClass().getResource("/imgdelete.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconDelete.setIcon(new ImageIcon(imgDelete));
		iconDelete.setBounds(0, 0, 46, 41);
		btnDelete.add(iconDelete);
		
		JPanel btnClear = new JPanel();
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBookID.setText("");
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
				txtSearch.setText("");
			}
		});
		btnClear.setBackground(SystemColor.windowBorder);
		btnClear.setBounds(1063, 773, 170, 41);
		add(btnClear);
		btnClear.setLayout(null);
		
		JLabel lblClear = new JLabel("Clear Text");
		lblClear.setForeground(Color.WHITE);
		lblClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClear.setBounds(56, 0, 91, 41);
		btnClear.add(lblClear);
		
		JLabel iconClear = new JLabel("");
		iconClear.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgClear = new ImageIcon(this.getClass().getResource("/imgclear.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconClear.setIcon(new ImageIcon(imgClear));
		iconClear.setBounds(0, 0, 46, 41);
		btnClear.add(iconClear);
		
		table_load();
	}
}
