package kazay.anas.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int duration;
    private String description;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private ConferenceRoom conferenceRoom;
    @ManyToMany
    private List<Equipment> equipments;
}
