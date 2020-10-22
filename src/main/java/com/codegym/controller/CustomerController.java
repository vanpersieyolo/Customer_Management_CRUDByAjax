package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.Customer.ICustomerService;
import com.codegym.service.Province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }


    @GetMapping("")
    public String home(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "home";
    }
    @GetMapping("/data")
    public ResponseEntity<Iterable<Customer>> customerResponseEntity(){
//        List list = (List)customerService.findAll();
//        System.out.println("------------------------------" + list.size());
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Iterable<Customer>> createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable Long id){
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Customer> searach(@PathVariable String name){
        customerService.findAllByNameContaining(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
