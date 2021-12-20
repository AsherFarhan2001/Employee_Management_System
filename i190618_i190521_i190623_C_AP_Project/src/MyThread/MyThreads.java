package MyThread;

import Business_Logic.EMS;
import File_Handling.Write_to_File;

public class MyThreads extends Thread {
	
	private EMS ems;
	
	@Override
	public void run() {
		Write_to_File.CRUD_FILE(ems);
	}

	public EMS getEms() {
		return ems;
	}

	public void setEms(EMS ems) {
		this.ems = ems;
	}
	
}
