import java.util.ArrayList;
import java.util.List;

public class Guest {

    private String guestid;
    private String name;
    private String phno;
    private String email;
    private List<Booking> bookings;

    public Guest(String guestid, String name, String phno, String email) {
        this.guestid = guestid;
        this.name = name;
        this.phno = phno;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public void makeBooking(Booking booking) {
        bookings.add(booking);
        System.out.println(name + " made booking: " + booking.getBooking_id());
    }

    public void cancelBooking(String booking_id) {
        for (Booking booking : bookings) {
            if (booking.getBooking_id().equals(booking_id)) {
                booking.cancel();
                return;
            }
        }
        System.out.println("Booking not found: " + booking_id);
    }

    public double viewBill(String booking_id, double rate) {
        for (Booking booking : bookings) {
            if (booking.getBooking_id().equals(booking_id)) {
                double bill = booking.calculateCost(rate);
                System.out.println(name + "'s bill for booking " + booking_id + ": $" + bill);
                return bill;
            }
        }
        return 0;
    }

    // Getters
    public String getGuestid()        { return guestid; }
    public String getName()           { return name; }
    public List<Booking> getBookings(){ return bookings; }

    @Override
    public String toString() {
        return "Guest[" + guestid + " " + name + "  " + phno + " " + email + "]";
    }
}
