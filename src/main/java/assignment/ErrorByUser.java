package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ErrorByUser {

    //getErroryUser
    public static void getErrorByUser(String fileName){
        
        //Number of jobs causing error and the corresponding user
        
        try{
        
        String line;
        String search = "error: This association";         // used to extract the error data
        int counter=0;
        int UserIDStart =0;
        int UserIDEnd=0;
        String Error= "";
        
      
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
       
        
         System.out.printf("%-30s%-20s\n","User","Number of errors");
         System.out.println("----------------------------------------------------");
         
                
        while((line=reader.readLine())!=null){
           
            
            if(line.contains(search)){   //search for error data (Association) //contains "error: This association
                
                
   
                   
                    UserIDStart = line.indexOf("user=\'")+6;
                    UserIDEnd= line.indexOf(", partition=")-1;
                   
                    Error += line.substring(UserIDStart, UserIDEnd)+" ";
                    counter++;
                    
                    //substring() method extracts characters, between two indices (positions), from a string, and returns the substring.

                    //Print the errors
                    //System.out.println("");
                    //System.out.println(line);
                    //System.out.println("");
           
                                          
                    
            }       
           
            }
          
            String[]data= Error.split(" ");
            
            
            
           
            //get duplicate count using Map
            Map<String,Long> duplicateCount = Arrays.stream(data).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
           
            
            //print Map for duplicate count
            duplicateCount.forEach((key,value)->System.out.printf("%-30s%-20s\n",key,value));
        
            
          //all the errors
            //System.out.println("");
             //System.out.println(Error);
            
        System.out.println("");   
        System.out.println("The number of jobs causing error : "+ counter);
   
        
        reader.close();
        }catch(FileNotFoundException e){
            System.out.println("File was not found");
            
        }catch(IOException e){
            System.out.println("IO Error:"+e.getMessage());
        }
    
    
    
    
    
    
}}
