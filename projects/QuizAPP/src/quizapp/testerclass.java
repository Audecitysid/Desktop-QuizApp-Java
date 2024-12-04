package quizapp;
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;




public class testerclass {



    // public static variables for Theory Questions

    public static String path = "";
    public static int totalnumberofquestions = 150;                    // the total number of questions in the csv
    public static int numberofrows = totalnumberofquestions + 1;


    public static int numberofdisplayquestions = 30;              // for a particular quiz
    public static int numberofcolumns = 9;

     


// public static variables for Practical Questions

    public static String practical_path = "";
    public static int practical_totalnumberofquestions = 150;                    // the total number of questions in the csv
    public static int practical_numberofrows = practical_totalnumberofquestions + 1;


    public static int practical_numberofdisplayquestions = 30;              // for a particular practical quiz
    public static int practical_numberofcolumns = 3;

    public static String[][] practical_displayquestions = new String[practical_numberofdisplayquestions][practical_numberofcolumns];




    public static String[][][][] ExamPracticalQuestions(int NumberOfQuestions){

        String [][][][] ExamPracticalQuestions = new String [6][3][practical_numberofrows + 2][practical_numberofcolumns + 1];
        numberofdisplayquestions = NumberOfQuestions;

        for(int indexofsection = 0; indexofsection < 6; indexofsection++){
        System.out.println("Section : " + indexofsection);

        switch (indexofsection) {
            case 0:
            practical_path = "QuestionData/PracticalQuestions/WordQuestions.csv";
            break;
            case 1:
            practical_path = "QuestionData/PracticalQuestions/ExcelQuestions.csv";
              break;
            case 2:
            practical_path = "QuestionData/PracticalQuestions/PowerpointQuestions.csv";
              break;
            case 3:
            practical_path = "QuestionData/PracticalQuestions/OutlookQuestions.csv";
              break;
            case 4:
            practical_path = "QuestionData/PracticalQuestions/WindowsQuestions.csv";
              break;
            case 5:
            practical_path = "QuestionData/PracticalQuestions/InternetQuestions.csv";
              break;

            default :
              practical_path = "QuestionData/PracticalQuestions/WordQuestions.csv";
          }


        System.out.println("File reading");

        
        String line = "";
        int rowcount = 0;
        int columncount = 0;
        String[][] questionsarray = null;
        
        try{
            BufferedReader objbuffer = new BufferedReader(new FileReader(practical_path));
            
                System.out.println(line);
                questionsarray = new String[practical_numberofrows + 2][practical_numberofcolumns + 1];  // specifications of the array
                objbuffer.close();

                objbuffer = new BufferedReader(new FileReader(practical_path)); 

                while((line = objbuffer.readLine()) != null && rowcount < practical_numberofrows){

                    String[] row = line.split(",");          // this is helping the row to have each comma seperated value to get stored in individual cell of array

                    for( columncount = 0; columncount < row.length; columncount++){

                        questionsarray[rowcount][columncount] = row[columncount];          // exact position of entering the data in array

                    }
                        
                    rowcount++;
                    
                }


        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found Exception");
        } catch(IOException e){
            e.printStackTrace();
        }
        // print the data in array------------------------------------ used to debug
        /*
        for(int r = 0; r < practical_numberofrows; r++){

            for(int c = 0; c < practical_numberofcolumns;c++){

                System.out.print(questionsarray[r][c] + "\t");
            }
            System.out.println();
        }
        */


        for(int indexoflevel = 0; indexoflevel < 3; indexoflevel++){
            System.out.println("Level : " + indexoflevel);

            int min = 0, max = 0;

        if(indexoflevel == 0){

            min = 1;
            max = 50;

        }else if(indexoflevel == 1){

            min = 51;
            max = 100;
            
        }else if(indexoflevel == 2){

            min = 101;
            max = 150;

        }

        
        // we want to randomize the array and don't want repeating questions so 
        Set<Integer> set = new HashSet<>();

      // generate random numbers between min and max until the set has at least 50 elements


int current = NumberOfQuestions;


      while (set.size() < current) {
         int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
         set.add(randomNum);
      }
     
     
   //   System.out.println("Random numbers with no duplicates = "+set);       

// convert the set to an array named arrofindex which will be usefull to pick index from

int n = set.size();
        int arrofindex[] = new int[n];
  
        int i = 0;
        for (int x : set)
            arrofindex[i++] = x;

// creating the display questions array named displayquestions

for(int r = 0; r < NumberOfQuestions ; r++){

    for(int c = 0; c < practical_numberofcolumns; c++){
        ExamPracticalQuestions[indexofsection][indexoflevel][r][c] = questionsarray[arrofindex[r]][c];
        System.out.print(ExamPracticalQuestions[indexofsection][indexoflevel][r][c] + "\t");
    }

    System.out.println();

}


        }  
        
    }

        return ExamPracticalQuestions;
        
    }

