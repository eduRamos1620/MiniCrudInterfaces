package com.eduardo.poointerfaces;

import com.eduardo.poointerfaces.modelo.Cliente;
import com.eduardo.poointerfaces.repositorio.*;
import com.eduardo.poointerfaces.repositorio.excepciones.AccesoDatoException;
import com.eduardo.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;
import com.eduardo.poointerfaces.repositorio.excepciones.LecturaAccesoDatosException;

import java.util.List;

public class MainRepositorio {
    public static void main(String[] args) {
        try {
            FullInterfaces<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Charles", "Ans"));
            repo.crear(new Cliente("Gera", "Mx"));
            repo.crear(new Cliente("Nanpa", "Basico"));
            Cliente duplicado = new Cliente("ISDH", "ERR");
            repo.crear(duplicado);
            //repo.crear(duplicado);
            //repo.crear(null);

            List<Cliente> clientes = repo.listar();
            clientes.forEach(c -> System.out.println(c));

            System.out.println();

            List<Cliente> paginable = repo.listar(0, 2);
            paginable.forEach(p -> System.out.println(p));

            System.out.println();

            List<Cliente> clientesOrdenAsc = repo.listar("nombre", Direccion.ASC);
            //clientesOrdenAsc.forEach(ord -> System.out.println(ord));
            for (Cliente orden : clientesOrdenAsc) {
                System.out.println(orden);
            }

            System.out.println();

            Cliente actua = new Cliente("Charles", "Anestesia");
            actua.setId(1);
            repo.editar(actua);
            Cliente mostrar = repo.porId(1);
            System.out.println(mostrar);

            System.out.println();

            repo.eliminar(4);
            repo.listar().forEach(cliente -> System.out.println(cliente));

            System.out.println();
            System.out.println("Total de registros: " + repo.total());
        } catch (LecturaAccesoDatosException e){
            System.out.println("Lectura " + e.getMessage());
            e.printStackTrace();
        }catch (EscrituraAccesoDatosException e){
            System.out.println("Escritura " + e.getMessage());
            e.printStackTrace();
        }catch (AccesoDatoException e){
            System.out.println("Generica " + e.getMessage());
            e.printStackTrace();
        }
    }
}
