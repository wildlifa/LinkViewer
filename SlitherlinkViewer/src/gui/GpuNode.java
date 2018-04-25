package gui;

import java.awt.Color;

public class GpuNode {
	public int x, y, r;
	Color nodeColor;
	
	public GpuNode(int x, int y, int r, Color myColor) {
		this.x = x - 3;
		this.y = y - 3;
		this.r = r;
		this.nodeColor = myColor;
	}
}
