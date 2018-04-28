package gui;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Map;

import model.Cell;
import model.Edge;
import model.Model;
import model.Node;

public class BufferedCanvas extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private boolean running;
	private Thread t1;
	
	public Model model;
	float verticalScale = 23;
	float horisontalScale = 20;
	private ArrayList<GpuLine> lines;
	private ArrayList<GpuNode> nodes;
	private ArrayList<GpuCell> cells;
	
	public synchronized void start(){
	    running = true;
	    t1 = new Thread (this);
	    t1.start(); // calls run()
	}
	
	public BufferedCanvas(Model model){
		this.model = model;
		lines = new ArrayList<GpuLine>();
		nodes = new ArrayList<GpuNode>();
		cells = new ArrayList<GpuCell>();
	}
	
	public void run(){

		while (running){   
			    update();
		    	draw();
			    try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		    					
		}

	}
	
	public void update() {
		lines.clear();
		for (Map.Entry<Integer, Edge> edge : model.edges.entrySet()) {
			int x1 = rescale(edge.getValue().getDownNode().getX(), horisontalScale);
			int y1 = rescale(edge.getValue().getDownNode().getY(), verticalScale);
			int x2 = rescale(edge.getValue().getUpNode().getX(), horisontalScale);
			int y2 = rescale(edge.getValue().getUpNode().getY(), verticalScale);
			
			if (edge.getValue().edgeBeingDebugged) {
				lines.add(new GpuLine(x1, y1, x2, y2, Color.MAGENTA));
			} else {
				if (edge.getValue().edgeOfInterest) {
					lines.add(new GpuLine(x1, y1, x2, y2, Color.CYAN));
				} else {
					lines.add(new GpuLine(x1, y1, x2, y2, Color.BLACK));
				}				
			}
		}
		
		nodes.clear();
		for (Map.Entry<Integer, Node> node : model.nodes.entrySet()) {
			int x = rescale(node.getValue().getX(), horisontalScale);
			int y = rescale(node.getValue().getY(), verticalScale);
			if (node.getValue().nodeBeingDebugged) {
				nodes.add(new GpuNode(x, y, 7, Color.MAGENTA));
			} else {
				if (node.getValue().nodeOfInterest) {
					nodes.add(new GpuNode(x, y, 7, Color.CYAN));	
				} else {
					nodes.add(new GpuNode(x, y, 7, Color.BLACK));	
				}				
			}
			
		}
		
		cells.clear();
		for (Map.Entry<Integer, Cell> cell : model.cells.entrySet()) {
			if (cell.getValue().cellBeingDebugged) {
				int modelX = (int) cell.getValue().topNode.getX();
				int modelY = (int) ((cell.getValue().topNode.getY() + cell.getValue().bottomNode.getY()) / 2.0f);
				int x = rescale(modelX, horisontalScale);
				int y = rescale(modelY, verticalScale);
				cells.add(new GpuCell(x, y, 71, new Color(255, 200, 255)));
			} else {
				if (cell.getValue().cellOfInterest) {
					int modelX = (int) cell.getValue().topNode.getX();
					int modelY = (int) ((cell.getValue().topNode.getY() + cell.getValue().bottomNode.getY()) / 2.0f);
					int x = rescale(modelX, horisontalScale);
					int y = rescale(modelY, verticalScale);
					cells.add(new GpuCell(x, y, 71, Color.CYAN));
				}
			}
			
		}
	}
	
	public int rescale(float value, float scaleRatio) {
		float resultingFloat = value * scaleRatio;
		int resultingIng = (int)resultingFloat;
		return resultingIng;		
	}
	
	
	public void draw(){
		BufferStrategy bs = getBufferStrategy();
		if (bs== null) {
			   createBufferStrategy(3);
			   return;
		}

		Graphics2D gg = (Graphics2D) bs.getDrawGraphics();  
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   
		gg.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
			
		gg.setPaint(Color.WHITE);
		gg.fill(new Rectangle2D.Double(0, 0, 600, 600));
			

		gg.translate(100, 250);
			
		//  Draw edges			
		for (GpuLine line : lines) {
			gg.setPaint(line.lineColor);
			gg.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
			
		//  Draw nodes
		for (GpuNode node : nodes) {
			gg.setPaint(node.nodeColor);
			gg.fillOval(node.x, node.y, node.r, node.r);
		}
			
		//  Draw nodes
		for (GpuCell cell : cells) {
			gg.setPaint(cell.nodeColor);
			gg.fillOval(cell.x, cell.y, cell.r, cell.r);
		}
		
		gg.dispose();
		bs.show();
	}

}
