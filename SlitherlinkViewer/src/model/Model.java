/*
 *  Andrei Croitor
 *  University of Stuttgart
 *  2018 © 
 *  
 *  This class represents a model of the graph including all relations.
 */
package model;

import java.util.HashMap;
import java.util.Map;

import gui.CellSelection;
import gui.NodeSelection;

public class Model {	

	int diameter = 0;
	public HashMap<Integer, Cell> cells = new HashMap<Integer, Cell>();
	public HashMap<Integer, Edge> edges = new HashMap<Integer, Edge>();
	public HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
	
	public Cell initialCell = null;
	public Cell leftScoutCell = null;
	public Cell topGeneralCell = null;
	public Cell topScoutCell = null;
	public Cell bottomGeneralCell = null;
	public Cell bottomScoutCell = null;
	
	public Model(int aDiameter) {
		
		initialCell = new Cell(this, "0");
		leftScoutCell = initialCell;
		topGeneralCell = initialCell;
		bottomGeneralCell = initialCell;
		
		diameter = aDiameter;
		for (int n = 1; n < diameter; n++) {
			leftScoutCell = leftToRightGrowth();
		}
		
		int radius = (diameter + 1) / 2;
		
		for (int m = 1; m < radius; m++) {
			topGeneralCell = firstToTopGrowth();
			topScoutCell = topGeneralCell;
			for (int n = 1; n < diameter-m; n++) {
				topScoutCell = topLeftToRightGrowth();
			}
		}		

		for (int m = 1; m < radius; m++) {
			bottomGeneralCell = firstToBottomGrowth();
			bottomScoutCell = bottomGeneralCell;
			for (int n = 1; n < diameter-m; n++) {
				bottomScoutCell = bottomLeftToRightGrowth();
			}
		}
		

		
	}
	
	private Cell leftToRightGrowth() {
		
		Cell newCell = new Cell(this, "1");
		return newCell;
		
	}
	
	private Cell firstToTopGrowth() {
		
		Cell newCell = new Cell(this, "2");
		return newCell;
		
	}
	
	private Cell topLeftToRightGrowth() {
		
		Cell newCell = new Cell(this, "3");
		return newCell;
		
	}
	
	private Cell firstToBottomGrowth() {
		
		Cell newCell = new Cell(this, "4");
		return newCell;
		
	}
	
	private Cell bottomLeftToRightGrowth() {
		
		Cell newCell = new Cell(this, "5");
		return newCell;
		
	}
	
	public void debugCell(int cellID, CellSelection myCellSelection) {
		resetDebugColors();
		if (cells.get(cellID) != null) {
			Cell myCell = cells.get(cellID);
			
			myCell.cellBeingDebugged = myCellSelection.selfCell;
			
			myCell.bottomLeftEdge.edgeBeingDebugged = myCellSelection.bottomLeftEdge;
			myCell.bottomRightEdge.edgeBeingDebugged = myCellSelection.bottomRightEdge;
			myCell.topLeftEdge.edgeBeingDebugged = myCellSelection.topLeftEdge;
			myCell.topRightEdge.edgeBeingDebugged = myCellSelection.topRightEdge;
			myCell.leftEdge.edgeBeingDebugged = myCellSelection.leftEdge;
			myCell.rightEdge.edgeBeingDebugged = myCellSelection.rightEdge;
			
			myCell.topNode.nodeBeingDebugged = myCellSelection.topNode;
			myCell.bottomNode.nodeBeingDebugged = myCellSelection.bottomNode;
			myCell.topLeftNode.nodeBeingDebugged = myCellSelection.topLeftNode;
			myCell.topRightNode.nodeBeingDebugged = myCellSelection.topRightNode;
			myCell.bottomLeftNode.nodeBeingDebugged = myCellSelection.bottomLeftNode;
			myCell.bottomRightNode.nodeBeingDebugged = myCellSelection.bottomRightNode;
			
			if (myCell.topOuterEdge != null) { myCell.topOuterEdge.edgeBeingDebugged = myCellSelection.topOuterEdge; }
			if (myCell.bottomOuterEdge != null) { myCell.bottomOuterEdge.edgeBeingDebugged = myCellSelection.bottomOuterEdge; }
			if (myCell.topLeftOuterEdge != null) { myCell.topLeftOuterEdge.edgeBeingDebugged = myCellSelection.topLeftOuterEdge; }
			if (myCell.topRightOuterEdge != null) { myCell.topRightOuterEdge.edgeBeingDebugged = myCellSelection.topRightOuterEdge; }
			if (myCell.bottomLeftOuterEdge != null) { myCell.bottomLeftOuterEdge.edgeBeingDebugged = myCellSelection.bottomLeftOuterEdge; }
			if (myCell.bottomRightOuterEdge != null) { myCell.bottomRightOuterEdge.edgeBeingDebugged = myCellSelection.bottomRightOuterEdge; }
			
			if (myCell.leftCell != null) { myCell.leftCell.cellBeingDebugged = myCellSelection.leftCell; }
			if (myCell.rightCell != null) { myCell.rightCell.cellBeingDebugged = myCellSelection.rightCell; }
			if (myCell.topRightCell != null) { myCell.topRightCell.cellBeingDebugged = myCellSelection.topRightCell; }
			if (myCell.topLeftCell != null) { myCell.topLeftCell.cellBeingDebugged = myCellSelection.topLeftCell; }
			if (myCell.bottomLeftCell != null) { myCell.bottomLeftCell.cellBeingDebugged = myCellSelection.bottomLeftCell; }
			if (myCell.bottomRightCell != null) { myCell.bottomRightCell.cellBeingDebugged = myCellSelection.bottomRightCell; }
			
		} else {
			System.out.println("could not find cell with ID " + cellID);
		}
	}
	
