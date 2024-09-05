/**
 * 
 */
package aircraftTrackingSystem;

import java.util.Objects;

/**
 * @author David O'Hanlon 15621049
 */
public class PassengerPlane extends Aircraft {
	
	// Instance Variables
	
	private CountryCode countryCode;
	
	// Constructors

	/**
	 * This is the default constructor
	 */
	public PassengerPlane() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * PassengerPlane Constructor with Args
	 * @param type
	 * @param wingspan
	 * @param power
	 * @param countryCode
	 */
	public PassengerPlane(String type, int wingspan, Power power, CountryCode countryCode) {
		super(type, wingspan, power);
		this.setCountryCode(countryCode);
		// TODO Auto-generated constructor stub
	}

	
	// Getters and Setters
	
	/**
	 * @return the countryCode
	 */
	public CountryCode getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(CountryCode countryCode) {
		if (countryCode == null) {
			throw new IllegalArgumentException("Country Code is null");
		} else {
		this.countryCode = countryCode;
		}
	} 
	
	// Methods
	
	public void showAll() {
		System.out.println("TYPE\t:" + getType());
		System.out.println("WINGSPAN:" + getWingspan());
		System.out.println("POWER\t:" + getPower());
		System.out.println("COUNTRY\t:" + getCountryCode());
	}
	
	// hashCode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(countryCode);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerPlane other = (PassengerPlane) obj;
		return countryCode == other.countryCode;
	}

	/**
	 * This method returns a reference to the passenger plane in the form PP-CODE-POWER-WINGSPAN-TYPE
	 */
	@Override
	public String ping() {
		
		String passengerPlaneRef;
		
		String passengerPlaneDefiner = "PP";
		
		int codeLetterOne = (int) getCountryCode().name().charAt(0);
		int codeLetterTwo = (int) getCountryCode().name().charAt(1);
		
		passengerPlaneRef = passengerPlaneDefiner + "-" + codeLetterOne + codeLetterTwo + "-" + getPower() + "-" + getWingspan() + "-" + getType(); 
		
		return passengerPlaneRef;
	}
	
	
	
	
	

}
