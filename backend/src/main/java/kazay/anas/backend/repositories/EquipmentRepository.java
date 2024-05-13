package kazay.anas.backend.repositories;

import kazay.anas.backend.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
}
