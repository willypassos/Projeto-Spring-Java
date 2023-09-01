package br.com.challengejava.orderapplication.service.products;

import br.com.challengejava.orderapplication.dto.products.ProductDTO;
import br.com.challengejava.orderapplication.model.products.Product;
import br.com.challengejava.orderapplication.repository.products.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAllProducts( ) {
        return productRepository.findAll().stream()
                .map(p -> modelMapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
       Product order = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(order,ProductDTO.class);
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
       Product product = modelMapper.map(productDTO,Product.class);
        productRepository.save(product);

        return modelMapper.map(product,ProductDTO.class);
    }

    public ProductDTO updateProduct(Long Id,ProductDTO orderDto) {
       Product product = modelMapper.map(orderDto,Product.class);
       product.setId(Id);
       product  = productRepository.save(product );

        return modelMapper.map(product,ProductDTO.class);
    }

    public void deleteProduct(Long Id) {
        productRepository.deleteById(Id);
    }

}