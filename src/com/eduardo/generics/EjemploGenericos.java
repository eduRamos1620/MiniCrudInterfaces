package com.eduardo.generics;

import com.eduardo.poointerfaces.modelo.Cliente;
import com.eduardo.poointerfaces.modelo.ClientePremiun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes= new ArrayList<>();
        clientes.add(new Cliente("Eduardo", "Ramos"));

        Cliente andres = clientes.get(0);

        Cliente[] clientesArreglo = {
                new Cliente("Soraya", "Hernandez"),
                new Cliente("Wasabi", "Duron")
        };
        Integer[] enterosArreglo = {1,2,3,4,5};

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        clientesLista.forEach(cl -> System.out.println(cl));
        enterosLista.forEach(el -> System.out.println(el));

        List<String> nombres = fromArrayToList(new String[]{"Juan", "Mario", "Pedro"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremiun> clientesPremiun = fromArrayToList(new ClientePremiun[]{
                new ClientePremiun("Indra", "Ramos")
        });
    }

    //Metodo Generico que convierte Arrays a Listas
    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento: x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }
}
