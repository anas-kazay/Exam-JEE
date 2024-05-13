package kazay.anas.backend.web;

import kazay.anas.backend.dtos.EmployeDTO;
import kazay.anas.backend.services.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class EmployeRestController {

    private ReservationService reservationService;

    @PostMapping
    public EmployeDTO createEmployee(@RequestBody EmployeDTO employeeDTO) {
        EmployeDTO createdEmployee = reservationService.saveEmploye(employeeDTO);
        return createdEmployee;
    }

    @GetMapping("/{id}")
    public EmployeDTO getEmployeeById(@PathVariable Long id) {
        EmployeDTO employeeDTO = reservationService.getEmployeeById(id);
        if (employeeDTO != null) {
            return employeeDTO;
        } else {
            return null;
        }
    }

    @GetMapping
    public List<EmployeDTO> getAllEmployees() {
        List<EmployeDTO> employees = reservationService.getAllEmployees();
        return employees;
    }

    @PutMapping("/{id}")
    public EmployeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeDTO employeDTO) {
        employeDTO.setId(id);
        EmployeDTO updatedEmployee = reservationService.updateEmploye(employeDTO);
        if (updatedEmployee != null) {
            return updatedEmployee;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        reservationService.deleteEmployee(id);
    }

    @GetMapping("/search")
    public List<EmployeDTO> searchCustomers(@RequestParam(name="keyword",defaultValue = "") String keyword){
        return reservationService.searchEmployes(keyword);
    }
}
