package kazay.anas.backend.dtos;

import kazay.anas.backend.entities.ReservationStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDTO {
    private Long id;
    private Date date;
    private int duration;
    private String description;
    private ReservationStatus status;
    private EmployeDTO employe;

}
