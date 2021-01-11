package theoryOfGraphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;



public class DFS extends Graph{
	  private String affichage;

    private Vector<Vertex> sommetsSequence;
    Graphics gr;
    int V;
    public DFS(int V,ArrayList<Vertex> vertice,int [][] mat, Graphics g){

        this.V=V-1;
        this.Vertice=vertice;
        MatrixAdj=mat;
        sommetsSequence=new Vector<>();
        affichage=new String("");
       gr=g;
    }
    
    public String dfs(int start) {
                
                affichage="\n            Sommet de départ est :  "+(start+1);
                sommetsSequence.clear();
		boolean[] visited = new boolean[V];
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		dfs(start, visited, sequence);
                Iterator<Integer> itdfs = sequence.iterator();
                String ress1="[";
                int i=0;
                while (itdfs.hasNext()) {
                    Integer s = itdfs.next();
                    sommetsSequence.add(Vertice.get( ( Integer.parseInt(s.toString()) ) ) );
                    ress1=ress1+" "+( (sommetsSequence.get(i).getLabel())+"  ");
                    i++;
                }
                ress1=ress1+"]";
                System.out.println(ress1);
                affichage+="\n\t"+ress1;
                for(int j=0;j<=sommetsSequence.size()-1;j++)
                { 
                    Vertex src=(Vertex) sommetsSequence.get(j);
                    src.setColor(new Color(204,229,255));
     	            src.setLbl_Col(Color.WHITE);
                    src.DrawVertex(gr);
                        try {
                            Thread.sleep(350);
                        } catch (Exception e) {
                            System.out.println("NOoooooooooooooooooooooo");
                        }
                }
        return affichage;
	}
	public void dfs(int currVert, boolean[] visited,ArrayList<Integer> sequence) {
		visited[currVert] = true;
		sequence.add(currVert);
		for (Integer i: getNeighbors(currVert, V)) {
			if (!visited[i]) {
                            dfs(i, visited, sequence);
			}
		}
	}
      
}
