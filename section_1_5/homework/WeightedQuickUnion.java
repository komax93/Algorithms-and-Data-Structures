package section_1_5.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 03.02.2016.
 */
public class WeightedQuickUnion
{
    private int count;
    private int[] id, sz;
    public static int countOfAccess = 0;

    public WeightedQuickUnion(int N)
    {
        count = N;

        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;

        sz = new int[N];
        for(int i = 0; i < N; i++)
            sz[i] = 1;
    }

    public int count()
    {
        return count;
    }

    public void printID()
    {
        for(int i = 0; i < id.length; i++)
            System.out.print(id[i] + " ");
        System.out.println();
        for(int i = 0; i < id.length; i++)
            System.out.print(sz[i] + " ");
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    public int find(int p)
    {

        while(p != id[p])
        {
            p = id[p];
            countOfAccess++;
        }


        return p;
    }

    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);


        if(connected(i, j)) return;

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
            if(p == q) continue;

            wqu.union(p, q);
        }

        //wqu.printID();
        System.out.println("Количество обращений к массиву: " + countOfAccess);
        System.out.println("Количество связных елементов: " + wqu.count());
    }
}
