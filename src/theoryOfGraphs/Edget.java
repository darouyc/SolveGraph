package theoryOfGraphs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;







public class Edget extends JPanel {
	private Color ed_col = Color.BLACK;
	private Vertex from ;
	private Vertex to ;
	private int cost;
	private Color color_arowHead=Color.BLACK;
	private Color color_cost =Color.BLACK;
	
	public Edget( Vertex from, Vertex to) {
		super();
		this.from = from;
		this.to = to;
	}
	public Edget( Vertex from, Vertex to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost; 
	}

	public Color getEd_col() {
		return ed_col;
	}

	public void setEd_col(Color ed_col) {
		this.ed_col = ed_col;
	}

	public Vertex getFrom() {
		return from;
	}

	public void setFrom(Vertex from) {
		this.from = from;
	}

	public Vertex getTo() {
		return to;
	}

	public void setTo(Vertex to) {
		this.to = to;
	}
	
	public void DrawEdget(Graphics2D g2)
	{	
		double var1 = angleBetween(from.getPos(),to.getPos());
		double var2 = angleBetween(to.getPos(),from.getPos());
		
		Point2D pointFrom = getPointOnCircle(from.getPos(), var1, 16);
		Point2D pointTo = getPointOnCircle(to.getPos(), var2, 16);
		
		Line2D line = new Line2D.Double(pointFrom, pointTo);
		g2.setPaint(ed_col);
		if(!from.equals(to))
		{
				if(!Graph.isDirected() && !Graph.isWheighted() )
					{
						g2.setStroke(new BasicStroke(2)); 
						g2.draw(line);
						//g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x-8, to.getPos().y-8 );
						
					}
				else if(Graph.isDirected() && !Graph.isWheighted())
				{
					g2.setStroke(new BasicStroke(2));
					g2.draw(line);
					//g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x, to.getPos().y );
					drawArrowHead(g2,pointTo);
					
				}else if(!Graph.isDirected() && Graph.isWheighted())
				{
					
					g2.setStroke(new BasicStroke(2)); 
					g2.draw(line);
				//	g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x-8, to.getPos().y-8 );
					drawLabel(g2);
					
				}else if(Graph.isDirected() && Graph.isWheighted())
				{
					g2.setStroke(new BasicStroke(2)); 
					g2.draw(line);
				//	g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x, to.getPos().y );
					drawArrowHead(g2,pointTo);
					drawLabel(g2);
					
			}
		}else {
					if(!Graph.isDirected() && !Graph.isWheighted() )
					{
						g2.setStroke(new BasicStroke(2)); 
						g2.drawArc(from.getPos().x-2*Graph.size_vertex/3, from.getPos().y-(Graph.size_vertex+Graph.size_vertex/2), 5*Graph.size_vertex/2, 2*Graph.size_vertex, 0, 360);
						
					}
				else if(!Graph.isDirected() && Graph.isWheighted())
				{
					
					g2.setStroke(new BasicStroke(2)); 
					g2.drawArc(from.getPos().x-2*Graph.size_vertex/3, from.getPos().y-(Graph.size_vertex+Graph.size_vertex/2), 5*Graph.size_vertex/2, 2*Graph.size_vertex, 0, 360);
					drawLabel(g2);
					
				}else if(Graph.isDirected() && Graph.isWheighted())
				{
					g2.setStroke(new BasicStroke(2)); 
					g2.drawArc(from.getPos().x-2*Graph.size_vertex/3, from.getPos().y-(Graph.size_vertex+Graph.size_vertex/2), 5*Graph.size_vertex/2, 2*Graph.size_vertex, 0, 360);
				//	g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x, to.getPos().y );
					drawArrowHead(g2,pointTo);
					drawLabel(g2);
					
				}else if(Graph.isDirected() && !Graph.isWheighted())
				{
					g2.setStroke(new BasicStroke(2));
					g2.drawArc(from.getPos().x-2*Graph.size_vertex/3, from.getPos().y-(Graph.size_vertex+Graph.size_vertex/2), 5*Graph.size_vertex/2, 2*Graph.size_vertex, 0, 360);
					//g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x, to.getPos().y );
					drawArrowHead(g2,pointTo);
					
				}
		}
		
	}
	public void AddEdget(Graphics2D g2)
	{	
		double var1 = angleBetween(from.getPos(),to.getPos());
		double var2 = angleBetween(to.getPos(),from.getPos());
		color_arowHead =new Color(204,229,255);
		Point2D pointFrom = getPointOnCircle(from.getPos(), var1, 16);
		Point2D pointTo = getPointOnCircle(to.getPos(), var2, 16);
		
		Line2D line = new Line2D.Double(pointFrom, pointTo);
		g2.setPaint(ed_col);
		if(!from.equals(to))
		{
				if(!Graph.isDirected() && !Graph.isWheighted() )
					{
						g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0)); 
						g2.draw(line);
						//g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x-8, to.getPos().y-8 );
						
					}
				else if(Graph.isDirected() && !Graph.isWheighted())
				{
					g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
					g2.draw(line);
					//g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x, to.getPos().y );
					drawArrowHead(g2,pointTo);
					
				}else if(!Graph.isDirected() && Graph.isWheighted())
				{
					
					g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0)); 
					g2.draw(line);
				//	g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x-8, to.getPos().y-8 );
					
					
				}else if(Graph.isDirected() && Graph.isWheighted())
				{
					g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0)); 
					g2.draw(line);
				//	g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x, to.getPos().y );
					drawArrowHead(g2,pointTo);
					
					
			}
		}else {
			if(!Graph.isDirected() && !Graph.isWheighted() )
			{
				g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0)); 
				g2.drawArc(from.getPos().x-2*Graph.size_vertex/3, from.getPos().y-(Graph.size_vertex+Graph.size_vertex/2), 5*Graph.size_vertex/2, 2*Graph.size_vertex, 0, 360);
				
			}
			else if(!Graph.isDirected() && Graph.isWheighted())
			{
				
				g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0)); 
				g2.drawArc(from.getPos().x-2*Graph.size_vertex/3, from.getPos().y-(Graph.size_vertex+Graph.size_vertex/2), 5*Graph.size_vertex/2, 2*Graph.size_vertex, 0, 360);
				drawLabel(g2);
				
			}else if(Graph.isDirected() && Graph.isWheighted())
			{
				g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0)); 
				g2.drawArc(from.getPos().x-2*Graph.size_vertex/3, from.getPos().y-(Graph.size_vertex+Graph.size_vertex/2), 5*Graph.size_vertex/2, 2*Graph.size_vertex, 0, 360);
			//	g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x, to.getPos().y );
				drawArrowHead(g2,pointTo);
				
				
			}else if(Graph.isDirected() && !Graph.isWheighted())
			{
				g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
				g2.drawArc(from.getPos().x-2*Graph.size_vertex/3, from.getPos().y-(Graph.size_vertex+Graph.size_vertex/2), 5*Graph.size_vertex/2, 2*Graph.size_vertex, 0, 360);
				//g2.drawLine(from.getPos().x+8, from.getPos().y+8,to.getPos().x, to.getPos().y );
				drawArrowHead(g2,pointTo);
				
			}
		}
			
	}
		
	
	private void drawArrowHead(Graphics2D g2, Point2D poin)
    {	
		double phi = Math.toRadians(25);
        g2.setPaint(color_arowHead);
        double dy = from.getPos().y - to.getPos().y;
        double dx = from.getPos().x - to.getPos().x;
        double theta = Math.atan2(dy, dx);
        //System.out.println("theta = " + Math.toDegrees(theta));
        double x, y, rho = theta + phi;
        for(int j = 0; j < 2; j++)
        {
            x = poin.getX() + 15 * Math.cos(rho);
            y = poin.getY() + 15 * Math.sin(rho);
            g2.draw(new Line2D.Double(poin.getX(), poin.getY(), x, y));
            rho = theta - phi;
        }
       
    }
	public void drawCost(Graphics2D graph2d, int x1, int y1, double x2, double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		double theta = Math.atan2(dy, dx);
		double x = 0, y = 0, rho = theta +Math.toRadians(8);
		x = x2 - 15 * Math.cos(rho);
		y = y2 - 15 * Math.sin(rho);
		graph2d.setFont(new Font("TimesRoman", Font.BOLD, 12));
		graph2d.setColor(color_cost);
		String label = ""+cost;
		graph2d.setStroke(new BasicStroke (2));
		graph2d.drawString(label, (int)x+10, (int)y+10);
	}
	
	public void drawLabel(Graphics2D graph2d) {
		if(Graph.isWheighted()) {
			if(Graph.isDirected()) {
				double dx = to.getPos().x - from.getPos().x;
				double dy = to.getPos().y - from.getPos().y;
				double distance = Math.sqrt(Math.pow(dx, 2)+ Math.pow(dy, 2));
				

				double x_arrow = ((Graph.size_vertex/distance)*(from.getPos().x-to.getPos().x))+to.getPos().x;
				double y_arrow = ((Graph.size_vertex/distance)*(from.getPos().y-to.getPos().y))+to.getPos().y;
				
				drawCost(graph2d, from.getPos().x, from.getPos().y, x_arrow, y_arrow);
			}else if(from != to) {
				int centerX =from.getPos().x + ((to.getPos().x-from.getPos().x)/2);
				int centerY =from.getPos().y+ ((to.getPos().y-from.getPos().y)/2);
				
				double deg = Math.toDegrees(Math.atan2(centerY-to.getPos().y, centerX - to.getPos().x) + Math.PI);
				
				if((deg>90)&& (deg<270)) {
					deg +=180;
				}
				double angle = Math.toRadians(deg);
				String label = ""+ cost;
				
				int sw = graph2d.getFontMetrics().stringWidth(label);
				graph2d.setFont(new Font("TimesRoman", Font.BOLD, 12));
				graph2d.rotate(angle, centerX, centerY);
				graph2d.setColor(color_cost);
				graph2d.drawString(label, centerX - (sw/2), centerY - 7);
				graph2d.rotate(-angle, centerX, centerY);
			}
		}
	}
	
	protected double angleBetween(Point2D from, Point2D to) {
	    double x = from.getX();
	    double y = from.getY();
	    double deltaX = to.getX() - x;
	    double deltaY = to.getY() - y;

	    double rotation = -Math.atan2(deltaX, deltaY);
	    rotation = Math.toRadians(Math.toDegrees(rotation) + 180);

	    return rotation;
	}
	protected Point2D getPointOnCircle(Point2D center, double radians, double radius) {

	    double x = center.getX();
	    double y = center.getY();

	    radians = radians - Math.toRadians(90.0); 
	    double xPosy = Math.round((float) (x + Math.cos(radians) * radius));
	    double yPosy = Math.round((float) (y + Math.sin(radians) * radius));

	    return new Point2D.Double(xPosy, yPosy);

	}
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	public Color getColor_arowHead() {
		return color_arowHead;
	}
	public void setColor_arowHead(Color color_arowHead) {
		this.color_arowHead = color_arowHead;
	}
	public Color getColor_cost() {
		return color_cost;
	}
	public void setColor_cost(Color color_cost) {
		this.color_cost = color_cost;
	}
	
	
	
}
