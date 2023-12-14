package ie.lyit.flight;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BookingTest {

	@Test
	public void testBooking() {
		Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30,12,2018), new Time(8,45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
    	Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
    	Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
    	Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
    	passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        assertEquals(outboundFlight, booking.getOutboundFlight());
        assertEquals(inboundFlight, booking.getInboundFlight());
        assertEquals(passengers, booking.getPassengers());
        assertTrue(booking.getTotalPrice() > 0);
 
	}

	@Test
	public void testToString() {
        Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30,12,2018), new Time(8,45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
        Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
        Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
        Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
        passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        String expectedToString = "Booking number: " + booking.getBookingNo() +
                "\t Outbound Flight " + outboundFlight.toString() +
                "\t InboundFlight " + inboundFlight.toString() +
                "\t Passengers [" + passengers + "]"+
                "\t Total Price=" + booking.getTotalPrice();
        assertEquals(expectedToString, booking.toString());
    }

	@Test
	 public void testEqualsObject() {
        Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30,12,2018), new Time(8,45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
        Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
        Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
        Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
        passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking1 = new Booking(outboundFlight, inboundFlight, passengers);
       // Booking booking2 = new Booking(outboundFlight, inboundFlight, passengers);

        assertTrue(booking1.equals(booking1));
    }


	@Test
	public void testFindPassenger() {
        Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30,12,2018), new Time(8,45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
        Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
        Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
        Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
        passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        assertTrue(booking.findPassenger(joeBloggs));
        assertFalse(booking.findPassenger(new Passenger(new Name("Mr", "John", "Doe"), "088 1234567", "john@gmail.com", 2, false, new CreditCard(987654321, new Date(31, 12, 2023), 456))));
    }

	@Test
	public void testGetOutboundFlight() {
        Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30,12,2018), new Time(8,45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
        Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
        Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
        Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
        passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        assertEquals(outboundFlight, booking.getOutboundFlight());
    }

	@Test
	public void testSetOutboundFlight() {
        Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight newOutboundFlight = new Flight("BR999","NewOrigin", "NewDestination", new Date(1,1,2022), new Time(9,30), 99.99);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
        Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
        Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
        Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
        passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking = new Booking(outboundFlight, null, passengers);

        booking.setOutboundFlight(newOutboundFlight);

        assertEquals(newOutboundFlight, booking.getOutboundFlight());
    }

	public void testGetInboundFlight() {
        Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30,12,2018), new Time(8,45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
        Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
        Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
        Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
        passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        assertEquals(inboundFlight, booking.getInboundFlight());
    }

    @Test
    public void testSetInboundFlight() {
        Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30,12,2018), new Time(8,45), 120.0);
        Flight newInboundFlight = new Flight("BR999","NewOrigin", "NewDestination", new Date(1,1,2022), new Time(9,30), 99.99);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
        Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
        Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
        Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
        passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        booking.setInboundFlight(newInboundFlight);

        assertEquals(newInboundFlight, booking.getInboundFlight());
    }

    @Test
    public void testGetPassengers() {
        Flight outboundFlight = new Flight("BR215","Derry", "Stanstead", new Date(25,12,2018), new Time(12,40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30,12,2018), new Time(8,45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
       
        Name name=new Name("Mr","Joe","Bloggs");
        CreditCard joesCard=new CreditCard(1234567895,new Date(31,12,2024),123);
        Passenger joeBloggs = new Passenger(name,"087 1234567", 
                                         "joe@gmail.com",1,false,joesCard);
        Name name1=new Name("Mrs","Jane","Doe");
        CreditCard janesCard=new CreditCard(123653325,new Date(4,6,2024),163);
        Passenger janeDoe = new Passenger(name1,"087 1234567", 
                                         "Jane@gmail.com",1,false,janesCard);
        passengers.add(joeBloggs);
        passengers.add(janeDoe);

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        assertEquals(passengers, booking.getPassengers());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetOutboundFlightWithNull() {
        Flight outboundFlight = new Flight("BR215", "Derry", "Stanstead", new Date(25, 12, 2018), new Time(12, 40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30, 12, 2018), new Time(8, 45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        booking.setOutboundFlight(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPassengersWithNull() {
        Flight outboundFlight = new Flight("BR215", "Derry", "Stanstead", new Date(25, 12, 2018), new Time(12, 40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30, 12, 2018), new Time(8, 45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        // Set passengers to null and expect IllegalArgumentException
        booking.setPassengers(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPassengersWithEmptyList() {
        Flight outboundFlight = new Flight("BR215", "Derry", "Stanstead", new Date(25, 12, 2018), new Time(12, 40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30, 12, 2018), new Time(8, 45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

       booking.setPassengers(new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPassengersWithMoreThanNinePassengers() {
        Flight outboundFlight = new Flight("BR215", "Derry", "Stanstead", new Date(25, 12, 2018), new Time(12, 40), 16.99);
        Flight inboundFlight = new Flight("BR216", "Stanstead", "Derry", new Date(30, 12, 2018), new Time(8, 45), 120.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            passengers.add(new Passenger(new Name("mr","k", "l"), "1234567890", "passenger" + i + "@gmail.com", 1, false,
                    new CreditCard(1234567890, new Date(31, 12, 2024), 123)));
        }

        Booking booking = new Booking(outboundFlight, inboundFlight, new ArrayList<>());

        booking.setPassengers(passengers);
    }
 }
