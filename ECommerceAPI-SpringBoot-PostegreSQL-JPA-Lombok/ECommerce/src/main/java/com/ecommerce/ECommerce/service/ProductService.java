package com.ecommerce.ECommerce.service;


import com.ecommerce.ECommerce.entity.Product;
import com.ecommerce.ECommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {


    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProductByName(String name) {

        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {

        return productRepository.findByCategory(category);
    }
    public List<Product> getProductsBySeller(String seller) {

        return productRepository.findBySeller(seller);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Product getProduct = productRepository.findById(id).orElse(null);


        if (getProduct != null){


            getProduct.setName(product.getName());
            getProduct.setCategory(product.getCategory());
            getProduct.setPrice(product.getPrice());
            getProduct.setPiece(product.getPiece());
            getProduct.setSeller(product.getSeller());
            

            return productRepository.save(getProduct);

        }

        return null;
    }

    @Override
    public void deleteProduct(Long id){


        productRepository.deleteById(id);

    }
}