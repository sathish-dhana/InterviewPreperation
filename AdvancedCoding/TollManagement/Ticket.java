import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
	private Vehicle vehicle;
	static int count = 11110;
	private int pass_Id;
	private LocalDateTime date;

	public Ticket(Vehicle vehicle) {
		count += 1;
		this.vehicle = vehicle;
		this.pass_Id = count;
		this.date = LocalDateTime.now();
	}

	public int getPassId() {
		return pass_Id;
	}

	public LocalDateTime getIssuedDate() {
		return date;
	} 

	public TicketType getVehiclePassType() {
		return vehicle.passType();
	}

	public String getFormattedDate() {
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = date.format(myFormatObj);
		return formattedDate;
	}

	@Override
	public String toString() {
		return "\n   Chennai toll plaza pvt. ltd\n" + "======================================\n" +
		"Pass Type    : " + vehicle.passType() + "\nPass Id      : " + this.pass_Id + "\nVehicle Name : " + vehicle.getRegNum() +
		"\nVehicle Type : " + vehicle.getType() + "\nFare         : " + vehicle.getVehicleFare() + "\nIsuued D & T : " + this.getFormattedDate()
		+ "\nValid till   : "+ vehicle.getValidDate() +"\n======================================\n";
	}
}	