import java.util.*;

class bookDetails{
    private int bookID;
    private String title;
    private String author;
    private int price;
    private String availability;
    
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    public int getBookID() {
        return bookID;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPrice() {
        return price;
    }
    public String getAvailability() {
        return availability;
    }
}

public class book{
    public static void main(String[] args){
        bookDetails b = new bookDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book ID:");
        b.setBookID(sc.nextInt());
        System.out.println("Enter book title:");
        b.setTitle(sc.next());
        System.out.println("Enter book author:");
        b.setAuthor(sc.next());
        System.out.println("Enter book price:");
        b.setPrice(sc.nextInt());
        System.out.println("Enter book availability:");
        b.setAvailability(sc.next());
        System.out.println("Book details:");
        System.out.println("Book ID: " + b.getBookID());
        System.out.println("Book Title: " + b.getTitle());
        System.out.println("Book Author: " + b.getAuthor());
        System.out.println("Book Price: " + b.getPrice());
        System.out.println("Book Availability: " + b.getAvailability());
        sc.close();
    }
}
