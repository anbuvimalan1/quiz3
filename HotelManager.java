package Quiz3;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}

public class HotelManager {
    private Map<String, Room> guestRooms;

    public HotelManager() {
        guestRooms = new HashMap<>();
    }

    public void checkIn(Quiz3.Person person, Room room) {
        guestRooms.put(person.getId(), room);
    }

    public void checkOut(Quiz3.Person person) {
        guestRooms.remove(person.getId());
    }

    public void displayInfo() {
        for (Map.Entry<String, Room> entry : guestRooms.entrySet()) {
            String personId = entry.getKey();
            Room room = entry.getValue();
            System.out.println("Person ID: " + personId + ", Room Number: " + room.getRoomNumber());
        }
    }

    public static void main(String[] args) {
        HotelManager hotelManager = new HotelManager();
        List<Quiz3.Person> persons = Quiz3.PersonManager.getPersons();

        // Check-in a person with your name and surname into the hotel
        // Assuming you're checking in the first person from the list into Room 101
        Room room101 = new Room(101);
        Quiz3.Person you = new Quiz3.Person();
        you.setId("YourID"); // Assign a unique ID
        you.setName("YourName");
        you.setSurname("YourSurname");
        hotelManager.checkIn(you, room101);

        // Check-in another person from the list into the same room
        // Assuming the second person from the list will be checked in
        if (!persons.isEmpty()) {
            Room sharedRoom = new Room(101); // Same room as you
            Quiz3.Person otherPerson = persons.get(0); // Assuming the list is not empty
            hotelManager.checkIn(otherPerson, sharedRoom);
        }

        // Display information about all guests and their rooms
        hotelManager.displayInfo();
    }
}