package com.eduardo.poointerfaces.repositorio;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T> implements FullInterfaces<T>{
    protected List<T> dataSource;

    public AbstractaListRepositorio(){
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    /*@Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for (Cliente clie: dataSource){
            if (clie.getId().equals(id)){
                resultado = clie;
                break;
            }
        }
        return resultado;
    }*/

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {

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
