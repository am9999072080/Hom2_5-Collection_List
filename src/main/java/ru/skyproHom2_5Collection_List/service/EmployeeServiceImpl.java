package ru.skyproHom2_5Collection_List.service;

import org.springframework.stereotype.Service;
import ru.skyproHom2_5Collection_List.exception.EmployeeAlreadyAddedException;
import ru.skyproHom2_5Collection_List.exception.EmployeeNotFoundException;
import ru.skyproHom2_5Collection_List.exception.EmployeeStorageIsFullException;
import ru.skyproHom2_5Collection_List.model.Employee;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private  static  final  int Employees_MAX_Count=5;
    private final Set<Employee>employees;
    public EmployeeServiceImpl() {
        this.employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException(employee);
    }
        if(employees.size()==Employees_MAX_Count){
            throw new EmployeeStorageIsFullException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeNotFoundException(employee);
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException(employee);
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }
}
