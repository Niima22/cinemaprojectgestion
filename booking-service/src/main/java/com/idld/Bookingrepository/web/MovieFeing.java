package com.idld.Bookingrepository.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.idld.Bookingrepository.modele.Produit;

@FeignClient(name = "product-service", url = "http://localhost:8081")  // Ensure the URL points to the correct service
public interface MovieFeing {

    @GetMapping("/produits/{id}")
    Produit findById(@PathVariable Long id);  // Fetch product by ID (in this case, Movie)

    @GetMapping("/produits")
    List<Produit> findAll();  // Fetch all products (Movies)
}
