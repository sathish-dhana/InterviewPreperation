import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class TollManagement {

	private ArrayList<Vehicle> vehicleRegister;
	private ArrayList<Ticket> entryRegister; 
	private int totalMoney;

	public TollManagement () {
		this.totalMoney = 0;
		this.vehicleRegister = new ArrayList<Vehicle>();
		this.entryRegister = new ArrayList<Ticket>();
	}

	public String addVehicle(Vehicle vehicle) {
		Ticket ticket = new Ticket(vehicle);
		vehicleRegister.add(vehicle);
		entryRegister.add(ticket);
		return ticket.toString();
	}

	public Ticket getTicket(int id) {
		Ticket t = null;
		Ticket result = null;
		Iterator<Ticket> i = entryRegister.iterator();
		while (i.hasNext()) {
			t = i.next();
			if (t.getPassId() == id) {
				result = t;
				break;
			}
		}
		return result;
	}

	public long getDiffernce(LocalDateTime from, LocalDateTime to) {
		LocalDateTime fromTemp = LocalDateTime.from(from);
		long days = fromTemp.until(to, ChronoUnit.DAYS);
		fromTemp = fromTemp.plusDays(days);
		return days;
	}
	
	public void scanTicket(int id) {
		Ticket ticket = getTicket(id);
		LocalDateTime issuedDate = ticket.getIssuedDate();
		LocalDateTime dateTimeNow = LocalDateTime.now();
		TicketType ticketType = ticket.getVehiclePassType();
		TicketType s = TicketType.SINGLE, r = TicketType.RETURN, d = TicketType.DAILY_PASS, m = TicketType.MONTHLY_PASS;
		
		if (ticketType.equals(s)) {
			System.out.println("\n********** Not valid for return. **********");
		}
		else if(ticketType.equals(r)) {
			long daysBetween = getDiffernce(issuedDate, dateTimeNow);
			if (daysBetween <= 1) {
				System.out.println("\n********** Scan successful, thanks for visiting. **********");
				entryRegister.remove(ticket);
			}
			else 
				System.out.println("\n********** Not valid for return. **********");
		}
		else if (ticketType.equals(d)) {
			long daysBetween = getDiffernce(issuedDate, dateTimeNow);
			if (daysBetween <= 1)
				System.out.println("\n********** Scan successful, thanks for visiting. **********");
			else 
				System.out.println("\n********** Not valid for daily pass expired. **********");
		}
		else if (ticketType.equals(m)) {
			long daysBetween = getDiffernce(issuedDate, dateTimeNow);
			if (daysBetween <= 31)
				System.out.println("\n********** Scan successful, thanks for visiting. **********");
			else 
				System.out.println("\n********** Not valid for monthly pass expired. **********");
		}
	} 

	/*
	public static void main(String[] args) {
		Vehicle bike = new Vehicle("TN-09-8765", VehicleType.CAR, TicketType.SINGLE);
		Vehicle honda = new Vehicle("TN-09-8777", VehicleType.CAR, TicketType.RETURN);
		TollManagement t = new TollManagement();
		System.out.println(t.addVehicle(bike));
		System.out.println(t.addVehicle(honda));
		Ticket tc = t.getTicket(11112);
		System.out.println(tc.toString());

		t.scanTicket(11111);
	}*/
}