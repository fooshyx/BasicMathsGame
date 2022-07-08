package game;

public class Node {
	char val;
	Node next;
	
	public Node(char v, Node n) {
		val = v;
		next = n;
	}
	
	@Override
	public String toString() {
		return "" + val;
	}

}
