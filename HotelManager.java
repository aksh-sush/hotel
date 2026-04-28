import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {

    private String managerid;
    private List<Room> rooms;

    public HotelManager(String managerid) {
        this.managerid = managerid;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added: " + room);
    }

    public void setRates(int room_number, double rate) {
        for (Room room : rooms) {
            if (room.getRoom_number() == room_number) {
                room.setRate(rate);
                System.out.println("Rate updated for Room " + room_number + " to $" + rate + "/night");
                return;
            }
        }
        System.out.println("Room not found: " + room_number);
    }

    public void viewOccupancy() {
        boolean found = false;
        for (Room room : rooms) {
            if (room.getStatus().equals("occupied")) {
                System.out.println(room);
                found = true;
            }
        }
        if (!found) System.out.println("No rooms currently occupied.");
    }

   

    public boolean checkAvailability(String type, LocalDate from_date, LocalDate to_date) {
        for (Room room : rooms) {
            if (room.getType().equals(type) && room.isAvailable(from_date, to_date)) {
                return true;
            }
        }
        return false;
    }

    public Room findAvailableRoom(String type) {
        for (Room room : rooms) {
            if (room.getType().equals(type) && room.getStatus().equals("available")) {
                return room;
            }
        }
        return null;
    }

    public List<Room> getRooms() { return rooms; }
    public String getManagerid() { return managerid; }
}
