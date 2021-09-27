import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Book> books = new ArrayList<Book>();
	static ArrayList<Reader> user = new ArrayList<Reader>();
	static Library annaLibrary;
	static LocalDate today;


	public static void main(String[] args) {

		//books//
		Book gravity = new Book("Gravity", "StefenHawking");
		Book sapiens = new Book("sapiens", "Yuval Noah Harari");
		Book godDelusion = new Book("God Delusion", "Richard Dawkins");
		Book theAlchemist = new Book("The Alchemist", "Paulo Choelo");
		Book theBrain = new Book("The Brain", "David Eaglemen");
		Book harryPotter = new Book("Harry Potter", "JK Rowling");
		Book elevenMinutes = new Book("Eleven Minutes", "Paulo Choelo");

		//Readers//
		Reader sathish = new Reader("Sathish", "Tambaram");
		Reader dhana = new Reader("Dhana", "Otteri");
		Reader sekar = new Reader("Sekar", "Pallavaram");
		Reader naveen = new Reader("Naveen", "Red hills");

		books.add(gravity);
		books.add(sapiens);
		books.add(godDelusion);
		books.add(theAlchemist);
		books.add(theBrain);
		books.add(harryPotter);
		books.add(elevenMinutes);

		user.add(sathish);
		user.add(dhana);
		user.add(sekar);
		user.add(naveen);

		//Library//
		annaLibrary = new Library(books, user);
		sathish.borrowBook(theBrain);
		sathish.borrowBook(theAlchemist);
		sathish.borrowBook(sapiens);
		dhana.borrowBook(godDelusion);
		
		System.out.println("\n" + "\n");
		System.out.println("***********************Welcome to Anna Library************************");
		System.out.println("\nEnter (0) for Library control." + "\nEnter (1) for user control.");
		System.out.print("\nEnter key : ");

		int key = scan.nextInt();

		boolean loop = true;

		switch(key) {

			case 0:
			System.out.println("\n{------> Library control <------}");
			System.out.println("\nEnter (0) to add books." + "\nEnter (1) to check books availlable." + 
				"\nEnter (2) to check books lended." + "\nEnter (3) to check users list" +
				"\nEnter (4) to check total books" + "\nEnter (5) to exit.");

			while (loop) {

			System.out.print("\nEnter key : ");
			int libKey = scan.nextInt();

			switch(libKey){

				case 0:
				addBooksTO();
				break;

				case 1:
				System.out.println(annaLibrary.getBooksAvaillable());
				break;

				case 2:
				System.out.println(annaLibrary.getBooksLended());
				break;

				case 3:
				System.out.println(annaLibrary.getUserReg());
				break;

				case 4:
				System.out.println("Total number of books in Library = " + annaLibrary.getTotalBooks());
				break;

				case 5:
				loop = false;
				break;

				default:
				System.out.println("Entered number is not valid");
			}
		}
			break;

			case 1:
			System.out.println("\n{------> User control <------}");
			System.out.println("\nEnter (0) to check books in library." + "\nEnter (1) borrow book." + 
				"\nEnter (2) return book." + "\nEnter (3) to exit");

			loop = true;

			while (loop) {

			System.out.print("\nEnter key : ");
			int userKey = scan.nextInt();

			switch(userKey) {
				case 0:
				System.out.print(annaLibrary.getBooksAvaillable());
				System.out.println(annaLibrary.getBooksLended());
				break;

				case 1:
				checkUserAndBorrow();
				break;

				case 2:
				checkUserAndReturn();
				break;

				case 3:
				loop = false;
				break;

				default:
				System.out.println("Entered number is not valid");
			}

			break;	
		}
	}
	}


	public static void addBooksTO() {
		System.out.print("\nEnter book name :");
		String bName = scan.next();
		System.out.print("Enter auther name :");
		String aName = scan.next();
		books.add(new Book(bName, aName));
		System.out. println("\nAdded book to library");
	}

	public static void checkUserAndBorrow() {
		System.out.println("Are you already registered ? type (yes / no)");

		String res = scan.next();
		String option1 = "yes", option2 = "no";
		Reader reader = null;

		if (res.equalsIgnoreCase(option1)) {
			System.out.print("enter your name : ");
			String nameOfReader = scan.next();
			reader = annaLibrary.getReader(nameOfReader);
		} 
		else if(res.equalsIgnoreCase(option2)) {
			System.out.println("Enter your name :");
			String regName = scan.next();
			System.out.println("Enter your adress :");
			String regAdress = scan.next();

			reader = new Reader(regName, regAdress);
		}

		System.out. println("\n****Books availlable now****");
		System.out.print(annaLibrary.getBooksAvaillable());
		System.out.print("\nenter book name you want: ");
		String name = scan.next();

		Book book = annaLibrary.getBook(name);

		if(reader.borrowBook(book)) {
			System.out.println("\nSuccesfully Borrowed");
		} else {
			System.out.println("\nSomething went wrong");
		}
	}

	public static void checkUserAndReturn() {
		System.out.println("Enter your name");
		String resName = scan.next();
		Reader reader = annaLibrary.getReader(resName);

		System.out.println(reader.toString());

		System.out.print("\nenter book name you want to return: ");
		String name = scan.next();

		Book book = annaLibrary.getBook(name);

		LocalDate borrowed = book.getBorrowDate();
		System.out.println("You borrowed book on : " + borrowed);
		today = LocalDate.now();
		//long daysBetween = DAYS.between(dateBefore, dateAfter);
		System.out.println("returned book on : " + book.setReturnedDate(today));

		if(reader.returnBook(book)) {
			System.out.println("\nSuccesfully returned");
		} else {
			System.out.println("\nSomething went wrong");
		}
	}

}