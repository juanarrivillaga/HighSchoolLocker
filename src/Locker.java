
public class Locker {
	
	private enum Status {LOCKED, UNLOCKED};//constants represent the locker status of either locked or unlocked
	
	//following are the instance variables of this class
	private Status lockerStatus;
	private int lockerNumber;
	private String student; 
	private int numberOfBooks;
	private CombinationLock lock;

	/* the following are constructors...
	 * we have two constructors per problem specification on blackboard
	 */
	public Locker(){
		lockerStatus = Status.LOCKED;
		lockerNumber = 0; 
		numberOfBooks = 0;
		student = "no owner";
		lock = new CombinationLock();
		
	}
	
	public Locker(int lockerNumber, String student,int books, int a, int b, int c){
		lockerStatus = Status.LOCKED;
		this.lockerNumber = lockerNumber;
		this.student = student;
		lock = new CombinationLock(a,b,c);
		numberOfBooks = books;
	}
	
	/* the following methods are the problem-specific methods. 
	 * Specifications come from Problem Statement on Blackboard
	 */
	
	public void putBookInLocker(){
		if (lockerStatus == Status.UNLOCKED){//check if locker is locked or unlocked
			numberOfBooks  += 1; //add a single book to locker
			System.out.printf("%nA book was added to locker %d",lockerNumber);
		}	
		else 
			System.out.printf("%nThis locker is LOCKED. You can't add any books");		
	}
	
	public void removeBookFromLocker(){
		if(lockerStatus == Status.UNLOCKED){//check if locker is locked or unlocked
			if (numberOfBooks > 0){ // check if there are any books to remove
				numberOfBooks -= 1; // removes a single book if there is at least one book
				System.out.printf("%nA book was removed from locker %d",lockerNumber);
			}
			else
				System.out.printf("%nThere are no more books to remove from this locker!");
		}
		else
			System.out.printf("%nThis locker is LOCKED! You can't remove any books.");
	}
	
	public void openLocker(int a, int b,int c){//This method calls the instance method for this
		if (lock.openLock(a, b, c)){
			System.out.printf("%nThe locker opens!");
			lockerStatus = Status.UNLOCKED;
		}
		else
			System.out.printf("%nThe locker won't open!");
	}
	/* the following instance methods are just set
	 * and get methods for all the attributes
	 */
	public Status getLockerStatus(){
		return lockerStatus;
	}
	
	public void setLockerStatus(Status status){
		lockerStatus = status;
	}

	public int getLockerNumber() {
		return lockerNumber;
	}
	
	public void setLockerNumber(int newNumber) {
		lockerNumber = newNumber;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String newname) {
		student = newname;
	}

	public CombinationLock getLock() {
		return lock;
	}

	public void setLock(CombinationLock lock) {
		this.lock = lock;
	} 
	
	/*some more methods to for the class	
	 * 
	 */
	public void printCurrentState(){
		System.out.printf("%nThe locker number is: %d%nThe locker belongs to: %s%nThere is(are) %d book(s) in the locker.%n",
						  lockerNumber, student, numberOfBooks);
		System.out.print("The locker is "+lockerStatus);
	}
	
}
