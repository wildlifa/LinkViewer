package gui;

public class EdgeSelection {
	
	public boolean topLeftEdge;
	public boolean bottomRightEdge;
	public boolean bottomLeftEdge;
	public boolean topRightEdge;
	
	public boolean bottomNode;
	public boolean topNode;

	public boolean leftCell;
	public boolean bottomCell;
	public boolean topCell;
	public boolean rightCell;

	
	public boolean selfEdge;
	
	public EdgeSelection() {
		
		topLeftEdge = false;
		bottomRightEdge = false;
		bottomLeftEdge = false;
		topRightEdge = false;
		
		bottomNode = false;
		topNode = false;
		
		leftCell = false;
		bottomCell = false;
		topCell = false;
		rightCell = false;
		
		selfEdge = false;

		
	}

}
