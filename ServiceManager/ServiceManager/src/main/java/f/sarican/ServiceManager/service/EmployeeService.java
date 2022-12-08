package f.sarican.ServiceManager.service;

import f.sarican.ServiceManager.exception.EmployeeNotFoundException;
import f.sarican.ServiceManager.model.Employee;
import f.sarican.ServiceManager.repository.IEmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;
    public List<Employee> getEmployees(String firstName) {
        if(firstName == null) {
            return employeeRepository.findAll();
        }else {
            return employeeRepository.findByfirstName(firstName);
        }
    }

    public Employee createEmployee(Employee newEmployee) {
        return  employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Girilen id ile Çalışan bulunamadı : " + id));
    }

    public void updateEmployee(String id, Employee newEployee) {
        Employee oldEmployee = getEmployeeById(id);
        oldEmployee.setFirstName(newEployee.getFirstName());
        oldEmployee.setSurName(newEployee.getSurName());
        employeeRepository.save(oldEmployee);
    }
}
