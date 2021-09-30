import java.util.*;

public class Main {
	static TicketBooker ticket = new TicketBooker();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("\n********************WELCOME TO RAILWAYS********************\n");
		boolean key = true;

		while (key) {
		System.out.println("\n<----------Select below operation---------->\n");
		System.out.println("* Enter 1 for booking.");
		System.out.println("* Enter 2 to cancel booking.");
		System.out.println("* Enter 3 to print booked tickets.");
		System.out.println("* Enter 4 for availlable tickets.");
		System.out.println("* Enter 5 to exit.");

		System.out.println("\nEnter any operation.");
		int value = scan.nextInt();

		switch(value) {
			case 1:
				bookingDetails();
				break;
			case 2:
				System.out.println("\nEnter passengerId to cancel :");
				int passId = scan.nextInt();
				ticket.cancelTickets(passId);
				break;
			case 3:
				ticket.printBookedTickets();
				break;
			case 4:
				ticket.printAvaillableTicket();
				break;
			case 5:
				System.out.println("\n<----------------Thank you---------------->");
				key = false;
				break;
			default:
				System.out.println("xxxxxxxxx---Invalid input, please try again---xxxxxxxxx");
				break;	
			}
		}
	}

	public static void bookingDetails() {
		Scanner scan = new Scanner(System.in);
		Berth berthFinal = null;

		System.out.println("Enter your name:");
		String name = scan.nextLine();

		System.out.println("Enter your gender:");
		String gender = scan.next();

		System.out.println("Enter your age:");
		int age=0;
		try {
			age = scan.nextInt();
		} catch(Exception e) {
			System.out.println("\nxxxxxxxxx---Please enter age in number.---xxxxxxxxx\n");
		}
		System.out.println("Enter your prefered berth (U, M, L):");
		char berth = scan.next().charAt(0);

		if (berth != 'U' && berth != 'M' && berth != 'L') {
			System.out.println("\nxxxxxxxxx---your entered berth is not valid---xxxxxxxxx\n");
		} else {
			if (berth == 'U') {
				berthFinal = berthFinal.UPPER;
			} else if (berth == 'M') {
				berthFinal = berthFinal.MIDDLE;
			} else {
				berthFinal = berthFinal.LOWER;
			}
		}
		Passenger user = new Passenger(name, age, gender, berthFinal);

		checkBookingAvaillability(user);
	}

	public static void checkBookingAvaillability(Passenger passenger) {

		Berth berth = passenger.berth;

		if (ticket.waiting <= 0) {
			System.out.println("No Tickets availlable.");
		} else {
			if (berth == berth.UPPER && ticket.upperBerth > 0 || berth == berth.MIDDLE && ticket.middleBerth > 0 || berth == berth.LOWER && ticket.lowerBerth > 0) {
				System.out.println("Your preferred berth is availlable.");

				if (berth == berth.UPPER) {
					ticket.bookUpperBerth(passenger, "UPPER");
					System.out.println("Id : " + passenger.passengerId + "\tStatus : Confirmed ticket" + "\tBerth : Upper");
				}
				else if (berth == berth.MIDDLE) {
					ticket.bookMiddleBerth(passenger, "MIDDLE");
					System.out.println("Id : " + passenger.passengerId + "\tStatus : Confirmed ticket" + "\tBerth : Middle");
				}
				else if (berth == berth.LOWER) {
					ticket.bookLowerBerth(passenger, "LOWER");
					System.out.println("Id : " + passenger.passengerId + "\tStatus : Confirmed ticket" + "\tBerth : Middle");
				}
			}
			else if	(ticket.lowerBerth > 0){
				System.out.println("\nYour preferred berth is not availlable.");
				ticket.bookLowerBerth(passenger, "LOWER");
				System.out.println("Id : " + passenger.passengerId + "\tStatus : Confirmed ticket" + "\tBerth : Lower");
			}
			else if (ticket.middleBerth > 0){
				System.out.println("\nYour preferred berth is not availlable.");
				ticket.bookMiddleBerth(passenger, "MIDDLE");
				System.out.println("Id : " + passenger.passengerId + "\tStatus : Confirmed ticket" + "\tBerth : Middle");
			}
			else if (ticket.upperBerth > 0){
				System.out.println("\nYour preferred berth is not availlable.");
				ticket.bookUpperBerth(passenger, "UPPER");
				System.out.println("Id : " + passenger.passengerId + "\tStatus : Confirmed ticket" + "\tBerth : Upper");
			}
			else if (ticket.racTicket > 0){
				System.out.println("\nYour preferred berth is not availlable.");
				ticket.bookRAC(passenger, "RAC");
				System.out.println("Id : " + passenger.passengerId + "\tStatus : RAC ticket" + "\tBerth : rac");
			}
			else if (ticket.waiting > 0){
				System.out.println("\nYour preferred berth is not availlable.");
				ticket.addWaitingList(passenger, "Waiting");
				System.out.println("Id : " + passenger.passengerId + "\tStatus : Waiting " + "\tBerth : not availlable");
			}
		}
	}
}