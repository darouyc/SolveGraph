package theoryOfGraphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;



public class BFS extends Graph	{
	
	 private Vector<Object> sommetsPrim;
	    private int acm;
	    private String affichage;
//	    Graphics2D gr2d;
	    private Vector<Vertex> sommetsSequence;
	    Graphics gr;
	    int V;
	    
	    public BFS( int V,ArrayList<Vertex> vertice,int [][] mat, Graphics g){
	        
	    	
	        this.V=V-1;
	        this.Vertice=vertice;
	        MatrixAdj=mat;
	        sommetsSequence=new Vector<>();
	        affichage=new String("");
	       gr=g;
	    //    System.out.println(" "+getEdgeWt(1,1));
	         
	    }
	    
	    public String bfs(int start) {
	              //  
	                affichage="\n         Sommet de départ est :  "+(start+1);
	                sommetsSequence.clear();
			ArrayList<Integer> sequence = new ArrayList<Integer>();
			boolean[] visited = new boolean[V];
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.offer(start);
			visited[start] = true;
			while (!q.isEmpty()) {
				Integer currVert = q.poll();
				sequence.add(currVert);
				for (Integer i: getNeighbors(currVert, V)) {
					if (!visited[i]) {
						q.offer(i);
						visited[i] = true;
					}
				}
			} 
			Iterator<Integer> itbfs = sequence.iterator();
	                String ress="[";
	                
	                while (itbfs.hasNext()) {
	                    Integer s = itbfs.next();
	                    sommetsSequence.add(Vertice.get(Integer.parseInt(s.toString())));
	                    ress=ress+" "+((Integer.parseInt(s.toString())+1)+"  ");
	                }
	                ress=ress+"]";
	                System.out.println(ress);
	                affichage+="\n\t"+ress;
//	                this.Affichage.setText(ress); 
	        for(int i=0;i<=sommetsSequence.size()-1;i++)
	        { 
	            Vertex src=(Vertex) sommetsSequence.get(i); 
	           src.setColor(new Color(204,229,255));
	           src.setLbl_Col(Color.WHITE);
	           src.DrawVertex(gr);
	           repaint();
	                try {
	                    Thread.sleep(350);
	                } catch (Exception e) {
	                    System.out.println("NOoooooooooooooooooooooo");
	                }
	        }
	        return affichage;
	    }
	      
}
