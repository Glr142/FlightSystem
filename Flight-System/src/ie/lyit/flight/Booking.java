package ie.lyit.flight;

import java.util.ArrayList;

public class Booking {
    private static int nextUniqueBookingNumber = 10000;

    private Flight outboundFlight;
    private Flight inboundFlight;
    private ArrayList<Passenger> passengers;
    private double totalPrice;
    private int bookingNo;

    // Constructor
    public Booking(Flight outboundFlight, Flight inboundFlight, ArrayList<Passenger> passengers) {
    	 //Caveat null outbound.
    	if (outboundFlight == null) {
              throw new IllegalArgumentException("Outbound flight is null.");
          } 
    	
    	 if (passengers == null) {
             throw new IllegalArgumentException("Passengers is null. Must have at least 1.");
         }
    	 if (passengers.isEmpty()) {
             throw new IllegalArgumentException("Passengers is empty. Must have at least 1.");
         }
    	 if (passengers.size()>9) {
             throw new IllegalArgumentException("Passengers more than 9. Must have a max of 9.");
         }
    	
    	 
        this.outboundFlight = outboundFlight;
        this.inboundFlight = inboundFlight;
        this.passengers = passengers;
        this.totalPrice = calculatePrice();
        this.bookingNo = nextUniqueBookingNumber++;
    }

    // toString method
    @Override
    public String toString() {
        return "Booking number: " + bookingNo + 
                "\t Outbound Flight " + outboundFlight.toString() +
                "\t InboundFlight " + inboundFlight.toString() +
                "\t Passengers [" + passengers + "]"+
                "\t Total Price=" + totalPrice ;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
    	Booking bObject;
        if(obj instanceof Booking)
          bObject = (Booking)obj;
        else
         return false;
    	
        return( this.bookingNo == bObject.bookingNo);
    }
 
    // findPassenger method
    public boolean findPassenger(Passenger p) {
        return passengers.contains(p);
    }

 // calculatePrice method
    public double calculatePrice() {
        double flightPrice = outboundFlight.getPrice();

        if (inboundFlight != null) {
            flightPrice += inboundFlight.getPrice();
        }
        return flightPrice * passengers.size();
    }	
    
    public Flight getOutboundFlight() {
        return outboundFlight;
    }

    public void setOutboundFlight(Flight outboundFlight) {
        this.outboundFlight = outboundFlight;
    }

    public Flight getInboundFlight() {
        return inboundFlight;
    }

    public void setInboundFlight(Flight inboundFlight) {
        this.inboundFlight = inboundFlight;
    }
    
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        if (passengers == null || passengers.isEmpty()) {
            throw new IllegalArgumentException("There must be at least 1 passenger.");
        }
        if (passengers.size() > 9) {
            throw new IllegalArgumentException("Invalid number of passengers. There must be at most 9 passengers.");
        }
        this.passengers = new ArrayList<>(passengers);
        this.totalPrice = calculatePrice();
    }

    public int getBookingNo() {
        return bookingNo;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
