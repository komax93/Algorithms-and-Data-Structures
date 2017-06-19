package section_4_1.homework;

import section_1_3.Stack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 11.04.2016.
 */
public class DepthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    public void dfs(Graph G, int s)
    {
        marked[s] = true;
        for(int w : G.adj(s))
            if(!marked[w])
            {
                edgeTo[w] = s;
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

        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_4_1\\tinyCG.txt";
        Graph G = new Graph(new Scanner(new File(path)));
        int s = 0;

        DepthFirstPaths search = new DepthFirstPaths(G, s);
        for(int v = 0; v < G.V(); v++)
        {
            System.out.print(s + " to " + v + " : ");
            if(search.hasPathTo(v))
                for(int w : search.pathTo(v))
                    if(w == s)
                        System.out.print(w);
                    else
                        System.out.print(" - " + w);
            System.out.println();
        }
    }
}
