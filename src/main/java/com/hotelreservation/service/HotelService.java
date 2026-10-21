package com.hotelreservation.service;


import com.hotelreservation.entity.Hotel;
import com.hotelreservation.exception.ResourceConflictException;
import com.hotelreservation.repository.ReservationRepository;
import com.hotelreservation.exception.ResourceNotFoundException;
import com.hotelreservation.repository.HotelRepository;
import com.hotelreservation.exception.InvalidDataException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;

    public HotelService(HotelRepository hotelRepository, ReservationRepository reservationRepository) {
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
    }

    public Hotel createHotel(Hotel hotel) {
        validateStars(hotel.getStars());
        return hotelRepository.save(hotel);
    }

    private void validateStars(Integer stars) {
        if (stars == null || stars < 1 || stars > 5) {
            throw new InvalidDataException("Hotel stars must be between 1 and 5.");
        }
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hotel is not found."));
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Hotel existingHotel = getHotelById(id);

        validateStars(updatedHotel.getStars());

        existingHotel.setName(updatedHotel.getName());
        existingHotel.setStars(updatedHotel.getStars());
        existingHotel.setCity(updatedHotel.getCity());

        return hotelRepository.save(existingHotel);
    }

    public void deleteHotel(Long id) {
        Hotel hotel = getHotelById(id);
        if (reservationRepository.existsByHotelId(id)){
            throw new ResourceConflictException("This hotel has existing reservations and cannot be deleted.");
        }
        hotelRepository.delete(hotel);
    }
}
