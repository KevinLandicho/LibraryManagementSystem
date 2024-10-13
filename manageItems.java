import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class manageItems extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					items frame = new items();
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
	public manageItems() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Item");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 157, 43);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Books", "Article", "Magazine", "Furnitures", "Newspaper"}));
		comboBox.setBounds(31, 63, 260, 33);
		contentPane.add(comboBox);
		
		JPanel btnCancel = new JPanel();
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageItems.this.dispose();
				
			}
		});
		btnCancel.setBackground(new Color(200,200,200));
		btnCancel.setBounds(31, 130, 74, 26);
		contentPane.add(btnCancel);
		btnCancel.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Cancel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 74, 26);
		btnCancel.add(lblNewLabel_1);
		
		JPanel btnSelect = new JPanel();
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int item = comboBox.getSelectedIndex();
				if (item==0) {
					manageBook book = new manageBook();
					book.show();
				}
				else if (item==1){
					manageArticle article = new manageArticle();
					article.show();
					
				}else if (item==2){
					manageMagazine magazine = new manageMagazine();
					magazine.show();
				}else if (item==3){
					manageFurniture furniture = new manageFurniture();
					furniture.show();
				}else if (item==4){
					manageNewspaper newspaper = new manageNewspaper();
					newspaper.show();
				}
				manageItems.this.dispose();
			}
		});
		btnSelect.setBackground(new Color(0, 200, 119));
		btnSelect.setBounds(217, 130, 74, 26);
		contentPane.add(btnSelect);
		btnSelect.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Select");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(0, 0, 74, 26);
		btnSelect.add(lblNewLabel_1_1);
	}
}
