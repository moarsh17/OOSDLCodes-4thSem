package LAB7;

class GenericMethods{
    public static <T> void printArray(T[] array){
        for(T element: array){
            System.out.println(element+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] roomNo = {101,102,103};
        String[] types = {"Standard","Deluxe","Suite"};
        Double[] price = {1500.0,2500.0,4000.0};
        printArray(roomNo);
        printArray(types);
        printArray(price);
    }
}