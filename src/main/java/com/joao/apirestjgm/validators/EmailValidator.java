package com.joao.apirestjgm.validators;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator {
    public boolean isValid(String email) {
        // Lógica de validação de email (regex ou bibliotecas especializadas)
        return true; // Exemplo de implementação
    }
}
