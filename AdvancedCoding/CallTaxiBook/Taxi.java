import java.util.*;

public class Taxi {
	static int taxicount = 0; // taxi number
     	int id;
     	boolean booked;
     	char currentSpot; 
     	int freeTime; 
     	int totalEarnings;
     	List<String> trips; 

	public Taxi() {
		taxicount += 1;
		id = taxicount;
		booked = false;
		currentSpot = 'a';
		freeTime = 6;
		totalEarnings = 0;
		trips = new ArrayList<String>();		
	}

	public void setDetails(boolean booked, char currentSpot, int freeTime, int totalEarnings, String tripDetail)
    {
            this.booked = booked;
            this.currentSpot = currentSpot;
            this.freeTime = freeTime;
            this.totalEarnings = totalEarnings;
            this.trips.add(tripDetail);
    }

    public void printDetails()
    {
        //print all trips details
        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totalEarnings);
        System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
        for(String trip : trips)
        {
            System.out.println(id + "          " + trip);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void printTaxiDetails()
    {
        //print total earningand taxi details like current location and free time
        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totalEarnings + " Current spot - " + this.currentSpot +" Free Time - " + this.freeTime);
    }
}