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
		
		System.out.println("OK, let's remove a book from Donal Duck's locker");
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
