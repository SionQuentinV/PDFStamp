package SION.PDFStamp.main;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        PDFStamp app = new PDFStamp();
        app.addImageToPdf("/PDF/pdfSample.pdf", "/Stamp/tamponClassique.png", "/Output/out.pdf");
        GUI gui = new GUI();
        gui.startGUI();
    }
}
