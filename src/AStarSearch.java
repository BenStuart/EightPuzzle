import java.util.ArrayList;
import java.util.HashMap;

public class AStarSearch {
	
	//Store nodes that are part of the frontier
	ArrayList<Node> frontier = new ArrayList<Node>();
	// Storage of game states 
	HashMap<Integer, Node> explored = new HashMap<Integer, Node>();
	//empty node to pass in
	Node emptyParent = new Node();
	Node start;
	
	public AStarSearch(GameState initialState) {
		start = new Node(initialState, emptyParent.getAction(), 0, emptyParent);
		// first node - starting node
		start.expand();
	}
	
	public Node search() {
		while(frontier.size() > 0){
			Node path = frontier.get(0);
		}
		return new Node();
	}

	public int getExploredCount() {
		// FIXME: implement this
		return 0;
	}
	
}
