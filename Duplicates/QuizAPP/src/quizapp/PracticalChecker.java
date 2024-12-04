package quizapp;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.util.List;



public class PracticalChecker {

    // 1.Apply bold to Second sentence
    public static boolean ID1() {

        boolean isBold = false;;

        try (FileInputStream fis = new FileInputStream("QuestionData/PracticalDuplicates/DOCX/1.docx")) {
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            if (paragraphs.size() >= 2) {
                XWPFParagraph secondParagraph = paragraphs.get(1);
                isBold = secondParagraph.getRuns().stream()
                        .anyMatch(run -> run.isBold());

                //System.out.println("Is the second sentence bold? " + isBold);
            } else {
                //System.out.println("The document does not have a second sentence.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       return isBold;
    }

    //Apply bold and underline to 5th sentence
    public static boolean ID2(){

        boolean isBoldAndUnderlined = false;

        try (FileInputStream fis = new FileInputStream("QuestionData/PracticalDuplicates/DOCX/1.docx")) {
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            if (paragraphs.size() >= 5) {
                XWPFParagraph fifthParagraph = paragraphs.get(4);
                isBoldAndUnderlined = fifthParagraph.getRuns().stream()
                        .anyMatch(run -> run.isBold() && run.getUnderline() != UnderlinePatterns.NONE);

                System.out.println("Is the fifth sentence bold and underlined? " + isBoldAndUnderlined);
            } else {
                System.out.println("The document does not have a fifth sentence.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isBoldAndUnderlined;
    }


    public static boolean ID3(){

        boolean iscorrect = false;

        try (FileInputStream fis = new FileInputStream("QuestionData/PracticalDuplicates/DOCX/3.docx")) {
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            if (paragraphs.size() >= 5) {
                XWPFParagraph fifthParagraph = paragraphs.get(4);
                boolean isBoldAndStrikeThrough = fifthParagraph.getRuns().stream()
                        .anyMatch(run -> run.isBold() && run.isStrikeThrough());

                        iscorrect = isBoldAndStrikeThrough;
                System.out.println("Is the fifth sentence bold and has strikethrough? " + isBoldAndStrikeThrough);
            } else {
                System.out.println("The document does not have a fifth sentence.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return iscorrect;
    }

    

    public static void main(String[] args) {


        System.out.println(ID3());


        
    }

    
}

