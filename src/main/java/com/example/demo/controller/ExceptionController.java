package com.example.demo.controller;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.exception.InvalidDataException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.utils.Constants.INVALID_DATA;
import static com.example.demo.utils.Constants.HANDLE_ERRORS;
import static com.example.demo.utils.Constants.VALIDATION_FAILED;

@SuppressWarnings({"unchecked", "rawtypes"})
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest){
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrorDTO errorDTO = new ErrorDTO(HANDLE_ERRORS, details);
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(InvalidDataException invalidDataException, WebRequest webRequest){
        List<String> details = new ArrayList<>();
        details.add(invalidDataException.getLocalizedMessage());
        ErrorDTO errorDTO = new ErrorDTO(INVALID_DATA, details);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest){
        List<String> details = new ArrayList<>();
        for(ObjectError error: methodArgumentNotValidException.getBindingResult().getAllErrors()){
            details.add(error.getDefaultMessage());
        }
        ErrorDTO errorDTO = new ErrorDTO(VALIDATION_FAILED, details);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
