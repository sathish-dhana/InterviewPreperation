import java.util.*;

public class Operation {
	public static void main(String[] args) {

		System.out.println("\n****************WELCOME TO ZOHO CABS****************\n");
		Scanner scan = new Scanner(System.in);
		boolean key = true;
		List<Taxi> taxis = createTaxis(4);

		while(key) {
		System.out.println("<----OPERATIONS---->\n");
		System.out.println("* Enter 1 for booking.");
		System.out.println("* Enter 2 for taxi booking details.");
		System.out.println("* Enter 3 to exit.\n");
		System.out.print("Enter your choice : ");

		int choice = scan.nextInt();

			switch(choice) {
				case 1:
						bookinginput(taxis);
					break;
				case 2:
					for(Taxi t : taxis)
                		t.printTaxiDetails();
             		for(Taxi t : taxis)
                		t.printDetails();
					break;
				case 3:
					key = false;
					break;
				default:
                    System.out.println("Please enter valid option!!!!");		
			}
		}
	}

	public static List<Taxi> createTaxis(int n)
    {
        List<Taxi> taxis = new ArrayList<Taxi>();
        // create taxis
        for(int i=1 ;i <=n;i++)
        {
            Taxi t = new Taxi();
            taxis.add(t);
        }
        return taxis;
    }

    public static List<Taxi> getFreeTaxi(List<Taxi> taxis, char pickupPoint, int pickupTime) {

    	List<Taxi> freeTaxi = new ArrayList<Taxi>();

    	for (Taxi t : taxis) {
    		if (t.freeTime < pickupTime && Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) <= pickupTime - t.freeTime)
    			freeTaxi.add(t);
    	}
    	return freeTaxi;
    }

	public static void bookinginput(List<Taxi> taxis) {

		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter booking details\n");
		int id = 1;

		System.out.println("Pickup Point (a - f):");
		char pickupPoint = scan.next().charAt(0);
		System.out.println("Drop Point (a - f):");
		char dropPoint = scan.next().charAt(0);
		System.out.println("Pickup Time :");
		int pickupTime = scan.nextInt();

		if (pickupPoint < 'a' || pickupPoint > 'f' || dropPoint < 'a' || dropPoint > 'f') {
			System.out.println("Valid pickup & drop points are a, b, c, d, e, f.");
		}

		List<Taxi> freeTaxi = getFreeTaxi(taxis, pickupPoint, pickupTime);

		if (freeTaxi.size() == 0) {
			System.out.println("No Taxi can be allotted, Please try after sometime.");
		}

		//sort taxi//
		Collections.sort(freeTaxi, (a,b)->a.totalEarnings - b.totalEarnings);
		//3, 1, 2 --> 1, 2, 3;

		bookTaxi(id, pickupPoint, dropPoint, pickupTime, freeTaxi);

        id++;
	}

	public static void bookTaxi(int customerID, char pickupPoint, char dropPoint, int pickupTime, List<Taxi> freeTaxi) {
		int min = 1000;
		Taxi bookedTaxi = null;
		String tripDetail = "";
		int nextfreeTime = 0;
		int distanceBetweenpickUpandDrop = 0;
		int earning = 0;
		char nextSpot = 'Z';

		for (Taxi t : freeTaxi) {
			int distanceBetweenCustomerAndTaxi = Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) * 15;

			if (distanceBetweenCustomerAndTaxi < min) {
				bookedTaxi = t;

				distanceBetweenpickUpandDrop = Math.abs((dropPoint - '0') - (pickupPoint - '0')) * 15;

				int dropTime  = pickupTime + distanceBetweenpickUpandDrop/15;

				nextfreeTime = dropTime;

                nextSpot = dropPoint;

                tripDetail = customerID + "               " + customerID + "          " + pickupPoint +  "      " + dropPoint + "       " + pickupTime + "          " +dropTime + "           " + earning;
				
				min = distanceBetweenCustomerAndTaxi;
			}
			 
		}
		bookedTaxi.setDetails(true, nextSpot, nextfreeTime, earning, tripDetail);
        
        System.out.println("Taxi " + bookedTaxi.id + " booked");
	}
}