package merged;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = "./Files/extracted_log";
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.println("\n+--------------------SLUM Controller---------------------+");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("| 1 | Total completed and ended jobs by months           |");
            System.out.println("| 2 | Total jobs by partition                            |");   //Total = 9966(but not printed)
            System.out.println("| 3 | Total errors by user                               |");
            System.out.println("| 4 | Total jobs by partition for each month             |"); //total june-dec : 9216
            System.out.println("| 5 | Total nodes usage per partition                    |");
            System.out.println("| 6 | Execution Time                                     |");
            System.out.println("| 7 | Total Invalid Jobs                                 |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("-1 : Quit");
            System.out.print("Select -> ");
            int select = keyboard.nextInt();
            System.out.println();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            switch (select) {
                case 1 -> JobCreatedEnded(fileName);
                case 2 -> jobByPartitions(fileName);
                case 3 -> getErrorByUser(fileName);
                case 4 -> getJobsByPartition(fileName); //by month(A)
                case 5 -> getNodeUsagePerPartition(fileName);
                case 6 -> averageExecutionTime(fileName);
                case 7 -> InvalidJob(fileName);
                case -1 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid selection");
            }
        } while (true);

    }

    public static LocalDateTime convertToLDT(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'['yyyy-MM-dd'T'HH:mm:ss.SSS']'");
        return LocalDateTime.parse(date, formatter);
    }

    public static void JobCreatedEnded (String fileName) {
        try{
            int cnt=0;

            FileInputStream fin =new FileInputStream(fileName);
            Scanner in = new Scanner(fin);
            int creat =0,june=0,july=0,ogos=0,sept=0,oct=0,nov=0,dec=0;
            int juneD=0,julyD=0,ogosD=0,septD=0,octD=0,novD=0,decD=0;

            System.out.println();

            while(in.hasNext()){
                String line =in.nextLine();
                String [] time =line.split("-");
                String[]lineArray =line.split(" ");
                String done =lineArray[lineArray.length-1];
                String date = time[1];
                String []newLine = line.split("\n");


                for(int i = 0;i<newLine.length;i++){
                    if(newLine[i].contains("sched: Allocate")){
                        creat++;
                    }
                    if(newLine[i].contains("sched/backfill")){
                        creat++;
                    }
                }
                if("done".equals(done)){
                    cnt++;
                }
                if(date.equals("06")){
                    for(int i = 0;i<newLine.length;i++){
                        if(newLine[i].contains("sched: Allocate")){
                            june++;
                        }
                        if(newLine[i].contains("sched/backfill")){
                            june++;
                        }
                        if("done".equals(done)){
                            juneD++;
                        }
                    }
                }
                if(date.equals("07")){
                    for(int i = 0;i<newLine.length;i++){
                        if(newLine[i].contains("sched: Allocate")){
                            july++;
                        }
                        if(newLine[i].contains("sched/backfill")){
                            july++;
                        }
                        if("done".equals(done)){
                            julyD++;
                        }
                    }
                }
                if(date.equals("08")){
                    for(int i = 0;i<newLine.length;i++){
                        if(newLine[i].contains("sched: Allocate")){
                            ogos++;
                        }
                        if(newLine[i].contains("sched/backfill")){
                            ogos++;
                        }
                        if("done".equals(done)){
                            ogosD++;
                        }
                    }
                }
                if(date.equals("09")){
                    for(int i = 0;i<newLine.length;i++){
                        if(newLine[i].contains("sched: Allocate")){
                            sept++;
                        }
                        if(newLine[i].contains("sched/backfill")){
                            sept++;
                        }
                        if("done".equals(done)){
                            septD++;
                        }
                    }
                }
                if(date.equals("10")){
                    for(int i = 0;i<newLine.length;i++){
                        if(newLine[i].contains("sched: Allocate")){
                            oct++;
                        }
                        if(newLine[i].contains("sched/backfill")){
                            oct++;
                        }
                        if("done".equals(done)){
                            octD++;
                        }
                    }
                }
                if(date.equals("11")){
                    for(int i = 0;i<newLine.length;i++){
                        if(newLine[i].contains("sched: Allocate")){
                            nov++;
                        }
                        if(newLine[i].contains("sched/backfill")){
                            nov++;
                        }
                        if("done".equals(done)){
                            novD++;
                        }
                    }
                }
                if(date.equals("12")){
                    for(int i = 0;i<newLine.length;i++){
                        if(newLine[i].contains("sched: Allocate")){
                            dec++;
                        }
                        if(newLine[i].contains("sched/backfill")){
                            dec++;
                        }
                        if("done".equals(done)){
                            decD++;
                        }
                    }
                }

            }
            System.out.println("Total number of job created = "+creat);
            System.out.println("Total number of job done = "+cnt+"\n");
            System.out.println("job created in june = "+june);
            System.out.println("job created in july = "+july);
            System.out.println("job  created in august = "+ogos);
            System.out.println("job created in september = "+sept);
            System.out.println("job created in october = "+oct);
            System.out.println("job created in november = "+nov);
            System.out.println("job created in december = "+dec+"\n");
            System.out.println("job done in june = "+juneD);
            System.out.println("job done in july = "+julyD);
            System.out.println("job done in august = "+ogosD);
            System.out.println("job done in september = "+septD);
            System.out.println("job done in october = "+octD);
            System.out.println("job done in november = "+novD);
            System.out.println("job done in december = "+decD);

        } catch (FileNotFoundException ex) {
            System.out.println("file not found");;
        }
    }

    public static void jobByPartitions(String fileName){
        int num;
        String data;
        String sub=null;
        int numEPYC=0;
        int numOpteron=0;
        int numV100=0;
        int numK40c=0;
        int numK10=0;
        int numTitan=0;

        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while(data!=null){

                num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                if(content[1].equals("sched/backfill:")){
                    if(content[6].equals("cpu-epyc"))
                        numEPYC++;
                    if(content[6].equals("cpu-opteron"))
                        numOpteron++;
                    if(content[6].equals("gpu-v100s"))
                        numV100++;
                    if(content[6].equals("gpu-k40c"))
                        numK40c++;
                    if(content[6].equals("gpu-titan"))
                        numTitan++;
                    if(content[6].equals("gpu-k10"))
                        numK10++;
                }

                for (String content1 : content) {           //content1 as iterator
                    if (content1.equals("Partition=cpu-epyc")) {
                        numEPYC++;
                    }
                    if (content1.equals("Partition=cpu-opteron")) {
                        numOpteron++;
                    }
                    if (content1.equals("Partition=gpu-v100s")) {
                        numV100++;
                    }
                    if (content1.equals("Partition=gpu-k40c")) {
                        numK40c++;
                    }
                    if (content1.equals("Partition=gpu-titan")) {
                        numTitan++;
                    }
                    if (content1.equals("Partition=gpu-k10")) {
                        numK10++;
                    }
                }

                data = read.readLine();
            }
        }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}

        System.out.printf("\n\n%-15s%-15s%-15s%-15s%-15s%-20s%-15s","","GPU-V100s","GPU-K10","GPU-Titan","GPU-K40c","CPU-Opteron","CPU-EPYC");
        System.out.println("\n--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15d%-15d%-15d%-15d%-20d%-15d\n","TOTAL",numV100,numK10,numTitan,numK40c,numOpteron,numEPYC);

        System.out.println();
        int[] arr = {numV100,numK10,numTitan,numK40c,numOpteron,numEPYC};
        String[] arrname = {"GPU-V100s","GPU-K10","GPU-Titan","GPU-K40c","CPU-Opteron","CPU-EPYC"};
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    String temp2 = arrname[j];
                    arrname[j] = arrname[j+1];
                    arrname[j+1] = temp2;

                }
            }
        }
        System.out.println("The highest number of partition : " + arrname[0] + " = " + arr[0]);
        System.out.println("The lowest number of partition : " + arrname[5] + " = " + arr[5]);

    }

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






    }

    public static void averageExecutionTime(String fileName){

        ArrayList<String> createJobTime = new ArrayList<>();
        ArrayList<String> createJobId = new ArrayList<>();
        ArrayList<String> endJobTime = new ArrayList<>();
        ArrayList<String> endJobId = new ArrayList<>();
        ArrayList<Double> exeTime = new ArrayList<>();


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
        catch(IOException e){System.out.println("Error occurs");}

        String [] createJobTime2 = new String[createJobTime.size()];
        String [] endJobTime2 = new String[endJobTime.size()];
        createJobTime.toArray(createJobTime2);
        endJobTime.toArray(endJobTime2);

        String maxJobId = null;
        String minJobId = null;

        double max = -1;
        double min = 9999;

        int No = 0;

        for(int i=0;i<createJobId.size();i++){

            for(int j=0;j<endJobId.size();j++){
                if(createJobId.get(i).equals(endJobId.get(j))){
                    LocalDateTime createTime = Main1.convertToLDT(createJobTime2[i]);
                    LocalDateTime endTime = Main1.convertToLDT(endJobTime2[j]);

                    long milliBetween = ChronoUnit.MILLIS.between(createTime,endTime);

                    if(milliBetween < 0)
                        milliBetween *=-1;

                    double milli = (double)milliBetween;

                    exeTime.add(milli);

                    double output = (double)((milliBetween/1000.0)/60);
                    No++;

                    if((milliBetween/1000)>max){
                        max = milliBetween/1000;maxJobId = createJobId.get(i);}

                    if((milliBetween)<min){
                        min = milliBetween;minJobId = createJobId.get(i);}

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
        //Segment A
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

    }

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

    public static void getJobsByPartition(String fileName)
    {
        try{
            Scanner newScanner = new Scanner(new FileInputStream(fileName));


            String [] split,seperate,word;
            String get;
            int []numP = new int[6];
            int b=6,digit,total=0;              //month
            String month="";
            String[]partition = {"gpu-v100s","cpu-opteron", "gpu-k10","gpu-titan","cpu-epyc","gpu-k40c"};

            while(newScanner.hasNextLine())
            {
                get = newScanner.nextLine();    //read line
                split = get.split(" ");
                seperate = split[0].split("-");     //get the month in String
                digit=Integer.parseInt(seperate[1]);  //convert month to integer

                if(split.length==7 && split[2].equals("Allocate"))
                {  total++;
                    if(digit==b)
                    {
                        word = split[6].split("=");  //partition

                        switch (word[1]) {
                            case "gpu-v100s" -> numP[0] += 1;
                            case "cpu-opteron" -> numP[1] += 1;
                            case "gpu-k10" -> numP[2] += 1;
                            case "gpu-titan" -> numP[3] += 1;
                            case "cpu-epyc" -> numP[4] += 1;
                            case "gpu-k40c" -> numP[5] += 1;
                        }
                    }
                    if(b==12)
                        month = "December";
                    if(digit!=b)
                    {
                        month = switch (b) {
                            case 6 -> "June";
                            case 7 -> "July";
                            case 8 -> "August";
                            case 9 -> "September";
                            case 10 -> "October";
                            case 11 -> "November";
                            default -> month;
                        };

                        display(month);
                        for(int i=0; i<partition.length;i++)
                        {
                            System.out.printf("|%-20s%12s%13s%n",partition[i] ,numP[i],"|" );
                        }
                        print();
                        System.out.println("\n");


                        b++;
                        split = get.split(" ");
                        seperate = split[0].split("-");
                        digit=Integer.parseInt(seperate[1]);

                        for(int i=0; i<numP.length;i++)
                            numP[i]=0;

                        if(digit==b)
                        {
                            word = split[6].split("=");

                            if(word[1].equals("gpu-v100s"))
                                numP[0] += 1;
                            else if(word[1].equals("cpu-opteron"))
                                numP[1]  += 1;
                            else if(word[1].equals("gpu-k10"))
                                numP[2] += 1;
                            else if(word[1].equals("gpu-titan"))
                                numP[3]  += 1;
                            else if(word[1].equals("cpu-epyc"))
                                numP[4]  += 1;
                            else if(word[1].equals("gpu-k40c"))
                                numP[5]  += 1;
                        }

                    }
                }
            }
            display(month);
            for(int i=0; i<partition.length;i++)
            {
                System.out.printf("|%-20s%12s%13s%n",partition[i] ,numP[i],"|" );
            }
            print();
            System.out.println();
            total(total);
            newScanner.close();
        }
        catch(IOException i)
        {   System.out.println("Problem with input file");}
    }

    public static void getNodeUsagePerPartition(String fileName)
    {
        try{
            BufferedReader get = new BufferedReader(new FileReader(fileName));

            String line;                          //read text in line
            String[]seperate,node,partitions;     //seperate is used to split the line     //node is used to split the nodelist    //partitions is used to split the partition
            String[]partition = {"cpu-epyc","cpu-opteron","gpu-v100s", "gpu-k10","gpu-titan","gpu-k40c"};
            String[]nodeCPU = {"cpu01","cpu03","cpu04","cpu05","cpu07","cpu08","cpu09","cpu10","cpu11","cpu12","cpu13","cpu14","cpu15"};
            String[]nodeGPU = {"gpu01","gpu02","gpu03","gpu04","gpu05"};
            int [] calcCPU1,calcCPU2;
            int [] calcGPU1,calcGPU2,calcGPU3,calcGPU4;

            calcCPU1 = new int[nodeCPU.length];
            calcCPU2 = new int[nodeCPU.length];

            calcGPU1 = new int[nodeGPU.length];
            calcGPU2 = new int[nodeGPU.length];
            calcGPU3 = new int[nodeGPU.length];
            calcGPU4 = new int[nodeGPU.length];

            int i=0;
            line = get.readLine();

            while(line!=null)
            {
                seperate = line.split(" ");
                if(seperate.length==7 && seperate[2].equals("Allocate"))        //find the line that contain "Allocate"
                {
                    partitions = seperate[6].split("=");
                    node = seperate[4].split("=");

                    if(partitions[1].equals(partition[i]))                      //check for partition cpu-epyc
                    {    for(int c=0; c<nodeCPU.length;c++)
                    {
                        if(node[1].equals(nodeCPU[c]))
                            calcCPU1[c]++;

                    }
                    }
                    i++;
                    if(partitions[1].equals(partition[i]))                      //check for partition cpu-opteron
                    {    for(int c=0; c<nodeCPU.length;c++)
                    {
                        if(node[1].equals(nodeCPU[c]))
                            calcCPU2[c]++;

                    }
                    }
                    i++;
                    if(partitions[1].equals(partition[i]))                      //check for partition gpu-v100s
                    {    for(int c=0; c<nodeGPU.length;c++)
                    {
                        if(node[1].equals(nodeGPU[c]))
                            calcGPU1[c]++;

                    }
                    }
                    i++;
                    if(partitions[1].equals(partition[i]))                      //check for partition gpu-k10
                    {    for(int c=0; c<nodeGPU.length;c++)
                    {
                        if(node[1].equals(nodeGPU[c]))
                            calcGPU2[c]++;

                    }
                    }
                    i++;
                    if(partitions[1].equals(partition[i]))                      //check for partition gpu-titan
                    {    for(int c=0; c<nodeGPU.length;c++)
                    {
                        if(node[1].equals(nodeGPU[c]))
                            calcGPU3[c]++;

                    }
                    }
                    i++;
                    if(partitions[1].equals(partition[i]))                      //check for partition gpu-k40c
                    {    for(int c=0; c<nodeGPU.length;c++)
                    {
                        if(node[1].equals(nodeGPU[c]))
                            calcGPU4[c]++;

                    }
                    }
                    i=0;       //set the i to zero to repeat the same process
                }

                line = get.readLine();
            }
            System.out.printf("%46s%n","NUMBER OF NODES USAGE PER PARTITION");
            System.out.println("+---------------------------------------------------------+");
            System.out.printf("|%13s%5s%12s%8s%10s%10s%n","Partition","|","Node","|","Total","|");
            System.out.println("+---------------------------------------------------------+");
            display(partition[0],nodeCPU,calcCPU1);     //call display method
            display(partition[1],nodeCPU,calcCPU2);
            display(partition[2],nodeGPU,calcGPU1);
            display(partition[3],nodeGPU,calcGPU2);
            display(partition[4],nodeGPU,calcGPU3);
            display(partition[5],nodeGPU,calcGPU4);
            get.close();

        }catch(IOException i)
        {System.out.println("Problem with input file");}
    }

    //For getJobsByPartition and getNodeUsagePerPartition
    public static void print()
    {
        System.out.println("+--------------------------------------------+");
    }

    public static void display(String month)
    {
        System.out.println("Number of Jobs by Partition in " + month + " 2022");
        print();
        System.out.printf("|%-25s%-19s|%n", "Partition", "Total Jobs");
        print();

    }
    public static void total(int total)
    {
        System.out.println("\nTotal number of Job Created from June to December is " + total + "\n\n");
    }
    public static void display(String a, String[]b, int[]c)         //create a method that used to print the result
    {
        for(int i=0; i<b.length; i++)
        {
            if(c[i]==0)
                continue;
            System.out.printf("|%13s%5s%12s%8s%10s%10s%n",a,"|",b[i] ,"|",c[i],"|");
        }
        System.out.println("+---------------------------------------------------------+");
    }


}


