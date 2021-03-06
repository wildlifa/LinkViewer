package model;

public class VerticalEdge extends Edge {
	
	public Cell topCell = null;
	public Cell bottomCell = null;
	public Cell leftCell = null;
	public Cell rightCell = null;
	
	public PositiveEdge topRightEdge = null;
	public PositiveEdge bottomLeftEdge = null;
	public NegativeEdge topLeftEdge = null;
	public NegativeEdge bottomRightEdge = null;
	
	public VerticalEdge(Model model, UpNode upNode, DownNode downNode) {
		edgeID = countID;
		countID++;
		
		this.model = model;
		this.model.edges.put(edgeID, this);
		
		this.upNode = upNode;
		this.downNode = downNode;
	}

}
