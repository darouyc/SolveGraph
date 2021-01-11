package theoryOfGraphs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;



public class FordFulkerson extends Graph{
	 private String affichage;
	    int [][] graph;
	    Graphics gr;
	    int V;
	    int[][] cost;
	    
	    public FordFulkerson(int V,ArrayList<Vertex> vertice,int [][] mat,int [][] cost, Graphics g){
	    	MatrixAdj=mat;
	        this.V=V-1;
	        this.Vertice=vertice;
	        
	        affichage=new String();
	        gr=(Graphics2D) g;
	        this.cost=cost;
	       
	        graph=cost;
	    }
	    
	    boolean bfs(int rGraph[][], int s, int t, int parent[]) 
	    { 
	        boolean visited[] = new boolean[V]; 
	        for(int i=0; i<V; ++i) 
	            visited[i]=false; 
	  
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 
	        queue.add(s); 
	        visited[s] = true; 
	        parent[s]=-1; 
	  
	        while (queue.size()!=0) 
	        { 
	            int u = queue.poll(); 
	  
	            for (int v=0; v<V; v++) 
	            { 
	                if (visited[v]==false && rGraph[u][v] > 0) 
	                { 
	                    queue.add(v); 
	                    parent[v] = u; 
	                    visited[v] = true; 
	                } 
	            } 
	        } 
	  
	        // If we reached sink in BFS starting from source, then 
	        // return true, else false 
	        return (visited[t] == true); 
	    } 
	  
	    // Returns tne maximum flow from s to t in the given graph 
	    String fordFulkerson(int s, int t) 
	    { 
	        
	        affichage="\n     Sommet de départ est :  "+(s+1);
	        affichage+="\n     Sommet de destination est :  "+(t+1);
	        int u, v; 
	        int rGraph[][] = new int[V][V]; 
	  
	        for (u = 0; u < V; u++) 
	            for (v = 0; v < V; v++) 
	                rGraph[u][v] = graph[u][v]; 
	  
	        
	        int parent[] = new int[V]; 
	  
	        int max_flow = 0;  
	        while (bfs(rGraph, s, t, parent)) 
	        { 
	            int path_flow = Integer.MAX_VALUE; 
	            for (v=t; v!=s; v=parent[v]) 
	            { 
	                u = parent[v]; 
	                path_flow = Math.min(path_flow, rGraph[u][v]); 
	            } 
	   
	            for (v=t; v != s; v=parent[v]) 
	            { 
	                u = parent[v]; 
	                rGraph[u][v] -= path_flow; 
	                rGraph[v][u] += path_flow; 
	            } 
	  
	            
	            max_flow += path_flow; 
	        } 
	  
	       
	        drawPanel(s, t, max_flow);
	        affichage+="\n\t--> Le flux maximal est : "+max_flow;
	        return affichage; 
	    }  

	        private void drawPanel(int s,int d,int maxflow) {
	            Vertex src= Vertice.get(s);
	            Vertex dest= Vertice.get(d);
	            src.setColor(new Color(204,229,255));
		        src.setLbl_Col(Color.WHITE);
		        src.DrawVertex(gr);
	                try {
	                    Thread.sleep(500);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	            dest.setColor(new Color(204,229,255));
	            dest.setLbl_Col(Color.WHITE);
	            dest.DrawVertex(gr);
	                try {
	                    Thread.sleep(500);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	            drawComment(dest,maxflow);
	                try {
	                    Thread.sleep(250);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	        }

	        private void drawComment(Vertex dest, int cout) {
	            int x=dest.getPos().x;
	            int y=dest.getPos().y;
	           
	            Font fonte = new Font("TimesRoman ",Font.BOLD,16);
	            gr.setFont(fonte);
	            gr.setColor(new Color(229, 204, 255));
	            gr.drawString("Flux Maximal ="+cout, x-2*4, y-4/3);
	        }
}
