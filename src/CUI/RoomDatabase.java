package CUI;

import java.util.ArrayList;

public class RoomDatabase {

    private static ArrayList<Room> roomList = new ArrayList<Room>();

    public RoomDatabase() {
        Room a1Room = new Room(101, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b1Room = new Room(102, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c1Room = new Room(103, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d1Room = new Room(104, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e1Room = new Room(105, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a2Room = new Room(201, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b2Room = new Room(202, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c2Room = new Room(203, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d2Room = new Room(204, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e2Room = new Room(205, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a3Room = new Room(301, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b3Room = new Room(302, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c3Room = new Room(303, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d3Room = new Room(304, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e3Room = new Room(305, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a4Room = new Room(401, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b4Room = new Room(402, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c4Room = new Room(403, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d4Room = new Room(404, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e4Room = new Room(405, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a5Room = new Room(501, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b5Room = new Room(502, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c5Room = new Room(503, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d5Room = new Room(504, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e5Room = new Room(505, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a6Room = new Room(601, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b6Room = new Room(602, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c6Room = new Room(603, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d6Room = new Room(604, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e6Room = new Room(605, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a7Room = new Room(701, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b7Room = new Room(702, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c7Room = new Room(703, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d7Room = new Room(704, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e7Room = new Room(705, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a8Room = new Room(801, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b8Room = new Room(802, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c8Room = new Room(803, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d8Room = new Room(804, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e8Room = new Room(805, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a9Room = new Room(901, RoomType.SINGLE, RoomType.SINGLE.getPrice(), false);
        Room b9Room = new Room(902, RoomType.TWIN, RoomType.TWIN.getPrice(), false);
        Room c9Room = new Room(903, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), false);
        Room d9Room = new Room(904, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), false);
        Room e9Room = new Room(905, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), false);

        Room a10Room = new Room(1001, RoomType.SINGLE, RoomType.SINGLE.getPrice(), true);
        Room b10Room = new Room(1002, RoomType.TWIN, RoomType.TWIN.getPrice(), true);
        Room c10Room = new Room(1003, RoomType.QUEENSINGLE, RoomType.QUEENSINGLE.getPrice(), true);
        Room d10Room = new Room(1004, RoomType.KINGSINGLE, RoomType.KINGSINGLE.getPrice(), true);
        Room e10Room = new Room(1005, RoomType.QUEENDOUBLE, RoomType.QUEENDOUBLE.getPrice(), true);

        addRoom(a1Room);
        addRoom(b1Room);
        addRoom(c1Room);
        addRoom(d1Room);
        addRoom(e1Room);

        addRoom(a2Room);
        addRoom(b2Room);
        addRoom(c2Room);
        addRoom(d2Room);
        addRoom(e2Room);

        addRoom(a3Room);
        addRoom(b3Room);
        addRoom(c3Room);
        addRoom(d3Room);
        addRoom(e3Room);

        addRoom(a4Room);
        addRoom(b4Room);
        addRoom(c4Room);
        addRoom(d4Room);
        addRoom(e4Room);

        addRoom(a5Room);
        addRoom(b5Room);
        addRoom(c5Room);
        addRoom(d5Room);
        addRoom(e5Room);

        addRoom(a6Room);
        addRoom(b6Room);
        addRoom(c6Room);
        addRoom(d6Room);
        addRoom(e6Room);

        addRoom(a7Room);
        addRoom(b7Room);
        addRoom(c7Room);
        addRoom(d7Room);
        addRoom(e7Room);

        addRoom(a8Room);
        addRoom(b8Room);
        addRoom(c8Room);
        addRoom(d8Room);
        addRoom(e8Room);

        addRoom(a9Room);
        addRoom(b9Room);
        addRoom(c9Room);
        addRoom(d9Room);
        addRoom(e9Room);

        addRoom(a10Room);
        addRoom(b10Room);
        addRoom(c10Room);
        addRoom(d10Room);
        addRoom(e10Room);
    }

    public void addRoom(Room Room) {
        roomList.add(Room);
    }

    public Room getRoomNumber(int roomNumber) {
        return roomList.get(roomNumber);
    }

    public ArrayList<Room> getRoom() {
        return roomList;
    }
}
