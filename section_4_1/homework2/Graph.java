package section_4_1.homework2;

/**
 * Created by Maxim on 15.04.2016.
 */
import java.util.*;

public class Graph
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private Graph G;

    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
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

    public Graph(Graph G)
    {
        this.G = G;
        this.V = G.V();
        this.E = G.E();
        this.adj = G.adj;
    }

    private void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public boolean hasEdge(int v, int w)
    {
        Integer tempV = new Integer(v);
        if(tempV.equals(adj(w)))
            return true;

        return false;
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
}