	public void debugNodes(int nodeID, NodeSelection myNodeSelection) {
		resetDebugColors();
		if (nodes.get(nodeID) != null) {

			if (nodes.get(nodeID) instanceof model.UpNode){
				UpNode upNode = (UpNode) nodes.get(nodeID);
				if (upNode.bottomLeftEdge != null) upNode.bottomLeftEdge.edgeBeingDebugged = myNodeSelection.bottomLeftEdge;
				if (upNode.bottomRightEdge != null) upNode.bottomRightEdge.edgeBeingDebugged = myNodeSelection.bottomRightEdge;
				if (upNode.topEdge != null) upNode.topEdge.edgeBeingDebugged = myNodeSelection.topEdge;
				if (upNode.bottomCell != null) upNode.bottomCell.cellBeingDebugged = myNodeSelection.bottomCell;
				if (upNode.topLeftCell != null) upNode.topLeftCell.cellBeingDebugged = myNodeSelection.topLeftCell;
				if (upNode.topRightCell != null) upNode.topRightCell.cellBeingDebugged = myNodeSelection.topRightCell;
			}
			
			if (nodes.get(nodeID) instanceof model.DownNode){
				DownNode downNode = (DownNode) nodes.get(nodeID);
				if (downNode.bottomEdge != null) downNode.bottomEdge.edgeBeingDebugged = myNodeSelection.bottomEdge;
				if (downNode.topLeftEdge != null) downNode.topLeftEdge.edgeBeingDebugged = myNodeSelection.topLeftEdge;
				if (downNode.topRightEdge != null) downNode.topRightEdge.edgeBeingDebugged = myNodeSelection.topRightEdge;
				if (downNode.topCell != null) downNode.topCell.cellBeingDebugged = myNodeSelection.topCell;
				if (downNode.bottomLeftCell != null) downNode.bottomLeftCell.cellBeingDebugged = myNodeSelection.bottomLeftCell;
				if (downNode.bottomRightCell != null) downNode.bottomRightCell.cellBeingDebugged = myNodeSelection.bottomRightCell;
			}
		
			nodes.get(nodeID).nodeBeingDebugged = myNodeSelection.selfNode;

			
		} else {
			System.out.println("could not find node with ID " + nodeID);
		}
	}
	
	public void resetDebugColors() {
		for (Map.Entry<Integer, Edge> edge : edges.entrySet()) {
			edge.getValue().edgeBeingDebugged = false;
		}
		
		for (Map.Entry<Integer, Node> node : nodes.entrySet()) {
			node.getValue().nodeBeingDebugged = false;
		} 
		
		for (Map.Entry<Integer, Cell> cell : cells.entrySet()) {
			cell.getValue().cellBeingDebugged = false;
		} 
	}
}
