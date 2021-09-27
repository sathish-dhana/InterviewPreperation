import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Teacher lizzy = new Teacher(1, "lizzy", 500);
		Teacher melena = new Teacher(2, "melena", 600);
		Teacher gowtham = new Teacher(3, "gowtham", 600);

		ArrayList<Teacher> teachers1 = new ArrayList<>();
		teachers1.add(lizzy);
		teachers1.add(melena);
		teachers1.add(gowtham);

		Student pavithra = new Student(1, "pavithra", 5);
		Student monica = new Student(2, "monica", 6);
		Student sahana = new Student(3, "sahana", 10);

		ArrayList<Student> students2 = new ArrayList<>();
		students2.add(pavithra);
		students2.add(monica);
		students2.add(sahana);

		School mcc = new School(students2, teachers1);
		pavithra.payFees(20000);
		monica.payFees(20000);
		sahana.payFees(20000);

		lizzy.addSalaryEarned(10000);
		melena.addSalaryEarned(10000);

		System.out.println("mcc has earned "  + mcc.getMoneyEarned());
		System.out.println("mcc spent "  + mcc.getMoneySpent());
		System.out.println("mcc profit "  + mcc.getProfit());
	}
}