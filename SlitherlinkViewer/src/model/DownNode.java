package model;

public class DownNode extends Node{
	
	public VerticalEdge bottomEdge = null;
	public PositiveEdge topRightEdge = null;
	public NegativeEdge topLeftEdge = null;
	
	public Cell topCell = null;
	public Cell bottomLeftCell = null;
	public Cell bottomRightCell = null;
	
	public DownNode(Model model, int x, int y) {
		
		nodeID = countID;
		countID++;
		
		this.model = model;
		this.model.nodes.put(nodeID, this);
		this.x = (float)x;
		this.y = (float)y;
		
	}


}
