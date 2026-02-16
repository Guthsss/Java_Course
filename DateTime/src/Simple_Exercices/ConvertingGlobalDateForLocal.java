package Simple_Exercices;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Demonstração: convertendo uma data/hora "global" (UTC) para uma data/hora "local"
 * (dependente de fuso) usando a API {@code java.time}.
 *
 * <h2>Conceitos principais</h2>
 * <ul>
 *   <li>{@link LocalDate}: representa apenas uma data (ano-mês-dia), <b>sem</b> hora e <b>sem</b> fuso.</li>
 *   <li>{@link LocalDateTime}: representa data + hora, <b>sem</b> fuso.</li>
 *   <li>{@link Instant}: representa um momento exato na linha do tempo (sempre em UTC).</li>
 *   <li>{@link ZoneId}: identifica um fuso horário (ex.: {@code America/Sao_Paulo}, {@code Europe/Lisbon}).</li>
 * </ul>
 *
 * <h2>Objetivo do exemplo</h2>
 * Pegar um {@link Instant} (momento UTC) e "ver" esse mesmo momento como {@link LocalDateTime}
 * em dois fusos diferentes: o fuso padrão do computador e um fuso específico.
 */
public class ConvertingGlobalDateForLocal {

    public static void main(String[] args) {

        // LocalDate: apenas data (não tem horas/minutos/segundos nem fuso).
        LocalDate d01 = LocalDate.now();

        // LocalDateTime: data + hora, mas ainda sem fuso.
        LocalDateTime d02 = LocalDateTime.now();

        // Instant: "agora" em UTC (momento global, ideal para logs/banco/integração).
        Instant d03 = Instant.now();

        /*
         * (Opcional) Lista todos os ZoneIds disponíveis na sua JVM.
         * Útil para descobrir o ID correto de uma região.
         *
         * for (String s : ZoneId.getAvailableZoneIds()) {
         *     System.out.println(s);
         * }
         */

        // Converte o Instant (UTC) para "data/hora local" usando o fuso do sistema.
        // Aqui você está dizendo: "qual é a data e hora locais deste instante, no meu computador?"
        LocalDateTime r1 = LocalDateTime.ofInstant(d03, ZoneId.systemDefault());

        // Converte o mesmo Instant para "data/hora local" em um fuso específico.
        // IMPORTANTE: ZoneId.of(...) precisa de um ID real, como "Europe/Lisbon".
        // "Portugal" geralmente NÃO é um ZoneId válido.
        LocalDateTime r2 = LocalDateTime.ofInstant(d03, ZoneId.of("Europe/Lisbon"));

        // Imprime as duas interpretações locais do mesmo instante (d03).
        System.out.println("r1 (no fuso do sistema): " + r1);
        System.out.println("r2 (no fuso Europe/Lisbon): " + r2);

        System.out.println();

        // Extra: acessando partes de uma LocalDate.
        // getDayOfMonth: dia do mês (1..31)
        // getMonthValue: mês (1..12)
        // getYear: ano
        System.out.println("d01 dia: " + d01.getDayOfMonth());
        System.out.println("d01 mês: " + d01.getMonthValue());
        System.out.println("d01 ano: " + d01.getYear());

        System.out.println("-----------------------------------");

        // Extra: acessando partes de uma LocalDateTime (horas/minutos/segundos).
        System.out.println("d02 horas: " + d02.getHour());
        System.out.println("d02 minutos: " + d02.getMinute());
        System.out.println("d02 segundos: " + d02.getSecond());
    }
}