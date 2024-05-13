package kazay.anas.backend.web;

import kazay.anas.backend.dtos.ConferenceRoomDTO;
import kazay.anas.backend.services.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/conferenceRooms")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ConferenceRoomRestController {

    private ReservationService conferenceRoomService;

    @PostMapping
    public ConferenceRoomDTO createConferenceRoom(@RequestBody ConferenceRoomDTO conferenceRoomDTO) {
        ConferenceRoomDTO createdRoom = conferenceRoomService.saveConferenceRoom(conferenceRoomDTO);
        return createdRoom;
    }

    @GetMapping("/{id}")
    public ConferenceRoomDTO getConferenceRoomById(@PathVariable Long id) {
        ConferenceRoomDTO roomDTO = conferenceRoomService.getConferenceRoomById(id);
        if (roomDTO != null) {
            return roomDTO;
        } else {
            return null;
        }
    }

    @GetMapping
    public List<ConferenceRoomDTO> getAllConferenceRooms() {
        List<ConferenceRoomDTO> rooms = conferenceRoomService.getAllConferenceRooms();
        return rooms;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConferenceRoom(@PathVariable Long id) {
        conferenceRoomService.deleteConferenceRoom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

