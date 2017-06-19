package section_1_5.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 02.02.2016.
 */
public class QuickFind
{
    private int count;
    private int[] id;

    public QuickFind(int N)
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
        return id[p];
    }

    public void union(int p, int q)
    {
        int pId = find(p);
        int qId = find(q);

        if(connected(pId, qId)) return;

        for(int i = 0; i < id.length; i++)
            if(id[i] == pId)
                id[i] = qId;

        count--;
    }

    public void printArr()
    {
        for(int i = 0; i < id.length; i++)
            System.out.print(id[i] + " ");
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner fReader = new Scanner(new File(fileName));

        QuickFind QF = new QuickFind(fReader.nextInt());
        while (fReader.hasNext())
        {
            int p = fReader.nextInt();
            int q = fReader.nextInt();

            System.out.println(p + " " + q);
            if(p == q) continue;

            QF.union(p, q);
        }

        QF.printArr();
        System.out.println("Количество связных елементов: " + QF.count());
    }
}
