package br.com.challengejava.orderapplication.controller.products;

import br.com.challengejava.orderapplication.dto.products.ProductDTO;
import br.com.challengejava.orderapplication.service.products.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@Data
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductService service;



    @GetMapping("/")
    public List<ProductDTO> getAllProducts()  {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable @NotNull Long id) {
        ProductDTO dto = service.getProductById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> addProduct(@RequestBody @Valid ProductDTO productDto, UriComponentsBuilder uriBuilder) {
        ProductDTO product = service.addProduct(productDto);

        URI uri = uriBuilder.path("/orders/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(product);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable @NotNull Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateOrderStatus(@PathVariable Long id, @RequestBody @Valid ProductDTO productDto) {
        ProductDTO update = service.updateProduct(id, productDto);
        return ResponseEntity.ok(update);
    }
}