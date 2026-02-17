package Simple_Exercices;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * <h1>CalculateDateTime - Documentação + Exemplos (java.time)</h1>
 *
 * <p>Este arquivo foca em <b>cálculos</b> com datas/horas.</p>
 *
 * <h2>O que NÃO fica repetido aqui</h2>
 * <ul>
 *   <li>Parse (String -> data): veja {@code DateTime01_CriacaoEParse}</li>
 *   <li>Formatação e fusos: veja {@code DateTime02_FormatacaoEFusos} e {@code ConvertingGlobalDateForLocal}</li>
 *   <li>Entrada do usuário (Scanner): veja {@code DateTime03_LeituraUsuarioScanner}</li>
 * </ul>
 *
 * <h2>O que você vai ver aqui</h2>
 * <ol>
 *   <li>Somar/subtrair em {@link LocalDate} e {@link LocalDateTime}</li>
 *   <li>Diferenças: {@link Period} (datas) e {@link Duration} (tempo)</li>
 *   <li>{@link Instant} com {@link ChronoUnit}: plus/minus, between/until, truncar e arredondar</li>
 * </ol>
 */
public class CalculateDateTime {
    public static void main(String[] args) {

        // 1) Criação (agora)
        LocalDate d01 = LocalDate.now();           // somente data
        LocalDateTime d02 = LocalDateTime.now();   // data + hora (sem fuso)
        Instant d03 = Instant.now();               // instante UTC

        // 2) Formatadores (apenas para exibir LocalDate/LocalDateTime aqui)
        DateTimeFormatter fmtDateBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmtDateTimeBR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("=== 1) AGORA ===");
        System.out.println("LocalDate (hoje):        " + d01.format(fmtDateBR));
        System.out.println("LocalDateTime (agora):   " + d02.format(fmtDateTimeBR));
        System.out.println("Instant (UTC):           " + d03);

        System.out.println();
        System.out.println("=== 2) PLUS / MINUS (LocalDate / LocalDateTime) ===");

        // LocalDate (datas)
        LocalDate pastWeekLocalDate = d01.minusWeeks(1);
        LocalDate nextWeekLocalDate = d01.plusWeeks(1);
        LocalDate plus30Days = d01.plusDays(30);

        System.out.println("Semana passada:          " + pastWeekLocalDate.format(fmtDateBR));
        System.out.println("Semana que vem:          " + nextWeekLocalDate.format(fmtDateBR));
        System.out.println("+30 dias:                " + plus30Days.format(fmtDateBR));

        // LocalDateTime (data + hora)
        LocalDateTime nextHourLocalDateTime = d02.plusHours(1);
        LocalDateTime pastHourLocalDateTime = d02.minusHours(1);

        System.out.println("Agora + 1 hora:          " + nextHourLocalDateTime.format(fmtDateTimeBR));
        System.out.println("Agora - 1 hora:          " + pastHourLocalDateTime.format(fmtDateTimeBR));

        System.out.println();
        System.out.println("=== 3) DIFERENÇAS (Period vs Duration) ===");

        // Period: diferença entre DATAS (sem hora)
        LocalDate startDate = d01;
        LocalDate endDate = d01.plusMonths(1).plusDays(10);
        Period period = Period.between(startDate, endDate);
        System.out.println("Period (data->data):     " + period.getMonths() + " meses e " + period.getDays() + " dias");

        // Duration: diferença entre INSTANTES/TEMPO (com horas/minutos/segundos)
        Instant startInstant = d03;
        Instant endInstant = d03.plusSeconds(90);
        Duration duration = Duration.between(startInstant, endInstant);
        System.out.println("Duration (instant):      " + duration.getSeconds() + " segundos");

        System.out.println();
        System.out.println("=== 4) INSTANT + ChronoUnit (mais exemplos) ===");

        // 4.1) plus/minus usando ChronoUnit (boa opção quando você quer deixar explícita a unidade)
        Instant plus2Days = d03.plus(2, ChronoUnit.DAYS);
        Instant minus3Hours = d03.minus(3, ChronoUnit.HOURS);
        Instant plus1500Millis = d03.plus(1500, ChronoUnit.MILLIS);

        System.out.println("Instant + 2 dias:        " + plus2Days);
        System.out.println("Instant - 3 horas:       " + minus3Hours);
        System.out.println("Instant + 1500 ms:       " + plus1500Millis);

        // 4.2) truncar (zerar partes menores) -> útil para agrupar por minuto/hora/dia
        Instant truncToSeconds = d03.truncatedTo(ChronoUnit.SECONDS);
        Instant truncToMinutes = d03.truncatedTo(ChronoUnit.MINUTES);

        System.out.println("Truncado p/ segundos:    " + truncToSeconds);
        System.out.println("Truncado p/ minutos:     " + truncToMinutes);

        // 4.3) diferença em uma unidade específica usando ChronoUnit (sem precisar Duration manualmente)
        long secondsBetween = ChronoUnit.SECONDS.between(d03, plus2Days);
        long hoursBetween = ChronoUnit.HOURS.between(d03, plus2Days);
        long daysBetween = ChronoUnit.DAYS.between(d03, plus2Days);

        System.out.println("Segundos entre (d03 e +2d): " + secondsBetween);
        System.out.println("Horas entre (d03 e +2d):    " + hoursBetween);
        System.out.println("Dias entre (d03 e +2d):     " + daysBetween);

        // 4.4) until(): muito parecido com between, só que como método de instância
        long minutesUntil = d03.until(d03.plus(90, ChronoUnit.MINUTES), ChronoUnit.MINUTES);
        System.out.println("Minutes until (+90min):  " + minutesUntil);

        System.out.println();
        System.out.println("=== Observação importante ===");
        System.out.println("Instant é UTC (momento global). Para fuso/formatar, veja DateTime02_FormatacaoEFusos.");
    }
}