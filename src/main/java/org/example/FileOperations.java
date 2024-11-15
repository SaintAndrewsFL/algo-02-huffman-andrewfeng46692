package org.example;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import javax.swing.text.BadLocationException;


public class FileOperations {

    public static String readText(String textFile) {
        try {
            String desktopPath = System.getProperty("user.home") + "/Desktop/" + textFile;
            Path filePath = Paths.get(desktopPath);
            return Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readRTFText(String rtfFile) {
        try {
            String documentsPath = System.getProperty("user.home") + "/Documents/" + rtfFile;
            Path filePath = Paths.get(documentsPath);

            RTFEditorKit rtfEditorKit = new RTFEditorKit();
            Document document = new DefaultStyledDocument();

            try (InputStream inputStream = Files.newInputStream(filePath)) {
                rtfEditorKit.read(inputStream, document, 0);
            }

            return document.getText(0, document.getLength());

        } catch (IOException | BadLocationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeToFile(String text, String fileLocation) {
        try {
            Path filePath = Paths.get(fileLocation);
            Files.writeString(filePath, text);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

