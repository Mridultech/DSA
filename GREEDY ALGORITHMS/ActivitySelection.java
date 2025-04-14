import java.util.*;
public class ActivitySelection { // O(nlogn)
    /*
     * important logic because many problems from it in placement 
     * 
     * problem statement : You are given a set of activities, each with a start time and an end time.
     * You need to select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
     * Activities are sorted according to their end time.
     * 
     * hindi mein : kuch kaam diye hai jinke start aur end time diye hai.hame ye janna hai ke ek admi kitne kaam kr skta hai maximum agar wo ek time pe sirf ek hi kaam karega.
     * 
     * ex : start = [10,12,20]
     *      end = [20,25,30]
     *     output : 2[A0,A2]
     * 
     * hint : non overlapping intervals ko dekhna hai : disjoint intervals
     * 
     * greedy approach :
     * 1. end time sorted hai 
     * hame wo activites chaiye jinka end time minimum ho.
     * usse wo activity jaldi khatam hogi aur dusri activity shuru hone ka time milega.
     * 2. pehli ko to kar lo, ab dusri ko tabhi kar sakte ho jab wo pehli se overlap na kare.
     * 3. dusri activity ka start time pehli activity ke end time se bada ya barabar hona chaiye.
     * 
     * in java comparator is an interface for sorting java objects.
     */

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //end time basis sorted
        //lekin manlo sorted nahi diya to kaise hoga ? : O(logn)

        int activities[][] = new int[start.length][3];
        for(int i = 0 ; i < start.length ; i++){
            activities[i][0] = i; //activity index // jab array sort hoke upar niche ho jayengi to badme index se pata kar lenge ki kaun si activity hai.
            activities[i][1] = start[i]; //start time
            activities[i][2] = end[i]; //end number
        }
        //lambda function -> shortform 
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2])); // ye khe rha hai o -> o[2] matlab second column ko sort kardo mtlab end time wale 

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity ko lena hai
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2]; //last activity ka end time

        for(int i = 1 ; i < end.length ; i++){
            if(activities[i][1] >= lastEnd){
                // select activity
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2]; //last activity ka end time update
            }
        }

        System.out.println("Maximum number of activities: " + maxAct);
        System.out.print("Selected activities: ");  
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("Activity" + ans.get(i) + " ");
        }
        
    }
}

