package searchMinMax;

import java.util.ArrayList;

public class DepthFirstSearch {
	
	public State exec(State initialState) {
		
		
		int limit=50;
		
		return Reculsive_DLS(initialState,limit);
		
		
		
	}
	
	
	
	public State Reculsive_DLS(State state,int limit ){
		if(state.IsGoal()) {return state;}
		else if(limit ==0) {return null;
		}
		else {
			
			ArrayList<State> successors=state.generateSuccessors();
			for(State child:successors) {
				
				State result=Reculsive_DLS(child,limit-1);
				if(result!=null) {return result;}
				
				
				
				
				
			}
			return null;
			
			
		}
	
		
		
	}

}
