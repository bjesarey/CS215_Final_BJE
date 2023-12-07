import java.util.*;

/**
 * Creates a hospital with a regular queue and a priority queue.
 * Objects of the patient class will flow through the two queues before being removed in the Discharge method.
 */

/**
 * @author Brandon Esarey
 * @version 5.0 Final Project CS215 Semester year Fall 2023
 */
public class Hospital {
	PriorityQueue<Patient> WaitRoom = new PriorityQueue<Patient>(10,new PatientComparator());
	Queue<Patient> TreatmentQueue = new LinkedList<>();

	/**
	 * 
	 */
	public Hospital() {

	}// end

	/**
	 * @param waitRoom
	 * @param treatmentQueue
	 */
	public Hospital(PriorityQueue<Patient> waitRoom, Queue<Patient> treatmentQueue) {
		WaitRoom = waitRoom;
		TreatmentQueue = treatmentQueue;

	}// end preferred constructor

	/**
	 * Adds new patients to the WaitRoom queue and determines if they will be able
	 * to move closer to the front of the line.
	 */
	public void CheckIn() {
		HUD();
		int PatientGenerator=(int)(Math.random()*2);
		if(PatientGenerator==1) {
		Patient person = new Patient();
		int ID=person.getID();
		person.Emergency();
		if (person.Emergency() == 1) {
			person.setEmergency(1);
			WaitRoom.add(person);
			System.out.println("Patient "+ ID +" is checking in with an emergency!");
			//IDScan();
		} // if
		else {
			WaitRoom.add(person);
			System.out.println("Patient "+ID+" has checked in to the hospital.");
			//IDScan();
		} // else
		}//if
		else
			System.out.println("No one has checked in at the moment.");
	}// end CheckIn()

	/**
	 * Removes a patient in the WaitRoom queue and places them in the Treatment
	 * Queue.
	 */
	public void Transfer() {
		Patient Transfer = WaitRoom.peek();
		if(Transfer!=null) {
		int ID=Transfer.getID();
		WaitRoom.remove();
		TreatmentQueue.add(Transfer);
		System.out.println("\nPatient "+ ID +" has been moved to treatment");
		//TreatmentIDScan();	
		}//if
		else
			System.out.println("\nNo patients in need of transfer");
	}// end Transfer()

	/**
	 * Removes a patient from the Treatment queue, effectively discharging them from
	 * the hospital.
	 */
	public void Discharge() {
		if(TreatmentQueue.peek()!=null) {
		Patient Healthy=TreatmentQueue.peek();
		int ID=Healthy.getID();
		TreatmentQueue.remove();
		System.out.println("\nPatient "+ID+" has been discharged from the hospital.");
	//	TreatmentIDScan();
		}//if
		else
			System.out.println("\nNo one waiting to be discharged");
	}// end Discharge()
	
	/**
	 * Displays the name of the hospital and clears the screen.
	 */
	public void HUD() {
		clear();
		System.out.println("UofL Health");
	}//end HUD()
	
	/**
	 * Clears the terminal when this method is run.
	 */
	public static void clear() {
		try {
			new ProcessBuilder("clear").inheritIO().start().waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end clear()
	
	/**
	 * Checks the ID numbers of patients in WaitRoom queue.
	 */
	public void IDScan() {
		for (Patient Waitlist : WaitRoom) 
            System.out.println("Patients waiting: " + Waitlist.getID());
	}//end IDScan()
	
	/**
	 * Checks the ID numbers of patients in TreatmentQueue.
	 */
	public void TreatmentIDScan() {
		for(Patient Treatlist: TreatmentQueue)
			System.out.println("Patients in treatment: "+ Treatlist.getID());
	}//end TreatmentIDScan()
	
	/**
	 * Displays IDs of Patients in the WaitRoom queue and the TreatmentQueue
	 */
	public void IDHub() {
		System.out.println();
		IDScan();
		System.out.println();
		TreatmentIDScan();
	}//end IDHub
}// end Hospital
