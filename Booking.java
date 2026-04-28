import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {

    private String booking_id;
    private String guestid;
    private int roomnumber;
    private LocalDate checkin;
    private LocalDate checkout;
    private String status;

    public Booking(String booking_id, String guestid, int roomnumber,
                   LocalDate checkin, LocalDate checkout, String status) {
        this.booking_id = booking_id;
        this.guestid = guestid;
        this.roomnumber = roomnumber;
        this.checkin = checkin;
        this.checkout = checkout;
        this.status = status;
    }

    public double calculateCost(double rate) {
        long days = ChronoUnit.DAYS.between(checkin, checkout);
        return days * rate;
    }

    public void cancel() {
        this.status = "cancelled";
        System.out.println("Booking " + booking_id + " has been cancelled.");
    }

    public void extendStay(LocalDate new_checkout) {
        this.checkout = new_checkout;
        System.out.println("Booking " + booking_id + " extended to: " + new_checkout);
    }

    // Getters
    public String getBooking_id() { return booking_id; }
    public String getGuestid()    { return guestid; }
    public int getRoomnumber()    { return roomnumber; }
    public LocalDate getCheckin() { return checkin; }
    public LocalDate getCheckout(){ return checkout; }
    public String getStatus()     { return status; }

    @Override
    public String toString() {
        return "Booking[" + booking_id + " | Guest: " + guestid +
               " | Room: " + roomnumber + " | " + checkin + " -> " + checkout + " | " + status + "]";
    }
}
