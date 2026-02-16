package Simple_Exercices;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Exemplo 01 - Criação e Parse (usando os seus exemplos como base).
 *
 * O que você aprende aqui:
 * - now(): criar data/hora atual
 * - parse(): converter String -> objeto de data/hora
 * - diferença rápida entre LocalDate / LocalDateTime / Instant
 */
public class DateTime01_CriacaoEParse {

    public static void main(String[] args) {
        System.out.println("=== Exemplo 01: Criação e Parse ===\n");

        // Seus exemplos (now)
        LocalDateTime d01 = LocalDateTime.now();
        LocalDate d02 = LocalDate.now();
        Instant d03 = Instant.now();

        // Seus exemplos (parse ISO)
        LocalDate d04 = LocalDate.parse("2001-11-23");
        LocalDateTime d05 = LocalDateTime.parse("2001-11-23T01:23:43");
        Instant d06 = Instant.parse("2001-11-23T01:23:43Z");
        Instant d07 = Instant.parse("2001-11-23T01:23:43-03:00");

        // Seus exemplos (parse BR com formatter)
        LocalDate d08 = LocalDate.parse("20/12/2007", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDateTime d09 = LocalDateTime.parse("21/11/2009 12:11", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        // Seu exemplo (of)
        LocalDateTime d10 = LocalDateTime.of(2009, 10, 21, 20, 11, 21, 32323);

        System.out.println("LocalDateTime (agora): " + d01);
        System.out.println("LocalDate (hoje): " + d02);
        System.out.println("Instant (agora UTC): " + d03);

        System.out.println();

        System.out.println("LocalDate (ISO parse): " + d04);
        System.out.println("LocalDateTime (ISO parse): " + d05);
        System.out.println("Instant (ISO UTC Z): " + d06);
        System.out.println("Instant (ISO com offset): " + d07);

        System.out.println();

        System.out.println("LocalDate (dd/MM/yyyy): " + d08);
        System.out.println("LocalDateTime (dd/MM/yyyy HH:mm): " + d09);
        System.out.println("LocalDateTime (of manual): " + d10);

        // Complemento (bem direto): Instant com offset vira um "momento UTC" também
        // (ele "normaliza" internamente para UTC).
        System.out.println();
        System.out.println("d07 (instant) em texto: " + d07);
    }
}