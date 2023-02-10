package unionFind;

public class QuickUnion {
    /*
     * Each element contains the id of it's parent.
     * Each element also points to the root of the tree.
     *      |
     *     / \
     *    /\ /\
     *        /\
     * 
     * The defect is that the trees can get to tall, meaning the find operation will be expensive.
     * Max find attempts is equal to N
     * Linear time complexity.
     */
    private int[] id;

    //If a parent ID points to itself,  

    public void QuickUnionUF (int N) {
        id = new int[N];
        for(int i = 0; i < N; i++) id[i] = i;
    }

    /**
     * Any element that points to itself is a root.
     * Any element that doesn't point to it's own index number is not a root. 
     * @param i The root we search for.
     * @return
     */
    private int root (int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }

    public void union (int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

}
