package com.example.CourseRegestration.service;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Map;

@Service
public class PdfGeneratorService {

    public byte[] generateEnrollmentPdf(Map<String, String> data) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("Enrollment Confirmation", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Student Name: " + data.get("studentName")));
        document.add(new Paragraph("Instructor Name: " + data.get("instructorName")));
        document.add(new Paragraph("Institution Name: " + data.get("institutionName")));
        document.add(new Paragraph("Enrollment Date: " + data.get("enrollmentDate")));

        document.add(new Paragraph(" "));
        document.add(new Paragraph("Course Details:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
        document.add(new Paragraph("Course Name: " + data.get("courseTitle")));
        document.add(new Paragraph("Duration: " + data.get("courseDescription")));
        document.add(new Paragraph("Description: " + data.get("coursePrice")));
        document.add(new Paragraph("StartDate: " + data.get("courseStartDate")));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Payment Details:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
        document.add(new Paragraph("Receiver Name: " + data.get("receiverName")));
        document.add(new Paragraph("Receiver Bank: " + data.get("receiverBank")));
        document.add(new Paragraph("Sender Name: " + data.get("senderName")));
        document.add(new Paragraph("Sender Bank: " + data.get("senderBank")));
        document.add(new Paragraph("Payment Mode: " + data.get("paymentMod")));
        document.add(new Paragraph("Transaction Date and Time: " + data.get("dateAndTime")));
        document.add(new Paragraph("Amount Paid: ₹" + data.get("amount")));

        document.close();
        return out.toByteArray();
    }
}

