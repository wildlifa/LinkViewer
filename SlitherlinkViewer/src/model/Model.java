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

import gui.BufferedCanvas;
import gui.CellSelection;

public class Model {
	
	BufferedCanvas canvas;

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
	
	public void debugCell(int cellID, CellSelection myCellSelection, BufferedCanvas myCanvas) {
		canvas = myCanvas;
		resetDebugColors();
		if (cells.get(cellID) != null) {
			Cell myCell = cells.get(cellID);
			myCell.bottomLeftEdge.edgeBeingDebugged = myCellSelection.bottomLeftEdge;
			myCell.bottomRightEdge.edgeBeingDebugged = myCellSelection.bottomRightEdge;
			myCell.topLeftEdge.edgeBeingDebugged = myCellSelection.topLeftEdge;
			myCell.topRightEdge.edgeBeingDebugged = myCellSelection.topRightEdge;
			myCell.leftEdge.edgeBeingDebugged = myCellSelection.leftEdge;
			myCell.rightEdge.edgeBeingDebugged = myCellSelection.rightEdge;
			if (myCell.topOuterEdge != null) { myCell.topOuterEdge.edgeBeingDebugged = myCellSelection.topOuterEdge; }
			if (myCell.bottomOuterEdge != null) { myCell.bottomOuterEdge.edgeBeingDebugged = myCellSelection.bottomOuterEdge; }
			if (myCell.topLeftOuterEdge != null) { myCell.topLeftOuterEdge.edgeBeingDebugged = myCellSelection.topLeftOuterEdge; }
			if (myCell.topRightOuterEdge != null) { myCell.topRightOuterEdge.edgeBeingDebugged = myCellSelection.topRightOuterEdge; }
			if (myCell.bottomLeftOuterEdge != null) { myCell.bottomLeftOuterEdge.edgeBeingDebugged = myCellSelection.bottomLeftOuterEdge; }
			if (myCell.bottomRightOuterEdge != null) { myCell.bottomRightOuterEdge.edgeBeingDebugged = myCellSelection.bottomRightOuterEdge; }
		} else {
			System.out.println("could not find cell with ID " + cellID);
		}
	}
	
	public void resetDebugColors() {
		for (Map.Entry<Integer, Edge> edge : edges.entrySet()) {
			edge.getValue().edgeBeingDebugged = false;
		}
	}
}
