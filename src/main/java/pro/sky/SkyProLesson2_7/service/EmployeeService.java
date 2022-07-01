package pro.sky.SkyProLesson2_5.service;

import org.springframework.stereotype.Service;
import pro.sky.SkyProLesson2_5.exception.EmployeeAlreadyAddedException;
import pro.sky.SkyProLesson2_5.exception.EmployeeNotFoundException;
import pro.sky.SkyProLesson2_5.exception.EmployeeStorageIsFullException;
import pro.sky.SkyProLesson2_5.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }

        return employee;
    }


    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }
}
