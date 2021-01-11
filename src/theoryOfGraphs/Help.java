package theoryOfGraphs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Help {

	private JFrame frame;
	private static JOptionPane op =new JOptionPane(); 
	

	/**
	 * Launch the application.
	 */
	public static void Help() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help window = new Help();
					window.frame.setVisible(true);
					
					String msg ="Cette application sert à utiliser des algorithmes\n pour analyser le graphe";
					JLabel label = new JLabel(msg);
					label.setFont(new Font("Arial", Font.PLAIN, 18));
					JOptionPane.showMessageDialog(null , label,"Bienvenue",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Help() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1191, 648);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JOptionPane.showMessageDialog(null , frame,"Cette application sert à utiliser des algorithmes pour analyser le diagramme",JOptionPane.YES_NO_CANCEL_OPTION);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(Color.GRAY);
		panel.setBounds(32, 143, 357, 379);
		frame.getContentPane().add(panel);
		
		Graph graph = new Graph();
		graph.setBounds(0, 0, 0, 0);
		panel.add(graph);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setText("Pour dessiner un sommet un simple clique gauche ");
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Cambria", Font.PLAIN, 16));
		textArea_1.setBounds(40, 47, 296, 45);
		panel.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setText("Pour dessiner un arc il faut glisser votre     sourie par clique gauche");
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Cambria", Font.PLAIN, 16));
		textArea_2.setBounds(40, 122, 296, 45);
		panel.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setText("Pour changer la position des sommets        glisser  votre sourie par clique droite");
		textArea_3.setLineWrap(true);
		textArea_3.setFont(new Font("Cambria", Font.PLAIN, 16));
		textArea_3.setBounds(40, 196, 296, 45);
		panel.add(textArea_3);
		
		JRadioButton radioButton = new JRadioButton("Non orient\u00E9");
		radioButton.setSelected(true);
		radioButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		radioButton.setBackground(Color.LIGHT_GRAY);
		radioButton.setBounds(44, 55, 109, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Orient\u00E9");
		radioButton_1.setSelected(false);
		radioButton_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		radioButton_1.setBackground(Color.LIGHT_GRAY);
		radioButton_1.setBounds(174, 55, 109, 23);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Ponder\u00E9");
		radioButton_2.setSelected(true);
		radioButton_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		radioButton_2.setBackground(Color.LIGHT_GRAY);
		radioButton_2.setBounds(292, 55, 109, 23);
		frame.getContentPane().add(radioButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(218, 165, 32));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		panel_1.setBounds(492, 80, 398, 248);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnAffichageDeLa = new JTextPane();
		txtpnAffichageDeLa.setEditable(false);
		txtpnAffichageDeLa.setBackground(new Color(218, 165, 32));
		txtpnAffichageDeLa.setFont(new Font("Cambria", Font.PLAIN, 17));
		txtpnAffichageDeLa.setText("Affichage de la matrice");
		txtpnAffichageDeLa.setBounds(119, 100, 172, 37);
		panel_1.add(txtpnAffichageDeLa);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(230, 230, 250), 3, true));
		panel_3.setBackground(new Color(255, 245, 238));
		panel_3.setBounds(925, 89, 240, 433);
		frame.getContentPane().add(panel_3);
		
		JButton button_9 = new JButton("BFS");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p>Explorer un nœud source, puis ses successeurs,<br> puis les successeurs non explorés des successeurs.<p><html>";
				JLabel label = new JLabel(msg);
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"BFS",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
	
			}
		});
		button_9.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_9.setBounds(30, 22, 180, 23);
		panel_3.add(button_9);
		
		JButton button_10 = new JButton("DFS");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p>Explore le premier chemin de ses successeurs <br>jusqu'au moment ou le sommet n'a plus de successeurs non visités.<br> Ensuite il remonte d'un niveau pour vérifier s'il<br> ne reste pas de sommets à visiter.</p></html>";
				JLabel label = new JLabel(msg);
				
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"DFS",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
	
			}
		});
		button_10.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_10.setBounds(30, 67, 180, 23);
		panel_3.add(button_10);
		
		JButton button_11 = new JButton("Wareshell");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p> Cette algorithme permet de trouver le plus court chemin entre toute paire de sommets.</p></html>";
				JLabel label = new JLabel(msg);
				
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Wareshell",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
	
			}
		});
		button_11.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_11.setBounds(30, 112, 180, 23);
		panel_3.add(button_11);
		
		JButton button_12 = new JButton("Prim");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p> Cette algorithme calcule un arbre couvrant minimal dans un graphe connexe<br> valué et non orienté.</p></html>";
				JLabel label = new JLabel(msg);
				
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Prim",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
	
			}
		});
		button_12.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_12.setBounds(30, 157, 180, 23);
		panel_3.add(button_12);
		
		JButton button_13 = new JButton("Dijkstra");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p> Cette algorithme calcule des plus courts chemins<br> à partir d'une source vers tous les autres sommets <br>dans un graphe orienté pondéré par des réels positifs.</p></html>";
				JLabel label = new JLabel(msg);
				
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Prim",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
	
			}
		});
		button_13.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_13.setBounds(30, 247, 180, 23);
		panel_3.add(button_13);
		
		JButton button_14 = new JButton("FordFulkerson");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p>  Un algorithme pour le problème du flot maximum.</p></html>";
				JLabel label = new JLabel(msg);
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Matrice",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));

			}
		});
		button_14.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_14.setBounds(30, 337, 180, 23);
		panel_3.add(button_14);
		
		JButton button_15 = new JButton("Welch et Powel");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p> La coloration de graphe consiste à attribuer une couleur à chacun<br> de ses sommets de manière que deux sommets reliés par<br> une arête soient de couleur différente.</p></html>";
				JLabel label = new JLabel(msg);
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Matrice",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));

			}
		});
		button_15.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_15.setBounds(30, 382, 180, 23);
		panel_3.add(button_15);
		
		JButton button_16 = new JButton("Bellman-Ford");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p> Un algorithme qui calcule des plus courts chemins depuis un sommet<br> source donné dans un graphe orienté pondéré.</p></html>";
				JLabel label = new JLabel(msg);
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Matrice",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));

			}
		});
		button_16.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_16.setBounds(30, 292, 180, 23);
		panel_3.add(button_16);
		
		JButton button_17 = new JButton("Kruskal");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="<html><p>  un algorithme de recherche d'arbre recouvrant de poids minimum (ARPM)<br> ou arbre couvrant minimum (ACM) dans un graphe connexe<br> non-orienté et pondéré.</p></html>";
				JLabel label = new JLabel(msg);
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Matrice",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));

			}
			
		});
		button_17.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button_17.setBounds(30, 202, 180, 23);
		panel_3.add(button_17);
		
		JButton button_19 = new JButton(">>");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg ="Transformer le graphe en matrice";
				JLabel label = new JLabel(msg);
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Matrice",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
	
			}
		});
		button_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_19.setBounds(408, 245, 56, 23);
		frame.getContentPane().add(button_19);
		
		JButton button_21 = new JButton("Dessiner");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="Activation du panel pour dessiner le graphe";
				JLabel label = new JLabel(msg);
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Dessiner",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
	
			}
		});
		button_21.setFont(new Font("Arial", Font.PLAIN, 15));
		button_21.setBounds(197, 547, 109, 23);
		frame.getContentPane().add(button_21);
		
		JButton button_22 = new JButton("Recommencer");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="Inistialiser le graph";
				JLabel label = new JLabel(msg);
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null , label,"Initialiser",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("TG.png")));
	
			}
		});
		button_22.setFont(new Font("Arial", Font.PLAIN, 15));
		button_22.setBounds(308, 90, 146, 23);
		frame.getContentPane().add(button_22);
		
		JLabel label = new JLabel("D\u00E9tail algorithme :");
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBounds(490, 339, 208, 23);
		frame.getContentPane().add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(205, 133, 63));
		panel_2.setBounds(490, 373, 400, 200);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane txtpnAffichageRsusltasDes = new JTextPane();
		txtpnAffichageRsusltasDes.setEditable(false);
		txtpnAffichageRsusltasDes.setText("Affichage r\u00E9susltas des algorithmes");
		txtpnAffichageRsusltasDes.setFont(new Font("Cambria", Font.PLAIN, 17));
		txtpnAffichageRsusltasDes.setBackground(new Color(205, 133, 63));
		txtpnAffichageRsusltasDes.setBounds(72, 87, 284, 41);
		panel_2.add(txtpnAffichageRsusltasDes);
		
		JTextPane txtpnLesAlgorithmes = new JTextPane();
		txtpnLesAlgorithmes.setEditable(false);
		txtpnLesAlgorithmes.setText("les algorithmes");
		txtpnLesAlgorithmes.setFont(new Font("Cambria", Font.PLAIN, 17));
		txtpnLesAlgorithmes.setBackground(new Color(255, 235, 205));
		txtpnLesAlgorithmes.setBounds(960, 41, 124, 37);
		frame.getContentPane().add(txtpnLesAlgorithmes);
		
		JTextPane txtpnChoisirTypeDe = new JTextPane();
		txtpnChoisirTypeDe.setEditable(false);
		txtpnChoisirTypeDe.setText("Choisir type de Graphe");
		txtpnChoisirTypeDe.setFont(new Font("Cambria", Font.PLAIN, 17));
		txtpnChoisirTypeDe.setBackground(new Color(244, 164, 96));
		txtpnChoisirTypeDe.setBounds(111, 11, 172, 37);
		frame.getContentPane().add(txtpnChoisirTypeDe);
		
		JLabel lblMatriceDadjacence = new JLabel("Matrice adjacente");
		lblMatriceDadjacence.setFont(new Font("Arial", Font.BOLD, 15));
		lblMatriceDadjacence.setBounds(492, 41, 208, 23);
		frame.getContentPane().add(lblMatriceDadjacence);
		
		JTextPane txtpnCliquerSurLes = new JTextPane();
		txtpnCliquerSurLes.setText("Cliquer sur les buttons pour plus d'information");
		txtpnCliquerSurLes.setFont(new Font("Cambria", Font.BOLD, 17));
		txtpnCliquerSurLes.setEditable(false);
		txtpnCliquerSurLes.setBackground(new Color(128, 128, 0));
		txtpnCliquerSurLes.setBounds(494, 0, 428, 37);
		frame.getContentPane().add(txtpnCliquerSurLes);
	}
}
