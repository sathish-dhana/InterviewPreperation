import java.util.ArrayList;

public class School {
	private Student ArrayList<Student> students;
	private Teacher ArrayList<Teacher> teachers;
	private int moneyEarned;
	private int moneySpent;

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
		this.teachers.add(teacher);
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void addStudents(Student students) {
		this.students.add(students);
	}

	public int getMoneyEarned() {
		return moneyEarned;
	}

	public int getMoneySpent() {
		return moneySpent;
	}

	public void updateMoneyEarned(int moneyEarned) {
		this.moneyEarned += moneyEarned;
	}

	public void updateMoneySpent(int moneySpent) {
		this.moneySpent += moneySpent;
		this.moneyEarned -= moneySpent;
	}
}