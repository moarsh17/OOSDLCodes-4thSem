package LAB3;

class HotelManagement implements Runnable{
    private String servicename;
    private int duration;

    HotelManagement(String servicename,int duration){
        this.servicename = servicename;
        this.duration = duration;
    }

    @Override
    public void run(){
        try{
            System.out.println(servicename + " has started...");
            Thread.sleep(duration);
            System.out.println(servicename + " is complete");
        } catch(InterruptedException e){
            System.out.println(servicename + " interrupted");
        }
    }
}

public class roomservice {
    public static void main(String[] args) {                                                                                                                                                                                            
        HotelManagement t1 = new HotelManagement("Room Cleaning", 5000);
        HotelManagement t2 = new HotelManagement("Food Delivery", 8000);
        HotelManagement t3 = new HotelManagement("Maintainence", 7500);
        Thread task1 = new Thread(t1);
        Thread task2 = new Thread(t2);
        Thread task3 = new Thread(t3);
        task1.start();
        task2.start();
        task3.start();
    }
}
