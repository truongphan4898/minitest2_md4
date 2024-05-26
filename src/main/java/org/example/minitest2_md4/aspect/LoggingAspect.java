package org.example.minitest2_md4.aspect;

import org.example.minitest2_md4.exception.DuplicateCodeException;
import org.example.minitest2_md4.exception.ResourceNotFoundException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @AfterThrowing(pointcut = "execution(* org.example.minitest2_md4.service.ComputerService.findById(..))", throwing = "ex")
    public void logResourceNotFoundException(ResourceNotFoundException ex) {
        System.out.println("Logging Aspect: " + ex.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* org.example.minitest2_md4.service.ComputerService.save(..))", throwing = "ex")
    public void logDuplicateCodeException(DuplicateCodeException ex) {
        System.out.println("Logging Aspect: " + ex.getMessage());
    }
}
