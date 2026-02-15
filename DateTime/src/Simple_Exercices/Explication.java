package Simple_Exercices;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Explication {
    public static void main(String[] args) {

        LocalDateTime d01 = LocalDateTime.now();
        LocalDate d02 = LocalDate.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2001-11-23");
        LocalDateTime d05 = LocalDateTime.parse("2001-11-23T01:23:43");
        Instant d06 = Instant.parse("2001-11-23T01:23:43Z");
        Instant d07 = Instant.parse("2001-11-23T01:23:43-03:00");
        LocalDate d08 = LocalDate.parse("20/12/2007", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDateTime d09 = LocalDateTime.parse("21/11/2009 12:11", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        // d10: exemplo criando a data/hora diretamente por componentes (ano, mês, dia, hora, minuto, segundo, nanos).
        // Se você quiser, dá para preencher esses valores facilmente com Scanner.
        LocalDateTime d10 = LocalDateTime.of(2009, 10, 21, 20, 11, 21, 32323);

        // ... existing code ...

        // Exemplo prático: usando Scanner para o usuário digitar uma data/hora e criar um LocalDateTime.
        // Forma MAIS fácil: ler uma linha no formato "dd/MM/yyyy HH:mm" e parsear com DateTimeFormatter.
        try (Scanner sc = new Scanner(System.in)) {
            DateTimeFormatter fmtUser = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            System.out.print("Digite uma data e hora (dd/MM/yyyy HH:mm): ");
            String texto = sc.nextLine();

            LocalDateTime d10Scanner = LocalDateTime.parse(texto, fmtUser);
            System.out.println("LocalDateTime (digitado): " + d10Scanner);
        }

        System.out.println("LocalDateTime (agora): " + d01);
        System.out.println("LocalDate (hoje): " + d02);
        System.out.println("Instant (agora UTC): " + d03);

        System.out.println("LocalDate (ISO parse): " + d04);
        System.out.println("LocalDateTime (ISO parse): " + d05);
        System.out.println("Instant (ISO UTC Z): " + d06);
        System.out.println("Instant (ISO com offset): " + d07);

        System.out.println("LocalDate (dd/MM/yyyy): " + d08);
        System.out.println("LocalDateTime (dd/MM/yyyy HH:mm): " + d09);
        System.out.println("LocalDateTime (of manual): " + d10);
    }
}