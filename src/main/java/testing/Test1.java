package testing;

import assignment.*;

import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException,InterruptedException {
        String fileName = "./Files/extracted_log";
        //avExecution
        // ime.averageExecutionTime(fileName); //Average Execution Time
                    //Job by Partition
        //ErrorByUser.getErrorByUser(fileName);           //Number of Errors bu Users
        //MonthJob.totalMonthJobCreateEnd(fileName);
        //MonthJob.totalMonthJobCreateEnd(fileName);
        //Partition.jobByPartitions(fileName);
        //ErrorByUser.getErrorByUser(fileName);
        //PartitionUsage.getJobsByPartition(fileName); //by month(A)
        //PartitionUsage.getNodeUsagePerPartition(fileName);
        MonthJob.totalCompletedAndEndedJob(fileName);
    }

}
