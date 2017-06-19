package section_4_1.homework;

/**
 * Created by Maxim on 11.04.2016.
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

    private void dfs(Graph G, int s)
    {
        marked[s] = true;
        count++;
        for(int w : G.adj(s))
            if(!marked[s])
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
}
