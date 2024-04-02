package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumb = sc.nextInt();
			System.out.print("Check-in (dd/mm/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.next(), formatter);

			System.out.print("Check-out (dd/mm/yyyy): ");
			LocalDate checkout = LocalDate.parse(sc.next(), formatter);

			Reservation reservation = new Reservation(roomNumb, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update reservation ");
			System.out.print("Check-in (dd/mm/yyyy): ");
			checkin = LocalDate.parse(sc.next(), formatter);

			System.out.print("Check-out (dd/mm/yyyy): ");
			checkout = LocalDate.parse(sc.next(), formatter);

			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		catch ( IllegalArgumentException e) {
			System.out.println("Error in reservation: "+e.getMessage());
		}
		

		sc.close();
	}
}
