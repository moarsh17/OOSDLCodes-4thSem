import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("input.txt");
            fos = new FileOutputStream("output.txt");
            int data;
            while((data = fis.read())!= -1){
                fos.write(data);
            }
            System.out.println("File contents copied successfully");
        }catch (IOException e){
            System.out.println("File error: " + e.getMessage());
        }finally{
            try{
                if(fis!=null && fos!=null){
                    fis.close();
                    fos.close();
                }
            }catch(IOException e){
                System.out.println("Error closing file");
            }
        }
    }
}
