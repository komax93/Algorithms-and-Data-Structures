package section_4_1;

import section_3_4.LinearProbingHashST;

import java.util.Scanner;

/**
 * Created by Maxim on 15.04.2016.
 */
public class SymbolGraph
{
    private LinearProbingHashST<String, Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp)
    {
        st = new LinearProbingHashST<String, Integer>();
        Scanner in = new Scanner(stream);
        while(in.hasNextLine())
        {
            String[] a = in.nextLine().split(sp);
            for(int i = 0; i < a.length; i++)
                if(!st.contains(a[i]))
                    st.put(a[i], st.size());
        }

        keys = new String[st.size()];
        for(String name : st.keys())
            keys[st.get(name)] = name;
        G = new Graph(st.size());
        in = new Scanner(stream);
        while(in.hasNextLine())
        {
            String[] a = in.nextLine().split(sp);
            int v = st.get(a[0]);
            for(int i = 1; i < a.length; i++)
                G.addEdge(v, st.get(a[i]));
        }
    }

    public boolean contains(String s)
    {
        return st.contains(s);
    }

    public int index(String s)
    {
        return st.get(s);
    }

    public String name(int v)
    {
        return keys[v];
    }

    public Graph G()
    {
        return G;
    }

    public static void main(String[] args)
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_4_1\\movies.txt";
        String delim = "Bacon, Kevin";
        SymbolGraph sg = new SymbolGraph(filename, "/");
        Graph G = sg.G();
        Scanner stdIN = new Scanner(filename);
        while(stdIN.hasNextLine())
        {
            String source = stdIN.nextLine();
            for(int w : G.adj(sg.index(source)))
                System.out.println(" " + sg.name(w));
        }
    }
}
