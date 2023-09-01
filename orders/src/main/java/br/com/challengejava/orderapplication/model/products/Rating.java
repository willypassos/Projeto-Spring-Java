package br.com.challengejava.orderapplication.model.products;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import java.text.DecimalFormat;
@Entity
@Table(name = "rating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Positive
    private Double rate;
    private Double count;
}
