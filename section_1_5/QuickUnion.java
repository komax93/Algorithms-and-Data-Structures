package section_1_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 01.02.2016.
 */
public class QuickUnion
{
    private int count;
    private int[] id;

    public QuickUnion(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
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
        int pID = find(p);
        int qID = find(q);

        if(pID == qID) return;

        id[pID] = qID;

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

        QuickUnion quickUnion = new QuickUnion(fReader.nextInt());
        while(fReader.hasNext())
        {
            int p = fReader.nextInt();
            int q = fReader.nextInt();
            System.out.println(p + " " + q);
            if(quickUnion.connected(p, q)) continue;

            quickUnion.union(p, q);
        }

        quickUnion.printArr();
        System.out.println(quickUnion.count() + " связующих элементов");
    }
}
