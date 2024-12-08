package com.eduardo.poointerfaces.repositorio;

import com.eduardo.poointerfaces.modelo.BaseEntity;
import com.eduardo.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements FullInterfaces<T>{
    protected List<T> dataSource;

    public AbstractaListRepositorio(){
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatosException{
        if (id == null || id <= 0){
            throw new LecturaAccesoDatosException("Id invalido debe ser mayor que cero");
        }
        T resultado = null;
        for (T clie: dataSource){
            if (clie.getId().equals(id)){
                resultado = clie;
                break;
            }
        }
        if (resultado == null){
            throw new LecturaAccesoDatosException("No existe el registro con el Id: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatosException{
        if (t == null){
            throw new EscrituraAccesoDatosException("No se puede agregar un registro null");
        }
        if (this.dataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatosException("Error el objeto con id " + t.getId() + " ya existe");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatosException{

        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
