package com.softtek.stream.persistencia;

import com.softtek.stream.modelo.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoOrderDetails extends Conexion {

    public List<OrderDetails> obtenerTodos() throws ClassNotFoundException, SQLException {
        Statement sentencia;

        ResultSet resultado;

        String sql = "SELECT order_id, product_id, unit_price, quantity, discount FROM order_details";

        List<OrderDetails> order = new ArrayList<>();

        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);

        while (resultado.next()) {
            order.add(new OrderDetails(
                    resultado.getInt("order_id"),
                    resultado.getInt("product_id"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("quantity"),
                    resultado.getDouble("discount")));

        }

        return order;
    }
}

