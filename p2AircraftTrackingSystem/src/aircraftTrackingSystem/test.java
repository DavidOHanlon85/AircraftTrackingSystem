package aircraftTrackingSystem;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PassengerPlane p1 = new PassengerPlane("Boeing 777", 25, Power.FIXED, CountryCode.FR);
		
		System.out.println(p1.ping());

	}

}
