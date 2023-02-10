package unionFind;

public class QuickFindUF {
    private int[] id;

    //Constructor
    public QuickFindUF(int N) {
        id = new int[N];
        //Set id of each object to itself.
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //Constant time?
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * 2N + 2
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        //change id[p] to id[q]; At most 2N + 2 array accesses.
        for(int i= 0;i < id.length; i++){
            //If the iterated element has the id associated with set P, the change the id to set Q
            if(id[i] == pid) id[i] = qid;
        }

    }

}
