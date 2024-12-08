package com.eduardo.poointerfaces.repositorio.excepciones;

public class RegistroDuplicadoAccesoDatosException extends EscrituraAccesoDatosException{
    public RegistroDuplicadoAccesoDatosException(String message) {
        super(message);
    }
}
