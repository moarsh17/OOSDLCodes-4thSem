package LAB2;

import java.util.*;

public class hotelbilling{

    public static double display_roomcost(double tariff, int days_stayed){
        return tariff*days_stayed;
    }
    public static double display_totalbill(double room_cost, double service_charges){
        return room_cost+service_charges;
    }
    public static void main(String[] args) {
        double tariff = 1500.50;
        int days_stayed = 4;
        double service_charges = 200.10;
        
        Double TARIFF = tariff;
        Integer Days = days_stayed;
        Double Service = service_charges;

        double room_cost = display_roomcost(tariff, days_stayed);

        System.out.println(("Tariff :") + tariff);
        System.out.println(("Days stayed :") + days_stayed);
        System.out.println(("Service charges :") + service_charges);
        System.out.println(("Room cost :") + display_roomcost(tariff, days_stayed));
        System.out.println(("Total bill :") + display_totalbill(room_cost, service_charges));
    }
}