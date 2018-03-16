package sjsu.nguyen.cs146.project1;

public class CircularLinkedList {
	public int size;
	private Node head;
	private Node tail;

	// Constructor
	public CircularLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	// Main Constructor
	public CircularLinkedList(int size) {
		this.size = size;
		for (int i = size; i >= 1; i--) {
			insertBeginning(i);
		}

		// COMMENT THE FOLLOWING STATEMENT TO CHANGE FROM Circular LinkedList to LinkedList
		tail.setNext(head);
	}

	// Checks if LinkedList is empty
	public boolean isEmpty() {
		return head == null;
	}

	// Returns the size
	public int getSize() {
		return size;
	}
	
	// Adds more nodes to the beginning
	public void insert(int value) {
		insertBeginning(value);
		size++;
	}

	// Appends the data to the beginning
	public void insertBeginning(int n) {
		Node node = new Node(n);

		// General case
		node.setNext(head);
		head = node;
		if (tail == null) {
			tail = node;
		}

		// System.out.println("HEAD: " + getHead());
		// System.out.println("TAIL: " + getTail());
	}

	// Deletes node at position
	public void deleteNode(int k) {

		for (int i = 0; i < size - 1; i++) {
			head = head.getNext();
			//System.out.println("MOVE: " + head.getData());
		}

		// for (int i = 0; i < k; i++) {
		head.setNext(head.getNext().getNext());
		head = head.getNext();
		//System.out.println("CURRENT: " + head.getData());
		size--;
	}

	public int winner(int k) {
		CircularLinkedList temp = new CircularLinkedList(size);

		while (temp.size != 1) {

			for (int i = 0; i < k; i++) {
				temp.head = temp.head.getNext();
				//System.out.println("TRANVERSAL: " + temp.head.getData());
			}

			//System.out.println("DELETE: " + temp.head.getData());
			temp.deleteNode(k);
			// temp.head = temp.head.getNext();
			//System.out.println("HEAD: " + temp.head.getData());
			//System.out.println();

		}

		return temp.head.getData();
	}

	// String representation of the LinkedList
	// Only works for Non-Circular LinkedList
	public String toString() {
		String result = head.getData() + " -> ";
		Node current = head;
		while (current.getNext() != null) {
			// System.out.println("DEBUGG");
			current = current.getNext();
			// For the comma at the tail
			if (current.getNext() == null) {
				result += current.getData();
				break;
			}
			result += current.getData() + " -> ";
		}
		return "List: " + result;
	}

	// Main Method
	public static void main(String[] args) {
		// Change these values for assignment
		int prisoners = 1;
		int jumps = 9;
		
		CircularLinkedList l = new CircularLinkedList(prisoners);
		System.out.println("Prisoners: " + prisoners);
		System.out.println("Jumps: " + jumps);
		System.out.println("Winner: " + l.winner(jumps));

	}
}
