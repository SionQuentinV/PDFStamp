package SION.PDFStamp.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GUI {

    public void startGUI() {
        // Creating frame (window)
        JFrame frame = new JFrame("PDFStamper");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create ContentPanel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Construct pdf selection component
        JPanel pdfPane = new JPanel();
        JButton PDFButton = new JButton("Choisir un PDF");
        PDFButton.setSize(50, 20);
        pdfPane.add(PDFButton);
        JLabel pdfText = new JLabel("Aucun fichier sélectionné...");
        pdfPane.add(pdfText);
        pdfPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        pdfPane.setMaximumSize(pdfPane.getPreferredSize());
        contentPanel.add(pdfPane);

        // Construct client selection component
        JPanel clientPane = new JPanel();

        JLabel clientLabel = new JLabel("Choisissez un client : ");
        clientPane.add(clientLabel);
        JComboBox<Clients> clientsComboBox = new JComboBox<Clients>(Clients.values());
        clientPane.add(clientsComboBox);
        clientPane.setMaximumSize(clientPane.getPreferredSize());
        clientPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(clientPane);

        PDFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PdfBrowser browser = new PdfBrowser();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Rendering UI
//        frame.add(contentPanel);
        frame.setContentPane(contentPanel);
        frame.setVisible(true);
    }
}
