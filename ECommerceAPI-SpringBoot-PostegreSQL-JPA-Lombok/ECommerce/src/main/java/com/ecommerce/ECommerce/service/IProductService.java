package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {


    public List<Product> getAllProducts();
    public Optional<Product> getProduct(Long id);
    public List<Product> getProductByName(String name);
    public List<Product> getProductsByCategory(String category);
    public List<Product> getProductsBySeller(String seller);
    public Product addProduct(Product product);
    public Product updateProduct(Long id,Product product);
    public void deleteProduct(Long id);

}
