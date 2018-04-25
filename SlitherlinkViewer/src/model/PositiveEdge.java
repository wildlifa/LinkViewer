package model;

public class PositiveEdge extends Edge {

	public Cell topLeftCell = null;
	public Cell bottomLeftCell = null;
	public Cell topRightCell = null;
	public Cell bottomRightCell = null;
	
	public NegativeEdge leftEdge = null;
	public NegativeEdge rightEdge = null;
	public VerticalEdge topEdge = null;
	public VerticalEdge bottomEdge = null;
	
	public PositiveEdge(Model model, UpNode upNode, DownNode downNode) {
		edgeID = countID;
		countID++;	
		
		this.model = model;
		this.model.edges.put(edgeID, this);
		
		this.upNode = upNode;
		this.downNode = downNode;
	}
}
