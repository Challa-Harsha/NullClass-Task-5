package commonFunctions;

import java.time.LocalTime;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

public class SetTime {
	
	@BeforeSuite
	public void timeSearch() {

		LocalTime now = LocalTime.now();
//		LocalTime startTime = LocalTime.of(0, 0); // 6:00 PM
	//	LocalTime endTime = LocalTime.of(23, 0);// 7:00 PM

		if (now.isBefore( LocalTime.of(0, 0)) || now.isAfter(LocalTime.of(23, 59))) {
			System.out.println("Outside testing windows (6 PM - 7 PM).Test will not run");
			throw new SkipException("Aborting the suite: outsidetesting hours.");
		}
		System.out.println("Within testing window. Proceeding with test suite...");
	}

}
