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
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class archiveDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtReason;
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
					archiveDetails frame = new archiveDetails();
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
	public archiveDetails() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 178);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 200, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Reason of Archiving:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 141, 49);
		contentPane.add(lblNewLabel);
		
		txtReason = new JTextField();
		txtReason.setBounds(10, 59, 346, 66);
		contentPane.add(txtReason);
		txtReason.setColumns(10);
		
		JPanel btnCancel = new JPanel();
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				archiveDetails.this.dispose();
			}
		});
		btnCancel.setBackground(new Color(100,100,100));
		btnCancel.setBounds(10, 138, 85, 30);
		contentPane.add(btnCancel);
		btnCancel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cancel");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(0, 0, 85, 30);
		btnCancel.add(lblNewLabel_1);
		
		JPanel btnArchive = new JPanel();
		btnArchive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String reason =txtReason.getText();
				String Id;
				Id = panelCatalog.txtSearch.getText();
				String BookID,Title,ISBN,Author,Version,Publisher,Place,Year,Pages,Cat1,Cat2;
				BookID = panelCatalog.txtSearch.getText();
				Title = panelCatalog.txtTitle.getText();
				ISBN = panelCatalog.txtISBN.getText();
				Author = panelCatalog.txtAuthor.getText();
				Version = panelCatalog.txtVersion.getText();
				Publisher = panelCatalog.txtPublisher.getText();
				Place = panelCatalog.txtPlace.getText();
				Year = panelCatalog.txtYear.getText();
				Pages = panelCatalog.txtPages.getText();
				Cat1 = panelCatalog.txtCat1.getText();
				Cat2 = panelCatalog.txtCat2.getText();
			
				
				try {
					pst = con.prepareStatement("INSERT INTO tbl_archived(book_id,Title,ISBN,author,version,publisher,place_published,year_published,pages,category_1,category_2,Reason ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1,BookID);
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
					pst.setString(12, reason);

					pst.executeUpdate();
					
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				try {
					pst = con.prepareStatement("Delete from tbl_catalog where book_id=?");
					pst.setString(1,Id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Archived!");
					panelCatalog.table_load();
					panelCatalog.txtBookID.setText("");
					panelCatalog.txtTitle.setText("");
					panelCatalog.txtISBN.setText("");
					panelCatalog.txtAuthor.setText("");
					panelCatalog.txtVersion.setText("");
					panelCatalog.txtPublisher.setText("");
					panelCatalog.txtPlace.setText("");
					panelCatalog.txtYear.setText("");
					panelCatalog.txtPages.setText("");
					panelCatalog.txtCat1.setText("");
					panelCatalog.txtCat2.setText("");
					panelCatalog.txtBookID.requestFocus();
					panelArchive.table_load();
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				
				archiveDetails.this.dispose();
			
			}
		});
		btnArchive.setBackground(new Color(0, 200, 119));
		btnArchive.setBounds(271, 138, 85, 30);
		contentPane.add(btnArchive);
		btnArchive.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Archive");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(0, 0, 85, 30);
		btnArchive.add(lblNewLabel_1_1);
	}
}
