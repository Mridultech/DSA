public class DisjointSetUnionDS { // Time complexity : O(4K) => O(K) where K is the number of elements in the set.

    /*
     * This class implements the Disjoint Set Union (DSU) data structure, also known as Union-Find.
     * It is used to keep track of a set of elements partitioned into disjoint (non-overlapping) subsets.
     * It supports two main operations: find and union.
     * 
     * 1. find(x): This operation finds the representative (or root) of the set that contains x.
     *    It uses path compression to make future queries faster by making nodes point directly to the root.
     * 
     * 2. union(x, y): This operation merges the sets that contain x and y.
     *    It uses union by rank to keep the tree flat by attaching the smaller tree under the root of the larger tree.
     * 
     *  isme agar rank a < rank b to a ko b ke neeche rakhna hai
     *  agar rank a > rank b to b ko a ke neeche rakhna hai

     * Application : 
     * disjoint set ke question krne ke liye .
     * kruskal algorithm mein MST nikalne ke liye
     * graphs mein cycle detect karne ke liye.
     * etc.
     */

    static int n = 7;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a , int b){
        int parentA = find(a);
        int parentB = find(b);

        if(rank[parentA] == rank[parentB]){
            parent[parentB] = parentA;
            rank[parentA]++;
    }
    else if (rank[parentA] < rank[parentB]){
        parent[parentA] = parentB;
    }
    else {
        parent[parentB] = parentA;
    }
}

//path compression : isme ham nodes ko directly update krde rahe hai jisse ki wo direct root ke neeche aa jaye
//isliye ham parent[x] = find(parent[x]) karte hai.
//isliye ham parent ko update karte hai.
// ise tree ki height kam ho jaati hai aur query time bhi kam ho jaata hai or path bhi compress ho jaa rha hai.
    public static void main(String[] args){
        init();
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
    }
}