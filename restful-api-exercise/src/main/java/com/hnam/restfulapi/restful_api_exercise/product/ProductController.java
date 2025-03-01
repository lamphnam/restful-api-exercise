package com.hnam.restfulapi.restful_api_exercise.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(path = "/addProducts")
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @GetMapping(path = "/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping(path = "/products/{id}")
    public Optional<Product> getProductById(@PathVariable long id) {
        return service.getProductById(id);
    }

    @DeleteMapping(path = "/products/delete/{id}")
    public void deleteProductById(@PathVariable long id) {
        service.deleteProductById(id);
    }

    @PutMapping(path = "/products/update/{id}")
    public void updateProductByID(@PathVariable long id, @RequestBody Product product) {
        service.updateProductById(id, product);
    }
}
