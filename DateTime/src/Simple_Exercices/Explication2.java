package Simple_Exercices;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Explication2 {
    public static void main(String[] args) {
        LocalDate d01 = LocalDate.parse("2001-11-23");
        LocalDateTime d02 = LocalDateTime.parse("2001-11-23T01:23:43");
        Instant d03 = Instant.parse("2001-11-23T01:23:43Z");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Forma 1: " + d01.format(fmt1));
        System.out.println("Forma 2: " + fmt1.format(d01));
        System.out.println("Forma 3: " + d01.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
