package searchMinMax;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		State initialState = new State (3, 3, Position.LEFT, 0, 0);
		executeDLS(initialState);
		
		

	}
	
	
	private static void executeDLS(State initialState) {
		DepthFirstSearch search = new DepthFirstSearch();
		State solution = search.exec(initialState);
		printSolution(solution);
	}
	
	
	private static void printSolution(State solution) {
		if (null == solution) {
			System.out.print("\nNo solution found.");
		} else {
			System.out.println("\nSolution (cannibalLeft,missionaryLeft,boat,cannibalRight,missionaryRight): ");
			ArrayList<State> path = new ArrayList<State>();
			State state = solution;
			while(null!=state) {
				path.add(state);
				state = state.getParentState();
			}

			int depth = path.size() - 1;
			for (int i = depth; i >= 0; i--) {
				state = path.get(i);
				if (state.IsGoal()) {
					System.out.println(state.toString());
				} else {if(state.getParentState()!=null)
					System.out.println(state.getParentState().toString()+" ->"+state.toString() );
				}
			}
			System.out.println("\nDepth: " + depth);
		}
	}

}
