
public class CombinationLock {
	//the following three integers are the combination
	private int firstRight;
	private int left;
	private int secondRight;
	
	private int dialPosition; // valid for integers 0-39
	
	public CombinationLock(){ // constructor with empty input argument
		dialPosition = 0;
		firstRight = 0;
		left = 0;
		secondRight = 0;
	}
	
	public CombinationLock(int r1, int l, int r2){ //this constructor allows you to initialize with a combination consisting of 3 integers
		firstRight = r1;
		left = l;
		secondRight = r2;
		dialPosition = 0;			
	}
	
	public void resetDial(){
		dialPosition = 0;
	}
	
	public void turnLeft(int turn){ 
		dialPosition = (dialPosition + turn) % 40;
	}
	
	public void turnRight(int turn){
		dialPosition = (dialPosition - turn) % 40;
	}
	
	public boolean openLock(int a, int b, int c){
		if ((a == firstRight) && (b == left) && (c == secondRight))
			return true;
		else
			return false;
	}
	
	public void getState(){
		System.out.printf("%nThe combination lock dial is pointing to %d and the combination is $d,%d,%d.",
						  dialPosition, firstRight, left, secondRight);
	}
	
}
