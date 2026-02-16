package Simple_Exercices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Exemplo 03 - Entrada do usuário com Scanner (baseado no seu exemplo prático).
 *
 * Complementos:
 * - valida o parse com try/catch (pra não quebrar se o usuário digitar errado)
 * - imprime a data/hora já formatada também
 */
public class DateTime03_LeituraUsuarioScanner {

    public static void main(String[] args) {
        System.out.println("=== Exemplo 03: Scanner (usuário digitando data/hora) ===\n");

        DateTimeFormatter fmtUser = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmtOut = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite uma data e hora (dd/MM/yyyy HH:mm): ");
            String texto = sc.nextLine();

            try {
                LocalDateTime dt = LocalDateTime.parse(texto, fmtUser);
                System.out.println("LocalDateTime (objeto): " + dt);
                System.out.println("Formatado (com segundos): " + dt.format(fmtOut));
            } catch (DateTimeParseException e) {
                System.out.println("Entrada inválida. Exemplo válido: 21/11/2009 12:11");
                System.out.println("Detalhe do erro: " + e.getMessage());
            }
        }
    }
}