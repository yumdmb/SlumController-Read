package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MonthJob {
    static int sumCreate = 0;
    static int sumEnd = 0;
    static ArrayList<Integer> numJobCreate = new ArrayList<>();
    static ArrayList<Integer> numJobEnd = new ArrayList<>();
    static int minCreate, maxCreate, minEnd, maxEnd;
    static int dayMinCreate, dayMaxCreate, dayMinEnd, dayMaxEnd;
    static int numCompleteJob, initiateJob;

    //totalMonthJobCreateEnd
    public static void totalMonthJobCreateEnd(String fileName){
        String data;
        String month = "";
        String day = "";
        double ave = 0.0;
        int m=0;
        int d=0;

        for (int monthtrack = 6; monthtrack <=12; monthtrack++) {
            String monstr = "";
            int numday = 0;
            switch(monthtrack){
                case 6 -> {
                    monstr = "Jun";
                    numday = 30;
                }
                case 7 -> {
                    monstr = "Jul";
                    numday = 31;
                }
                case 8 -> {
                    monstr = "Aug";
                    numday = 31;
                }
                case 9 -> {
                    monstr = "Sep";
                    numday = 30;
                }
                case 10 -> {
                    monstr = "Oct";
                    numday = 31;
                }
                case 11 -> {
                    monstr = "Nov";
                    numday = 30;
                }
                case 12 -> {
                    monstr = "Dec";
                    numday = 16;
                }
            }

            numJobEnd.add(0);
            numJobCreate.add(0);

            try {
                BufferedReader read = new BufferedReader(new FileReader(fileName));
                data = read.readLine();
                while (data != null) {

                    int num = data.split(" ").length;
                    String[] content = new String[num];
                    content = data.split(" ");

                    //ALLOCATE NUMBER OF JOBS CREATED AND ENDED BY DAYS AND MONTHS
                    month = data.substring(6, 8);
                    day = data.substring(9, 11);
                    d = Integer.parseInt(day);
                    LocalDateTime dateTime = Main.convertToLDT(content[0]);

                    if (dateTime.getMonthValue() == monthtrack) {
                        for (String content2 : content) {
                            if (content2.equals("done")) {
                                numJobCreate.add(d - 1, numJobCreate.get(d - 1) + 1);
                            }
                            if (content2.equals("Allocate")) {
                                numJobEnd.add(d - 1, numJobEnd.get(d - 1) + 1);
                            }
                        }
                    }
                    data = read.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            } catch (IOException e) {
                System.out.println("Error occurs while editing file");
            }

            System.out.println("\nMonth : " + monthtrack);
            System.out.printf("%-20s", "Day           |");
            for (int i = 0; i < numday; i++) {
                System.out.printf("%-5d", (i + 1));
            }
            System.out.printf("\n%-20s", "Created job |");
            for (int i = 0; i < numday; i++) {

                if (i > 0) {
                    sumEnd += numJobEnd.get(i)-numJobEnd.get(i-1)+1;
                    System.out.printf("%-5d", numJobEnd.get(i)-numJobEnd.get(i-1)+1);
                }
                else{
                    sumEnd += numJobEnd.get(i);
                    System.out.printf("%-5d", numJobEnd.get(i));
                }
            }
            System.out.printf("\n%-20s", "Ended job     |");
            for (int i = 0; i < numday; i++) {
                if (i > 0) {
                    sumCreate += numJobCreate.get(i)-numJobCreate.get(i-1)+1;
                    System.out.printf("%-5d", numJobCreate.get(i)-numJobCreate.get(i-1)+1);
                }
                else{
                    sumCreate += numJobCreate.get(i);
                    System.out.printf("%-5d", numJobCreate.get(i));
                }
            }

            minCreate = numJobCreate.get(0); dayMinCreate = 1;
            maxCreate = numJobCreate.get(0); dayMaxCreate = 1;
            minEnd = numJobCreate.get(0); dayMinEnd = 1;
            maxEnd = numJobCreate.get(0); dayMaxEnd = 1;

            System.out.println("\nTotal job created in " + monstr +   ": " + sumCreate);
            System.out.println("Total job ended in  " + monstr +   ": " + sumEnd);
            ave = sumCreate / (double) numday;
            System.out.printf("Average job created in %s: %.1f\n", monstr, ave);
            ave = sumEnd / (double) numday;
            System.out.printf("Average job ended in %s  : %.1f\n", monstr, ave);
            for (int i = 1; i < numday; i++) {
                if (numJobCreate.get(i)-numJobCreate.get(i-1) > maxCreate) {
                    maxCreate = numJobCreate.get(i)-numJobCreate.get(i-1)+1;
                    dayMaxCreate = i + 1;
                }
                if (numJobCreate.get(i)-numJobCreate.get(i-1) < minCreate) {
                    minCreate = numJobCreate.get(i)-numJobCreate.get(i-1)+1;
                    dayMinCreate = i + 1;
                }
                if (numJobEnd.get(i)-numJobEnd.get(i-1) > maxEnd) {
                    maxEnd = numJobEnd.get(i)-numJobEnd.get(i-1)+1;
                    dayMaxEnd = i + 1;
                }
                if (numJobEnd.get(i)-numJobEnd.get(i-1) < minCreate) {
                    minEnd = numJobEnd.get(i)-numJobEnd.get(i-1)+1;
                    dayMinEnd = i + 1;
                }
            }
            System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
            System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
            System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
            System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

        }
    }

    //totalCompletedAndEndedJob
    public static void totalCompletedAndEndedJob(String fileName){
        String data;

        numCompleteJob=0;
        initiateJob=0;

        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while(data!=null){

                //READ AND DISPLAY ALL THE CONTENTS OF THE FILE
                //System.out.println(data);

                //DIVIDE EACH LINE INTO ARRAY
                int num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                //SHOW THE TOTAL NUMBER OF ENDED AND COMPLETED JOBS
                for (String content1 : content) {
                    if (content1.equals("done"))
                        numCompleteJob++;
                    if(content1.equals("Allocate"))
                        initiateJob++;
                }
                data = read.readLine();
            }
        }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}

        //DISPLAY RESULT
        System.out.println("Number of job created : " + numCompleteJob);
        System.out.println("Number of job ended   : " + initiateJob);
    }
}
