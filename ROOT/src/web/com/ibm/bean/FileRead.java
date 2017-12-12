package web.com.ibm.bean;

import java.io.*;

public class FileRead {
    public static void main(String [] args) {

        // The name of the file to open.
       

        // This will reference one line at a time
        String line = null;

        try {
        	File file = new File("D:");
        	for(String fileNames : file.list()) System.out.println(fileNames);
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
            		new FileReader("D:\\BC_2018728_101.txt");
            System.out.println("Hello");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(Exception e) {
        e.printStackTrace();    
        }
        
    }
}