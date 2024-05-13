package kazay.anas.backend.mappers;

import kazay.anas.backend.dtos.ConferenceRoomDTO;
import kazay.anas.backend.entities.ConferenceRoom;
import org.springframework.stereotype.Service;

@Service
public class ConferenceRoomMapper {
    public ConferenceRoomDTO conferenceRoomToDTO(ConferenceRoom conferenceRoom) {
        ConferenceRoomDTO conferenceRoomDTO = new ConferenceRoomDTO();
        conferenceRoomDTO.setId(conferenceRoom.getId());
        conferenceRoomDTO.setNumber(conferenceRoom.getNumber());
        conferenceRoomDTO.setName(conferenceRoom.getName());
        conferenceRoomDTO.setCapacity(conferenceRoom.getCapacity());
        conferenceRoomDTO.setType(conferenceRoom.getType());
        return conferenceRoomDTO;
    }

    public ConferenceRoom dtoToConferenceRoom(ConferenceRoomDTO conferenceRoomDTO) {
        ConferenceRoom conferenceRoom = new ConferenceRoom();
        conferenceRoom.setId(conferenceRoomDTO.getId());
        conferenceRoom.setNumber(conferenceRoomDTO.getNumber());
        conferenceRoom.setName(conferenceRoomDTO.getName());
        conferenceRoom.setCapacity(conferenceRoomDTO.getCapacity());
        conferenceRoom.setType(conferenceRoomDTO.getType());
        return conferenceRoom;
    }
}