    public static boolean isInternetAvailable() {
        try {
            // Try to resolve the Google DNS server address
            InetAddress address = InetAddress.getByName("8.8.8.8");
            
            // Ping the address to check if there is a network connection
            return address.isReachable(3000); // 3 seconds timeout
        } catch (Exception e) {
            return false;
        }
    }

    public static void Openfile(String Filename){


        try {
            if (Desktop.isDesktopSupported()) {
              Desktop.getDesktop().open(new File(Filename));
            }
          } catch (IOException ioe) {
            ioe.printStackTrace();
         }


    }


    public static void SaveAndClose() throws Exception{

        
        Robot robot = new Robot();
        
        // Press and hold the Ctrl key
        robot.keyPress(KeyEvent.VK_CONTROL);
        
        // Press the S key
        robot.keyPress(KeyEvent.VK_S);
        
        // Release the S key
        robot.keyRelease(KeyEvent.VK_S);
        
        // Release the Ctrl key
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
    }

    public static boolean DoesFileExists(String Filename , String Location){

        boolean DoesFileExists = false;
        File file = new File(Location, Filename);
        DoesFileExists = file.exists();

        return DoesFileExists;
    }


    public static String GetDateAndTime(){

        String formattedDateTime = null;

        try {
        boolean isInternetAvailable = isInternetAvailable();
        if(isInternetAvailable == true){

                // Connect to a server that returns the current date and time
                URL url = new URL("https://www.google.com");
                URLConnection conn = url.openConnection();
                conn.connect();
                
                // Get the current time from the server response
                long timestamp = conn.getDate();
                Date date = new Date(timestamp);
                
                // Format the date and time using SimpleDateFormat
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                formattedDateTime = dateFormat.format(date);
                
                System.out.println("Current date and time from the internet: " + formattedDateTime);


                BufferedWriter writer = new BufferedWriter(new FileWriter("datetime.txt"));
                writer.write(formattedDateTime);
                writer.close();
            
        }
        else{

        LocalDateTime now = LocalDateTime.now();
        // Format the date and time using a formatter
        //Sun Mar 19 18:05:59 IST 2023
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedDateTime = now.format(formatter);
        
        System.out.println("Current system date and time: " + formattedDateTime);

        String Filename = "datetime.txt";
        String Filepath = "C:/Users/Siddhesh Dhomane/Documents/NetBeansProjects/QuizAPP/datetime.txt";
                
        boolean FileExists = DoesFileExists(Filename,Filepath);
        

        if(FileExists == true){

             // Read the date and time from the text file
             BufferedReader reader = new BufferedReader(new FileReader("datetime.txt"));
             String dateTimeString = reader.readLine();
             reader.close();

             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             Date dateinfile = dateFormat.parse(dateTimeString);

             Date fetchedDate = dateFormat.parse(formattedDateTime);

             if(dateinfile.before(fetchedDate)){

                BufferedWriter writer = new BufferedWriter(new FileWriter("datetime.txt"));
                writer.write(formattedDateTime);
                writer.close();
             }

        }
            //put a dialogue box to say that the date and time appears to be an issue so please connect to the internet
            
        else{
            System.out.println("the date and time appears to be an issue so please connect to the internet");
        }

        

        }

        }catch (Exception e) {
            e.printStackTrace();
        }


        return formattedDateTime;
    }




   

    public static void main(String[] args){

        String section = "InputAndOutputQuestions";
        //String array [][] = ControllerClass.Theoryquestions(section, 10); 

        String array [][][][] = ControllerClass.ExamTheoryQuestions(10);
        

        
        

    }
    

    
}
