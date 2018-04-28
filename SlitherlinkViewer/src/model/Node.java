package model;

public abstract class Node {
	
	protected static int countID = 0;
	public int nodeID;
	public boolean nodeBeingDebugged = false;
	public boolean nodeOfInterest = false;
	
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
