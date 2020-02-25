package searchMinMax;

import java.util.ArrayList;

enum Position{LEFT,RIGHT}

public class State {
	
	
	private int cannibalLeft;
	private int cannibalRight;
	private int missionaryLeft;
	private int missionaryRight;
	private Position boat;
	private State ParentState;
	
	public State(int canLeft,int misLeft,Position boat,int canRight,int misRight) {
		
		cannibalLeft=canLeft;
		cannibalRight=canRight;
		missionaryLeft=misLeft;
		missionaryRight=misRight;
		this.boat=boat;
		
		
		
		
	}
	
	
	
	public boolean isValid() {
		if (missionaryLeft >= 0 && missionaryRight >= 0 && cannibalLeft >= 0 && cannibalRight >= 0
	               && (missionaryLeft == 0 || missionaryLeft >= cannibalLeft)
	               && (missionaryRight == 0 || missionaryRight >= cannibalRight)) {
			return true;
		}
		return false;
		}
	
	public ArrayList<State> generateSuccessors(){
		ArrayList<State> successors = new ArrayList<State>();
		if (boat == Position.LEFT) {
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft - 2, Position.RIGHT,
					cannibalRight, missionaryRight + 2)); // Two missionaries cross left to right.
			testAndAdd(successors, new State(cannibalLeft - 2, missionaryLeft, Position.RIGHT,
					cannibalRight + 2, missionaryRight)); // Two cannibals cross left to right.
			testAndAdd(successors, new State(cannibalLeft - 1, missionaryLeft - 1, Position.RIGHT,
					cannibalRight + 1, missionaryRight + 1)); // One missionary and one cannibal cross left to right.
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft - 1, Position.RIGHT,
					cannibalRight, missionaryRight + 1)); // One missionary crosses left to right.
			testAndAdd(successors, new State(cannibalLeft - 1, missionaryLeft, Position.RIGHT,
					cannibalRight + 1, missionaryRight)); // One cannibal crosses left to right.
		} else {
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft + 2, Position.LEFT,
					cannibalRight, missionaryRight - 2)); // Two missionaries cross right to left.
			testAndAdd(successors, new State(cannibalLeft + 2, missionaryLeft, Position.LEFT,
					cannibalRight - 2, missionaryRight)); // Two cannibals cross right to left.
			testAndAdd(successors, new State(cannibalLeft + 1, missionaryLeft + 1, Position.LEFT,
					cannibalRight - 1, missionaryRight - 1)); // One missionary and one cannibal cross right to left.
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft + 1, Position.LEFT,
					cannibalRight, missionaryRight - 1)); // One missionary crosses right to left.
			testAndAdd(successors, new State(cannibalLeft + 1, missionaryLeft, Position.LEFT,
					cannibalRight - 1, missionaryRight)); // One cannibal crosses right to left.
		}
		return successors;
		
		
	}
	
	
	private void testAndAdd(ArrayList<State> successors, State newState) {
		if (newState.isValid()) {
			newState.setParentState(this);
			successors.add(newState);
		}
	}
	
	
	public int getCannibalLeft() {
		return cannibalLeft;
	}


	public int getCannibalRight() {
		return cannibalRight;
	}


	public int getMissionaryLeft() {
		return missionaryLeft;
	}


	public int getMissionaryRight() {
		return missionaryRight;
	}


	public State getParentState() {
		return ParentState;
	}


	public void setCannibalLeft(int cannibalLeft) {
		this.cannibalLeft = cannibalLeft;
	}


	public void setCannibalRight(int cannibalRight) {
		this.cannibalRight = cannibalRight;
	}


	public void setMissionaryLeft(int missionaryLeft) {
		this.missionaryLeft = missionaryLeft;
	}


	public void setMissionaryRight(int missionaryRight) {
		this.missionaryRight = missionaryRight;
	}


	public void setParentState(State parentState) {
		ParentState = parentState;
	}


	public boolean IsGoal() {
		return (missionaryLeft==0&&cannibalLeft==0);
		
		
	}
	public String toString() {
		if (boat == Position.LEFT) {
			return "(" + cannibalLeft + "," + missionaryLeft + ",L,"
        			+ cannibalRight + "," + missionaryRight + ")";
		} else {
			return "(" + cannibalLeft + "," + missionaryLeft + ",R,"
        			+ cannibalRight + "," + missionaryRight + ")";
		}
     }

}
