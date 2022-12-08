package f.sarican.ServiceManager.repository;

import f.sarican.ServiceManager.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IEmployeeRepository extends MongoRepository<Employee,String> {
    List<Employee> findByfirstName(String firstName);
}
