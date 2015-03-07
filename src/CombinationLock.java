
public class CombinationLock {
	//the following array will hold 3 integers are the combination (the final positions necessary for the lock to open)
	private int [] combination;

	private int dialPosition; //valid for integers 0-39
	private int length = 40; // length of the lock i.e. number of ticks
	
	
	public CombinationLock(){ // constructor with empty input argument
		dialPosition = 0;
		combination = new int [3];
		
	}
	
	public CombinationLock(int r1, int l, int r2){ //this constructor allows you to initialize with a combination consisting of 3 integers
		
		combination = new int [3];
		combination[0] = r1;
		combination[1] = l;
		combination[2] = r2;
		dialPosition = 0;			
	}
	
	public int getDialPosition(){
		return dialPosition;
	}
	
	public void resetDial(){
		dialPosition = 0;
	}
	
	public void turnLeft(int turn){ //turns the dial left by an integer amount... LEFT is the POSITIVE direction
		dialPosition = (dialPosition + turn) % length;
	}
	
	public void turnRight(int turn){// RIGHT is the NEGATIVE direction
		int newPosition = (dialPosition - turn) % length; // thus we must subtract
		while (newPosition < 0){ //  a % m in Java returns  a value x such that -(m-1) < x < (m-1), we want only numbers 0 < x < m(-1)
			newPosition += length; //this adds the length (i.e. the modulus) to the result of the mod operation until the result is positive. 
		}
		dialPosition = newPosition;
	}
	
	public boolean openLock(int move1, int move2, int move3){
		turnRight(move1);
		int a = getDialPosition(); //use this value to test combination
		System.out.printf("%nOk, let's try the first move to the right.%n"+
				 		  "The new position is %d.%n", getDialPosition());
		turnLeft(move2);
		int b = getDialPosition();
		System.out.printf("Ok, let's try the second move, this one to the left.%n"+
						  "The new position is %d.%n", getDialPosition());
		turnRight(move3);
		int c = getDialPosition();
		System.out.printf("OK, let's try the third and final move to the right.%n"+
						  "The new position is %d.%n", getDialPosition());
		
		return ((a == combination[0]) && (b == combination[1]) && (c == combination[2]));
			
	}
	
	public void getState(){
		System.out.printf("%nThe combination lock dial is pointing to %d and the combination is %d,%d,%d.",
						  dialPosition, combination[0], combination[1], combination[2]);
	}
/* The following static method will find the right moves one must use to get the right combination to open any lock. The formula is simple:
 * distance = position1 - position2. However, to stay in the range 0-39 we take the modulus of the difference  with respect to the total
 * length of the lock (the number of ticks) and use the correction of adding this length to the result to get the equivalent (modulo length) positive number.
 * 	See method turnRight.
 */
	public static int[] findTheRightMoves(CombinationLock lock){
		int [] move = new int[3];
		//first move:
		move [0] = (lock.dialPosition - lock.combination[0])%lock.length; //since turning right is the negative direction, we use the initial position minus the final position
		while (move[0] < 0){
			move[0] += lock.length;//keep adding length until you reach first positive result
		}
		// second move:
		move[1] = (lock.combination[1] - lock.combination[0])%lock.length; //turning left is the positive direction, thus use final position minus initial position
		while (move[1] < 0){
			move[1] += lock.length;
		}
		// third move:
		move[2] = lock.combination[1] - lock.combination[2];
		while (move[2] < 0){
			move[2] += lock.length;
		}
		
		return move;
	}
	
	
}
