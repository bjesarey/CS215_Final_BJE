/**
 * Creates patients, which will be the main object in the Hospital class.
 */

/**
 * @author Brandon Esarey
 * @version 5.0 Final Project CS215 Semester year Fall 2023
 */

public class Patient {
	private int Emergency;
	private int ID;
	
	public Patient() {
		Emergency = 0;
		ID = (int)(Math.random()*1001)+1;
	}// end Patient()(Default Constructor)

	/**
	 * @param emergency
	 * @param iD
	 */
	public Patient(int emergency, int iD) {
		Emergency = emergency;
		ID = iD;
	}//end Preferred Constructor

	/**
	 * @return the emergency
	 */
	public int getEmergency() {
		return Emergency;
	}//end getEmergency

	/**
	 * @param emergency the emergency to set
	 */
	public void setEmergency(int emergency) {
		Emergency = emergency;
	}//end setEmergency
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}//end GetID

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}//end setID

	/**
	 * Determines whether a patient will have a serious injury and be able to move further into
	 * the WaitRoom queue.
	 */
	public int Emergency() {
		int EmergencyOdds = (int) (Math.random() * 4);
		if (EmergencyOdds == 3)
			return 1;
		else
			return 0;
	}// end Emergency()
}// end Patient
