

package tatosport;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.testng.reporters.jq.Main;

public class PdfCreador {
    
    
    private File ruta_destino=null;
    private PdfPTable tabla = null;
    private static final Font fontBold = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
    private static final Font fontNormal = new Font(Font.FontFamily.COURIER, 11, Font.NORMAL);
    private Document documento;
    private ArrayList ListaEncabezados;
    private ArrayList ListaPiePagina;    
    
    public PdfCreador()
    {
          ListaEncabezados = new ArrayList();
          ListaPiePagina = new ArrayList();
    }
    
     public void SetArregloDatosToPdf(String[][] arreglo , String[] columnas ) throws DocumentException
     {
          int dim = columnas.length;
          int i=0;
          if(dim !=0){
              try {
                  tabla = this.getTabla(dim);
                  for(i =0; i < columnas.length ;i++)
                      tabla.addCell(this.getCell(columnas[i].toString()));
                 
                  for( i=0;i< arreglo.length;i++){
                    for(int j=0;j<arreglo[0].length;j++){
                        if(arreglo[i][j]!=null){
                        tabla.addCell(getCell(arreglo[i][j]));
                        }
                    }
                  }
              } catch (IOException ex) {
                  Logger.getLogger(PdfCreador.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
     }
     
      public void SetDatosEncabezado(ArrayList datos)
      {
          this.ListaEncabezados = datos;
      }
      
      
      public void SetDatosPiedePagina(ArrayList datos)
      {
          this.ListaPiePagina = datos;
      }
      
      
        public void Crear_PDF(String titulo, String autor, String asunto, String clave , String dato){

        Colocar_Destino();

        if(this.ruta_destino!=null){
            try {
               
                documento = getDocument();
                PdfWriter.getInstance(documento, new FileOutputStream(this.ruta_destino + ".pdf"));
                documento.open();
                documento.addTitle(titulo); 
                documento.addAuthor(autor); 
                documento.addSubject(asunto); 
                documento.addKeywords(clave); 
                
                if(dato == "" || dato == null){
                    
                    if(this.ListaEncabezados.size() >=1)
                    {
                        for(int i =0 ; i < this.ListaEncabezados.size();i++)
                            documento.add(this.getInformationFooter(this.ListaEncabezados.get(i).toString()));
                    }
                    
                    documento.add(tabla);

                    if(this.ListaPiePagina.size() >=1)
                    {
                        for(int i =0 ; i < this.ListaPiePagina.size();i++)
                            documento.add(this.getInformationFooter(this.ListaPiePagina.get(i).toString()));
                    }
                }
                else 
                   documento.add(new Paragraph(dato));  
                
                documento.close(); 
                
                
            } catch (    DocumentException | FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }        
    }
          
    public void Imprimir(){
     Desktop d=Desktop.getDesktop();
     try {
            if(Desktop.isDesktopSupported())
                d.print(new File(this.ruta_destino + ".pdf"));
     }
     catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     
     private float getConvertCmsToPoints(float cm) {
        return cm * 28.4527559067f;
     }
       
       private Document getDocument(){
        Document document = new Document(new Rectangle( getConvertCmsToPoints(21.5f), getConvertCmsToPoints(27.94f)));
       document.setMargins(0, 0, 1, 1);
       return document;
     }
       
      
     private String getCurrentDateTime() {
      Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yy '-' hh:mm");
      return ft.format(dNow);
       }
     
      private PdfPTable getTabla(int dimension) throws DocumentException {
        PdfPTable table = new PdfPTable(dimension);
        int[] anchuras = new int[dimension];
        for(int i=0 ; i < dimension ; i++)
            anchuras[i] = 10;
        table.setWidths(anchuras);
        return table;
     }
      
      private PdfPCell getCell(String text) throws DocumentException, IOException {
      Chunk chunk = new Chunk();
      chunk.append(text);
      chunk.setFont(fontNormal);
      PdfPCell cell = new PdfPCell(new Paragraph(chunk));
      cell.setHorizontalAlignment(Element.ALIGN_LEFT);
      cell.setBorder(Rectangle.BOX);
        return cell;
     } 
    
    private void Colocar_Destino(){
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf","PDF");
       JFileChooser fileChooser = new JFileChooser();       
       fileChooser.setFileFilter(filter);
       int result = fileChooser.showSaveDialog(null);
       if ( result == JFileChooser.APPROVE_OPTION ){   
           this.ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
    }   
    
  
       private Paragraph getHeader(String header) {
            Paragraph paragraph = new Paragraph();
            Chunk chunk = new Chunk();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            chunk.append( header + getCurrentDateTime() + "\n");
            chunk.setFont(fontBold);
            paragraph.add(chunk);
            return paragraph;
       }
     
     private Paragraph getInformation(String informacion) {
            Paragraph paragraph = new Paragraph();
            Chunk chunk = new Chunk();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            chunk.append(informacion);
            chunk.setFont(fontNormal);
            paragraph.add(chunk);
             return paragraph;
      }
     
     private Paragraph getInformationFooter(String informacion) {
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk();
        paragraph.setAlignment(Element.ALIGN_CENTER);
        chunk.append(informacion);
        chunk.setFont(new Font(Font.FontFamily.COURIER, 8, Font.NORMAL));
        paragraph.add(chunk);
        return paragraph;
       }
  
}
