package com.vermau2k01.coding.mongodb_project.product;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    /**
     * Create a new product
     * 
     * @param product the product to create
     * @return the created product
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    
    /**
     * Get all products
     * 
     * @return a list of all products
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    /**
     * Get a product by ID
     * 
     * @param id the ID of the product to retrieve
     * @return the product with the specified ID
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable ObjectId id) {
        return productService.getProductById(id);
    }
    
    /**
     * Update a product
     * 
     * @param id the ID of the product to update
     * @param product the updated product information
     * @return the updated product
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable ObjectId id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
    
    /**
     * Delete a product
     * 
     * @param id the ID of the product to delete
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable ObjectId id) {
        productService.deleteProduct(id);
    }
}
