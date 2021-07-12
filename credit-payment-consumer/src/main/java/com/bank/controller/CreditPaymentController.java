package com.bank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bank.model.CreditPayment;
import com.bank.service.CreditPaymentService;

@RestController
@RequestMapping("/rest/payment")
public class CreditPaymentController {


	 @Autowired
     private CreditPaymentService service;
   // private UserRepository userRepository;
	 private static final String dateFormat = "dd-MM-yyyy";
	 
    @GetMapping("/add/{id}/{amount}")
    public CreditPayment addPayment(@PathVariable("id") final String id, @PathVariable("amount") final Double amount) {
     service.save(new CreditPayment(id, amount, "pago1"));
     return service.findById(id);
    }

    @GetMapping("/update/{id}/{amount}")
    public CreditPayment updatePayment(@PathVariable("id") final String id,@PathVariable("amount") final Double amount) {
    service.update(new CreditPayment(id, amount, "pago2"));
    return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, CreditPayment> deletePayment(@PathVariable("id") final String id) {
    	service.delete(id);
        return allPayment();
    }

    @GetMapping("/all")
    public Map<String, CreditPayment> allPayment() {
        return service.findAll();
    }
	
	
}
