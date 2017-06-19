package section_2_3.homework;

import java.util.Random;

/**
 * Created by Maxim on 23.02.2016.
 */
public class Quick3way
{
    /*public static void sort(Comparable[] a)
    {
        int N = a.length;
        shuffle(a);
        sort(a, 0, N - 1);
    }*/

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];

        while(i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if(cmp < 0)
                exch(a, lt++, i++);
            else if(cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
    }

    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    private static void shuffle(Comparable[] a)
    {
        int N = a.length;
        Random rand = new Random();

        for(int i = 0; i < N; i++)
        {
            int randInt = rand.nextInt(i + 1);
            exch(a, i, randInt);
        }
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    public static void main(String[] args)
    {
        Integer[] a2 = {40, 69, 40, 22, 96, 48, 40, 14, 13, 40};

        sort(a2, 0, a2.length - 1);
        show(a2);
    }
}
