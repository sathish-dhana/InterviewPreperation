import java.util.*;

public class TicketBooker {

	static final int totalBookingTicket = 3;
	static final int totalRacTicket = 1;
	static final int totalWaitingTicket = 1;

	static int lowerBerth = totalBookingTicket/3;
	static int middleBerth = totalBookingTicket/3;
	static int upperBerth = totalBookingTicket/3;
	static int racTicket = totalRacTicket;
	static int waiting = totalRacTicket;

    static List<Passenger> lowerBerthsPositions = new ArrayList<Passenger>();
    static List<Passenger> middleBerthsPositions = new ArrayList<Passenger>();
    static List<Passenger> upperBerthsPositions = new ArrayList<Passenger>();
    static Queue<Passenger> racPositions = new LinkedList<Passenger>();
    static Queue<Passenger> waitingListPositions = new LinkedList<Passenger>();

    HashMap<Integer, Passenger> checkPassenger = new HashMap<Integer, Passenger>();

  	public void bookLowerBerth(Passenger pass, String berth) {
  		if (lowerBerthsPositions.size() < totalBookingTicket/3) {
  			lowerBerthsPositions.add(pass);
  			checkPassenger.put(pass.passengerId, pass);
  			pass.alloted = berth;
  			lowerBerth--;
  		}
  	}
  	public void bookUpperBerth(Passenger pass, String berth) {
  		if (upperBerthsPositions.size() < totalBookingTicket/3) {
  			upperBerthsPositions.add(pass);
  			checkPassenger.put(pass.passengerId, pass);
  			pass.alloted = berth;
  			upperBerth--;
  		}
  	}
  	public void bookMiddleBerth(Passenger pass, String berth) {
  		if (middleBerthsPositions.size() < totalBookingTicket/3) {
  			middleBerthsPositions.add(pass);
  			checkPassenger.put(pass.passengerId, pass);
  			pass.alloted = berth;
  			middleBerth--;
  		}
  	}
  	public void bookRAC(Passenger pass, String berth) {
  		racPositions.add(pass);
  		checkPassenger.put(pass.passengerId, pass);
  		pass.alloted = berth;
  		racTicket--;
  	}
  	public void addWaitingList(Passenger pass, String berth) {
  		waitingListPositions.add(pass);
  		checkPassenger.put(pass.passengerId, pass);
  		pass.alloted = berth;
  		waiting--;
  	}

  	public void cancelTickets(int passId) {
  		Passenger p = checkPassenger.get(passId);
  		checkPassenger.remove(passId);

  		String passBerth = p.alloted;

  		if (passBerth == "LOWER") {
  			Iterator<Passenger> i = lowerBerthsPositions.iterator();
  			p = null;
  			while (i.hasNext()) {
				p = i.next();
				if (p.passengerId == passId)
					i.remove();
			}
			lowerBerth--;
  		}
  		if (passBerth == "MIDDLE") {
  			Iterator<Passenger> i = middleBerthsPositions.iterator();
  			p = null;
  			while (i.hasNext()) {
				p = i.next();
				if (p.passengerId == passId)
					i.remove();
			}
			middleBerth--;
  		}
  		if (passBerth == "UPPER") {
  			Iterator<Passenger> i = upperBerthsPositions.iterator();
  			p = null;
  			while (i.hasNext()) {
				p = i.next();
				if (p.passengerId == passId)
					i.remove();
			}
			upperBerth--;
  		}

  		if (racPositions.size() > 0) {
  				p = racPositions.remove();
  				racTicket--;
  				if (lowerBerthsPositions.size() < totalBookingTicket/3) {
  					p.alloted = "LOWER";
  					lowerBerthsPositions.add(p);
  					lowerBerth--;
  				}
  				else if (middleBerthsPositions.size() < totalBookingTicket/3){
  					p.alloted = "MIDDLE";
  					middleBerthsPositions.add(p);
  					middleBerth--;
  				}
  				else if (upperBerthsPositions.size() < totalBookingTicket/3){
  					p.alloted = "UPPER";
  					upperBerthsPositions.add(p);
  					upperBerth--;
  				}
  		}

  		if (waitingListPositions.size() > 0) {
  				p = waitingListPositions.remove();
  				p.alloted = "RAC";
  				racPositions.add(p);
  				waiting--;
  		}
  	}

  	public void printAvaillableTicket() {
  		System.out.println("\nAvaillable Lower Berth : " + lowerBerth);
  		System.out.println("Availlable Middle Berth : " + middleBerth);
  		System.out.println("Availlable Upper Berth : " + upperBerth);
  		System.out.println("Availlable RAC : " + racTicket);
  		System.out.println("Availlable Waiting List: " + waiting);
  	}

  	public void printBookedTickets() {
  		System.out.println("\n***********************Lower Berth Tickets***********************\n");

  		Iterator<Passenger> i = lowerBerthsPositions.iterator();
  		Passenger p = null;
  		if (!i.hasNext())
  			System.out.println("Berth is Empty");
  		while (i.hasNext()) {
			p = i.next();
			System.out.println(p.toString());
		}

		System.out.println("\n***********************Middle Berth Tickets***********************\n");

  		Iterator<Passenger> m = middleBerthsPositions.iterator();
  		if (!m.hasNext())
  			System.out.println("Berth is Empty");
  		while (m.hasNext()) {
			p = m.next();
			System.out.println(p.toString());
		}

		System.out.println("\n***********************Upper Berth Tickets***********************\n");

  		Iterator<Passenger> j = upperBerthsPositions.iterator();
  		if (!j.hasNext())
  			System.out.println("Berth is Empty");
  		while (j.hasNext()) {
			p = j.next();
			System.out.println(p.toString());
		}

		System.out.println("\n***********************RAC Tickets***********************\n");

  		Iterator<Passenger> k = racPositions.iterator();
  		if (!k.hasNext())
  			System.out.println("Berth is Empty");
  		while (k.hasNext()) {
			p = k.next();
			System.out.println(p.toString());
		}

		System.out.println("\n***********************Waiting List Tickets***********************\n");

  		Iterator<Passenger> l = waitingListPositions.iterator();
  		if (!l.hasNext())
  			System.out.println("Berth is Empty");
  		while (l.hasNext()) {
			p = l.next();
			System.out.println(p.toString());
		}
  	}
}