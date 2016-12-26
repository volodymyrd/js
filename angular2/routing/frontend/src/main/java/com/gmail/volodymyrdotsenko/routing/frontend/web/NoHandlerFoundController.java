package com.gmail.volodymyrdotsenko.routing.frontend.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class NoHandlerFoundController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    @ExceptionHandler(value = {Exception.class})
    public String error(Model model, HttpServletRequest request,
                        HttpServletResponse response, Exception exception) {
        switch (response.getStatus()) {
            case 404:
                return "redirect:/index.html";
            case 403:
                break;
            default:
                exception.printStackTrace();
        }

        return null;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}