import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("in.txt")){
            FileWriter fw = new FileWriter("out.txt");
            int ch;
            while((ch=fr.read())!=-1){
                fw.write(ch);
            }
            fw.close();
            System.out.println("Data written successfully");
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
