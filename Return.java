import java.awt.EventQueue;	
import java.awt.Font;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.LineBorder;



public class Return implements Runnable,ThreadFactory{
	
	public static ArrayList<String> message;
	
	private static JFrame frame;
	private WebcamPanel panel =null;
	private static Webcam webcam =null;
	private int mouseX,mouseY;
	private static final long serialVersionUID = 6441489157408381878L;
	private Executor executor =Executors.newSingleThreadExecutor(this);
	private String BookId;
	private String txt;
	private JTextField txtStudentNumber;
	private JPanel pnlButtonNext;
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return window = new Return();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
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
		}}
	

	public Return() {
		initialize();
		Connect();
	}

	
	public static void Paneclose() {
		frame.dispose();
	}
	public static void WebClose() {
		webcam.close();
	}
	
	public void initialize() {
		Connect();
		frame = new JFrame("Webcam");
		frame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
			}
		});
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX=e.getX();
				mouseY=e.getY();
			}
		});
		frame.getContentPane().setBackground(new Color(255,255,255));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1128, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel pnlReturn = new JPanel();
		pnlReturn.setBounds(385, 76, 650, 490);
		frame.getContentPane().add(pnlReturn);
		
		message = new ArrayList<String>();
		
		java.awt.Dimension size = WebcamResolution.VGA.getSize();
		webcam = Webcam.getWebcams().get(0);
		webcam.setViewSize(size);
		
		panel = new WebcamPanel(webcam);
		panel.setPreferredSize(size);
		panel.setFPSDisplayed(true);
		pnlReturn.add(panel);
		
		executor.execute(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100,100,100));
		panel_1.setBounds(0, 0, 1128, 37);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(1095, 0, 33, 32);
		panel_1.add(lblX);
		lblX.setBackground(new Color(255, 255, 255));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					frame.dispose();
					webcam.close();
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblX.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblX.setForeground(new Color(221, 168, 63));
			}
		});
		
		JPanel pnlInstruction = new JPanel();
		pnlInstruction.setBackground(new Color(0, 200, 119));
		pnlInstruction.setBounds(0, 37, 291, 582);
		frame.getContentPane().add(pnlInstruction);
		pnlInstruction.setLayout(null);
		
		JTextPane txtMessage = new JTextPane();
		txtMessage.setText("Please scan the QR code on the student's ID to proceed.");
		txtMessage.setForeground(new Color(255, 255, 255));
		txtMessage.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		txtMessage.setEditable(false);
		txtMessage.setBackground(new Color(0, 200, 119));
		txtMessage.setBounds(39, 116, 224, 143);
		pnlInstruction.add(txtMessage);
		
		txtStudentNumber = new JTextField();
		txtStudentNumber.setForeground(new Color(255, 255, 255));
		txtStudentNumber.setText("Student Number");
		txtStudentNumber.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtStudentNumber.setEditable(false);
		txtStudentNumber.setColumns(10);
		txtStudentNumber.setBorder(null);
		txtStudentNumber.setBackground(new Color(0, 200, 119));
		txtStudentNumber.setBounds(34, 351, 211, 29);
		pnlInstruction.add(txtStudentNumber);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		separator.setBounds(23, 380, 240, 2);
		separator.setForeground(new Color(255, 255, 255));
		pnlInstruction.add(separator);
		
		pnlButtonNext = new JPanel();
		pnlButtonNext.setVisible(false);
		pnlButtonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    txt = txtStudentNumber.getText();
			   
			  
			    if(txt.equals(message.get(0))) {
			    	txtMessage.setText("Scan the book's QR code to initiate a Returning transaction in the system.");
					txtStudentNumber.setText("Book ID");
					txt="";
					
			    	
			    }
			    
			    
			    else {
			    	
			    	
			    	int response= JOptionPane.showConfirmDialog(null, "Book Returned, Thankyou!",null, JOptionPane.YES_NO_OPTION);
			    	

			    if (response == JOptionPane.YES_OPTION) {
			    	String StudId = message.get(0);
			    	String BId = message.get(1);
			    	String Date, Time;
			    	
			    	LocalDateTime now = LocalDateTime.now();

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String formattedDate = now.format(formatter);
					DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
					String formattedTime = now.format(formatter1);
					Date = (formattedDate);
					Time = (formattedTime);
					
					try {
						pst = con.prepareStatement("INSERT INTO tbl_return (LRN,book_id,date_return,time_return) VALUES (?,?,?,?)");
						pst.setString(1,StudId);
						pst.setString(2,BId);
						pst.setString(3,Date);
						pst.setString(4,Time);
						
						
						pst.executeUpdate();
						panelReturned.table_load();
					
					}
					catch(SQLException e1){
						e1.printStackTrace();
					}
					try {
						pst = con.prepareStatement("Update tbl_issued set Status='Returned' where book_id=? and LRN=?");
						pst.setString(1,BId);
						pst.setString(2,StudId);
					
						
						pst.executeUpdate();
						panelReturned.table_load();
						panelIssued.table_load();
						
					
					}
					catch(SQLException e1){
						e1.printStackTrace();
					}
					
			    	frame.dispose();
					webcam.close();
					
			    } else if (response == JOptionPane.NO_OPTION) {
			    	Window window = JOptionPane.getRootFrame();
			    	window.dispose();
			    } else {
			    	Window window = JOptionPane.getRootFrame();
			    	window.dispose();
			    }
			   
			    }
				
			}
		});
		pnlButtonNext.setLayout(null);
		pnlButtonNext.setBackground(new Color(1, 177, 104));
		pnlButtonNext.setBounds(181, 442, 77, 29);
		pnlInstruction.add(pnlButtonNext);
		
		JLabel lblNewLabel_1 = new JLabel("Next");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 7, 36, 14);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		pnlButtonNext.add(lblNewLabel_1);
	
		
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "My Thread");
		t.setDaemon(true);
		return t;
	}

	@Override
	public void run() {
		
		
		do {
			
			 
			try {
				Thread.sleep(100);
				
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			
			Result result= null;
			BufferedImage image = null;
			if (webcam.isOpen()) {
				if ((image = webcam.getImage()) == null){
					continue;
				}
			}
			
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
			
			try {
				result = new MultiFormatReader().decode(bitmap);
			} catch (NotFoundException ex) {
				
			}
			
			if ( result != null) {
				if(JOptionPane.showConfirmDialog(null,"Scanning successful! Do you want to save it?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					
					System.out.println(result.getText());
					BookId=(result.getText());
					message.add(result.getText());
					BookId=message.get(0);
					if(message.size() > 1) {
					    txtStudentNumber.setText(message.get(1));
					   
					}
					else {
					     txtStudentNumber.setText(message.get(0));
					    
					     pnlButtonNext.setVisible(true);
					 
					}
			
				}

			}		
		
	} while (true);
		
		
		
		
	}
}
	

