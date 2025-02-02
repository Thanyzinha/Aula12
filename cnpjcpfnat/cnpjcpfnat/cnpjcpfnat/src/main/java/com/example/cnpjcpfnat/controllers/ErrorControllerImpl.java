package com.example.cnpjcpfnat.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllerImpl implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Página de erro personalizada, pode ser HTML ou uma simples mensagem
        return "error";  // Retorna para a página de erro, que pode ser um arquivo 'error.html' em 'src/main/resources/templates'
    }
}
