package SION.PDFStamp.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class PdfBrowser extends JFrame {
    public Stream<Path> listPDF() throws IOException {
        String resourcesPath = "src/main/resources";
        return Files.list(new File(resourcesPath + "/PDF").toPath());
    }

    public PdfBrowser() throws IOException {
//        Setup frame
        this.setTitle("Choisissez un fichier");

//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Stream<Path> pdfFiles = listPDF();
//        Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        DefaultListModel<Path> list = new DefaultListModel();
        pdfFiles.forEach(path -> {
            list.addElement(path.getFileName());
        });

        JList<Path> pdfList = new JList<Path>(list);
        pdfList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contentPanel.add(pdfList);


        JButton submitButton = new JButton("Choisir");
        submitButton.setSize(submitButton.getPreferredSize());

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(pdfList.getSelectedIndex());
            }
        });

        contentPanel.add(submitButton);


        this.add(contentPanel);
        this.setSize(800,600);
        this.setVisible(true);
    }
}
