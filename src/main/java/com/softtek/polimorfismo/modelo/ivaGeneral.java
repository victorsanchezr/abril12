package com.softtek.polimorfismo.modelo;

public class ivaGeneral implements IImuesto{
    @Override
    public double calcularImpuesto(Producto p1) {
        return p1.getPrecio()*1.21;
    }
}
