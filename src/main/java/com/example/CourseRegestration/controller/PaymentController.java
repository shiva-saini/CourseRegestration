package com.example.CourseRegestration.controller;

import com.example.CourseRegestration.entity.Payment;
import com.example.CourseRegestration.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments") //
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPayment(@RequestBody Payment payment){
        String res = paymentService.addPayment(payment);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public Payment findPaymentById(@RequestParam("id") Integer id){
        Payment payment = paymentService.findPaymentById(id);
        return payment;
    }
}
