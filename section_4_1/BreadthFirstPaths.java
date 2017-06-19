package section_4_1;

import section_1_3.Queue;
import section_1_3.Stack;

/**
 * Created by Maxim on 11.04.2016.
 */
public class BreadthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s)
    {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(s);
        marked[s] = true;
        while(!q.isEmpty())
        {
            int v = q.dequeue();
            for(int w : G.adj(v))
                if(!marked[v])
                {
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.enqueue(w);
                }
        }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v)
    {
        if(!hasPathTo(v))
            return null;
        Stack<Integer> search = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            search.push(x);
        search.push(s);
        return search;
    }

    /*
    0 to 0: 0
    0 to 1: 0-1
    0 to 2: 0-2
    0 to 3: 0-2-3
    0 to 4: 0-2-4
    0 to 5: 0-5
     */
}
