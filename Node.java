package sjsu.nguyen.cs146.project1;

public class Node {
	private int data;
	private Node link;

	// Empty Constructor
	public Node() {
		this.data = 0;
		this.link = null;
	}

	// One Parameter Constructor
	public Node(int data) {
		this.data = data;
		this.link = null;
	}

	// Main Constructor
	public Node(int data, Node link) {
		this.data = data;
		this.link = link;
	}

	// Returns the next Node
	public Node getNext() {
		return link;
	}

	// Alters the next Node
	public void setNext(Node link) {
		this.link = link;
	}

	// Return value of the Node
	public int getData() {
		return data;

	}
	
	// Alters the data
    public void setData(int data) {
        this.data = data;
    }
    
}
