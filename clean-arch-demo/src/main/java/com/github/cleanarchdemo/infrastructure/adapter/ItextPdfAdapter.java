package com.github.cleanarchdemo.infrastructure.adapter;

import com.github.cleanarchdemo.application.contract.RegistrationPdfExporter;
import com.github.cleanarchdemo.domain.entity.Registration;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ItextPdfAdapter implements RegistrationPdfExporter {
    @Override
    public String generate(Registration registration) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("output.pdf"));
            doc.open();
            doc.add(new Paragraph(registration.getName()));
            doc.add(new Paragraph(registration.getRegistrationNumber().value()));
            doc.add(new Paragraph(registration.getEmail().value()));
            doc.close();
            return doc.toString();
        }
        catch (Exception ex){
            doc.close();
            return null;
        }
    }
}