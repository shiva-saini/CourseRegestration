package com.example.CourseRegestration.service;

import com.example.CourseRegestration.entity.Payment;
import com.example.CourseRegestration.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public String addPayment(Payment payment){
       Payment res =  paymentRepository.save(payment);
       return "Success";

    }

    public Payment findPaymentById(Integer id){
        Payment res = paymentRepository.findById(id).get();
        return res;
    }
}
