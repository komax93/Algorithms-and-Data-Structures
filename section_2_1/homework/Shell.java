package section_2_1.homework;

/**
 * Created by Maxim on 16.02.2016.
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
        /*Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int arraySize = scanner.nextInt();
        Integer[] array = new Integer[arraySize];

        for(int i = 0; i < arraySize; i++)
        {
            array[i] = scanner.nextInt();
        }*/


        Integer[] intArray = {38, 98, 87, 53, 95, 65, 86, 37, 41, 57};
        sort(intArray);
        assert isSorted(intArray);
        show(intArray);
    }
}
