import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {
	static int count = 100;
	private int registerNumber;
	private String name;
	private String auther;
	private Availlability availlability;
	private LocalDate borrowDate;
	private LocalDate returnedDate;
	private final int maxDay = 30;


	public Book(String name, String auther) {
		this.count += 1;
		this.registerNumber = count;
		this.name = name;
		this.auther = auther;
		this.availlability = availlability.TRUE;
		this.borrowDate = LocalDate.now();
		this.returnedDate = null;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public LocalDate setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
		return returnedDate;
	}

	public int getRegisterNumber() {
		return registerNumber;
	}

	public String getName() {
		return name;
	}

	public String auther() {
		return auther;
	}

	public Availlability getAvaillability() {
		return availlability;
	}

	public void closeAvaillability() {
		this.availlability = availlability.FALSE;
	}

	public void openAvaillability() {
		this.availlability = availlability.TRUE;
	}

	public String toString() {
		return "\nRegister Number : " + registerNumber + "\nTitle : " + name + "\nAuther : "
		 + auther + "\nAvaillability : " + availlability + "\n";
	}
}