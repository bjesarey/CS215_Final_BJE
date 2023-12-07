import java.util.Timer;
import java.util.TimerTask;

/**
 * Tests the classes in the CS 215 Final project.
 */

/**
 * @author Brandon Esarey
 * @version 5.0 Final Project CS215 Semester year Fall 2023
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hospital brooks = new Hospital();
		HospitalTimers scheduler = new HospitalTimers(brooks);
        scheduler.scheduleTasks();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                scheduler.stopScheduler();
                System.out.println("All done!");
            }
        }, 61000);
	}//end main()

}//end Application
