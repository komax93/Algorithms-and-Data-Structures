package section_2_3.homework;

/**
 * Created by Maxim on 22.02.2016.
 */
import java.util.*;
public class Quick
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        shuffle(a);
        sort(a, 0, N - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
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
        Integer[] a = {40, 69, 40, 22, 96, 48, 40, 14, 13, 40};
        //sort(a);
        partition(a, 0, a.length - 1);
        show(a);
    }
}
