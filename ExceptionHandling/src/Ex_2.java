import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Admin\\Downloads\\arara.txt");

        Scanner input = null;

        try {
            input = new Scanner(file);
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error opening file " + e.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
            System.out.println("Finally block executable");
        }
    }
}
