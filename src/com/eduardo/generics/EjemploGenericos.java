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

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientesPremiun);

        System.out.println("Maximo entre 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo entre 5.5, 3.2, 7.8 es: " + maximo(5.5, 3.2, 7.8));
        System.out.println("Maximo entre perro, gato, pez es: " + maximo("perro", "gato", "pez"));
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

    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>>  T maximo(T a, T b, T c){
        T max = a;
        if(b.compareTo(max) > 0){
            max = b;
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }
}
