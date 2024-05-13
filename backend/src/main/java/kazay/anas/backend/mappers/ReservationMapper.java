package kazay.anas.backend.mappers;

import org.springframework.stereotype.Component;
import kazay.anas.backend.entities.Reservation;
import kazay.anas.backend.dtos.ReservationDTO;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {



    public ReservationDTO reservationToDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setDate(reservation.getDate());
        reservationDTO.setDuration(reservation.getDuration());
        reservationDTO.setDescription(reservation.getDescription());
        reservationDTO.setStatus(reservation.getStatus());
        return reservationDTO;
    }

    public Reservation dtoToReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setDate(reservationDTO.getDate());
        reservation.setDuration(reservationDTO.getDuration());
        reservation.setDescription(reservationDTO.getDescription());
        reservation.setStatus(reservationDTO.getStatus());

        return reservation;
    }
}
