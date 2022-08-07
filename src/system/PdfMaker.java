
package system;

import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document;  
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import values.Values;

public class PdfMaker {
    
    
    
    static String filePath = null;
    static String basePath = "src/pay_receipt/";
    static String directory = null;
    static PdfWriter pdfWritter ;
    static PdfDocument pdfDoc;
    static Document document;   
    
    
    
    private static String getPdfSavePath(){
        String myDocumentsDir = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        if(!new File(myDocumentsDir+"/TMS Payment Receipts").exists()){
            new File(myDocumentsDir+"/TMS Payment Receipts").mkdirs();
        }
        return myDocumentsDir+"/TMS Payment Receipts/";       
        
    }
 
    
    public static String makePayReceiptPdf(String rentMonth, String txnId,String tName,String aptName,String payDate,String rentAmount, String payAmount, String dueAmount) throws FileNotFoundException{
        
        filePath = getPdfSavePath()+txnId+"_pay_receipt_"+rentMonth.toLowerCase().replace('-', '_')+".pdf";
        
        pdfWritter = new PdfWriter(filePath);
        pdfDoc = new PdfDocument(pdfWritter);
        document = new Document(pdfDoc);
        
        
        pdfDoc.setDefaultPageSize(new PageSize(600,500));
        
        //Header//
        float colWidthTop[] = {200f,200f,200f};
        Table tableTop = new Table(colWidthTop);
        
        tableTop.setBackgroundColor(new DeviceRgb(255,0,0));
        
        Cell c1 = new Cell()
                .add(new Paragraph(rentMonth))
                .setBorder(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(255,255,255))
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setHorizontalAlignment(HorizontalAlignment.CENTER);
                
                      
                
        Cell c2 = new Cell()
                .add(new Paragraph("Payment Receipt"))                
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(18)
                .setBorder(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(255,255,255));
                 
                
                
                
        Cell c3 = new Cell()
                .add(new Paragraph("TXN ID: "+txnId))
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setFontColor(new DeviceRgb(255,255,255));   
        
        
        tableTop.addCell(c1);        tableTop.addCell(c2);        tableTop.addCell(c3);
              
        document.add(tableTop);
        
        
        
        float colWidthMid[] = {600f};
        Table tableMid = new Table(colWidthMid);
        tableMid.setMarginTop(50);
        
        Cell c4 = new Cell()
                .add(new Paragraph("Tenant Name\t\t\t:\t"+tName))
                .setBorder(Border.NO_BORDER)
                .setFontSize(14);
        
        Cell c5 = new Cell()
                .add(new Paragraph("Apartment \t\t\t\t:\t"+aptName))
                .setBorder(Border.NO_BORDER)
                .setFontSize(14);
        
        Cell c6 = new Cell()
                .add(new Paragraph("Payment Date   \t\t:\t"+payDate))
                .setBorder(Border.NO_BORDER)
                .setFontSize(14);
        
        
        tableMid.addCell(c4);   tableMid.addCell(c5);   tableMid.addCell(c6);
        
        document.add(tableMid);
        
        
        float colWidthAmount[] = {200,400}; 
        Table tableAmount = new Table(colWidthAmount);
        tableAmount.setMarginTop(30);
        
        
        Cell c7 = new Cell()
                .add(new Paragraph("Description"))
                .setTextAlignment(TextAlignment.CENTER)                
                .setFontColor(new DeviceRgb(255,255,255))
                .setBackgroundColor(new DeviceRgb(255,0,0))
                .setFontSize(14);
        
        Cell c8 = new Cell()
                .add(new Paragraph("Amount"))
                .setTextAlignment(TextAlignment.CENTER)                
                .setFontColor(new DeviceRgb(255,255,255))
                .setBackgroundColor(new DeviceRgb(255,0,0))
                .setFontSize(14);
        
        
        
        Cell c9 = new Cell()
                .add(new Paragraph("Rent"))
                .setTextAlignment(TextAlignment.CENTER)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c10 = new Cell()
                .add(new Paragraph(rentAmount))
                .setTextAlignment(TextAlignment.RIGHT)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c11 = new Cell()
                .add(new Paragraph("Paid"))
                .setTextAlignment(TextAlignment.CENTER)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c12 = new Cell()
                .add(new Paragraph(payAmount))
                .setTextAlignment(TextAlignment.RIGHT)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c13 = new Cell()
                .add(new Paragraph("Due"))
                .setTextAlignment(TextAlignment.CENTER)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c14 = new Cell()
                .add(new Paragraph(dueAmount))
                .setTextAlignment(TextAlignment.RIGHT)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        
        
        
        
        tableAmount.addCell(c7);    tableAmount.addCell(c8);  
        tableAmount.addCell(c9);    tableAmount.addCell(c10);
        tableAmount.addCell(c11);    tableAmount.addCell(c12);
        tableAmount.addCell(c13);    tableAmount.addCell(c14);
        
        
        tableAmount.setMarginBottom(30);
        document.add(tableAmount);
        
        
        
  
        
        
        
        float colWidthCred[] = {600f};
        Table tableCredit= new Table(colWidthCred);
        
        Cell c16 = new Cell()
                .add(new Paragraph(Values.APP_NAME))
                .setTextAlignment(TextAlignment.CENTER)             
                .setBorder(Border.NO_BORDER)
                .setFontSize(10);
        
        Cell c17 = new Cell()
                .add(new Paragraph(Values.APP_CREDIT))
                .setTextAlignment(TextAlignment.CENTER)             
                .setBorder(Border.NO_BORDER)
                .setFontSize(10);
        
        
        tableCredit.setMarginTop(20);
        
        tableCredit.addCell(c16);    tableCredit.addCell(c17);
        
        
        document.add(tableCredit);
        
        
        
        float colWidthTime[] = {600f};
        Table tableTime = new Table(colWidthTime);
        
        Cell c15 = new Cell()
                .add(new Paragraph(Time.getCurHourMinSec()+"-"+Time.getCurDayMonthYear()))
                .setTextAlignment(TextAlignment.RIGHT)             
                .setBorder(Border.NO_BORDER)
                .setFontSize(8);
        
        
        tableTime.addCell(c15);
        tableTime.setMarginTop(30);
        
        document.add(tableTime);
        
 
        
        document.close();
        
        return filePath;
  
        
    }
    
    
    
