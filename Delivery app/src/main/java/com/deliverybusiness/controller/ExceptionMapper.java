//package com.deliverybusiness.controller;
//
//import com.deliverybusiness.exception.WrongIdException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import java.util.HashMap;
//
//
//@ControllerAdvice
//public class ExceptionMapper extends ResponseEntityExceptionHandler {
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid
//            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return this.handleExceptionInternal(ex, handleException(ex), headers, status, request);
//    }
//    private HashMap<String, String> convertException(String msg){
//        HashMap<String, String> mapa = new HashMap<>();
//        mapa.put("Error", msg);
//        return mapa;
//    }
//
//    private HashMap<String, String> handleException(MethodArgumentNotValidException methodArgumentNotValidException) {
//        StringBuilder message = new StringBuilder();
//        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
//            message.append(String.format("%s: %s. ", fieldError.getField(), fieldError.getDefaultMessage()));
//        }
//            HashMap<String, String> mapa = new HashMap<>();
//            mapa.put("Info", message.toString());
//            return mapa;
//        }
//    @ExceptionHandler({WrongIdException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public HashMap<String, String> handleWrongIdException(WrongIdException wrongIdException){
//        return convertException(wrongIdException.getMessage());
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public HashMap<String,String> handleNullPointerException(NullPointerException nullPointerException){
//        return convertException(nullPointerException.getMessage());
//    }
//
//}
