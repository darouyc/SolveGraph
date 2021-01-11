package theoryOfGraphs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Vector;



public class Wareshall extends Graph {
	 private Vector<Object> sommetsPrim;
	    private int acm;
	    private String affichage;
//	    Graphics2D gr2d;
	    int V;
	    private Vector<Vertex> sommetsSequence;
	    final static int INF = 99999; 
	    Graphics grr;
	    int graph[][];
	    
	    public Wareshall(int v,ArrayList<Vertex> vertice,int [][] mat,int [][] cost, Graphics g){
	    	MatrixAdj=mat;
	        this.V=v;
	        this.Vertice=vertice;
	        
	        sommetsSequence=new Vector<>();
	        affichage=new String();
	        
	        grr=(Graphics2D) g;
	        System.out.println(" V="+V);
	        graph=cost;
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {System.out.println(" i ="+i+" j ="+j+"   "+graph[i][j]);
	                if(i!=j && graph[i][j]==0)
	                {  
	                	
	                	graph[i][j]=INF;
	                }
	            }
	        }
	    }
	  
	    String floydWarshall() 
	    { 
	        int dist[][] = new int[V][V]; 
	        int i, j, k; 
	        for (i = 0; i < V; i++) 
	            for (j = 0; j < V; j++) 
	                dist[i][j] = graph[i][j]; 
	        for (k = 0; k < V; k++) 
	        { 
	            for (i = 0; i < V; i++) 
	            { 
	                for (j = 0; j < V; j++) 
	                { 
	                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
	                        dist[i][j] = dist[i][k] + dist[k][j]; 
	                } 
	            } 
	        } 
	        
	      
	        return printSolution(dist); 
	    } 
	  
	    String printSolution(int dist[][]) 
	    { 
	       
	        affichage="\nLa matrice affiche les plus courts chemins entre 2 sommets :\n"; 
	        for (int i=0; i<V; ++i) 
	        { 
	            affichage+="\t";
	            for (int j=0; j<V; ++j) 
	            { 
	                if (dist[i][j]==INF) 
	                    affichage+="INF  |      "; 
	                else
	                    affichage+=dist[i][j]+"      |      "; 
	            } 
	            affichage+="\n";
	            drawPanel(grr);
	        } 
	        return affichage; 
	    } 
	  public void drawPanel(Graphics gr)
	  {
		  new Thread() {
			  public void run()
			  {
				   Vertex from =new Vertex();
		  Vertex to = new Vertex();
		//  int limit =V-1;
		  Graphics2D g2d = (Graphics2D) gr.create();
		  if(isDirected())
		  {
			  for(int i=0;i<V;i++)
			  {
				  for(int j=0; j<V;j++)
				  {
					  System.out.println("************ i="+i+" j="+j);
					//  System.out.println("************ limit"+limit);
					  if(MatrixAdj[i][j]==0  )
					  {
						  for(int p=0;p<V;p++)
						  {
							  if(Vertice.get(p).getLabel()==i+1 )
							  {
								  from=Vertice.get(p);
								  System.out.println("from "+from.getLabel());
							  }
							  if(Vertice.get(p).getLabel()==j+1)
							  {
								  System.out.println("to "+to.getLabel());
								  to=Vertice.get(p);
							  }
							  
						  }
						  from.setColor(new Color(153, 153, 255));
						  try {
							  from.DrawVertex(g2d);
							Thread.sleep(300);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
						   Edget ed = new Edget(from,to);
						  
						   ed.setEd_col(new Color(153, 153, 255));
						  
						   ed.setColor_arowHead(new Color(153, 153, 255));
						   ed.AddEdget(g2d);
						   to.setColor(new Color(153, 153, 255));
							  try {
								  to.DrawVertex(g2d);
								Thread.sleep(300);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							  
						  try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  paint(g2d);
					  }
						  
				  }
			  }
		  }else {
			  for(int i=0;i<V;i++)
			  {
				  for(int j=i; j<V;j++)
				  {
					  System.out.println("************ i="+i+" j="+j);
					//  System.out.println("************ limit"+limit);
					  if(MatrixAdj[i][j]==0 )
					  {
						  for(int p=0;p<V;p++)
						  {
							  if(Vertice.get(p).getLabel()==i+1 )
							  {
								  from=Vertice.get(p);
								  System.out.println("from "+from.getLabel());
							  }
							  if(Vertice.get(p).getLabel()==j+1)
							  {
								  System.out.println("to "+to.getLabel());
								  to=Vertice.get(p);
							  }
							  
						  }
						  from.setColor(new Color(153, 153, 255));
						  try {
							  from.DrawVertex(g2d);
							Thread.sleep(300);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						   Edget ed = new Edget(from,to);
						  
						   ed.setEd_col(new Color(153, 153, 255));
						   
						   ed.setColor_cost(new Color(153, 153, 255));
						   ed.AddEdget(g2d);
						   to.setColor(new Color(153, 153, 255));
							  try {
								  to.DrawVertex(g2d);
								Thread.sleep(300);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						  try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  paint(g2d);
					  }
						  
				 
				  }}}
	  }
			  
		  }.start();
		 
}}
