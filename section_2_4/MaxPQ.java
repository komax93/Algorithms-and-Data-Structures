package section_2_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 28.02.2016.
 */

public class MaxPQ<Key extends Comparable<Key>>
{
    private int N;
    private Key[] pq;

    public MaxPQ(int cap)
    {
        pq = (Key[]) new Comparable[cap];
        N = 0;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j)
    {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k)
    {
        while(k > 1 && less(k / 2, k))
        {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k)
    {
        while(2 * k <= N)
        {
            int j = 2 * k;
            if(j < N && less(j, j + 1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void insert(Key k)
    {
        pq[++N] = k;
        swim(N);
    }

    public Key delMax()
    {
        Key value = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return value;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String link = reader.readLine();
        Scanner scanner = new Scanner(new File(link));

        MaxPQ<String> PQ = new MaxPQ<String>(50);


        while(scanner.hasNext())
        {
            String str = scanner.next();
            if(!str.equals("*"))
                PQ.insert(str);
            else if (!PQ.isEmpty())
                System.out.print(PQ.delMax() + " ");
        }
        System.out.println();
    }
}

