package theoryOfGraphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;



public class Kruskal extends Graph {
	   private Vector<Object> sommetsKruskal;
	    private int acm;
	    private String affichage;
	     Graphics gr;
	    int [][]costt;
	    int V;
	    static int[] parent ;
	    final static int INF =  Integer.MAX_VALUE;
	    
	    public Kruskal(int V,ArrayList<Vertex> vertice,int [][] mat, int [][]cost, Graphics g){
	    	this.V=V-1;
	        this.Vertice=vertice;
	        MatrixAdj=mat;
	        this.costt=cost;
	        
	        sommetsKruskal=new Vector<>();
	        acm=0;
	        affichage=new String();
	        this.gr=g;
	        
	        parent = new int[V]; 
	        for (int i = 0; i < Vertice.size(); i++) {
	            for (int j = 0; j < Vertice.size(); j++) {
	                if(cost[i][j]==0)
	                	cost[i][j]=INF;
	            }
	        }
	    }
	    
	    static int find(int i) 
	{ 
	    while (parent[i] != i) 
	        i = parent[i]; 
	    return i; 
	} 
	  
	// Does union of i and j. It returns 
	// false if i and j are already in same 
	// set. 
	static void union1(int i, int j) 
	{ 
	    int a = find(i); 
	    int b = find(j); 
	    parent[a] = b; 
	} 
	  
	// Finds MST using Kruskal's algorithm 
	public String kruskalMST() 
	{ 
	    int cost[][]=costt;
	    sommetsKruskal.clear();
	    acm=0;
	    
	   
	    affichage="\n\t     Arrêtes \t Coûts\n";
	    int mincost = 0; // Cost of min MST. 
	  
	    // Initialize sets of disjoint sets. 
	    for (int i = 0; i < V; i++) 
	        parent[i] = i; 
	  
	    // Include minimum weight edges one by one 
	    int edge_count = 0; 
	    while (edge_count < V - 1) 
	    { 
	        int min = INF, a = -1, b = -1; 
	        for (int i = 0; i < V; i++) 
	        { 
	            for (int j = 0; j < V; j++)  
	            { 
	                if (find(i) != find(j) && cost[i][j] < min)  
	                { 
	                    min = cost[i][j]; 
	                    a = i; 
	                    b = j; 
	                } 
	            } 
	        } 
	        union1(a, b); 
 
	        affichage+="\t-"+(edge_count+1)+"- :  "+(a+1)+ " - " + (b+1) + "\t  " +min+"\n";
	        Vector tempVect = new Vector();
	        tempVect.add(Vertice.get(a));
	        tempVect.add(Vertice.get(b));
	        tempVect.add(min);
	        sommetsKruskal.add(tempVect);
	        edge_count++; 
	        acm += min; 
	    } 
	    System.out.printf("\n Minimum cost= %d \n", mincost); 

	    affichage+="\t => ACM = "+acm;
	    drawPanel();
	    return affichage;
	} 
	    
	    public void drawPanel(){  
	        for(int i=0;i<=sommetsKruskal.size()-1;i++)
	        { 
	            Vertex src=(Vertex) ((Vector) sommetsKruskal.get(i)).get(0);
	            Vertex dest=(Vertex) ((Vector) sommetsKruskal.get(i)).get(1);
	            int cout=(int) ((Vector) sommetsKruskal.get(i)).get(2);
	            
	            src.DrawVertex(gr);
	                try {
	                    Thread.sleep(500);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	                Edget ed =new Edget(src, dest, cout);
	                ed.setColor_arowHead(new Color(255, 178, 102));
	                ed.setEd_col(new Color(255, 178, 102));
	                ed.setColor_cost(new Color(255, 178, 102));
	                ed.AddEdget((Graphics2D) gr);
	                try {
	                    Thread.sleep(250);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	                dest.DrawVertex(gr);
	                try {
	                Thread.sleep(500);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	        }
//	        Affichage.setText(affichage);
	    }
}
