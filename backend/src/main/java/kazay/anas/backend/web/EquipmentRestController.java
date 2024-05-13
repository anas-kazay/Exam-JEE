package kazay.anas.backend.web;

import kazay.anas.backend.dtos.EquipmentDTO;
import kazay.anas.backend.services.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipments")
@Slf4j
@AllArgsConstructor
@CrossOrigin("*")
public class EquipmentRestController {

    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<EquipmentDTO> createEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        EquipmentDTO createdEquipment = reservationService.saveEquipment(equipmentDTO);
        return new ResponseEntity<>(createdEquipment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentDTO> getEquipmentById(@PathVariable Long id) {
        EquipmentDTO equipmentDTO = reservationService.getEquipmentById(id);
        if (equipmentDTO != null) {
            return new ResponseEntity<>(equipmentDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<EquipmentDTO> getAllEquipments() {
        List<EquipmentDTO> equipments = reservationService.getAllEquipments();
        return equipments;
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        reservationService.deleteEquipment(id);
    }
}
