package notepad;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import utilisateur.note;
import notepad.connexionNote;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import notepad.JframeList; 

public class JFramenote extends JFrame {

	private JPanel contentPane;
	private JTextField textTitre;
	
	private connexionNote note1 = new connexionNote();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramenote frame = new JFramenote();
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
	public JFramenote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 46, 373, 170);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTitre = new JLabel("Titre : ");
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.anchor = GridBagConstraints.WEST;
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
		panel.add(lblTitre, gbc_lblTitre);
		
		textTitre = new JTextField();
		GridBagConstraints gbc_textTitre = new GridBagConstraints();
		gbc_textTitre.gridwidth = 3;
		gbc_textTitre.insets = new Insets(0, 0, 5, 0);
		gbc_textTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTitre.gridx = 0;
		gbc_textTitre.gridy = 1;
		panel.add(textTitre, gbc_textTitre);
		textTitre.setColumns(10);
		
		JLabel lblContenu = new JLabel("Contenu : ");
		GridBagConstraints gbc_lblContenu = new GridBagConstraints();
		gbc_lblContenu.anchor = GridBagConstraints.WEST;
		gbc_lblContenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblContenu.gridx = 0;
		gbc_lblContenu.gridy = 2;
		panel.add(lblContenu, gbc_lblContenu);
		
		JTextPane textContenu = new JTextPane();
		GridBagConstraints gbc_textContenu = new GridBagConstraints();
		gbc_textContenu.insets = new Insets(0, 0, 5, 0);
		gbc_textContenu.gridheight = 2;
		gbc_textContenu.fill = GridBagConstraints.BOTH;
		gbc_textContenu.gridwidth = 3;
		gbc_textContenu.gridx = 0;
		gbc_textContenu.gridy = 3;
		panel.add(textContenu, gbc_textContenu);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					note note =new note();
					var v = textTitre.getText(); 
					var vp = textContenu.getText(); 
					if ((!v.isEmpty()) && (!vp.isEmpty()) ) {
						note.setTitre(textTitre.getText());
						note.setContenu(textContenu.getText());
						if(note1.ajouter(note)) {
							JOptionPane.showMessageDialog(contentPane, textContenu.getText());
							textContenu.setText("");	
						}
					} else { 
						JOptionPane.showMessageDialog(null, "Renseignez les champs"); 
						}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		GridBagConstraints gbc_btnEnregistrer = new GridBagConstraints();
		gbc_btnEnregistrer.anchor = GridBagConstraints.WEST;
		gbc_btnEnregistrer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnregistrer.gridx = 0;
		gbc_btnEnregistrer.gridy = 5;
		panel.add(btnEnregistrer, gbc_btnEnregistrer);
		
		JButton btnList = new JButton("Liste");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JframeList().setVisible(true);
			}
		});
		btnList.setBounds(308, 229, 89, 23);
		contentPane.add(btnList);
		
		
	}
}





 /*private JPanel contentPane;
  * public Jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
  */

