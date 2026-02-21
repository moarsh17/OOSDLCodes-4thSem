package LAB2;

import java.util.*;

enum RoomType{
    STANDARD(1500),
    DELUXE(2500),
    SUITE(5000);

    private int base_tariff;

    RoomType(int base_tariff){
        this.base_tariff = base_tariff;
    }

    public int get_tariff(){
        return base_tariff;
    }

    public int total_cost(int days_stayed){
        return base_tariff*days_stayed;
    }
}

public class hotelmanagement{
    public static void main(String[] args) {
        RoomType room = RoomType.DELUXE;
        int days_stayed = 4;
        System.out.println(("Room type :") + room);
        System.out.println(("Days stayed :") + days_stayed);
        System.out.println(("Tariff :") + room.get_tariff());
        System.out.println(("Total cost :") + room.total_cost(days_stayed));
    }
}

