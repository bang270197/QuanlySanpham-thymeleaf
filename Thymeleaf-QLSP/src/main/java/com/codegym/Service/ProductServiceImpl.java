package com.codegym.Service;

import com.codegym.Model.Product;
import com.codegym.Persistence.ProductPersistenceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ProductServiceImpl implements GenerelService<Product> {

    @Autowired
    private ProductPersistenceImpl productPersistence;
    @Override
    public ArrayList<Product> showAll() {
        return productPersistence.showAll();
    }

    @Override
    public Product findById(Long id) {
        return productPersistence.findById(id);
    }

    @Override
    public ArrayList<Product> findByName(String name) {
        return productPersistence.findByName(name);
    }

    @Override
    public void addProduct(Product product) {
        productPersistence.addProduct(product);
    }

    @Override
    public void editProduct(Product product) {
       productPersistence.editProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
      productPersistence.deleteProduct(id);
    }
}
