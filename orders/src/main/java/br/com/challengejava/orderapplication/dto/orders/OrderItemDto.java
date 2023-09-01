package br.com.challengejava.orderapplication.dto.orders;

import lombok.*;

import java.math.BigDecimal;

@Data
public class OrderItemDto {

    private Long id;
    private BigDecimal price;
    private Integer amount;
    private BigDecimal partialAmount;
}
