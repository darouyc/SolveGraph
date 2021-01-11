package theoryOfGraphs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.*;




public class Graph extends javax.swing.JPanel  {
	
	
	ArrayList<Vertex> Vertice= new ArrayList<Vertex>();
	ArrayList<Edget> Edgets = new ArrayList<Edget>();
	private static boolean directed = false;
	private static boolean wheighted =true;
	int current_vertex =1;
	int [][]MatrixAdj;
	boolean connexe = false;
	public int getCurrent_vertex() {
		return current_vertex;
	}
	public void setCurrent_vertex(int current_vertex) {
		this.current_vertex = current_vertex;
	}
	Graphics2D gr2d;
	int[][] adjMat;
	 
		
	static int size_vertex=16;
	
	
	public Graph() {
		repaint();
	}
	public ArrayList<Vertex> getVertice() {
		return Vertice;
	}
	public void setVertice(ArrayList<Vertex> vertice) {
		Vertice = vertice;
	}
	public static boolean isWheighted() {
		return wheighted;
	}
	public void setWheighted(boolean wheighted) {
		this.wheighted = wheighted;
	}
	public ArrayList<Edget> getEdgets() {
		return Edgets;
	}
	public void setEdgets(ArrayList<Edget> edgets) {
		Edgets = edgets;
	}
	
	public static int getSize_vertex() {
		return size_vertex;
	}
	public static void setSize_vertex(int size_vertex) {
		Graph.size_vertex = size_vertex;
	}
	public static boolean isDirected() {
		return directed;
	}
	public void setDirected(boolean directed) {
		this.directed = directed;
	}
	
	public void addVertex(Vertex vertex)
	{
		Vertice.add(vertex);
		
		System.out.println("changed");
	}
	
	public void addEdget(Edget edget) {
		Edgets.add(edget);
		
	}
	public Vertex getVertexPos(int x, int y)
	{
		
		for(int i=0 ;i<Vertice.size(); i++ )
		{
			if((Vertice.get(i).getPos().x-16 <= x  && x <= Vertice.get(i).getPos().x +16) && (Vertice.get(i).getPos().y-16 <= y  && y <= Vertice.get(i).getPos().y +16))
			{	
				
				return Vertice.get(i);	
			}
		}
		System.out.println("none");
		return new Vertex();
	}
	public boolean existVertexlbl(int label)
	{
		
		for(int i=0 ;i<Vertice.size(); i++ )
		{
			if(Vertice.get(i).getLabel()==label)
				return true;	
			
		}
		return false;
	}
	
	public boolean existVer(int x, int y) 
	{
		Vertex v =getVertexPos(x,y);
		
		if(v.getPos()!=null )
		{
			
		for(int i =0;i<Vertice.size();i++)
		{
			if(Vertice.get(i).getPos().equals(v.getPos()) )
				return true;
		} }
				return false;
			
	}
	
	
	public boolean exsitEdget(Edget edget)
	{
		if(!directed)
		{
			for(int i =0; i< Edgets.size(); i++)
			{
				if(Edgets.get(i).getFrom().equals(edget.getFrom()) && Edgets.get(i).getTo().equals(edget.getTo()) || Edgets.get(i).getTo().equals(edget.getFrom()) && Edgets.get(i).getFrom().equals(edget.getTo()))
					return true;
			}return false;
		}else {
			for(int i =0; i< Edgets.size(); i++)
			{
				if(Edgets.get(i).getFrom().equals(edget.getFrom()) && Edgets.get(i).getTo().equals(edget.getTo()))
					return true;
			}return false;
		}
	}
	
