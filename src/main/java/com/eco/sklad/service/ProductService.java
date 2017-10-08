package com.eco.sklad.service;

import com.eco.sklad.domain.Product;
import com.eco.sklad.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;

    public List<Product> findAll(){
    return productRepo.findAll();
}

    @Transactional
    public void addProduct(Product product){

        System.out.println(product);
        productRepo.save(product);
    }

    public Product findOne (Integer id){

        return productRepo.findOne(id);
    }

    @Transactional
    public boolean delete(int id){
        productRepo.delete(id);
        return true;
    }
}
