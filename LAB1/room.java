import java.util.*;

class roomDetails{
    public int roomNumber;
    public String roomType;
    public int basePrice;

    roomDetails(int roomNumber, String roomType){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }
    roomDetails(int roomNumber, String roomType, int basePrice){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.basePrice = basePrice;
    }

    public void displayroomDetails(){
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Base Price: " + basePrice);
    }
}

class deluxeRoom extends roomDetails{
    public boolean freeWifi;
    public boolean breakfast;

    deluxeRoom(int roomNumber, String roomType, int basePrice, boolean freeWifi, boolean breakfast){
        super(roomNumber, roomType, basePrice);
        this.freeWifi = freeWifi;
        this.breakfast = breakfast;
    }
    public void displayDeluxeRoomDetails(){
        displayroomDetails();
        System.out.println("Free Wifi: " + freeWifi);
        System.out.println("Breakfast: " + breakfast);
    }
}

public class room {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room number:");
        int roomNumber = sc.nextInt();
        System.out.println("Enter room type:");
        String roomType = sc.next();    
        System.out.println("Enter base price:");
        int basePrice = sc.nextInt();   
        roomDetails rd = new roomDetails(roomNumber, roomType, basePrice);
        System.out.println("Room Details:");
        rd.displayroomDetails();
        System.out.println("Does the room have free wifi? (true/false):");
        boolean freeWifi = sc.nextBoolean();    
        System.out.println("Does the room include breakfast? (true/false):");
        boolean breakfast = sc.nextBoolean();   
        deluxeRoom dr = new deluxeRoom(roomNumber, roomType, basePrice, freeWifi, breakfast);
        System.out.println("Deluxe Room Details:"); 
        dr.displayDeluxeRoomDetails();
    }
}
