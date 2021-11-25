package SION.PDFStamp.main;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PDFStamp {

    public String getResourcePath(String path) throws IOException {
        String resourcesPath = "src/main/resources";
        File resourceFile = new File(resourcesPath + path);
        return resourceFile.getAbsolutePath();
    }

    public void addImageToPdf(String pdfInput, String imageInput, String outputFile) throws IOException {
        try(PDDocument doc = Loader.loadPDF(new File(getResourcePath(pdfInput)))){
            for(int i = 0; i < doc.getNumberOfPages(); i++){
                PDPage page = doc.getPage(i);
                PDImageXObject image = PDImageXObject.createFromFile(getResourcePath(imageInput), doc);
                try(PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, true)){
                    float scale = 1f;
                    contentStream.drawImage(image, page.getMediaBox().getWidth() / 4, 20, image.getWidth() * scale, image.getHeight() * scale);
                }
            }

//            doc.save(getResourcePath(outputFile));
        }
    }
}
