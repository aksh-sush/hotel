import java.time.LocalDate;

public class HotelSystem {

    public static void main(String[] args) {

        HotelManager hotelManager = new HotelManager("MGR01");
        hotelManager.addRoom(new Room(101, "deluxe", 2, 200.0, "available"));

        // Guest passes their details
        Guest guest = new Guest("G001", "akshithaa", "9850573242", "akshithaa@email.com");

        // Guest passes room request
        String roomType = "deluxe";
        LocalDate checkin  = LocalDate.of(2026, 5, 1);
        LocalDate checkout = LocalDate.of(2026, 5, 4);

        // Manager checks and reverts with boolean
        boolean isAvailable = hotelManager.checkAvailability(roomType, checkin, checkout);
        System.out.println("Guest: " + guest.getName() + " | Availability: " + isAvailable);

        if (isAvailable) {
            System.out.println("Room is available. Proceed with booking.");
        } else {
            System.out.println("No rooms available for the selected dates.");
        }
    }
}
