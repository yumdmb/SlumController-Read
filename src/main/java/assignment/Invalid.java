package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Invalid {

    //ErrorAndInvalid
    public static void InvalidJob(String fileName){
        int numInvalid = 0;
        String data = null;

        int numQosSpec = 0;
        int numPartition = 0;
        int numJob = 0;
        int numNode = 0;
        int numUser = 0;
        int numGroup = 0;
        int numAccount = 0;

        //HashSet <String> invalid = new HashSet<String>();
        HashSet<String> user = new HashSet<String>();
        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while(data!=null){
                int num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                for(int i=0;i<content.length;i++){
                    if(content[i].equals("Invalid")){
                        //System.out.println(data);
                        if(content[i+2].equals("specification"))
                            numQosSpec++;
                        if(content[i+1].equals("partition"))
                            numPartition++;
                        if(content[i+1].equals("job"))
                            numJob++;
                        if(content[i+1].equals("node"))
                            numNode++;
                        if(content[i+1].equals("user"))
                            numUser++;
                        if(content[i+1].equals("group"))
                            numGroup++;
                        if(content[i+1].equals("account"))
                            numAccount++;
                    }
                }
                data=read.readLine();
            }
        }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}

        numInvalid = numQosSpec + numAccount + numGroup + numUser + numNode + numJob + numPartition;

        System.out.println("*-----------------------------------------------------------------------*");
        System.out.printf("| %-50s%-20s|\n","Types of Invalid","Number of Cases");
        System.out.println("*-----------------------------------------------------------------------*");
        System.out.printf("| %-50s%-20s|\n","Invalid Qos Specification",numQosSpec);
        System.out.printf("| %-50s%-20d|\n","Invalid Account",numAccount);
        System.out.printf("| %-50s%-20d|\n","Invalid MonthJob Id Specified",numJob);
        System.out.printf("| %-50s%-20d|\n","Invalid Partition Name Specified",numPartition);
        System.out.printf("| %-50s%-20d|\n","Invalid Node Name Specified",numNode);
        System.out.printf("| %-50s%-20d|\n","Invalid User Id",numUser);
        System.out.printf("| %-50s%-20d|\n","Invalid Group Id",numGroup);
        System.out.println("*-----------------------------------------------------------------------*");
        System.out.printf("| %-50s%-20d|\n","Total Invalid",numInvalid);
        System.out.println("*-----------------------------------------------------------------------*");
    }
}
