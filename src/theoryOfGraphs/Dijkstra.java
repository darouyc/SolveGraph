package theoryOfGraphs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;



public class Dijkstra extends Graph{
	   private String affichage;
	    Vector sommetsDijikstra;
	    int V;
	    int[][] cost;
	    
	    
	    public Dijkstra(int v,ArrayList<Vertex> vertice,int [][] mat,int [][] cost, Graphics g){
	    	MatrixAdj=mat;
	        this.V=v-1;
	        this.Vertice=vertice;;
	   //     System.out.println("nobre de sommets :"+V);
	        sommetsDijikstra=new Vector<Integer>();
	        affichage=new String();
	        gr2d=(Graphics2D) g;
	        this.cost=cost;
	    }
	     
	    public String dijkstra( int src) 
	    { 
	    	int graph[][]=new int[Vertice.size()][Vertice.size()];
	    	sommetsDijikstra=new Vector<Integer>();
	        affichage="\n     Sommet de départ est :  "+(src+1);
	        if(!isDirected())
	        {
	        	graph=cost;
	        }
	        else {
	        	
	        	for (int i=0;i<Vertice.size();i++)
	        	{
	        		for(int j=0; j<i; j++)
	        		{
	        			graph[i][j]=0;
	        		}
	        		for(int j=i; j<Vertice.size();j++)
	        		{
	        			graph[i][j]=cost[i][j];
	        		}
	        	}
	        }
	        int dist[] = new int[V]; // The output array. dist[i] will hold 
	                                 // the shortest distance from src to i 
	        
	        // sptSet[i] will true if vertex i is included in shortest 
	        // path tree or shortest distance from src to i is finalized 
	        Boolean sptSet[] = new Boolean[V]; 
	  
	        // Initialize all distances as INFINITE and stpSet[] as false 
	        for (int i = 0; i < V; i++) 
	        { 
	            dist[i] = Integer.MAX_VALUE; 
	            sptSet[i] = false; 
	           
	        } 
	  
	        dist[src] = 0; 

	        for (int count = 0; count < (V-1); count++) 
	        { 
	        	System.out.println("true "+count);
	        	
	            int u = minDistance(dist, sptSet);  
	            sptSet[u] = true; 
	            for (int v = 0; v < V; v++) 
	            {	
	            	
	                if (!sptSet[v] && graph[u][v]!=0 &&  dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]) 
	                {
	                	dist[v] = dist[u] + graph[u][v]; 
	                }
	            }
	        } 
	       System.out.println("true    true");
	      String val= printSolution(dist, V,src);
	        return val; 
	    }
	    
	    public String printSolution(int dist[],int V, int src) 
	    { 
	        affichage += "\n\tChemin \t  Distance Source";
	        System.out.println("Sommet \t  Distance from Source"); 
	        for (int i = 0; i < V; i++) {
	            System.out.println((1+i)+" \t\t "+dist[i]);
	            affichage+="\n\t"+(src+1)+"->"+(1+i)+" \t\t "+dist[i] ;
	            sommetsDijikstra.add(dist[i]);
	        }
	        drawPanel(src);
	        return affichage;
	    } 
	      
	    int minDistance(int dist[], Boolean sptSet[]) 
	    { 
	        
	        int min = Integer.MAX_VALUE, min_index=-1; 
	  
	        for (int v = 0; v < V; v++) 
	            if (sptSet[v] == false && dist[v] <= min) 
	            { 
	                min = dist[v]; 
	                min_index = v; 
	            } 
	  
	        return min_index; 
	    } 

	    private void drawPanel(int start) {
	        Vertex src= Vertice.get(start);
	        int value=sommetsDijikstra.size()-1;
	        System.out.println("size"+ sommetsDijikstra.size());
	        
	        System.out.println("V= "+ V);
	        for(int i=0;i<=value;i++)
	        { 
	        	System.out.println("sommet dij"+ sommetsDijikstra.get(i));
	            Vertex dest= Vertice.get(i);
	            int destCout =(int) sommetsDijikstra.get(i);
	            
	            src.setColor(new Color(204,229,255));
		        
	            src.DrawVertex(gr2d);
	            src.setLbl_Col(Color.WHITE);
	                try {
	                    Thread.sleep(500);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	            drawComment(dest,destCout);
	                try { 
	                    Thread.sleep(250);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	        }
	    }

	    private void drawComment(Vertex dest, int cout) {
	        int x=dest.getPos().x;
	        int y=dest.getPos().y;
	    
	        
	        gr2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
	        gr2d.setStroke(new BasicStroke(2));
	        gr2d.setColor(new Color(218,165,32));
	        gr2d.drawString("distance ="+cout, x-2*4, y-4/3);
	    }
}
