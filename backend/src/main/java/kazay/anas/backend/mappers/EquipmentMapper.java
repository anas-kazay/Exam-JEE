package kazay.anas.backend.mappers;

import kazay.anas.backend.dtos.EquipmentDTO;
import kazay.anas.backend.entities.Equipment;
import org.springframework.stereotype.Service;

@Service
public class EquipmentMapper {
    public EquipmentDTO equipmentToDTO(Equipment equipment) {
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.setId(equipment.getId());
        equipmentDTO.setName(equipment.getName());
        equipmentDTO.setWeight(equipment.getWeight());
        equipmentDTO.setType(equipment.getType());
        equipmentDTO.setCatalog(equipment.getCatalog());
        return equipmentDTO;
    }

    public Equipment dtoToEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();
        equipment.setId(equipmentDTO.getId());
        equipment.setName(equipmentDTO.getName());
        equipment.setWeight(equipmentDTO.getWeight());
        equipment.setType(equipmentDTO.getType());
        equipment.setCatalog(equipmentDTO.getCatalog());
        return equipment;
    }
}
