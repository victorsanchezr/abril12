package com.softtek.polimorfismo.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor

public class Facturas {


    private IImuesto imuesto;

    private List<Producto> productos = new ArrayList<>();

    public Facturas(IImuesto imuesto, List<Producto> productos) {
        this.imuesto = imuesto;
        this.productos = productos;
    }

    public IImuesto getImuesto() {
        return imuesto;
    }

    public void setImuesto(IImuesto imuesto) {
        this.imuesto = imuesto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Producto pr) {
        productos.add(pr);
    }

    public double calcularTotalFactura(){

        double total = 0;
        for (int i = 0; i < productos.size(); i++) {

            total = total + (productos.get(i).getPrecio() + imuesto.calcularImpuesto(productos.get(i)));
        }

        return total;
    }



}
