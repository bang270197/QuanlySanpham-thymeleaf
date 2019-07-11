package com.codegym.Persistence;

import com.codegym.Model.Product;

import java.util.ArrayList;

public class ProductPersistenceImpl implements GeneralPersistence<Product> {
    ArrayList<Product> productArrayList=new ArrayList<>();
    {
        productArrayList.add(new Product(1,"iphone5","apple@gmail.com","American"));
        productArrayList.add(new Product(2,"iphone6s","apple@gmail.com","American"));
        productArrayList.add(new Product(3,"iphone6plus","apple@gmail.com","American"));
        productArrayList.add(new Product(4,"iphone7","apple@gmail.com","American"));
        productArrayList.add(new Product(5,"iphone8plus","apple@gmail.com","American"));
    }
    @Override
    public ArrayList<Product> showAll() {
        return productArrayList;
    }

    @Override
    public Product findById(Long id) {
        for (int i=0;i<productArrayList.size();i++){
            if (productArrayList.get(i).getId()==id)
            {
                return productArrayList.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> findByName(String name) {
        ArrayList<Product> products=new ArrayList<>();
        for (int i=0;i<productArrayList.size();i++){
            if (productArrayList.get(i).getName().equals(name)){
                products.add(productArrayList.get(i));
            }
        }
        return products;
    }

    @Override
    public void addProduct(Product product) {
             productArrayList.add(product);
    }

    @Override
    public void editProduct(Product product) {
           for (int i=0;i<productArrayList.size();i++){
               if (product.getId()==productArrayList.get(i).getId()){
                   productArrayList.set(i,product);
               }
           }
    }

    @Override
    public void deleteProduct(int id) {
        for (int i=0;i<productArrayList.size();i++){
            if (productArrayList.get(i).getId()==id){
                productArrayList.remove(i);
            }
        }
    }
}
