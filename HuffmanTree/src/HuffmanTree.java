import java.util.*;

public class HuffmanTree {
	public static void main(String[] a) {
		ArrayList<Node> nodes=new ArrayList<Node>();
		nodes.add(new Node("A", .35));
		nodes.add(new Node("B", .1));
		nodes.add(new Node("C", .15));
		nodes.add(new Node("D", .15));
		nodes.add(new Node("_", .05));
		nodes=sort(nodes);
		for (Node n:nodes) {
			System.out.println(n);
		}
	}

	public static ArrayList<Node> sort(ArrayList<Node> toSort) {
		Node[] nodes=new Node[toSort.size()];
		for (int i=0; i<nodes.length; i++) {
			nodes[i]=toSort.get(i);
		}
		return bogoSort(nodes);
	}

	public static ArrayList<Node> bogoSort(Node[] list) {
		Random r=new Random();
		hackToAvoidStackOverflowRecursion:while (true) {
			int[] newIndexes=new int[list.length];
			for (int i=0; i<newIndexes.length; i++) {
				newIndexes[i]=r.nextInt(newIndexes.length);
				for (int j=0; j<i; j++) {
					if (newIndexes[i]==newIndexes[j]) {
						//We just told a second number to
						//go to the same position
						i--;//restart outer loop
						j=i;
					}
				}
			}
			ArrayList<Node> toReturn=new ArrayList<Node>();
			for (int i:newIndexes) {
				toReturn.add(list[i]);
			}
			for (int i=0; i<toReturn.size()-1; i++) {
				if (toReturn.get(i).value>toReturn.get(i+1).value)
					continue hackToAvoidStackOverflowRecursion;
			}
			return toReturn;
		}
	}
}
