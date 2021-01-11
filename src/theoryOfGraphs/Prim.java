package theoryOfGraphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;





public class Prim extends Graph{
	private Vector<Object> sommetsPrim;
    private int acm;
    private String affichage;
    Graphics gr;
    int [][]cost;
    int V;

    
    public Prim(int V,ArrayList<Vertex> vertice,int [][] mat, int [][]cost, Graphics g){
    	this.V=V-1;
        this.Vertice=vertice;
        MatrixAdj=mat;
        this.cost=cost;
        sommetsPrim=new Vector<>();
        acm=0;
        affichage=new String();
        
        gr=(Graphics2D) g;
    }
    
    public String primMST() 
    { 
        int graph[][]=cost;
        int parent[] = new int[V]; 
        int key[] = new int[V]; 
  
         
        Boolean mstSet[] = new Boolean[V];  
        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        }  
        key[0] = 0; 
        parent[0] = -1;  
     
        for (int count = 0; count < (V - 1); count++) { 
            int u = minKey(key, mstSet); 
            mstSet[u] = true; 
            for (int v = 0; v < V; v++) 
             if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
        String resultat=printMST(parent, graph); 
        drawPanel(gr2d);
        return resultat;
        
    }
    
    public String printMST(int parent[], int graph[][]) 
    {   
        
        affichage="\n\t  Arrêtes \t Coûts\n";
        System.out.println("Edge \t Weight"); 
        for (int i = 1; i < V; i++) 
        {   

            Vector tempVect = new Vector();
            tempVect.add(Vertice.get(parent[i]));
            tempVect.add(Vertice.get(i));
            tempVect.add(graph[i][parent[i]]);

            sommetsPrim.add(tempVect);
            System.out.println("\t"+((Vertex)tempVect.get(0)).getLabel() + " - " + (((Vertex)tempVect.get(1)).getLabel())
                    + "\t=>" + tempVect.get(2));
            acm+=(int)tempVect.get(2);
            affichage+=("\t-"+i+"- :  "+((Vertex)tempVect.get(0)).getLabel() )+ " - " + (((Vertex)tempVect.get(1)).getLabel())
                    + "\t    " + tempVect.get(2)+"\n";
        } 
        affichage+="\t\t=> ACM = "+acm;
        return affichage;
    }
    
    int minKey(int key[], Boolean mstSet[]) 
    { 
      
        int min = Integer.MAX_VALUE;
        int min_index=0;
        		if(Edgets.size()!=0)
        		{
        			min_index =-1;
        		}
        		 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    
    public void drawPanel(Graphics2D Panel){  
        for(int i=0;i<=sommetsPrim.size()-1;i++)
        { 
            Vertex src=(Vertex) ((Vector) sommetsPrim.get(i)).get(0);
            Vertex dest=(Vertex) ((Vector) sommetsPrim.get(i)).get(1);
            
            int cout=(int) ((Vector) sommetsPrim.get(i)).get(2);
            Edget ed =new Edget(src, dest, cout);
            src.setColor(new Color(0, 204, 102));
            src.DrawVertex(gr);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("NOoooooooooooooooooooooo");
                }
                ed.setColor_arowHead(new Color(0, 204, 102));
                ed.setColor_cost(new Color(0, 204, 102));
                ed.setEd_col(new Color(0, 204, 102));
            ed.AddEdget((Graphics2D) gr);
                try {
                    Thread.sleep(250);
                } catch (Exception e) {
                    System.out.println("NOoooooooooooooooooooooo");
                }
            dest.setColor(new Color(0, 204, 102));
            dest.DrawVertex(gr);
                try {
                Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("NOoooooooooooooooooooooo");
                }
        }

    }
}
