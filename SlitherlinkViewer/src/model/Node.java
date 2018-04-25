package model;

public abstract class Node {
	
	protected static int countID = 0;
	public int nodeID;
	
	Model model;
	
	float x;
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	float y;

	
}
