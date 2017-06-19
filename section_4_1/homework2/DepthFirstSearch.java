package section_4_1.homework2;

import section_4_1.Graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 20.04.2016.
 */
public class DepthFirstSearch
{
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s)
    {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        count++;
        for(int w : G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }

    public boolean marked(int v)
    {
        return marked[v];
    }

    public int count()
    {
        return count;
    }

    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_4_1\\tiny.txt";
        Graph G = new Graph(new Scanner(new File(path)));
        int s = 9;

        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++)
            if(search.marked(v))
                System.out.print(v + " " );
        System.out.println();
        if(G.V() != search.count())
            System.out.print("НЕ");
        System.out.println(" связный");
    }
}
