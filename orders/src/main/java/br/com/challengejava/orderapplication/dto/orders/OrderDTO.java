package br.com.challengejava.orderapplication.dto.orders;

import br.com.challengejava.orderapplication.enums.Status;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO  {


    private UUID id;
    private Long userId;
    private Status status;
    private BigDecimal totalPrice;
    private List<OrderItemDto> items = new ArrayList<>();

}
