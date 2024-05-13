package kazay.anas.backend.repositories;

import kazay.anas.backend.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    List<Employe> findByNameContains(String keyword);
}
