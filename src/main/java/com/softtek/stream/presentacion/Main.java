package com.softtek.stream.presentacion;

import com.softtek.stream.modelo.OrderDetails;
import com.softtek.stream.persistencia.AccesoOrderDetails;

import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccesoOrderDetails ac = new AccesoOrderDetails();
        //ejercicio1(ac);
        //ejercicio2(ac);

       // ejercicio3(ac);

       // ejercicio4(ac);
        ejercicio5(ac);
    }

    public static void ejercicio1(AccesoOrderDetails ac) throws SQLException, ClassNotFoundException {

        Predicate<OrderDetails> categoria = x->x.getUnitPrice() > 30;
        ac.obtenerTodos().stream().filter(categoria).forEach(System.out::println);

    }

    public static void ejercicio2(AccesoOrderDetails ac) throws SQLException, ClassNotFoundException {


        ac.obtenerTodos().stream().sorted(Comparator.comparing(OrderDetails::getUnitPrice).reversed()).forEach(System.out::println);

    }

    public static void ejercicio3(AccesoOrderDetails ac) throws SQLException, ClassNotFoundException {


        Optional<OrderDetails> detalleMinimo = ac.obtenerTodos()
                .stream()
                .min(Comparator.comparing(OrderDetails::getUnitPrice));


        System.out.println(detalleMinimo);


    }

    public static void ejercicio4(AccesoOrderDetails ac) throws SQLException, ClassNotFoundException {

        IntSummaryStatistics esta = ac.obtenerTodos().stream().mapToInt(OrderDetails::getQuantity).summaryStatistics();


        System.out.println(esta.getMax());
        System.out.println(esta.getMin());


    }

    public static void ejercicio5(AccesoOrderDetails ac) throws SQLException, ClassNotFoundException {

        Map<Integer, Integer> productQuantitySum = ac.obtenerTodos().stream()
                .collect(Collectors.groupingBy(OrderDetails::getProductId,
                        Collectors.summingInt(OrderDetails::getQuantity)));

        System.out.println(productQuantitySum);


    }
}
