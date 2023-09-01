package br.com.challengejava.orderapplication.dto.products;

import br.com.challengejava.orderapplication.dto.orders.OrderDTO;
import br.com.challengejava.orderapplication.enums.Category;
import br.com.challengejava.orderapplication.model.products.Rating;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
public class ProductDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private String Description;
    private Category category;
    private String image;
    Rating rating;
}

