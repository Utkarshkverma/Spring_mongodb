package com.vermau2k01.coding.mongodb_project.product;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CRUD operations
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(ObjectId id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(ObjectId id, Product product) {
        if (id == null) {
            throw new NullPointerException("Product ID cannot be null");
        }
        if (product == null) {
            throw new NullPointerException("Product cannot be null");
        }
        
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new NullPointerException("Product not found with ID " + id));
        
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
    
    
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(ObjectId id) {
        productRepository.deleteById(id);
    }
}