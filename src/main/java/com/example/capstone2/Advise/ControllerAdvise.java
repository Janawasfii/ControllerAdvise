package com.example.capstone2.Advise;

import com.example.capstone2.APIResponse.APIException;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice

public class ControllerAdvise {

    @ExceptionHandler(value = APIException.class)
    public ResponseEntity ApiException(APIException e){
    return ResponseEntity.status(400).body(e.getMessage());}

//Duplicate A username and email that are unique
@ExceptionHandler(value =DataIntegrityViolationException.class)
public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        return ResponseEntity.status(400).body(e.getMessage());
}

    //InvalidDataAccessResourceUsageException: JDBC exception executing SQL and could not execute statement
    //Get something found
    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class )
    public ResponseEntity InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
        return ResponseEntity.status(200).body(e.getMessage());
    }

    //JSON(forget the comma in body raw)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
    //In the path I put a String rather than Integer(id)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }

//    //SQL (Check "Coulmn" in the server)
//    @ExceptionHandler(value = CommandAcceptanceException.class)
//    public ResponseEntity CommandAcceptanceException(CommandAcceptanceException e){
//        return ResponseEntity.status(400).body(e.getMessage());
//    }

    //Forget a letter of attribute in JSON body and Protiens must be a positive number(I put a 0)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
    //(Forget to write "api" in the path)
    @ExceptionHandler(value = NoResourceFoundException.class)
    public  ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
    //wrong CRUD (choosing put rather than get)
    @ExceptionHandler(value= HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return ResponseEntity.status(405).body(e.getMessage());
    }


}
