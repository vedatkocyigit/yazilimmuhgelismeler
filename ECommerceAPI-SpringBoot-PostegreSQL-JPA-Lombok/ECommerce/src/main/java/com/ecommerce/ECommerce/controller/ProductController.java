package com.ecommerce.ECommerce.controller;


import com.ecommerce.ECommerce.entity.Product;
import com.ecommerce.ECommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor

public class ProductController {

    private final ProductService productService;



    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id){

        return productService.getProduct(id);
    }


    @GetMapping("/name/{name}")
    public List<Product> getProductByName(@PathVariable String name){

        return productService.getProductByName(name.replace("-"," "));
    }


    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){

        return productService.getProductsByCategory(category);
    }

    @GetMapping("/brand/{brand}")
    public List<Product> getProductsBySeller(@PathVariable String brand){

        return productService.getProductsBySeller(brand);
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product){

        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product){

        return productService.updateProduct(id,product);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){

         productService.deleteProduct(id);

    }


}
