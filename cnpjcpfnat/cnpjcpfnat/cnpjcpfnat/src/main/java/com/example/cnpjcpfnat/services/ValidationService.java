package com.example.cnpjcpfnat.services;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", "");
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;
        return validateCPF(cpf);
    }

    public boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^\\d]", "");
        if (cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) return false;
        return validateCNPJ(cnpj);
    }

    private boolean validateCPF(String cpf) {
        int[] pesoCPF = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int digito1 = calculateDigit(cpf.substring(0, 9), pesoCPF);
        int digito2 = calculateDigit(cpf.substring(0, 9) + digito1, new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2});
        return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
    }

    private boolean validateCNPJ(String cnpj) {
        int[] pesoCNPJ1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesoCNPJ2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int digito1 = calculateDigit(cnpj.substring(0, 12), pesoCNPJ1);
        int digito2 = calculateDigit(cnpj.substring(0, 12) + digito1, pesoCNPJ2);
        return cnpj.equals(cnpj.substring(0, 12) + digito1 + digito2);
    }

    private int calculateDigit(String str, int[] peso) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - '0') * peso[i];
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }
}
