package theoryOfGraphs;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;


import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;




public class TG {

	private JFrame frmThorieDesGraphes;
	
	
	JPanel pn_mat = new JPanel();
	JTextArea textArea = new JTextArea();
	JButton btnBFS = new JButton("BFS");
	JButton btnDFS = new JButton("DFS");
	JButton btnPrim = new JButton("Prim");
	JButton btnDijkstra = new JButton("Dijkstra");
	JButton btnWareshall = new JButton("Wareshell");
	JButton btnMarquage = new JButton("FordFulkerson");
	JButton btncoloriage = new JButton("Welch et Powel");
	JButton btnBellmanFord = new JButton("Bellman-Ford");
	JButton btnKruskal = new JButton("Kruskal");
	
	String BFSContent="";
	String DFSContent="";
	String PrimContent="";
	String DijkstraContent="";
	String WaresallContent="";
	String MarquageContent="";
	String ColoriageContent="";
	String BellmanFordContent="";
	String KruskalContent="";
	
	JLabel lblNbrVertex = new JLabel("0");
	JLabel lblNbEdgets = new JLabel("0");
	
	String PDF_RAPPORT=" ";
	
	Vertex from = new Vertex();
	Vertex to = new Vertex();
	Point pos = new Point(1,1); 
	static boolean press = false;
	Graph graph = new Graph();	
	int costt;
	boolean value =false;
	MatrixAdj m=  new MatrixAdj(graph);

	ArrayList<JTextField> fields = new ArrayList<JTextField>();
	String details ="";
	int[][] cost;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TG window = new TG();
					window.frmThorieDesGraphes.setVisible(true);
					
				//	window.graph.getComponents();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TG() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThorieDesGraphes = new JFrame();
		frmThorieDesGraphes.setFont(new Font("Cambria", Font.BOLD, 16));
		frmThorieDesGraphes.setForeground(new Color(205, 133, 63));
		frmThorieDesGraphes.setTitle("Th\u00E9orie des graphes");
		frmThorieDesGraphes.setIconImage(Toolkit.getDefaultToolkit().getImage(TG.class.getResource("/img/TGLogo.png")));
		frmThorieDesGraphes.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmThorieDesGraphes.setBounds(100, 100, 1140, 719);
		frmThorieDesGraphes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graph.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		
		
		
		JRadioButton rdbtnDirected = new JRadioButton("Orient\u00E9");
		rdbtnDirected.setBackground(Color.LIGHT_GRAY);
		rdbtnDirected.setFont(new Font("Cambria", Font.BOLD, 17));
		rdbtnDirected.setSelected(false);
		
