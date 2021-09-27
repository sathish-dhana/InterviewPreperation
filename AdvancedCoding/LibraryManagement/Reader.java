import java.util.ArrayList;
import java.util.Iterator;

public class Reader {
	static int idcount = 0;
	private int userId;
	private String name;
	private String adress;
	private ArrayList<Book> borrowbookReg;

	public Reader(String name, String adress) {
		this.idcount += 1;
		this.userId = idcount;
		this.name = name;
		this.adress = adress;
		this.borrowbookReg = new ArrayList<Book>();
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public ArrayList<Book> getBorrowBooks() {
		return borrowbookReg;
	}

	public boolean borrowBook(Book book) {
		book.closeAvaillability();
		Library.lendBook(book);
		this.borrowbookReg.add(book);
		return true;
	}

	public boolean returnBook(Book book) {
		book.openAvaillability();
		Library.addLendedBook(book);
		this.borrowbookReg.remove(book);
		return true;
	}

	@Override
	public String toString() {
		String result = "";
		Iterator<Book> i = borrowbookReg.iterator();

		if (!i.hasNext()) {
			result = "No books in hand";
			return "\nUser ID : " + userId + "\nName : " + name + "\nAddress : " + adress 
			+ "\nBooks borrowed : (" + result + ")";
		}

		while(i.hasNext()) {
			Book b = i.next();
			result += b.getName();

			if (i.hasNext())
				result += ", ";
		}
		return "\nUser ID : " + userId + "\nName : " + name + "\nAddress : " + adress 
		+ "\nBooks borrowed : (" + result + ")";
	}
}