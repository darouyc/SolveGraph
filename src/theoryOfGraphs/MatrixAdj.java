package theoryOfGraphs;

public class MatrixAdj {

	
	Graph g=new Graph();
	int [][] mat = new int[g.Vertice.size()][g.Vertice.size()];
	
	
	
	public MatrixAdj(Graph g) {
		super();
		this.g = g;
		this.mat= new int[g.Vertice.size()][g.Vertice.size()];
	}
	
	public int[][] cMatrix()
	{
		if(!Graph.isDirected())
		{
			for(int i=0; i<g.getVertice().size();i++)
			{
				System.out.println("Sommet "+g.getVertice().get(i).getPos().x);
				for(int j=0; j<g.getEdgets().size();j++)
				{
					
					if(g.Edgets.get(j).getFrom().getPos()==g.Vertice.get(i).getPos() )
					{
						System.out.print(g.Edgets.get(j).getFrom().getPos().x);
						System.out.println(" =>"+g.Edgets.get(j).getTo().getPos().x);
						System.out.println(" un autre");
						//System.out.println(g.Edgets.get(j).getFrom().getLabel());
						for(int p=0; p<g.getVertice().size();p++)
						{
							if(g.Edgets.get(j).getTo().getPos()==g.Vertice.get(p).getPos() )
							{	//System.out.println(g.Edgets.get(j).getTo().getLabel());
								mat[i][p]=1;
							}
							
					
				        }
			       }else if(g.Edgets.get(j).getTo().getPos()==g.Vertice.get(i).getPos() )
				        {
			    	   System.out.print(g.Edgets.get(j).getTo().getPos().x);
						System.out.println(" <="+g.Edgets.get(j).getFrom().getPos().x);
						System.out.println(" un autre");
			    	   for(int p=0; p<g.getVertice().size();p++)
						{
							if(g.Edgets.get(j).getFrom().getPos()==g.Vertice.get(p).getPos() )
							{	//System.out.println(g.Edgets.get(j).getTo().getLabel());
								mat[i][p]=1;
							}
						
					
				        }
				        }
			   }
			}
		}else {
				for(int i=0; i<g.getVertice().size();i++)
				{
					System.out.println("Sommet "+g.getVertice().get(i).getPos().x);
					for(int j=0; j<g.getEdgets().size();j++)
					{
						
						if(g.Edgets.get(j).getFrom().getPos()==g.Vertice.get(i).getPos() )
						{
							System.out.print(g.Edgets.get(j).getFrom().getPos().x);
							System.out.println(" =>"+g.Edgets.get(j).getTo().getPos().x);
							System.out.println(" un autre");
							//System.out.println(g.Edgets.get(j).getFrom().getLabel());
							for(int p=0; p<g.getVertice().size();p++)
							{
								if(g.Edgets.get(j).getTo().getPos()==g.Vertice.get(p).getPos() )
								{	//System.out.println(g.Edgets.get(j).getTo().getLabel());
									mat[i][p]=1;
								}
								
						
					        }
						}
					}
				 }
			 }
	return mat;
	
}
}