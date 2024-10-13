import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	JPanel btnDashboard;
	JPanel btnCatalog;
	JPanel btnIssued;
	JPanel btnReturned;
	JPanel btnOverdue;
	JPanel btnArchive;
	JPanel btnData;
	JPanel btnTimelog;
	JPanel btnAccesslog;
	JPanel btnAcquisition;	
	JPanel btnInventory;
	static panelDashboard PanelDashboard;
	static panelCatalog PanelCatalog;
	static panelIssued PanelIssued;
	static panelReturned PanelReturned;
	static panelOverdue PanelOverdue;
	static panelArchive PanelArchive;
	static panelData PanelData;
	static panelTimelog PanelTimelog;
	static panelAcquisition PanelAcquisition;
	static panelInventory PanelInventory;
	static JPanel panelMaincontent;
	private JLabel iconProfile;
	
	static article Article;
	static Furniture furniture;
	static newspaper Newspaper;
	static magazine Magazine;
	static book Book;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1526, 863);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		PanelDashboard = new panelDashboard();
		PanelCatalog = new panelCatalog();
		PanelIssued = new panelIssued();
		PanelReturned = new panelReturned();
		PanelOverdue = new panelOverdue();
		PanelArchive = new panelArchive();
		PanelData = new panelData();
		PanelTimelog = new panelTimelog();
		PanelAcquisition = new panelAcquisition();
		PanelInventory = new panelInventory();
		Article = new article();
		furniture = new Furniture();
		Newspaper = new newspaper();
		Magazine = new magazine();
		Book = new book();
		
	
		
		JPanel Menu = new JPanel();
		Menu.setBackground(new Color(0, 200, 119));
		Menu.setBounds(0, 0, 233, 863);
		contentPane.add(Menu);
		Menu.setLayout(null);
		
		JLabel iconLogo = new JLabel("");
		Image imglogo = new ImageIcon(this.getClass().getResource("/imglogo.png")).getImage().getScaledInstance(100, 120, Image.SCALE_SMOOTH);
		iconLogo.setIcon(new ImageIcon(imglogo));
		iconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		iconLogo.setBounds(51, 0, 117, 146);
		Menu.add(iconLogo);
		
		btnDashboard = new JPanel();
		btnDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnDashboard.setBackground(new Color(1, 177, 104));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(0, 200, 119));
				btnInventory.setBackground(new Color(0,200,119));
				
				menuClicked(PanelDashboard);
			}
		});
		btnDashboard.setBackground(new Color(1, 177, 104));
		btnDashboard.setBounds(0, 166, 233, 66);
		Menu.add(btnDashboard);
		btnDashboard.setLayout(null);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDashboard.setForeground(new Color(255, 255, 255));
		lblDashboard.setBounds(34, 10, 189, 46);
		btnDashboard.add(lblDashboard);
		
		btnCatalog = new JPanel();
		btnCatalog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(1, 177, 104));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(0, 200, 119));
				btnInventory.setBackground(new Color(0,200,119));
				
				menuClicked(PanelCatalog);
			}
		});
		btnCatalog.setBackground(new Color(0, 200, 119));
		btnCatalog.setBounds(0, 231, 233, 66);
		Menu.add(btnCatalog);
		btnCatalog.setLayout(null);
		
		JLabel lblCatalog = new JLabel("Catalog");
		lblCatalog.setForeground(Color.WHITE);
		lblCatalog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCatalog.setBounds(34, 10, 189, 46);
		btnCatalog.add(lblCatalog);
		
		btnIssued = new JPanel();
		btnIssued.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(1, 177, 104));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(0, 200, 119));
				btnInventory.setBackground(new Color(0,200,119));
				
				menuClicked(PanelIssued);
			}
		});
		btnIssued.setBackground(new Color(0, 200, 119));
		btnIssued.setBounds(0, 297, 233, 66);
		Menu.add(btnIssued);
		btnIssued.setLayout(null);
		
		JLabel lblIssued = new JLabel("Issued");
		lblIssued.setForeground(Color.WHITE);
		lblIssued.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIssued.setBounds(34, 10, 189, 46);
		btnIssued.add(lblIssued);
		
		btnArchive = new JPanel();
		btnArchive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(PanelArchive);
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(1, 177, 104));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(0, 200, 119));
				btnInventory.setBackground(new Color(0,200,119));
			}
		});
		btnArchive.setBackground(new Color(0, 200, 119));
		btnArchive.setBounds(0, 494, 233, 66);
		Menu.add(btnArchive);
		btnArchive.setLayout(null);
		
		JLabel lblArchive = new JLabel("Archive");
		lblArchive.setForeground(Color.WHITE);
		lblArchive.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblArchive.setBounds(34, 10, 189, 46);
		btnArchive.add(lblArchive);
		
		btnOverdue = new JPanel();
		btnOverdue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(PanelOverdue);
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(1, 177, 104));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(0, 200, 119));
				btnInventory.setBackground(new Color(0,200,119));
			}
		});
		btnOverdue.setBackground(new Color(0, 200, 119));
		btnOverdue.setBounds(0, 428, 233, 66);
		Menu.add(btnOverdue);
		btnOverdue.setLayout(null);
		
		JLabel lblOverdue = new JLabel("Overdue");
		lblOverdue.setForeground(Color.WHITE);
		lblOverdue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOverdue.setBounds(34, 10, 189, 46);
		btnOverdue.add(lblOverdue);
		
		btnReturned = new JPanel();
		btnReturned.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(PanelReturned);
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(1, 177, 104));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(0, 200, 119));
				btnInventory.setBackground(new Color(0,200,119));
			}
		});
		btnReturned.setBackground(new Color(0, 200, 119));
		btnReturned.setBounds(0, 363, 233, 66);
		Menu.add(btnReturned);
		btnReturned.setLayout(null);
		
		JLabel lblReturned = new JLabel("Returned");
		lblReturned.setForeground(Color.WHITE);
		lblReturned.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReturned.setBounds(34, 10, 189, 46);
		btnReturned.add(lblReturned);
		
		
		btnTimelog = new JPanel();
		btnTimelog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(PanelTimelog);
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(1, 177, 104));
				btnAcquisition.setBackground(new Color(0, 200, 119));
				btnInventory.setBackground(new Color(0,200,119));
			}
		});
		btnTimelog.setBackground(new Color(0, 200, 119));
		btnTimelog.setBounds(0, 626, 233, 66);
		Menu.add(btnTimelog);
		btnTimelog.setLayout(null);
		
		JLabel lblStudentsTimeLog = new JLabel("Students' time log");
		lblStudentsTimeLog.setForeground(Color.WHITE);
		lblStudentsTimeLog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentsTimeLog.setBounds(34, 10, 189, 46);
		btnTimelog.add(lblStudentsTimeLog);
		
		btnData = new JPanel();
		btnData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(PanelData);
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(1, 177, 104));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(0, 200, 119));
				btnInventory.setBackground(new Color(0,200,119));
			}
		});
		btnData.setBackground(new Color(0, 200, 119));
		btnData.setBounds(0, 561, 233, 66);
		Menu.add(btnData);
		btnData.setLayout(null);
		
		JLabel lblStudentsData = new JLabel("Students' Data");
		lblStudentsData.setForeground(Color.WHITE);
		lblStudentsData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentsData.setBounds(34, 10, 189, 46);
		btnData.add(lblStudentsData);
		
		btnAcquisition = new JPanel();
		btnAcquisition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(PanelAcquisition);
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(1, 177, 104));
				btnInventory.setBackground(new Color(0,200,119));
			}
		});
		btnAcquisition.setBackground(new Color(0, 200, 119));
		btnAcquisition.setBounds(0, 689, 233, 66);
		Menu.add(btnAcquisition);
		btnAcquisition.setLayout(null);
		
		JLabel lblAcquisitions = new JLabel("Acquisitions");
		lblAcquisitions.setForeground(Color.WHITE);
		lblAcquisitions.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAcquisitions.setBounds(34, 10, 189, 46);
		btnAcquisition.add(lblAcquisitions);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 177, 104));
		panel.setBounds(0, 824, 233, 39);
		Menu.add(panel);
		panel.setLayout(null);
		
		JLabel Librarian = new JLabel("Librarian");
		Librarian.setFont(new Font("Tahoma", Font.BOLD, 15));
		Librarian.setBounds(55, 0, 103, 39);
		panel.add(Librarian);
		Librarian.setForeground(new Color(255, 255, 255));
		Librarian.setHorizontalAlignment(SwingConstants.CENTER);
		
		iconProfile = new JLabel("");
		iconProfile.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgpro = new ImageIcon(this.getClass().getResource("/imgpro.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		iconProfile.setIcon(new ImageIcon(imgpro));
		iconProfile.setBounds(0, 0, 45, 39);
		panel.add(iconProfile);
		
		JLabel iconLogout = new JLabel("");
		iconLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				JOptionPane.showConfirmDialog(null, "Do you want to Logout?",null, JOptionPane.YES_NO_OPTION);
				libLogin log = new libLogin();
				log.show();
				MainFrame.this.dispose();
			}
		});
		iconLogout.setHorizontalAlignment(SwingConstants.CENTER);
		iconLogout.setBounds(188, 0, 45, 39);
		Image imglog = new ImageIcon(this.getClass().getResource("/imglog.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		iconLogout.setIcon(new ImageIcon(imglog));
		panel.add(iconLogout);
		
		btnInventory = new JPanel();
		btnInventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnDashboard.setBackground(new Color(0, 200, 119));
				btnCatalog.setBackground(new Color(0, 200, 119));
				btnIssued.setBackground(new Color(0, 200, 119));
				btnReturned.setBackground(new Color(0, 200, 119));
				btnOverdue.setBackground(new Color(0, 200, 119));
				btnArchive.setBackground(new Color(0, 200, 119));
				btnData.setBackground(new Color(0, 200, 119));
				btnTimelog.setBackground(new Color(0, 200, 119));
				btnAcquisition.setBackground(new Color(0,200,119));
				btnInventory.setBackground(new Color(1,177,104));
				
				menuClicked(PanelInventory);
			}
		});
		btnInventory.setLayout(null);
		btnInventory.setBackground(new Color(0, 200, 119));
		btnInventory.setBounds(0, 758, 233, 66);
		Menu.add(btnInventory);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setForeground(Color.WHITE);
		lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInventory.setBounds(34, 10, 189, 46);
		btnInventory.add(lblInventory);
		
		panelMaincontent = new JPanel();
		panelMaincontent.setBackground(new Color(255, 255, 255));
		panelMaincontent.setBounds(233, 0, 1308, 863);
		contentPane.add(panelMaincontent);
		panelMaincontent.setLayout(null);
		
		panelMaincontent.add(PanelDashboard);
		panelMaincontent.add(PanelCatalog);
		panelMaincontent.add(PanelIssued);
		panelMaincontent.add(PanelReturned);
		panelMaincontent.add(PanelOverdue);
		panelMaincontent.add(PanelArchive);
		panelMaincontent.add(PanelData);
		panelMaincontent.add(PanelTimelog);
		panelMaincontent.add(PanelAcquisition);
		panelMaincontent.add(PanelInventory);
		panelMaincontent.add(Article);
		panelMaincontent.add(furniture);
		panelMaincontent.add(Newspaper);
		panelMaincontent.add(Magazine);
		panelMaincontent.add(Book);
		menuClicked(PanelDashboard);
		
	}
	public static void menuClicked(JPanel panel) {
		PanelDashboard.setVisible(false);
		PanelCatalog.setVisible(false);
		PanelIssued.setVisible(false);
		PanelReturned.setVisible(false);
		PanelOverdue.setVisible(false);
		PanelArchive.setVisible(false);
		PanelData.setVisible(false);
		PanelTimelog.setVisible(false);
		PanelAcquisition.setVisible(false);
		PanelInventory.setVisible(false);
		Article.setVisible(false);
		furniture.setVisible(false);
		Newspaper.setVisible(false);
		Magazine.setVisible(false);
		Book.setVisible(false);
		panel.setVisible(true);
	}
}
