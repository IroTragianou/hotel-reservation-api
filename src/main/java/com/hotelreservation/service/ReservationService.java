package com.hotelreservation.service;


import com.hotelreservation.entity.Reservation;
import com.hotelreservation.entity.ReservationStatus;
import com.hotelreservation.exception.InvalidDataException;
import com.hotelreservation.exception.ResourceNotFoundException;
import com.hotelreservation.repository.CustomerRepository;
import com.hotelreservation.repository.HotelRepository;
import com.hotelreservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final HotelRepository hotelRepository;
    private final CustomerRepository customerRepository;


    public ReservationService(
            ReservationRepository reservationRepository,
            HotelRepository hotelRepository,
            CustomerRepository customerRepository
    ) {
        this.reservationRepository = reservationRepository;
        this.hotelRepository = hotelRepository;
        this.customerRepository = customerRepository;

    }

    private void validateDates(LocalDate checkIn, LocalDate checkout) {
        if (checkIn == null || checkout == null) {
            throw new InvalidDataException("Check-in and check-out are required.");
        }

        if (!checkout.isAfter(checkIn)) {

            throw new InvalidDataException("Check-out must be after check-in.");
        }
    }

    private void validatePrice(BigDecimal totalPrice) {
        if (totalPrice == null) {
            throw new InvalidDataException("Total price is required.");
        }
        if (totalPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidDataException("Total price cannot be negative.");
        }
    }

    public Reservation createReservation(Reservation reservation) {
        validateDates(
                reservation.getCheckIn(),
                reservation.getCheckOut()
        );

        validatePrice(reservation.getTotalPrice());

        hotelRepository.findById(reservation.getHotel().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hotel not found."));

        customerRepository.findById(reservation.getCustomer().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found."));


        validateNoOverlap(reservation);

        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Reservation not found."));
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void cancelReservation(Long id) {
        Reservation reservation = getReservationById(id);
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);
    }

    private List<Reservation> getAllReservationsByCustomerId(Long customerId) {
        return reservationRepository.findByCustomerId(customerId);

    }

    private void validateNoOverlap(Reservation reservation) {
        Long customerId = reservation.getCustomer().getId();
        List<Reservation> reservations =
                getAllReservationsByCustomerId(customerId);
        for (Reservation existingReservation : reservations) {
            if (existingReservation.getStatus() == ReservationStatus.ACTIVE) {
                boolean overlaps =
                        reservation.getCheckIn().isBefore(existingReservation.getCheckOut())
                                && reservation.getCheckOut().isAfter(existingReservation.getCheckIn());
                if (overlaps) {
                    throw new InvalidDataException(
                            "Reservation dates overlap with an existing reservation."
                    );
                }
            }
        }


    }


}

