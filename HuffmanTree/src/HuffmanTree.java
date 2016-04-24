import java.util.*;

public class HuffmanTree {
	private static String[] symbols;

	public static void main(String[] a) {
		ArrayList<Node> nodes=getInput();
		while(nodes.size()>1) {
			nodes=sort(nodes);
			nodes.add(new Node(nodes.get(0), nodes.get(1)));
			nodes.remove(0);
			nodes.remove(0);
		}
		System.out.println("The Huffman code for the given characters is:");
		for (String s:symbols) {
			findSymbol(s, nodes.get(0), "");
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

	public static ArrayList<Node> getInput() {
		ArrayList<Node> toReturn=new ArrayList<Node>();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the symbols, each seperated by a space:");
		symbols=s.nextLine().split(" ");
		System.out.println("Enter the frequency of each corresponding symbol, each seperated by a space");
		String[] frequenciesAsString=s.nextLine().split(" ");
		for (int i=0; i<symbols.length; i++) {
			if (symbols[i].isEmpty())
				continue;
			toReturn.add(new Node(symbols[i], Double.parseDouble(frequenciesAsString[i])));
		}
		return toReturn;
	}

	public static void findSymbol(String s, Node head, String previousCode) {
		if () {
			
		}
	}
}
