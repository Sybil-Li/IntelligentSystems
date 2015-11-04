package tour;

import npuzzle.NPuzzlePrinting;
import search.BreadthFirstFrontier;
import search.BreadthFirstTreeSearch;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.TreeSearch;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on Romania tour");
		System.out.println();
		
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
//		Node solution = BreadthFirstTreeSearch.findSolution(new TourState(startCity), goalTest);
//		new TourPrinting().printSolution(solution);
		
		Node root = new Node(null, null, new TourState(startCity));
//		
//		TreeSearch BFTS = new TreeSearch(new BreadthFirstFrontier());
//		Node s1 = BFTS.findSolution(root, goalTest);
//		new TourPrinting().printSolution(s1);
//		BFTS.printCnt();
//		BFTS.printMaxFrontier();
		
//		GraphSearch BFGS = new GraphSearch(new BreadthFirstFrontier());
//		Node s2 = BFGS.findSolution(root, goalTest);
//		new TourPrinting().printSolution(s2);
//		BFGS.printCnt();
//		BFGS.printMaxFrontier();
		
		
		TreeSearch DFTS = new TreeSearch(new DepthFirstFrontier());
		Node s3 = DFTS.findSolution(root, goalTest);
		new TourPrinting().printSolution(s3);
		DFTS.printCnt();
		DFTS.printMaxFrontier();
//		
//		
//		GraphSearch DFGS = new GraphSearch(new DepthFirstFrontier());
//		Node s4 = DFGS.findSolution(root, goalTest);
//		new TourPrinting().printSolution(s4);
//		DFGS.printCnt();
//		DFGS.printMaxFrontier();
	}
}
