package LAB7;

public class HotelRoomManagementSystem {
    public static <T> void display(T data){
        System.out.println("Data: " + data);
    }
    public static void main(String[] args){
        display(101);
        display("Deluxe");
        display(4000.0);
        display(true);
    }
}
