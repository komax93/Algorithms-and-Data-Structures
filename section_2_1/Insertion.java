package section_2_1;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 14.02.2016.
 */
public class Insertion
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 1; i < N; i++)
        {
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j - 1);

        }
    }

    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] arr, int i, int j)
    {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void show(Comparable[] arr)
    {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] arr)
    {
        for(int i = 1; i < arr.length; i++)
            if(less(arr[i], arr[i - 1]))
                return false;
        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int arraySize = scanner.nextInt();
        Integer[] array = new Integer[arraySize];

        for(int i = 0; i < arraySize; i++)
        {
            array[i] = scanner.nextInt();
        }
        sort(array);
        assert isSorted(array);
        show(array);
    }
}
