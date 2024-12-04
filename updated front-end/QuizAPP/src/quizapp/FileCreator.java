/*
package quizapp;

import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import org.apache.poi.xslf.usermodel.XMLSlideShow;




public class FileCreator {


   public static void CreateDocx(int numFiles){
      String filePath = "D:/nonwhitespace/CSVData/PracticalOrignalFiles/DOCX/"; // Set the directory path
      String fileNamePrefix = ""; // Set the prefix for the file name
      

      for (int i = 1; i <= numFiles; i++) {
         String fileName = fileNamePrefix + i + ".docx"; // Set the file name with serial number
         try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream out = new FileOutputStream(filePath + fileName);
            document.write(out);
            out.close();
            System.out.println(fileName + " created successfully");
         } catch (Exception e) {
            System.out.println("Error creating " + fileName + ": " + e.getMessage());
         }
      }
   }

   public static void CreatXlxs(int numfiles){

      String directoryPath = "D:/nonwhitespace/CSVData/PracticalOrignalFiles/XLXS/"; // specify the directory path
        String fileNamePrefix = ""; // specify the prefix for file names
        String fileExtension = ".xlsx"; // specify the file extension


        // loop through 50 times to create 50 files
        for (int i = 1; i <= numfiles; i++) {
            String fileName = fileNamePrefix + i + fileExtension;
            String filePath = directoryPath + fileName;

            // create a new workbook and write to file
            XSSFWorkbook workbook = new XSSFWorkbook();
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
                System.out.println("Created file: " + filePath);
            } catch (IOException e) {
                System.err.println("Error creating file: " + filePath);
                e.printStackTrace();
            }
        }


   }

   public static void CreatePpt(int numfiles){

      String directoryPath = "D:/nonwhitespace/CSVData/PracticalOrignalFiles/PPTX/"; // specify the directory path
        String fileNamePrefix = ""; // specify the prefix for file names
        String fileExtension = ".pptx"; // specify the file extension

        // loop through 50 times to create 50 files
        for (int i = 1; i <= numfiles; i++) {
            String fileName = fileNamePrefix + i + fileExtension;
            String filePath = directoryPath + fileName;

            // create a new slideshow and write to file
            XMLSlideShow slideshow = new XMLSlideShow();
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                slideshow.write(outputStream);
                System.out.println("Created file: " + filePath);
            } catch (IOException e) {
                System.err.println("Error creating file: " + filePath);
                e.printStackTrace();
            }
        }

   }


    public static void main(String[] args){

      CreatePpt(50);
      

      
    }
    
}
*/
