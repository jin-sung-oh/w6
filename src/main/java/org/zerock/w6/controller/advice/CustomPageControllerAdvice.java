package org.zerock.w6.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zerock.w6.exception.DataNotFoundException;

import java.util.zip.DataFormatException;

@ControllerAdvice
@Log4j2
public class CustomPageControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DataNotFoundException.class)
    public String handleNotFound(DataNotFoundException exception){
       log.info("handleNotFound");
       return "my404";
    }

}
