package com.example.clients;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DemoController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String name, @RequestParam String surname, @RequestParam String adres, @RequestParam String mail
            , @RequestParam String phone, @RequestParam String info) {
        Person client = new Person();
        client.setName(name);
        client.setSurname(surname);
        client.setAdres(adres);
        client.setEmail(mail);
        client.setPhone(phone);
        client.setInformation(info);
        personRepository.save(client);
        return "Added new client to repo!";
    }

    @GetMapping("/list")
    public Iterable<Person> getCustomers() {
        return personRepository.findAll();
    }


    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        personRepository.deleteById(id);
        return "Client deleted";
    }

    @GetMapping("/find/{id}")
    public Optional<Person> findById(@PathVariable Long id) {
        return personRepository.findById(id);
    }
}