		JRadioButton rdbtnNotDirected = new JRadioButton("Non orient\u00E9");
		rdbtnNotDirected.setBackground(Color.LIGHT_GRAY);
		rdbtnNotDirected.setFont(new Font("Cambria", Font.BOLD, 17));
		rdbtnNotDirected.setSelected(true);
		rdbtnNotDirected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNotDirected.isSelected() && graph.isWheighted())
				{
					rdbtnDirected.setSelected(false);
					graph.setDirected(false);
					 btnWareshall.setEnabled(true);
					 btnPrim.setEnabled(true); 
					 btnKruskal.setEnabled(true); 
					 btnDijkstra.setEnabled(true); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(true);
					 btnBellmanFord.setEnabled(false); 
					
					clear();
				}else if(!rdbtnNotDirected.isSelected() && !graph.isWheighted()){
					rdbtnDirected.setSelected(true);
					graph.setDirected(true);
					 btnWareshall.setEnabled(true);
					 btnPrim.setEnabled(false);
					 btnKruskal.setEnabled(false);
					 btnDijkstra.setEnabled(false); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(false);
					 btnBellmanFord.setEnabled(false);
					 clear();
				}	 else if(rdbtnNotDirected.isSelected() &&!graph.isWheighted())
				{
					rdbtnDirected.setSelected(false);
					graph.setDirected(false);
					btnWareshall.setEnabled(true);
					 btnPrim.setEnabled(false);
					 btnKruskal.setEnabled(false);
					 btnDijkstra.setEnabled(false); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(false);
					 btnBellmanFord.setEnabled(false);
					 clear();
				}else if(!rdbtnNotDirected.isSelected() && graph.isWheighted())
				{
					rdbtnDirected.setSelected(true);
					graph.setDirected(true);
					btnWareshall.setEnabled(true);
					 btnPrim.setEnabled(false);
					 btnKruskal.setEnabled(true);
					 btnDijkstra.setEnabled(true); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(false);
					 btnBellmanFord.setEnabled(true);
					 clear();
					
				}
					
				}
			});
	
		
		
		rdbtnDirected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDirected.isSelected() && graph.isWheighted())
				{
					rdbtnNotDirected.setSelected(false);
					graph.setDirected(true);
					 btnWareshall.setEnabled(true);
					 btnPrim.setEnabled(false);
					 btnKruskal.setEnabled(false);
					 btnDijkstra.setEnabled(true); 
					 btnMarquage.setEnabled(true); 
					 btncoloriage.setEnabled(false);
					 btnBellmanFord.setEnabled(true); 
				
				}else if( !rdbtnDirected.isSelected() && graph.isWheighted()) {
					rdbtnNotDirected.setSelected(true);
					graph.setDirected(false);
					 btnWareshall.setEnabled(true);
					 btnPrim.setEnabled(true); 
					 btnKruskal.setEnabled(true);
					 btnDijkstra.setEnabled(true); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(true);
					 btnBellmanFord.setEnabled(false); 
				
				}else if(rdbtnDirected.isSelected() && !graph.isWheighted())
				{
					rdbtnNotDirected.setSelected(false);
					graph.setDirected(true);
					 btnWareshall.setEnabled(true);
					 btnPrim.setEnabled(false);
					 btnKruskal.setEnabled(false);
					 btnDijkstra.setEnabled(false); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(false);
					 btnBellmanFord.setEnabled(false); 
				}else if(!rdbtnDirected.isSelected() && !graph.isWheighted())
				{
					rdbtnNotDirected.setSelected(true);
					graph.setDirected(false);
					 btnWareshall.setEnabled(true);
					 btnPrim.setEnabled(false);
					 btnKruskal.setEnabled(false);
					 btnDijkstra.setEnabled(false); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(false);
					 btnBellmanFord.setEnabled(false); 
				}
				clear();
			}});
		
		JRadioButton rdbtnweighted = new JRadioButton("Ponder\u00E9");
		rdbtnweighted.setBackground(Color.LIGHT_GRAY);
		rdbtnweighted.setFont(new Font("Cambria", Font.BOLD, 17));
		rdbtnweighted.setSelected(true);
		rdbtnweighted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnweighted.isSelected() && graph.isDirected())
				{
					graph.setWheighted(true);
					 btnPrim.setEnabled(false); 
					 btnKruskal.setEnabled(false);
					 btnDijkstra.setEnabled(false); 
					 btnMarquage.setEnabled(true); 
					 btncoloriage.setEnabled(false);
					 btnBellmanFord.setEnabled(true); 
					clear();
				}else if(rdbtnweighted.isSelected() && !graph.isDirected()){
					graph.setWheighted(true);
					 btnPrim.setEnabled(true); 
					 btnKruskal.setEnabled(true);
					 btnDijkstra.setEnabled(true); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(true);
					 btnBellmanFord.setEnabled(false); 
					clear();
				}else if(!rdbtnweighted.isSelected() && graph.isDirected())
				{
					graph.setWheighted(false);
					 btnPrim.setEnabled(false); 
					 btnKruskal.setEnabled(false);
					 btnDijkstra.setEnabled(false); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(false);
					 btnBellmanFord.setEnabled(false); 
					clear();
				}else if(!rdbtnweighted.isSelected() && !graph.isDirected()){
					graph.setWheighted(false);
					 btnPrim.setEnabled(false); 
					 btnKruskal.setEnabled(false);
					 btnDijkstra.setEnabled(false); 
					 btnMarquage.setEnabled(false); 
					 btncoloriage.setEnabled(true);
					 btnBellmanFord.setEnabled(false); 
					clear();
				}
			}});
	//	pn_mat.setBounds(454, 13, 304, 250);
		pn_mat.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
	
		
	//	pn_mat.setBackground(new Color(255, 255, 255));
		frmThorieDesGraphes.getContentPane().add(pn_mat);
		lblNbrVertex.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNbEdgets.setFont(new Font("Cambria", Font.BOLD, 16));
		
		
		JButton btn_grToMatrix = new JButton(">>");
		btn_grToMatrix.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_grToMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!graph.Vertice.isEmpty())
				{	
					    lblNbrVertex.setText(String.valueOf(graph.Vertice.size()));
						lblNbEdgets.setText(String.valueOf(graph.Edgets.size()));
						 m = new MatrixAdj(graph);
						int [][] res =m.cMatrix();
						graph.MatrixAdj=res;
						System.out.println(" "+m.mat[1][1]);
						for(int i=0; i<res.length;i++)
						{
							JLabel [] lbl =new JLabel[res.length];
							lbl [i]=new JLabel(String.valueOf(i+1));
							lbl [i].setBounds(2,27+i*30, 30, 30);
							lbl [i].setBackground(Color.GRAY);
							
							pn_mat.add(lbl [i]);
								
							for(int j=0; j<res.length;j++)
							{
							//	JTextField [] textField1 =new JTextField[res.length];
								lbl [i]=new JLabel(String.valueOf(j+1));
								lbl [i].setBounds(33+j*50,2, 30, 30);
								lbl [i].setBackground(Color.GRAY);
								
								pn_mat.add(lbl [i]);
		
								System.out.print(" "+res[i][j]);
								JTextField [] textFieldW =new JTextField[res.length];
								textFieldW [j]=new JTextField(String.valueOf(res[i][j]));
								textFieldW [j].setBounds(33+j*50,27+i*30, 30, 30);
								textFieldW [j].setColumns(50+j*20);
								
								pn_mat.add(textFieldW [j]);
								pn_mat.repaint();	
							}
							System.out.println("\n");
						}//
						cost=graph.costMatrix(res);	
//						System.out.println("*******************cost**************");
//						for(int i=0;i<cost.length;i++)
//						{
//							
//							for(int j= 0;j<cost.length;j++)
//							{
//								System.out.print("\t\t\t"+cost[i][j]+"\t\t\t\t");
//							}
//							System.out.print("\n");
//						}
			}else {
				String msg ="Il faut dessiner le graphe";
            	JLabel label = new JLabel(msg);
            	label = new JLabel(msg);
            	label.setFont(new Font("Arial", Font.PLAIN, 12));
            	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
			
			}
			}
		});
		
		graph.setBackground(Color.GRAY);
		graph.setLayout(null);
		
		JButton btn_D = new JButton("Dessiner");
		btn_D.setIcon(new ImageIcon(TG.class.getResource("/img/draw.png")));
		btn_D.setFont(new Font("Cambria", Font.BOLD, 16));
		btn_D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					drwVertex(graph);		
					drwEdegts(graph);
	
			}
		});
		JLabel lblVertex = new JLabel("Sommets |V|");
		lblVertex.setIcon(new ImageIcon(TG.class.getResource("/img/vertex.png")));
		lblVertex.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JLabel lblEdgets = new JLabel("Arr\u00EAts |E|");
		lblEdgets.setIcon(new ImageIcon(TG.class.getResource("/img/edget.png")));
		lblEdgets.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JButton btn_clear = new JButton("Recommencer");
		btn_clear.setIcon(new ImageIcon(TG.class.getResource("/img/recommancer.jpg")));
		btn_clear.setFont(new Font("Cambria", Font.BOLD, 15));
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(230, 230, 250), 3, true));
		panel.setBackground(new Color(255, 245, 238));
		panel.setLayout(null);
		
