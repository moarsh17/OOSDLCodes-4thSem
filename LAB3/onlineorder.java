package LAB3;

class OrderProcessingSystem extends Thread{
    private String serviceName;
    private int duration;

    OrderProcessingSystem(String serviceName, int duration){
        this.serviceName = serviceName;
        this.duration = duration;
    }

    @Override
    public void run(){
        try{
            System.out.println(serviceName + " has started...");
            Thread.sleep(duration);
            System.out.println(serviceName + " is complete");
        } catch(InterruptedException e){
            System.out.println(serviceName + " interrupted");
        }
    }
}

public class onlineorder {
    public static void main(String[] args) {
        OrderProcessingSystem t1 = new OrderProcessingSystem("Order Validation", 2000);
        OrderProcessingSystem t2 = new OrderProcessingSystem("Payment Processing", 4000);
        OrderProcessingSystem t3 = new OrderProcessingSystem("Order Shipment", 10000);
        t1.start();
        t2.start();
        t3.start();
    }
}
