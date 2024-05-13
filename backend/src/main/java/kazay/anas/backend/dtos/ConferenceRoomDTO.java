package kazay.anas.backend.dtos;


import kazay.anas.backend.entities.ConferenceRoomType;
import lombok.Data;

@Data
public class ConferenceRoomDTO {
    private Long id;
    private String number;
    private String name;
    private int capacity;
    private ConferenceRoomType type;

}
