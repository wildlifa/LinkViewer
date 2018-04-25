package gui;

import java.awt.Color;

public class GpuCell {
	public int x, y, r;
	Color nodeColor;
	
	public GpuCell(int x, int y, int r, Color myColor) {
		this.x = x - 3;
		this.y = y - 3;
		this.r = r;
		this.nodeColor = myColor;
	}
}
