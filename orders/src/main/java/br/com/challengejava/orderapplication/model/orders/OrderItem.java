package br.com.challengejava.orderapplication.model.orders;

import br.com.challengejava.orderapplication.model.orders.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private BigDecimal price;

    @NotNull
    @Positive
    private Integer amount;

    private BigDecimal partialAmount;

    @ManyToOne(optional=false)
    private Order order;

}
