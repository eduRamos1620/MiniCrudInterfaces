package com.eduardo.poointerfaces.repositorio;

import com.eduardo.poointerfaces.modelo.Cliente;
import com.eduardo.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void crear(T cliente) throws AccesoDatoException;
    void editar(T cliente) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;
}
