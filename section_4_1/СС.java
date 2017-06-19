package section_4_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 14.04.2016.
 */
public class СС
{
    private boolean[] marked;
    private int[] id;
    private int count;

    public СС(Graph G)
    {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int s = 0; s < G.V(); s++)
            if(!marked[s])
            {
                bfs(G, s);
                count++;
            }
    }

    private void bfs(Graph G, int v)
    {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v))
            if(!marked[w])
                bfs(G, w);
    }

    public boolean connected(int v, int w)
    {
        return id[v] == id[w];
    }

    public int id(int v)
    {
        return id[v];
    }

    public int count()
    {
        return count;
    }

    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_4_1\\tinyG.txt";
        Graph G = new Graph(new Scanner(new File(path)));
        СС cc = new СС(G);
        int M = cc.count();
        System.out.println(M + " компонентов");
        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];
        for(int i = 0; i < M; i++)
            components[i] = new Bag<Integer>();
        for(int v = 0; v < G.V(); v++)
            components[cc.id(v)].add(v);
        for(int i = 0; i < M; i++)
        {
            for(int v : components[i])
                System.out.print(v + " ");
            System.out.println();
        }

    }
}
