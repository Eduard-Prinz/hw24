package hw24.hw.service;

import hw24.hw.exception.EmployeeAlreadyAddedException;
import hw24.hw.exception.EmployeeNotFoundException;
import hw24.hw.exception.InvalideInputExeption;
import hw24.hw.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import static org.apache.commons.lang3.StringUtils.*;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }


    @Override
    public Employee addsEmployee(String firstName, String lastName, int salary, int departmentId) {
        validateInput(firstName, lastName);

        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFirstName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFirstName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        validateInput(firstName, lastName);

        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        validateInput(firstName, lastName);

        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalideInputExeption();
        }

    }

}