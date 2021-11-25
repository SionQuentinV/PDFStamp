package SION.PDFStamp.Models;

import java.io.File;

public class PDFFile {

    private String filename;

    public PDFFile(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
