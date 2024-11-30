package com.eduardo.poointerfaces.repositorio;

import com.eduardo.poointerfaces.modelo.Cliente;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio, PaginableRepositorio{
    private List<Cliente> dataSource;

    public ClienteListRepositorio(){
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for (Cliente clie: dataSource){
            if (clie.getId().equals(id)){
                resultado = clie;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente c = this.porId(id);
        this.dataSource.remove(c);
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
                int resultado = 0;
                if(dir == Direccion.ASC){
                    resultado = ordenar(a, b, campo);
                } else if (dir == Direccion.DESC) {
                    resultado = ordenar(b, a, campo);
                }
                return resultado;
        });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    public static int ordenar(Cliente a, Cliente b, String campo){
        int resultado = 0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
