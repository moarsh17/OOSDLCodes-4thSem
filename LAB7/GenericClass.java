package LAB7;

class Room<T, U> {
    private T roomId;      
    private U roomAttribute; 

    public Room(T roomId, U roomAttribute) {
        this.roomId = roomId;
        this.roomAttribute = roomAttribute;
    }

    public T getRoomId() {
        return roomId;
    }

    public U getRoomAttribute() {
        return roomAttribute;
    }

    public void displayRoomDetails() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Attribute: " + roomAttribute);
    }
}


public class GenericClass {
    public static void main(String[] args) {
        Room<Integer, String> room1 = new Room<>(101, "Deluxe");
        Room<String, Double> room2 = new Room<>("A-202", 199.99);
        Room<Integer, Double> room3 = new Room<>(303, 149.50);

        room1.displayRoomDetails();
        room2.displayRoomDetails();
        room3.displayRoomDetails();
    }
}