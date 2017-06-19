package section_4_1.homework2;

import section_1_3.Stack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 20.04.2016.
 */
public class DepthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
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
}
