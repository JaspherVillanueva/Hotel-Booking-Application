package CUI;

public class Room {

    private int roomNumber;
    private RoomType roomType;
    private int roomPrice;
    private boolean isReserved;

    public Room(int roomNumber, RoomType roomType, int roomPrice, boolean isReserved) {
        this.setRoomNumber(roomNumber);
        this.setRoomType(roomType);
        this.setRoomPrice(roomPrice);
        this.setIsReserved(isReserved);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public String toString() {
        return "Room Number: " + this.roomNumber + " Type: " + this.roomType + " ($" + this.roomPrice + " per night)\n";
    }
}
