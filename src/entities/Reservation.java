package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.ReservationDataException;

public class Reservation {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new ReservationDataException("Check-out date must be after check-in date!");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date chckout) {
		this.checkout = chckout;
	}
	
	public Integer duration() {
		long duration = checkout.getTime() - checkin.getTime();
		return (int) TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		Date current = new Date();
		if (!checkout.after(checkin)) {
			throw new ReservationDataException("Check-out date must be after check-in date!");
		}
		else if (checkin.before(current) || checkout.before(current)) {
			throw new ReservationDataException("Check-in and check-out must be futture dates");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Reservation: Room " + roomNumber + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout) 
				+ ", " + duration() + " night(s)";
	}
	
}
