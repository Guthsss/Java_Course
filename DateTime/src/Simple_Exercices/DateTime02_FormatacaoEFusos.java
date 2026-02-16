package Simple_Exercices;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Exemplo 02 - Formatação e Fusos (baseado no seu Explication2).
 *
 * O que você aprende aqui:
 * - formatar LocalDate e LocalDateTime
 * - formatar Instant usando ZoneId
 * - comparar o mesmo Instant em Londres e São Paulo
 * - ver que o offset pode mudar conforme a data (DST)
 */
public class DateTime02_FormatacaoEFusos {

    public static void main(String[] args) {
        System.out.println("=== Exemplo 02: Formatação e Fusos ===\n");

        LocalDate d01 = LocalDate.parse("2001-11-23");
        LocalDateTime d02 = LocalDateTime.parse("2001-11-23T01:23:43");
        Instant d03 = Instant.parse("2001-11-23T01:23:43Z");
        Instant d04 = Instant.now();

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("LocalDate formatado (dd/MM/yyyy): " + d01.format(fmt1));
        System.out.println("LocalDateTime formatado (dd/MM/yyyy HH:mm): " + d02.format(fmt2));

        System.out.println();

        // Seu jeito original: formatter com zone do sistema
        ZoneId zoneSystem = ZoneId.systemDefault();
        DateTimeFormatter fmtSystem = fmt3.withZone(zoneSystem);

        System.out.println("Fuso do sistema: " + zoneSystem);
        System.out.println("d03 (Instant UTC) exibido no fuso do sistema: " + fmtSystem.format(d03));
        System.out.println("d04 (Instant agora) exibido no fuso do sistema: " + fmtSystem.format(d04));

        System.out.println();

        // Complemento: comparar fusos específicos
        ZoneId london = ZoneId.of("Europe/London");
        ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");

        System.out.println("d03 em Londres: " + fmt3.withZone(london).format(d03));
        System.out.println("d03 em São Paulo: " + fmt3.withZone(saoPaulo).format(d03));

        // Complemento: mostrar offsets (pra entender DST)
        System.out.println();
        System.out.println("Offset SP em 2001-11-23 (d03): " + d03.atZone(saoPaulo).getOffset());
        System.out.println("Offset SP hoje: " + Instant.now().atZone(saoPaulo).getOffset());
    }
}