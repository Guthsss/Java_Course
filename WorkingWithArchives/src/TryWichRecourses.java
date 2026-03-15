import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWichRecourses {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("/home/guths/Downloads/TXT.txt"))){

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}