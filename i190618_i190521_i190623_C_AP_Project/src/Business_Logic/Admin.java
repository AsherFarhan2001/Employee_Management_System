package Business_Logic;

public class Admin {
	private Personel_Info PI;

	public Admin(Personel_Info pI) {
		//super();
		PI = pI;
	}

	public Personel_Info getPI() {
		return PI;
	}

	public void setPI(Personel_Info pI) {
		PI = pI;
	}
	
}
