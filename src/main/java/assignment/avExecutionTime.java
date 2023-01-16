package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class avExecutionTime {

    static ArrayList createJobTime = new ArrayList();
    static ArrayList createJobId = new ArrayList();
    static ArrayList endJobTime = new ArrayList();
    static ArrayList endJobId = new ArrayList();
    static ArrayList<Double> exeTime = new ArrayList<>();

    //averageExecutionTIme
    public static void averageExecutionTime(String fileName){

        String data = "";

        double totalExecutionTime = 0.0;

        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();

            while(data!=null){

                int num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                // Create job
                for(int i=0;i<content.length;i++){
                    if(content[i].equals("Allocate")){
                        createJobTime.add(content[0]);
                        createJobId.add(content[i+1]);
                    }

                    // End job
                    if(content[i].equals("done")){
                        endJobTime.add(content[0]);
                        endJobId.add(content[i-1]);
                    }
                } // For loop

                data = read.readLine();
            } // WHILE(DATE)
        }   // TRY

        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}

        String [] createJobTime2 = new String[createJobTime.size()];
        String [] endJobTime2 = new String[endJobTime.size()];
        createJobTime.toArray(createJobTime2);
        endJobTime.toArray(endJobTime2);

        String maxJobId = null;
        String minJobId = null;

        double max = -1;
        double min = 9999;

        int No = 0;

//        System.out.printf("\n%-8s%-20s%-20s%-30s%-30s%-30s\n","No.","Completed job ID","Ended job ID","job Completed Time","job Ended Time","Execution Time (mins)");
//        System.out.print("--------------------------------------------------------------------------------------------------------------------------------------");

        for(int i=0;i<createJobId.size();i++){

            for(int j=0;j<endJobId.size();j++){
                if(createJobId.get(i).equals(endJobId.get(j))){
                    LocalDateTime createTime = Main.convertToLDT(createJobTime2[i]);
                    LocalDateTime endTime = Main.convertToLDT(endJobTime2[j]);

                    long milliBetween = ChronoUnit.MILLIS.between(createTime,endTime);

                    if(milliBetween < 0)
                        milliBetween *=-1;

                    double milli = (double)milliBetween;

                    exeTime.add(milli);

                    double output = (double)((milliBetween/1000.0)/60);
                    No++;
//                    System.out.printf("\n%-8d%-20s%-20s%-30s%-30s",No,createJobId.get(i),endJobId.get(j),createJobTime2[i],endJobTime2[j]);
//                    System.out.printf("%.3f",output);

                    if((milliBetween/1000)>max){
                        max = milliBetween/1000;maxJobId = (String) createJobId.get(i);}

                    if((milliBetween)<min){
                        min = milliBetween;minJobId = (String) createJobId.get(i);}

                    totalExecutionTime += (double)((milliBetween/1000.0));
                    break;
                }

            }
        }
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total number of completed job : " + No);

        System.out.println();

        System.out.printf("Total execution time : %.2f Days\n" , ((totalExecutionTime/3600)/24));
        System.out.printf("Total execution time : %.2f Hours\n" , totalExecutionTime/3600 );
        System.out.printf("Total execution time : %.2f Mins\n" , totalExecutionTime/60 );
        System.out.printf("Total execution time : %.2f Seconds\n" , totalExecutionTime );

        System.out.println();

        System.out.printf("Average execution time : %.2f Days\n" , (((totalExecutionTime/3600)/24)/No));
        System.out.printf("Average execution time : %.2f Hours\n" , (totalExecutionTime/3600)/No );
        System.out.printf("Average execution time : %.2f Mins\n" , (totalExecutionTime/60)/No );
        System.out.printf("Average execution time : %.2f Seconds\n" , (totalExecutionTime)/No );

        System.out.println();

        System.out.println("Highest Execution Time " + maxJobId);
        System.out.printf("Highest execution time : %.2f Days\n" , (((max/3600)/24)));
        System.out.printf("Highest execution time : %.2f Hours\n" , (max/3600) );
        System.out.printf("Highest execution time : %.2f Mins\n" , (max/60) );
        System.out.printf("Highest execution time : %.2f Seconds\n" , (max) );

        System.out.println();

        System.out.println("Lowest Execution Time " + minJobId);
        System.out.printf("Lowest execution time : %.2f milliseconds\n" , min );

        System.out.println();

        Collections.sort(exeTime);
        double median = 0;
        double firstQuartile = 0;
        double thirdQuartile = 0;

        firstQuartile = exeTime.size()*0.25;
        thirdQuartile = exeTime.size()*0.75;

        System.out.printf("First Quartile of execution time : %.1f mins\n" , (exeTime.get((int)firstQuartile) + exeTime.get((int)firstQuartile+1))/2/1000/60);

        if(exeTime.size()%2 == 0){
            median =(exeTime.get((int) Math.floor(exeTime.size()/2))+  exeTime.get(((int)Math.floor(exeTime.size()/2)+1)) )/2;
        }

        else if(exeTime.size()%2==1){
            median = exeTime.get((int) Math.ceil(exeTime.size()/2));
        }
        median = (median / 1000)/60;
        System.out.printf("Median of execution time         : %.1f mins\n", median);

        System.out.printf("Third Quartile of execution time : %.1f mins\n" , (exeTime.get((int)thirdQuartile) + exeTime.get((int)thirdQuartile+1))/2/1000/60);

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

    } // End method
}
