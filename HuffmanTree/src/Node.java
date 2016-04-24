public class Node {
	public Node left, right;
	public double value;
	public String name;

	public Node(Node left, Node right) {
		this.left=left;
		this.right=right;
		value=left.value+right.value;
	}

	public Node(String name, double frequency) {
		this.name=name;
		value=frequency;
	}

	public String toString() {
		return "{\""+name+"\", "+value+"}";
	}
}
