package com.example.cnpjcpfnat.controllers;

import com.example.cnpjcpfnat.exceptions.InvalidNumberException;
import com.example.cnpjcpfnat.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    @GetMapping("/cpf/{cpf}")
    public boolean validateCPF(@PathVariable String cpf) {
        if (!validationService.isValidCPF(cpf)) {
            throw new InvalidNumberException("CPF inválido: " + cpf);
        }
        return true;
    }

    @GetMapping("/cnpj/{cnpj}")
    public boolean validateCNPJ(@PathVariable String cnpj) {
        if (!validationService.isValidCNPJ(cnpj)) {
            throw new InvalidNumberException("CNPJ inválido: " + cnpj);
        }
        return true;
    }
}
