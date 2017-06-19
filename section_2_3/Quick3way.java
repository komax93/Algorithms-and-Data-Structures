package section_2_3;

import java.util.Random;

/**
 * Created by Maxim on 22.02.2016.
 */
public class Quick3way
{
    public static void sort(Comparable[] a)
    {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

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
        sort(a, lo, lt - 1);
        sort(a, hi, gt + 1);
    }

    public static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    public static void shuffle(Comparable[] a)
    {
        int N = a.length;
        Random r = new Random();

        for(int i = 0; i < a.length; i++)
        {
            int randInt = r.nextInt(i + 1);
            exch(a, i, randInt);
        }
    }

    public static void exch(Comparable[] a, int i, int j)
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
}