//		JLabel lbl = new JLabel();
//		lbl.setBounds(158, 15, 0, 0);
//        pnTrace.add(lbl);
		
		btnBFS.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnBFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g =graph.getGraphics();
				if(graph.Vertice.size()>0){
					
					 m = new MatrixAdj(graph);
					graph.MatrixAdj=m.cMatrix();
                    BFS bfs=new BFS(graph.current_vertex,graph.Vertice, graph.MatrixAdj, g);
                    BFS bfsPdf=new BFS(graph.current_vertex,graph.Vertice, graph.MatrixAdj, g);
                    try{
                    	
                        int start=Integer.parseInt(JOptionPane.showInputDialog("Enter le sommet de départ :"));
                        if(1<=start && start<=graph.current_vertex) 
                        details+="\n*******************************BFS***************************\n";
                        details+=bfs.bfs(start-1);
                        BFSContent=bfsPdf.bfs(start-1);
                        textArea.setText(details);
                        System.out.println(details);
                       
                        
                    }catch(Exception ev){                                        
                    	String msg ="Il faut donner le sommet de départ";
                    	JLabel label = new JLabel(msg);
                    	label = new JLabel(msg);
                    	label.setFont(new Font("Arial", Font.PLAIN, 12));
                    	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/questionMark.png")));
    				
                    }
                }else
                	{
                	String msg ="Il faut dessiner le graphe";
                	JLabel label = new JLabel(msg);
                	label = new JLabel(msg);
                	label.setFont(new Font("Arial", Font.PLAIN, 12));
                	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
				
                	}
				
                ;
			}
			});	
		btnBFS.setBounds(30, 22, 180, 23);
		panel.add(btnBFS);
		
		
		btnDFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphics g =graph.getGraphics();
				if(graph.Vertice.size()>0){
					
					 m = new MatrixAdj(graph);
					graph.MatrixAdj=m.cMatrix();
                    DFS dfs=new DFS(graph.current_vertex,graph.Vertice, graph.MatrixAdj, g);
                    DFS dfsPdf=new DFS(graph.current_vertex,graph.Vertice, graph.MatrixAdj, g);
                    try{
                    	
                        int start=Integer.parseInt(JOptionPane.showInputDialog("Enter le sommet de départ :"));
                        if(1<=start && start<=graph.current_vertex)
                        details+="\n*****************************DFS********************************\n";
                        details+=dfs.dfs(start-1);
                        DFSContent = dfsPdf.dfs(start-1);
                        textArea.setText(details);
                        System.out.println(details);
                        
                    }catch(Exception e){                                        
                    	String msg ="Il faut donner le sommet de départ";
                    	JLabel label = new JLabel(msg);
                    	label = new JLabel(msg);
                    	label.setFont(new Font("Arial", Font.PLAIN, 12));
                    	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/questionMark.png")));
    				
                    }
                }else
                	{
                	String msg ="Il faut dessiner le graphe";
                	JLabel label = new JLabel(msg);
                	label = new JLabel(msg);
                	label.setFont(new Font("Arial", Font.PLAIN, 12));
                	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
				
                	};
			}
		});
		btnDFS.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnDFS.setBounds(30, 67, 180, 23);
		panel.add(btnDFS);
		
		
		btnWareshall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g =graph.getGraphics();
				if(graph.Vertice.size()>0){
					
					 m = new MatrixAdj(graph);
					graph.MatrixAdj=m.cMatrix();
					cost=graph.costMatrix(graph.MatrixAdj);
                    Wareshall warshall=new Wareshall(graph.Vertice.size(),graph.Vertice, graph.MatrixAdj,cost, g);
                    Wareshall warshallPdf=new Wareshall(graph.Vertice.size(),graph.Vertice, graph.MatrixAdj,cost, g);
                    WaresallContent =warshallPdf.floydWarshall();
                    details+="\n***************************Wareshall*****************************\n";
                    details+=warshall.floydWarshall();
                    textArea.setText(details);
                    System.out.println(details);
                    
                    }else
                    {
                    	String msg ="Il faut dessiner le graphe";
                    	JLabel label = new JLabel(msg);
                    	label = new JLabel(msg);
                    	label.setFont(new Font("Arial", Font.PLAIN, 12));
                    	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
    				
                    } ;
			}
		});
		btnWareshall.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnWareshall.setBounds(30, 112, 180, 23);
		panel.add(btnWareshall);
		
		
		btnPrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g =graph.getGraphics();
				if(graph.Vertice.size()>0){
                    if(rdbtnNotDirected.isSelected()){
                    	 m = new MatrixAdj(graph);
                    	graph.MatrixAdj=m.cMatrix();
                    	cost=graph.costMatrix(graph.MatrixAdj);
                    	
                        Prim prim=new Prim(graph.current_vertex,graph.Vertice, graph.MatrixAdj,cost, g);
                        Prim primPdf=new Prim(graph.current_vertex,graph.Vertice, graph.MatrixAdj,cost, g);
                        details+="\n**************************Prim*********************************\n";
                        details+=prim.primMST();
                        PrimContent=primPdf.primMST();
                        textArea.setText(details);
                        System.out.println(details);
                       
                    }else
                    	JOptionPane.showMessageDialog(null, "il faut donner un Graph Non-orienté !", "Error", JOptionPane.ERROR_MESSAGE);
                }else
                	{
                	String msg ="Il faut dessiner le graphe";
                	JLabel label = new JLabel(msg);
                	label = new JLabel(msg);
                	label.setFont(new Font("Arial", Font.PLAIN, 12));
                	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
				
                	};
			}
		});
		btnPrim.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnPrim.setBounds(30, 157, 180, 23);
		panel.add(btnPrim);
		
		
		btnDijkstra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( graph.Vertice.size()>0)
				{
						if(graph.isWheighted()){
							Graphics g =graph.getGraphics();
							 m = new MatrixAdj(graph);
							graph.MatrixAdj=m.cMatrix();
							cost=graph.costMatrix(graph.MatrixAdj);
							
		                    Dijkstra dijkstra=new Dijkstra(graph.current_vertex,graph.Vertice, graph.MatrixAdj,cost, g);
		                    Dijkstra dijkstrapdf=new Dijkstra(graph.current_vertex,graph.Vertice, graph.MatrixAdj,cost, g);
		                try{
		                    int start=Integer.parseInt(JOptionPane.showInputDialog("Enter le sommet de départ :"));
		                    if(1<=start && start<=graph.current_vertex)
		                    {
		                    	DijkstraContent = dijkstrapdf.dijkstra(start-1);
		                    	details+="\n***************************Dijkstra****************************\n";
		                    	details+=dijkstra.dijkstra(start-1);
		                    }
		                    textArea.setText(details);
		                    System.out.println(details);
		                   
		                   
		                    
		                    
		                }catch(Exception ex){      
		                	ex.printStackTrace();
		                	String msg ="Il faut donner le sommet de départ";
                        	JLabel label = new JLabel(msg);
                        	label = new JLabel(msg);
                        	label.setFont(new Font("Arial", Font.PLAIN, 12));
                        	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/questionMark.png")));
        				
		                }
		                }else
		                	JOptionPane.showMessageDialog(null, "il faut un graph pondéré !", "Error", JOptionPane.ERROR_MESSAGE);
		                ;
				}else {
					String msg ="Il faut dessiner le graphe";
                	JLabel label = new JLabel(msg);
                	label = new JLabel(msg);
                	label.setFont(new Font("Arial", Font.PLAIN, 12));
                	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
				
				}
				
			}
		});
		btnDijkstra.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnDijkstra.setBounds(30, 247, 180, 23);
		panel.add(btnDijkstra);
		btnMarquage.setEnabled(false);
		
		
		btnMarquage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graph.Vertice.size()>0){
					Graphics g =graph.getGraphics();
					 m = new MatrixAdj(graph);
					 graph.MatrixAdj=m.cMatrix();
					 cost=graph.costMatrix(graph.MatrixAdj);
					 
                    FordFulkerson fordFulkerson=new FordFulkerson(graph.current_vertex,graph.Vertice, graph.MatrixAdj,cost, g);
                    FordFulkerson fordFulkersonPdf=new FordFulkerson(graph.current_vertex,graph.Vertice, graph.MatrixAdj,cost, g);
                    try{
                        int start=Integer.parseInt(JOptionPane.showInputDialog("Enter le sommet de départ :"));
                        int end=Integer.parseInt(JOptionPane.showInputDialog("Enter le sommet de destination :"));
                        if(1<=start && start<=graph.current_vertex && 1<=end && end<=graph.current_vertex)
                        	MarquageContent=fordFulkersonPdf.fordFulkerson(start-1,end-1);
                        	details+="\n***************************FordFulkerson*********************\n";
                        	details+=fordFulkerson.fordFulkerson(start-1,end-1);
                        textArea.setText(details);
                        System.out.println(details);
                    }catch(Exception ex){
                    	ex.printStackTrace();
                    	
                    	String msg ="Il faut donner le sommet de départ et de destination";
                    	JLabel label = new JLabel(msg);
                    	label = new JLabel(msg);
                    	label.setFont(new Font("Arial", Font.PLAIN, 16));
                    	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/questionMark.png")));
    				
                    }
                    }else 
                    {
                    	String msg ="Il faut dessiner le graphe";
                    	JLabel label = new JLabel(msg);
                    	label = new JLabel(msg);
                    	label.setFont(new Font("Arial", Font.PLAIN, 12));
                    	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
    				
                    };
				
			}
		});
		btnMarquage.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnMarquage.setBounds(30, 337, 180, 23);
		panel.add(btnMarquage);
		
		
		btncoloriage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graph.Vertice.size()>0){
					Graphics g =graph.getGraphics();
					 graph.repaint();
					 m = new MatrixAdj(graph);
					graph.MatrixAdj=m.cMatrix();
					cost=graph.costMatrix(graph.MatrixAdj);
					
                    WelchPowel WelchPowel=new WelchPowel(graph.current_vertex,graph.Vertice, graph.MatrixAdj, g);
                    WelchPowel WelchPowelPdf=new WelchPowel(graph.current_vertex,graph.Vertice, graph.MatrixAdj, g);
                    ColoriageContent = WelchPowelPdf.WelchPowel();
                    details+="\n******************************WelchPowel************************\n";
                            details+=WelchPowel.WelchPowel();
                        textArea.setText(details);
                        System.out.println(details);
                  graph.repaint();
                    }else 
                    	{
                    	String msg ="Il faut dessiner le graphe";
                    	JLabel label = new JLabel(msg);
                    	label = new JLabel(msg);
                    	label.setFont(new Font("Arial", Font.PLAIN, 12));
                    	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
    				
                    	};
			}
		});
		btncoloriage.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btncoloriage.setBounds(30, 382, 180, 23);
		panel.add(btncoloriage);
		
		
		btnBellmanFord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Graphics g =graph.getGraphics();
				if(graph.Vertice.size()>0)
				{
					if(graph.isWheighted())
					{
	                    
	                    	m = new MatrixAdj(graph);
	                    	graph.MatrixAdj=m.cMatrix();
	                    	cost=graph.costMatrix(graph.MatrixAdj);
	                    	
	                        BellmanFord bellmanFord=new BellmanFord(graph.current_vertex,graph.Edgets.size(),graph.Edgets,graph.Vertice, graph.MatrixAdj,cost, g);
	                        BellmanFord bellmanFordPdf=new BellmanFord(graph.current_vertex,graph.Edgets.size(),graph.Edgets,graph.Vertice, graph.MatrixAdj,cost, g);
	                        try{
	                            int start=Integer.parseInt(JOptionPane.showInputDialog("Enter le sommet de départ :"));
	                            if(1<=start && start<=graph.current_vertex)
	                            	 details+="\n************************bellmanFord****************************\n";
	                                details+=bellmanFord.graphSup.BellmanFord(start-1);
	                                BellmanFordContent =bellmanFordPdf.graphSup.BellmanFord(start-1);
	                            textArea.setText(details);
	                            System.out.println(details);
	                            graph.paint(g);
	                        }catch(Exception ex){
	                        	ex.printStackTrace();
	                        	String msg ="Il faut donner le sommet de départ";
	                        	JLabel label = new JLabel(msg);
	                        	label = new JLabel(msg);
	                        	label.setFont(new Font("Arial", Font.PLAIN, 12));
	                        	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/questionMark.png")));
	        				
	                        }
	                    
	                        
	                    }
	                    else {
	                    	JOptionPane.showMessageDialog(null, "il faut un graphe pondéré !", "Error", JOptionPane.ERROR_MESSAGE);
	                    	}
	                    
				}else {
					String msg ="Il faut dessiner le graphe";
                	JLabel label = new JLabel(msg);
                	label = new JLabel(msg);
                	label.setFont(new Font("Arial", Font.PLAIN, 12));
                	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
				}
				
              
			}
		});
		
		btnBellmanFord.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnBellmanFord.setBounds(30, 292, 180, 23);
		btnBellmanFord.setEnabled(false);
		panel.add(btnBellmanFord);
		
		
		btnKruskal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g =graph.getGraphics();
			
				if(graph.Vertice.size()>0){
                    if(graph.connexe()){
                    	
                    	m = new MatrixAdj(graph);
                    	graph.MatrixAdj=m.cMatrix();
                    	cost=graph.costMatrix(graph.MatrixAdj);
                    	
                        Kruskal kruskal=new Kruskal(graph.current_vertex,graph.Vertice, graph.MatrixAdj,cost, g);
                        Kruskal kruskalPdf=new Kruskal(graph.current_vertex,graph.Vertice, graph.MatrixAdj,cost, g);
                        KruskalContent =kruskalPdf.kruskalMST();
                        details+="\n*****************************Kruskal**************************\n";
                        details+=kruskal.kruskalMST();
                        textArea.setText(details);
                        System.out.println(details);
                        
                    }else
                    {
                    	String msg ="le graphe n'est pas connexe";
                    	JLabel label = new JLabel(msg);
                    	label = new JLabel(msg);
                    	label.setFont(new Font("Arial", Font.PLAIN, 12));
                    	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
    				
                    }
				}else
                	{
                	String msg ="Il faut dessiner le graphe";
                	JLabel label = new JLabel(msg);
                	label = new JLabel(msg);
                	label.setFont(new Font("Arial", Font.PLAIN, 12));
                	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
				
                	};
			}
		});
		btnKruskal.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnKruskal.setBounds(30, 202, 180, 23);
		panel.add(btnKruskal);
		
		
		
		JLabel lblTrace = new JLabel("D\u00E9tail algorithme :");
		lblTrace.setFont(new Font("Arial", Font.BOLD, 15));
		
		JScrollPane scrollPane = new JScrollPane(pn_mat);
		scrollPane.setBackground(new Color(255, 255, 255));
		
		JScrollPane scrollPaneTrace = new JScrollPane();
		pn_mat.setLayout(null);
		GroupLayout gl_pn_mat = new GroupLayout(pn_mat);
		gl_pn_mat.setHorizontalGroup(
			gl_pn_mat.createParallelGroup(Alignment.LEADING)
				.addGap(0, 394, Short.MAX_VALUE)
		);
		gl_pn_mat.setVerticalGroup(
			gl_pn_mat.createParallelGroup(Alignment.LEADING)
				.addGap(0, 244, Short.MAX_VALUE)
		);
		pn_mat.setLayout(gl_pn_mat);
		scrollPaneTrace.setBackground(new Color(255, 255, 255));
		
		
		
		
		scrollPaneTrace.setViewportView(textArea);
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea.setEditable(false);
		
