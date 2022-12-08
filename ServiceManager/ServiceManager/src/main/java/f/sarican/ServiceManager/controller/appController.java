package f.sarican.ServiceManager.controller;

import f.sarican.ServiceManager.exception.EmployeeNotFoundException;
import f.sarican.ServiceManager.model.Employee;

import f.sarican.ServiceManager.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class appController {

    private final EmployeeService employeeService;

    //Tüm verileri getir.(Çalışanlar)
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required = false) String firstName) {
        return new ResponseEntity<>(employeeService.getEmployees(firstName), OK);
    }

    //Veri tabanı ortak metod
    private Employee getEmployeeById(String id) {
        return employeeService.getEmployeeById(id);
    }

    // Id e göre veri getir(Çalışan)
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        return new ResponseEntity<>(getEmployeeById(id), OK);

    }

    // Veri ekle(Çalışan)
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee) {
        return new ResponseEntity<>(employeeService.createEmployee(newEmployee), CREATED);
    }

    // Id e göre veri güncelle.(Çalışan)
    @PutMapping("/{id}")
    public ResponseEntity<Void> getEmployee(@PathVariable String id,@RequestBody Employee newEployee) {
        employeeService.updateEmployee(id,newEployee);
        return new ResponseEntity<>(OK);
    }

    // Id e göre veri sil.(Çalışan)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(OK);
    }

    // Hata yakalama metodu
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException exp) {
        return new ResponseEntity<>(exp.getMessage(), NOT_FOUND);
    }
}
