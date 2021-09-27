public class Vehicle {
	private String reg_Num;
	private VehicleType type;
	private TicketType pass;

	Vehicle(String reg_Num, VehicleType type, TicketType pass) {
		this.reg_Num = reg_Num;
		this.type = type;
		this.pass = pass;
	}

	public String getRegNum() {
		return reg_Num;
	}

	public VehicleType getType() {
		return type;
	}

	public TicketType passType() {
		return pass;
	}

	public int getVehicleFare() {
		return pass.getFare();
	}

	public String getValidDate() {
		return pass.setTime();
	}
}