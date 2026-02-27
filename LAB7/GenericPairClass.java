package LAB7;

class Pair<T, U> {

    private T first;   
    private U second;  

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void display() {
        System.out.println("Room Number: " + first);
        System.out.println("Guest Name: " + second);
        System.out.println("------------------------");
    }
}

public class GenericPairClass {

    public static void main(String[] args) {
        Pair<Integer, String> booking1 = new Pair<>(101, "Alice Johnson");
        Pair<Integer, String> booking2 = new Pair<>(102, "Michael Smith");
        Pair<Integer, String> booking3 = new Pair<>(103, "Sophia Brown");

        booking1.display();
        booking2.display();
        booking3.display();
    }
}