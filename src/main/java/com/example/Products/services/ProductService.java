package com.example.Products.services;

import com.example.Products.entitys.Product;
import com.example.Products.exceptions.ResourceNotFoundException;
import com.example.Products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


   public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto com o ID" + id + " não encontrado"));
        return existingProduct;
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com ID " + id + " não encontrado"));


        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getDescription() != null) {
            existingProduct.setDescription(product.getDescription());
        }

        return productRepository.save(existingProduct);
    }


    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto com o ID" + id + " não encontrado"));
        productRepository.delete(existingProduct);
    }


}
