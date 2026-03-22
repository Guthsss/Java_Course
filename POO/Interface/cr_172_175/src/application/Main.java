package application;

import model.entities.CarRental;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter rental data:");

        System.out.print("Car model: ");
        String carModel = input.nextLine();

        System.out.print("Pickup (dd/MM/yyyy hh:mm");
        LocalDateTime pickupDate = LocalDateTime.parse(input.nextLine(), getFormatter());

        System.out.print("Return (dd/MM/yyyy hh:mm");
        LocalDateTime returnDate = LocalDateTime.parse(input.nextLine(), getFormatter());

        CarRental carRental = new CarRental(pickupDate, returnDate);
        RentalService rentalService = new RentalService(10.0, 130.0, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("INVOICE:");

        System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f",carRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

        input.close();
    }
    private static DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }
}
