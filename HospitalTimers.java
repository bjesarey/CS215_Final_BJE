
/**
 * Modifies the methods in the Hospital class to make them run on a timer.
 */
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Brandon Esarey
 * @version 5.0 Final Project CS215 Semester year Fall 2023
 */
public class HospitalTimers {
	private final Hospital hospital;
	private Timer timer;

	public HospitalTimers(Hospital hospital) {
		this.hospital = hospital;
	}// end preferred constructor

	public void scheduleTasks() {
		timer = new Timer();
	
		// Schedule CheckIn task every 5 seconds
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				hospital.CheckIn();
			}
		}, 0, 5000);

		// Schedule Transfer task every 10 seconds
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				hospital.Transfer();
			}
		}, 0, 10000);

		// Schedule Discharge task every 15 seconds
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				hospital.Discharge();
			}
		}, 0, 15000);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				hospital.IDHub();
			}
		}, 0, 5000);

	}// end scheduleTasks()

	public void stopScheduler() {
		if (timer != null) {
			timer.cancel();
			timer.purge();
		} // if
	}// end stopScheduler()
}// end HospitalTimers
