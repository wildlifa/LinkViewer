/*
 *  Andrei Croitor
 *  University of Stuttgart
 *  2018 � 
 *  
 *  This class represents a cell.
 */

package model;

public class Cell {
	
	protected static int countID = 0;
	public int cellID;
	
	Model model;
	public boolean cellBeingDebugged = false;
	public boolean cellOfInterest = false;
	
	public PositiveEdge topLeftEdge = null;
	public PositiveEdge bottomRightEdge = null;
	public VerticalEdge leftEdge = null; 
	public VerticalEdge rightEdge = null;
	public NegativeEdge bottomLeftEdge = null;
	public NegativeEdge topRightEdge = null;
	
	public PositiveEdge topRightOuterEdge = null;
	public PositiveEdge bottomLeftOuterEdge = null;
	public VerticalEdge topOuterEdge = null; 
	public VerticalEdge bottomOuterEdge = null;
	public NegativeEdge bottomRightOuterEdge = null;
	public NegativeEdge topLeftOuterEdge = null;
	
	public Cell rightCell = null;
	public Cell leftCell = null;
	public Cell topRightCell = null;
	public Cell topLeftCell = null;
	public Cell bottomRightCell = null;
	public Cell bottomLeftCell = null;
	
	public UpNode topNode = null;
	public UpNode bottomLeftNode = null;
	public UpNode bottomRightNode = null;
	public DownNode bottomNode = null;
	public DownNode topLeftNode = null;
	public DownNode topRightNode = null;
		
	
	public Cell(Model aModel, String generationType) {
		cellID = countID;
		countID++;		
		model = aModel;
		model.cells.put(cellID, this);

		
		if (generationType.equals("0")) {
			
			//  linking nodes to cell
			topNode = new UpNode(model, 2, 0);
			bottomLeftNode = new UpNode(model, 0, 3);
			bottomRightNode = new UpNode(model, 4, 3);
			bottomNode = new DownNode(model, 2, 4);
			topLeftNode = new DownNode(model, 0, 1);
			topRightNode = new DownNode(model, 4, 1);
			
			//  linking edges to cell
			//  linking nodes to edges
			topLeftEdge = new PositiveEdge(model,  topNode, topLeftNode);
			bottomRightEdge = new PositiveEdge(model, bottomRightNode, bottomNode);
			leftEdge = new VerticalEdge(model, bottomLeftNode, topLeftNode);
			rightEdge = new VerticalEdge(model, bottomRightNode, topRightNode);
			bottomLeftEdge = new NegativeEdge(model, bottomLeftNode, bottomNode);
			topRightEdge = new NegativeEdge(model, topNode, topRightNode);
			
			//  linking edges to nodes
			topNode.bottomLeftEdge = topLeftEdge;
			topNode.bottomRightEdge = topRightEdge;
			
			topLeftNode.bottomEdge = leftEdge;
			topLeftNode.topRightEdge = topLeftEdge;
			
			topRightNode.bottomEdge = rightEdge;
			topRightNode.topLeftEdge = topRightEdge;
			
			bottomNode.topLeftEdge = bottomLeftEdge;
			bottomNode.topRightEdge = bottomRightEdge;
			
			bottomLeftNode.topEdge = leftEdge;
			bottomLeftNode.bottomRightEdge = bottomLeftEdge;
			
			bottomRightNode.topEdge = rightEdge;
			bottomRightNode.bottomLeftEdge = bottomRightEdge;
			
			//  linking cells to nodes
			topNode.bottomCell = this;
			topLeftNode.bottomRightCell = this;
			topRightNode.bottomLeftCell = this;
			bottomNode.topCell = this;
			bottomLeftNode.topRightCell = this;
			bottomRightNode.topLeftCell = this;
			
			//  linking cells to edges
			topLeftEdge.bottomRightCell = this;
			bottomRightEdge.topLeftCell = this;
			leftEdge.rightCell = this;
			rightEdge.leftCell = this;
			bottomLeftEdge.topRightCell = this;
			topRightEdge.bottomLeftCell = this;		
			
			//  linking edges to edges
			topLeftEdge.bottomEdge = leftEdge;
			topLeftEdge.rightEdge = topRightEdge;
			
			bottomRightEdge.topEdge = rightEdge;
			bottomRightEdge.leftEdge = bottomLeftEdge;
			
			leftEdge.bottomRightEdge = bottomLeftEdge;
			leftEdge.topRightEdge = topLeftEdge;
			
			rightEdge.topLeftEdge = topRightEdge;
			rightEdge.bottomLeftEdge = bottomRightEdge;
			
			bottomLeftEdge.topEdge = leftEdge;
			bottomLeftEdge.rightEdge = bottomRightEdge;
			
			topRightEdge.bottomEdge = rightEdge;
			topRightEdge.leftEdge = topLeftEdge;		
					
		}
		
		if (generationType.equals("1")) {
			
			//  linking cells to cells
			leftCell = model.leftScoutCell;
			leftCell.rightCell = this;
			
			//  linking nodes to cell
			topNode = new UpNode(model, (int) leftCell.topNode.getX() + 4, (int) leftCell.topNode.getY());
			bottomLeftNode = leftCell.bottomRightNode;
			bottomRightNode = new UpNode(model, (int) leftCell.bottomRightNode.getX() + 4, (int) leftCell.bottomRightNode.getY());
			bottomNode = new DownNode(model, (int) leftCell.bottomNode.getX() + 4, (int) leftCell.bottomNode.getY());
			topLeftNode = leftCell.topRightNode;
			topRightNode = new DownNode(model, (int) leftCell.topRightNode.getX() + 4, (int) leftCell.topRightNode.getY());
			
			//  linking edges to cells
			//  linking nodes to edges
			topLeftEdge = new PositiveEdge(model,  topNode, topLeftNode);
			bottomRightEdge = new PositiveEdge(model, bottomRightNode, bottomNode);
			leftEdge = leftCell.rightEdge;
			rightEdge = new VerticalEdge(model, bottomRightNode, topRightNode);
			bottomLeftEdge = new NegativeEdge(model, bottomLeftNode, bottomNode);
			topRightEdge = new NegativeEdge(model, topNode, topRightNode);
					
			//  linking edges to nodes
			topNode.bottomLeftEdge = topLeftEdge;
			topNode.bottomRightEdge = topRightEdge;
			
			topLeftNode.topRightEdge = topLeftEdge;
			
			topRightNode.bottomEdge = rightEdge;
			topRightNode.topLeftEdge = topRightEdge;
			
			bottomNode.topLeftEdge = bottomLeftEdge;
			bottomNode.topRightEdge = bottomRightEdge;
			
			bottomLeftNode.bottomRightEdge = bottomLeftEdge;
			
			bottomRightNode.topEdge = rightEdge;
			bottomRightNode.bottomLeftEdge = bottomRightEdge;
			
			//  linking cells to nodes
			topNode.bottomCell = this;
			topLeftNode.bottomRightCell = this;
			topRightNode.bottomLeftCell = this;
			bottomNode.topCell = this;
			bottomLeftNode.topRightCell = this;
			bottomRightNode.topLeftCell = this;
			
			//  linking cells to edges
			topLeftEdge.bottomRightCell = this;
			bottomRightEdge.topLeftCell = this;
			leftEdge.rightCell = this;
			rightEdge.leftCell = this;
			bottomLeftEdge.topRightCell = this;
			topRightEdge.bottomLeftCell = this;
			
			topLeftEdge.bottomLeftCell = leftCell;
			bottomLeftEdge.topLeftCell = leftCell;
			
			leftCell.topRightEdge.bottomRightCell = this;
			leftCell.bottomRightEdge.topRightCell = this;
			
			//  linking edges to edges
			topLeftEdge.bottomEdge = leftEdge;
			topLeftEdge.rightEdge = topRightEdge;
			topLeftEdge.leftEdge = leftCell.topRightEdge;
			
			bottomRightEdge.topEdge = rightEdge;
			bottomRightEdge.leftEdge = bottomLeftEdge;
			
			leftEdge.bottomRightEdge = bottomLeftEdge;
			leftEdge.topRightEdge = topLeftEdge;
			
			rightEdge.topLeftEdge = topRightEdge;
			rightEdge.bottomLeftEdge = bottomRightEdge;
			
			bottomLeftEdge.topEdge = leftEdge;
			bottomLeftEdge.rightEdge = bottomRightEdge;
			bottomLeftEdge.leftEdge = leftCell.bottomRightEdge;
			
			topRightEdge.bottomEdge = rightEdge;
			topRightEdge.leftEdge = topLeftEdge;
			
			leftCell.bottomRightEdge.rightEdge = bottomLeftEdge;
			leftCell.topRightEdge.rightEdge = topLeftEdge;
			
			topLeftOuterEdge = leftCell.topRightEdge;
			bottomLeftOuterEdge = leftCell.bottomRightEdge;
			leftCell.topRightOuterEdge = topLeftEdge;
			leftCell.bottomRightOuterEdge = bottomLeftEdge;
		}
		
		if (generationType.equals("2")) {
			
			//  linking cells to cells
			bottomLeftCell = model.topGeneralCell;
			bottomLeftCell.topRightCell = this;
			bottomRightCell = bottomLeftCell.rightCell;
			bottomRightCell.topLeftCell = this;
			
			//  linking nodes to cell
			topNode = new UpNode(model, (int) bottomLeftCell.topRightNode.getX(), (int) bottomLeftCell.topRightNode.getY() - 4);
			bottomLeftNode = bottomLeftCell.topNode;
			bottomRightNode = bottomRightCell.topNode;
			bottomNode = bottomLeftCell.topRightNode;
			topLeftNode = new DownNode(model, (int) bottomLeftCell.topNode.getX(), (int) (int) bottomLeftCell.topNode.getY() - 2);
			topRightNode = new DownNode(model, (int) bottomRightCell.topNode.getX(), (int) bottomRightCell.topNode.getY() - 2);
			
			
			//  linking edges to cells
			//  linking nodes to edges
			topLeftEdge = new PositiveEdge(model,  topNode, topLeftNode);
			bottomRightEdge = bottomRightCell.topLeftEdge;
			leftEdge = new VerticalEdge(model, bottomLeftNode, topLeftNode);
			rightEdge = new VerticalEdge(model, bottomRightNode, topRightNode);
			bottomLeftEdge = bottomLeftCell.topRightEdge;
			topRightEdge = new NegativeEdge(model, topNode, topRightNode);
			
			//  linking edges to nodes
			topNode.bottomLeftEdge = topLeftEdge;
			topNode.bottomRightEdge = topRightEdge;
					
			topLeftNode.topRightEdge = topLeftEdge;
			topLeftNode.bottomEdge = leftEdge;
					
			topRightNode.bottomEdge = rightEdge;
			topRightNode.topLeftEdge = topRightEdge;				
					
			bottomLeftNode.topEdge = leftEdge;
					
			bottomRightNode.topEdge = rightEdge;
			
			//  linking cells to nodes
			topNode.bottomCell = this;
			topLeftNode.bottomRightCell = this;
			topRightNode.bottomLeftCell = this;
			bottomNode.topCell = this;
			bottomLeftNode.topRightCell = this;
			bottomRightNode.topLeftCell = this;
			
			//  linking cells to edges
			topLeftEdge.bottomRightCell = this;
			bottomRightEdge.topLeftCell = this;
			leftEdge.rightCell = this;
			rightEdge.leftCell = this;
			bottomLeftEdge.topRightCell = this;
			topRightEdge.bottomLeftCell = this;
			
			leftEdge.bottomCell = bottomLeftCell;
			rightEdge.bottomCell = bottomRightCell;
			bottomRightEdge.bottomLeftCell = bottomLeftCell;
			
			bottomLeftCell.topLeftEdge.topRightCell = this;
			bottomLeftCell.rightEdge.topCell = this;
			bottomRightCell.topRightEdge.topLeftCell = this;

			//  linking edges to edges
			topLeftEdge.bottomEdge = leftEdge;
			topLeftEdge.rightEdge = topRightEdge;
			
			bottomRightEdge.topEdge = rightEdge;
			
			leftEdge.bottomRightEdge = bottomLeftEdge;
			leftEdge.topRightEdge = topLeftEdge;
			leftEdge.bottomLeftEdge = bottomLeftCell.topLeftEdge;
			
			rightEdge.topLeftEdge = topRightEdge;
			rightEdge.bottomLeftEdge = bottomRightEdge;
			rightEdge.bottomRightEdge = bottomRightCell.topRightEdge;
			
			bottomLeftEdge.topEdge = leftEdge;
			
			topRightEdge.bottomEdge = rightEdge;
			topRightEdge.leftEdge = topLeftEdge;
			
			bottomLeftCell.topLeftEdge.topEdge = leftEdge;
			bottomRightCell.topRightEdge.topEdge = rightEdge;
			
			bottomLeftOuterEdge = bottomLeftCell.topLeftEdge;
			bottomOuterEdge = bottomLeftCell.rightEdge;
			bottomRightOuterEdge = bottomRightCell.topRightEdge;
			
			bottomLeftCell.topOuterEdge = leftEdge;
			bottomRightCell.topOuterEdge = rightEdge;
		}
		
		if (generationType.equals("3")) {
			
			//  linking cells to cells
			leftCell = model.topScoutCell;
			leftCell.rightCell = this;		
			bottomLeftCell = leftCell.bottomRightCell;
			bottomRightCell = bottomLeftCell.rightCell;
			bottomLeftCell.topRightCell = this;
			bottomRightCell.topLeftCell = this;
			
			//  linking nodes to cell
			topNode = new UpNode(model, (int) leftCell.topNode.getX() + 4, (int) leftCell.topNode.getY());
			bottomLeftNode = leftCell.bottomRightNode;
			bottomRightNode = bottomRightCell.topNode;
			bottomNode = bottomRightCell.topLeftNode;
			topLeftNode = leftCell.topRightNode;
			topRightNode = new DownNode(model, (int) leftCell.topRightNode.getX() + 4, (int) leftCell.topRightNode.getY());
			
			//  linking edges to cell
			//  linking nodes to edges
			topLeftEdge = new PositiveEdge(model,  topNode, topLeftNode);
			bottomRightEdge = bottomRightCell.topLeftEdge;
			leftEdge = leftCell.rightEdge;
			rightEdge = new VerticalEdge(model, bottomRightNode, topRightNode);
			bottomLeftEdge = bottomLeftCell.topRightEdge;
			topRightEdge = new NegativeEdge(model, topNode, topRightNode);
			
			//  linking edges to nodes
			topNode.bottomLeftEdge = topLeftEdge;
			topNode.bottomRightEdge = topRightEdge;
					
			topLeftNode.topRightEdge = topLeftEdge;
					
			topRightNode.bottomEdge = rightEdge;
			topRightNode.topLeftEdge = topRightEdge;				
								
			bottomRightNode.topEdge = rightEdge;
			
			//  linking cells to nodes
			topNode.bottomCell = this;
			topLeftNode.bottomRightCell = this;
			topRightNode.bottomLeftCell = this;
			bottomNode.topCell = this;
			bottomLeftNode.topRightCell = this;
			bottomRightNode.topLeftCell = this;
			
			//  linking cells to edges
			topLeftEdge.bottomRightCell = this;
			bottomRightEdge.topLeftCell = this;
			leftEdge.rightCell = this;
			rightEdge.leftCell = this;
			bottomLeftEdge.topRightCell = this;
			topRightEdge.bottomLeftCell = this;
			
			rightEdge.bottomCell = bottomRightCell;
			topLeftEdge.bottomLeftCell = leftCell;
			
			bottomLeftCell.topLeftEdge.topRightCell = this;
			bottomLeftCell.rightEdge.topCell = this;
			bottomRightCell.topRightEdge.topLeftCell = this;
			leftCell.topRightEdge.bottomRightCell = this;
			
			//  linking edges to edges
			topLeftEdge.bottomEdge = leftEdge;
			topLeftEdge.rightEdge = topRightEdge;
			topLeftEdge.leftEdge = leftCell.topRightEdge;
			
			bottomRightEdge.topEdge = rightEdge;
			
			leftEdge.topRightEdge = topLeftEdge;
			
			rightEdge.topLeftEdge = topRightEdge;
			rightEdge.bottomLeftEdge = bottomRightEdge;
			rightEdge.bottomRightEdge = bottomRightCell.topRightEdge;

			topRightEdge.bottomEdge = rightEdge;
			topRightEdge.leftEdge = topLeftEdge;
			
			bottomRightCell.topRightEdge.topEdge = rightEdge;
			
			topLeftOuterEdge = leftCell.topRightEdge;
			bottomLeftOuterEdge = leftCell.bottomRightEdge;
			bottomOuterEdge = bottomLeftCell.rightEdge;
			bottomRightOuterEdge = bottomRightCell.topRightEdge;
			
			leftCell.topRightEdge.rightEdge = topLeftEdge;
			
			leftCell.topRightOuterEdge = topLeftEdge;
			bottomRightCell.topOuterEdge = rightEdge;

		}
		
		if (generationType.equals("4")) { 
			
			//  linking cells to cells
			topLeftCell = model.bottomGeneralCell;
			topLeftCell.bottomRightCell = this;
			topRightCell = topLeftCell.rightCell;
			topRightCell.bottomLeftCell = this;
			
			//  linking nodes to cell 
			topNode = topLeftCell.bottomRightNode;
			bottomLeftNode = new UpNode(model, (int) topLeftCell.bottomNode.getX(), (int) (int) topLeftCell.bottomNode.getY() + 2);
			bottomRightNode = new UpNode(model, (int) topRightCell.bottomNode.getX(), (int) (int) topRightCell.bottomNode.getY() + 2);
			bottomNode = new DownNode(model, (int) topLeftCell.bottomRightNode.getX(), (int) (int) topLeftCell.bottomRightNode.getY() + 4);
			topLeftNode = topLeftCell.bottomNode;
			topRightNode = topRightCell.bottomNode;
			
			
			//  linking edges to cells
			//  linking nodes to edges 
			topLeftEdge = topLeftCell.bottomRightEdge;
			bottomRightEdge = new PositiveEdge(model, bottomRightNode, bottomNode);
			leftEdge = new VerticalEdge(model, bottomLeftNode, topLeftNode);
			rightEdge = new VerticalEdge(model, bottomRightNode, topRightNode);
			bottomLeftEdge = new NegativeEdge(model, bottomLeftNode, bottomNode);
			topRightEdge = topRightCell.bottomLeftEdge;
			
			//  linking edges to nodes 
			bottomNode.topLeftEdge = bottomLeftEdge;
			bottomNode.topRightEdge = bottomRightEdge;
					
			bottomLeftNode.bottomRightEdge = bottomLeftEdge;
			bottomLeftNode.topEdge = leftEdge;
					
			topLeftNode.bottomEdge = leftEdge;
			
			topRightNode.bottomEdge = rightEdge;
					
			bottomRightNode.topEdge = rightEdge;
			bottomRightNode.bottomLeftEdge = bottomRightEdge;
			
			//  linking cells to nodes
			topNode.bottomCell = this;
			topLeftNode.bottomRightCell = this;
			topRightNode.bottomLeftCell = this;
			bottomNode.topCell = this;
			bottomLeftNode.topRightCell = this;
			bottomRightNode.topLeftCell = this;
			
			//  linking cells to edges
			topLeftEdge.bottomRightCell = this;
			bottomRightEdge.topLeftCell = this;
			leftEdge.rightCell = this;
			rightEdge.leftCell = this;
			bottomLeftEdge.topRightCell = this;
			topRightEdge.bottomLeftCell = this;
			
			leftEdge.topCell = topLeftCell;
			rightEdge.topCell = topRightCell;
			
			topLeftCell.bottomLeftEdge.bottomRightCell = this;
			topLeftCell.rightEdge.bottomCell = this;
			topRightCell.bottomRightEdge.bottomLeftCell = this;

			//  linking edges to edges
			topLeftEdge.bottomEdge = leftEdge;
			
			topRightEdge.bottomEdge = rightEdge;
			
			bottomRightEdge.topEdge = rightEdge;
			bottomRightEdge.leftEdge = bottomLeftEdge;
			
			bottomLeftEdge.topEdge = leftEdge;
			bottomLeftEdge.rightEdge = bottomRightEdge;
			
			leftEdge.bottomRightEdge = bottomLeftEdge;
			leftEdge.topRightEdge = topLeftEdge;
			leftEdge.topLeftEdge = topLeftCell.bottomLeftEdge;			
			
			rightEdge.topLeftEdge = topRightEdge;
			rightEdge.bottomLeftEdge = bottomRightEdge;
			rightEdge.topRightEdge = topRightCell.bottomRightEdge;			
			
			topLeftCell.bottomLeftEdge.bottomEdge = leftEdge;
			topRightCell.bottomRightEdge.bottomEdge = rightEdge;
			
			topLeftOuterEdge = topLeftCell.bottomLeftEdge;
			topOuterEdge = topLeftCell.rightEdge;
			topRightOuterEdge = topRightCell.bottomRightEdge;
			
			topLeftCell.bottomOuterEdge = leftEdge;
			topRightCell.bottomOuterEdge = rightEdge;
		}
		
			if (generationType.equals("5")) { 
			
			//  linking cells to cells
			leftCell = model.bottomScoutCell;
			leftCell.rightCell = this;		
			topLeftCell = leftCell.topRightCell;
			topRightCell = topLeftCell.rightCell;
			topLeftCell.bottomRightCell = this;
			topRightCell.bottomLeftCell = this;
			
			//  linking nodes to cell
			topNode = topRightCell.bottomLeftNode;
			bottomLeftNode = leftCell.bottomRightNode;
			bottomRightNode = new UpNode(model, (int) topRightCell.bottomNode.getX(), (int) topRightCell.bottomNode.getY() + 2);
			bottomNode = new DownNode(model, (int) topRightCell.bottomLeftNode.getX(), (int) topRightCell.bottomLeftNode.getY() + 4);
			topLeftNode = leftCell.topRightNode;
			topRightNode = topRightCell.bottomNode;
			
			//  linking edges to cell
			//  linking nodes to edges
			topLeftEdge = topLeftCell.bottomRightEdge;
			bottomRightEdge = new PositiveEdge(model, bottomRightNode, bottomNode);
			leftEdge = leftCell.rightEdge;
			rightEdge = new VerticalEdge(model, bottomRightNode, topRightNode);
			bottomLeftEdge = new NegativeEdge(model, bottomLeftNode, bottomNode);
			topRightEdge = topRightCell.bottomLeftEdge;
			
			//  linking edges to nodes 
			bottomNode.topLeftEdge = bottomLeftEdge;
			bottomNode.topRightEdge = bottomRightEdge;
					
			bottomLeftNode.bottomRightEdge = bottomLeftEdge;
					
			bottomRightNode.topEdge = rightEdge;
			bottomRightNode.bottomLeftEdge = bottomRightEdge;					
								
			topRightNode.bottomEdge = rightEdge;
			
			//  linking cells to nodes
			topNode.bottomCell = this;
			topLeftNode.bottomRightCell = this;
			topRightNode.bottomLeftCell = this;
			bottomNode.topCell = this;
			bottomLeftNode.topRightCell = this;
			bottomRightNode.topLeftCell = this;
			
			//  linking cells to edges
			topLeftEdge.bottomRightCell = this;
			bottomRightEdge.topLeftCell = this;
			leftEdge.rightCell = this;
			rightEdge.leftCell = this;
			bottomLeftEdge.topRightCell = this;
			topRightEdge.bottomLeftCell = this;
			
			rightEdge.topCell = topRightCell;
			bottomLeftEdge.topLeftCell = leftCell;
			
			topLeftCell.bottomLeftEdge.bottomRightCell = this;
			topLeftCell.rightEdge.bottomCell = this;
			topRightCell.bottomRightEdge.bottomLeftCell = this;
			leftCell.bottomRightEdge.topRightCell = this;
			
			//  linking edges to edges
			bottomLeftEdge.topEdge = leftEdge;
			bottomLeftEdge.rightEdge = bottomRightEdge;
			bottomLeftEdge.leftEdge = leftCell.bottomRightEdge;
			
			topRightEdge.bottomEdge = rightEdge;
			
			leftEdge.bottomRightEdge = bottomLeftEdge;
			
			rightEdge.topLeftEdge = topRightEdge;
			rightEdge.bottomLeftEdge = bottomRightEdge;
			rightEdge.topRightEdge = topRightCell.bottomRightEdge;
			
			bottomRightEdge.topEdge = rightEdge;
			bottomRightEdge.leftEdge = bottomLeftEdge;
			
			bottomLeftOuterEdge = leftCell.bottomRightEdge;
			topLeftOuterEdge = leftCell.topRightEdge;
			topOuterEdge = topLeftCell.rightEdge;
			topRightOuterEdge = topRightCell.bottomRightEdge;
			
			leftCell.bottomRightEdge.rightEdge = bottomLeftEdge;
			topRightCell.bottomRightEdge.bottomEdge = rightEdge;
			
			leftCell.bottomRightOuterEdge = bottomLeftEdge;
			topRightCell.bottomOuterEdge = rightEdge;

		}

	}
	
}
