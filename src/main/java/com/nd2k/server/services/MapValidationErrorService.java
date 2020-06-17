package com.nd2k.server.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> MapValidationService(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String, String> errorMapping = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMapping.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMapping, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
