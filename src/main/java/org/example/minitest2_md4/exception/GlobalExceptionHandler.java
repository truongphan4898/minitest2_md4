package org.example.minitest2_md4.exception;


import org.example.minitest2_md4.dto.ComputerDTO;
import org.example.minitest2_md4.model.TypeComputer;
import org.example.minitest2_md4.service.ITypeComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DuplicateCodeException.class)
    public ModelAndView handleDuplicateCodeException(DuplicateCodeException ex) {
        ModelAndView mav = new ModelAndView("/error_code");
        mav.addObject("errorMessage", ex.getMessage());
        return mav;
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFoundException(ResourceNotFoundException ex) {
        ModelAndView mav = new ModelAndView("/error");
        mav.addObject("errorMessage", ex.getMessage());
        return mav;
    }


}
