import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node {
	private GameState state;
	private GameState.Action action;
	private int pathCost;
	private Node parent;
	
	public Node(){
		
	}
	
	public Node(GameState state, GameState.Action action, int pathCost, Node parent) {
		super();
		this.state = state;
		this.action = action;
		this.pathCost = pathCost;
		this.parent = parent;
	}
	
	public GameState getState() {
		return state;
	}

	public GameState.Action getAction() {
		return action;
	}

	public int getPathCost() {
		return pathCost;
	}

	public Node getParent() {
		return parent;
	}

	public String toString() {
		StringBuilder repr = new StringBuilder();
		repr.append( "Path:      " ).append( getPath() ).append("\n");
		repr.append( "Path cost: " ).append( getPathCost() ).append("\n");
		repr.append( "State:\n" ).append( getState() );
		return repr.toString();
	}

	public List<GameState.Action> getPath() {
		return buildPathList(new ArrayList<GameState.Action>());
	}
	
	private List<GameState.Action> buildPathList(List<GameState.Action> path) {
		if (parent != null) {
			parent.buildPathList(path);
			path.add(action);
		}
		return path;
	}
	
	public Collection<Node> expand() {
		// actions that can be taken for the current game state
		// for each new possible action create a corresponding node with a new state
		
		//Collection of all applicable actions from current game state
		Collection<GameState.Action> collect = state.applicableActions();
		
		ArrayList<Node> toBeReturned = new ArrayList<>();
		
		for (GameState.Action act : collect ){
			//new node with new state(once action is applied), the actual action i.e EAST,WEST..., cost of action (always one) and the parent node.
			Node node = new Node(state.applyAction(act), act, 1, this.parent);
			toBeReturned.add(node);
		}
		return toBeReturned;
	}
}
