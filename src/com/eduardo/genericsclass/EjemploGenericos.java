package com.eduardo.genericsclass;

public class EjemploGenericos {
    public static void main(String[] args) {

        Camion<Animal> trnasporteCaballos = new Camion<>(5);
        trnasporteCaballos.add(new Animal("Spirit", "Caballo"));
        trnasporteCaballos.add(new Animal("Horse", "Caballo"));
        trnasporteCaballos.add(new Animal("Rayo", "Caballo"));
        trnasporteCaballos.add(new Animal("Rubi", "Caballo"));
        trnasporteCaballos.add(new Animal("Suly", "Caballo"));

        imprimirCamion(trnasporteCaballos);

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Excavadora"));
        transMaquinas.add(new Maquinaria("Pereforadora"));
        transMaquinas.add(new Maquinaria("Grua"));

        imprimirCamion(transMaquinas);

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Honda"));
        transAuto.add(new Automovil("Mazda"));
        transAuto.add(new Automovil("Ford"));

        imprimirCamion(transAuto);
    }

    public static <T> void imprimirCamion(Camion<T> camion){
        for (T a: camion){
            if (a instanceof Animal){
                System.out.println(((Animal)a).getNombre() + " tipo " + ((Animal)a).getTipo());
            }
            if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria)a).getTipo());
            }
            if (a instanceof Automovil){
                System.out.println(((Automovil) a).getMarca());
            }
        }
    }
}
