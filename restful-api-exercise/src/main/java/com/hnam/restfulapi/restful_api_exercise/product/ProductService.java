package com.hnam.restfulapi.restful_api_exercise.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product request) {
        repository.save(request);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(long id) {
        return repository.findById(id);
    }

    public void deleteProductById(long id) {
        repository.deleteById(id);
    }

    public void updateProductById(long id, Product request) {
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        repository.save(product);
    }
}
