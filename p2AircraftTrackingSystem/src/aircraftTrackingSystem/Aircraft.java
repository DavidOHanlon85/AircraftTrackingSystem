/**
 * 
 */
package aircraftTrackingSystem;

import java.util.Objects;

/**
 * @author David O'Hanlon 15621049
 */
public abstract class Aircraft {

	// Constants

	public static final int MIN_TYPE_LENGTH = 3;
	public static final int MAX_TYPE_LENGTH = 15;

	public static final int MIN_WINGSPAN_LENGTH = 25;
	public static final int MAX_WINGSPAN_LENGTH = 50;

	// Instance Variables

	private String type;
	private int wingspan;
	private Power power;

	// Constructors

	/**
	 * This is the default constructor
	 */

	Aircraft() {

	}

	/**
	 * Aircraft constructor with args
	 * 
	 * @param type
	 * @param wingspan
	 * @param power
	 */
	public Aircraft(String type, int wingspan, Power power) {
		this.setType(type);
		this.setWingspan(wingspan);
		this.setPower(power);
	}

	// Getters and Setters
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets type according to business rule that type length must be between 3 and
	 * 15 (inclusive). IllegalArgumentException thrown if outside this range or if
	 * the input is null
	 * 
	 * @param type
	 * @throws IllegalArgumentException
	 */
	public void setType(String type) throws IllegalArgumentException {
		if (type == null) {
			throw new IllegalArgumentException("Type is null");
		}
		if (type.length() >= MIN_TYPE_LENGTH && type.length() <= MAX_TYPE_LENGTH) {
			this.type = type;
		} else {
			throw new IllegalArgumentException("Invalid input length");
		}
	}

	/**
	 * @return the wingspan
	 */
	public int getWingspan() {
		return wingspan;
	}

	/**
	 * Sets wingspan according to business rule that wingspan length is between 25
	 * and 50 inclusive. IllegalArgumentException thrown if outside this range.
	 * 
	 * @param wingspan
	 */
	public void setWingspan(int wingspan) {
		if (wingspan >= MIN_WINGSPAN_LENGTH && wingspan <= MAX_WINGSPAN_LENGTH) {
			this.wingspan = wingspan;
		} else {
			throw new IllegalArgumentException("Invalid wingspan length");
		}
	}

	/**
	 * @return the power
	 */
	public Power getPower() {
		return power;
	}

	/**
	 * Set power - throws IllegalArgumentException if null
	 * @param power
	 * @throws IllegalArgumentException
	 */
	public void setPower(Power power) throws IllegalArgumentException {
		if (power == null) {
			throw new IllegalArgumentException("Power is null");
		} else {
			this.power = power;
		}
	}

	public void showAll() {
		System.out.println("TYPE\t:" + getType());
		System.out.println("WINGSPAN:" + getWingspan());
		System.out.println("POWER\t:" + getPower());
	}

	// Methods

	public abstract String ping();

	// hashCode and equals

	@Override
	public int hashCode() {
		return Objects.hash(power, type, wingspan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aircraft other = (Aircraft) obj;
		return power == other.power && Objects.equals(type, other.type) && wingspan == other.wingspan;
	}

}
