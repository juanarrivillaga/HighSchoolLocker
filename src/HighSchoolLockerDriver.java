public class HighSchoolLockerDriver {

	public static void main(String[] args) {
		Locker firstLocker = new Locker(100, "Mickey Mouse", 3, 28, 17, 39);
		Locker secondLocker = new Locker(275, "Donald Duck", 0, 35, 16, 27);
		
		System.out.println("Let's try to open  Mickey Mouse's locker with the combination 15,18,18.");
		firstLocker.openLocker(15,18,18);
		System.out.println();
		System.out.println();
		
		System.out.println("OK, let's try to right combination: 28,17,39.");
		firstLocker.openLocker(28, 17, 39);
		System.out.printf("%n%nOK, let's add three books to Mickey mouses locker");
		firstLocker.putBookInLocker();
		firstLocker.putBookInLocker();
		firstLocker.putBookInLocker();
		
		System.out.println();
		System.out.println();
		
		System.out.println("OK, let's remove a book from Donald Duck's locker");
		secondLocker.removeBookFromLocker();
		
		System.out.printf("%n%nIt would probably help to open the locker first...");
		secondLocker.openLocker(35, 16, 27);
		System.out.printf("%n%nOk, now we can remove that book from Donald Duck's locker...");
		secondLocker.removeBookFromLocker();
		
		System.out.println();
		firstLocker.printCurrentState();
		System.out.println();
		secondLocker.printCurrentState();
	}

}
/*SAMPE OUTPUT:
 * Let's try to open  Mickey Mouse's locker with the combination 15,18,18.

The locker won't open!

OK, let's try to right combination: 28,17,39.

The locker opens!

OK, let's add three books to Mickey mouses locker
A book was added to locker 100
A book was added to locker 100
A book was added to locker 100

OK, let's remove a book from Donald Duck's locker

This locker is LOCKED! You can't remove any books.

It would probably help to open the locker first...
The locker opens!

Ok, now we can remove that book from Donald Duck's locker...
There are no more books to remove from this locker!

The locker number is: 100
The locker belongs to: Mickey Mouse
There is(are) 6 book(s) in the locker.
The locker is UNLOCKED

The locker number is: 275
The locker belongs to: Donald Duck
There is(are) 0 book(s) in the locker.
The locker is UNLOCKED
*/