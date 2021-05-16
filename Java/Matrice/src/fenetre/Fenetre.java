package fenetre;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	public static int val1 = 1 ;
	public static int val2 = 1;
	public static int val3 = 1;
	public static int val4 = 1;
	
	public int getVal1() {
		return val1 ;
	}
	public int getVal2() {
		return val2 ;
	}
	public int getVal3() {
		return val3 ;
	}
	public int getVal4() {
		return val4 ;
	}
	
	private static final long serialVersionUID = -7145831902708934491L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JButton btnNext = new JButton("next");
	private Multiplication fen;

	/**
	 * Create the frame.
	 */
	public Fenetre() {
		setBackground(new Color(192, 192, 192));
		setResizable(false);
		this.setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Stephane\\Documents\\101621-1514241-operations-sur-les-matrices-et-les-integrales-et-java-swing\\image\\matix_pas.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel hzoneM1 = new JPanel();
		panel.add(hzoneM1);
		hzoneM1.setLayout(null);
		
		JLabel textMat1 = new JLabel("Matrice A");
		textMat1.setBounds(245, 68, 61, 18);
		textMat1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hzoneM1.add(textMat1);
		
		JPanel dZoneM1 = new JPanel();
		panel.add(dZoneM1);
		dZoneM1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		dZoneM1.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		JLabel textLineM1 = new JLabel("Lignes");
		textLineM1.setBounds(108, 23, 52, 14);
		
		JLabel textColM1 = new JLabel("Colonnes");
		textColM1.setBounds(411, 23, 64, 14);
		textColM1.setToolTipText("colonne text");
		panel_6.setLayout(null);
		panel_6.add(textLineM1);
		panel_6.add(textColM1);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(null);
/************************************************************************/
		JComboBox<Integer> comboBox = new JComboBox<>();
		comboBox.setToolTipText("Selectionnez le Nombres de Lignes de votre Matrice [0..8]");
		for(int i=1; i <=8 ;i++) {
			comboBox.addItem(i);
		}
		comboBox.setBounds(103, 11, 58, 22);
		panel_5.add(comboBox);
		comboBox.addActionListener(this :: comboBoxListener);
/*************************************************************************/		
		JComboBox<Integer> comboBox_1 = new JComboBox<Integer>();
		comboBox_1.setToolTipText("Selectionnez le Nombre de Colonnes de votre Matrice [0..8]");
		for(int i=1; i <=8 ;i++) {
			comboBox_1.addItem(i);
		}
		comboBox_1.setBounds(412, 11, 64, 22);
		panel_5.add(comboBox_1);
		comboBox_1.addActionListener(this :: comboBoxListener2);
/*************************************************************************/		
		JPanel splitPane1 = new JPanel();
		contentPane.add(splitPane1);
		splitPane1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel hZoneM2 = new JPanel();
		splitPane1.add(hZoneM2);
		hZoneM2.setLayout(null);
		
		JLabel textMat2 = new JLabel("Matrice B");
		textMat2.setBounds(250, 11, 60, 18);
		hZoneM2.add(textMat2);
		textMat2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
/*************************************************************************/	
		JComboBox<Integer> comboBox_2 = new JComboBox<Integer>();
		comboBox_2.setToolTipText("Selectionnez le Nombres de Lignes de votre Matrice [0..8]");
		for(int i=1; i <=8 ;i++) {
			comboBox_2.addItem(i);
		}
		comboBox_2.setBounds(104, 64, 58, 22);
		hZoneM2.add(comboBox_2);
		comboBox_2.addActionListener(this :: comboBoxListener3);
/*************************************************************************/		
		JComboBox<Integer> comboBox_3 = new JComboBox<Integer>();
		comboBox_3.setToolTipText("Selectionnez le Nombre de Colonnes de votre Matrice [0..8]");
		for(int i=1; i <=8 ;i++) {
			comboBox_3.addItem(i);
		}
		comboBox_3.setBounds(412, 64, 64, 22);
		hZoneM2.add(comboBox_3);
		comboBox_3.addActionListener(this :: comboBoxListener4);
/*************************************************************************/		
		JLabel textLineM1_1 = new JLabel("Lignes");
		textLineM1_1.setBounds(110, 39, 52, 14);
		hZoneM2.add(textLineM1_1);
		
		JLabel textColM1_1 = new JLabel("Colonnes");
		textColM1_1.setToolTipText("colonne text");
		textColM1_1.setBounds(412, 39, 64, 14);
		hZoneM2.add(textColM1_1);
		
		JPanel panel_3 = new JPanel();
		splitPane1.add(panel_3);
		panel_3.setLayout(null);
		
		btnNext.addActionListener(this :: btnNextListener );
		btnNext.setBounds(478, 63, 64, 23);
		panel_3.add(btnNext);	
		btnNext.setEnabled(true);

	}
	private void btnNextListener(ActionEvent event) {
		fen = new Multiplication();
		fen.setExtendedState(MAXIMIZED_BOTH);
		
	}
	@SuppressWarnings("unchecked")
	private void comboBoxListener(ActionEvent evt) {
		Fenetre.val1 = (int)((JComboBox<Integer>)evt.getSource()).getSelectedItem();
	}
	@SuppressWarnings("unchecked")
	private void comboBoxListener2(ActionEvent evt) {
		Fenetre.val2 = (int)((JComboBox<Integer>)evt.getSource()).getSelectedItem();
		if(val2 == val3) {
			btnNext.setEnabled(true);
		}else {
			btnNext.setEnabled(false);
		}
	}
	@SuppressWarnings("unchecked")
	private void comboBoxListener3(ActionEvent evt) {
		Fenetre.val3 = (int)((JComboBox<Integer>)evt.getSource()).getSelectedItem();
		if(val2 == val3) {
			btnNext.setEnabled(true);
		}else {
			btnNext.setEnabled(false);
		}
	}
	@SuppressWarnings("unchecked")
	private void comboBoxListener4(ActionEvent evt) {
		Fenetre.val4 = (int)((JComboBox<Integer>)evt.getSource()).getSelectedItem();
	}
	
}

