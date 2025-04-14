import java.util.*;
public class JobSequencing{

    /*
     * Problem statement : We have an array of jobs where every job has a deadline and associated profit if the job is
     *  finished before the deadline. It is also given that every job takes a single unit of time, so the
     *  minimum possible deadline for any job is 1. Maximize the total profit if only one job can be
     *  scheduled at a time means we can only do a single job on particular day.
     * 
     *  Sample Input 1 :
     * 
     *  JobID       Deadline(day)  Profit
     *     a           4             20
     *     b           1             10
     *     c           1             40
     *     d           1             30
     * 
     *  Sample Output 1 : c, a
     * 
     * Solution : we would pick job c on day 1 as by observing deadline and max. profit due to which we gain profit of 40 and then we have only 1 job left with still deadline of 3 days to we complete it to gain another profit of +40.
     * TOTAL MAX. PROFIT : 80
     * 
     * Greedy approach : 
     * 1. Sort the jobs in descending order of profit.
     * 2. Initialize an arraylist to keep track of the free time slots.
     * 3. Iterate through the jobs and check if the job can be scheduled in the free time slots.
     * 
     * Note : here we're learning to sort objects.
     */

    

     static class Job{
        int deadline;
        int profit;
        int id; // 0,1,2...

        public Job(int i , int d , int p){
            id = i;
            deadline = d;
            profit = p;
        }
     }
    public static void main(String[] args){
        int jobsInfo[][] ={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs = new ArrayList<>(); // array of jobs

        for(int i = 0 ; i < jobsInfo.length ; i++){
           jobs.add(new Job(i , jobsInfo[i][0], jobsInfo[i][1])); // create a new job object

        }
        // comparators sorting ke time pe comparison kaise ho rha hai uski definition decide krte hai.
        //syntax to sort "objects" in descending order of profit
        //for ascending order of profit use obj1.profit - obj2.profit
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit - obj1.profit); // sort the jobs in descending order of profit

        ArrayList<Integer> sequence = new ArrayList<>(); // to store the result

        int time = 0;

        for(int i = 0 ; i<jobs.size() ; i++){
            Job current = jobs.get(i); // get the current job
            if(current.deadline > time){ // check if the job can be scheduled in the free time slots
                sequence.add(current.id); // add the job id to the result
                time++; // increment the time slot
            }
        }

        //print sequence of jobs    

        System.out.print("Job sequence : ");
        for(int i = 0 ; i < sequence.size() ; i++){
            System.out.print(sequence.get(i) + " "); // output the job sequence
        }
    }
}