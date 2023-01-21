package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Job {
    public static void JobCreatedEnded (String fileName) {
        try{
            int cnt=0;

            FileInputStream fin =new FileInputStream("./Files/extracted_log");
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
}
