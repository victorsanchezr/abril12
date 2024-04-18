package com.softtek.polimorfismo.presentacion;

import com.softtek.polimorfismo.modelo.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Producto> array = new ArrayList<>();
        Producto prod1 = new Producto("primer",1.50);
        Producto prod2 = new Producto("primer",2.50);
        Producto prod3 = new Producto("primer",15.50);
        Producto prod4 = new Producto("primer",1.70);
        Producto prod5 = new Producto("primer",1.20);


        array.add(prod1);
        array.add(prod2);
        array.add(prod3);
        array.add(prod4);
        array.add(prod5);

        IImuesto ivagen = new ivaGeneral();
        IImuesto ivare = new ivaSuperReducido();

        Facturas fac1 = new Facturas(ivagen,array);
        Facturas fac2 = new Facturas(ivare,array);

        System.out.printf("Total: " +fac1.calcularTotalFactura());

        System.out.printf("Total: " +fac2.calcularTotalFactura());


    }
}
