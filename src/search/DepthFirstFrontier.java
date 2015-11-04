package search;

import java.util.*;

public class DepthFirstFrontier implements Frontier {
	LinkedList<Node> stack = new LinkedList<Node>();
	
	@Override
	public void addNode(Node n) {
		stack.push(n);
	}

	@Override
	public void clear() {
		stack.clear();		
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Node poll() {
		return stack.pop();
	}
	
	public int size() {
		return stack.size();
	}
}