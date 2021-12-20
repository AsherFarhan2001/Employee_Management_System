package Business_Logic;

public class Bonus {
	
	private int extra_hours;
	private int hourly_rate;
	
	public Bonus() {
		extra_hours=0;
		hourly_rate=0;
	}

	public Bonus(int extra_hours, int hourly_rate) {
		this.extra_hours = extra_hours;
		this.hourly_rate = hourly_rate;
	}

	public int getExtra_hours() {
		return extra_hours;
	}

	public void setExtra_hours(int extra_hours) {
		this.extra_hours = extra_hours;
	}

	public int getHourly_rate() {
		return hourly_rate;
	}

	public void setHourly_rate(int hourly_rate) {
		this.hourly_rate = hourly_rate;
	}
	
}
