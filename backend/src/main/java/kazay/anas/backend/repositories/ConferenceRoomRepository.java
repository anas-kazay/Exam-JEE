package kazay.anas.backend.repositories;

import kazay.anas.backend.entities.ConferenceRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRoomRepository extends JpaRepository<ConferenceRoom,Long> {
}
