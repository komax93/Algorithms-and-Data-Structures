package section_2_1;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 15.02.2016.
 */
public class Shell
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;

        while(h < N / 3) h = 3 * h + 1;

        while(h >= 1)
        {
            for(int i = h; i < N; i++)
            {
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }

            h /= 3;
        }
    }

    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
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

    public static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int arrayLength = scanner.nextInt();
        Integer[] array = new Integer[arrayLength];

        for(int i = 0; i < array.length; i++)
        {
            array[i] = scanner.nextInt();
        }

        sort(array);
        show(array);
    }
}
