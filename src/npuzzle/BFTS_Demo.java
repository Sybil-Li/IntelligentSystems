package npuzzle;

import search.BreadthFirstTreeSearch;
import search.TreeSearch;
import search.GraphSearch;
import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;

import search.GoalTest;
import search.Node;

/**
 * 
 * @author Sybil Li
 * 
 * Discussion of results:
 * DFTS runs into an infinite loop
 * BFTS, BTGS, DFGS all return the correct solution
 * In terms of efficiency, BFGS performs the best
 * It generates the least number of nodes, and max frontier size is the smallest
 * In general, graph search is more efficient than tree search
 * And it prevents the algorithm from entering an infinite loop
 *
 */

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		
		GoalTest goalTest = new TilesGoalTest();
//		Node solution = BreadthFirstTreeSearch.findSolution(initialConfiguration, goalTest);
//		new NPuzzlePrinting().printSolution(solution);
		
		Node root = new Node(null, null, initialConfiguration);
		
		TreeSearch BFTS = new TreeSearch(new BreadthFirstFrontier());
		Node s1 = BFTS.findSolution(root, goalTest);
		new NPuzzlePrinting().printSolution(s1);
		BFTS.printCnt();
		BFTS.printMaxFrontier();
		
		
		GraphSearch BFGS = new GraphSearch(new BreadthFirstFrontier());
		Node s2 = BFGS.findSolution(root, goalTest);
		new NPuzzlePrinting().printSolution(s2);
		BFGS.printCnt();
		BFGS.printMaxFrontier();
		
		
//		TreeSearch DFTS = new TreeSearch(new DepthFirstFrontier());
//		Node s3 = DFTS.findSolution(root, goalTest);
//		new NPuzzlePrinting().printSolution(s3);
//		DFTS.printCnt();
//		DFTS.printMaxFrontier();
		
		
		GraphSearch DFGS = new GraphSearch(new DepthFirstFrontier());
		Node s4 = DFGS.findSolution(root, goalTest);
		new NPuzzlePrinting().printSolution(s4);
		DFGS.printCnt();
		DFGS.printMaxFrontier();
		
	}
}
