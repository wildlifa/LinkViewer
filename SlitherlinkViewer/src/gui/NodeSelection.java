package gui;

public class NodeSelection {
	
	public boolean topLeftEdge;
	public boolean bottomRightEdge;
	public boolean topEdge; 
	public boolean bottomEdge;
	public boolean bottomLeftEdge;
	public boolean topRightEdge;
	
	public boolean topRightCell;
	public boolean topLeftCell;
	public boolean bottomCell;
	public boolean topCell;
	public boolean bottomRightCell;
	public boolean bottomLeftCell;
	
	public boolean selfNode;
	
	public NodeSelection() {
		
		topLeftEdge = false;
		bottomRightEdge = false;
		topEdge = false; 
		bottomEdge = false;
		bottomLeftEdge = false;
		topRightEdge = false;		
		
		topRightCell = false;
		topLeftCell = false;
		bottomCell = false;
		topCell = false;
		bottomRightCell = false;
		bottomLeftCell = false;
		
		selfNode = false;

		
	}

}
