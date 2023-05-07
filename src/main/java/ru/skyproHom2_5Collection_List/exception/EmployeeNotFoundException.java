package ru.skyproHom2_5Collection_List.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.skyproHom2_5Collection_List.model.Employee;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Employee employee){
        super("Сотрудник не найден: "+ employee.toString());
    }
}
