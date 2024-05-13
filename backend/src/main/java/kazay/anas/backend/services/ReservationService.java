package kazay.anas.backend.services;

import kazay.anas.backend.dtos.ConferenceRoomDTO;
import kazay.anas.backend.dtos.EmployeDTO;
import kazay.anas.backend.dtos.EquipmentDTO;
import kazay.anas.backend.dtos.ReservationDTO;
import kazay.anas.backend.entities.ConferenceRoom;
import kazay.anas.backend.entities.Employe;
import kazay.anas.backend.entities.Equipment;
import kazay.anas.backend.entities.Reservation;

import java.util.List;

public interface ReservationService {
    EmployeDTO saveEmploye(EmployeDTO employeDTO);
    EmployeDTO updateEmploye(EmployeDTO employeDTO);
    EmployeDTO getEmployeeById(Long id);
    List<EmployeDTO> getAllEmployees();
    void deleteEmployee(Long id);
    ConferenceRoomDTO saveConferenceRoom(ConferenceRoomDTO conferenceRoomDTO);
    ConferenceRoomDTO getConferenceRoomById(Long id);
    List<ConferenceRoomDTO> getAllConferenceRooms();
    void deleteConferenceRoom(Long id);
    EquipmentDTO saveEquipment(EquipmentDTO equipment);
    EquipmentDTO getEquipmentById(Long id);
    List<EquipmentDTO> getAllEquipments();
    void deleteEquipment(Long id);
    ReservationDTO saveReservation(ReservationDTO reservationDTO);
    ReservationDTO getReservationById(Long id);
    List<ReservationDTO> getAllReservations();
    void deleteReservation(Long id);

    List<EmployeDTO> searchEmployes(String keyword);
}