	public void moveVertex(Point to,Graphics g) 
	{
		
		Vertex v = getVertexPos(to.x, to.y);	
		for(Vertex s : Vertice)
		{
			if(v == s)
			{
				s.setPos(to);
				
			}

		}
		for(Edget ed : Edgets)
		{
			if(ed.getFrom().getPos() == v.getPos())
			{
				System.out.println("Verteeeeeeeeeex change");
				ed.getFrom().setPos(to);
				
			}else if(ed.getTo().getPos() == v.getPos())
			{	System.out.println("Verteeeeeeeeeex change");
				ed.getTo().setPos(to);
			}

		}
		
		System.out.println("gggggggg");	
	}
	@Override
	public void  paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		for (int i=0; i<Edgets.size();i++)
		{
			Edgets.get(i).DrawEdget((Graphics2D) g);
			System.out.println("from "+Edgets.get(i).getFrom().getPos().x+" to "+Edgets.get(i).getTo().getPos().x+" cost "+Edgets.get(i).getCost());
		}	
		for(int i=0; i<Vertice.size();i++)
		{
			System.out.println("chan**********ged");
			Vertice.get(i).DrawVertex(g);
			System.out.println("vertex "+Vertice.get(i).getPos().x);
		}
		
	}
	  
	
	  public ArrayList<Integer> getNeighbors(int vertex, int som) {
			ArrayList<Integer> neighbors = new ArrayList<Integer>();
			for (int i=0; i<som; i++) {
				if (getEdgeWt(vertex, i) != 0) {
					neighbors.add(i);
					
				}
			}
			return neighbors;
		}
	  public int getEdgeWt(int outVert, int inVert) {
		 
			return MatrixAdj[outVert][inVert];
		}
	
	
	public int [][] costMatrix(int[][] matrix)
	{
		int costMatrix[][]= new int[Vertice.size()][Vertice.size()];
		if(wheighted)
		{
			
			for (int i=0;i<Vertice.size();i++)
				{
					for(int j=0;j<Vertice.size();j++)
					
					{
						
							if(matrix[i][j]== 1)
							{
								
								costMatrix[i][j]=getCostEdget(i,j);
								//System.out.println("costtt i="+i+" j= "+j+" cost= "+costMatrix[i][j]);
							}else
							{
								costMatrix[i][j]=0;
							}
							System.out.print("  "+costMatrix[i][j]);
						
						
					}System.out.print("\n");
				}
		}
		return costMatrix;
	}
	
	public int getCostEdget(int fromlbl ,int tolbl)
	{
		fromlbl++;
		tolbl++;
		int cost=0;
		for(int i=0;i<Edgets.size();i++)
		{
			//System.out.println("i "+Edgets.get(i).getFrom().getLabel()+" j= "+Edgets.get(i).getTo().getLabel()+" cost= "+Edgets.get(i).getCost());
			if( (Edgets.get(i).getFrom().getLabel()==fromlbl && Edgets.get(i).getTo().getLabel()==tolbl) || (Edgets.get(i).getTo().getLabel()==fromlbl && Edgets.get(i).getFrom().getLabel()==tolbl))
				{
				
				cost =Edgets.get(i).getCost();
				//System.out.println(" cost "+cost+" from "+ fromlbl+" to "+ tolbl);
				}
			 
		}
		return cost;
	}
	
	public Vertex getVertex(int lbl )
	{
		
		for(int i=0 ;i<Vertice.size(); i++ )
		{
			if(Vertice.get(i).getLabel() == lbl)
			{	
				
				return Vertice.get(i);	
			}
		}
		System.out.println("none");
		return new Vertex();
	}
	
	public boolean connexe()
	{
		boolean existed=false;
		for(int i=0; i<Vertice.size();i++)
		{
			for(int ed=0;ed<Edgets.size();ed++)
			{
				if(Edgets.get(ed).getFrom().getPos()== Vertice.get(i).getPos() || Edgets.get(ed).getTo().getPos() == Vertice.get(i).getPos())
				{
					existed=true;
				}
			}
		}
		if(existed && Vertice.size()-1 <= Edgets.size())
		{
			connexe=true;
		}
		return connexe;
	}
	
	
	
	
	
	
	
	
}