     public static String makeDuePayReceiptPdf(String rentMonth, String txnId,String tName,String aptName,String payDate,String rentAmount, String payAmount, String dueAmount) throws FileNotFoundException{
        
        filePath = getPdfSavePath()+txnId+"_due_pay_receipt_"+rentMonth.toLowerCase().replace('-', '_')+".pdf";
        
        pdfWritter = new PdfWriter(filePath);
        pdfDoc = new PdfDocument(pdfWritter);
        document = new Document(pdfDoc);
        
        
        pdfDoc.setDefaultPageSize(new PageSize(600,500));
        
        //Header//
        float colWidthTop[] = {200f,200f,200f};
        Table tableTop = new Table(colWidthTop);
        
        tableTop.setBackgroundColor(new DeviceRgb(255,0,0));
        
        Cell c1 = new Cell()
                .add(new Paragraph(rentMonth))
                .setBorder(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(255,255,255))
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setHorizontalAlignment(HorizontalAlignment.CENTER);
                
                      
                
        Cell c2 = new Cell()
                .add(new Paragraph("Due Payment Receipt"))                
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(18)
                .setBorder(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(255,255,255));
                 
                
                
                
        Cell c3 = new Cell()
                .add(new Paragraph("TXN ID: "+txnId))
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setFontColor(new DeviceRgb(255,255,255));   
        
        
        tableTop.addCell(c1);        tableTop.addCell(c2);        tableTop.addCell(c3);
              
        document.add(tableTop);
        
        
        
        float colWidthMid[] = {600f};
        Table tableMid = new Table(colWidthMid);
        tableMid.setMarginTop(50);
        
        Cell c4 = new Cell()
                .add(new Paragraph("Tenant Name\t\t\t:\t"+tName))
                .setBorder(Border.NO_BORDER)
                .setFontSize(14);
        
        Cell c5 = new Cell()
                .add(new Paragraph("Apartment \t\t\t\t:\t"+aptName))
                .setBorder(Border.NO_BORDER)
                .setFontSize(14);
        
        Cell c6 = new Cell()
                .add(new Paragraph("Payment Date   \t\t:\t"+payDate))
                .setBorder(Border.NO_BORDER)
                .setFontSize(14);
        
        
        tableMid.addCell(c4);   tableMid.addCell(c5);   tableMid.addCell(c6);
        
        document.add(tableMid);
        
        
        float colWidthAmount[] = {200,400}; 
        Table tableAmount = new Table(colWidthAmount);
        tableAmount.setMarginTop(30);
        
        
        Cell c7 = new Cell()
                .add(new Paragraph("Description"))
                .setTextAlignment(TextAlignment.CENTER)                
                .setFontColor(new DeviceRgb(255,255,255))
                .setBackgroundColor(new DeviceRgb(255,0,0))
                .setFontSize(14);
        
        Cell c8 = new Cell()
                .add(new Paragraph("Amount"))
                .setTextAlignment(TextAlignment.CENTER)                
                .setFontColor(new DeviceRgb(255,255,255))
                .setBackgroundColor(new DeviceRgb(255,0,0))
                .setFontSize(14);
        
        
        
        Cell c9 = new Cell()
                .add(new Paragraph("Due"))
                .setTextAlignment(TextAlignment.CENTER)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c10 = new Cell()
                .add(new Paragraph(rentAmount))
                .setTextAlignment(TextAlignment.RIGHT)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c11 = new Cell()
                .add(new Paragraph("Paid"))
                .setTextAlignment(TextAlignment.CENTER)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c12 = new Cell()
                .add(new Paragraph(payAmount))
                .setTextAlignment(TextAlignment.RIGHT)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c13 = new Cell()
                .add(new Paragraph("New Due"))
                .setTextAlignment(TextAlignment.CENTER)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        Cell c14 = new Cell()
                .add(new Paragraph(dueAmount))
                .setTextAlignment(TextAlignment.RIGHT)              
                .setBackgroundColor(new DeviceRgb(238,238,238))
                .setFontSize(14);
        
        
        
        
        
        tableAmount.addCell(c7);    tableAmount.addCell(c8);  
        tableAmount.addCell(c9);    tableAmount.addCell(c10);
        tableAmount.addCell(c11);    tableAmount.addCell(c12);
        tableAmount.addCell(c13);    tableAmount.addCell(c14);
        
        
        tableAmount.setMarginBottom(30);
        document.add(tableAmount);
        
        
        
  
        
        
        
        float colWidthCred[] = {600f};
        Table tableCredit= new Table(colWidthCred);
        
        Cell c16 = new Cell()
                .add(new Paragraph(Values.APP_NAME))
                .setTextAlignment(TextAlignment.CENTER)             
                .setBorder(Border.NO_BORDER)
                .setFontSize(10);
        
        Cell c17 = new Cell()
                .add(new Paragraph(Values.APP_CREDIT))
                .setTextAlignment(TextAlignment.CENTER)             
                .setBorder(Border.NO_BORDER)
                .setFontSize(10);
        
        
        tableCredit.setMarginTop(20);
        
        tableCredit.addCell(c16);    tableCredit.addCell(c17);
        
        
        document.add(tableCredit);
        
        
        
        float colWidthTime[] = {600f};
        Table tableTime = new Table(colWidthTime);
        
        Cell c15 = new Cell()
                .add(new Paragraph(Time.getCurHourMinSec()+"-"+Time.getCurDayMonthYear()))
                .setTextAlignment(TextAlignment.RIGHT)             
                .setBorder(Border.NO_BORDER)
                .setFontSize(8);
        
        
        tableTime.addCell(c15);
        tableTime.setMarginTop(30);
        
        document.add(tableTime);
        
 
        
        document.close();
        
        return filePath;
  
        
    }
    
    
    
    
    
    
    
    
    
    
}
