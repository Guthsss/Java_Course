import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Rooms rooms;
        Rooms[] array = new Rooms[10];
        System.out.print("Numbers of Students: ");
        int n = input.nextInt();
        input.nextLine();
        for (int i=0;i<n;i++) {
            System.out.print("Enter a Name: ");
            String name = input.nextLine();

            System.out.print("Enter a Email: ");
            String email = input.next();

            System.out.print("Choose a room(1-10): ");
            int chose = input.nextInt();

            input.nextLine();
            if (chose < 1 || chose > 10) {
                System.out.println("Error: Invalid room");
                i--;
                continue;
            } else if (array[chose-1] != null) {
                System.out.println("Room already chosen");
                i--;
                continue;
            }
            rooms = new Rooms(name, email, false);
            array[chose-1] = rooms;
        }
        System.out.println(" ");
        System.out.println("Occupied rooms: ");
        System.out.println(" ");
        for (int i=0;i< array.length;i++) {
            Rooms r = array[i];
            if (r != null) {
                System.out.println("Room " + (i + 1) + ": " + r);
            }
        }
    }
}
