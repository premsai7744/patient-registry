package com.premit.patient_registry.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest req) {
        List<String> messages = ex.getFieldErrors()
                                  .stream()
                                  .map(ele->ele.getDefaultMessage())
                                  .collect(Collectors.toList());
        logger.error("messages");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(messages);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception ex,HttpServletRequest req){
        logger.error(ex.getMessage());
        logger.error(req.getContextPath());
        logger.error(req.getPathInfo());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                              .body(ex.getMessage());
    }

}
