
import java.util.PriorityQueue;

public class WeakestSoldier {

    //problem statement : We are given an max binary matrix of 1's(soldiers) and 0's (civillians). The soldiers are positioned in front of civilians. i.e is all 1's will appear to left of 0's in each row. 
    /*
     * A row i is weaker than row j if the number of soldiers in row i is less than the number of soldiers in row j.
     * If the number of soldiers in row i is equal to the number of soldiers in row j, then row i is weaker than row j if i < j.
     * 
     * We need to find the k weakest rows in the matrix.
     * 
     * example:
     * Input: [[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,1,1,1]], k = 2
     * Output: [0,2]
     * Explanation:
     * The 1st row has 1 soldier and the 2nd row has 4 soldiers. The 3rd row has 1 soldier and the 4th row has 4 soldiers.
     * The weakest rows are the 1st and 3rd rows, which have 1 soldier each.
     * The weakest rows are the 1st and 3rd rows, which have 1 soldier each.
     * The 1st row is weaker than the 3rd row because it has fewer soldiers.
     * The 2nd and 4th rows are not weaker than the 1st and 3rd rows because they have more soldiers.
     * 
     * 
     * approach : 
     * 1. Create a list of pairs where each pair contains the number of soldiers and the index of the row.
     * 2. Sort the list of pairs in ascending order of the number of soldiers and then by the index of the row.
     * 3. Create a priority queue of the indices of the k weakest rows.
     * 4. Iterate through the list of pairs and add the indices of the k weakest rows to the priority queue.
     * 5. Return the indices of the k weakest rows in ascending order.
     * 
     */

     static class Row implements Comparable<Row> {
        int soldiers;
        int index;

        public Row(int soldiers, int index){
            this.soldiers = soldiers;
            this.index = index;
     }

        @Override
        public int compareTo(Row other) {
            if (this.soldiers == other.soldiers) {
                return this.index - other.index;
            }
            return this.soldiers - other.soldiers;
        }
    }
    public static void main(String[] args){
        int army[][] = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 1, 1, 1}
        };
        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i = 0; i < army.length; i++){
            int soldiers = 0;
            for(int j = 0; j < army[i].length; j++){
                if(army[i][j] == 1){
                    soldiers++;
                }
            }
            pq.add(new Row(soldiers, i));
        }

        for(int i = 0 ; i < k; i++){
            Row row = pq.poll();
            System.out.print(row.index + " ");
        }
    }
}
