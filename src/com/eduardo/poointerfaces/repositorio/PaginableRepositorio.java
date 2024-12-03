package com.eduardo.poointerfaces.repositorio;

import com.eduardo.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);
}
