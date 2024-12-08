package com.eduardo.poointerfaces;

import com.eduardo.poointerfaces.modelo.Cliente;
import com.eduardo.poointerfaces.modelo.Producto;
import com.eduardo.poointerfaces.repositorio.ClienteListRepositorio;
import com.eduardo.poointerfaces.repositorio.Direccion;
import com.eduardo.poointerfaces.repositorio.FullInterfaces;
import com.eduardo.poointerfaces.repositorio.ProductoListRepositorio;
import com.eduardo.poointerfaces.repositorio.excepciones.AccesoDatoException;
import com.eduardo.poointerfaces.repositorio.excepciones.LecturaAccesoDatosException;

import java.util.List;

public class MainRepositorioProducto {
    public static void main(String[] args) {
        try {
            FullInterfaces<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Cama", 11000));
            repo.crear(new Producto("Refri", 16000));
            repo.crear(new Producto("Moto electrica", 3000));
            repo.crear(new Producto("ISDH", 30498));

            List<Producto> productos = repo.listar();
            productos.forEach(c -> System.out.println(c));

            System.out.println();

            List<Producto> paginable = repo.listar(0, 2);
            paginable.forEach(p -> System.out.println(p));

            System.out.println();

            List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
            //clientesOrdenAsc.forEach(ord -> System.out.println(ord));
            for (Producto orden : productosOrdenAsc) {
                System.out.println(orden);
            }

            System.out.println();

            Producto actua = new Producto("pc gamer", 12000);
            actua.setId(1);
            repo.editar(actua);
            Producto mostrar = repo.porId(1);
            System.out.println(mostrar);

            System.out.println();

            repo.eliminar(4);
            repo.listar().forEach(producto -> System.out.println(producto));

            System.out.println();
            System.out.println("Total de registros: " + repo.total());
        } catch (LecturaAccesoDatosException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
