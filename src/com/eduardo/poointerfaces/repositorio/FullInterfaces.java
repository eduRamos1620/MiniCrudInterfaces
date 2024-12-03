package com.eduardo.poointerfaces.repositorio;

public interface FullInterfaces<T> extends  OrdenableRepositorio<T>, CrudRepositorio<T>, PaginableRepositorio<T>, ContableRepositorio{
}
