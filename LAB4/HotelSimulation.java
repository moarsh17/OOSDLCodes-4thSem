package LAB4;

public class HotelSimulation {

    static class Hotel {
        private int availableRooms;

        public Hotel(int totalRooms) {
            this.availableRooms = totalRooms;
        }

        public synchronized void bookRoom(String customerName) {
            while (availableRooms == 0) {
                try {
                    System.out.println(customerName + " is waiting for a room...");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(customerName + " was interrupted.");
                }
            }

            availableRooms--;
            System.out.println(customerName + " booked a room. Available rooms: " + availableRooms);
        }

        public synchronized void releaseRoom(String customerName) {
            availableRooms++;
            System.out.println(customerName + " released a room. Available rooms: " + availableRooms);
            notifyAll(); 
        }
    }

    static class BookingTask implements Runnable {
        private final Hotel hotel;
        private final String customerName;

        public BookingTask(Hotel hotel, String customerName) {
            this.hotel = hotel;
            this.customerName = customerName;
        }

        @Override
        public void run() {
            hotel.bookRoom(customerName);
        }
    }

   static class ReleaseTask implements Runnable {
        private final Hotel hotel;
        private final String customerName;

        public ReleaseTask(Hotel hotel, String customerName) {
            this.hotel = hotel;
            this.customerName = customerName;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            hotel.releaseRoom(customerName);
        }
    }

    public static void main(String[] args) {

        Hotel hotel = new Hotel(2); 

        Thread c1 = new Thread(new BookingTask(hotel, "Customer-1"));
        Thread c2 = new Thread(new BookingTask(hotel, "Customer-2"));
        Thread c3 = new Thread(new BookingTask(hotel, "Customer-3"));
        Thread c4 = new Thread(new BookingTask(hotel, "Customer-4"));

        Thread r1 = new Thread(new ReleaseTask(hotel, "Customer-1"));
        Thread r2 = new Thread(new ReleaseTask(hotel, "Customer-2"));

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        r1.start();
        r2.start();
    }
}
