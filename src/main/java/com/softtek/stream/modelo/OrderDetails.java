package com.softtek.stream.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    private int orderId;
    private int productId;
    private double unitPrice;
    private int quantity;
    private double discount;

}
