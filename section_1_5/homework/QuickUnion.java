package section_1_5.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 03.02.2016.
 */



public class QuickUnion
{
    private int[] id;
    private int count;

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

    public void printID()
    {
        for(int i = 0; i < id.length; i++)
            System.out.print(id[i] + " ");
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

        if(connected(i, j)) return;

        id[i] = j;
        count--;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner fReader = new Scanner(new File(fileName));

        QuickUnion QU = new QuickUnion(fReader.nextInt());
        while (fReader.hasNext())
        {
            int p = fReader.nextInt();
            int q = fReader.nextInt();

            System.out.println(p + " " + q);
            if(p == q) continue;

            QU.union(p, q);
        }

        QU.printID();
        System.out.println("Количество связных елементов: " + QU.count());
    }
}
