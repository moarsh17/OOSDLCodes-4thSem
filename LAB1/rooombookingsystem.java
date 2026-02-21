import java.util.*;

class Room{
    public int roomNo;
    public int baseTariff;

    Room(int roomNo, int baseTariff){
        this.roomNo = roomNo;
        this.baseTariff = baseTariff;
    }

    public void calculateTariff(){
        System.out.println("Base Tariff: " + baseTariff*1.05);
    }
}

class StandardRoom extends Room{
    StandardRoom(int roomNo, int baseTariff){
        super(roomNo, baseTariff);
    }
    public void calculateTariff(){
        System.out.println("Standard Room Tariff: " + baseTariff*1.10);
    }
}

class DeluxeRoom extends Room{
    DeluxeRoom(int roomNo, int baseTariff){
        super(roomNo, baseTariff);
    }
    public void calculateTariff(){
        System.out.println("Deluxe Room Tariff: " + baseTariff*1.20);
    }
}

public class rooombookingsystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room number:");
        int roomNo = sc.nextInt();
        System.out.println("Enter base tariff:");
        int baseTariff = sc.nextInt();
        Room r = new Room(roomNo, baseTariff);
        r.calculateTariff();
        StandardRoom sr = new StandardRoom(roomNo, baseTariff);
        sr.calculateTariff();
        DeluxeRoom dr = new DeluxeRoom(roomNo, baseTariff);
        dr.calculateTariff();
    }
}
