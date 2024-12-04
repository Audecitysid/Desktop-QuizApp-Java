package quizapp;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Compare {


    public static boolean compare(String file1, String file2) throws IOException {
        // Open the first file
        XWPFDocument doc1 = new XWPFDocument(new FileInputStream(file1));
        
        // Open the second file
        XWPFDocument doc2 = new XWPFDocument(new FileInputStream(file2));
        
        // Compare the number of paragraphs in the two documents
        if (doc1.getParagraphs().size() != doc2.getParagraphs().size()) {
            return false;
        }
        
        // Compare each paragraph in the two documents
        for (int i = 0; i < doc1.getParagraphs().size(); i++) {
            XWPFParagraph para1 = doc1.getParagraphs().get(i);
            XWPFParagraph para2 = doc2.getParagraphs().get(i);
            
            // Compare the XML of the two paragraphs
            String xml1 = para1.getCTP().xmlText();
            String xml2 = para2.getCTP().xmlText();
            if (!xml1.equals(xml2)) {
                return false;
            }
            
            // Compare the XML of each run in the two paragraphs
            for (int j = 0; j < para1.getRuns().size(); j++) {
                XWPFRun run1 = para1.getRuns().get(j);
                XWPFRun run2 = para2.getRuns().get(j);
                
                // Compare the XML of the two runs
                String runXml1 = run1.getCTR().xmlText();
                String runXml2 = run2.getCTR().xmlText();
                if (!runXml1.equals(runXml2)) {
                    return false;
                }
            }
        }
        
        // Close the documents
        IOUtils.closeQuietly(doc1);
        IOUtils.closeQuietly(doc2);
        
        // The two documents have the same content and formatting
        return true;
    }

    public static void main(String [] args) throws IOException{

        String file1 = "QuestionData/PracticalOrignalFiles/DOCX/1.docx"; // path to the first document
        String file2 = "QuestionData/PracticalOrignalFiles/DOCX/2.docx"; // path to the second document


        boolean check = compare(file1, file2);
        System.out.print(check);
    }
    
}
