package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Client {

    private String name;
    private String email;
    private LocalDate birthDate;

    public Client(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Client: " + name + " ");
        stringBuilder.append("(" +
                birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ") - ");
        stringBuilder.append(email);
        return stringBuilder.toString();
    }
}
