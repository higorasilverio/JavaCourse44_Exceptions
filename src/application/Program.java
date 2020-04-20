package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;
import exceptions.ReservationDataException;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner input = new Scanner(System.in);
		System.out.print("Room number: ");
		int roomNumber = input.nextInt();
		try {
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(input.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(input.next());
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(input.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(input.next());
			reservation.updateDates(checkin, checkout);
			System.out.println(reservation);			
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (ReservationDataException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		input.close();
	}
}
