package section_4_1.homework;

/**
 * Created by Maxim on 11.04.2016.
 */
import java.util.*;

public class Graph
{
    private final int V;
    private int e;
    private Bag<Integer>[] adj;

    public Graph(int V)
    {
        this.V = V;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Graph(Scanner in)
    {
        this(in.nextInt());
        int E = in.nextInt();
        for(int i = 0; i < E; i++)
        {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        return e;
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
}
