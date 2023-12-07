import java.util.Comparator;

/**
 * Creates a method to determine how objects will be placed in the priority queue.
 */

/**
 * @author Brandon Esarey
 * @version 5.0 Final Project CS215 Semester year Fall 2023
 */
public class PatientComparator implements Comparator<Patient>{

	@Override
	public int compare(Patient p1, Patient p2) {
		// TODO Auto-generated method stub
		if(p1.getEmergency()<p2.getEmergency())
		return 0;
		else if(p1.getEmergency()>p2.getEmergency())
			return-1;
		else
			return 0;
	}//end Compare

}//end PatientComparator()
