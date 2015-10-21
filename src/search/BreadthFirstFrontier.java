package search;

import java.util.*;

public class BreadthFirstFrontier implements Frontier {
	LinkedList<Node> queue = new LinkedList<Node>();
	
	@Override
	public void addNode(Node n) {
		queue.offer(n);
	}

	@Override
	public void clear() {
		queue.clear();		
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Node poll() {
		return queue.poll();
	}
	
}