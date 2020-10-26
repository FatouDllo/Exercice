package Criminel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import utilisateur.user;

import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import Criminel.connexion;
import utilisateur.user;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent; 

public class JframeUserUti extends JFrame {

	private JPanel contentPane;
	private JTable tableUsers;
	private connexion userDao = new connexion(); 
	private JButton btnRecherche;
	private JTextField textFieldRecherche;
	private JButton btnRetour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeUserUti frame = new JframeUserUti();
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
	public JframeUserUti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableUsers = new JTable();
		tableUsers.setBounds(10, 11, 495, 219);
		contentPane.add(tableUsers);
		
		JLabel lblRecherche = new JLabel("Recherche par : ");
		lblRecherche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRecherche.setBounds(30, 272, 141, 14);
		contentPane.add(lblRecherche);
		
		btnRecherche = new JButton("Rechercher");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if (textFieldRecherche.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"S'il vous plaît entrer quelque chose ");
				}else {
						if (select_rech.getSelectedItem().equals("id")) {
							ps=conection.querySelectALL("select from criminels like id=%'"+textFieldRecherche+"%'"));
						}
				}*/
					
			}
		});
		btnRecherche.setBounds(46, 326, 113, 23);
		contentPane.add(btnRecherche);
		
		JComboBox select_rech = new JComboBox();
		select_rech.setForeground(new Color(0, 0, 0));
		select_rech.setModel(new DefaultComboBoxModel(new String[] {"Id ", "Nom ", "Pr\u00E9nom"}));
		select_rech.setBounds(207, 270, 107, 22);
		contentPane.add(select_rech);
		
		textFieldRecherche = new JTextField();
		textFieldRecherche.setBounds(207, 327, 96, 20);
		contentPane.add(textFieldRecherche);
		textFieldRecherche.setColumns(10);
		
		
		
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFrameLogin().setVisible(true);
			}
		});
		btnRetour.setBounds(417, 352, 89, 23);
		contentPane.add(btnRetour);
		remplir(); 
	}
	
	private void remplir() {
		DefaultTableModel dtm=new DefaultTableModel();
		// DefaulttableModel classe graphique colonnes et lignes 
		dtm.addColumn("ID");
		dtm.addColumn("Nom");
		dtm.addColumn("Prenom");
		dtm.addColumn("Age");
		dtm.addColumn("Crime");
		dtm.addColumn("AnneeEmprisonnement");
		for(user user : userDao.listerUsers()) {
			dtm.addRow(new Object[] {user.getId(), user.getNom(), user.getPrenom(), user.getAge(), user.getCrime(), 
					user.getAnneeEmprisonnement() });
		}
		this.tableUsers.setModel(dtm);
	}
}

