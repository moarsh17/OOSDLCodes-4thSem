import java.util.*;

abstract class Room{
    public int roomNo;
    public int basePrice;
    public abstract void calculateTariff();
    public void displayRoomDetails(){
        System.out.println("Room Number: " + roomNo);
        System.out.println("Base Price: " + basePrice);
    }
}

interface Amenities{
    void provideWifi();
    void provideBreakfast();
}

class StandardRoom extends Room implements Amenities{
    public void calculateTariff(){
        System.out.println("Standard Room Tariff: " + basePrice*1.10);
    }
    public void provideWifi(){
        System.out.println("Standard Room provides Wifi");
    }
    public void provideBreakfast(){
        System.out.println("Standard Room provides Breakfast");
    }
}

class DeluxeRoom extends Room implements Amenities{
    public void calculateTariff(){
        System.out.println("Deluxe Room Tariff: " + basePrice*1.20);
    }
    public void provideWifi(){
        System.out.println("Deluxe Room provides Wifi");
    }
    public void provideBreakfast(){
        System.out.println("Deluxe Room provides Breakfast");
    }
}

public class abstraction {
    
}
