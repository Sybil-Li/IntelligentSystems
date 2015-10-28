package search;

import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;

public class GraphSearch {
	protected Frontier f;
	protected HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
	
	public GraphSearch (Frontier frontier) {
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
				State result = n.state.getActionResult(a);
				if (!visited.containsKey(result.hashCode())) {
					visited.put(result.hashCode(), 0);
					f.addNode(new Node(n, a, result));
				}
			}
		}
		return null;
		
	}
}