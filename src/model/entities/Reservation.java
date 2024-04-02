package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long p = ChronoUnit.DAYS.between(checkIn, checkOut);
		return p;
	}

	public String updateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "Error: check-in or check-out before now";
		}
		if (!checkOut.isAfter(checkIn)) {
			return "Error in reservation check-out before check-in";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;

	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", Check-in: " + formatter.format(checkIn) + ", Check-out: "
				+ formatter.format(checkOut) + ", " + duration() + " nights";
	}
}
