import java.util.ArrayList;

public class School {
	private ArrayList<Student> students;
	private ArrayList<Teacher> teachers;
	private static int moneyEarned;
	private static int moneySpent;

	public School(ArrayList<Student> students, ArrayList<Teacher> teachers) {
		this.teachers = teachers;
		this.students = students;
		this.moneyEarned = 0;
		this.moneySpent = 0;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
        students.add(student);
    }

	public int getMoneyEarned() {
		return moneyEarned;
	}

	public int getMoneySpent() {
		return moneySpent;
	}

	public static void updateMoneyEarned(int moneycollected) {
		moneyEarned += moneycollected;
	}

	public static void updateMoneySpent(int moneygone) {
		moneySpent += moneygone;
	}

	public int getProfit() {
		return moneyEarned - moneySpent;
	}
}