package search;
import java.util.*;

public class TreeSearch implements Search {
	protected Frontier f;
	
	public TreeSearch (Frontier frontier) {
		f = frontier;
	}
	
	public Node findSolution(Node root, GoalTest goal) {
		f.addNode(root);
		Node n;
		while (!f.isEmpty()) {
			n = f.poll();
			if (goal.isGoal(n.state)) {
				return n;
			}
			Set<Action> neighbors = (Set<Action>) n.state.getApplicableActions();
			Iterator<Action> c = neighbors.iterator();
			while (c.hasNext()) {
				Action a = c.next();
				f.addNode(new Node(n, a, n.state.getActionResult(a)));
			}
		}
		return null;
		
	}
}
