package gui;

public class NodeSelection {
	
	public boolean topLeftEdge;
	public boolean bottomRightEdge;
	public boolean topEdge; 
	public boolean bottomEdge;
	public boolean bottomLeftEdge;
	public boolean topRightEdge;
	
	public boolean topCell;
	public boolean bottomCell;
	public boolean topRightCell;
	public boolean topLeftCell;
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
		
		topCell = false;
		bottomCell = false;
		topRightCell = false;
		topLeftCell = false;
		bottomRightCell = false;
		bottomLeftCell = false;
		
		selfNode = false;

		
	}

}
