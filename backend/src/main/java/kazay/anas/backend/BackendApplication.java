package kazay.anas.backend;

import kazay.anas.backend.entities.*;
import kazay.anas.backend.repositories.ConferenceRoomRepository;
import kazay.anas.backend.repositories.EmployeRepository;
import kazay.anas.backend.repositories.EquipmentRepository;
import kazay.anas.backend.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class BackendApplication implements CommandLineRunner {
    private EmployeRepository employeeRepository;
    private ConferenceRoomRepository conferenceRoomRepository;
    private EquipmentRepository equipmentRepository;
    private ReservationRepository reservationRepository;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // Adding 5 employees
        for (int i = 1; i <= 5; i++) {
            Employe employee = new Employe();
            employee.setName("Employee " + i);
            employee.setEmail("employee" + i + "@example.com");
            employee.setPhoto("photo" + i + ".jpg");
            employeeRepository.save(employee);

            // Creating 2 reservations for each employee
            for (int j = 1; j <= 2; j++) {
                // Salle de conférence
                ConferenceRoom conferenceRoom = new ConferenceRoom();
                conferenceRoom.setNumber("Room " + i + j);
                conferenceRoom.setName("Meeting Room " + i + j);
                conferenceRoom.setCapacity(20);
                conferenceRoom.setType(ConferenceRoomType.REUNION);
                conferenceRoomRepository.save(conferenceRoom);

                // Équipement
                Equipment equipment = new Equipment();
                equipment.setName("Projector " + i + j);
                equipment.setWeight(5.0);
                equipment.setType(EquipmentType.VIDEO_PROJECTOR);
                equipment.setCatalog("projector_catalog.pdf");
                equipmentRepository.save(equipment);

                // Réservation
                Reservation reservation = new Reservation();
                reservation.setDate(new Date());
                reservation.setDuration(2);
                reservation.setDescription("Meeting " + j + " for Employee " + i);
                reservation.setStatus(ReservationStatus.VALIDATED);
                reservation.setEmploye(employee);
                reservation.setConferenceRoom(conferenceRoom);
                reservation.setEquipments(Arrays.asList(equipment));
                reservationRepository.save(reservation);
            }
        }
    }

}
