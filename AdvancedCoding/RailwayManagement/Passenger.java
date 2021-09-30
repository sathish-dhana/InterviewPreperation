public class Passenger {
	static int count = 0;
	int passengerId;
	String name;
	int age;
	String gender;
	Berth berth;
	String alloted;

	public Passenger(String name, int age, String gender, Berth berth) {
		this.count = count + 1;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.berth = berth;
		this.passengerId = count;
		this.alloted = "";
	}
	@Override
	public String toString() {
		return "\n" +"Passenger Id : " + passengerId 
		 + "\nName : " + name +
		 "\nAge : " + age +
		 "\nGender : " + gender 
		 + "\nAlloted : " + alloted +
		 "\nStatus : " + "confirmed\n";
	}

	// public static void main(String[] args) {

	// 	int l = 5;
	// 	Berth berth = null;
	// 	while (l > 0) {
	// 		Passenger user = new Passenger("dhana", 25, "male", berth.UPPER);
	// 		System.out.println(user.passengerId);
	// 		l--;
	// 	}
	// }
}