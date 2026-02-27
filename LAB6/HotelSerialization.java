package LAB6;

import java.io.*;

class Room implements Serializable {
    int roomNumber;
    String roomType;
    double price;
    boolean status;
    String guestName;

    Room(int r, String t, double p, boolean s, String g) {
        roomNumber = r;
        roomType = t;
        price = p;
        status = s;
        guestName = g;
    }

    void display() {
        System.out.println(roomNumber + " " + roomType + " " +
                           price + " " + status + " " + guestName);
    }
}

public class HotelSerialization {
    public static void main(String[] args) {

        try {

            ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("rooms.txt"));

            Room r1 = new Room(1, "Deluxe", 2500, false, "None");
            Room r2 = new Room(2, "Suite", 4000, true, "Rahul");

            out.writeObject(r1);
            out.writeObject(r2);
            out.close();

            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("rooms.txt"));

            Room room1 = (Room) in.readObject();
            Room room2 = (Room) in.readObject();
            in.close();

            System.out.println("All Rooms:");
            room1.display();
            room2.display();

            System.out.println("Search Room 2:");
            if(room2.roomNumber == 2)
                room2.display();

            if(room1.roomNumber == 1) {
                room1.status = true;
                room1.guestName = "Arjun";
            }

            ObjectOutputStream out2 =
                new ObjectOutputStream(new FileOutputStream("rooms.txt"));

            out2.writeObject(room1);
            out2.writeObject(room2);
            out2.close();

            System.out.println("Updated Successfully");

        } 
        catch(IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
}