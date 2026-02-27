package LAB7;

class RoomCharges<T extends Number> {
    private T price;
    private T discount;

    public RoomCharges(T price, T discount) {
        this.price = price;
        this.discount = discount;
    }

    public double calculateTotalPrice() {
        return price.doubleValue();
    }

    public double calculateDiscountedPrice() {
        return price.doubleValue() - discount.doubleValue();
    }

    public void displayCharges() {
        System.out.println("Room Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Total Price: " + calculateTotalPrice());
        System.out.println("Discounted Price: " + calculateDiscountedPrice());
    }

    public static void main(String[] args) {
        System.out.println("Room 1 Price Details:");
        RoomCharges<Double> room1 = new RoomCharges<>(5000.0, 750.0);
        room1.displayCharges();
        System.out.println("Room 2 Price Details:");
        RoomCharges<Integer> room2 = new RoomCharges<>(3000, 500);
        room2.displayCharges();
    }
}