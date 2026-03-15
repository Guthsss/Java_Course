import java.io.File;
import java.util.Scanner;

public class cr_167 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a file path");
        String srtPath = input.nextLine();

        File path = new File(srtPath);

        System.out.println("getName: " + path.getName());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getPath: " + path.getPath());

        input.close();
    }
}
