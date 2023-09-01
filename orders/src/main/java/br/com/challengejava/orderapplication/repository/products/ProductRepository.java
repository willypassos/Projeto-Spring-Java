package br.com.challengejava.orderapplication.repository.products;

import br.com.challengejava.orderapplication.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

    @Repository
    public interface ProductRepository extends JpaRepository<Product, Long> {
    }

