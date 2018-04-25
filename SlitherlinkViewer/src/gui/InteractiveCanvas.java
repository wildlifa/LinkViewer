package gui;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Map;

import model.Edge;
import model.Model;
import model.Node;

@SuppressWarnings("serial")
public class InteractiveCanvas extends Canvas {
	
	public Model model;
	float verticalScale = 23;
	float horisontalScale = 20;
	
	public InteractiveCanvas(Model model){
		this.model = model;
	}
	
	public int rescale(float value, float scaleRatio) {
		float resultingFloat = value * scaleRatio;
		int resultingIng = (int)resultingFloat;
		return resultingIng;
		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D)g;
	
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   
		gg.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		gg.setPaint(Color.WHITE);
		gg.fill(new Rectangle2D.Double(0, 0, 600, 600));
		

		gg.translate(100, 250);
		
		//  Draw edges
		
		for (Map.Entry<Integer, Edge> edge : model.edges.entrySet()) {
			gg.setPaint(Color.BLACK);
			if (edge.getValue().edgeBeingDebugged) {
				gg.setPaint(Color.MAGENTA);
			}
			int x1 = rescale(edge.getValue().getDownNode().getX(), horisontalScale);
			int y1 = rescale(edge.getValue().getDownNode().getY(), verticalScale);
			int x2 = rescale(edge.getValue().getUpNode().getX(), horisontalScale);
			int y2 = rescale(edge.getValue().getUpNode().getY(), verticalScale);
		    gg.drawLine(x1, y1, x2, y2);

		}
		
		//  Draw nodes
		for (Map.Entry<Integer, Node> node : model.nodes.entrySet()) {
			gg.setPaint(Color.BLACK);
			int x = rescale(node.getValue().getX(), horisontalScale);
			int y = rescale(node.getValue().getY(), verticalScale);
		    gg.fillOval(x-3, y-3, 7, 7);

		}
		


	}
}
