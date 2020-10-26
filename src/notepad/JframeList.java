package notepad;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import utilisateur.user;

import javax.swing.JTable;
import notepad.connexionNote;
import utilisateur.note;

public class JframeList extends JFrame {

	private JPanel contentPane;
	private JTable tableNotes;
	private connexionNote note1 = new connexionNote(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeList frame = new JframeList();
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
	public JframeList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tableNotes = new JTable();
		contentPane.add(tableNotes, BorderLayout.CENTER);
		remplir(); 
	}

	private void remplir() {
		DefaultTableModel dtm=new DefaultTableModel();
		// DefaulttableModel classe graphique colonnes et lignes 
		dtm.addColumn("titre");
		dtm.addColumn("contenu");
		for(note note : note1.listerNotes()) {
			dtm.addRow(new Object[] { note.getTitre(),note.getContenu() });
		}
		this.tableNotes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titre", "Contenu"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}
}
