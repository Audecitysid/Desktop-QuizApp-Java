/*

import java.io.*;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.microsoft.OfficeParser;
import org.apache.tika.sax.BodyContentHandler;

public class CompareWordDocs {
    public static void main(String[] args) {
        String file1 = "document1.doc"; // path to the first document
        String file2 = "document2.doc"; // path to the second document

        try {
            // parse the first document
            FileInputStream fis1 = new FileInputStream(file1);
            BodyContentHandler handler1 = new BodyContentHandler(-1);
            Metadata metadata1 = new Metadata();
            ParseContext context1 = new ParseContext();
            OfficeParser parser1 = new OfficeParser();
            parser1.parse(fis1, handler1, metadata1, context1);
            String text1 = handler1.toString();
            fis1.close();

            // parse the second document
            FileInputStream fis2 = new FileInputStream(file2);
            BodyContentHandler handler2 = new BodyContentHandler(-1);
            Metadata metadata2 = new Metadata();
            ParseContext context2 = new ParseContext();
            OfficeParser parser2 = new OfficeParser();
            parser2.parse(fis2, handler2, metadata2, context2);
            String text2 = handler2.toString();
            fis2.close();

            // compare the two documents
            if (text1.equals(text2)) {
                System.out.println("The two Word documents have identical contents and formatting.");
            } else {
                System.out.println("The two Word documents have different contents or formatting.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/