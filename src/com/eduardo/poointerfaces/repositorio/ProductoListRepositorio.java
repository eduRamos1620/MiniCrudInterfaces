package com.eduardo.poointerfaces.repositorio;

import com.eduardo.poointerfaces.modelo.Cliente;
import com.eduardo.poointerfaces.modelo.Producto;
import com.eduardo.poointerfaces.repositorio.excepciones.LecturaAccesoDatosException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto>{

    @Override
    public void editar(Producto producto) throws LecturaAccesoDatosException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
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

    public static int ordenar(Producto a, Producto b, String campo){
        int resultado = 0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "descripcion" ->
                    resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" ->
                    resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
