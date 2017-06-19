package section_1_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 01.02.2016.
 */
public class WeightedQuickUnion
{
    int count;
    int[] id, sz;

    public WeightedQuickUnion(int N)
    {
        count = N;
        id = new int[N];
        sz = new int[N];

        for(int i = 0; i < N; i++)
            id[i] = i;
        for(int j = 0; j < N; j++)
            sz[j] = 1;
    }

    public int count()
    {
        return count;
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    private int find(int p)
    {
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);

        if(i == j) return;

        if(sz[i] < sz[j])
        {
            id[i] = j;
            sz[j] += sz[i];
        }
        else
        {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;
    }

    public void printArr()
    {
        for(int i = 0; i < id.length; i++)
            System.out.print(id[i] + " ");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner fReader = new Scanner(new File(fileName));

        WeightedQuickUnion wqu = new WeightedQuickUnion(fReader.nextInt());
        while (fReader.hasNext())
        {
            int p = fReader.nextInt();
            int q = fReader.nextInt();

            //System.out.println(p + " " + q);
            if(wqu.connected(p, q)) continue;
            wqu.union(p, q);
        }
        wqu.printArr();
        System.out.println(wqu.count() + " связных элементов.");
    }
}
