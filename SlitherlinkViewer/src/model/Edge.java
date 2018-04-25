package model;

public abstract class Edge {
	
	protected static int countID = 0;
	public int edgeID;
	public boolean edgeBeingDebugged = false;
	
	Model model;
	
	UpNode upNode;
	DownNode downNode;
	
	public UpNode getUpNode() {
		return upNode;
	}
	public DownNode getDownNode() {
		return downNode;
	}
		


}
