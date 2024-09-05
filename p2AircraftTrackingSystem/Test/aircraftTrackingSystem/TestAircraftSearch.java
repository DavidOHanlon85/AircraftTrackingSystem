package aircraftTrackingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAircraftSearch {

	// test data

	ArrayList<Aircraft> aircrafts;
	Aircraft a1, a2, a3, a4, a5;

	ArrayList<PassengerPlane> passengerPlanes;
	PassengerPlane p1, p2, p3, p4, p5;

	AircraftSearch as;

	int minWingspan, maxWingspan;

	@BeforeEach
	void setUp() throws Exception {

		aircrafts = new ArrayList<Aircraft>();
		passengerPlanes = new ArrayList<PassengerPlane>();

		a1 = new PassengerPlane("Plane1", 25, Power.FIXED, CountryCode.US);
		a2 = new PassengerPlane("Plane1", 30, Power.FIXED, CountryCode.US);
		a3 = new PassengerPlane("Plane1", 35, Power.FIXED, CountryCode.US);
		a4 = new PassengerPlane("Plane1", 40, Power.FIXED, CountryCode.US);
		a5 = new PassengerPlane("Plane1", 45, Power.FIXED, CountryCode.US);

		aircrafts.add(a1);
		aircrafts.add(a2);
		aircrafts.add(a3);
		aircrafts.add(a4);
		aircrafts.add(a5);

		p1 = new PassengerPlane("Plane1", 25, Power.FIXED, CountryCode.US);
		p2 = new PassengerPlane("Plane1", 25, Power.FIXED, CountryCode.US);
		p3 = new PassengerPlane("Plane1", 25, Power.FIXED, CountryCode.UK);
		p4 = new PassengerPlane("Plane1", 25, Power.FIXED, CountryCode.UK);
		p5 = new PassengerPlane("Plane1", 25, Power.FIXED, CountryCode.FR);

		passengerPlanes.add(p1);
		passengerPlanes.add(p2);
		passengerPlanes.add(p3);
		passengerPlanes.add(p4);
		passengerPlanes.add(p5);

		minWingspan = 27;
		maxWingspan = 42;

		as = new AircraftSearch();

	}

	@Test
	void testSearchByWingSpanValid() {

		ArrayList<Aircraft> results = as.searchByWingSpan(aircrafts, minWingspan, maxWingspan);

		assertTrue(results.size() == 3);
		assertTrue(results.contains(a2));
		assertTrue(results.contains(a3));
		assertTrue(results.contains(a4));

		results = as.searchByWingSpan(aircrafts, 25, 32);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(a1));
		assertTrue(results.contains(a2));

	}

	@Test
	void testSearchByWingSpanNull() {

		aircrafts = null;

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			as.searchByWingSpan(aircrafts, minWingspan, maxWingspan);
		});

		assertEquals("Arraylist is null", exp.getMessage());

	}

	@Test
	void testSearchByWingSpanALEmpty() {

		aircrafts.clear();

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			as.searchByWingSpan(aircrafts, minWingspan, maxWingspan);
		});

		assertEquals("Arraylist is empty", exp.getMessage());

	}

	@Test
	void testSearchByWingSpanMinGreaterThanMaxValue() {

		aircrafts.clear();

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			as.searchByWingSpan(aircrafts, maxWingspan, minWingspan);
		});

		assertEquals("Min wingspan > Max wingspan", exp.getMessage());

	}

	@Test
	void testSearchByCountryValid() {

		ArrayList<PassengerPlane> results = as.searchByCountry(passengerPlanes, CountryCode.UK);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(p3));
		assertTrue(results.contains(p4));

		results = as.searchByCountry(passengerPlanes, CountryCode.US);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(p1));
		assertTrue(results.contains(p2));

	}

	@Test
	void testSearchByCountryALNull() {

		passengerPlanes = null;

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			as.searchByCountry(passengerPlanes, CountryCode.UK);
		});

		assertEquals("Arraylist is null", exp.getMessage());

	}
	
	@Test
	void testSearchByCountryALEmpty() {

		passengerPlanes.clear();;

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			as.searchByCountry(passengerPlanes, CountryCode.UK);
		});

		assertEquals("Arraylist is empty", exp.getMessage());

	}
	
	@Test
	void testSearchByCountryCountryCodeNull() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			as.searchByCountry(passengerPlanes, null);
		});

		assertEquals("Country code is null", exp.getMessage());

	}
	

}
