package section_1_5;

import java.io.*;
import java.util.*;

/**
 * Created by Maxim on 31.01.2016.
 */
public class UF
{
    private int count;
    private int[] elements;

    public UF(int N)
    {
        count = N;
        elements = new int[N];
        for(int i = 0; i < N; i++)
            elements[i] = i;
    }

    public int count()
    {
        return count;
    }

    private int find(int p)
    {
        return elements[p];
    }

    public boolean connected(int p, int q)
    {
        return (find(p) == find(q));
    }

    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID) return;

        for(int i = 0; i < elements.length; i++)
            if(elements[i] == pID)
                elements[i] = qID;
        count--;
    }

    public void printArr()
    {
        for(int i = 0; i < elements.length; i++)
            System.out.print(elements[i] + " ");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner fReader = new Scanner(new File(fileName));

        UF uf = new UF(fReader.nextInt());
        while (fReader.hasNext())
        {
            int p = fReader.nextInt();
            int q = fReader.nextInt();
            System.out.println(p + " " + q);
            if(uf.connected(p, q)) continue;

            uf.union(p, q);
        }

        uf.printArr();
        System.out.println(uf.count() + " елементов.");
    }
}
