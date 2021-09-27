public class Student {
	private int id;
	private String name;
	private int grade;
	private int feesPaid;
	private int feesTotal;

	//i have passed feestotal as zero since we can update using setter//
	public Student(int id, String name, int grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.feesPaid = 0;
		this.feesTotal = 50000;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public int getFeespaid() {
		return feesPaid;
	}

	public int getFeesTotal() {
		return feesTotal;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setFeesTotal(int feesTotal) {
		this.feesTotal = feesTotal;
	}

	public void payFees(int feesPaid) {
		this.feesPaid += feesPaid;
		School.updateMoneyEarned(feesPaid);
	}

	public int remainingFees() {
		return feesTotal - feesPaid;
	}
}