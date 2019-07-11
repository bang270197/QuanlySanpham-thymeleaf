package com.codegym.Persistence;

import java.util.ArrayList;

public interface GeneralPersistence<E> {
    ArrayList<E> showAll();

    E findById(Long id);

    ArrayList<E> findByName(String name);

    void addProduct(E e);

    void editProduct(E e);

    void deleteProduct(int id);
}
