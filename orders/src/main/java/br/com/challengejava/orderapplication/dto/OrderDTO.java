package br.com.challengejava.orderapplication.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private UUID id;
    private String name;
    private double price;
    private OrderDTO order;



}
