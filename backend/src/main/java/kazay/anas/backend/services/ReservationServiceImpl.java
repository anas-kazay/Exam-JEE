package kazay.anas.backend.services;

import kazay.anas.backend.mappers.ConferenceRoomMapper;
import kazay.anas.backend.mappers.EmployeMapper;
import kazay.anas.backend.mappers.EquipmentMapper;
import kazay.anas.backend.mappers.ReservationMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kazay.anas.backend.dtos.*;
import kazay.anas.backend.entities.*;
import kazay.anas.backend.repositories.ConferenceRoomRepository;
import kazay.anas.backend.repositories.EmployeRepository;
import kazay.anas.backend.repositories.EquipmentRepository;
import kazay.anas.backend.repositories.ReservationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {


    private EmployeRepository employeRepository;


    private ConferenceRoomRepository conferenceRoomRepository;


    private EquipmentRepository equipmentRepository;


    private ReservationRepository reservationRepository;


    public EmployeMapper employeMapper;


    private ConferenceRoomMapper conferenceRoomMapper;


    private EquipmentMapper equipmentMapper;


    private ReservationMapper reservationMapper;

    @Override
    public EmployeDTO saveEmploye(EmployeDTO employeDTO) {
        Employe employe = employeMapper.dtoToEmploye(employeDTO);
        Employe savedEmploye = employeRepository.save(employe);
        return employeMapper.employeToDTO(savedEmploye);
    }

    @Override
    public EmployeDTO updateEmploye(EmployeDTO employeDTO) {
        Employe existingEmploye = employeRepository.findById(employeDTO.getId()).orElse(null);
        if (existingEmploye == null) {
            return null;
        } else {
            existingEmploye.setName(employeDTO.getName());
            existingEmploye.setEmail(employeDTO.getEmail());
            existingEmploye.setPhoto(employeDTO.getPhoto());

            Employe updatedEmploye = employeRepository.save(existingEmploye);
            return employeMapper.employeToDTO(updatedEmploye);
        }
    }


    @Override
    public EmployeDTO getEmployeeById(Long id) {
        Employe employe = employeRepository.findById(id).orElse(null);
        return (employe != null) ? employeMapper.employeToDTO(employe) : null;
    }

    @Override
    public List<EmployeDTO> getAllEmployees() {
        List<Employe> employees = employeRepository.findAll();
        return employees.stream().map(employeMapper::employeToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public ConferenceRoomDTO saveConferenceRoom(ConferenceRoomDTO conferenceRoomDTO) {
        ConferenceRoom conferenceRoom = conferenceRoomMapper.dtoToConferenceRoom(conferenceRoomDTO);
        ConferenceRoom savedConferenceRoom = conferenceRoomRepository.save(conferenceRoom);
        return conferenceRoomMapper.conferenceRoomToDTO(savedConferenceRoom);
    }

    @Override
    public ConferenceRoomDTO getConferenceRoomById(Long id) {
        ConferenceRoom conferenceRoom = conferenceRoomRepository.findById(id).orElse(null);
        return (conferenceRoom != null) ? conferenceRoomMapper.conferenceRoomToDTO(conferenceRoom) : null;
    }

    @Override
    public List<ConferenceRoomDTO> getAllConferenceRooms() {
        List<ConferenceRoom> conferenceRooms = conferenceRoomRepository.findAll();
        return conferenceRooms.stream().map(conferenceRoomMapper::conferenceRoomToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteConferenceRoom(Long id) {
        conferenceRoomRepository.deleteById(id);
    }

    @Override
    public EquipmentDTO saveEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentMapper.dtoToEquipment(equipmentDTO);
        Equipment savedEquipment = equipmentRepository.save(equipment);
        return equipmentMapper.equipmentToDTO(savedEquipment);
    }

    @Override
    public EquipmentDTO getEquipmentById(Long id) {
        Equipment equipment = equipmentRepository.findById(id).orElse(null);
        return (equipment != null) ? equipmentMapper.equipmentToDTO(equipment) : null;
    }

    @Override
    public List<EquipmentDTO> getAllEquipments() {
        List<Equipment> equipments = equipmentRepository.findAll();
        return equipments.stream().map(equipmentMapper::equipmentToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.dtoToReservation(reservationDTO);
        return reservationMapper.reservationToDTO(reservation);
    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        return (reservation != null) ? reservationMapper.reservationToDTO(reservation) : null;
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservationMapper::reservationToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<EmployeDTO> searchEmployes(String keyword) {
        List<Employe> customers =  employeRepository.findByNameContains(keyword);
        List<EmployeDTO> customerDTOS = customers.stream().map(emp -> employeMapper.employeToDTO(emp)).collect(Collectors.toList());
        return customerDTOS;
    }
}
