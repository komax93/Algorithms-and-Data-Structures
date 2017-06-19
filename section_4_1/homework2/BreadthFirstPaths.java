package section_4_1.homework2;

import section_1_3.Queue;
import section_1_3.Stack;

/**
 * Created by Maxim on 20.04.2016.
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
        marked[s] = true;
        q.enqueue(s);
        while(!q.isEmpty())
        {
            int v = q.dequeue();
            for(int w : G.adj(v))
            {
                if(!marked[w])
                {
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.enqueue(w);
                }
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
        for(int x = v; x != s; x = edgeTo[v])
            search.push(x);
        search.push(s);
        return search;
    }
}
