package com.gibson.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Filip Kisic
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill extends BaseEntity {

    private int userId;
    private LocalDateTime dateOfPurchase;
    private double totalPrice;
    private String paymentMethod;

    public Bill(int id, int userId, LocalDateTime dateOfPurchase, double totalPrice, String paymentMethod) {
        super(id);
        this.userId = userId;
        this.dateOfPurchase = dateOfPurchase;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }
}
