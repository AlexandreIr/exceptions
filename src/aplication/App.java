package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;


public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter	formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumb = sc.nextInt();
		System.out.print("Check-in (dd/mm/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(),formatter);
		
		System.out.print("Check-out (dd/mm/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(), formatter);
		
		if(!checkout.isAfter(checkin)) {
			System.out.println("Error in reservation check-out before check-in");
		} else {
			Reservation reservation = new Reservation(roomNumb, checkin, checkout);
			System.out.println("Reservation: "+reservation);
			System.out.println("Nights: "+reservation.duration());
		}
		
		
		
		sc.close();
	}
}
