package model;

public class UpNode extends Node {
	
	public VerticalEdge topEdge = null;
	public PositiveEdge bottomLeftEdge = null;
	public NegativeEdge bottomRightEdge = null;
	
	public Cell topLeftCell = null;
	public Cell topRightCell = null;
	public Cell bottomCell = null;
	
	public UpNode(Model model, int x, int y) {
		
		nodeID = countID;
		countID++;
		
		this.model = model;
		this.model.nodes.put(nodeID, this);
		this.x = (float)x;
		this.y = (float)y;
	}

}
