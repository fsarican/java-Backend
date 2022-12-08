package f.sarican.ServiceManager.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
