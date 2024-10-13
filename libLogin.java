import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class libLogin extends JFrame {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	public static String username;
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
					libLogin frame = new libLogin();
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
	public libLogin() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1566, 866);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 200, 119));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(0, 0, 839, 866);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(45, 21, 117));
		panel_1.setBounds(792, 0, 10, 866);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(207, 40, 32));
		panel_1_1.setBounds(738, 0, 10, 866);
		panel.add(panel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(235, 199, 25));
		panel_1_2.setBounds(682, 0, 10, 866);
		panel.add(panel_1_2);
		
		JLabel iconLogo = new JLabel("");
		iconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		iconLogo.setBounds(140, 156, 412, 489);
		Image imglogo = new ImageIcon(this.getClass().getResource("/imglogo.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
		iconLogo.setIcon(new ImageIcon(imglogo));
		panel.add(iconLogo);
		
		JLabel lblNewLabel = new JLabel("Digital Library");
		lblNewLabel.setForeground(new Color(100, 100, 100));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 597, 402, 55);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome Back!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(1030, 261, 395, 65);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				username=txtUser.getText();
				String password=String.valueOf(txtPass.getPassword());
				
				try {
					pst = con.prepareStatement("select username,password from tbl_librarianaccount where username = ? and password=?");
					pst.setString(1,  username);
					pst.setString(2, password);
					
					ResultSet rs= pst.executeQuery();
					
					if(rs.next ()==true)
					{
						
						MainFrame main = new MainFrame();
						main.show();
						libLogin.this.dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid login details", "Login System", JOptionPane.ERROR_MESSAGE);
						txtUser.setText(null);
						txtPass.setText(null);
						txtUser.grabFocus();
					}
				}
				catch(SQLException e1){
				e1.printStackTrace();
				
				}	
			}
		});
		panel_2.setBackground(new Color(1, 177, 104));
		panel_2.setBounds(1030, 605, 395, 71);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Login");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(0, 0, 395, 71);
		panel_2.add(lblNewLabel_1_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setBounds(1030, 499, 395, 60);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		txtPass = new JPasswordField();
		txtPass.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
		txtPass.setBounds(0, 18, 395, 42);
		panel_2_1.add(txtPass);
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(1030, 376, 395, 60);
		contentPane.add(panel_2_1_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(0, 18, 395, 42);
		txtUser.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
		panel_2_1_1.add(txtUser);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(1029, 336, 352, 41);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_1.setBounds(1029, 457, 352, 41);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblCreateAcc = new JLabel("Or Sign Up using");
		lblCreateAcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAcc.setForeground(new Color(255, 255, 255));
		lblCreateAcc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCreateAcc.setBounds(1173, 687, 136, 32);
		contentPane.add(lblCreateAcc);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createAcc main = new createAcc();
				main.show();
			}
		});
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSignUp.setBounds(1173, 721, 136, 32);
		contentPane.add(lblSignUp);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1205, 750, 72, 3);
		contentPane.add(panel_3);
	}
}
