package section_2_3;

/**
 * Created by Maxim on 21.02.2016.
 */
import java.util.*;

public class Quick
{
    public static void sort(Comparable[] a)
    {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while(true)
        {
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;

            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void shuffle(Object[] a)
    {
        int N = a.length;
        Random rand = new Random();

        for(int i = 0; i < N; i++)
        {
            int randInt = rand.nextInt(i + 1);
            exch(a, i, randInt);
        }
    }

    private static void exch(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    public static void show(Object[] a)
    {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    public static void main(String[] args)
    {
        Integer[] a = {123, 84, 1, 48840, 2, 11, 582};
        sort(a);
        show(a);
    }
}
