package search;

import java.util.Iterator;

import java.util.Set;
import java.util.HashSet;

public class GraphSearch {
	protected Frontier f;
	protected HashSet<Integer> visited = new HashSet<Integer>();
	private int cnt = 0;
	private int maxFrontier = 0;
	
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
				if (!visited.contains(result.hashCode())) {
					visited.add(result.hashCode());
					f.addNode(new Node(n, a, result));
					cnt++;
				}
			}
			
			if (f.size() > maxFrontier) {
				maxFrontier = f.size();
			}
		}
		return null;
		
	}
	
	public void printCnt() {
		System.out.println("Number of Nodes Generated: " + cnt);
	}
	
	public void printMaxFrontier() {
		System.out.println("Max Size of Frontier " + maxFrontier);
	}
}
