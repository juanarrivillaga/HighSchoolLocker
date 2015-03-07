/*The purpose of this assignment is to create a class that includes an attribute that is another class type and methods 
  that support those attributes. OUTPUT IS IN A COMMENT AT THE END OF THIS CLASS file"
 */

public class HighSchoolLockerDriver {

	public static void main(String[] args) {
		Locker firstLocker = new Locker(100, "Mickey Mouse", 3, 28, 17, 39);
		Locker secondLocker = new Locker(275, "Donald Duck", 0, 35, 16, 27);
		
		System.out.println("Let's try to open  Mickey Mouse's locker with the combination 15,18,18.");
		firstLocker.openLocker(15,18,18);
		System.out.println();
		
		System.out.println("\nOK, let's reset the dial to position 0 and find the right combination.");
		firstLocker.getLock().resetDial(); //note I have to use the Locker class getLock method to access the CombinationLock private method!
		int [] move = CombinationLock.findTheRightMoves(firstLocker.getLock()); // note: I have to use the Locker class getLock method to 
																				// call the CombinationLock object because it is private even
																				// though I'm using a public, static CombinationLock method!
	
		System.out.printf("%nThe right moves are right %d, left %d, and right %d.%n", move[0], move[1], move[2]);
		System.out.printf("%nLet's open Mickey Mouse's locker with the right moves!");
		firstLocker.openLocker(move[0], move[1], move[2]);
		System.out.printf("%n%nOK, let's add three books to Mickey Mouse's locker");
		firstLocker.putBookInLocker();
		firstLocker.putBookInLocker();
		firstLocker.putBookInLocker();
		
		System.out.println("\n\nOK, let's remove a book from Donald Duck's locker\n");
		secondLocker.removeBookFromLocker();
		
		System.out.printf("%n%nIt would probably help to open the locker first...");
		
		move = CombinationLock.findTheRightMoves(secondLocker.getLock()); // again, here we use a Locker class method to call the CombinationLock
																		  // object... see line 17
		secondLocker.openLocker(move[0], move[1], move[2]);
		System.out.printf("%n%nOk, now we can remove that book from Donald Duck's locker...");
		secondLocker.removeBookFromLocker();
		
		System.out.println();
		System.out.println("Finally, let's look at the attributes of the two lockers:");
		firstLocker.printCurrentState();
		System.out.println();
		secondLocker.printCurrentState();
	}

}
/* SAMPE OUTPUT:
Let's try to open  Mickey Mouse's locker with the combination 15,18,18.

Ok, let's try the first move to the right.
The new position is 25.
Ok, let's try the second move, this one to the left.
The new position is 3.
OK, let's try the third and final move to the right.
The new position is 25.

The locker won't open!

OK, let's reset the dial to position 0 and find the right combination.

The right moves are right 12, left 29, and right 18.

Let's open Mickey Mouse's locker with the right moves!
Ok, let's try the first move to the right.
The new position is 28.
Ok, let's try the second move, this one to the left.
The new position is 17.
OK, let's try the third and final move to the right.
The new position is 39.

The locker opens!

OK, let's add three books to Mickey Mouse's locker
A book was added to locker 100
A book was added to locker 100
A book was added to locker 100

OK, let's remove a book from Donald Duck's locker


This locker is LOCKED! You can't remove any books.

It would probably help to open the locker first...
Ok, let's try the first move to the right.
The new position is 35.
Ok, let's try the second move, this one to the left.
The new position is 16.
OK, let's try the third and final move to the right.
The new position is 27.

The locker opens!

Ok, now we can remove that book from Donald Duck's locker...
There are no more books to remove from this locker!
Finally, let's look at the attributes of the two lockers:

The locker number is: 100
The locker belongs to: Mickey Mouse
There is(are) 6 book(s) in the locker.
The locker is UNLOCKED

The locker number is: 275
The locker belongs to: Donald Duck
There is(are) 0 book(s) in the locker.
The locker is UNLOCKED
*/