package org.example.minitest2_md4.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateCodeException.class)
    public ModelAndView handleDuplicateCodeException(DuplicateCodeException ex) {
        ModelAndView mav = new ModelAndView("/add");
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
