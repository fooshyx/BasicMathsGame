package game;

public class CyclicList {
	public Node current;
	int size;
	
	public CyclicList(int s) {
		size = s;
		instantiateList();
	}
	
	public void instantiateList() {
		if (current == null) {
			current = new Node('0', null);
		}
		Node temp = current;
		char count = '1';
		while(Character.getNumericValue(count) < size) {
			temp.next = new Node(count, null);
			temp = temp.next;
			count ++;
		}
		if (Character.getNumericValue(count) == size) {
			temp.next = new Node(count, current);
		}
	}
	

}
