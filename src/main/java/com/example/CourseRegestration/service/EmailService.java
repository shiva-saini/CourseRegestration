package com.example.CourseRegestration.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PdfGeneratorService pdfService;

    public void sendEnrollmentEmail(String to, Map<String,String> req) throws Exception {
        byte[] pdfBytes = pdfService.generateEnrollmentPdf(req);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Enrollment Confirmation - " + req.get("courseName"));
        helper.setText("Hello " + req.get("studentname") + ",\n\nPlease find attached your enrollment confirmation PDF.");

        helper.addAttachment("EnrollmentDetails.pdf", new ByteArrayResource(pdfBytes));
        mailSender.send(message);
    }
}
