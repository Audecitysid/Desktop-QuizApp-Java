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


public class ControllerClass {


    

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


    public static boolean deleteFolder(File folder) {
        if (!folder.exists()) {
            return true; // nothing to delete
        }
        
        if (!folder.isDirectory()) {
            return false; // not a directory
        }
        
        // Delete all files and subdirectories in the folder
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        
        // Delete the empty folder
        return folder.delete();
    }


    public static void ClearDuplicates(){

        String folderPath = "QuestionData/PracticalDuplicates"; 
        File folder = new File(folderPath);
        
        if (deleteFolder(folder)) {
            System.out.println("Folder deleted successfully!");
        } else {
            System.out.println("Failed to delete folder!");
        }
        
    }


    public static void CreateDuplicates(){
        
        ClearDuplicates();
        String sourceFolder = "QuestionData/PracticalOrignalFiles"; 
        String destinationFolder = "QuestionData/PracticalDuplicates"; 

        try {
            Path sourcePath = Paths.get(sourceFolder);
            Path destinationPath = Paths.get(destinationFolder);

            // Copy the source folder to the destination folder
            Files.walk(sourcePath).forEach(source -> {
                try {
                    Path destination = destinationPath.resolve(sourcePath.relativize(source));
                    Files.copy(source, destination);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("Folder copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
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
    
    public static void CloseWindow(int x , int y){

        try {
            // Create a new Robot instance
            Robot robot = new Robot();

            // Set the mouse position to the desired coordinates
            
            robot.mouseMove(x, y);

            // Press and release the left mouse button
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
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

         
        // Press and hold the Ctrl key
        robot.keyPress(KeyEvent.VK_CONTROL);

        // Press the w key
        robot.keyPress(KeyEvent.VK_W);
        
        // Release the w key
        robot.keyRelease(KeyEvent.VK_W);
        
        // Release the Ctrl key
        robot.keyRelease(KeyEvent.VK_CONTROL);


/*
        try {
            Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
            Runtime.getRuntime().exec("taskkill /f /im EXCEL.EXE");
            Runtime.getRuntime().exec("taskkill /f /im POWERPNT.EXE");
            Runtime.getRuntime().exec("taskkill /f /im OUTLOOK.EXE");
            System.out.println("Microsoft Office applications have been closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }


         try {
            Runtime.getRuntime().exec("taskkill /f /im et.exe");
            Runtime.getRuntime().exec("taskkill /f /im wpscloudsvr.exe");
            Runtime.getRuntime().exec("taskkill /f /im wpscloudoffice.exe");
            System.out.println("WPS Office has been closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    */


        
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

    public static String GetCurrentDateAndTime(){

        String formattedDateTime = null;

        boolean isInternetAvailable = isInternetAvailable();
        if(isInternetAvailable == true){
            try {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{

        LocalDateTime now = LocalDateTime.now();
        // Format the date and time using a formatter
        //Sun Mar 19 18:05:59 IST 2023
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedDateTime = now.format(formatter);
        
        System.out.println("Current system date and time: " + formattedDateTime);
        }

        
        return formattedDateTime;
    }



/////////////////////////////////////////////////////////////////////////////////////////////

    public static String[][][][] ExamTheoryQuestions(int NumberOfQuestions){

        String [][][][] ExamTheoryQUestions = new String [6][3][numberofrows + 2][numberofcolumns + 1];
        numberofdisplayquestions = NumberOfQuestions;

        for(int indexofsection = 0; indexofsection < 6; indexofsection++){
        System.out.println("Section : " + indexofsection);

        switch (indexofsection) {
            case 0:
                path = "QuestionData/TheoryQuestions/InputAndOutputQuestions.csv";
            break;
            case 1:
                path = "QuestionData/TheoryQuestions/InternetQuestions.csv";
              break;
            case 2:
                path = "QuestionData/TheoryQuestions/MS-AccessQuestions.csv";
              break;
            case 3:
                path = "QuestionData/TheoryQuestions/SecondaryStorageQuestions.csv";
              break;
            case 4:
                path = "QuestionData/TheoryQuestions/SystemSoftwareQuestions.csv";
              break;
            case 5:
                path = "QuestionData/TheoryQuestions/SystemUnitQuestions.csv";
              break;

            default :
                path = "QuestionData/TheoryQuestions/InputAndOutputQuestions.csv";
            
          }
        System.out.println("File reading");

        
        String line = "";
        int rowcount = 0;
        int columncount = 0;
        String[][] questionsarray = null;
        
        try{

            BufferedReader objbuffer = new BufferedReader(new FileReader(path));
            
                System.out.println(line);
                questionsarray = new String[numberofrows + 2][numberofcolumns + 1];  // specifications of the array
                objbuffer.close();

                objbuffer = new BufferedReader(new FileReader(path)); 

                while((line = objbuffer.readLine()) != null && rowcount < numberofrows){

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
        for(int r = 0; r < numberofrows; r++){

            for(int c = 0; c < numberofcolumns;c++){

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


for(int r = 0; r < numberofdisplayquestions ; r++){

    for(int c = 0; c < numberofcolumns; c++){
        ExamTheoryQUestions[indexofsection][indexoflevel][r][c] = questionsarray[arrofindex[r]][c];
        System.out.print(ExamTheoryQUestions[indexofsection][indexoflevel][r][c] + "\t");
    }

    System.out.println();

}
        }  
        
    }

        return ExamTheoryQUestions;
        
    }


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

        CreateDuplicates();

        return ExamPracticalQuestions;
        
    }






    public static String[][][] Theoryquestions(int NumberOfQuestions)
    {
       numberofdisplayquestions = NumberOfQuestions;

       String [][][] TheoryQuestions = new String [6][numberofrows + 2][numberofcolumns + 1];
       numberofdisplayquestions = NumberOfQuestions;

       for(int indexofsection = 0; indexofsection < 6; indexofsection++){
       System.out.println("Section : " + indexofsection);

       switch (indexofsection) {
           case 0:
               path = "QuestionData/TheoryQuestions/InputAndOutputQuestions.csv";
           break;
           case 1:
               path = "QuestionData/TheoryQuestions/InternetQuestions.csv";
             break;
           case 2:
               path = "QuestionData/TheoryQuestions/MS-AccessQuestions.csv";
             break;
           case 3:
               path = "QuestionData/TheoryQuestions/SecondaryStorageQuestions.csv";
             break;
           case 4:
               path = "QuestionData/TheoryQuestions/SystemSoftwareQuestions.csv";
             break;
           case 5:
               path = "QuestionData/TheoryQuestions/SystemUnitQuestions.csv";
             break;

           default :
               path = "QuestionData/TheoryQuestions/InputAndOutputQuestions.csv";
           
         }
       System.out.println("File reading");

       
       String line = "";
       int rowcount = 0;
       int columncount = 0;
       String[][] questionsarray = null;
       
       try{

           BufferedReader objbuffer = new BufferedReader(new FileReader(path));
           
               System.out.println(line);
               questionsarray = new String[numberofrows + 2][numberofcolumns + 1];  // specifications of the array
               objbuffer.close();

               objbuffer = new BufferedReader(new FileReader(path)); 

               while((line = objbuffer.readLine()) != null && rowcount < numberofrows){

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
       for(int r = 0; r < numberofrows; r++){

           for(int c = 0; c < numberofcolumns;c++){

               System.out.print(questionsarray[r][c] + "\t");
           }
           System.out.println();
       }
       */


       
           int min = 1, max = 150;
       
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


for(int r = 0; r < numberofdisplayquestions ; r++){

   for(int c = 0; c < numberofcolumns; c++){
       TheoryQuestions[indexofsection][r][c] = questionsarray[arrofindex[r]][c];
       System.out.print(TheoryQuestions[indexofsection][r][c] + "\t");
   }

   System.out.println();

}
         
       
   }

       return TheoryQuestions;
       
       }



    public static boolean Evaluate(String QuestionType , int QuestionNumber , String [][] array){



        boolean iscorrect = false;
        if(QuestionType == "Theory"){

          
            
            if(array[QuestionNumber][6].equals( array[QuestionNumber][7])){

                iscorrect = true;
        
                }
            
        }
        else if(QuestionType == "Practical"){


        }

        return iscorrect;
    }



    public static String[][][] PracticalQuestions(int NumberOfQuestions){

        String [][][] PracticalQuestions = new String [6][practical_numberofrows + 2][practical_numberofcolumns + 1];
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


        

            int min = 1, max = 150;


        
        // we want to randomize the array and don't want repeating questions so 
        Set<Integer> set = new HashSet<>();

      // generate random numbers between min and max until the set has 

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
        PracticalQuestions[indexofsection][r][c] = questionsarray[arrofindex[r]][c];
        System.out.print(PracticalQuestions[indexofsection][r][c] + "\t");
    }

    System.out.println();

}

    }

        CreateDuplicates();

        return PracticalQuestions;
        
    }


    public static int UserValidity(String Entered_Username, String Entered_Password){


        boolean isInternetAvailable = isInternetAvailable();

        if(isInternetAvailable == true){

        }


        
        /*
            check if (internet connection is available)
            {
                fetch the date and time from internet
                 write it down to the last access time.

            }

            bool flag = true;
            while(flag == true){
            if(check if the text file exists){

               if(file.username == username && file.password == password)

                    //fetch system date and time
                    if( last access date and time <= system date and time ){

                        if(system date and time <= expiry date and time){
                            write last access date in text file 
                            #status code 10 flag = false;


                        }
                        else{
                            // try to fetch the date from database
                            if(interet is available){
                                fetch expiry date and time and update the expiry date and time in txt file
                                flag = true;
                            }
                            else{

                                #status code 6 flag = false;

                            }
                             
                        
                        }
                        
                    }
                    else{
                        #status code 5 flag = false
                    }

                }

                else{
                    # status code 4 set flag = false;
                    
                }
            }
            else{

                //make api calls to the database to fetch the username password and subscription period
                // create a text file in the directory with login info (username + password + subscription period) flag == true

                // throw an exception of connect to the internet if it fails to connect 
                # set status code = 3 flag = false
                
            }
              }
             
             */


        int Status_Code = 0;

        return Status_Code;
    }

    

    
    public static void main(String[] args){



    String ans = "SystemSoftwareQuestions";
    

        

    }
}