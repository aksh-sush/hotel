import java.time.LocalDate;

public class Room {

    private int room_number;
    private String type;
    private int floor;
    private double rate;
    private String status;

    public Room(int room_number, String type, int floor, double rate, String status) {
        this.room_number = room_number;
        this.type = type;
        this.floor = floor;
        this.rate = rate;
        this.status = status;
    }

    public boolean isAvailable(LocalDate from_date, LocalDate to_date) {
        return this.status.equals("available");
    }

    public void updateStatus(String new_status) {
        this.status = new_status;
        System.out.println("Room " + room_number + " status updated to: " + new_status);
    }

    public int getRoom_number()   { return room_number; }
    public double getRate()       { return rate; }
    public void setRate(double rate) { this.rate = rate; }
    public String getStatus()     { return status; }
    public String getType()       { return type; }

    //@Override
    public String toString() {
        return "Room[" + room_number + " | " + type + " | Floor " + floor + " | $" + rate + "/night | " + status + "]";
    }
}
