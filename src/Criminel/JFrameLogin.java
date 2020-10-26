package Criminel;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import Criminel.JFrameUserCrime; 
import Criminel.JframeUserUti;

public class JFrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass;
	private String url ="jdbc:mysql://localhost/java_crime ?useUnicode=true &useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC"  ;
	private String utilisateur = "root";
    private String motDePasse = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLogin frame = new JFrameLogin();
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
	public JFrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomPage = new JLabel("CONNEXION");
		lblNomPage.setLabelFor(this);
		lblNomPage.setBackground(Color.BLUE);
		lblNomPage.setForeground(Color.BLUE);
		lblNomPage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomPage.setBounds(130, 11, 127, 67);
		contentPane.add(lblNomPage);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 65, 341, 187);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUser = new JLabel("Nom d'utilisateur :");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUser.setBounds(98, 11, 117, 26);
		panel.add(lblUser);
		
		textUser = new JTextField();
		textUser.setBounds(66, 42, 171, 20);
		panel.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Mot de passe : ");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPass.setBounds(103, 73, 91, 14);
		panel.add(lblPass);
		
		textPass = new JTextField();
		textPass.setBounds(66, 98, 171, 20);
		panel.add(textPass);
		textPass.setColumns(10);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection =null; 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					connection = DriverManager.getConnection(url, utilisateur , motDePasse);
					PreparedStatement ps=connection.prepareStatement("Select * from login where Username ='"+textUser.getText()+"'and Password='"
					+textPass.getText().toString()+"'and admin='"+0+"'");
					ResultSet rs = ps.executeQuery();
					PreparedStatement pm=connection.prepareStatement("Select * from login where Username ='"+textUser.getText()+"'and Password='"
							+textPass.getText().toString()+"'and admin='"+1+"'");
							ResultSet rm = pm.executeQuery();
					if (rs.next())
						new JframeUserUti().setVisible(true);
					else 
						if (rm.next())
							new JFrameUserCrime().setVisible(true);
						else 
							JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect");
						
				}catch (Exception e1){
					e1.printStackTrace(); 
				}
			}
		});
		btnConnexion.setBackground(Color.BLUE);
		btnConnexion.setForeground(Color.BLACK);
		btnConnexion.setBounds(38, 138, 101, 23);
		panel.add(btnConnexion);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame JFrameLogin = new JFrame("Exit"); 
				if (JOptionPane.showConfirmDialog(JFrameLogin, "Etes-vous sûr de vouloir quitter ? ", "JFrameLogin",
						 JOptionPane.YES_NO_OPTION)==  JOptionPane.YES_NO_OPTION) {
					System.exit(0); 
				}
			}
		});
		btnFermer.setBackground(Color.BLUE);
		btnFermer.setForeground(Color.BLACK);
		btnFermer.setBounds(176, 138, 89, 23);
		panel.add(btnFermer);
		
		
		
	}
}
