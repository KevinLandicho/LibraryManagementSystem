import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelDashboard extends JPanel {


	 public static String bookQuantitySum;
	 public static String studentQuantity;
	 public static String issuedQuantity;
	 public static String overdueQuantity;
	 public static String archiveQuantity;
	 public static String returnQuantity;
	 private JLabel lblBooksTotal;
	 private JLabel lblStudentsTotal;
	 private JLabel lblIssuedNum;
	 private JLabel lblOverdueNum;
	 private JLabel lblArchiveNum;
	 private JLabel lblReturnNum;
	 private Timer timer;
	
	 //variables for PieGraph
	 public static String Book1;
	 public static String Book2;
	 public static String Book3;
	 public static String Book4;
	 public static String Book5;
	 //variables for PieGraph Row Count
	 public static int cBook1;
	 public static int cBook2;
	 public static int cBook3;
	 public static int cBook4;
	 public static int cBook5;
	

	 private static JPanel pnlChart;
	 
	

	
	static Connection con;
	static PreparedStatement pst;
	ResultSet rs;
	public static String username;
	/**
	 * Create the panel.
	 */
	public static void Connect() {
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
	
	 public static void showPieChart(){
		  try {
		    String query = "SELECT book_id, num_borrowed FROM ( SELECT book_id, COUNT(*) AS num_borrowed FROM tbl_issued GROUP BY book_id ORDER BY num_borrowed DESC ) AS tmp LIMIT 5;";
		   
		 
		        pst = con.prepareStatement(query);
		        ResultSet rs = pst.executeQuery(query);
		   
		   
		    String[] topBookTitles = new String[5];
			int[] topBookBorrowCounts = new int[5];
		    int i = 0;
		      while(rs.next()) {
		    	  topBookTitles[i] = rs.getString("book_id");
		    	  topBookBorrowCounts[i] = rs.getInt("num_borrowed");
		        i++;
		        
		    	if(topBookTitles[0] == null) {
					Book1 = "No record yet";
					Book2 = "No record yet";
					Book3  = "No record yet";
					Book4 = "No record yet";
					Book5 = "No record yet";
					
					cBook1 = 10;
					cBook2 = 10;
					cBook3  =10;
					cBook4 = 10;
					cBook5 = 10;
					
				}
				else if(!(topBookTitles[0] == null) && (topBookTitles[1]==null)) {
					Book1 = topBookTitles[0];
					Book2 = "";
					Book3  = "";
					Book4 = "";
					Book5 = "";
					
					cBook1 = topBookBorrowCounts[0];
					cBook2 = 0;
					cBook3  =0;
					cBook4 = 0;
					cBook5 = 0;
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book1);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book1 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
				}
				else if(!(topBookTitles[0] == null) && !(topBookTitles[1] == (null)) && topBookTitles[2] == (null)) {
					Book1 = topBookTitles[0];
					Book2 = topBookTitles[1];
					Book3  = "";
					Book4 = "";
					Book5 = "";
					
					cBook1 = topBookBorrowCounts[0];
					cBook2 = topBookBorrowCounts[1];
					cBook3  =0;
					cBook4 = 0;
					cBook5 = 0;
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book1);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book1 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book2);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book2 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
				}
				else if(!(topBookTitles[0] == null) && !(topBookTitles[1] == (null)) && !(topBookTitles[2] == (null)) && topBookTitles[3] == (null)) {
					Book1 = topBookTitles[0];
					Book2 = topBookTitles[1];
					Book3  = topBookTitles[2];
					Book4 = "";
					Book5 = "";
					
					cBook1 = topBookBorrowCounts[0];
					cBook2 = topBookBorrowCounts[1];
					cBook3  =topBookBorrowCounts[2];
					cBook4 = 0;
					cBook5 = 0;
					
					
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book1);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book1 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book2);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book2 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book3);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book3 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
				}
				else if(!(topBookTitles[0] == null) && !(topBookTitles[1] == null) && !(topBookTitles[2] == null) && !(topBookTitles[3]==null) && topBookTitles[4] == (null)) {
					Book1 = topBookTitles[0];
					Book2 = topBookTitles[1];
					Book3  = topBookTitles[2];
					Book4 = topBookTitles[3];
					Book5 = "";
					
					cBook1 = topBookBorrowCounts[0];
					cBook2 = topBookBorrowCounts[1];
					cBook3  =topBookBorrowCounts[2];
					cBook4 = topBookBorrowCounts[3];
					cBook5 = 0;
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book1);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book1 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book2);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book2 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book3);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book3 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
					try {
						
						pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
						pst.setString(1, Book4);
						
						
						ResultSet rs1= pst.executeQuery();
						if (rs1.next()) {
							Book4 = rs1.getString("Title");
						}
						pst.close();
						//rs1.close();
					
					}catch (SQLException e1) {
						e1.printStackTrace();
						Connect();
					}
					
					
				}
				else {
				Book1 = topBookTitles[0];
				Book2 = topBookTitles[1];
				Book3  = topBookTitles[2];
				Book4 = topBookTitles[3];
				Book5 = topBookTitles[4];
				cBook1 = topBookBorrowCounts[0];
				cBook2  = topBookBorrowCounts[1];
				cBook3  = topBookBorrowCounts[2];
				cBook4  = topBookBorrowCounts[3];
				cBook5  = topBookBorrowCounts[4]; 
				
				
				try {
					
					pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
					pst.setString(1, Book1);
					
					
					ResultSet rs1= pst.executeQuery();
					if (rs1.next()) {
						Book1 = rs1.getString("Title");
					}
					pst.close();
					//rs1.close();
				
				}catch (SQLException e1) {
					e1.printStackTrace();
					Connect();
				}
				
				
				try {
					
					pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
					pst.setString(1, Book2);
					
					
					ResultSet rs1= pst.executeQuery();
					if (rs1.next()) {
						Book2 = rs1.getString("Title");
					}
					pst.close();
					//rs1.close();
				
				}catch (SQLException e1) {
					e1.printStackTrace();
					Connect();
				}
				
				try {
					
					pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
					pst.setString(1, Book3);
					
					
					ResultSet rs1= pst.executeQuery();
					if (rs1.next()) {
						Book3 = rs1.getString("Title");
					}
					pst.close();
					//rs1.close();
				
				}catch (SQLException e1) {
					e1.printStackTrace();
					Connect();
				}
				
				try {
					
					pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
					pst.setString(1, Book4);
					
					
					ResultSet rs1= pst.executeQuery();
					if (rs1.next()) {
						Book4 = rs1.getString("Title");
					}
					pst.close();
					//rs1.close();
				
				}catch (SQLException e1) {
					e1.printStackTrace();
					Connect();
				}
				
				try {
					
					pst = con.prepareStatement("select Title from tbl_catalog where book_id=?");
					pst.setString(1, Book5);
					
					
					ResultSet rs1= pst.executeQuery();
					if (rs1.next()) {
						Book5 = rs1.getString("Title");
					}
					pst.close();
					//rs1.close();
				
				}catch (SQLException e1) {
					e1.printStackTrace();
					Connect();
				}
				
				}
			        //create dataset
			      DefaultPieDataset barDataset = new DefaultPieDataset( );
			      barDataset.setValue( Book1 , new Double( cBook1 ) ); 
			      barDataset.setValue( Book2 , new Double( cBook2  ) );  
			      barDataset.setValue( Book3 , new Double( cBook3 ) );   
			      barDataset.setValue( Book4 , new Double( cBook4 ) ); 
			      barDataset.setValue( Book5 , new Double( cBook5  ) );
			      //create chart
			       JFreeChart piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
			    // set the title to null
			       piechart.setTitle((TextTitle) null);
			       // set the outline to null
			       piechart.setBorderVisible(false);
			       piechart.setBorderPaint(null);
			     
			      
			        PiePlot piePlot =(PiePlot) piechart.getPlot();
			     
			       //changing pie chart blocks colors
			        piePlot.setInsets(new RectangleInsets(0, 0, 0, 0));
			        piePlot.setLabelBackgroundPaint(new Color(100, 100, 100, 200));
			        piePlot.setLabelOutlinePaint(null);
			        piePlot.setLabelShadowPaint(null);
			        piePlot.setLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
			        piePlot.setLabelPaint(Color.white);
			        piePlot.setSectionPaint(Book1, new Color(0, 200, 119));
			        piePlot.setSectionPaint(Book2, new Color(122, 209, 81));
			        piePlot.setSectionPaint(Book3, new Color(34, 168, 132));
			        piePlot.setSectionPaint(Book4, new Color(42, 192, 142));
			        piePlot.setSectionPaint(Book5, new Color(42, 224, 142));
			      
			        piePlot.setBackgroundPaint(new Color(100,100,100));
			       
			        //create chartPanel to display chart(graph)
			        ChartPanel barChartPanel = new ChartPanel(piechart);
			      
			        barChartPanel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			        barChartPanel.setBorder(null);
			        barChartPanel.setBackground(new Color(100,100,100));
			        pnlChart.removeAll();
			        pnlChart.add(barChartPanel, BorderLayout.CENTER);
			        pnlChart.validate();
			       
			        pst.close();
			        //rs.close();
			        }
			} catch (SQLException e) {
			    System.out.println("Lost connection to the database. Trying to reconnect...");
			    Connect();
			    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		  }


		
		public static void updateBookQuantitySum() {
		    try {
		        String query = "SELECT COUNT(*) FROM tbl_catalog";
		        pst = con.prepareStatement(query);
		        ResultSet rs = pst.executeQuery(query);
		        if (rs.next()) {
		            bookQuantitySum = rs.getString(1);
		        }
		       
		        pst.close();
		        rs.close();
		    } catch (SQLException e) {
		    	 System.out.println("Lost connection to the database. Trying to reconnect...");
		         Connect();
		    }
		}
		
		
		
		
		
		public static void updateLabelStudentQuantity() {
		    try {
		        String query = "SELECT COUNT(*) FROM tbl_student";
		        pst = con.prepareStatement(query);
		        ResultSet rs = pst.executeQuery(query);
		        if (rs.next()) {
		            studentQuantity = rs.getString(1);
		        }
		       
		        pst.close();
		        rs.close();
		    } catch (SQLException e) {
		    	 System.out.println("Lost connection to the database. Trying to reconnect...");
		         Connect();
		    }
		}
		
		//SELECT COUNT(*) FROM table_name WHERE Status = 'pending';
		
		public static void updateLabelIssued() {
		    try {
		        String query = "SELECT COUNT(*) FROM tbl_issued WHERE Status IN('Active','overdue')";
		        pst = con.prepareStatement(query);
		        ResultSet rs = pst.executeQuery(query);
		        if (rs.next()) {
		            issuedQuantity = rs.getString(1);
		        }
		       
		        pst.close();
		        rs.close();
		    } catch (SQLException e) {
		    	 System.out.println("Lost connection to the database. Trying to reconnect...");
		         Connect();
		    }
		}
		
		public static void updateLabelOverdue() {
		    try {
		        String query = "SELECT COUNT(*) FROM tbl_issued WHERE Status = 'overdue'";
		        pst = con.prepareStatement(query);
		        ResultSet rs = pst.executeQuery(query);
		        if (rs.next()) {
		            overdueQuantity = rs.getString(1);
		        }
		       
		        pst.close();
		        rs.close();
		    } catch (SQLException e) {
		    	 System.out.println("Lost connection to the database. Trying to reconnect...");
		         Connect();
		    }
		}
		
		public static void updateLabelArchive() {
		    try {
		        String query = "SELECT COUNT(*) FROM tbl_archived";
		        pst = con.prepareStatement(query);
		        ResultSet rs = pst.executeQuery(query);
		        if (rs.next()) {
		            archiveQuantity = rs.getString(1);
		        }
		       
		        pst.close();
		        rs.close();
		    } catch (SQLException e) {
		    	 System.out.println("Lost connection to the database. Trying to reconnect...");
		         Connect();
		    }
		}
		
		public static void updateLabelReturn() {
		    try {
		        String query = "SELECT COUNT(*) FROM tbl_return";
		        pst = con.prepareStatement(query);
		        ResultSet rs = pst.executeQuery(query);
		        if (rs.next()) {
		            returnQuantity = rs.getString(1);
		        }
		       
		        pst.close();
		        rs.close();
		    } catch (SQLException e) {
		    	 System.out.println("Lost connection to the database. Trying to reconnect...");
		         Connect();
		    }
		}


	public panelDashboard() {
		Connect();
		
		 timer = new Timer(1000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	//changing the number of books in Homepage
	                updateBookQuantitySum();
	                int sum = Integer.parseInt(bookQuantitySum);
	                lblBooksTotal.setText(Integer.toString(sum));
	               
	                //changing the number of students in Homepage
	                updateLabelStudentQuantity();
	                int sNum = Integer.parseInt(studentQuantity);
	                lblStudentsTotal.setText(Integer.toString(sNum));
	               
	              //changing the number of issued books in Homepage
	                updateLabelIssued();
	                int iNum = Integer.parseInt(issuedQuantity);
	                lblIssuedNum.setText(Integer.toString(iNum));
	               
	              //changing the number of overdue books in Homepage 
	                updateLabelOverdue();
	                int oNum = Integer.parseInt(overdueQuantity);
	                lblOverdueNum.setText(Integer.toString(oNum));
	                
	                updateLabelArchive();
	                int aNum = Integer.parseInt(archiveQuantity);
	                lblArchiveNum.setText(Integer.toString(aNum));
	                
	                updateLabelReturn();
	                int rNum = Integer.parseInt(returnQuantity);
	                lblReturnNum.setText(Integer.toString(rNum));
	            }
	        });
	        timer.start();

		setBounds(0, 0, 1308, 863);
		setLayout(null);
		
		
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblWelcome.setForeground(new Color(100, 100, 100));
		lblWelcome.setBounds(34, 32, 177, 49);
		add(lblWelcome);
		
	
		JLabel lblName = new JLabel("Librarian!");
		lblName.setForeground(new Color(100, 100, 100));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblName.setBounds(214, 32, 310, 49);
		add(lblName);
		
		JPanel panelBook = new JPanel();
		panelBook.setBackground(new Color(0, 200, 119));
		panelBook.setBounds(35, 185, 385, 268);
		add(panelBook);
		panelBook.setLayout(null);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame Main = (MainFrame)
				SwingUtilities.getWindowAncestor(panelDashboard.this);
				Main.menuClicked(Main.PanelCatalog);
				
				Main.btnDashboard.setBackground(new Color(0, 200, 119));
				Main.btnCatalog.setBackground(new Color(1, 177, 104));
				Main.btnIssued.setBackground(new Color(0, 200, 119));
				Main.btnReturned.setBackground(new Color(0, 200, 119));
				Main.btnOverdue.setBackground(new Color(0, 200, 119));
				Main.btnArchive.setBackground(new Color(0, 200, 119));
				Main.btnData.setBackground(new Color(0, 200, 119));
				Main.btnTimelog.setBackground(new Color(0, 200, 119));
				Main.btnAcquisition.setBackground(new Color(0, 200, 119));
				
			}
		});
		panel_1.setBackground(new Color(100, 100, 100));
		panel_1.setBounds(0, 204, 385, 64);
		panelBook.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMoreInfo = new JLabel("More Info");
		lblMoreInfo.setForeground(Color.WHITE);
		lblMoreInfo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMoreInfo.setBounds(206, 10, 109, 49);
		panel_1.add(lblMoreInfo);
		
		JLabel lblBooks = new JLabel("Books");
		lblBooks.setForeground(new Color(255, 255, 255));
		lblBooks.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblBooks.setBounds(56, 121, 109, 49);
		panelBook.add(lblBooks);
		
		lblBooksTotal = new JLabel("0");
		lblBooksTotal.setForeground(new Color(255, 255, 255));
		lblBooksTotal.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblBooksTotal.setBounds(56, 80, 142, 49);
		panelBook.add(lblBooksTotal);
		
		JLabel iconBook = new JLabel("");
		iconBook.setHorizontalAlignment(SwingConstants.CENTER);
		iconBook.setBounds(203, 53, 156, 141);
		panelBook.add(iconBook);
		Image imgBooks = new ImageIcon(this.getClass().getResource("/imgbook.png")).getImage().getScaledInstance(137, 137, Image.SCALE_SMOOTH);
		iconBook.setIcon(new ImageIcon(imgBooks));
		
		JPanel panelStudent = new JPanel();
		panelStudent.setLayout(null);
		panelStudent.setBackground(new Color(0, 200, 119));
		panelStudent.setBounds(430, 185, 385, 268);
		add(panelStudent);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame Main = (MainFrame)
						SwingUtilities.getWindowAncestor(panelDashboard.this);
						Main.menuClicked(Main.PanelData);
						
						Main.btnDashboard.setBackground(new Color(0, 200, 119));
						Main.btnCatalog.setBackground(new Color(0, 200, 119));
						Main.btnIssued.setBackground(new Color(0, 200, 119));
						Main.btnReturned.setBackground(new Color(0, 200, 119));
						Main.btnOverdue.setBackground(new Color(0, 200, 119));
						Main.btnArchive.setBackground(new Color(0, 200, 119));
						Main.btnData.setBackground(new Color(1, 177, 104));
						Main.btnTimelog.setBackground(new Color(0, 200, 119));
						Main.btnAcquisition.setBackground(new Color(0, 200, 119));
			}
		});
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(SystemColor.windowBorder);
		panel_1_1.setBounds(0, 204, 385, 64);
		panelStudent.add(panel_1_1);
		
		JLabel lblMoreInfo_1 = new JLabel("More Info");
		lblMoreInfo_1.setForeground(Color.WHITE);
		lblMoreInfo_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMoreInfo_1.setBounds(206, 10, 109, 49);
		panel_1_1.add(lblMoreInfo_1);
		
		JLabel lblStudent = new JLabel("Students");
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblStudent.setBounds(56, 121, 142, 49);
		panelStudent.add(lblStudent);
		
		lblStudentsTotal = new JLabel("0");
		lblStudentsTotal.setForeground(Color.WHITE);
		lblStudentsTotal.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblStudentsTotal.setBounds(56, 80, 142, 49);
		panelStudent.add(lblStudentsTotal);
		
		JLabel iconStud = new JLabel("");
		iconStud.setHorizontalAlignment(SwingConstants.CENTER);
		iconStud.setBounds(203, 53, 156, 141);
		panelStudent.add(iconStud);
		Image imgStud = new ImageIcon(this.getClass().getResource("/imgstudent.png")).getImage().getScaledInstance(137, 137, Image.SCALE_SMOOTH);
		iconStud.setIcon(new ImageIcon(imgStud));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(100, 100, 100));
		panel.setBounds(832, 185, 449, 624);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblStudent_1 = new JLabel("What are the most");
		lblStudent_1.setForeground(Color.WHITE);
		lblStudent_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblStudent_1.setBounds(10, 10, 417, 54);
		panel.add(lblStudent_1);
		
		JLabel lblStudent_1_1 = new JLabel("popular books borrowed");
		lblStudent_1_1.setForeground(Color.WHITE);
		lblStudent_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblStudent_1_1.setBounds(10, 60, 417, 54);
		panel.add(lblStudent_1_1);
		
		JLabel lblStudent_1_2 = new JLabel("this month?");
		lblStudent_1_2.setForeground(Color.WHITE);
		lblStudent_1_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblStudent_1_2.setBounds(10, 111, 417, 54);
		panel.add(lblStudent_1_2);
		
		pnlChart = new JPanel();
		pnlChart.setForeground(new Color(100,100,100));
		pnlChart.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		pnlChart.setBorder(null);
		pnlChart.setBackground(new Color(100,100,100));
		pnlChart.setBounds(10, 210, 429, 404);
		panel.add(pnlChart);
		pnlChart.setLayout(new BorderLayout(0, 0));

		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame Main = (MainFrame)
						SwingUtilities.getWindowAncestor(panelDashboard.this);
						Main.menuClicked(Main.PanelReturned);
						
						Main.btnDashboard.setBackground(new Color(0, 200, 119));
						Main.btnCatalog.setBackground(new Color(0, 200, 119));
						Main.btnIssued.setBackground(new Color(0, 200, 119));
						Main.btnReturned.setBackground(new Color(1, 177, 104));
						Main.btnOverdue.setBackground(new Color(0, 200, 119));
						Main.btnArchive.setBackground(new Color(0, 200, 119));
						Main.btnData.setBackground(new Color(0, 200, 119));
						Main.btnTimelog.setBackground(new Color(0, 200, 119));
						Main.btnAcquisition.setBackground(new Color(0, 200, 119));
			}
		});
		panel_2.setBackground(new Color(100,100,100));
		panel_2.setBounds(36, 463, 185, 168);
		add(panel_2);
		panel_2.setLayout(null);
		
		lblReturnNum = new JLabel("0");
		lblReturnNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnNum.setForeground(Color.WHITE);
		lblReturnNum.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblReturnNum.setBounds(0, 0, 185, 49);
		panel_2.add(lblReturnNum);
		
		JLabel lblReturned = new JLabel("Returned");
		lblReturned.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturned.setForeground(Color.WHITE);
		lblReturned.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblReturned.setBounds(0, 34, 185, 49);
		panel_2.add(lblReturned);
		
		JLabel iconReturn = new JLabel("");
		iconReturn.setHorizontalAlignment(SwingConstants.CENTER);
		iconReturn.setBounds(53, 75, 83, 83);
		panel_2.add(iconReturn);
		Image imgReturn = new ImageIcon(this.getClass().getResource("/imgreturned.png")).getImage().getScaledInstance(83, 83, Image.SCALE_SMOOTH);
		iconReturn.setIcon(new ImageIcon(imgReturn));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame Main = (MainFrame)
						SwingUtilities.getWindowAncestor(panelDashboard.this);
						Main.menuClicked(Main.PanelIssued);
						
						Main.btnDashboard.setBackground(new Color(0, 200, 119));
						Main.btnCatalog.setBackground(new Color(0, 200, 119));
						Main.btnIssued.setBackground(new Color(1, 177, 104));
						Main.btnReturned.setBackground(new Color(0, 200, 119));
						Main.btnOverdue.setBackground(new Color(0, 200, 119));
						Main.btnArchive.setBackground(new Color(0, 200, 119));
						Main.btnData.setBackground(new Color(0, 200, 119));
						Main.btnTimelog.setBackground(new Color(0, 200, 119));
						Main.btnAcquisition.setBackground(new Color(0, 200, 119));
			}
		});
		panel_2_1.setBackground(SystemColor.windowBorder);
		panel_2_1.setBounds(430, 463, 185, 168);
		add(panel_2_1);
		panel_2_1.setLayout(null);
		
		lblIssuedNum = new JLabel("0");
		lblIssuedNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssuedNum.setForeground(Color.WHITE);
		lblIssuedNum.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblIssuedNum.setBounds(0, 0, 185, 49);
		panel_2_1.add(lblIssuedNum);
		
		JLabel lblIssued = new JLabel("Issued");
		lblIssued.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssued.setForeground(Color.WHITE);
		lblIssued.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIssued.setBounds(0, 34, 185, 49);
		panel_2_1.add(lblIssued);
		
		JLabel iconIssued = new JLabel("");
		iconIssued.setHorizontalAlignment(SwingConstants.CENTER);
		iconIssued.setBounds(51, 75, 83, 83);
		panel_2_1.add(iconIssued);
		Image imgIssued = new ImageIcon(this.getClass().getResource("/imgissued.png")).getImage().getScaledInstance(83, 83, Image.SCALE_SMOOTH);
		iconIssued.setIcon(new ImageIcon(imgIssued));
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame Main = (MainFrame)
						SwingUtilities.getWindowAncestor(panelDashboard.this);
						Main.menuClicked(Main.PanelArchive);
						
						Main.btnDashboard.setBackground(new Color(0, 200, 119));
						Main.btnCatalog.setBackground(new Color(0, 200, 119));
						Main.btnIssued.setBackground(new Color(0, 200, 119));
						Main.btnReturned.setBackground(new Color(0, 200, 119));
						Main.btnOverdue.setBackground(new Color(0, 200, 119));
						Main.btnArchive.setBackground(new Color(1, 177, 104));
						Main.btnData.setBackground(new Color(0, 200, 119));
						Main.btnTimelog.setBackground(new Color(0, 200, 119));
						Main.btnAcquisition.setBackground(new Color(0, 200, 119));
			}
		});
		panel_2_2.setBackground(new Color(0, 200, 119));
		panel_2_2.setBounds(630, 463, 185, 168);
		add(panel_2_2);
		panel_2_2.setLayout(null);
		
		lblArchiveNum = new JLabel("0");
		lblArchiveNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblArchiveNum.setForeground(Color.WHITE);
		lblArchiveNum.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblArchiveNum.setBounds(0, 0, 185, 49);
		panel_2_2.add(lblArchiveNum);
		
		JLabel lblArchive = new JLabel("Archived");
		lblArchive.setHorizontalAlignment(SwingConstants.CENTER);
		lblArchive.setForeground(Color.WHITE);
		lblArchive.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArchive.setBounds(0, 34, 185, 49);
		panel_2_2.add(lblArchive);
		
		JLabel iconArchive = new JLabel("");
		iconArchive.setHorizontalAlignment(SwingConstants.CENTER);
		iconArchive.setBounds(49, 75, 83, 83);
		panel_2_2.add(iconArchive);
		Image imgArchive = new ImageIcon(this.getClass().getResource("/imgarchived.png")).getImage().getScaledInstance(83, 83, Image.SCALE_SMOOTH);
		iconArchive.setIcon(new ImageIcon(imgArchive));
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame Main = (MainFrame)
						SwingUtilities.getWindowAncestor(panelDashboard.this);
						Main.menuClicked(Main.PanelOverdue);
						
						Main.btnDashboard.setBackground(new Color(0, 200, 119));
						Main.btnCatalog.setBackground(new Color(0, 200, 119));
						Main.btnIssued.setBackground(new Color(0, 200, 119));
						Main.btnReturned.setBackground(new Color(0, 200, 119));
						Main.btnOverdue.setBackground(new Color(1, 177, 104));
						Main.btnArchive.setBackground(new Color(0, 200, 119));
						Main.btnData.setBackground(new Color(0, 200, 119));
						Main.btnTimelog.setBackground(new Color(0, 200, 119));
						Main.btnAcquisition.setBackground(new Color(0, 200, 119));
			}
		});
		panel_2_3.setBackground(new Color(0, 200, 119));
		panel_2_3.setBounds(235, 463, 185, 168);
		add(panel_2_3);
		panel_2_3.setLayout(null);
		
		lblOverdueNum = new JLabel("0");
		lblOverdueNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverdueNum.setForeground(Color.WHITE);
		lblOverdueNum.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblOverdueNum.setBounds(0, 0, 185, 49);
		panel_2_3.add(lblOverdueNum);
		
		JLabel lblOverdue = new JLabel("Overdue");
		lblOverdue.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverdue.setForeground(Color.WHITE);
		lblOverdue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblOverdue.setBounds(0, 34, 185, 49);
		panel_2_3.add(lblOverdue);
		
		JLabel iconOver = new JLabel("");
		iconOver.setHorizontalAlignment(SwingConstants.CENTER);
		iconOver.setBounds(51, 75, 83, 83);
		panel_2_3.add(iconOver);
		Image imgOver = new ImageIcon(this.getClass().getResource("/imgoverdue.png")).getImage().getScaledInstance(83, 83, Image.SCALE_SMOOTH);
		iconOver.setIcon(new ImageIcon(imgOver));
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame Main = (MainFrame)
						SwingUtilities.getWindowAncestor(panelDashboard.this);
						Main.menuClicked(Main.PanelTimelog);
						
						Main.btnDashboard.setBackground(new Color(0, 200, 119));
						Main.btnCatalog.setBackground(new Color(0, 200, 119));
						Main.btnIssued.setBackground(new Color(0, 200, 119));
						Main.btnReturned.setBackground(new Color(0, 200, 119));
						Main.btnOverdue.setBackground(new Color(0, 200, 119));
						Main.btnArchive.setBackground(new Color(0, 200, 119));
						Main.btnData.setBackground(new Color(0, 200, 119));
						Main.btnTimelog.setBackground(new Color(1, 177, 104));
						Main.btnAcquisition.setBackground(new Color(0, 200, 119));
			}
		});
		panel_2_4.setBackground(SystemColor.windowBorder);
		panel_2_4.setBounds(36, 641, 505, 168);
		add(panel_2_4);
		panel_2_4.setLayout(null);
		
		JLabel lblStudentsTimeLog = new JLabel("Students' Time Log");
		lblStudentsTimeLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsTimeLog.setForeground(Color.WHITE);
		lblStudentsTimeLog.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblStudentsTimeLog.setBounds(55, 60, 302, 49);
		panel_2_4.add(lblStudentsTimeLog);
		
		JLabel iconTime = new JLabel("");
		iconTime.setHorizontalAlignment(SwingConstants.CENTER);
		iconTime.setBounds(367, 36, 100, 100);
		panel_2_4.add(iconTime);
		Image imgTime = new ImageIcon(this.getClass().getResource("/imgtimelog.png")).getImage().getScaledInstance(83, 83, Image.SCALE_SMOOTH);
		iconTime.setIcon(new ImageIcon(imgTime));
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame Main = (MainFrame)
						SwingUtilities.getWindowAncestor(panelDashboard.this);
						Main.menuClicked(Main.PanelAcquisition);
						
						Main.btnDashboard.setBackground(new Color(0, 200, 119));
						Main.btnCatalog.setBackground(new Color(0, 200, 119));
						Main.btnIssued.setBackground(new Color(0, 200, 119));
						Main.btnReturned.setBackground(new Color(0, 200, 119));
						Main.btnOverdue.setBackground(new Color(0, 200, 119));
						Main.btnArchive.setBackground(new Color(0, 200, 119));
						Main.btnData.setBackground(new Color(0, 200, 119));
						Main.btnTimelog.setBackground(new Color(0, 200, 119));
						Main.btnAcquisition.setBackground(new Color(1, 177, 104));
			}
		});
		panel_2_2_1.setBackground(new Color(0, 200, 119));
		panel_2_2_1.setBounds(551, 641, 263, 168);
		add(panel_2_2_1);
		panel_2_2_1.setLayout(null);
		
		JLabel lblAccessLog = new JLabel("Acquisition");
		lblAccessLog.setForeground(Color.WHITE);
		lblAccessLog.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAccessLog.setBounds(10, 56, 253, 49);
		panel_2_2_1.add(lblAccessLog);
		
		JLabel iconAccess = new JLabel("");
		iconAccess.setHorizontalAlignment(SwingConstants.CENTER);
		iconAccess.setBounds(173, 42, 80, 80);
		panel_2_2_1.add(iconAccess);
		iconAccess.setIcon(new ImageIcon(imgIssued));
	
		 timer = new Timer(1000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	//changing the number of books in Homepage
	                updateBookQuantitySum();
	                int sum = Integer.parseInt(bookQuantitySum);
	                lblBooksTotal.setText(Integer.toString(sum));
	               
	                //changing the number of students in Homepage
	                updateLabelStudentQuantity();
	                int sNum = Integer.parseInt(studentQuantity);
	                lblStudentsTotal.setText(Integer.toString(sNum));
	               
	              //changing the number of issued books in Homepage
	                updateLabelIssued();
	                int iNum = Integer.parseInt(issuedQuantity);
	                lblIssuedNum.setText(Integer.toString(iNum));
	               
	              //changing the number of overdue books in Homepage 
	                updateLabelOverdue();
	                int oNum = Integer.parseInt(overdueQuantity);
	                lblOverdueNum.setText(Integer.toString(oNum));
	                
	                updateLabelArchive();
	                int aNum = Integer.parseInt(archiveQuantity);
	                lblArchiveNum.setText(Integer.toString(aNum));
	                
	                updateLabelReturn();
	                int rNum = Integer.parseInt(returnQuantity);
	                lblReturnNum.setText(Integer.toString(rNum));
	                
	                showPieChart();
	            }
	        });
	        timer.start();

	}
	
}
