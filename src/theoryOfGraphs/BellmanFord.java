package theoryOfGraphs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;



public class BellmanFord extends Graph{
	 private Vector sommetsBelmman;
	    private String affichage;
	    Graph graphSup;
	    Graphics gr;
	    int [][]cost;
	    int V;
	    int E;
	    
	    
	    public BellmanFord(int v,int nbreEdget,ArrayList<Edget> Edgets,ArrayList<Vertex> vertice,int [][] mat, int [][]cost, Graphics g){
	    	this.V=v;
	        this.Vertice=vertice;
	       // MatrixAdj=mat;
	        this.cost=cost;
	        System.out.println("les nombres de sommets:" + V);
	        sommetsBelmman=new Vector();
	        affichage=new String();        
	        this.gr=g;
	        this.E=nbreEdget;
	       
	        graphSup=new Graph(vertice.size(), this.E);
	        
	        int p=0;
	       if(isDirected())
	       {
	    	   for (int i = 0; i < vertice.size(); i++) { 
	             for (int j = 0; j < vertice.size(); j++) {
	                 if (cost[i][j]!=0) {
	                	 System.out.println("edget nbre: "+ p);
	                    graphSup.edge[p].src = i; 
	                    graphSup.edge[p].dest = j; 
	                    graphSup.edge[p].weight = cost[i][j]; 
	                    p++;
	                 }
	             }
	        	}
	       }
//	       }else {
//	    	   for (int i = 0; i < vertice.size(); i++) { 
//		             for (int j = i; j < vertice.size(); j++) {
//		                 if (cost[i][j]!=0) {
//		                	 System.out.println("edget nbre: "+ p);
//		                    graphSup.edge[p].src = i; 
//		                    graphSup.edge[p].dest = j; 
//		                    graphSup.edge[p].weight = cost[i][j]; 
//		                    p++;
//		                 }
//		             }
//		        	}
//	    	   
//	       }
	        	
	         
	    }
	    
	        class Graph 
	        { 
	           
	            class Edge { 
	                int src, dest, weight; 
	                Edge() { 
	                    src = dest = weight = 0; 
	                } 
	            }; 

	            int V, E; 
	            Edge edge[]; 

	             
	            Graph(int v, int e) 
	            { 
	                V = v; 
	                E = e; 
	                edge = new Edge[e]; 
	                for (int i=0; i<e; ++i) 
	                    edge[i] = new Edge(); 
	            } 

	          
	            String BellmanFord(int src) 
	            { 
	                Graph graph=graphSup;
	                int V = graph.V, E = graph.E; 
	                int dist[] = new int[V]; 
	                sommetsBelmman=new Vector();
	                // Step 1: Initialize distances from src to all other 
	                // vertices as INFINITE 
	                for (int i=0; i<V; ++i) 
	                    dist[i] = Integer.MAX_VALUE; 
	                dist[src] = 0; 

	                // Step 2: Relax all edges |V| - 1 times. A simple 
	                // shortest path from src to any other vertex can 
	                // have at-most |V| - 1 edges 
	                for (int i=1; i<V; ++i) 
	                { 
	                    for (int j=0; j<E; ++j) 
	                    { 
	                        int u = graph.edge[j].src; 
	                        int v = graph.edge[j].dest; 
	                        int weight = graph.edge[j].weight; 
	                        if (dist[u]!=Integer.MAX_VALUE && 
	                            dist[u]+weight<dist[v]) 
	                            dist[v]=dist[u]+weight; 
	                    } 
	                } 

	                // Step 3: check for negative-weight cycles.  The above 
	                // step guarantees shortest distances if graph doesn't 
	                // contain negative weight cycle. If we get a shorter 
	                //  path, then there is a cycle. 
	                for (int j=0; j<E; ++j) 
	                { 
	                    int u = graph.edge[j].src; 
	                    int v = graph.edge[j].dest; 
	                    int weight = graph.edge[j].weight; 
	                    if (dist[u] != Integer.MAX_VALUE && 
	                        dist[u]+weight < dist[v]) 
	                      System.out.println("Graph contains negative weight cycle"); 
	                } 
	                return printArr(dist, V,src); 
	            } 

	                // A utility function used to print the solution 
	            String printArr(int dist[], int V,int src) 
	            {   
	              
	                affichage="\n    Sommet de départ est :  "+(src+1);
//	                affichage+="Vertex   Distance from Source";
	                affichage += "\n\tChemin \t  Distance Source";
	                System.out.println("Vertex   Distance from Source"); 
	                for (int i=0; i<V; ++i) 
	                {
	                    affichage+="\n\t"+(src+1)+"->"+(i+1)+"\t\t"+dist[i];
	                    sommetsBelmman.add(dist[i]);
	                }
	                drawPanel(src);
	                return affichage;
	            }
	            
	            private void drawPanel(int start) {
	                Vertex src= Vertice.get(start);
	                for(int i=0;i<=sommetsBelmman.size()-1;i++)
	                { 
	                    Vertex dest= Vertice.get(i);
	                    int destCout =(int) sommetsBelmman.get(i);
	                    
	                    src.setColor(new Color(204,229,255));
	     	            src.setLbl_Col(Color.WHITE);
	                    src.DrawVertex(gr);
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
	            
	            gr.setFont(new Font("TimesRoman", Font.PLAIN, 12));
	            ((Graphics2D) gr).setStroke(new BasicStroke(2));
	            gr.setColor(Color.black);
	            gr.drawString("distance ="+cout, x-2*4, y-4/3);
	        }
	    }
}
