package quizapp;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class hey {

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

        String folderPath = "QuestionData/PracticalDuplicates"; // replace with actual folder path
        File folder = new File(folderPath);
        
        if (deleteFolder(folder)) {
            System.out.println("Folder deleted successfully!");
        } else {
            System.out.println("Failed to delete folder!");
        }
        
    }


    public static void CreateDuplicates(){

        ClearDuplicates();
        String sourceFolder = "QuestionData/PracticalOrignalFiles"; // replace with actual source folder path
        String destinationFolder = "QuestionData/PracticalDuplicates"; // replace with actual destination folder path

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

    public static void main(String args[]){

        String array [][][] = ControllerClass.PracticalQuestions(10);
        


    }

}
