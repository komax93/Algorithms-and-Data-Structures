package section_2_1;

/**
 * Created by Maxim on 13.02.2016.
 */
import java.io.InputStreamReader;
import java.util.*;

public class Selection
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 0; i < N; i++)
        {
            int min = i;
            for(int j = i + 1; j < N; j++)
                if(less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
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

    public static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
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
