import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static TollManagement toll = new TollManagement();

	public static void main(String[] args) {

		System.out.println("\n*****************Welcome to Chennai toll plaza*****************");

		boolean out = false;

		while(!out) {
			System.out.println("\nEnter (0) to get ticket." + "\nEnter (1) to scan return ticket."
				+ "\nEnter (2) to exit toll");

			System.out.print("\nEnter key : ");
			int key = scan.nextInt();

			switch(key) {

				case 0:
				getDetails();
				break;

				case 1:
				processTicket();
				break;

				case 2:
				System.out.println("\n********  Thank you for visiting ********\n");
				out = true;
				break;
			}
		}
	}

	public static void getDetails() {
		System.out.print("\nEnter the register number : ");

		String regNo = scan.next();

		System.out.println("\nSelect vehicle type :" + "\n (0) - Car" + "\n (1) - Van" + "\n (2) - Bus" 
			+ "\n (3) - Truck");

		System.out.print("\nEnter any key : ");

		int key1 = scan.nextInt();

		System.out.println("\nSelect Ticket type :" + "\n (0) - SINGLE" + "\n (1) - RETURN" + "\n (2) - DAILY PASS" 
			+ "\n (3) - MONTHLY PASS");

		System.out.print("\nEnter any key : ");

		int key2 = scan.nextInt();

		VehicleType ob1 = null;
		TicketType ob2 = null;
		
		//Select vehicle type//
		if (key1 == 0)
			ob1 = VehicleType.CAR;
		else if (key1 == 1)
			ob1 = VehicleType.VAN;
		else if (key1 == 2)
			ob1 = VehicleType.BUS;
		else if (key1 == 3)
			ob1 = VehicleType.TRUCK;

		//Select vehicle ticket//
		if (key2 == 0)
			ob2 = TicketType.SINGLE;
		else if (key2 == 1)
			ob2 = TicketType.RETURN;
		else if (key2 == 2)
			ob2 = TicketType.DAILY_PASS;
		else if (key2 == 3)
			ob2 = TicketType.MONTHLY_PASS;

		Vehicle newVehicle = new Vehicle(regNo, ob1, ob2);
		System.out.println(toll.addVehicle(newVehicle));
	}

	public static void processTicket() {

		System.out.print("\nEnter the ticket pass ID : ");
		int num = scan.nextInt();
		toll.scanTicket(num);
	}
}