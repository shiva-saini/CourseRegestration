package com.example.CourseRegestration.service;

import com.example.CourseRegestration.entity.*;
import com.example.CourseRegestration.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final InstitutionRepository institutionRepository;
    private final MentorRepository mentorRepository;
    private final EmailService emailService;

    private final PaymentRepository paymentRepository;
    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository,UserRepository userRepository,CourseRepository courseRepository,
                             InstitutionRepository institutionRepository,
                             MentorRepository mentorRepository,
                             PaymentRepository paymentRepository,
                             EmailService emailService


    ){
        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.institutionRepository = institutionRepository;
        this.mentorRepository = mentorRepository;
        this.paymentRepository = paymentRepository;
        this.emailService = emailService;

    }

    public String enrollUserInToCourse(Enrollment enrollment) throws Exception {
        User user = userRepository.findById(enrollment.getUser_id()).get();
        if(user == null){
            throw new Exception("User not found!");
        }

        Course course = courseRepository.findById(enrollment.getCourse_id()).get();

        if(course == null){
            throw new Exception("Course not found!");
        }

        Institution institution = institutionRepository.findById(enrollment.getInstitution_id()).get();

        if(institution == null){
            throw new Exception("Institution not found!");
        }

        Mentor mentor = mentorRepository.findById(enrollment.getMentorId()).get();

        if(mentor == null){
            throw new Exception("Mentor not found!");
        }

        Payment payment = new Payment();
        payment.setReceiverName(institution.getOwner());
        payment.setReceiverBank("1324354657687980");
        payment.setSenderName(user.getName());
        payment.setSenderBank("7566847564633333");
        payment.setPrice(course.getPrice());
        payment.setDateAndTime(LocalDateTime.now());
        payment.setTransactionMode("GPay");

        Payment saved = paymentRepository.save(payment);
        //add payment id and enrollment after successfull payment
        enrollment.setPaymentId(saved.getId());
        enrollment.setPaymentStatus(true);
        enrollment.setEnrollmentDate(LocalDateTime.now());

        //saving the enrollment details
        enrollmentRepository.save(enrollment);

        // send mail notification to user with all the details
        //create map with below data
        Map<String,String> req = new HashMap<>();
        req.put("studentName",user.getName());
        req.put("instructorName",mentor.getName());
        req.put("institutionName",institution.getName());
        req.put("enrollmentDate",enrollment.getEnrollmentDate().toString());
        req.put("courseTitle",course.getTitle());
        req.put("courseDescription",course.getDescription());
        req.put("coursePrice", course.getPrice().toString());
        req.put("courseStartDate",course.getStartDate().toString());
        req.put("receiverName",payment.getReceiverName());
        req.put("receiverBank",payment.getReceiverBank());
        req.put("senderName",payment.getSenderName());
        req.put("senderBank",payment.getSenderBank());
        req.put("paymentMod",payment.getTransactionMode());
        req.put("dateAndTime",payment.getDateAndTime().toString());
        req.put("amount",payment.getPrice().toString());

        emailService.sendEnrollmentEmail("shivasainisiyana2211@gmail.com",req);

        return "Enrollment successfull!";

    }
}
