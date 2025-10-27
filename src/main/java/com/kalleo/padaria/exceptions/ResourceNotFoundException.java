package com.kalleo.padaria.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Construtor que recebe um ID e gera uma mensagem padrão
    public ResourceNotFoundException(Long id) {
        super("Recurso não encontrado com ID: " + id);
    }
}
