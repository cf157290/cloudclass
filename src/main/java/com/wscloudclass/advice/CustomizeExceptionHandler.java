package com.wscloudclass.advice;

import com.wscloudclass.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handler(Model model,Throwable e){
        if (e instanceof CustomizeException){
            model.addAttribute("code",((CustomizeException) e).getCode());
            model.addAttribute("message",e.getMessage());
        }else {
            model.addAttribute("message","服务器忙碌,请稍后再试!!!");
        }
        return new ModelAndView("error");
    }
}
