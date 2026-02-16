package Simple_Exercices;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Explication {
    public static void main(String[] args) {

        // Agora esta classe virou um "atalho" para rodar exemplos separados,
        // reaproveitando (e complementando) exatamente os exemplos que você já tinha aqui.
        DateTime01_CriacaoEParse.main(args);
        System.out.println("\n----------------------------------------\n");

        DateTime02_FormatacaoEFusos.main(args);
        System.out.println("\n----------------------------------------\n");

        DateTime03_LeituraUsuarioScanner.main(args);
    }
}