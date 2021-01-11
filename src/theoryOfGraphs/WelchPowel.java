package theoryOfGraphs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;





public class WelchPowel extends Graph{
	
	  private String affichage;

	    private ArrayList<Integer> degree;
	    Graphics gr;
	    private List<Integer> nbr_neighbor;
	    private ArrayList <Integer> visited;
	    private ArrayList <Integer> colored;
	    int V;
	    boolean value=false;
	    Random rand = new Random();
	    int nbreColor= 0;
	 	
		
	    
	public WelchPowel(int V,ArrayList<Vertex> vertice,int [][] mat, Graphics g)
	{
		this.V=V-1;
        this.Vertice=vertice;
        MatrixAdj=mat;
        degree=new ArrayList<Integer>();
        nbr_neighbor = new ArrayList<Integer>();
        visited =new ArrayList<Integer>();
        colored =new ArrayList<Integer>();
        affichage=new String("");
       gr=g;
	}
	public String WelchPowel()
	{
		
		
		 for(int i=0;i<Vertice.size() ;i++)
		 {
			 nbr_neighbor.add(getNeighbors(i , V).size());
			 Vertice.get(i).neibhors=getNeighbors(i , V).size();
			 System.out.println(" le sommet__________ "+Vertice.get(i).getLabel()+" degree "+Vertice.get(i).neibhors);
			 
		 }
		 nbr_neighbor= nbr_neighbor.stream().distinct().collect(Collectors.toList());
		
			
		
			Collections.sort(Vertice, Collections.reverseOrder(new Sortbyroll()) );
			for(int g=0 ;g<V;g++)
			{
				System.out.println(" le sommet ********** "+Vertice.get(g).getLabel()+" degree "+Vertice.get(g).neibhors);
				degree.add(Vertice.get(g).getLabel());
			}
			for(int g=0 ;g< V;g++)
			{
				System.out.println(" le nouveau ********** "+degree.get(g));
				//degree.add(g);
			}
		int size =degree.size();	
		for(int j=0 ;j<degree.size();j++)
		{
			System.out.println("degree 1  "+degree.size());
			int r =rand.nextInt(255);
			int g =rand.nextInt(255);
			int b =rand.nextInt(255);
			
			nbreColor++;
			
			getVertex(degree.get(j)).setColor(new Color(r, g,b));
					System.out.println(" le sommet supprimer " + degree.get(j));
					int test =degree.get(j);
					affichage+=" \n le sommet  "+degree.get(j)+ " couleur "+ nbreColor +"\n";
			degree.remove(degree.get(j));
			size=degree.size();
			int i=0;
			while( i<size)
			{	System.out.println("sommet  "+degree.get(i));
			int test2= degree.get(i);
				if( !CompareList(visited, getNeighbors(test2-1, V)) && !visited.contains(test2-1) && !getNeighbors(test-1,V).contains(test2-1)  )
						{
						
							getVertex(degree.get(i)).setColor(new Color(r, g,b));
							visited.add(degree.get(i)-1);
							affichage+=" \n le sommet  "+degree.get(i)+ " couleur "+ nbreColor +"\n";
							degree.remove(degree.get(i));
							System.out.println("size  "+degree.size());
							
							size=degree.size();
						}else i++;
			}visited.clear();
		}
		
//		
		 repaint();
		
		return affichage;
		
	}
	public boolean CompareList(ArrayList list1 , ArrayList list2)
	{
		for(int i= 0; i<list1.size() ; i++)
		{
			for(int j=0; j<list2.size() ;j++)
			{
				if(list1.get(i).equals(list2.get(j)))
					return true;
			}
		}return false;
	}
}
class Sortbyroll extends Vertex implements Comparator<Vertex> 
{ 
    

	@Override
	public int compare(Vertex v, Vertex a) {
		return String.valueOf(a.neibhors).compareTo(String.valueOf(v.neibhors));
	
		
	} 
} 
