/**
 * 
 */
package aircraftTrackingSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class TestPassengerPlane {

	// test data

	String validTypeLengthLow, validTypeLengthMid, validTypeLengthHigh;
	String invalidTypeLengthLow, invalidTypeLengthHigh;

	int validWingspanLow, validWingspanMid, validWingspanHigh;
	int invalidWingspanLow, invalidWingspanHigh;

	Power fixed, prop, rotor;

	CountryCode UK, FR, US;

	PassengerPlane p;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		validTypeLengthLow = "A".repeat(3);
		validTypeLengthMid = "A".repeat(10);
		validTypeLengthHigh = "A".repeat(15);

		invalidTypeLengthLow = "A".repeat(2);
		invalidTypeLengthHigh = "A".repeat(16);

		validWingspanLow = 25;
		validWingspanMid = 37;
		validWingspanHigh = 50;

		invalidWingspanLow = 24;
		invalidWingspanHigh = 51;

		fixed = Power.FIXED;
		prop = Power.PROP;
		rotor = Power.ROTOR;

		UK = CountryCode.UK;
		FR = CountryCode.FR;
		US = CountryCode.US;

		p = new PassengerPlane(validTypeLengthLow, validWingspanHigh, fixed, UK);
	}

	@Test
	void testPassengerPlaneConstructorValid() {

		assertNotNull(p);

		assertEquals(validTypeLengthLow, p.getType());
		assertEquals(validWingspanHigh, p.getWingspan());
		assertEquals(fixed, p.getPower());
		assertEquals(UK, p.getCountryCode());

	}

	@Test
	void testPassengerPlaneConstructorInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			PassengerPlane p1 = new PassengerPlane(invalidTypeLengthHigh, validWingspanHigh, fixed, UK);
		});

		assertEquals("Invalid input length", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			PassengerPlane p1 = new PassengerPlane(null, validWingspanHigh, fixed, UK);
		});

		assertEquals("Type is null", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			PassengerPlane p1 = new PassengerPlane(validTypeLengthMid, invalidWingspanHigh, fixed, UK);
		});

		assertEquals("Invalid wingspan length", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			PassengerPlane p1 = new PassengerPlane(validTypeLengthMid, validWingspanLow, null, UK);
		});

		assertEquals("Power is null", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			PassengerPlane p1 = new PassengerPlane(validTypeLengthMid, validWingspanLow, fixed, null);
		});

		assertEquals("Country Code is null", exp.getMessage());

	}

	@Test
	void testGetSetTypeValid() {
		p.setType(validTypeLengthLow);
		assertEquals(validTypeLengthLow, p.getType());

		p.setType(validTypeLengthMid);
		assertEquals(validTypeLengthMid, p.getType());

		p.setType(validTypeLengthHigh);
		assertEquals(validTypeLengthHigh, p.getType());
	}

	@Test
	void testGetSetTypeInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			p.setType(invalidTypeLengthLow);
		});
		assertEquals("Invalid input length", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			p.setType(invalidTypeLengthHigh);
		});
		assertEquals("Invalid input length", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			p.setType(null);
		});
		assertEquals("Type is null", exp.getMessage());

	}

	@Test
	void testGetSetWingspanValid() {
		p.setWingspan(validWingspanLow);
		assertEquals(validWingspanLow, p.getWingspan());

		p.setWingspan(validWingspanMid);
		assertEquals(validWingspanMid, p.getWingspan());

		p.setWingspan(validWingspanHigh);
		assertEquals(validWingspanHigh, p.getWingspan());
	}

	@Test
	void testGetSetWingspanInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			p.setWingspan(invalidWingspanLow);
		});
		assertEquals("Invalid wingspan length", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			p.setWingspan(invalidWingspanHigh);
		});
		assertEquals("Invalid wingspan length", exp.getMessage());

	}
	
	@Test
	void testGetSetPowerValid() {
		p.setPower(fixed);
		assertEquals(Power.FIXED, p.getPower());
		
		p.setPower(prop);
		assertEquals(Power.PROP, p.getPower());
		
		p.setPower(rotor);
		assertEquals(Power.ROTOR, p.getPower());
	}
	
	@Test
	void testGetSetPowerInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			p.setPower(null);
		});
		assertEquals("Power is null", exp.getMessage());
	}
	
	@Test
	void testGetSetCountryCodeValid() {
		p.setCountryCode(UK);
		assertEquals(CountryCode.UK, p.getCountryCode());
		
		p.setCountryCode(US);
		assertEquals(CountryCode.US, p.getCountryCode());
		
		p.setCountryCode(FR);
		assertEquals(CountryCode.FR, p.getCountryCode());
	}
	
	@Test
	void testGetSetCountryCodeInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			p.setCountryCode(null);
		});
		assertEquals("Country Code is null", exp.getMessage());
		
	}

	
	@Test
	void testPing() {
		
		PassengerPlane p2 = new PassengerPlane("Boeing 777", 34, fixed, FR);
		
		String passengerPlaneRef = p2.ping();
		
		assertEquals("PP", passengerPlaneRef.substring(0, 2));
		assertEquals(7082, Integer.parseInt(passengerPlaneRef.substring(3, 7)));
		assertTrue(passengerPlaneRef.contains("FIXED"));
		assertEquals(34, Integer.parseInt(passengerPlaneRef.substring(14, 16)));
		assertTrue(passengerPlaneRef.contains("Boeing 777"));
		assertEquals("PP-7082-FIXED-34-Boeing 777", passengerPlaneRef);
		
		
	}

}
