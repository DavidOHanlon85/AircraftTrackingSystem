/**
 * 
 */
package aircraftTrackingSystem;

import java.util.ArrayList;

/**
 * @author David O'Hanlon 15621049
 */
public class AircraftSearch {
	
	
	public static void main(String[] args) {
		
		ArrayList<PassengerPlane> aircrafts = new ArrayList<PassengerPlane>();
		
		PassengerPlane a1 = new PassengerPlane("Boeing 777", 25, Power.FIXED, CountryCode.UK);
		PassengerPlane a2 = new PassengerPlane("Boeing 777", 30, Power.FIXED, CountryCode.UK);
		PassengerPlane a3 = new PassengerPlane("Boeing 777", 35, Power.FIXED, CountryCode.US);
		PassengerPlane a4 = new PassengerPlane("Boeing 777", 40, Power.FIXED, CountryCode.FR);
		PassengerPlane a5 = new PassengerPlane("Boeing 777", 50, Power.FIXED, CountryCode.FR);
		
		aircrafts.add(a1);
		aircrafts.add(a2);
		aircrafts.add(a3);
		aircrafts.add(a4);
		aircrafts.add(a5);
		
		ArrayList<PassengerPlane> results = searchByCountry(aircrafts, CountryCode.UK);
		
		for (Aircraft a : results) {
			a.showAll();
		}
		
		
		
	}

	/**
	 * This method searches aircraft with a wingspan between a min wingspan and
	 * maxwingspan inclusive. It throws and IllegalArugementError if the minwingspan
	 * is greater than maxwingspan, if aircrafts is empty or null with appropriate
	 * messages
	 * 
	 * @param aircrafts
	 * @param minWingspan
	 * @param maxWingspan
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Aircraft> searchByWingSpan(ArrayList<Aircraft> aircrafts, int minWingspan, int maxWingspan)
			throws IllegalArgumentException {

		ArrayList<Aircraft> results = new ArrayList<Aircraft>();

		if (minWingspan > maxWingspan) {
			throw new IllegalArgumentException("Min wingspan > Max wingspan");
		}

		if (aircrafts == null) {
			throw new IllegalArgumentException("Arraylist is null");
		}

		if (aircrafts.size() == 0) {
			throw new IllegalArgumentException("Arraylist is empty");
		}

		for (Aircraft a : aircrafts) {
			if (a.getWingspan() >= minWingspan && a.getWingspan() <= maxWingspan) {
				results.add(a);
			}
		}

		return results;
	}

	/**
	 * This method searches aircraft with a countrycode. It throws and
	 * IllegalArugementError if passengerPlanes is empty or null, or if CountryCode
	 * is null, with appropriate messages.
	 * 
	 * @param passengerPlanes
	 * @param countryCode
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<PassengerPlane> searchByCountry(ArrayList<PassengerPlane> passengerPlanes,
			CountryCode countryCode) throws IllegalArgumentException {

		ArrayList<PassengerPlane> results = new ArrayList<PassengerPlane>();

		if (passengerPlanes == null) {
			throw new IllegalArgumentException("Arraylist is null");
		}

		if (passengerPlanes.size() == 0) {
			throw new IllegalArgumentException("Arraylist is empty");
		}

		if (countryCode == null) {
			throw new IllegalArgumentException("Country code is null");
		}

		for (PassengerPlane p : passengerPlanes) {
			if (p.getCountryCode() == countryCode) {
				results.add(p);
			}
		}

		return results;

	}

}
