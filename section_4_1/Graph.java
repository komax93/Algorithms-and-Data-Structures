package section_4_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * Created by Maxim on 07.04.2016.
 */
public class Graph
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

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

    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }


    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_4_1\\tinyCG.txt";
        Graph G = new Graph(new Scanner(new File(path)));
        int s = 0;

        DepthFirstPaths search = new DepthFirstPaths(G, s);
        for(int v = 0; v < G.V(); v++)
        {
            System.out.print(s + " to " + v + ": ");
            if(search.hasPathTo(v))
                for(int x : search.pathTo(v))
                    if(x == s)
                        System.out.print(x);
                    else
                        System.out.print("-" + x);
            System.out.println();
        }
    }

    /*public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_4_1\\tiny.txt";
        Graph G = new Graph(new Scanner(new File(path)));
        int s = 9;

        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for(int v = 0; v < G.V(); v++)
            if(search.marked(v))
                System.out.print(v + " ");
        System.out.println();
        if(G.V() != search.count())
            System.out.print("НЕ ");
        System.out.println("связанный");
    }*/
}
