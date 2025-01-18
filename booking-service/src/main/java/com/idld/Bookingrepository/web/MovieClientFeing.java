package com.idld.Bookingrepository.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.idld.Bookingrepository.modele.Client;

@FeignClient(name = "client-service", url = "http://localhost:8080")  // Ensure the URL points to the correct service
public interface MovieClientFeing {

    @GetMapping("/clients/{id}")
    Client findById(@PathVariable Long id);  // Fetch client by ID

    @GetMapping("/clients")
    List<Client> findAll();  // Fetch all clients
}
