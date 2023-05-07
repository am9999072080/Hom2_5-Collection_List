package ru.skyproHom2_5Collection_List.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends RuntimeException{

    public EmployeeStorageIsFullException(){
        super("Хранилище сотрудников заполнено");
    }
}