//		JButton btnModeDemploi = new JButton("Mode d'emploi");
//		btnModeDemploi.setForeground(new Color(47, 79, 79));
//		btnModeDemploi.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//					
//					Help helpWindow =new Help();
//					helpWindow.Help();
//				
//			}
//		});
//		btnModeDemploi.setBackground(SystemColor.inactiveCaptionBorder);
//		btnModeDemploi.setFont(new Font("Cambria Math", Font.BOLD, 16));
//		btnModeDemploi.setBounds(895, 81, 180, 34);
//		frmThorieDesGraphes.getContentPane().add(btnModeDemploi);
//		
		JLabel lblNewLabel = new JLabel("Th\u00E9orie des graphes");
		lblNewLabel.setIcon(new ImageIcon(TG.class.getResource("/img/TGLogo.png")));
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 25));
		
		JLabel label = new JLabel("Matrice adjacente");
		label.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton btnClear = new JButton("Nettoyer le graphe");
		btnClear.setIcon(new ImageIcon(TG.class.getResource("/img/clear.jpg")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphics g =graph.getGraphics();
				graph.repaint();
				 new Thread()
				 {
					 public void run()
					 {
					 			  for (int i=0; i<graph.Edgets.size();i++)
							{
								graph.Edgets.get(i).DrawEdget((Graphics2D) g);
								System.out.println("from "+graph.Edgets.get(i).getFrom().getPos().x+" to "+graph.Edgets.get(i).getTo().getPos().x+" cost "+graph.Edgets.get(i).getCost());
								
							}	
							for(int i=0; i<graph.Vertice.size();i++)
							{
								System.out.println("chan**********ged");
								graph.Vertice.get(i).DrawVertex(g);
								System.out.println("vertex "+graph.Vertice.get(i).getPos().x);
								
							}
					 }
				 }.start();
				
			
							
			}		
			
		});
		btnClear.setFont(new Font("Cambria", Font.BOLD, 16));
		btnClear.setVisible(true);
		
		JButton btnScreen = new JButton("ScreenShot");
		btnScreen.setIcon(new ImageIcon(TG.class.getResource("/img/screen.png")));
		
		btnScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!graph.Vertice.isEmpty())
				{
					try {
						JFileChooser file_chooser = new JFileChooser();
				        file_chooser.setFileFilter(new FileNameExtensionFilter("png", new String[]{"png","PNG"}));
				        String chemin=null;
				        
				        if(file_chooser.showDialog(file_chooser, "Exporter vers")==0) {
					        if(file_chooser.getSelectedFile().exists()) {       	
					        	if(JOptionPane.showConfirmDialog(file_chooser, "Voulez vous vraiments ecraser le contenu du fichier!!", "Fichier deja Exist!!!", JOptionPane.WARNING_MESSAGE )!=0)return;
					        	chemin = file_chooser.getSelectedFile().getAbsolutePath();
					        }
					        if(chemin==null)chemin = file_chooser.getSelectedFile().getAbsolutePath()+".png";
				           
								
						
								saveScreenShot(graph, chemin);
	
								String msg ="L'image est capturer";
								JLabel label = new JLabel(msg);
								label.setFont(new Font("Arial", Font.PLAIN, 18));
								JOptionPane.showMessageDialog(null , label,"Capture",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/saved.png")));
								
				        }
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
					}
				}else {
					String msg ="Il faut dessinser le graphe";
					JLabel label = new JLabel(msg);
					label = new JLabel(msg);
					label.setFont(new Font("Arial", Font.PLAIN, 16));
					JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
					
				}
			}
		});
		btnScreen.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JButton btnPDF = new JButton("Exporter en pdf");
		btnPDF.setIcon(new ImageIcon(TG.class.getResource("/img/Pdf.png")));
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ExportPdf();
				} catch (DocumentException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//
//			
			}
		});
		btnPDF.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JButton btnGuide = new JButton("Guide");
		btnGuide.setSelectedIcon(new ImageIcon(TG.class.getResource("/img/Guide.png")));
		btnGuide.setIcon(new ImageIcon(TG.class.getResource("/img/Guide.png")));
		btnGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						Platform.startup(
								()->{
								JFrame web =new JFrame("Guide");
								WebView webView = new WebView();
								
								URL url= this.getClass().getResource("Guide/index.html");
								webView.getEngine().load(url.toString());
								
								VBox vBox = new VBox(webView);
								Scene scene = new Scene(vBox, 960, 600);
								
								JFXPanel panel = new JFXPanel();
								panel.setScene(scene);
								
								web.add(panel);
								web.setVisible(true);
								web.pack();
								});
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
				
			}
		});
		btnGuide.setForeground(new Color(47, 79, 79));
		btnGuide.setFont(new Font("Cambria Math", Font.BOLD, 16));
		btnGuide.setBackground(new Color(244, 247, 252));
		GroupLayout groupLayout = new GroupLayout(frmThorieDesGraphes.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(rdbtnNotDirected, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(rdbtnweighted, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtnDirected, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
					.addGap(119)
					.addComponent(btnGuide, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(439)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVertex, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNbrVertex, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEdgets, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNbEdgets, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(graph, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btn_grToMatrix, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTrace, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneTrace, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(btn_D, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(125)
					.addComponent(btnScreen, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(150)
					.addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(rdbtnNotDirected, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnweighted, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnDirected, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(btnGuide, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addGap(1)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVertex, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNbrVertex, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(lblEdgets, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(lblNbEdgets, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(graph, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(102)
									.addComponent(btn_grToMatrix, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(lblTrace, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(scrollPaneTrace, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_D, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnScreen, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		frmThorieDesGraphes.getContentPane().setLayout(groupLayout);
		
		
		}
		
	 public void  drwEdegts(Graph graph)
	 {
		 Graphics g =graph.getGraphics();
		 
		 graph.addMouseListener(new MouseAdapter() {
			 
				
				public void mousePressed(MouseEvent e) {
					if(SwingUtilities.isLeftMouseButton(e))
				    {
						from=graph.getVertexPos(e.getX(), e.getY());
				    }
				}
		
		
				
				public void mouseReleased(MouseEvent e) {
					if(SwingUtilities.isLeftMouseButton(e))
				    {
						Edget ed;
						to= graph.getVertexPos(e.getX(), e.getY());
						if(graph.isWheighted())
						{
							
							
							 ed =new Edget(from, to,1);
							 value = true;
						}else {
							 ed = new Edget(from, to);
						}
					
					
						if(!graph.exsitEdget(ed))
						{
							if(ed.getFrom().getPos() != null && ed.getTo().getPos() != null)
							{
								if(graph.isWheighted() && from!=to )
								{
									String val=null;
									val=JOptionPane.showInputDialog(" le cout :");
									if(val!=null && !val.isEmpty() )
									{
									
										costt =Integer.parseInt(val);
										if(costt==0)
										{
											String msg ="Il faut donner une valeur non null";
						                	JLabel label = new JLabel(msg);
						                	label = new JLabel(msg);
						                	label.setFont(new Font("Arial", Font.PLAIN, 16));
						                	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
										
										}else {
											
										
										System.out.println("cost \n");
										ed.setCost(costt);
										graph.addEdget(ed);
								        graph.repaint();
								       }	
									}else 
									{
									String msg ="!! Entrez une valeur";
				                	JLabel label = new JLabel(msg);
				                	label = new JLabel(msg);
				                	label.setFont(new Font("Arial", Font.PLAIN, 16));
				                	JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
									}
					               }
								 
							else {
								graph.addEdget(ed);
								 graph.repaint();
							}}
						}		
							
				    }	    
					else {
						System.out.println("exist");
					}
					
				}
			});
		
		
		
	 }
	 public void drwVertex(Graph graph)
	 {
		 Graphics g =graph.getGraphics();
		 graph.addMouseListener(new MouseAdapter() {		
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(SwingUtilities.isLeftMouseButton(e)) {
					int label = graph.current_vertex;
								Vertex v =new Vertex(label,e.getPoint());
									if(!graph.existVer(v.getPos().x, v.getPos().y) && !graph.existVertexlbl(label))
										{
										    graph.current_vertex++;
											graph.addVertex(v);
											
											graph.repaint();
											
										}
									if(graph.existVer(v.getPos().x, v.getPos().y)) {
											System.out.print("Good");		
										}
								}
					
					}  
		 });
		 graph.addMouseMotionListener(new MouseAdapter() {	
				public void mouseDragged(MouseEvent e) {
					if(SwingUtilities.isRightMouseButton(e))
					{
					int dx ;
					int dy;
					
					if(SwingUtilities.isRightMouseButton(e))
					{
						
						System.out.println("Goodln");
						
						if(press=true)
						{
							dx=e.getX();
							dy=e.getY();
							graph.moveVertex(new Point(dx,dy),g);
							
							graph.repaint();
						//    graph.paint(g);
						    System.out.println("Good*************");
						   
						}
						
						 
					}
				}
				}
				});
		 
		 graph.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseReleased(MouseEvent e) {
							if(SwingUtilities.isRightMouseButton(e))
						    {
								 graph.repaint();
								
						    }
						}
						});
	 }
	 
	 
	 public void clear()
	 {
		 
		 	graph.Vertice.clear();
			graph.Edgets.clear();
		//	graph.paint(graph.getGraphics());
			
			graph.current_vertex=1;
			graph.removeAll();
			graph.repaint();
			pn_mat.removeAll();
			pn_mat.repaint();
			textArea.setText(" ");
			details="";
			lblNbrVertex.setText("0");
			lblNbEdgets.setText("0");
		 
	 }
	 
	 
	 public static BufferedImage getScreenShot(Component com) 
	 {
		 BufferedImage img = new BufferedImage(com.getWidth(), com.getHeight(), BufferedImage.TYPE_INT_RGB);
		 com.printAll(img.getGraphics());
		 return img;
	 }
	 
	 public static void saveScreenShot(Component com, String fileName) throws Exception
	 {
		 BufferedImage img =getScreenShot(com);
		 
		 ImageIO.write(img, "png", new FileOutputStream(fileName));
	 }
	 
	 
	 public void ExportPdf() throws DocumentException, FileNotFoundException, IOException
	 {
		 if(graph.Vertice.size()!=0)
				{
		 JFileChooser file_chooser = new JFileChooser();
	        file_chooser.setFileFilter(new FileNameExtensionFilter("Fichiers pdf", new String[]{"pdf","PDF"}));
	        String chemin=null;
	        
	        if(file_chooser.showDialog(file_chooser, "Exporter vers")==0) {
		        if(file_chooser.getSelectedFile().exists()) {       	
		        	if(JOptionPane.showConfirmDialog(file_chooser, "Voulez vous vraiments ecraser le contenu du fichier!!", "Fichier deja Exist!!!", JOptionPane.WARNING_MESSAGE )!=0)return;
		        	chemin = file_chooser.getSelectedFile().getAbsolutePath();
		        }
		        if(chemin==null)chemin = file_chooser.getSelectedFile().getAbsolutePath()+".pdf";
	           
					try {
					Document document=new Document();
					
					
						PdfWriter.getInstance(document, new FileOutputStream(chemin));
						document.open();
						Paragraph title =new Paragraph("\n Théorie des graphes\n", FontFactory.getFont(FontFactory.TIMES_BOLD,30 ,Font.BOLD, BaseColor.CYAN));
						title.setAlignment(Element.ALIGN_CENTER);
						document.add(title);
						
						
						Paragraph nbreVertex =new Paragraph("Le nombre de sommets: "+graph.Vertice.size(), FontFactory.getFont(FontFactory.TIMES_BOLD,13 ,Font.PLAIN, BaseColor.BLUE));
						document.add(nbreVertex);
						
						
						Paragraph nbreEdgets =new Paragraph("Le nombre des arrêtes: ", FontFactory.getFont(FontFactory.TIMES_BOLD,13,Font.PLAIN, BaseColor.BLUE));
						nbreEdgets.add(" "+graph.Edgets.size());
						document.add(nbreEdgets);
						
						Paragraph titleGraph =new Paragraph("Le graph: ", FontFactory.getFont(FontFactory.TIMES_BOLD,13 ,Font.PLAIN, BaseColor.DARK_GRAY));
						document.add(titleGraph);
						
						File file = new File("src//img//graph.jpg");
						ImageIO.write(getScreenShot(graph) , "jpg", file);
						Image img =Image.getInstance(file.toURI().toURL());
						img.setAlignment(Element.ALIGN_CENTER);
						document.add(img);
						document.newPage();
						
						Paragraph titleMatrix =new Paragraph("La matrice d'adjacence", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
						document.add(titleMatrix);
						
						File fileMatrix = new File("src//img//matrix.jpg");
						ImageIO.write(getScreenShot(pn_mat) , "jpg", fileMatrix);
						Image imgMatrix =Image.getInstance(fileMatrix.toURI().toURL());
						imgMatrix.setAlignment(Element.ALIGN_CENTER);
						document.add(imgMatrix);
						
						if(!BFSContent.isEmpty())
						{
							Paragraph titleBfs =new Paragraph("L'algorithme BFS", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
							document.add(titleBfs);
							
							Paragraph BFS =new Paragraph(BFSContent,  FontFactory.getFont(FontFactory.TIMES_BOLD,15 ,Font.PLAIN, BaseColor.BLACK)); 
							document.add(BFS);		
						}
						
						if(!DFSContent.isEmpty())
						{
							Paragraph titleDFS =new Paragraph("L'algorithme DFS", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
							document.add(titleDFS);
							
							Paragraph DFS =new Paragraph(DFSContent,  FontFactory.getFont(FontFactory.TIMES_BOLD,15 ,Font.PLAIN, BaseColor.BLACK)); 
							document.add(DFS);		
						}
						
						if(!PrimContent.isEmpty())
						{
							Paragraph titlePrim =new Paragraph("L'algorithme Prim", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
							document.add(titlePrim);
							
							Paragraph prim =new Paragraph(PrimContent,  FontFactory.getFont(FontFactory.TIMES_BOLD,15 ,Font.PLAIN, BaseColor.BLACK)); 
							document.add(prim);		
						}
						
						if(!DijkstraContent.isEmpty())
						{
							Paragraph titledijskstra =new Paragraph("L'algorithme Dijkstra", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
							document.add(titledijskstra);
							
							Paragraph dijkstra =new Paragraph(DijkstraContent,  FontFactory.getFont(FontFactory.TIMES_BOLD,15 ,Font.PLAIN, BaseColor.BLACK)); 
							document.add(dijkstra);		
						}
						
						if(!WaresallContent.isEmpty())
						{
							Paragraph titlewareshall =new Paragraph("L'algorithme wareshall", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
							document.add(titlewareshall);
							
							Paragraph wareshall =new Paragraph(WaresallContent,  FontFactory.getFont(FontFactory.TIMES_BOLD,15 ,Font.PLAIN, BaseColor.BLACK)); 
							document.add(wareshall);		
						}
						
						if(!ColoriageContent.isEmpty())
						{
							Paragraph titlecoloriage =new Paragraph("L'algorithme de coloriage", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
							document.add(titlecoloriage);
							
							Paragraph coloriage =new Paragraph(ColoriageContent,  FontFactory.getFont(FontFactory.TIMES_BOLD,15 ,Font.PLAIN, BaseColor.BLACK)); 
							document.add(coloriage);		
						}
						
						if(!BellmanFordContent.isEmpty())
						{
							Paragraph titlebellmanford =new Paragraph("L'algorithme bellmanford", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
							document.add(titlebellmanford);
							
							Paragraph bellmanFord =new Paragraph(BellmanFordContent,  FontFactory.getFont(FontFactory.TIMES_BOLD,15 ,Font.PLAIN, BaseColor.BLACK)); 
							document.add(bellmanFord);		
						}
						
						if(!KruskalContent.isEmpty())
						{
							Paragraph titlekruskall =new Paragraph("L'algorithme kruskall", FontFactory.getFont(FontFactory.TIMES_BOLD,17 ,Font.PLAIN, BaseColor.BLUE));
							document.add(titlekruskall);
							
							Paragraph kruskal =new Paragraph(KruskalContent,  FontFactory.getFont(FontFactory.TIMES_BOLD, 15,Font.PLAIN, BaseColor.BLACK)); 
							document.add(kruskal);		
						}
						
					
					
					document.close();
					String msg ="Enregistrer";
					JLabel label = new JLabel(msg);
					label.setFont(new Font("Arial", Font.BOLD, 18));
					JOptionPane.showMessageDialog(null , label,"Saved",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/saved.png")));
					
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
	              
	                
	        }else
				{
					String msg ="Il faur dessinser le graphe";
					JLabel label = new JLabel(msg);
					label = new JLabel(msg);
					label.setFont(new Font("Arial", Font.BOLD, 16));
					JOptionPane.showMessageDialog(null , label,"Error",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/error.png")));
					
				}
		
		
		 	 }
		}	

