package theoryOfGraphs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;


public class Vertex extends JPanel implements Comparable<Vertex>{
    
	
	private Color color =Color.WHITE;
	private int label;
	private Color lbl_Col = new Color(204, 204, 0);
	private Point pos;
	Font fonte = new Font("TimesRoman ",Font.BOLD,20);
	protected int neibhors;
	
	
	
	public Vertex(Color color, int label, Color lbl_Col, Point pos) {
		super();
		this.color = color;
		this.label = label;
		this.lbl_Col = lbl_Col;
		this.pos = pos;
	}
	public Vertex() {
		this.color = Color.WHITE; 
		this.label = 0;
		this.lbl_Col = null;
		this.pos = null;
	}
	public Vertex(int label,  Point pos) {
		super();
		this.label = label;
		
		this.pos = pos;
	}
	public Vertex(Vertex vertex) {
		super();
		this.color = Color.WHITE;
		this.label = vertex.label;
		this.lbl_Col = vertex.lbl_Col;
		this.pos = vertex.pos;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	public Color getLbl_Col() {
		return lbl_Col;
	}
	public void setLbl_Col(Color lbl_Col) {
		this.lbl_Col = lbl_Col;
	}
	public Point getPos() {
		return pos;
	}
	public void setPos(Point pos) {
		this.pos = pos;
	}
	
	
	public void DrawVertex(Graphics g)
	{
		g.setFont(fonte);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(color);
		g2.fillOval(pos.x-16, pos.y-16, 16*2, 16*2);
		g2.setColor(lbl_Col);
		int labelWidth = g2.getFontMetrics().stringWidth(""+label);
		int labelHeight = g2.getFontMetrics().getHeight();
		g2.drawString(""+label, pos.x-labelWidth/2, pos.y+labelHeight/4);
		color =Color.WHITE;
		lbl_Col = new Color(204, 204, 0);
		
	}
	
	@Override
	public int compareTo(Vertex v) {
		return String.valueOf(this.label).compareTo(String.valueOf(v.label));
	}
	
	
	public int compare(Vertex v) {
		return String.valueOf(this.neibhors).compareTo(String.valueOf(v.neibhors));
	}
}
