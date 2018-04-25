package gui;

import java.awt.Color;

public class GpuLine {
	
	public int x1, y1, x2, y2;
	Color lineColor;
	
	public GpuLine(int x1, int y1, int x2, int y2, Color myColor) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.lineColor = myColor;
	}

}
