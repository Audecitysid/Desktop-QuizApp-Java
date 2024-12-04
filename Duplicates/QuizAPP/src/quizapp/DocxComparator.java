package quizapp;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class DocxComparator {
    public static void main(String[] args) throws IOException {
        String file1Path = "path/to/file1.docx";
        String file2Path = "path/to/file2.docx";

        boolean areEqual = compareDocxFiles(file1Path, file2Path);
        System.out.println("The files are " + (areEqual ? "equal" : "not equal") + ".");
    }

    public static boolean compareDocxFiles(String file1Path, String file2Path) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1Path);
             FileInputStream fis2 = new FileInputStream(file2Path)) {

            XWPFDocument doc1 = new XWPFDocument(fis1);
            XWPFDocument doc2 = new XWPFDocument(fis2);

            List<XWPFParagraph> paragraphs1 = doc1.getParagraphs();
            List<XWPFParagraph> paragraphs2 = doc2.getParagraphs();

            if (paragraphs1.size() != paragraphs2.size()) {
                return false;
            }

            for (int i = 0; i < paragraphs1.size(); i++) {
                XWPFParagraph paragraph1 = paragraphs1.get(i);
                XWPFParagraph paragraph2 = paragraphs2.get(i);

                if (!compareParagraphs(paragraph1, paragraph2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean compareParagraphs(XWPFParagraph paragraph1, XWPFParagraph paragraph2) {
        List<XWPFRun> runs1 = paragraph1.getRuns();
        List<XWPFRun> runs2 = paragraph2.getRuns();
    
        if (runs1.size() != runs2.size()) {
            return false;
        }
    
        for (int i = 0; i < runs1.size(); i++) {
            XWPFRun run1 = runs1.get(i);
            XWPFRun run2 = runs2.get(i);
    
            if (!compareRuns(run1, run2)) {
                return false;
            }
        }
    
        return paragraph1.getAlignment().equals(paragraph2.getAlignment()) &&
                paragraph1.getSpacingBetween() == paragraph2.getSpacingBetween() &&
                paragraph1.getSpacingAfter() == paragraph2.getSpacingAfter() &&
                paragraph1.getSpacingBefore() == paragraph2.getSpacingBefore() &&
                paragraph1.getIndentationLeft() == paragraph2.getIndentationLeft() &&
                paragraph1.getIndentationRight() == paragraph2.getIndentationRight() &&
                paragraph1.getIndentationFirstLine() == paragraph2.getIndentationFirstLine() &&
                paragraph1.isWordWrapped() == paragraph2.isWordWrapped() &&
                paragraph1.getNumIlvl() == paragraph2.getNumIlvl() &&
                paragraph1.getNumFmt() == paragraph2.getNumFmt();
    }

    private static boolean compareRuns(XWPFRun run1, XWPFRun run2) {
        return run1.text().equals(run2.text()) &&
                run1.isBold() == run2.isBold() &&
                run1.isItalic() == run2.isItalic() &&
                run1.isStrikeThrough() == run2.isStrikeThrough() &&
                run1.getFontSize() == run2.getFontSize() &&
                Objects.equals(run1.getSubscript(), run2.getSubscript()) &&
                Objects.equals(run1.getColor(), run2.getColor()) &&
                Objects.equals(run1.getFontFamily(), run2.getFontFamily()) &&
                Objects.equals(run1.getUnderline(), run2.getUnderline()) &&
                Objects.equals(run1.getStyle(), run2.getStyle()) &&
                run1.getCTR().isSetHighlight() == run2.getCTR().isSetHighlight() &&
                Objects.equals(run1.getCTR().getHighlight().getVal(), run2.getCTR().getHighlight().getVal());
    }
     
}


}