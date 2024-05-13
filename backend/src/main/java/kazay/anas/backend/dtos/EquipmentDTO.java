package kazay.anas.backend.dtos;

import jakarta.persistence.*;
import kazay.anas.backend.entities.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EquipmentDTO {
    private Long id;
    private String name;
    private double weight;
    private EquipmentType type;
    private String catalog;
}

