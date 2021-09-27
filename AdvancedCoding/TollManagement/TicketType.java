import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum TicketType {
	SINGLE(30)
	{
		@Override
		public String setTime() {
			String validDate = "one time pass";
			return validDate;
		}
	}
	, RETURN(60) 
	{
		@Override
		public String setTime(){
			LocalDateTime date = LocalDateTime.now();
			LocalDateTime nextdate = date.plusDays(1);
			DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String validDate = nextdate.format(myFormatObj1);
			return validDate;
		}
	}
	, DAILY_PASS(100)
	{
		@Override
		public String setTime(){
			LocalDateTime date = LocalDateTime.now();
			LocalDateTime nextdate = date.plusDays(1);
			DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String validDate = nextdate.format(myFormatObj1);
			return validDate;
		}
	}
	, MONTHLY_PASS(2000)
	{
		@Override
		public String setTime(){
			LocalDateTime date = LocalDateTime.now();
			LocalDateTime nextdate = date.plusDays(31);
			DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String validDate = nextdate.format(myFormatObj1);
			return validDate;
		}	
	};

	int fare;
	public abstract String setTime();

	TicketType(int fare) {
		this.fare = fare;
	}

	public int getFare() {
		return fare;
	}
}


