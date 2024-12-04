package quizapp;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CompareWordDocs {

    private static final Pattern PATTERN_WHITESPACE = Pattern.compile("\\s+");
    private static final Pattern PATTERN_NONBREAKING_SPACE = Pattern.compile("\u00a0");
    
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
        List<XWPFParagraph> paragraphs1 = doc1.getParagraphs();
        List<XWPFParagraph> paragraphs2 = doc2.getParagraphs();
        for (int i = 0; i < paragraphs1.size(); i++) {
            XWPFParagraph para1 = paragraphs1.get(i);
            XWPFParagraph para2 = paragraphs2.get(i);
            
            // Compare the text in the two paragraphs
            String text1 = getTextWithFormatting(para1);
            String text2 = getTextWithFormatting(para2);
            if (!text1.equals(text2)) {
                return false;
            }
        }
        
        // Close the documents
        doc1.close();
        doc2.close();
        
        // The two documents have the same content and formatting
        return true;
    }
    
    private static String getTextWithFormatting(XWPFParagraph para) {
        StringBuilder sb = new StringBuilder();
        
        List<XWPFRun> runs = para.getRuns();
        for (XWPFRun run : runs) {
            String text = run.getText(0);
            if (text != null) {
                // Strip out any whitespace and non-breaking spaces
                Matcher whitespaceMatcher = PATTERN_WHITESPACE.matcher(text);
                text = whitespaceMatcher.replaceAll("");
                Matcher nonbreakingSpaceMatcher = PATTERN_NONBREAKING_SPACE.matcher(text);
                text = nonbreakingSpaceMatcher.replaceAll("");
                
                // Append the text with its formatting
                sb.append(run.getCTR().xmlText());
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String file1 = "QuestionData/PracticalOrignalFiles/DOCX/1.docx"; // path to the first document
        String file2 = "QuestionData/PracticalOrignalFiles/DOCX/2.docx"; // path to the second document


        boolean check = compare(file1, file2);
        System.out.print(check);

    }
}
