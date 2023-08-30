package br.com.challengejava.orderapplication.dto;

import br.com.challengejava.orderapplication.model.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private Long id;
    private Integer userId;
    private Integer amount;
    private Status status;
}
