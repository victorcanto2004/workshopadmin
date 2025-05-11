/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;

/**
 *
 * @author alfon
 */
public class Carnet {
  private Document documento;
    private PdfWriter writer;
    private PdfContentByte cb;

    private final int carnetWidth = 252;
    private final int carnetHeight = 144;
    private final int marginX = 20;
    private final int marginY = 20;  //Margenes del carnet
    private final int spacingX = 10;
    private final int spacingY = 10;

    private final int columns = 2;
    private final int rows = 4;

    private int counter = 0; //CONTADOR DE CARNETS GENERADOS
 
    private FileOutputStream fos;
    private File archivoPDF;

    public Carnet() throws Exception {
         // Obtener la ruta de Descargas
    String userHome = System.getProperty("user.home");
    String filePath = userHome + "/Downloads/Gafetes.pdf";
    
    archivoPDF = new File(filePath);
    fos = new FileOutputStream(archivoPDF);

    // Crear el documento y configurar la escritura en la ruta de Descargas
    documento = new Document(PageSize.LETTER);
    writer = PdfWriter.getInstance(documento, new FileOutputStream(filePath)); // Guarda en Descargas
    documento.open();
    cb = writer.getDirectContent();
    }

    public void agregarCarnet(String matricula, String nombres, String apellidos, String tutor, String contacto,  JTable jTableTalleresGrupos) throws Exception {
        if (counter != 0 && counter % (columns * rows) == 0) {
            documento.newPage(); // Genera una nueva página cada 8 carnets
        }

        int col = counter % columns;
        int row = (counter % (columns * rows)) / columns;

        float x = marginX + col * (carnetWidth + spacingX);
        float y = documento.getPageSize().getHeight() - marginY - (row + 1) * (carnetHeight + spacingY);

        PdfTemplate template = cb.createTemplate(carnetWidth, carnetHeight);

        // Fondo del carnet
        Image fondo = Image.getInstance("src/workshopadmin/Imagenes/fondo.jpg");
        fondo.scaleAbsolute(carnetWidth, carnetHeight);
        fondo.setAbsolutePosition(0, 0);
        template.addImage(fondo);

        // Título
        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        ColumnText.showTextAligned(template, Element.ALIGN_CENTER,
                new Phrase("Centro Cultural Green Nekk'", fontTitulo),
                carnetWidth / 2, carnetHeight - 20, 0);

        // Datos personales (2 columnas)
            Font fontTexto = new Font(Font.FontFamily.HELVETICA, 8);

            // Columna izquierda (matrícula y nombre)
            ColumnText ctIzq = new ColumnText(template);
            ctIzq.setSimpleColumn(20, 55, carnetWidth / 2 - 5, carnetHeight - 40);
            ctIzq.addElement(new Paragraph("Matrícula: " + matricula, fontTexto)); //AGREGA DATOS
            ctIzq.addElement(new Paragraph("Nombre: " + nombres, fontTexto));
            ctIzq.go();

            // Columna derecha (apellido, tutor, contacto)
            ColumnText ctDer = new ColumnText(template);
            ctDer.setSimpleColumn(carnetWidth / 2 + 5, 55, carnetWidth - 20, carnetHeight - 40);
            ctDer.addElement(new Paragraph("Apellido: " + apellidos, fontTexto));
            ctDer.addElement(new Paragraph("Tutor: " + tutor, fontTexto)); //AGREGA DATOS
            ctDer.addElement(new Paragraph("Contacto: " + contacto, fontTexto));
            ctDer.go();
            
            // Crear la tabla desde JTable
            PdfPTable tablaPDF = crearTablaDesdeJTable(jTableTalleresGrupos);
            tablaPDF.setTotalWidth(carnetWidth - 40);
            tablaPDF.setLockedWidth(true);
            tablaPDF.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Posición de la tabla 
            float tablaX = 20;
            float tablaY = 60; 
            tablaPDF.writeSelectedRows(0, -1, tablaX, tablaY, template);
        cb.addTemplate(template, x, y);
        counter++;
    }
    
    public PdfPTable crearTablaDesdeJTable(JTable jTable) {
    PdfPTable table = new PdfPTable(jTable.getColumnCount());
    table.setWidthPercentage(100);

    Font fontCabecera = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
    Font fontCelda = new Font(Font.FontFamily.HELVETICA, 8); //FUENTE DE LA TABLA

    // Agrega encabezados
    for (int i = 0; i < jTable.getColumnCount(); i++) {
        PdfPCell header = new PdfPCell(new Phrase(jTable.getColumnName(i), fontCabecera));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.setPadding(3f); // Menor padding
        table.addCell(header);
    }

    // Agrega filas
    for (int row = 0; row < jTable.getRowCount(); row++) {
        for (int col = 0; col < jTable.getColumnCount(); col++) {
            Object value = jTable.getValueAt(row, col);
            PdfPCell cell = new PdfPCell(new Phrase(value != null ? value.toString() : "", fontCelda));
            cell.setPadding(2f); // Menor padding
            table.addCell(cell);
        }
    }

    return table;
}

    public void cerrarDocumento() {
    try {
        if (documento != null && documento.isOpen()) {
            documento.close();
        }
        if (fos != null) {
            fos.close();
        }
        // Abrir el archivo automáticamente
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(archivoPDF);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }   
}
