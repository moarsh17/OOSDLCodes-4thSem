package LAB6;
import java.io.*;

public class HotelRAF {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("rooms.txt", "rw");

            int RECORD_SIZE = 4 + (20 * 2) + 8 + 1; 

            raf.seek(0);
            raf.writeInt(1);
            raf.writeChars(String.format("%-20s", "Deluxe"));
            raf.writeDouble(2500);
            raf.writeBoolean(false);

            raf.seek(0);
            System.out.println("Room No: " + raf.readInt());

            char[] type = new char[20];
            for(int i=0;i<20;i++)
                type[i] = raf.readChar();
            System.out.println("Type: " + new String(type).trim());

            System.out.println("Price: " + raf.readDouble());
            System.out.println("Booked: " + raf.readBoolean());

            raf.seek(4 + (20*2) + 8); 
            raf.writeBoolean(true);

            raf.seek(4 + (20*2) + 8);
            System.out.println("Updated Status: " + raf.readBoolean());

            raf.close();
        } 
        catch(IOException e) {
            System.out.println(e);
        }
    }
}