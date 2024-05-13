package kazay.anas.backend.mappers;

import kazay.anas.backend.dtos.EmployeDTO;
import kazay.anas.backend.entities.Employe;
import org.springframework.stereotype.Service;


@Service
public class EmployeMapper {
    public EmployeDTO employeToDTO(Employe employee) {
        EmployeDTO employeDTO = new EmployeDTO();
        employeDTO.setId(employee.getId());
        employeDTO.setName(employee.getName());
        employeDTO.setEmail(employee.getEmail());
        employeDTO.setPhoto(employee.getPhoto());
        return employeDTO;
    }

    public Employe dtoToEmploye(EmployeDTO employeeDTO) {
        Employe employee = new Employe();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoto(employeeDTO.getPhoto());
        return employee;
    }
}
