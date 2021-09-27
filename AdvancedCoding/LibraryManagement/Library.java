import java.util.ArrayList;
import java.util.Iterator;

public class Library {
	private String name;
	static ArrayList<Book> books;
	static ArrayList<Book> booksLended;
	static ArrayList<Reader> userReg;
	private int totalBooks;

	public Library(ArrayList<Book> books, ArrayList<Reader> userReg) {
		this.name = "Anna Library";
		this.books = books;
		this.userReg = userReg;
		this.booksLended = new ArrayList<Book>();
		this.totalBooks = this.books.size();
	}

	public int getTotalBooks() {
		totalBooks = books.size() + booksLended.size();
		return totalBooks;
	}

	public void addBooksToLibrary(Book book) {
		this.books.add(book);
	}

	public static void addUserToReg(Reader reader) {
		userReg.add(reader);
	}

	public static void lendBook(Book book) {
		booksLended.add(book);
		books.remove(book);
	}

	public static void addLendedBook(Book book) {
		booksLended.remove(book);
		books.add(book);
	}

	public static String getBooksAvaillable() {
		String result = "\n";
		Iterator<Book> i = books.iterator();
		while(i.hasNext()) {
			Book b = i.next();
			result += b.toString();
		}
		return result;
	}

	public static String getBooksLended() {
		String result = "\n";
		Iterator<Book> i = booksLended.iterator();
		while(i.hasNext()) {
			Book b = i.next();
			result += b.toString();
		}
		return result;
	}

	public static String getUserReg() {
		String result = "\n";
		Iterator<Reader> i = userReg.iterator();

		while(i.hasNext()) {
			Reader r = i.next();
			result += r.toString() + "\n";
		}
		return result;
	}

	public static Reader getReader(String name) {
		Iterator<Reader> i = userReg.iterator();
		Reader reader = i.next();

		while(i.hasNext()) {
			reader = i.next();
			String res = reader.getName();

			if (res.equalsIgnoreCase(name))
				break;
		}
		return reader;
	}

	public static Book getBook(String name) {
		Iterator<Book> i = books.iterator();
		Book book = i.next();

		while(i.hasNext()) {
			book = i.next();
			String res = book.getName();

			if (res.equalsIgnoreCase(name))
				break;
		}
		return book;
	}


}