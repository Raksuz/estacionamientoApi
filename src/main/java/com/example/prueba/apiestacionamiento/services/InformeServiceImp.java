package com.example.prueba.apiestacionamiento.services;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.apiestacionamiento.repositories.InformeRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

@Service
public class InformeServiceImp implements InformeService {
    
    @Autowired
    private InformeRepository informeRepository;

    @Override
    public List<Object[]> obtenerDetalle() {
        return informeRepository.obtenerDetalle();
    }

    @Override
    public byte[] generarPDF(List<Object[]> datos) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outputStream));
                Document document = new Document(pdfDoc)) {
            Table table = new Table(datos.get(0).length);

            String[] encabezados = {"Num. Placa", "Tiempo estacionado (min.)", "Cantidad a pagar"};
            for (String encabezado : encabezados) {
                table.addHeaderCell(new Cell().add(new Paragraph(encabezado)));
            }
            for (int i = 0; i < datos.size(); i++) {
                for (int j = 0; j < datos.get(i).length; j++) {
                    table.addCell(new Cell().add(new Paragraph(datos.get(i)[j].toString())));
                }
            }
            document.add(table);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
