package LAB8;
import java.util.*;

class Room implements Comparable<Room> {
    private int roomNumber;
    private String roomType;
    private double pricePerDay;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true; 
    }

    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerDay() { return pricePerDay; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public int compareTo(Room other) {
        return Integer.compare(this.roomNumber, other.roomNumber);
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " | " + roomType + " | Rs " + pricePerDay + " | Status: " + (isAvailable ? "Available" : "Occupied");
    }
}

class Customer {
    private int customerId;
    private String name;
    private String contactNumber;
    private int allocatedRoomNumber;

    public Customer(int customerId, String name, String contactNumber, int allocatedRoomNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.allocatedRoomNumber = allocatedRoomNumber;
    }

    public int getAllocatedRoomNumber() { return allocatedRoomNumber; }

    @Override
    public String toString() {
        return "ID: " + customerId + " | Name: " + name + " | Contact: " + contactNumber + " | Room: " + allocatedRoomNumber;
    }
}

public class HotelManagementSystem {
    private ArrayList<Room> roomList = new ArrayList<>();
    private ArrayList<Customer> customerList = new ArrayList<>();
    private HashMap<Integer, Customer> roomMapping = new HashMap<>(); 

    public static void main(String[] args) {
        HotelManagementSystem system = new HotelManagementSystem();
        system.showMenu();
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- HOTEL MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Room");
            System.out.println("2. Display Available Rooms");
            System.out.println("3. Add Customer & Book Room");
            System.out.println("4. Checkout Customer");
            System.out.println("5. Display All Customers");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addRoom(sc); break;
                    case 2: displayAvailableRooms(); break;
                    case 3: bookRoom(sc); break;
                    case 4: checkout(sc); break;
                    case 5: displayCustomers(); break;
                    case 6: System.out.println("Exiting..."); return;
                    default: System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: Please provide valid input.");
            }
        }
    }

    private void addRoom(Scanner sc) {
        System.out.print("Enter Room Number: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Type (Single/Double/Deluxe/Suite): ");
        String type = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(sc.nextLine());

        roomList.add(new Room(num, type, price));
        Collections.sort(roomList); 
        System.out.println("Room added successfully.");
    }

    private void displayAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        boolean found = false;
        Iterator<Room> it = roomList.iterator();
        while (it.hasNext()) {
            Room r = it.next();
            if (r.isAvailable()) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("No rooms available.");
    }

    private void bookRoom(Scanner sc) {
        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Contact: ");
        String contact = sc.nextLine();
        System.out.print("Target Room Number: ");
        int rNum = Integer.parseInt(sc.nextLine());

        for (Room r : roomList) {
            if (r.getRoomNumber() == rNum) {
                if (r.isAvailable()) {
                    Customer c = new Customer(id, name, contact, rNum);
                    customerList.add(c);
                    roomMapping.put(rNum, c); 
                    r.setAvailable(false);
                    System.out.println("Booking successful!");
                    return;
                } else {
                    System.out.println("Room is already occupied.");
                    return;
                }
            }
        }
        System.out.println("Room not found.");
    }

    private void checkout(Scanner sc) {
        System.out.print("Enter Room Number for checkout: ");
        int rNum = Integer.parseInt(sc.nextLine());

        if (roomMapping.containsKey(rNum)) {
            for (Room r : roomList) {
                if (r.getRoomNumber() == rNum) {
                    r.setAvailable(true);
                    break;
                }
            }
            Customer c = roomMapping.remove(rNum);
            customerList.remove(c);
            System.out.println("Checkout successful for " + rNum);
        } else {
            System.out.println("Room is not currently occupied.");
        }
    }

    private void displayCustomers() {
        System.out.println("\n--- Current Guest List ---");
        if (customerList.isEmpty()) {
            System.out.println("No guests currently in the hotel.");
        } else {
            for (Customer c : customerList) {
                System.out.println(c);
            }
        }
    }
}