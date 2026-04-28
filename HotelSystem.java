import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class HotelSystem {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        HotelManager hotelManager = new HotelManager("MGR01");
        hotelManager.addRoom(new Room(101, "deluxe",  2, 200.0, "available"));
        hotelManager.addRoom(new Room(102, "standard", 1, 100.0, "available"));
        hotelManager.addRoom(new Room(103, "suite",    3, 350.0, "available"));

        System.out.println("\n=== Hotel Booking System ===");

        // --- Guest details ---
        System.out.println("\n-- Enter Guest Details --");
        String guestId = prompt("Guest ID: ");
        String name    = prompt("Full Name: ");
        String phone   = prompt("Phone Number: ");
        String email   = prompt("Email: ");

        Guest guest = new Guest(guestId, name, phone, email);
        System.out.println("Guest registered: " + guest);

        // --- Room request ---
        System.out.println("\n-- Room Request --");
        System.out.println("Available types: deluxe, standard, suite");
        String roomType = prompt("Room Type: ").toLowerCase();

        LocalDate checkin  = readDate("Check-in Date (yyyy-MM-dd): ");
        LocalDate checkout = readDate("Check-out Date (yyyy-MM-dd): ");

        while (!checkout.isAfter(checkin)) {
            System.out.println("Check-out must be after check-in. Try again.");
            checkout = readDate("Check-out Date (yyyy-MM-dd): ");
        }

        // --- Availability check ---
        boolean isAvailable = hotelManager.checkAvailability(roomType, checkin, checkout);
        System.out.println("\nGuest: " + guest.getName() + " | Availability: " + isAvailable);

        if (isAvailable) {
            System.out.println("Room is available. Proceed with booking.");

            String confirm = prompt("Confirm booking? (yes/no): ").toLowerCase();
            if (confirm.equals("yes")) {
                Room room = hotelManager.findAvailableRoom(roomType);
                String bookingId = "BK" + System.currentTimeMillis() % 10000;
                Booking booking  = new Booking(bookingId, guestId, room.getRoom_number(),
                                               checkin, checkout, "confirmed");
                guest.makeBooking(booking);
                room.updateStatus("occupied");

                double cost = booking.calculateCost(room.getRate());
                System.out.println("\n--- Booking Confirmed ---");
                System.out.println(booking);
                System.out.println("Estimated cost: $" + cost);
            } else {
                System.out.println("Booking cancelled by guest.");
            }
        } else {
            System.out.println("No rooms available for the selected dates.");
        }

        sc.close();
    }

    private static String prompt(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    private static LocalDate readDate(String message) {
        while (true) {
            String input = prompt(message);
            try {
                return LocalDate.parse(input, DATE_FMT);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }
}
